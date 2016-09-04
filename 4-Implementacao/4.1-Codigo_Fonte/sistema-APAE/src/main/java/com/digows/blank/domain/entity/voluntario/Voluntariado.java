/**
 * 
 */
package com.digows.blank.domain.entity.voluntario;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
@DataTransferObject(javascript = "Voluntariado")
public class Voluntariado extends AbstractEntity implements Serializable
{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7830046726537777982L;

	@Column(length = 100)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataInicio;
	
	@Column(length = 100)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataFim;
	
	@ManyToOne
	private Termo termo;
	
}
