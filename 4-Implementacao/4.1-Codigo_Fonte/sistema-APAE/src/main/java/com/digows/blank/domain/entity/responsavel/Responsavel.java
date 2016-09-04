/**
 * 
 */
package com.digows.blank.domain.entity.responsavel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.directwebremoting.annotations.DataTransferObject;
import org.hibernate.envers.Audited;
import org.springframework.util.Assert;

import com.digows.blank.domain.entity.pessoa.Pessoa;

/**
 * @author lucas
 *
 */

@Entity
@Audited
@Table(name = "\"responsavel\"")
@DataTransferObject ( javascript = "Responsavel" )
public class Responsavel extends Pessoa implements Serializable
{
	/**
	 * @return the localTrabalho
	 */
	public String getLocalTrabalho()
	{
		return localTrabalho;
	}


	/**
	 * @param localTrabalho the localTrabalho to set
	 */
	public void setLocalTrabalho( String localTrabalho )
	{
		this.localTrabalho = localTrabalho;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = -7320428318108226729L;
	
	

	/**
	 * @param nome
	 * @param rg
	 * @param cpf
	 * @param localTrabalho
	 * @param telefone
	 */
	
	public Responsavel(){
		super();
	}


	
	@Column(length = 100)
	private String localTrabalho;

	
//	Getters and setters

	/**
	 * @return the nome
	 */

	
	public void isValid()
	{
		Assert.isTrue( !this.getNome().isEmpty(), "Digite o nome do responsável");
		
	}
	
	
	

}
