package com.ethos.newsletterapi.model;

import java.util.List;

public record Newsletter(String titulo, String conteudo, List<AssinanteEmail> assinanteEmails) {
}
