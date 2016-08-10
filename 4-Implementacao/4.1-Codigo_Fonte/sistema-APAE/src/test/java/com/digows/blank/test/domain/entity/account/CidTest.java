/**
 * 
 */
package com.digows.blank.test.domain.entity.account;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.test.context.support.WithUserDetails;

import com.digows.blank.domain.entity.aluno.Cid;
import com.digows.blank.domain.service.aluno.CidService;
import com.digows.blank.test.domain.AbstractIntegrationTests;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;


/**
 * @author lucas
 *
 */
public class CidTest extends AbstractIntegrationTests
{
	
	@Autowired
	private CidService cidService;

	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value = {
			"/dataset/CidDataSet.xml"
	})
	public void updateCidMustPass()
	{
		
		Cid cid = cidService.findCidById( 1L );
		
		cid.setDefinicao( "definicao" );
		
		cid = cidService.findCidById( 1L );
		
		cidService.updateCid( cid );

		Assert.assertEquals( cid.getDefinicao(), "definicao");

	}
	
	
	@Test(expected=IllegalArgumentException.class)
	@WithUserDetails("admin@email.com")
	@DatabaseSetup(type = DatabaseOperation.INSERT, value = {
			"/dataset/account/UserDataSet.xml"
	})
	public void updateCidMustFail()
	{
		Cid cid = new Cid();
		
		cidService.updateCid( cid );
		
		Assert.fail("Deveria falhar pois não tem id");

	}
	
	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value = {
			"/dataset/CidDataSet.xml"
	})
	public void listCidMustPast()
	{
		
		Page<Cid> cids = cidService.listCidsByFilters( null, null );

		Assert.assertTrue( cids.getContent().isEmpty() );
	
	}
	
	@Test
	public void listCidMustFail()
	{
		
		Page<Cid> cids = cidService.listCidsByFilters( null, null );

		Assert.assertTrue( cids.getContent().isEmpty() );
	
	}
	
	
}
