/**
 * 
 */
package com.digows.blank.domain.entity.funcionario;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.directwebremoting.annotations.DataTransferObject;
import org.hibernate.envers.Audited;

import com.digows.blank.domain.entity.pessoa.Endereco;
import com.digows.blank.domain.entity.pessoa.Pessoa;

/**
 * @author lucas
 *
 */

@Entity
@Audited
@DataTransferObject(javascript = "Funcionario")
public class Funcionario extends Pessoa implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4577097521894994679L;

	
	private String nomePai;
	
	private String nomeMae;
	
	private String email;
	
	private String numeroIdentificacaoSocial;

	@OneToOne
	private Endereco endereco;
	
	@OneToOne
	private Endereco localNascimento;
	

}
