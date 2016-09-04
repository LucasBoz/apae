/**
 * 
 */
package com.digows.blank.domain.entity.aluno;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.directwebremoting.annotations.DataTransferObject;
import org.hibernate.envers.Audited;

import br.com.eits.common.domain.entity.AbstractEntity;

/**
 * @author lucas
 *
 */

@Entity
@Audited
@DataTransferObject(javascript = "Irmao")
public class Irmao extends AbstractEntity implements Serializable
{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6788424252711326353L;


	@Column(length = 100)
	private String nome;
	
	@Column(length = 100)
	private Calendar dataNascimento;


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
