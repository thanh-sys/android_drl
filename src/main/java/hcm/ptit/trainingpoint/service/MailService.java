package hcm.ptit.trainingpoint.service;

import hcm.ptit.trainingpoint.model.dto.DataMailDTO;

import javax.mail.MessagingException;

import org.springframework.stereotype.Service;

@Service
public interface MailService {
    void sendHtmlMail(DataMailDTO dataMail, String templateName) throws MessagingException;
}