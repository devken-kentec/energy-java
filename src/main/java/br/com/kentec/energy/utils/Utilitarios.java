package br.com.kentec.energy.utils;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class Utilitarios {
	
	public String formataDataString(String data) {
		String ano = "";
		String mes = "";
		String dia = "";
		ano = data.substring(0, 4);
		mes = data.substring(5, 7);
		dia = data.substring(8, 10);
		String dataFormatada = dia +"/"+mes+"/"+ano;
		return dataFormatada;
	}
	
	
	public String formatarCpfString(String cpf) {
		String p1 = cpf.substring(0, 3);
		String p2 = cpf.substring(3, 6);
		String p3 = cpf.substring(6, 9);
		String p4 = cpf.substring(9, 11);
		String cpfFormatado = p1+"."+p2+"."+p3+"-"+p4;
		
		return cpfFormatado;
	}
	
	public String dataAtual() {
		LocalDateTime agora = LocalDateTime.now();
	    DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dataFormatada = formatterData.format(agora);
		return dataFormatada;
	}
	
	public void sendMail() {
		
		final String username = "contato@kentec.com.br";
		final String password = "@dev_ken130483";

		Properties props = new Properties();
		props.put("mail.smtp.host", "mail.kentec.com.br");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("kennedy_tomazete@outlook.com"));
			message.setSubject("Teste email hostgator com HTML");
			message.setText("Olá.!! Esta e-mail foi enviado usando javamail e com HTML");
                        String m = "<h1 style=\"color:red;\">KEN<span style=\"color:black;\">TEC</span></h1>"
                                 + "<p style=\"color:green;\">Email enviado com sucesso!!</p>"
                                 + "<p style=\"color:black;\">Novo 12/01/2021</p>";
                        message.setContent(m, "text/html; charset=utf-8");
                        message.setSentDate(new Date());
			Transport.send(message);
			System.out.println("Pronto!");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}
}
