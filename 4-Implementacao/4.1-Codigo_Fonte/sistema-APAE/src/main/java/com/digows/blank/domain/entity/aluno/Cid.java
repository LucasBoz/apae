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
	
	@Column(length = 100)
	private String cid10;
	
	@Column(length = 100, name="cat")
	private String categoria;
	
	@Column(length = 100, name="subcat")
	private String subcategoria;
	
	@Column(length = 50, name="descr")
	private String descricao;
	
	@Column(length = 100)
	private String definicao;
	
	@Column(length = 10, name="restsexo")
	private String restricaoSexo;
	
	@Column(length = 20)
	private Boolean ativo;

	
	
	/**
	 * 
	 */
	public Cid()
	{
		super();
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
	 * @return the categoria
	 */
	public String getCategoria()
	{
		return categoria;
	}



	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria( String categoria )
	{
		this.categoria = categoria;
	}



	/**
	 * @return the subcategoria
	 */
	public String getSubcategoria()
	{
		return subcategoria;
	}



	/**
	 * @param subcategoria the subcategoria to set
	 */
	public void setSubcategoria( String subcategoria )
	{
		this.subcategoria = subcategoria;
	}



	/**
	 * @return the descricao
	 */
	public String getDescricao()
	{
		return descricao;
	}



	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao( String descricao )
	{
		this.descricao = descricao;
	}



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
	 * @return the restricaoSexo
	 */
	public String getRestricaoSexo()
	{
		return restricaoSexo;
	}



	/**
	 * @param restricaoSexo the restricaoSexo to set
	 */
	public void setRestricaoSexo( String restricaoSexo )
	{
		this.restricaoSexo = restricaoSexo;
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
