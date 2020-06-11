package com.teko.client.controller;

import com.teko.client.domain.Email;
import com.teko.proto.AddEmailRequest;
import com.teko.proto.EmailServiceGrpc;
import com.teko.proto.EmailTranfer;
import com.teko.proto.GetAllEmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/")
public class BaseController {

    @Autowired
    @Qualifier("emailServiceBlockingStub")
    EmailServiceGrpc.EmailServiceBlockingStub emailService;

    @RequestMapping("/")
    public List<Email> getAllEmail() {
        Iterator<EmailTranfer> emailTranfers = emailService.getAll(GetAllEmailRequest.getDefaultInstance());
        List<Email> result = new ArrayList<>();
        while (emailTranfers.hasNext()) {
            result.add(Email.fromProto(emailTranfers.next()));
        }
        return result;
    }

    @RequestMapping("/add")
    public Email saveEmail() {
        Email email = Email.builder()
                .id(0)
                .file("file")
                .fromEmail("fromEmail")
                .important(true)
                .message("message")
                .sendTime(new Date(System.currentTimeMillis()))
                .status("status")
                .subject("subject")
                .toEmail("toEmail")
                .build();
        EmailTranfer emailTranfer = emailService.save(AddEmailRequest.newBuilder().setEmail(email.toProto()).build());
        return Email.fromProto(emailTranfer);
    }
}
