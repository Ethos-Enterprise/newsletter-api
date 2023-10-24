package com.ethos.newsletterapi.mapper;

import com.ethos.newsletterapi.model.Newsletter;
import com.ethos.newsletterapi.repository.entity.NewsletterEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", nullValueMappingStrategy = org.mapstruct.NullValueMappingStrategy.RETURN_DEFAULT)
public interface NewsletterEntityMapper {
    NewsletterEntity from(Newsletter newsletter);
}
