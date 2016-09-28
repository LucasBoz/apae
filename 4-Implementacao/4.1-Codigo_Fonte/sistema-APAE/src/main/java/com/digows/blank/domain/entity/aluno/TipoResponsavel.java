/**
 * 
 */
package com.digows.blank.domain.entity.aluno;

import org.directwebremoting.annotations.DataTransferObject;

/**
 * @author lucas
 *
 */

@DataTransferObject(type="enum")
public enum TipoResponsavel
{
	PAI,
	MAE,
	TIO,
	AVO,
	OUTROS
	
}
