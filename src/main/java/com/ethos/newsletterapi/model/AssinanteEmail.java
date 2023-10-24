package com.ethos.newsletterapi.model;

import com.ethos.newsletterapi.observer.Assinante;
import com.ethos.newsletterapi.service.EnviadorEmailService;

public class AssinanteEmail implements Assinante {

    private static final String EMAIL_EMPRESA = "jeffersoonaraujoo@gmail.com";
    private String nome;
    private String email;

    @Override
    public void receberNewsletter(EnviadorEmailService enviadorEmailService, Newsletter newsletter) {
        enviadorEmailService.sendEmail(EMAIL_EMPRESA, this.email, newsletter.titulo(), newsletter.conteudo());
    }

    public AssinanteEmail(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
