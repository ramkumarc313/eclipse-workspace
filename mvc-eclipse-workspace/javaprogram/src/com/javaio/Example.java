package com.javaio;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class Example {

	    public static final String ACCOUNT_SID = "ACcac63ab4836de92c7164a16a9835241c";
	    public static final String AUTH_TOKEN = "c7b6415dfe5a9fbf68f1b2e79291cdf8";

	    public static void main(String[] args) {
	        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	        Message message = Message.creator(
	                new com.twilio.type.PhoneNumber("whatsapp:+917358252244"),
	                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
	                "Hello thomas there!")
	            .create();

	        System.out.println(message.getSid());
	    }


	

}
