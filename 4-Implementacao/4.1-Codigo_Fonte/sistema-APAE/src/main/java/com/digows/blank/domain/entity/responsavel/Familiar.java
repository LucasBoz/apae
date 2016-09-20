/**
 * 
 */
package com.digows.blank.domain.entity.responsavel;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.directwebremoting.annotations.DataTransferObject;
import org.hibernate.envers.Audited;

import com.digows.blank.domain.entity.aluno.Aluno;
import com.digows.blank.domain.entity.aluno.TipoResponsavel;

import br.com.eits.common.domain.entity.AbstractEntity;

/**
 * @author lucas
 *
 */

@Entity
@Audited
@DataTransferObject(javascript = "Familiar")
public class Familiar extends AbstractEntity implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5329209234112509435L;


	@ManyToOne( fetch = FetchType.EAGER, cascade= CascadeType.PERSIST )
	private Responsavel responsavel;
	
	@Column(length=10)
	private TipoResponsavel tipoResponsavel;


	/**
	 * @return the responsavel
	 */
	public Responsavel getResponsavel()
	{
		return responsavel;
	}


	/**
	 * @param responsavel the responsavel to set
	 */
	public void setResponsavel( Responsavel responsavel )
	{
		this.responsavel = responsavel;
	}



	/**
	 * @return the tipoResponsavel
	 */
	public TipoResponsavel getTipoResponsavel()
	{
		return tipoResponsavel;
	}


	/**
	 * @param tipoResponsavel the tipoResponsavel to set
	 */
	public void setTipoResponsavel( TipoResponsavel tipoResponsavel )
	{
		this.tipoResponsavel = tipoResponsavel;
	}

	
}
