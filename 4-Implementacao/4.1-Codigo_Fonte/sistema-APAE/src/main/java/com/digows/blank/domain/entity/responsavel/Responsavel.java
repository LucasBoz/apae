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

import br.com.eits.common.domain.entity.AbstractEntity;

/**
 * @author lucas
 *
 */

@Entity
@Audited
@Table(name = "\"responsavel\"")
@DataTransferObject ( javascript = "Responsavel" )
public class Responsavel extends AbstractEntity implements Serializable
{
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
	
	public Responsavel( String nome, String rg, String cpf, String localTrabalho, String telefone )
	{
		super();
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.localTrabalho = localTrabalho;
		this.telefone = telefone;
	}

	@Column(nullable = false, length = 100)
	private String nome;
	
	@Column( length = 11 )
	private String rg;
	
	@Column( length = 11 )
	private String cpf;
	
	@Column(length = 100)
	private String localTrabalho;
	
	@Column(nullable = false, length = 50)
	private String telefone;
	
//	Getters and setters

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
	
	
	

}
