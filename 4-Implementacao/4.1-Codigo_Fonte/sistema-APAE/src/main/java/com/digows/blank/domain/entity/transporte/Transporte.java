/**
 * 
 */
package com.digows.blank.domain.entity.transporte;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.directwebremoting.annotations.DataTransferObject;
import org.hibernate.envers.Audited;

import br.com.eits.common.domain.entity.AbstractEntity;

/**
 * @author lucas
 *
 */

@Entity
@Audited
@Table(name = "\"transporte\"")
@DataTransferObject(javascript = "Transporte")
public class Transporte extends AbstractEntity implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6344256821427396517L;

	@Column(length = 100)
	private String nome;

	@Column(length = 100)
	private String telefone;
	
	@Column(length = 100)
	private TipoTransporte tipoTransporte;

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
	 * @return the telefone
	 */
	public String getTelefone()
	{
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone( String telefone )
	{
		this.telefone = telefone;
	}

	/**
	 * @return the tipoTransporte
	 */
	public TipoTransporte getTipoTransporte()
	{
		return tipoTransporte;
	}

	/**
	 * @param tipoTransporte the tipoTransporte to set
	 */
	public void setTipoTransporte( TipoTransporte tipoTransporte )
	{
		this.tipoTransporte = tipoTransporte;
	}
	
	
	
	
}
