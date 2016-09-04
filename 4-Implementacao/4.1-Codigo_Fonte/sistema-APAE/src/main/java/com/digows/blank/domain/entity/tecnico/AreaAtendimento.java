/**
 * 
 */
package com.digows.blank.domain.entity.tecnico;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.directwebremoting.annotations.DataTransferObject;
import org.hibernate.envers.Audited;

import br.com.eits.common.domain.entity.AbstractEntity;

/**
 * @author lucas
 *
 */


@Entity
@Audited
@DataTransferObject(javascript = "AreaAtendimento")
public class AreaAtendimento extends AbstractEntity implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2483572476162684937L;
	
	@Column(length = 100)
	private String nome;

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
	
	

}
