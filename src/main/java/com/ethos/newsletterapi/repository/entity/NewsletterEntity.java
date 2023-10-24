package com.ethos.newsletterapi.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.UUID;

@Entity
@Table(name = "newsletter")
public class NewsletterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String titulo;

    private String conteudo;

    public NewsletterEntity() {
    }

    @Builder(toBuilder = true)
    public NewsletterEntity(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
