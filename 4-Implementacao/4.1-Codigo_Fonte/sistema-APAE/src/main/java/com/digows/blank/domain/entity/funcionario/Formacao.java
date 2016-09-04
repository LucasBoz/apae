/**
 * 
 */
package com.digows.blank.domain.entity.funcionario;

import java.io.Serializable;
import java.util.Calendar;

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

	
	private String area;
	
	private String codigo;
	
	private Boolean formacaoPedagoga;
	
	private Calendar anoInicio;
	
	private Calendar anoConclusao;
	
	private String nomeInstituicao;
	
	private Situacao situacao;
	
	private TipoInstituicao tipoInstituicao;
	
	
	
}
