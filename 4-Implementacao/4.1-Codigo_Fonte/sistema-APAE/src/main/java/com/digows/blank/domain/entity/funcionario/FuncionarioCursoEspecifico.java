/**
 * 
 */
package com.digows.blank.domain.entity.funcionario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.directwebremoting.annotations.DataTransferObject;
import org.hibernate.envers.Audited;

import com.digows.blank.domain.entity.pessoa.Pessoa;

import br.com.eits.common.domain.entity.AbstractEntity;

/**
 * @author lucas
 *
 */

@Audited
@DataTransferObject(javascript = "FuncionarioCursoEspecifico")
public class FuncionarioCursoEspecifico extends AbstractEntity implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1595087155984837251L;

	@ManyToOne
	private Funcionario funcionario;
	
	@Column(length=100)
	private CursosEspecificos cursosEspecificos;
	
	public FuncionarioCursoEspecifico(){
		super();
	}
	
	public FuncionarioCursoEspecifico(Funcionario funcionario,CursosEspecificos cursosEspecificos){
		this.setFuncionario( funcionario );
		this.setCursosEspecificos( cursosEspecificos );
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
	 * @return the cursosEspecificos
	 */
	public CursosEspecificos getCursosEspecificos()
	{
		return cursosEspecificos;
	}

	/**
	 * @param cursosEspecificos the cursosEspecificos to set
	 */
	public void setCursosEspecificos( CursosEspecificos cursosEspecificos )
	{
		this.cursosEspecificos = cursosEspecificos;
	}
	
	
	
}
