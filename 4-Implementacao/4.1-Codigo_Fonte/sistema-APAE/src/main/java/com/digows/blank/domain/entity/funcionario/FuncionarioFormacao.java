/**
 * 
 */
package com.digows.blank.domain.entity.funcionario;

import javax.persistence.ManyToOne;

/**
 * @author lucas
 *
 */
public class FuncionarioFormacao
{
	
	@ManyToOne
	private Funcionario funcionario;
	
	@ManyToOne
	private Funcao funcao;

}
