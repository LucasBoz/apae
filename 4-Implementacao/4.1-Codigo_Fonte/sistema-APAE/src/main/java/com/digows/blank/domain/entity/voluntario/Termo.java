/**
 * 
 */
package com.digows.blank.domain.entity.voluntario;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.directwebremoting.annotations.DataTransferObject;
import org.hibernate.envers.Audited;

import br.com.eits.common.domain.entity.AbstractEntity;

/**
 * @author lucas
 *
 */


@Entity
@Audited
@DataTransferObject(javascript = "Termo")
public class Termo extends AbstractEntity implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4153344284069815264L;


	@Column(length = 100)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataInicio;
	
	@Column(length = 100)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataFim;
	
	@Column(length = 100)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataGeracao;
	
	

}
