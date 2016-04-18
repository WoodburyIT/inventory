package controllers;

import java.net.PasswordAuthentication;
import java.util.List;
import java.util.Properties;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import persistence.ScheduledCheckout;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import util.CheckoutDAO;

public class Mail extends Controller {

	private static final String SMTP_HOST_NAME = "smtpmail.ad.uvu.edu";
	private static final Integer PORT = 25;
    private static final String SMTP_AUTH_USER = "wbit";
    private static final String SMTP_AUTH_PWD  = "Rum@1lm@n";
    private static final String FROM_FIELD = "wbit@uvu.edu";
	
	@Transactional
    public Result testMail() throws EmailException {
		System.out.println("Sending some mail");
		Email email = new SimpleEmail();
	    email.setSmtpPort(PORT);
	    email.setAuthenticator(new DefaultAuthenticator(SMTP_AUTH_USER, SMTP_AUTH_PWD));
	    email.setDebug(false);
	    email.setHostName(SMTP_HOST_NAME);
	    email.setFrom(FROM_FIELD);
	    email.setSubject("Testing");
	    email.setMsg("This is a test mail ... :-)");
	    email.addTo("mail@jdclark.biz");
	    email.send();
	    System.out.println("Mail sent!");
	    
	    return ok();
    }
	
}