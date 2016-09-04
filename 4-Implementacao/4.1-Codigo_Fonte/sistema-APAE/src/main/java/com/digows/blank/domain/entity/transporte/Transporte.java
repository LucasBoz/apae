/**
 * 
 */
package com.digows.blank.domain.entity.transporte;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.directwebremoting.annotations.DataTransferObject;
import org.hibernate.envers.Audited;
import org.springframework.util.Assert;

import com.digows.blank.domain.entity.pessoa.Pessoa;

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
	
	@OneToOne
	private Motorista motorista;
	
	@OneToOne
	private Motorista comissario;
	
	@Column(length = 20)
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

	/**
	 * @param telefone the telefone to set
	 */


	
	public void isValid()
	{
		Assert.isTrue( !this.getNome().isEmpty(), "Digite o nome do transporte");		
	}
	
	
}
