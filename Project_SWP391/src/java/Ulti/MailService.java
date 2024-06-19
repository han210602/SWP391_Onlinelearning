/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ulti;

import java.util.Properties;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

/**
 *
 * @author ngngh
 */
public class MailService {
        public static void sendMail(String to, String sub, String message) {
        final String user = "khoinguyen17062002@gmail.com";
        final String pass = "acub qzfk djqp kmsy";
        Properties pros = new Properties();
        pros.put("mail.smtp.host", "smtp.gmail.com");
        pros.put("mail.smtp.port", "587");//TLS 587 SSL 465
        pros.put("mail.smtp.auth", "true");
        pros.put("mail.smtp.starttls.enable", "true");

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        };

        Session session = Session.getInstance(pros, auth);

        MimeMessage msg = new MimeMessage(session);
        try {
            msg.setFrom(user);//nguoi gui
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));//nguoi nhan
            msg.setSubject(sub);//tieu de
            msg.setText(message);
            Transport.send(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
