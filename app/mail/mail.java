package mail;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

import persistence.Asset;
import persistence.CheckoutEvent;
import persistence.CheckoutLineItem;
import persistence.Customer;

public class mail {

	private static final String SMTP_HOST_NAME = "smtpmail.ad.uvu.edu";
	private static final Integer PORT = 25;
    private static final String SMTP_AUTH_USER = "wbit";
    private static final String SMTP_AUTH_PWD  = "Rum@1lm@n";
    private static final String FROM_FIELD = "wbit@uvu.edu";
    
	public static void dueToday(CheckoutEvent checkoutEvent) throws Exception{
		System.out.println("Sending some mail");
		HtmlEmail email = new HtmlEmail();
	    email.setSmtpPort(PORT);
	    email.setAuthenticator(new DefaultAuthenticator(SMTP_AUTH_USER, SMTP_AUTH_PWD));
	    email.setDebug(false);
	    email.setHostName(SMTP_HOST_NAME);
	    email.setFrom(FROM_FIELD);
	    email.setSubject("Your checkout from WBIT is due today");
	    email.setMsg(views.html.dueToday.render(checkoutEvent) + "");
	    email.addTo("mail@jdclark.biz");
	    email.send();
	    System.out.println("Mail sent!");
	}
	
	
}
