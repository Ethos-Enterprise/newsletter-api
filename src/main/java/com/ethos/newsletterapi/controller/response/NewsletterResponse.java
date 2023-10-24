package com.ethos.newsletterapi.controller.response;

import java.util.UUID;

public record NewsletterResponse(UUID id, String titulo, String conteudo) {
}
