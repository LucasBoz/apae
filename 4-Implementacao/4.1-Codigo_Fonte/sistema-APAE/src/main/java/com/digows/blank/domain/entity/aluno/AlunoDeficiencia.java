/**
 * 
 */
package com.digows.blank.domain.entity.aluno;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.directwebremoting.annotations.DataTransferObject;
import org.hibernate.envers.Audited;

import br.com.eits.common.domain.entity.AbstractEntity;

/**
 * @author lucas
 *
 */


@Entity
@Audited
@DataTransferObject(javascript = "AlunoDeficiencia")
public class AlunoDeficiencia extends AbstractEntity implements Serializable
{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5520671061574427843L;

	@ManyToOne
	private Aluno aluno;
	
	@Column
	private Deficiencia deficiencia;

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
	 * @return the deficiencia
	 */
	public Deficiencia getDeficiencia()
	{
		return deficiencia;
	}

	/**
	 * @param deficiencia the deficiencia to set
	 */
	public void setDeficiencia( Deficiencia deficiencia )
	{
		this.deficiencia = deficiencia;
	}
	
	

}
