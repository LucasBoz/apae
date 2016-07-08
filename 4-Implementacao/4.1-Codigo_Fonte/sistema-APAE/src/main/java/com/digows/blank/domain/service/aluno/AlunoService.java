package com.digows.blank.domain.service.aluno;

import java.util.Calendar;

import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.digows.blank.domain.entity.account.User;
import com.digows.blank.domain.entity.account.UserRole;
import com.digows.blank.domain.entity.aluno.Aluno;
import com.digows.blank.domain.repository.aluno.IAlunoRepository;

/**
 * 
 * @author rodrigo.p.fraga@gmail.com
 */
@Service
@RemoteProxy
@Transactional
public class AlunoService
{
	/*-------------------------------------------------------------------
	 *				 		     ATTRIBUTES
	 *-------------------------------------------------------------------*/

	//Repositories
	/**
	 * 
	 */
	@Autowired
	private IAlunoRepository alunoRepository;

	/*-------------------------------------------------------------------
	 *				 		     SERVICES
	 *-------------------------------------------------------------------*/

	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly=true)
	public Aluno findAlunoById( Long id )
	{
		final Aluno aluno = this.alunoRepository.findOne( id );
		return aluno;
	}
	
	
	/**
	 * 
	 * @param aluno
	 * @return
	 */
	@PreAuthorize("hasAnyAuthority('"+UserRole.ADMINISTRATOR_VALUE+"','"+UserRole.MANAGER_VALUE+"')")
	public Aluno insertAluno( Aluno aluno)
	{
		Assert.notNull( aluno );

//		aluno.setEnabled( true );

		return this.alunoRepository.save( aluno );
	}
	
	@PreAuthorize("hasAnyAuthority('"+UserRole.ADMINISTRATOR_VALUE+"','"+UserRole.MANAGER_VALUE+"')")
	public Aluno updateAluno( Aluno aluno)
	{
		Assert.notNull( aluno );

//		aluno.setEnabled( true );

		return this.alunoRepository.save( aluno );
	}
	
	
	/**
	 * 
	 * @param pageable
	 * @param filters
	 * @return
	 */
	@Transactional(readOnly=true)
	public Page<Aluno> listAlunosByFilters( String filter, PageRequest pageable )
	{
		return this.alunoRepository.listByFilters( filter, pageable );
	}
}