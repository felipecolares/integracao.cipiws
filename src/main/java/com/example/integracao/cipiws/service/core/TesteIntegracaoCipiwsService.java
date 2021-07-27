package com.example.integracao.cipiws.service.core;

import com.example.integracao.cipiws.service.integracao.cipiws.CipiwsSistemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TesteIntegracaoCipiwsService {

    @Autowired
    CipiwsSistemaService cipiwsSistemaService;

    public SistemaDTO acionarIntegracaoServicoCipi() {
        return cipiwsSistemaService.obterPorId(1);
    }
}
