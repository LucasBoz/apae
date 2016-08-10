/**
 * 
 */
package com.digows.blank.test.domain.entity.account;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.digows.blank.domain.entity.aluno.Cid;
import com.digows.blank.domain.entity.transporte.Transporte;
import com.digows.blank.domain.service.aluno.TransporteService;
import com.digows.blank.test.domain.AbstractUnitTests;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;


/**
 * @author lucas
 *
 */
public class TransporteTest extends AbstractUnitTests
{
	
	@Autowired
	private TransporteService transporteService;

	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value = {
			"/dataset/TransporteDataSet.xml"
	})
	public void updateTransporteMustPass()
	{
		
		Transporte transporte = transporteService.findTransporteById( 1L );
		


	}
	
	
	
}
