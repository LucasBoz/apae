/**
 * 
 */
package com.digows.blank.domain.service.funcionario;

import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.digows.blank.domain.entity.tecnico.Tecnico;
import com.digows.blank.domain.repository.funcionario.ITecnicoRepository;

/**
 * @author lucas
 *
 */
@Service
@RemoteProxy
@Transactional
public class TecnicoService
{

	@Autowired
	private ITecnicoRepository tecnicoRepository;

	@Transactional(readOnly=true)
	public Tecnico findTecnicoById( Long id )
	{
		final Tecnico tecnico = this.tecnicoRepository.findOne( id );
		return tecnico;
	}
	
	public Tecnico insertTecnico( Tecnico tecnico)
	{

		if(tecnico.getUser() != null){
			tecnico.getUser().setEnabled( true );
		}

		return this.tecnicoRepository.save( tecnico );
	}
	
	public Tecnico updateTecnico( Tecnico tecnico)
	{
		Assert.notNull( tecnico );
		
		

		return this.tecnicoRepository.save( tecnico );
	}
	
	
	public void removeTecnico(  Long tecnicoId)
	{
		this.tecnicoRepository.delete( tecnicoId );
	}
	
	
	public Page<Tecnico> listByFilters( String filter, PageRequest page ){
		
		return this.tecnicoRepository.listByFilters( filter, page );
		
	}
	
}
