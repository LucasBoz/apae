/**
 * 
 */
package com.digows.blank.domain.service.funcionario;

import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.digows.blank.domain.entity.funcionario.Funcionario;
import com.digows.blank.domain.repository.funcionario.IFuncionarioRepository;

/**
 * @author lucas
 *
 */
@Service
@RemoteProxy
@Transactional
public class FuncionarioService
{

	@Autowired
	private IFuncionarioRepository funcionarioRepository;

	@Transactional(readOnly=true)
	public Funcionario findFuncionarioById( Long id )
	{
		final Funcionario funcionario = this.funcionarioRepository.findOne( id );
		return funcionario;
	}
	
	public Funcionario insertFuncionario( Funcionario funcionario)
	{
//		Assert.notNull( funcionario );

//		funcionario.isValid();

		return this.funcionarioRepository.save( funcionario );
	}
	
	public Funcionario updateFuncionario( Funcionario funcionario)
	{
		Assert.notNull( funcionario );

		funcionario.isValid();

		return this.funcionarioRepository.save( funcionario );
	}
	
	
	public void removeFuncionario(  Long funcionarioId)
	{
		this.funcionarioRepository.delete( funcionarioId );
	}
	
}
