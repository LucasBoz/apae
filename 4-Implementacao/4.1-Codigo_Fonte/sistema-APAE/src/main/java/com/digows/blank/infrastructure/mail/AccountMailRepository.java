package com.digows.blank.infrastructure.mail;

import java.util.concurrent.Future;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.digows.blank.domain.entity.account.User;
import com.digows.blank.domain.repository.IAccountMailRepository;

/**
 * @author rodrigo.p.fraga@gmail.com
 * @since 03/08/2012
 * @version 1.0
 */
@Component
public class AccountMailRepository implements IAccountMailRepository
{
	/*-------------------------------------------------------------------
	 *                          ATTRIBUTES
	 *-------------------------------------------------------------------*/
	/**
     *
     */
	@Autowired
	private JavaMailSender mailSender;
	/**
     *
     */
	@Autowired
	private TemplateEngine templateEngine;
	/**
     *
     */
	@Value("${spring.mail.from}")
	private String mailFrom;
	/* (non-Javadoc)
	 * @see com.digows.blank.domain.repository.IAccountMailRepository#sendNewUserAccount(com.digows.blank.domain.entity.account.User)
	 */
	@Override
	public Future<Void> sendNewUserAccount( User user )
	{
		// TODO Auto-generated method stub
		return null;
	}

	/*-------------------------------------------------------------------
	 *                          BEHAVIORS
	 *-------------------------------------------------------------------*/
	/**
	 *
	 * @param user
	 */
}