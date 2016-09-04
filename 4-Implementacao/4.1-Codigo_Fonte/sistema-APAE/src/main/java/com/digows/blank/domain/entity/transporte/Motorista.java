/**
 * 
 */
package com.digows.blank.domain.entity.transporte;

import java.io.Serializable;

import javax.persistence.Entity;

import org.directwebremoting.annotations.DataTransferObject;
import org.hibernate.envers.Audited;

import com.digows.blank.domain.entity.pessoa.Pessoa;

/**
 * @author lucas
 *
 */

@Entity
@Audited
@DataTransferObject(javascript = "Motorista")
public class Motorista extends Pessoa implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4448295236873248738L;
	
	
	public Motorista()
	{
		super();
	}

}
