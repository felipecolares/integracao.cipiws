package com.example.integracao.cipiws.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class CredenciaisService {

    private final Environment env;

    @Autowired
    public CredenciaisService(Environment env) {
        this.env = env;
    }

    public CredenciaisAcessoWS obterCredenciaisAcesso(){
        return new CredenciaisAcessoWS(
                env.getProperty("cipi.codOrg"),
                env.getProperty("cipi.usr"),
                "983.394.160-57"
        );
    }
}
