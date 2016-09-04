package com.digows.blank.domain.entity.aluno;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.directwebremoting.annotations.DataTransferObject;
import org.hibernate.envers.Audited;

import com.digows.blank.domain.entity.pessoa.Pessoa;
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
	
	@OneToMany
	private List<Irmao> irmao;
	
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
	 * 
	 * @param id
	 * @param name
	 * @param email
	 * @param enabled
	 */

	
	/*-------------------------------------------------------------------
	 *							BEHAVIORS
	 *-------------------------------------------------------------------*/
	
	
	public void isValid()
	{
//		Assert.isTrue( !this.getNome().isEmpty(), "Digite o nome do aluno");
	}
	
	
}