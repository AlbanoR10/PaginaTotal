/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author Edelarocha
 */
@Service
public class EmailSender {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String para) {
        SimpleMailMessage message = new SimpleMailMessage();
message.setFrom("eare.albano@gmail.com");
message.setTo(para);
message.setText("Felicidades");
message.setSubject("Realizaste una cotizacion");

mailSender.send(message);


    }
}
