/**
 * 
 */
package com.digows.blank.domain.service.funcionario;

import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.digows.blank.domain.entity.funcionario.Formacao;
import com.digows.blank.domain.repository.funcionario.IFormacaoRepository;


/**
 * @author lucas
 *
 */
@Service
@RemoteProxy
@Transactional
public class FormacaoService
{

	@Autowired
	private IFormacaoRepository formacaoRepository;

	@Transactional(readOnly=true)
	public Formacao findFormacaoById( Long id )
	{
		final Formacao formacao = this.formacaoRepository.findOne( id );
		return formacao;
	}
	
	public Formacao insertFormacao( Formacao formacao)
	{

		return this.formacaoRepository.save( formacao );
	}
	
	public Formacao updateFormacao( Formacao formacao)
	{
		Assert.notNull( formacao );

//		formacao.isValid();

		return this.formacaoRepository.save( formacao );
	}
	
	
	public void removeFormacao(  Long formacaoId)
	{
		this.formacaoRepository.delete( formacaoId );
	}
	
}
