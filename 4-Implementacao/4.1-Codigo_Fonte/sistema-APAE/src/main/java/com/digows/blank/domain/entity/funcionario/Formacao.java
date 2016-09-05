/**
 * 
 */
package com.digows.blank.domain.entity.funcionario;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
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
@DataTransferObject(javascript = "Formacao")
public class Formacao extends AbstractEntity implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2066038205201878180L;


	@Column(length = 100)
	private String area;

	@Column(length = 100)
	private String codigo;

	@Column(length = 100)
	private Boolean formacaoPedagoga;

	@Column(length = 100)
	private Integer anoInicio;

	@Column(length = 100)
	private Integer anoConclusao;

	@Column(length = 100)
	private String nomeInstituicao;

	@Column(length = 100)
	private Situacao situacao;

	@Column(length = 100)
	private TipoInstituicao tipoInstituicao;

	/**
	 * @return the area
	 */
	public String getArea()
	{
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea( String area )
	{
		this.area = area;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo()
	{
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo( String codigo )
	{
		this.codigo = codigo;
	}

	/**
	 * @return the formacaoPedagoga
	 */
	public Boolean getFormacaoPedagoga()
	{
		return formacaoPedagoga;
	}

	/**
	 * @param formacaoPedagoga the formacaoPedagoga to set
	 */
	public void setFormacaoPedagoga( Boolean formacaoPedagoga )
	{
		this.formacaoPedagoga = formacaoPedagoga;
	}

	/**
	 * @return the anoInicio
	 */
	public Integer getAnoInicio()
	{
		return anoInicio;
	}

	/**
	 * @param anoInicio the anoInicio to set
	 */
	public void setAnoInicio( Integer anoInicio )
	{
		this.anoInicio = anoInicio;
	}

	/**
	 * @return the anoConclusao
	 */
	public Integer getAnoConclusao()
	{
		return anoConclusao;
	}

	/**
	 * @param anoConclusao the anoConclusao to set
	 */
	public void setAnoConclusao( Integer anoConclusao )
	{
		this.anoConclusao = anoConclusao;
	}

	/**
	 * @return the nomeInstituicao
	 */
	public String getNomeInstituicao()
	{
		return nomeInstituicao;
	}

	/**
	 * @param nomeInstituicao the nomeInstituicao to set
	 */
	public void setNomeInstituicao( String nomeInstituicao )
	{
		this.nomeInstituicao = nomeInstituicao;
	}

	/**
	 * @return the situacao
	 */
	public Situacao getSituacao()
	{
		return situacao;
	}

	/**
	 * @param situacao the situacao to set
	 */
	public void setSituacao( Situacao situacao )
	{
		this.situacao = situacao;
	}

	/**
	 * @return the tipoInstituicao
	 */
	public TipoInstituicao getTipoInstituicao()
	{
		return tipoInstituicao;
	}

	/**
	 * @param tipoInstituicao the tipoInstituicao to set
	 */
	public void setTipoInstituicao( TipoInstituicao tipoInstituicao )
	{
		this.tipoInstituicao = tipoInstituicao;
	}
	
	public void isValid( TipoInstituicao tipoInstituicao )
	{
		
	}
	
}
