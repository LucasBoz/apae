/**
 * 
 */
package com.digows.blank.domain.entity.pessoa;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.directwebremoting.annotations.DataTransferObject;
import org.hibernate.envers.Audited;

import br.com.eits.common.domain.entity.AbstractEntity;

/**
 * @author lucas
 *
 */


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Audited
@DataTransferObject(javascript = "Pessoa")
public class Pessoa extends AbstractEntity implements Serializable
{

	/**q
	 * 
	 */
	private static final long serialVersionUID = 1268312855760683864L;
	
	@Column(nullable = false, length = 100)
	private String nome;
	
	@Column( length = 20)
	private String rg;
	
	@Column( length = 20)
	private String cpf;
	
	@Column( length = 100)
	private Calendar dataNascimento;
	
	@Column( length = 10)
	private Sexo sexo;

	/**
	 * @return the nome
	 */
	public String getNome()
	{
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome( String nome )
	{
		this.nome = nome;
	}

	/**
	 * @return the rg
	 */
	public String getRg()
	{
		return rg;
	}

	/**
	 * @param rg the rg to set
	 */
	public void setRg( String rg )
	{
		this.rg = rg;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf()
	{
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf( String cpf )
	{
		this.cpf = cpf;
	}

	/**
	 * @return the dataNascimento
	 */
	public Calendar getDataNascimento()
	{
		return dataNascimento;
	}

	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento( Calendar dataNascimento )
	{
		this.dataNascimento = dataNascimento;
	}


	
	

}
