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
public enum TipoDeficiencia
{
	BAIXA_VISAO,
	CEGUEIRA,
	AUDITIVA,
	FISICA,
	INTELECTUAL,
	SURDO,
	SURDOSEGUEIRA,
	MULTIPLA
}
