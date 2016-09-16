/**
 * 
 */
package com.digows.blank.domain.service.tecnico;

import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.digows.blank.domain.entity.tecnico.AreaAtendimento;
import com.digows.blank.domain.repository.funcionario.IAreaAtendimentoRepository;

/**
 * @author lucas
 *
 */
@Service
@RemoteProxy
@Transactional
public class AreaAtendimentoService
{

	@Autowired
	private IAreaAtendimentoRepository areaAtendimentoRepository;

	@Transactional(readOnly=true)
	public AreaAtendimento findAreaAtendimentoById( Long id )
	{
		final AreaAtendimento areaAtendimento = this.areaAtendimentoRepository.findOne( id );
		return areaAtendimento;
	}
	
	public AreaAtendimento insertAreaAtendimento( AreaAtendimento areaAtendimento)
	{
		Assert.notNull( areaAtendimento );

		return this.areaAtendimentoRepository.save( areaAtendimento );
	}
	
	public AreaAtendimento updateAreaAtendimento( AreaAtendimento areaAtendimento)
	{
		Assert.notNull( areaAtendimento );

		return this.areaAtendimentoRepository.save( areaAtendimento );
	}
	
	
	public void removeAreaAtendimento(  Long areaAtendimentoId)
	{
		this.areaAtendimentoRepository.delete( areaAtendimentoId );
	}
	
	
	public Page<AreaAtendimento> listAreaAtendimentosByFilters( String filter, PageRequest page ){
		
		return this.areaAtendimentoRepository.listByFilters( filter, page );
		
	}
	
}
