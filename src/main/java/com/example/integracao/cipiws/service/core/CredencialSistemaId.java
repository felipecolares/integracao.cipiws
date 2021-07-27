package com.example.integracao.cipiws.service.core;

public class CredencialSistemaId {

    private Integer idSistema;

    private CredenciaisAcessoWS credenciaisAcesso;

    public Integer getIdSistema() {
        return idSistema;
    }

    public void setIdSistema(Integer idSistema) {
        this.idSistema = idSistema;
    }

    public CredenciaisAcessoWS getCredenciaisAcesso() {
        return credenciaisAcesso;
    }

    public void setCredenciaisAcesso(CredenciaisAcessoWS credenciaisAcesso) {
        this.credenciaisAcesso = credenciaisAcesso;
    }
}
