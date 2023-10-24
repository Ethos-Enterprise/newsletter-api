package com.ethos.newsletterapi.mapper;

import com.ethos.newsletterapi.api.empresadto.Empresa;
import com.ethos.newsletterapi.model.AssinanteEmail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring")
public interface AssinanteMapper {
    @Mapping(target = "nome", source = "razaoSocial")
    AssinanteEmail from(Empresa empresa);
}
