/**
 * 
 */
package com.digows.blank.domain.entity.funcionario;

import org.directwebremoting.annotations.DataTransferObject;

/**
 * @author lucas
 *
 */
@DataTransferObject(type="enum")
public enum Situacao
{
	CONCLUIDO, 
	EM_ANDAMENTO
}
