/**
 * 
 */
package com.digows.blank.domain.entity.professor;

import java.io.Serializable;

import javax.persistence.Entity;

import org.directwebremoting.annotations.DataTransferObject;
import org.hibernate.envers.Audited;

import com.digows.blank.domain.entity.funcionario.Funcionario;

/**
 * @author lucas
 *
 */

@Entity
@Audited
@DataTransferObject(javascript = "Professor")
public class Professor extends Funcionario implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3444004686027290767L;

}
