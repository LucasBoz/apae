package com.digows.blank.domain.service.aluno;

import java.util.Calendar;

import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.digows.blank.domain.entity.account.UserRole;
import com.digows.blank.domain.entity.aluno.Cid;
import com.digows.blank.domain.repository.aluno.ICidRepository;

/**
 * 
 * @author rodrigo.p.fraga@gmail.com
 */
@Service
@RemoteProxy
@Transactional
public class CidService
{
	/*-------------------------------------------------------------------
	 *				 		     ATTRIBUTES
	 *-------------------------------------------------------------------*/

	//Repositories
	/**
	 * 
	 */
	@Autowired
	private ICidRepository cidRepository;

	/*-------------------------------------------------------------------
	 *				 		     SERVICES
	 *-------------------------------------------------------------------*/

	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly=true)
	public Cid findCidById( Long id )
	{
		final Cid cid = this.cidRepository.findOne( id );
		return cid;
	}
	
	
	@PreAuthorize("hasAnyAuthority('"+UserRole.ADMINISTRATOR_VALUE+"','"+UserRole.MANAGER_VALUE+"')")
	public void updateCid( Cid cid)
	{
		Assert.notNull( cid );
		Assert.notNull( cid.getId() );
		
		Cid cid10 = findCidById(cid.getId());
		
		cid10.setAtivo( cid.getAtivo() );
		cid10.setDefinicao( cid.getDefinicao() );

		this.cidRepository.save( cid10 );
		
	}
	
	
	/**
	 * 
	 * @param pageable
	 * @param filters
	 * @return
	 */
	@Transactional(readOnly=true)
	public Page<Cid> listCidsByFilters( String filter, PageRequest pageable )
	{
		return this.cidRepository.listByFilters( filter , pageable );
	}
}