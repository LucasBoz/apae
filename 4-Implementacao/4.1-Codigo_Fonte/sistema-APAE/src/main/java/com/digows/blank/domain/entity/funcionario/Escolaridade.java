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
public enum Escolaridade
{
	FUNDAMENTAL_INCOMPLETO, 
	FUNDAMENTAL_COMPLETO,
	ENSINO_MEDIO_MAGISTERIO,
	ENSINO_MEDIO_MAGISTERIO_INDIGENA,
	ENSINO_MEDIO,
	SUPERIOR	
}
