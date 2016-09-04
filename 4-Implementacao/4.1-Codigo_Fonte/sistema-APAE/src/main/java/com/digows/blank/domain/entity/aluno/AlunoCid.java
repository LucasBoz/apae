/**
 * 
 */
package com.digows.blank.domain.entity.aluno;

import java.io.Serializable;

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
@DataTransferObject(javascript = "AlunoCid")
public class AlunoCid extends AbstractEntity implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4994296439058453549L;
	
	@ManyToOne
	private Aluno aluno;
	
	@ManyToOne
	private Cid cid;

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
	
	

}
