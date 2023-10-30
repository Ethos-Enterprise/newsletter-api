package com.ethos.newsletterapi.controller.request;

import jakarta.validation.constraints.NotBlank;

public record NewsletterRequest(
        @NotBlank(message = "O título não pode ser vazio")
        String titulo, String conteudo) {
}
