package com.ethos.newsletterapi.api;

import com.ethos.newsletterapi.api.empresadto.Empresa;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "empresa", url = "http://localhost:8082/v1.0/empresas")
public interface EmpresaApiClient {
    @GetMapping(path = "/assinante?assinanteNewsletter=true")
    List<Empresa> getEmpresasAssinantes();
}
