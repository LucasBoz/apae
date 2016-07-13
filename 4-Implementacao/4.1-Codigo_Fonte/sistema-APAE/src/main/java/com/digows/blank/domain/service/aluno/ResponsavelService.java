package com.digows.blank.domain.service.aluno;

import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.digows.blank.domain.entity.account.UserRole;
import com.digows.blank.domain.entity.responsavel.Responsavel;
import com.digows.blank.domain.repository.aluno.IResponsavelRepository;

/**
 * 
 * @author rodrigo.p.fraga@gmail.com
 */
@Service
@RemoteProxy
@Transactional
public class ResponsavelService
{
	/*-------------------------------------------------------------------
	 *				 		     ATTRIBUTES
	 *-------------------------------------------------------------------*/

	//Repositories
	/**
	 * 
	 */
	@Autowired
	private IResponsavelRepository responsavelRepository;

	/*-------------------------------------------------------------------
	 *				 		     SERVICES
	 *-------------------------------------------------------------------*/

	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly=true)
	public Responsavel findResponsavelById( Long id )
	{
		return this.responsavelRepository.findOne( id );
	}
	
	
	/**
	 * 
	 * @param aluno
	 * @return
	 */
	@PreAuthorize("hasAnyAuthority('"+UserRole.ADMINISTRATOR_VALUE+"','"+UserRole.MANAGER_VALUE+"')")
	public Responsavel insertResponsavel( Responsavel responsavel)
	{
		Assert.notNull( responsavel );
		
		responsavel.isValid();

		return this.responsavelRepository.save( responsavel );
	}
	
	@PreAuthorize("hasAnyAuthority('"+UserRole.ADMINISTRATOR_VALUE+"','"+UserRole.MANAGER_VALUE+"')")
	public Responsavel updateResponsavel(  Responsavel responsavel)
	{
		Assert.notNull( responsavel );
		
		responsavel.isValid();

		return this.responsavelRepository.save( responsavel );
	}
	
	
	/**
	 * 
	 * @param pageable
	 * @param filters
	 * @return
	 */
	@Transactional(readOnly=true)
	public Page<Responsavel> listResponsavelByFilters( String filter, PageRequest pageable )
	{
		return this.responsavelRepository.listByFilters( filter, pageable );
		
	}
	
	@PreAuthorize("hasAnyAuthority('"+UserRole.ADMINISTRATOR_VALUE+"','"+UserRole.MANAGER_VALUE+"')")
	public void removeResponsavel(  Long responsavelId)
	{
		this.responsavelRepository.delete( responsavelId );
	}
	
	
}