package com.example.integracao.cipiws.web.rest.core;

import com.example.integracao.cipiws.service.core.SistemaDTO;
import com.example.integracao.cipiws.service.core.TesteIntegracaoCipiwsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TesteIntegracaoCipiws {

    private static final String PRIVATE_API_URI = "/cipiws/teste-integracao";

    @Autowired
    TesteIntegracaoCipiwsService testeIntegracaoCipiwsService;

    @GetMapping(PRIVATE_API_URI)
    public SistemaDTO iniciarTesteIntegracao() {
        return testeIntegracaoCipiwsService.acionarIntegracaoServicoCipi();
    }
}
