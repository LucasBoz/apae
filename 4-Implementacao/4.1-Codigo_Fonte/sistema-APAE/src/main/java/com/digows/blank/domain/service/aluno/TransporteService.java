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
import com.digows.blank.domain.entity.transporte.Transporte;
import com.digows.blank.domain.repository.transporte.ITransporteRepository;

/**
 * 
 * @author rodrigo.p.fraga@gmail.com
 */
@Service
@RemoteProxy
@Transactional
public class TransporteService
{
	/*-------------------------------------------------------------------
	 *				 		     ATTRIBUTES
	 *-------------------------------------------------------------------*/

	//Repositories
	/**
	 * 
	 */
	@Autowired
	private ITransporteRepository transporteRepository;

	/*-------------------------------------------------------------------
	 *				 		     SERVICES
	 *-------------------------------------------------------------------*/

	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly=true)
	public Transporte findTransporteById( Long id )
	{
		final Transporte transporte = this.transporteRepository.findOne( id );
		return transporte;
	}
	
	
	/**
	 * 
	 * @param transporte
	 * @return
	 */
//	@PreAuthorize("hasAnyAuthority('"+UserRole.ADMINISTRATOR_VALUE+"','"+UserRole.MANAGER_VALUE+"')")
	public Transporte insertTransporte( Transporte transporte)
	{
		Assert.notNull( transporte );

		transporte.isValid();

		return this.transporteRepository.save( transporte );
	}
	
//	@PreAuthorize("hasAnyAuthority('"+UserRole.ADMINISTRATOR_VALUE+"','"+UserRole.MANAGER_VALUE+"')")
	public Transporte updateTransporte( Transporte transporte)
	{
		Assert.notNull( transporte );

		transporte.isValid();

		return this.transporteRepository.save( transporte );
	}
	
	
	/**
	 * 
	 * @param pageable
	 * @param filters
	 * @return
	 */
	@Transactional(readOnly=true)
	public Page<Transporte> listTransportesByFilters( String filter, PageRequest pageable )
	{
		return this.transporteRepository.listByFilters( filter, pageable );
	}
	

//	@PreAuthorize("hasAnyAuthority('"+UserRole.ADMINISTRATOR_VALUE+"','"+UserRole.MANAGER_VALUE+"')")
	public void removeTransporte(  Long transporteId)
	{
		this.transporteRepository.delete( transporteId );
	}
	
	
}