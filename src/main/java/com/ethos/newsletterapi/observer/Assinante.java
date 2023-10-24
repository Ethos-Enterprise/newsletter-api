package com.ethos.newsletterapi.observer;

import com.ethos.newsletterapi.model.Newsletter;
import com.ethos.newsletterapi.service.EnviadorEmailService;

public interface Assinante {
    void receberNewsletter(EnviadorEmailService enviadorEmailService, Newsletter newsletter);
}
