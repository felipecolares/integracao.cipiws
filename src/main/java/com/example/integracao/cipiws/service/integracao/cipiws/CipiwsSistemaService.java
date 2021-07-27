package com.example.integracao.cipiws.service.integracao.cipiws;

import com.example.integracao.cipiws.service.core.CredenciaisService;
import com.example.integracao.cipiws.service.core.CredencialSistemaId;
import com.example.integracao.cipiws.service.core.SistemaDTO;
import com.example.integracao.cipiws.service.core.Usuario;
import com.example.integracao.cipiws.service.singleton.RetokenGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CipiwsSistemaService {

    private final Environment env;
    private final String baseUrl;
    private final HttpHeaders headers;
    private final RetokenGatewayService gatewaySingleton;
    private final CredenciaisService credenciaisService;

    @Autowired
    public CipiwsSistemaService(Environment env, RetokenGatewayService gatewaySingleton, CredenciaisService credenciaisService) {
        this.env = env;
        this.baseUrl = env.getProperty("cipiws.urlBase");
        this.headers = new HttpHeaders();
        this.gatewaySingleton = gatewaySingleton;
        this.credenciaisService = credenciaisService;
    }

    public SistemaDTO obterPorId(Integer id) {
        CredencialSistemaId credId = new CredencialSistemaId();
        credId.setIdSistema(id);
        credId.setCredenciaisAcesso(credenciaisService.obterCredenciaisAcesso());
        headers.setBearerAuth(this.gatewaySingleton.getToken());
        String baseURL = String.format("%s/api/private/sistema/obter-por-id", baseUrl);
        HttpEntity<Object> entity = new HttpEntity<>(credId, headers);
        ParameterizedTypeReference<SistemaDTO> typeRef = new ParameterizedTypeReference<>() {};
        ResponseEntity<SistemaDTO> respostaRequest =  gatewaySingleton.dispararComTokenCipiws(baseURL, HttpMethod.POST, entity, typeRef);
        return respostaRequest.getBody();
    }

}
