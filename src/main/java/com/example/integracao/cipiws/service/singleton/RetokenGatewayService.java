package com.example.integracao.cipiws.service.singleton;


import com.example.integracao.cipiws.service.integracao.cipiws.CipiwsTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@Scope("singleton")
public class RetokenGatewayService {

    private final CipiwsTokenService cipiwsTokenService;
    private final RestTemplate restTemplate;
    private final HttpHeaders headers;
    private String token;

    @Autowired
    public RetokenGatewayService(CipiwsTokenService cipiwsTokenService) {
        this.cipiwsTokenService = cipiwsTokenService;
        headers = new HttpHeaders();
        this.restTemplate = new RestTemplate();
        this.token = this.cipiwsTokenService.getToken().getToken();
    }

    public <T> ResponseEntity<T> dispararComTokenCipiws(String baseUrl, HttpMethod method, HttpEntity<Object> entity, ParameterizedTypeReference<?> tipoRetorno) {
        try {
        	tratarToken();
            return (ResponseEntity<T>) restTemplate.exchange(baseUrl, method, entity,tipoRetorno);
        } catch (HttpClientErrorException ex){
        	getRenovarToken();
            headers.setBearerAuth(this.token);
            HttpEntity<Object> novaEntity = new HttpEntity<>(entity.getBody(), headers);
            return (ResponseEntity<T>) restTemplate.exchange(baseUrl, method, novaEntity, tipoRetorno);
        }
    }
    
    private void tratarToken() {
    	if(this.token==null) {
    		getRenovarToken();
    	}
    }

    public String getToken() {
        return this.token;
    }

    private void getRenovarToken() {
    	this.token = this.cipiwsTokenService.getToken().getToken();
    }
}
