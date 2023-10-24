package com.ethos.newsletterapi.controller;

import com.ethos.newsletterapi.controller.request.NewsletterRequest;
import com.ethos.newsletterapi.controller.response.NewsletterResponse;
import com.ethos.newsletterapi.service.NewsletterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/newsletter")
@RequiredArgsConstructor
public class NewsletterController {
    private final NewsletterService newsletterService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NewsletterResponse postNewsletter(@RequestBody NewsletterRequest request){
        return newsletterService.postNewsletter(request);
    }

    @GetMapping
    public List<NewsletterResponse> getNewsletters(){
        return newsletterService.getAllNewsletters();
    }

    @GetMapping("/{id}")
    public NewsletterResponse getNewsletterById(@PathVariable UUID id){
        return newsletterService.getNewsletterById(id);
    }

    @PutMapping("/{id}")
    public NewsletterResponse putNewsletterById(@PathVariable UUID id, @RequestBody NewsletterRequest request){
        return newsletterService.putNewsletterById(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNewsletterById(@PathVariable UUID id){
        newsletterService.deleteNewsletterById(id);
    }

    @GetMapping("/send/{id}")
    public void sendNewsletterById(@PathVariable UUID id){
        newsletterService.sendNewsletterById(id);
    }
}
