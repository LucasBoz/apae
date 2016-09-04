/**
 * 
 */
package com.digows.blank.domain.entity.voluntario;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.directwebremoting.annotations.DataTransferObject;
import org.hibernate.envers.Audited;

import com.digows.blank.domain.entity.pessoa.Pessoa;

/**
 * @author lucas
 *
 */

@Entity
@Audited
@DataTransferObject(javascript = "Voluntario")
public class Voluntario extends Pessoa implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4711938202259493374L;
	
	@OneToMany
	private List<Voluntariado> voluntariado;
	

}
