/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.utility;

import com.example.demo.domain.User;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

/**
 *
 * @author Leyeseyi
 */
@Component
public class MailConstructor {
    @Autowired
    private Environment env;
    
    public SimpleMailMessage constructResetTokenEmail(String contextPath, Locale locale, String token, User user, String password){

        String url = contextPath + "/newUser?token="+token;    
        String message = "\nPlease click on this link to verify your email to complete your registration. Your current password is "+password;
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(user.getEmail());
        email.setSubject("The BookStore - New User");
        email.setText(url+message);
        email.setFrom(env.getProperty("support.email"));
        return email;
    } 
            
}
