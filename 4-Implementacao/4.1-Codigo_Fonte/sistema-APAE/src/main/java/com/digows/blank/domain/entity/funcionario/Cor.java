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
public enum Cor
{
	BRANCA, 
	PRETA, 
	PARDA, 
	AMARELA, 
	INDIGENA, 
	NAO_DECLARADA;
}
