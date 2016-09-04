/**
 * 
 */
package com.digows.blank.domain.entity.aluno;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;

import org.directwebremoting.annotations.DataTransferObject;
import org.hibernate.envers.Audited;

import br.com.eits.common.domain.entity.AbstractEntity;

/**
 * @author lucas
 *
 */
@Entity
@Audited
@DataTransferObject(javascript = "Medida")
public class Medida extends AbstractEntity implements Serializable


{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8672440319599823838L;

	private float peso;
	
	private float altura;
	
	private Calendar dataMedicao;

	/**
	 * @return the peso
	 */
	public float getPeso()
	{
		return peso;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso( float peso )
	{
		this.peso = peso;
	}

	/**
	 * @return the altura
	 */
	public float getAltura()
	{
		return altura;
	}

	/**
	 * @param altura the altura to set
	 */
	public void setAltura( float altura )
	{
		this.altura = altura;
	}

	/**
	 * @return the dataMedicao
	 */
	public Calendar getDataMedicao()
	{
		return dataMedicao;
	}

	/**
	 * @param dataMedicao the dataMedicao to set
	 */
	public void setDataMedicao( Calendar dataMedicao )
	{
		this.dataMedicao = dataMedicao;
	}

	
	
}
