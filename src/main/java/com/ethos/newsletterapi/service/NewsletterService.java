package com.ethos.newsletterapi.service;

import com.ethos.newsletterapi.api.EmpresaApiClient;
import com.ethos.newsletterapi.api.empresadto.Empresa;
import com.ethos.newsletterapi.controller.request.NewsletterRequest;
import com.ethos.newsletterapi.controller.response.NewsletterResponse;
import com.ethos.newsletterapi.mapper.AssinanteMapper;
import com.ethos.newsletterapi.mapper.NewsletterEntityMapper;
import com.ethos.newsletterapi.mapper.NewsletterMapper;
import com.ethos.newsletterapi.mapper.NewsletterResponseMapper;
import com.ethos.newsletterapi.model.AssinanteEmail;
import com.ethos.newsletterapi.model.Newsletter;
import com.ethos.newsletterapi.repository.NewsletterRepository;
import com.ethos.newsletterapi.repository.entity.NewsletterEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NewsletterService {
    private final NewsletterRepository newsletterRepository;
    private final NewsletterResponseMapper newsletterResponseMapper;
    private final NewsletterEntityMapper newsletterEntityMapper;
    private final NewsletterMapper newsletterMapper;
    private final EmpresaApiClient empresaApiClient;
    private final EnviadorEmailService enviadorEmailService;
    private final AssinanteMapper assinanteMapper;

    public NewsletterResponse postNewsletter(NewsletterRequest request) {
        Newsletter model = newsletterMapper.from(request);
        NewsletterEntity entity = newsletterEntityMapper.from(model);
        NewsletterEntity savedEntity = saveNewsletter(entity);
        return newsletterResponseMapper.from(savedEntity);
    }

    public NewsletterResponse getNewsletterById(UUID id) {
        NewsletterEntity entity = newsletterRepository.findById(id).orElseThrow();
        return newsletterResponseMapper.from(entity);
    }

    public NewsletterResponse putNewsletterById(UUID id, NewsletterRequest request) {
        Newsletter model = newsletterMapper.from(request);
        NewsletterEntity entity = newsletterEntityMapper.from(model);
        entity.setId(id);
        NewsletterEntity savedEntity = saveNewsletter(entity);
        return newsletterResponseMapper.from(savedEntity);
    }

    public void deleteNewsletter(UUID id) {
        newsletterRepository.deleteById(id);
    }

    public void sendNewsletterById(UUID id) {
        NewsletterEntity entity = newsletterRepository.findById(id).orElseThrow();
        Newsletter newsletter = newsletterMapper.from(entity);
        List<Empresa> empresasAssinantes = empresaApiClient.getEmpresasAssinantes();
        List<AssinanteEmail> assinanteEmails = empresasAssinantes.stream().map(assinanteMapper::from).toList();

        assinanteEmails.forEach(assinanteEmail -> assinanteEmail.receberNewsletter(enviadorEmailService, newsletter));
    }

    private NewsletterEntity saveNewsletter(NewsletterEntity entity) {
        return newsletterRepository.save(entity);
    }

    public List<NewsletterResponse> getAllNewsletters() {
        List<NewsletterEntity> newsletters = newsletterRepository.findAll();
        return newsletters.stream().map(newsletterResponseMapper::from).toList();
    }

    public void deleteNewsletterById(UUID id) {
        newsletterRepository.deleteById(id);
    }
}
