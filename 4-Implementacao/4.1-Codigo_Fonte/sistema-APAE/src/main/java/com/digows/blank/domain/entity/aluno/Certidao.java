/**
 * 
 */
package com.digows.blank.domain.entity.aluno;

import java.io.Serializable;

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
@DataTransferObject(javascript = "Certidao")
public class Certidao extends AbstractEntity implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2584850420364814529L;

	@Column(length = 100)
	private String numero;
	
	@Column(length = 100)
	private String livro;
	
	@Column(length = 100)
	private String folha;
	

}
