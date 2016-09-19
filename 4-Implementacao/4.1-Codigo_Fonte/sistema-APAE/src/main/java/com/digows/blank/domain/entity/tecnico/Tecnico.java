/**
 * 
 */
package com.digows.blank.domain.entity.tecnico;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.directwebremoting.annotations.DataTransferObject;
import org.hibernate.envers.Audited;

import com.digows.blank.domain.entity.account.User;
import com.digows.blank.domain.entity.funcionario.Funcionario;

/**
 * @author lucas
 *
 */
@Entity
@Audited
@DataTransferObject(javascript = "Tecnico")
public class Tecnico extends Funcionario implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8573682580595216979L;
	

	@ManyToOne
	private AreaAtendimento areaAtendimento;
	
	@OneToOne( cascade= CascadeType.REMOVE, fetch = FetchType.EAGER)
	private User user;
	
	
	/**
	 * @return the areaAtendimento
	 */
	public AreaAtendimento getAreaAtendimento()
	{
		return areaAtendimento;
	}

	/**
	 * @param areaAtendimento the areaAtendimento to set
	 */
	public void setAreaAtendimento( AreaAtendimento areaAtendimento )
	{
		this.areaAtendimento = areaAtendimento;
	}

	/**
	 * @return the user
	 */
	public User getUser()
	{
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser( User user )
	{
		this.user = user;
	}


}
