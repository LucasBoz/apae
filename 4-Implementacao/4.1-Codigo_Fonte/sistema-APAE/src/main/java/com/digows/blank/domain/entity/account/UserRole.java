package com.digows.blank.domain.entity.account;

import org.directwebremoting.annotations.DataTransferObject;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author rodrigo.p.fraga@gmail.com
 * @since 02/06/2014
 * @version 1.0
 */
@DataTransferObject(type = "enum")
public enum UserRole implements GrantedAuthority
{
	/*-------------------------------------------------------------------
	 *				 		     ENUMS
	 *-------------------------------------------------------------------*/
	COORDENADOR, // 0
	SECRETARIA, // 1
	TECNICO; // 2

	public static final String COORDENADOR_VALUE 	= "COORDENADOR";
	public static final String SECRETARIA_VALUE 	= "SECRETARIA";
	public static final String TECNICO_VALUE 		= "TECNICO";
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.security.core.GrantedAuthority#getAuthority()
	 */
	@Override
	public String getAuthority()
	{
		return this.name();
	}
}