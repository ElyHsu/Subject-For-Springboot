package com.foway.mason.service;

public interface MailService {
	void sendMail(String recipients, String mailSubject, String mailBody);
	String mailtoclient();
}