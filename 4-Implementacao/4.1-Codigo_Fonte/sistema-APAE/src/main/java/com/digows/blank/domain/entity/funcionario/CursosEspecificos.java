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
public enum CursosEspecificos
{
	CRECHE ("Creche"),
	PRE_ESCOLA ("Pré excola"),
	ANOS_INICIAIS_ENSINO_FUNDAMENTAL ("Anos iniciais ensino funcamental"),
	ANOS_FINAIS_ENSINO_FUNDAMENTAL ("Anos finais Ensino fundamental"),
	ENSINO_MEDIO ("Ensino medio"),
	EDUCACAO_JOVENS_ADULTOS("Ensino medio"),
	EDICACAO_ESPECIAL("Ensino medio"),
	EDUCACAO_INDIGENA("Ensino medio"),
	EDUCACAO_CAMPO("Ensino medio"),
	EDUCACAO_AMBIENTAL ("TESTE"),
	EDUCACAO_DIREITOS_HUMANOS("TESTE"),
	GENERO_DIVERSIDADE_SEXUAL("TESTE"),
	DIREITOS_CRIANCA_ADOLECENTE("TESTE"),
	RELACOES_ETNIRACIAIS("TESTE"),
	OUTROS("TESTE"),
	NENHUM ("TESTE");
	
	String value;
	

	CursosEspecificos(String value){
		this.value = value;
	}
	
	
	/**
	 * @return the value
	 */
	public String getValue()
	{
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue( String value )
	{
		this.value = value;
	}

	
}
