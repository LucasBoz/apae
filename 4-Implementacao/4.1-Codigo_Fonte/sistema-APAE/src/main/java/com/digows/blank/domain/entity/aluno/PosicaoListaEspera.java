/**
 * 
 */
package com.digows.blank.domain.entity.aluno;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
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
@DataTransferObject(javascript = "PosicaoListaEspera")
public class PosicaoListaEspera extends AbstractEntity implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -631150713580225096L;


	@Column(length = 10)
	private Integer posicao;
	

	@Column(length = 10)
	private Calendar dataAvaliacao;
	

	@Column(length = 10)
	private Turma turma;
	
	@OneToOne
	private Aluno aluno;


	/**
	 * @return the aluno
	 */
	public Aluno getAluno()
	{
		return aluno;
	}


	/**
	 * @param aluno the aluno to set
	 */
	public void setAluno( Aluno aluno )
	{
		this.aluno = aluno;
	}


	/**
	 * @return the posicao
	 */
	public Integer getPosicao()
	{
		return posicao;
	}


	/**
	 * @param posicao the posicao to set
	 */
	public void setPosicao( Integer posicao )
	{
		this.posicao = posicao;
	}


	/**
	 * @return the dataAvaliacao
	 */
	public Calendar getDataAvaliacao()
	{
		return dataAvaliacao;
	}


	/**
	 * @param dataAvaliacao the dataAvaliacao to set
	 */
	public void setDataAvaliacao( Calendar dataAvaliacao )
	{
		this.dataAvaliacao = dataAvaliacao;
	}


	/**
	 * @return the turma
	 */
	public Turma getTurma()
	{
		return turma;
	}


	/**
	 * @param turma the turma to set
	 */
	public void setTurma( Turma turma )
	{
		this.turma = turma;
	}
	

}
