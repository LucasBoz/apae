package com.digows.blank.domain.entity.aluno;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.directwebremoting.annotations.DataTransferObject;
import org.hibernate.envers.Audited;

import com.digows.blank.domain.entity.pessoa.Pessoa;
import com.digows.blank.domain.entity.responsavel.Familiar;
import com.digows.blank.domain.entity.transporte.Transporte;

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
public class Aluno extends Pessoa implements Serializable
{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 8789400292156676536L;

	/*-------------------------------------------------------------------
	 *				 		     ATTRIBUTES
	 *-------------------------------------------------------------------*/

	
	@Column(length = 100)
	private String naturalidade;
	
	@Column(length = 100)
	private String sereCgm;
	
	@Column(length = 100)
	private String sus;

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
	
	@OneToMany( fetch = FetchType.EAGER, cascade= CascadeType.ALL )
	@JoinColumn(name="aluno_id")
	private List<Irmao> irmaos;
	
	@OneToMany( fetch = FetchType.EAGER, cascade= CascadeType.ALL )
	@JoinColumn(name="aluno_id")
	private List<Medida> medidas;
	
	@OneToMany( fetch = FetchType.EAGER, cascade= CascadeType.ALL )
	@JoinColumn(name="aluno_id")
	private Set<Familiar> familiares;
	
	
	
	@ManyToOne
	private Transporte transporte;

	@OneToOne
	private PosicaoListaEspera posicaoListaEspera;


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
		
	}


	/*-------------------------------------------------------------------
	 *						GETTERS AND SETTERS
	 *-------------------------------------------------------------------*/

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
	 * @return the medidas
	 */
	public List<Medida> getMedidas()
	{
		return medidas;
	}

	/**
	 * @param medidas the medidas to set
	 */
	public void setMedidas( List<Medida> medidas )
	{
		this.medidas = medidas;
	}



	/**
	 * @return the familiares
	 */
	public Set<Familiar> getFamiliares()
	{
		return familiares;
	}

	/**
	 * @param familiares the familiares to set
	 */
	public void setFamiliares( Set<Familiar> familiares )
	{
		this.familiares = familiares;
	}

	/**
	 * @param sus the sus to set
	 */
	public void setSus( String sus )
	{
		this.sus = sus;
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
	 * @return the irmaos
	 */
	public List<Irmao> getIrmaos()
	{
		return irmaos;
	}

	/**
	 * @param irmaos the irmaos to set
	 */
	public void setIrmaos( List<Irmao> irmaos )
	{
		this.irmaos = irmaos;
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
	 * @return the posicaoListaEspera
	 */
	public PosicaoListaEspera getPosicaoListaEspera()
	{
		return posicaoListaEspera;
	}

	/**
	 * @param posicaoListaEspera the posicaoListaEspera to set
	 */
	public void setPosicaoListaEspera( PosicaoListaEspera posicaoListaEspera )
	{
		this.posicaoListaEspera = posicaoListaEspera;
	}

	
	/*-------------------------------------------------------------------
	 *							BEHAVIORS
	 *-------------------------------------------------------------------*/
	
	
	public void isValid()
	{
//		Assert.isTrue( !this.getNome().isEmpty(), "Digite o nome do aluno");
	}

	
	
	
}