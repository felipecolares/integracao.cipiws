package com.example.integracao.cipiws.service.core;

import java.time.LocalDate;
import java.util.List;

public class SistemaDTO {
    private Integer id;

    private String sigla;

    private String nome;

    private String senha;

    private List<String> permissaoOrgao;

    private String email;

    private LocalDate dtCriacao;

    private CredenciaisAcessoWS credenciaisAcesso;

    public SistemaDTO() {
    }

    public SistemaDTO(String sigla, String nome, String email) {
        this.sigla = sigla;
        this.nome = nome;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<String> getPermissaoOrgao() {
        return permissaoOrgao;
    }

    public void setPermissaoOrgao(List<String> permissaoOrgao) {
        this.permissaoOrgao = permissaoOrgao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(LocalDate dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public CredenciaisAcessoWS getCredenciaisAcesso() {
        return credenciaisAcesso;
    }

    public void setCredenciaisAcesso(CredenciaisAcessoWS credenciaisAcesso) {
        this.credenciaisAcesso = credenciaisAcesso;
    }
}
