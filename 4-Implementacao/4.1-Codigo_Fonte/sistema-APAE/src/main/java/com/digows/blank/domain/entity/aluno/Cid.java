/**
 * 
 */
package com.digows.blank.domain.entity.aluno;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.directwebremoting.annotations.DataTransferObject;
import org.hibernate.envers.Audited;

import br.com.eits.common.domain.entity.AbstractEntity;

/**
 * @author lucas
 *
 */

@Entity
@Audited
@Table(name = "\"cid10\"")
@DataTransferObject(javascript = "Cid")
public class Cid  extends AbstractEntity
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7067237191070868263L;
	
	@Column(length = 4)
	private String cid10;
	@Column(length = 1)
	private Character opc;
	@Column(length = 1)
	private Character cat;
	@Column(length = 1)
	private Character subCat;
	@Column(length = 50)
	private Character descr;
	@Column(length = 1)
	private Character restrsexo;
	@Column(length = 1)
	private Boolean ativo;
	/**
	 * @return the cid10
	 */
	public String getCid10()
	{
		return cid10;
	}
	/**
	 * @param cid10 the cid10 to set
	 */
	public void setCid10( String cid10 )
	{
		this.cid10 = cid10;
	}
	/**
	 * @return the opc
	 */
	public Character getOpc()
	{
		return opc;
	}
	/**
	 * @param opc the opc to set
	 */
	public void setOpc( Character opc )
	{
		this.opc = opc;
	}
	/**
	 * @return the cat
	 */
	public Character getCat()
	{
		return cat;
	}
	/**
	 * @param cat the cat to set
	 */
	public void setCat( Character cat )
	{
		this.cat = cat;
	}
	/**
	 * @return the subCat
	 */
	public Character getSubCat()
	{
		return subCat;
	}
	/**
	 * @param subCat the subCat to set
	 */
	public void setSubCat( Character subCat )
	{
		this.subCat = subCat;
	}
	/**
	 * @return the descr
	 */
	public Character getDescr()
	{
		return descr;
	}
	/**
	 * @param descr the descr to set
	 */
	public void setDescr( Character descr )
	{
		this.descr = descr;
	}
	/**
	 * @return the restrsexo
	 */
	public Character getRestrsexo()
	{
		return restrsexo;
	}
	/**
	 * @param restrsexo the restrsexo to set
	 */
	public void setRestrsexo( Character restrsexo )
	{
		this.restrsexo = restrsexo;
	}
	/**
	 * @return the ativo
	 */
	public Boolean getAtivo()
	{
		return ativo;
	}
	/**
	 * @param ativo the ativo to set
	 */
	public void setAtivo( Boolean ativo )
	{
		this.ativo = ativo;
	}
	
	
	
	
}
