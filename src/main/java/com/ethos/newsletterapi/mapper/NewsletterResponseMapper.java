package com.ethos.newsletterapi.mapper;

import com.ethos.newsletterapi.controller.response.NewsletterResponse;
import com.ethos.newsletterapi.repository.entity.NewsletterEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", nullValueMappingStrategy = org.mapstruct.NullValueMappingStrategy.RETURN_DEFAULT)
public interface NewsletterResponseMapper {
    NewsletterResponse from(NewsletterEntity newsletterEntity);
}
