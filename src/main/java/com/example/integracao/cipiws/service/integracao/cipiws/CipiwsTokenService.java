package com.example.integracao.cipiws.service.integracao.cipiws;


import com.example.integracao.cipiws.service.integracao.model.LoginVM;
import com.example.integracao.cipiws.service.integracao.model.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
public class CipiwsTokenService {

    private final Environment env;
    private final String baseUrl;
    private final RestTemplate restTemplate;
    private final Logger log = LoggerFactory.getLogger(CipiwsTokenService.class);

    @Autowired
    public CipiwsTokenService(Environment env) {
        this.env = env;
        baseUrl = env.getProperty("cipiws.urlBase");
        restTemplate = new RestTemplate();
    }

    public Token getToken()  {
		String baseURL = baseUrl + "/api/public/sistema/gerar-token";
        LoginVM loginVM = new LoginVM();
        loginVM.setUsuario(env.getProperty("cipi.usr"));
        loginVM.setSenha(env.getProperty("cipi.senha"));
        HttpEntity<Object> entity = new HttpEntity<>(loginVM);
        return restTemplate.exchange(baseURL, HttpMethod.POST, entity, Token.class).getBody();
    }
}
