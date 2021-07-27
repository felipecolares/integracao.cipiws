package com.example.integracao.cipiws.service.core;

public class CredenciaisAcessoWS {

    private static final long serialVersionUID = -3713699715353067565L;

    private String codigoOrgao;
    private String sistema;
    private String cpf;

    public CredenciaisAcessoWS() {
    }

    public CredenciaisAcessoWS(String codigoOrgao, String sistema, String cpf) {
        this.codigoOrgao = codigoOrgao;
        this.sistema = sistema;
        this.cpf = cpf;
    }

    public String getCodigoOrgao() {
        return codigoOrgao;
    }

    public void setCodigoOrgao(String codigoOrgao) {
        this.codigoOrgao = codigoOrgao;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
