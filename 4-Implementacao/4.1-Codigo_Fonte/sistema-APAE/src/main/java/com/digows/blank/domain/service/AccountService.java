package com.digows.blank.domain.service;

import java.util.Calendar;

import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.digows.blank.domain.entity.account.User;
import com.digows.blank.domain.entity.account.UserRole;
import com.digows.blank.domain.entity.tecnico.Tecnico;
import com.digows.blank.domain.repository.account.IUserRepository;
import com.digows.blank.domain.repository.funcionario.ITecnicoRepository;


/**
 * 
 * @author rodrigo.p.fraga@gmail.com
 */
@Service
@RemoteProxy
@Transactional
public class AccountService
{
	/*-------------------------------------------------------------------
	 *				 		     ATTRIBUTES
	 *-------------------------------------------------------------------*/
	/**
	 * Password encoder
	 */
	@Autowired
	private ShaPasswordEncoder passwordEncoder;

	/**
	 * Hash generator for encryption
	 */
	@Autowired
	private SaltSource saltSource;

	/**
	 * 
	 */
	@Autowired
	private MessageSource messageSorce;

	// Repositories
	/**
	 * 
	 */
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private ITecnicoRepository tecnicoRepository;
	
	

	/*-------------------------------------------------------------------
	 *				 		     SERVICES
	 *-------------------------------------------------------------------*/
	/**
	 * 
	 * @param event
	 */
	@PreAuthorize("isAuthenticated() && #user.id == principal.id")
	public void updateLastUserLogin( User user )
	{
		Assert.notNull( user );
		user = this.findUserById( user.getId() );
		user.setLastLogin( Calendar.getInstance() );
		this.userRepository.save( user );
	}

	/**
	 * 
	 * @param user
	 * @return
	 */
	@PreAuthorize("hasAnyAuthority('" + UserRole.COORDENADOR_VALUE + "','" + "')")
	public User insertUser( User user )
	{
		Assert.notNull( user );

		user.setEnabled( true );
		// encrypt password
		final String encodedPassword = this.passwordEncoder.encodePassword( user.getPassword(), this.saltSource.getSalt( user ) );
		user.setPassword( encodedPassword );

		return this.userRepository.save( user );
	}
	
	
	@PreAuthorize("hasAnyAuthority('" + UserRole.COORDENADOR_VALUE + "','" + "')")
	public void removeUser( Long userId )
	{
		Assert.notNull( userId );
		
		Tecnico tecnico = this.tecnicoRepository.findByUserId( userId );
		
		tecnico.setUser( null );
		
		this.tecnicoRepository.saveAndFlush( tecnico );

		this.userRepository.delete( userId );
	}

	/**
	 * 
	 * @param user
	 * @return
	 */
	public User updateUser( User userParam )
	{
		User user = this.userRepository.findOne( userParam.getId() );

		user.setName( userParam.getName() );
		user.setLogin( userParam.getLogin() );
		user.setRole( userParam.getRole() );
		user.setEnabled( true );

		if ( userParam.getPassword() != null )
		{

			final String encodedPassword = this.passwordEncoder.encodePassword( userParam.getPassword(), this.saltSource.getSalt( user ) );
			user.setPassword( encodedPassword );

		}
		return this.userRepository.save( user );
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public User findUserById( Long id )
	{
		final User user = this.userRepository.findOne( id );
		Assert.notNull( user, this.messageSorce.getMessage( "repository.notFoundById", new Object[]
		{ id }, LocaleContextHolder.getLocale() ) );
		return user;
	}

	/**
	 * 
	 * @param pageable
	 * @param filters
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<User> listUsersByFilters( String filter, PageRequest pageable )
	{
		return this.userRepository.listByFilters( filter, pageable );
	}
}