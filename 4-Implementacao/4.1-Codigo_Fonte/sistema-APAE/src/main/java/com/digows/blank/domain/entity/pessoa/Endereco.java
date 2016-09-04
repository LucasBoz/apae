/**
 * 
 */
package com.digows.blank.domain.entity.pessoa;

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
@DataTransferObject(javascript = "Endereco")
public class Endereco extends AbstractEntity implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2938411568279757352L;

	@Column(length = 100)
	private String bairro;
	
	@Column(length = 100)
	private String logradouro;
	
	@Column(length = 20)
	private String cep;
	
	@Column(length = 50)
	private String numero;
	
	@Column(length = 100)
	private String complemento;
	
	@Column(length = 2)
	private String uf;
	
	@Column(length = 100)
	private String municipio;

	/**
	 * @return the bairro
	 */
	public String getBairro()
	{
		return bairro;
	}

	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro( String bairro )
	{
		this.bairro = bairro;
	}

	/**
	 * @return the logradouro
	 */
	public String getLogradouro()
	{
		return logradouro;
	}

	/**
	 * @param logradouro the logradouro to set
	 */
	public void setLogradouro( String logradouro )
	{
		this.logradouro = logradouro;
	}

	/**
	 * @return the cep
	 */
	public String getCep()
	{
		return cep;
	}

	/**
	 * @param cep the cep to set
	 */
	public void setCep( String cep )
	{
		this.cep = cep;
	}

	/**
	 * @return the numero
	 */
	public String getNumero()
	{
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero( String numero )
	{
		this.numero = numero;
	}

	/**
	 * @return the complemento
	 */
	public String getComplemento()
	{
		return complemento;
	}

	/**
	 * @param complemento the complemento to set
	 */
	public void setComplemento( String complemento )
	{
		this.complemento = complemento;
	}

	/**
	 * @return the uf
	 */
	public String getUf()
	{
		return uf;
	}

	/**
	 * @param uf the uf to set
	 */
	public void setUf( String uf )
	{
		this.uf = uf;
	}

	/**
	 * @return the municipio
	 */
	public String getMunicipio()
	{
		return municipio;
	}

	/**
	 * @param municipio the municipio to set
	 */
	public void setMunicipio( String municipio )
	{
		this.municipio = municipio;
	}

	
}
