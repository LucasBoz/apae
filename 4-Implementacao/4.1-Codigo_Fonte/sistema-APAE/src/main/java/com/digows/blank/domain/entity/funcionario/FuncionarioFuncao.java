/**
 * 
 */
package com.digows.blank.domain.entity.funcionario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.directwebremoting.annotations.DataTransferObject;
import org.hibernate.envers.Audited;

import br.com.eits.common.domain.entity.AbstractEntity;

/**
 * @author lucas
 *
 */

//@Entity
@Audited
@DataTransferObject(javascript = "FuncionarioFuncao")
public class FuncionarioFuncao extends AbstractEntity implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7461181321332745913L;
	
	@ManyToOne
	private Funcionario funcionario;
	
	@Column(length=100)
	private Funcao funcao;
	
	public FuncionarioFuncao(){
		
	}
	
	public FuncionarioFuncao( Funcionario funcionario,Funcao funcao ){
		this.setFuncionario( funcionario );
		this.setFuncao( funcao );
	}

	/**
	 * @return the funcionario
	 */
	public Funcionario getFuncionario()
	{
		return funcionario;
	}

	/**
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario( Funcionario funcionario )
	{
		this.funcionario = funcionario;
	}

	/**
	 * @return the funcao
	 */
	public Funcao getFuncao()
	{
		return funcao;
	}

	/**
	 * @param funcao the funcao to set
	 */
	public void setFuncao( Funcao funcao )
	{
		this.funcao = funcao;
	}
	
	

}
