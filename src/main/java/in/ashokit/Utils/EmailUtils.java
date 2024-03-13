package in.ashokit.Utils;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {
	
	
	  @Autowired
	  private  JavaMailSender javaMailSender;
	  
	  public boolean sendEmail(String sub, String body, String to) {
	        try {
	            MimeMessage message = javaMailSender.createMimeMessage();
	            MimeMessageHelper helper = new MimeMessageHelper(message, true);

	            helper.setSubject(sub);
	            helper.setText(body);
	            helper.setTo(to);

	           

	            javaMailSender.send(message);

	            return true; // Email sent successfully
	        } catch (Exception e) {
	            e.printStackTrace(); // Handle exception appropriately (log it, throw custom exception, etc.)
	            return false; // Failed to send email
	        }
	    }
	
	

}
