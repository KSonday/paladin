package com.paladin.services;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.paladin.models.ActiveOpportunity;
import com.paladin.models.User;
import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;

@Service("mailService")
public class MailServiceImpl implements MailService {
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	@Autowired
	private OpportunityService opportunityService;
	
	private static final String SENDGRID_API_KEY = "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";
	
	@Override
	public void sendProfile(User user) {
		MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo("team@joinpaladin.com");
            helper.setFrom("noreply@joinpaladin.com");
            helper.setSubject("New User");
            helper.setText(user.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {}
        javaMailSender.send(mail);
	}
	
	@Override
	public void sendMatchEmail(User user, List<ActiveOpportunity> opportunities) {
		SendGrid sendgrid = new SendGrid(SENDGRID_API_KEY);

	    SendGrid.Email email = new SendGrid.Email();
	    email.addTo(user.getEmail());
	    email.setFrom("noreply@joinpaladin.com");
	    email.setSubject("Hello World");
	    email.addSubstitution("-test-", new String[]{opportunityService.getUrl(opportunities.get(0))});
	    email.addSubstitution("-test0-", new String[]{"http://d1qzfw5jom7xzu.cloudfront.net/home.jpg"});
	    email.setTemplateId("fc596eb5-014f-4371-a2c5-e495e643210f");
	    email.setHtml("<p></p>");

	    try {
	      SendGrid.Response response = sendgrid.send(email);
	      System.out.println(response.getMessage());
	    }
	    catch (SendGridException e) {
	      System.err.println(e);
	    }
	  }
}
