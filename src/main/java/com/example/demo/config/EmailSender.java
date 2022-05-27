/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.config;

import com.example.demo.clases.Cotizacion;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.*;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.*;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 *
 * @author Edelarocha
 */
@Service
public class EmailSender {

    @Autowired
    private JavaMailSender mailSender;

//    public void sendEmail(Cotizacion cotizacion) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("eare.albano@gmail.com");
//        message.setTo(cotizacion.getCorreoElectronico());
//        message.setText("Felicidades");
//        message.setSubject("Realizaste una cotizacion");
//
//        mailSender.send(message);
//
//    }
//    public void sendEmail(String para) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("eare.albano@gmail.com");
//        message.setTo(para);
//        StringBuilder correo = new StringBuilder();
//        correo.append("<!DOCTYPE html>\n"
//                + "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n"
//                + "<head>\n"
//                + "	<meta charset=\"UTF-8\">\n"
//                + "	<meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">\n"
//                + "	<meta name=\"x-apple-disable-message-reformatting\">\n"
//                + "	<title></title>\n"
//                + "	<!--[if mso]>\n"
//                + "	<noscript>\n"
//                + "		<xml>\n"
//                + "			<o:OfficeDocumentSettings>\n"
//                + "				<o:PixelsPerInch>96</o:PixelsPerInch>\n"
//                + "			</o:OfficeDocumentSettings>\n"
//                + "		</xml>\n"
//                + "	</noscript>\n"
//                + "	<![endif]-->\n"
//                + "	<style>\n"
//                + "		table, td, div, h1, p {font-family: Arial, sans-serif;}\n"
//                + "	</style>\n"
//                + "</head>"
//                + "<body style=\"margin:0;padding:0;\">"
//                + "<h1>Correo pro</h1>"
//                + "</body>");
//        message.setText(correo.toString());
////        message.setText("<h2>Cotizacon</h2>");
//        message.setSubject("Realizaste una cotizacion");
//
//        mailSender.send(message);
//        System.out.println("Correo enviado");
//    }
    public void sendEmail(String para) {

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        // Get the default Session object.
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("eare.albano@gmail.com", "ovwqzvjgagbbzwqd");
            }
        });
        MimeMessage message = new MimeMessage(session);

        try {
            StringBuilder sb = new StringBuilder();
            sb.append(encabezadoCorreo());
            sb.append(inicioTablaCorreo());
            sb.append(ultimoParteTablaCorreo());
            sb.append(tablaAuxCorreo());
            sb.append(finCorreo());
            message.setFrom("eare.albano@gmail.com");
            message.setRecipients(RecipientType.TO, para);
            message.setSubject("Qe paza");
            message.setText(sb.toString(), "utf-8", "html");
            Transport.send(message);
            System.out.println("Correo Enviado");
        } catch (Exception ex) {
            System.out.println("Algo fallo en el correo");
        }
    }

    public String encabezadoCorreo() {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n"
                + "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n"
                + "<head>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">\n"
                + "<meta name=\"x-apple-disable-message-reformatting\">\n"
                + "<title></title>\n"
                + "<!--[if mso]>\n"
                + "<noscript>\n"
                + "<xml>\n"
                + "<o:OfficeDocumentSettings>\n"
                + "<o:PixelsPerInch>96</o:PixelsPerInch>\n"
                + "</o:OfficeDocumentSettings>\n"
                + "</xml>\n"
                + "</noscript>\n"
                + "<![endif]-->\n"
                + "<style>\n"
                + "table, td, div, h1, p {font-family: Arial, sans-serif;}\n"
                + "</style>\n"
                + "</head>");

        return sb.toString();
    }

    public String inicioTablaCorreo() {
        StringBuilder sb = new StringBuilder();
        sb.append("<body style=\"margin:0;padding:0;\">\n"
                + "<table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;background:#ffffff;\">\n"
                + "<tr>\n"
                + "<td align=\"center\" style=\"padding:0;\">\n"
                + "<table role=\"presentation\" style=\"width:602px;border-collapse:collapse;border:1px solid #cccccc;border-spacing:0;text-align:left;background:#000;\">\n"
                + "<tr>\n"
                + "<td align=\"center\" style=\"padding:40px 0 30px 0;background:#000;\">\n"
                + "<img src=\"https://www.pandaancha.mx/plds/articulos/bcbf6a4b9c2b8d897db5beea24f29bab438183555.jpg\" alt=\"\" width=\"300\" style=\"height:auto;display:block;\" />\n"
                + "</td>\n"
                + "</tr>\n"
                + "<tr>\n"
                + "<td style=\"padding:36px 30px 42px 30px;\">\n"
                + "<table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;\">\n"
                + "<tr>\n"
                + "<h1 style=\"color:#BD4B4B;font-size:24px;font-family:Arial,sans-serif;\">En este correo se especificaran los costos del paquete que modelo en el cotizador de la pagina TotalPlayExpress.com</h1>\n"
                + "<h1 style=\"color:#009DAE;font-size:24px;font-family:Arial,sans-serif;\">Esquema de pagos por meses</h1>\n"
                + "<table role=\"presentation\" style=\"width:100%;background-color:#9A0680;\">\n"
                + "<tr style=\"border:2px solid #F4BEEE;\">\n"
                + "<td style=\"color:#DADDFC;border:2px solid #DADDFC;\">\n"
                + "<h1 style=\"font-size:24px;font-family:Arial,sans-serif;\">Primer</h1>\n"
                + "</td>\n"
                + "<td style=\"color:#DADDFC;border:2px solid #DADDFC\">\n"
                + "<h1 style=\"font-size:24px;font-family:Arial,sans-serif;\">Segundo</h1>\n"
                + "</td>\n"
                + "<td style=\"color:#DADDFC;border:2px solid #DADDFC\">\n"
                + "<h1 style=\"font-size:24px;font-family:Arial,sans-serif;\">Tercer</h1>\n"
                + "</td>\n"
                + "<td style=\"color:#DADDFC;border:2px solid #DADDFC\">\n"
                + "<h1 style=\"font-size:24px;font-family:Arial,sans-serif;\">Cuarto</h1>\n"
                + "</td>\n"
                + "<td style=\"color:#DADDFC;border:2px solid #DADDFC\">\n"
                + "<h1 style=\"font-size:24px;font-family:Arial,sans-serif;\">Quinto</h1>\n"
                + "</td>\n"
                + "<td style=\"color:#DADDFC;border:2px solid #DADDFC;\">\n"
                + "<h1 style=\"font-size:24px;font-family:Arial,sans-serif;\">Sexto</h1>\n"
                + "</td>\n"
                + "</tr>");

        return sb.toString();
    }

    public String ultimoParteTablaCorreo() {
        StringBuilder sb = new StringBuilder();
        sb.append("<tr style=\"border:2px solid #F4BEEE;;background-color:#71DFE7;\">\n"
                + "<td style=\"color:#181D31;border:2px solid #DADDFC;\">\n"
                + "<h1 style=\"font-size:30px;font-family:Arial,sans-serif\">619</h1>\n"
                + "</td>\n"
                + "<td style=\"color:#181D31;border:2px solid #DADDFC\">\n"
                + "<h1 style=\"font-size:30px;font-family:Arial,sans-serif;\">619</h1>\n"
                + "</td>\n"
                + "<td style=\"color:#181D31;border:2px solid #DADDFC\">\n"
                + "<h1 style=\"font-size:30px;font-family:Arial,sans-serif;\">619</h1>\n"
                + "</td>\n"
                + "<td style=\"color:#181D31;border:2px solid #DADDFC\">\n"
                + "<h1 style=\"font-size:30px;font-family:Arial,sans-serif;\">619</h1>\n"
                + "</td>\n"
                + "<td style=\"color:#181D31;border:2px solid #DADDFC\">\n"
                + "<h1 style=\"font-size:30px;font-family:Arial,sans-serif;\">619</h1>\n"
                + "</td>\n"
                + "<td style=\"color:#181D31;border:2px solid #DADDFC\">\n"
                + "<h1 style=\"font-size:30px;font-family:Arial,sans-serif;\">619</h1>\n"
                + "</td>\n"
                + "</tr>\n"
                + "<tr style=\"border:2px solid #F4BEEE;\">\n"
                + "<td style=\"color:#DADDFC;border:2px solid #DADDFC;\">\n"
                + "<h1 style=\"font-size:24px;font-family:Arial,sans-serif;\">Septimo</h1>\n"
                + "</td>\n"
                + "<td style=\"color:#DADDFC;border:2px solid #DADDFC\">\n"
                + "<h1 style=\"font-size:24px;font-family:Arial,sans-serif;\">Octavo</h1>\n"
                + "</td>\n"
                + "<td style=\"color:#DADDFC;border:2px solid #DADDFC\">\n"
                + "<h1 style=\"font-size:24px;font-family:Arial,sans-serif;\">Noveno</h1>\n"
                + "</td>\n"
                + "<td style=\"color:#DADDFC;border:2px solid #DADDFC\">\n"
                + "<h1 style=\"font-size:24px;font-family:Arial,sans-serif;\">Decimo</h1>\n"
                + "</td>\n"
                + "<td style=\"color:#DADDFC;border:2px solid #DADDFC\">\n"
                + "<h1 style=\"font-size:24px;font-family:Arial,sans-serif;\">Onceavo</h1>\n"
                + "</td>\n"
                + "<td style=\"color:#DADDFC;border:2px solid #DADDFC\">\n"
                + "<h1 style=\"font-size:24px;font-family:Arial,sans-serif;\">Doceavo</h1>\n"
                + "</td>\n"
                + "</tr>\n"
                + "<tr style=\"border:2px solid #F4BEEE;;background-color:#71DFE7;\">\n"
                + "<td style=\"color:#181D31;border:2px solid #DADDFC;\">\n"
                + "<h1 style=\"font-size:30px;font-family:Arial,sans-serif\">619</h1>\n"
                + "</td>\n"
                + "<td style=\"color:#181D31;border:2px solid #DADDFC\">\n"
                + "<h1 style=\"font-size:30px;font-family:Arial,sans-serif;\">619</h1>\n"
                + "</td>\n"
                + "<td style=\"color:#181D31;border:2px solid #DADDFC\">\n"
                + "<h1 style=\"font-size:30px;font-family:Arial,sans-serif;\">619</h1>\n"
                + "</td>\n"
                + "<td style=\"color:#181D31;border:2px solid #DADDFC\">\n"
                + "<h1 style=\"font-size:30px;font-family:Arial,sans-serif;\">619</h1>\n"
                + "</td>\n"
                + "<td style=\"color:#181D31;border:2px solid #DADDFC\">\n"
                + "<h1 style=\"font-size:30px;font-family:Arial,sans-serif;\">619</h1>\n"
                + "</td>\n"
                + "<td style=\"color:#181D31;border:2px solid #DADDFC\">\n"
                + "<h1 style=\"font-size:30px;font-family:Arial,sans-serif;\">619</h1>\n"
                + "</td>\n"
                + "</tr>\n"
                + "</table>\n"
                + "</tr>");

        return sb.toString();
    }

    public String tablaAuxCorreo() {
        StringBuilder sb = new StringBuilder();
        sb.append("<tr>\n"
                + "<h1 style=\"color:#009DAE;font-size:24px;font-family:Arial,sans-serif;\">DESGLOCE PRIMER PAGO</h1>\n"
                + "<table role=\"presentation\" style=\"width:80%;background-color:#FA0680;\">\n"
                + "<tr style=\"border:2px solid #F4BEEE;;background-color:#261C2C;\">\n"
                + "<td style=\"color:#6E85B2;border:2px solid #DADDFC;\">\n"
                + "<h1 style=\"font-size:30px;font-family:Arial,sans-serif;\">Concepto</h1>\n"
                + "</td>\n"
                + "<td style=\"color:#6E85B2;border:2px solid #DADDFC;\">\n"
                + "<h1 style=\"font-size:30px;font-family:Arial,sans-serif;\">Precio</h1>\n"
                + "</td>\n"
                + "</tr>\n"
                + "<tr style=\"border:2px solid #F4BEEE;;background-color:#3E2C41;\">\n"
                + "<td style=\"color:#6E85B2;border:2px solid #DADDFC;\">\n"
                + "<h1 style=\"font-size:30px;font-family:Arial,sans-serif;\">Internet 100 megas</h1>\n"
                + "</td> \n"
                + "<td style=\"color:#6E85B2;border:2px solid #DADDFC\">\n"
                + "<h1 style=\"font-size:30px;font-family:Arial,sans-serif;\">170</h1>\n"
                + "</td>\n"
                + "</tr>\n"
                + "<tr style=\"border:2px solid #F4BEEE;;background-color:#64C9CF;\">\n"
                + "<td style=\"color:#4c3292;border:2px solid #DADDFC;\">\n"
                + "<h1 style=\"font-size:30px;font-family:Arial,sans-serif\">Costo De Instalacion</h1>\n"
                + "</td>\n"
                + "<td style=\"color:#4c3292;border:2px solid #DADDFC\">\n"
                + "<h1 style=\"font-size:30px;font-family:Arial,sans-serif;\">$170</h1>\n"
                + "</td>\n"
                + "</tr>\n"
//                + "'+@NetflixBody+'\n"
//                + "'+@AmazonBody+'\n"
//                + "'+@C140Body+'\n"
//                + "'+@C230Body+'\n"
//                + "'+@C280Body+'\n"
//                + "'+@WifiExtenderBody+'\n"
//                + "'+@TvAdicionalBody+'\n"
                + "<br>\n"
                + "<tr style=\"border:2px solid #F4BEEE;background-color:#BCCC9A;\">\n"
                + "<td style=\"color:#002366;border:2px solid #DADDFC;\">\n"
                + "<h1 style=\"font-size:30px;font-family:Arial,sans-serif;\">Total</h1>\n"
                + "</td>\n"
                + "<td style=\"color:#002366;border:2px solid #DADDFC\">\n"
                + "<h1 style=\"font-size:30px;font-family:Arial,sans-serif;\">619</h1>\n"
                + "</td>\n"
                + "</tr>\n"
                + "</table>\n"
                + "</tr>\n"
                + "</table>\n"
                + "</td>\n"
                + "</tr>");

        return sb.toString();
    }

    public String finCorreo() {
        StringBuilder sb = new StringBuilder();
        sb.append("<tr>\n"
                + "<td style=\"padding:30px;background:#ee4c50;\">\n"
                + "<table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;font-size:9px;font-family:Arial,sans-serif;\">\n"
                + "<tr>\n"
                + "<td style=\"padding:0;width:60%;\" align=\"left\">\n"
                + "<p style=\"margin:0;font-size:18px;line-height:16px;font-family:Arial,sans-serif;color:#ffffff;\">\n"
                + "Para terminar su contratacion responda este correo, o llame a este numero <span style=\"color:#222\">6623804420</span><br/>\n"
                + "</p>\n"
                + "</td>\n"
                + "<td style=\"padding:0;width:40%;\" align=\"right\">\n"
                + "<table role=\"presentation\" style=\"border-collapse:collapse;border:0;border-spacing:0;\">\n"
                + "<tr>\n"
                + "<td style=\"padding:0 0 0 10px;width:38px;\">\n"
                + "<a href=\"http://www.twitter.com/\" style=\"color:#ffffff;\"><img src=\"https://assets.codepen.io/210284/tw_1.png\" alt=\"Twitter\" width=\"38\" style=\"height:auto;display:block;border:0;\" /></a>\n"
                + "</td>\n"
                + "<td style=\"padding:0 0 0 10px;width:38px;\">\n"
                + "<a href=\"http://www.facebook.com/\" style=\"color:#ffffff;\"><img src=\"https://assets.codepen.io/210284/fb_1.png\" alt=\"Facebook\" width=\"38\" style=\"height:auto;display:block;border:0;\" /></a>\n"
                + "</td>\n"
                + "</tr>\n"
                + "</table>\n"
                + "</td>\n"
                + "</tr>\n"
                + "</table>\n"
                + "</td>\n"
                + "</tr>\n"
                + "</table>\n"
                + "</td>\n"
                + "</tr>\n"
                + "</table>\n"
                + "</body>\n"
                + "</html>");

        return sb.toString();
    }

}
