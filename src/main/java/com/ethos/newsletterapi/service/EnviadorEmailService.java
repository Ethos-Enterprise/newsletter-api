package com.ethos.newsletterapi.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import lombok.RequiredArgsConstructor;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnviadorEmailService {

    private final JavaMailSender mailSender;

    private final TaskExecutor taskExecutor;

    private static Log log = LogFactory.getLog(EnviadorEmailService.class);

    public void sendEmail(final String remetente, final String destinatario, final String titulo, final String conteudo){
        taskExecutor.execute(() -> sendMailSimple(remetente, destinatario, titulo, conteudo));
    }

    private void sendMailSimple(
            final String remetente,
            final String destinatario,
            final String titulo,
            final String conteudo
    ) {

        MimeMessage message = mailSender.createMimeMessage();
        try {
            String html = new String(Files.readAllBytes(Paths.get("src/main/resources/templates/email.html")));
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(remetente);
            helper.setTo(destinatario);
            helper.setSubject(titulo);
            helper.setText(html, true);
            File directory = new File("src/main/resources/templates/images");
            File[] files = directory.listFiles();

            assert files != null;
            for (File file : files) {
                if(file.isFile() && file.getName().contains(".png") || file.getName().contains(".gif")){
                    FileSystemResource res = new FileSystemResource(file);
                    helper.addInline(file.getName(), res);
                }
            }
        } catch (MessagingException | IOException e) {
            throw new MailParseException(e);
        }

        mailSender.send(message);

        if (log.isDebugEnabled()) {
            log.debug(String.format("Email enviado corretamente para: %s", destinatario));
        }
    }
}