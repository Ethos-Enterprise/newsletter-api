package com.ethos.newsletterapi.api.empresadto;

public class EmpresaBuilder {
    private String nome;
    private String email;

    public EmpresaBuilder setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public EmpresaBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public Empresa createEmpresa() {
        return new Empresa(nome, email);
    }
}
