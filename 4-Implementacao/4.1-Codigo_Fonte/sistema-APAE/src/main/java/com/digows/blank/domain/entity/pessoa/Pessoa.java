/**
 * 
 */
package com.digows.blank.domain.entity.pessoa;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.directwebremoting.annotations.DataTransferObject;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.eits.common.domain.entity.AbstractEntity;

/**
 * @author lucas
 *
 */


@Entity
@Audited
@DataTransferObject(javascript = "Pessoa")
public class Pessoa extends AbstractEntity implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1268312855760683864L;
	


	@Column(nullable = false, length = 100)
	@NotEmpty( message="Nome é obrigatório" )
	private String nome;
	
	@Column( length = 20)
	private String rg;
	
	@Column( length = 20)
	private String cpf;
	
	@Column( length = 100)
	private Calendar dataNascimento;
	
	@Column( length = 10)
	private Sexo sexo;
	
	
	@OneToMany( fetch = FetchType.EAGER, cascade= CascadeType.ALL )
	@JoinColumn(name="pessoa_id")
	private List<Telefone> telefones;

	
	
	/**
	 * @return the telefones
	 */
	public List<Telefone> getTelefones()
	{
		return telefones;
	}

	/**
	 * @param telefones the telefones to set
	 */
	public void setTelefones( List<Telefone> telefones )
	{
		this.telefones = telefones;
	}

	/**
	 * @return the sexo
	 */
	public Sexo getSexo()
	{
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo( Sexo sexo )
	{
		this.sexo = sexo;
	}

	
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
