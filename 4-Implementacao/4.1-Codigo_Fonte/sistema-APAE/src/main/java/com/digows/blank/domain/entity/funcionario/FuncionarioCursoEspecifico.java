/**
 * 
 */
package com.digows.blank.domain.entity.funcionario;

import javax.persistence.ManyToOne;

/**
 * @author lucas
 *
 */
public class FuncionarioCursoEspecifico
{

	@ManyToOne
	private Funcionario funcionario;
	
	@ManyToOne 
	private CursosEspecificos cursosEspecificos;
	
}
