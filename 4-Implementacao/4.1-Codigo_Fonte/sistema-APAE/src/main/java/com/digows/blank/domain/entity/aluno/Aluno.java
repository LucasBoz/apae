package com.digows.blank.domain.entity.aluno;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.directwebremoting.annotations.DataTransferObject;
import org.hibernate.envers.Audited;

import com.digows.blank.domain.entity.responsavel.Responsavel;
import com.digows.blank.domain.entity.transporte.Transporte;

import br.com.eits.common.domain.entity.AbstractEntity;

/**
 * 
 * @since 02/06/2014
 * @version 1.0
 * @category
 */
@Entity
@Audited
@Table(name = "\"aluno\"")
@DataTransferObject(javascript = "Aluno")
public class Aluno extends AbstractEntity implements Serializable
{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 8789400292156676536L;

	/*-------------------------------------------------------------------
	 *				 		     ATTRIBUTES
	 *-------------------------------------------------------------------*/


	@Column(length = 100)
	private String matricula;
	@Column(length = 100)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataMatricula;
	@Column(length = 100)
	private String nome;
	@Column(length = 100)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataNacimento;
	@Column(length = 100)
	private String naturalidade;
	@Column(length = 1)
	private Character sexo;
	@Column(length = 100)
	private String sereCgm;
	@Column(length = 100)
	private String sus;
	@Column(length = 100)
	private String endereco;
	@Column(length = 100)
	private String bairro;
	@Column(length = 8)
	private String cep;
	@Column(length = 100)
	private String telefone;
	@Column(length = 100)
	private String certidaoNacimento;
	@Column(length = 100)
	private String livro;
	@Column(length = 100)
	private String folha;
	@Column(length = 100)
	private String rg;
	@Column(length = 100)
	private String cpf;
	@Column(length = 100)
	private String bpc;
	@Column(length = 100)
	private String beneficio;
	@Column(length = 100)
	private Boolean autorizacaoIrSozinho;
	@Column(length = 100)
	private Boolean bolsaFamilia;
	@Column(length = 100)
	private String alergia;
	
	@ManyToOne
	private Cid cid;
	
	@ManyToOne
	private Transporte transporte;

	@ManyToMany
	private Set<Responsavel> responsavel;
	


	/*-------------------------------------------------------------------
	 * 		 					CONSTRUCTORS
	 *-------------------------------------------------------------------*/
	/**
	 * 
	 */
	public Aluno()
	{
	}

	/**
	 * 
	 * @param id
	 */
	public Aluno( Long id )
	{
		super( id );
	}


	/*-------------------------------------------------------------------
	 *						GETTERS AND SETTERS
	 *-------------------------------------------------------------------*/

	/**
	 * @return the matricula
	 */
	public String getMatricula()
	{
		return matricula;
	}

	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula( String matricula )
	{
		this.matricula = matricula;
	}

	/**
	 * @return the dataMatricula
	 */
	public Calendar getDataMatricula()
	{
		return dataMatricula;
	}

	/**
	 * @param dataMatricula the dataMatricula to set
	 */
	public void setDataMatricula( Calendar dataMatricula )
	{
		this.dataMatricula = dataMatricula;
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
	 * @return the dataNacimento
	 */
	public Calendar getDataNacimento()
	{
		return dataNacimento;
	}

	/**
	 * @param dataNacimento the dataNacimento to set
	 */
	public void setDataNacimento( Calendar dataNacimento )
	{
		this.dataNacimento = dataNacimento;
	}

	/**
	 * @return the naturalidade
	 */
	public String getNaturalidade()
	{
		return naturalidade;
	}

	/**
	 * @param naturalidade the naturalidade to set
	 */
	public void setNaturalidade( String naturalidade )
	{
		this.naturalidade = naturalidade;
	}

	/**
	 * @return the sexo
	 */
	public Character getSexo()
	{
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo( Character sexo )
	{
		this.sexo = sexo;
	}

	/**
	 * @return the sereCgm
	 */
	public String getSereCgm()
	{
		return sereCgm;
	}

	/**
	 * @param sereCgm the sereCgm to set
	 */
	public void setSereCgm( String sereCgm )
	{
		this.sereCgm = sereCgm;
	}

	/**
	 * @return the sus
	 */
	public String getSus()
	{
		return sus;
	}

	/**
	 * @param sus the sus to set
	 */
	public void setSus( String sus )
	{
		this.sus = sus;
	}

	/**
	 * @return the endereco
	 */
	public String getEndereco()
	{
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco( String endereco )
	{
		this.endereco = endereco;
	}

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
	 * @return the certidaoNacimento
	 */
	public String getCertidaoNacimento()
	{
		return certidaoNacimento;
	}

	/**
	 * @param certidaoNacimento the certidaoNacimento to set
	 */
	public void setCertidaoNacimento( String certidaoNacimento )
	{
		this.certidaoNacimento = certidaoNacimento;
	}

	/**
	 * @return the livro
	 */
	public String getLivro()
	{
		return livro;
	}

	/**
	 * @param livro the livro to set
	 */
	public void setLivro( String livro )
	{
		this.livro = livro;
	}

	/**
	 * @return the folha
	 */
	public String getFolha()
	{
		return folha;
	}

	/**
	 * @param folha the folha to set
	 */
	public void setFolha( String folha )
	{
		this.folha = folha;
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
	 * @return the bpc
	 */
	public String getBpc()
	{
		return bpc;
	}

	/**
	 * @param bpc the bpc to set
	 */
	public void setBpc( String bpc )
	{
		this.bpc = bpc;
	}

	/**
	 * @return the beneficio
	 */
	public String getBeneficio()
	{
		return beneficio;
	}

	/**
	 * @param beneficio the beneficio to set
	 */
	public void setBeneficio( String beneficio )
	{
		this.beneficio = beneficio;
	}

	/**
	 * @return the autorizacaoIrSozinho
	 */
	public Boolean getAutorizacaoIrSozinho()
	{
		return autorizacaoIrSozinho;
	}

	/**
	 * @param autorizacaoIrSozinho the autorizacaoIrSozinho to set
	 */
	public void setAutorizacaoIrSozinho( Boolean autorizacaoIrSozinho )
	{
		this.autorizacaoIrSozinho = autorizacaoIrSozinho;
	}

	/**
	 * @return the bolsaFamilia
	 */
	public Boolean getBolsaFamilia()
	{
		return bolsaFamilia;
	}

	/**
	 * @param bolsaFamilia the bolsaFamilia to set
	 */
	public void setBolsaFamilia( Boolean bolsaFamilia )
	{
		this.bolsaFamilia = bolsaFamilia;
	}

	/**
	 * @return the alergia
	 */
	public String getAlergia()
	{
		return alergia;
	}

	/**
	 * @param alergia the alergia to set
	 */
	public void setAlergia( String alergia )
	{
		this.alergia = alergia;
	}

	/**
	 * @return the cid
	 */
	public Cid getCid()
	{
		return cid;
	}

	/**
	 * @param cid the cid to set
	 */
	public void setCid( Cid cid )
	{
		this.cid = cid;
	}

	/**
	 * @return the transporte
	 */
	public Transporte getTransporte()
	{
		return transporte;
	}

	/**
	 * @param transporte the transporte to set
	 */
	public void setTransporte( Transporte transporte )
	{
		this.transporte = transporte;
	}

	/**
	 * @return the responsavel
	 */
	public Set<Responsavel> getResponsavel()
	{
		return responsavel;
	}

	/**
	 * @param responsavel the responsavel to set
	 */
	public void setResponsavel( Set<Responsavel> responsavel )
	{
		this.responsavel = responsavel;
	}



	
	/**
	 * 
	 * @param id
	 * @param name
	 * @param email
	 * @param enabled
	 */

	
	/*-------------------------------------------------------------------
	 *							BEHAVIORS
	 *-------------------------------------------------------------------*/
	
	
	
}