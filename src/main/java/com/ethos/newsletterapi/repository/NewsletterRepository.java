package com.ethos.newsletterapi.repository;

import com.ethos.newsletterapi.repository.entity.NewsletterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NewsletterRepository extends JpaRepository<NewsletterEntity, UUID> {
}
