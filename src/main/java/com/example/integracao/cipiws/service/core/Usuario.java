package com.example.integracao.cipiws.service.core;

public class Usuario  {

    private Integer id;
    private String cpf;
    private String nome;
    private Long idMunicipio;
    private String email;
    private String foto;
    private Boolean delecaoLogica;
    private Integer idOrganizacao;
    private Integer idOrganizacaoLogada;
    private Integer idOrganizacaoAnterior;
    private Integer idUF;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Long idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Boolean getDelecaoLogica() {
        return delecaoLogica;
    }

    public void setDelecaoLogica(Boolean delecaoLogica) {
        this.delecaoLogica = delecaoLogica;
    }

    public Integer getIdOrganizacao() {
        return idOrganizacao;
    }

    public void setIdOrganizacao(Integer idOrganizacao) {
        this.idOrganizacao = idOrganizacao;
    }

    public Integer getIdOrganizacaoLogada() {
        return idOrganizacaoLogada;
    }

    public void setIdOrganizacaoLogada(Integer idOrganizacaoLogada) {
        this.idOrganizacaoLogada = idOrganizacaoLogada;
    }

    public Integer getIdOrganizacaoAnterior() {
        return idOrganizacaoAnterior;
    }

    public void setIdOrganizacaoAnterior(Integer idOrganizacaoAnterior) {
        this.idOrganizacaoAnterior = idOrganizacaoAnterior;
    }

    public Integer getIdUF() {
        return idUF;
    }

    public void setIdUF(Integer idUF) {
        this.idUF = idUF;
    }
}
