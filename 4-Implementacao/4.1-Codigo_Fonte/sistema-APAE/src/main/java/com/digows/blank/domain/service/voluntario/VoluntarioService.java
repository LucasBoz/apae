/**
 * 
 */
package com.digows.blank.domain.service.voluntario;

import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.digows.blank.domain.entity.voluntario.Voluntario;
import com.digows.blank.domain.repository.voluntario.IVoluntarioRepository;

/**
 * @author lucas
 *
 */
@Service
@RemoteProxy
@Transactional
public class VoluntarioService
{

	@Autowired
	private IVoluntarioRepository voluntarioRepository;

	@Transactional(readOnly=true)
	public Voluntario findVoluntarioById( Long id )
	{
		final Voluntario voluntario = this.voluntarioRepository.findOne( id );
		return voluntario;
	}
	
	public Voluntario insertVoluntario( Voluntario voluntario)
	{
		return this.voluntarioRepository.save( voluntario );
	}
	
	public Voluntario updateVoluntario( Voluntario voluntario)
	{
		Assert.notNull( voluntario );

		return this.voluntarioRepository.save( voluntario );
	}
	
	
	public void removeVoluntario(  Long voluntarioId)
	{
		this.voluntarioRepository.delete( voluntarioId );
	}
	
	
	public Page<Voluntario> listByFilters( String filter, PageRequest page ){
		
		return this.voluntarioRepository.listByFilters( filter, page );
		
	}
	
}
