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

/**
 * @author lucas
 *
 */
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
	
	@Column(length = 123)
	private String cid10;
	
	@Column(length = 123)
	private String opc;
	
	@Column(length = 100)
	private String cat;
	
	@Column(length = 123)
	private String subcat;
	
	@Column(length = 50)
	private String descr;
	
	@Column(length = 100)
	private String definicao;
	
	@Column(length = 123)
	private String restrsexo;
	
	@Column(length = 123)
	private Boolean ativo;

	
	
	/**
	 * 
	 */
//	public Cid()
//	{
//		super();
//	}

	/**
	 * @return the definicao
	 */
	public String getDefinicao()
	{
		return definicao;
	}

	/**
	 * @param definicao the definicao to set
	 */
	public void setDefinicao( String definicao )
	{
		this.definicao = definicao;
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
	public String getOpc()
	{
		return opc;
	}

	/**
	 * @param opc the opc to set
	 */
	public void setOpc( String opc )
	{
		this.opc = opc;
	}

	/**
	 * @return the cat
	 */
	public String getCat()
	{
		return cat;
	}

	/**
	 * @param cat the cat to set
	 */
	public void setCat( String cat )
	{
		this.cat = cat;
	}

	/**
	 * @return the subcat
	 */
	public String getSubcat()
	{
		return subcat;
	}

	/**
	 * @param subcat the subcat to set
	 */
	public void setSubcat( String subcat )
	{
		this.subcat = subcat;
	}

	/**
	 * @return the descr
	 */
	public String getDescr()
	{
		return descr;
	}

	/**
	 * @param descr the descr to set
	 */
	public void setDescr( String descr )
	{
		this.descr = descr;
	}

	/**
	 * @return the restrsexo
	 */
	public String getRestrsexo()
	{
		return restrsexo;
	}

	/**
	 * @param restrsexo the restrsexo to set
	 */
	public void setRestrsexo( String restrsexo )
	{
		this.restrsexo = restrsexo;
	}

	/**
	 * @return the cid10
	 */

	
	
}
