/**
 * 
 */
package com.digows.blank.test.domain.service.responsavel;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.digows.blank.domain.entity.responsavel.Responsavel;
import com.digows.blank.domain.service.aluno.ResponsavelService;
import com.digows.blank.test.domain.AbstractIntegrationTests;


/**
 * @author lucas
 *
 */
public class ResponsavelTests extends AbstractIntegrationTests
{
	@Autowired
	private ResponsavelService responsavelService;

	@Test
	public void saveResponsavelMustPass()
	{ 
		Responsavel responsavel = new Responsavel();
		
		responsavel.setLocalTrabalho( "funciona" );
		
		responsavel.setNome( "asdasukyiudilkals" );

//		responsavel.setIdteste123( 1231 );
	
		responsavelService.insertResponsavel( responsavel );
		
		Assert.assertEquals( "qwe", "qwe" );
		
	}

}
