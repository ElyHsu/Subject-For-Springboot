package com.foway.mason.service;

public interface MailService {
	String sendMail(String recipients, String mailSubject, String mailBody);
}