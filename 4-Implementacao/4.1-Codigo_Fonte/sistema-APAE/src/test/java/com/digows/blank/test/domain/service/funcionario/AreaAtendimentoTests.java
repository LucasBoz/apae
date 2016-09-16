/**
 * 
 */
package com.digows.blank.test.domain.service.funcionario;

import javax.validation.ValidationException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.digows.blank.domain.entity.tecnico.AreaAtendimento;
import com.digows.blank.domain.service.tecnico.AreaAtendimentoService;
import com.digows.blank.test.domain.AbstractIntegrationTests;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;


/**
 * @author lucas
 *
 */
public class AreaAtendimentoTests extends AbstractIntegrationTests
{
	@Autowired
	private AreaAtendimentoService areaAtendimentoService;

	@Test
	public void saveAreaAtendimentoMustPass()
	{ 
		AreaAtendimento areaAtendimento = new AreaAtendimento();
	
		areaAtendimento.setNome( "Area teste" );
		
		areaAtendimento = areaAtendimentoService.insertAreaAtendimento( areaAtendimento );
		
		areaAtendimentoService.updateAreaAtendimento( areaAtendimento );
		
	}
	
	
	@Test( expected=ValidationException.class )
	public void saveAreaAtendimentoMustFail() 
	{ 
		
		AreaAtendimento areaAtendimento = new AreaAtendimento();
		
		areaAtendimento.setNome( "" );
		
		areaAtendimentoService.insertAreaAtendimento( areaAtendimento );
		
		Assert.fail();
		
	}
	
	
	
	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value = {
		"/dataset/areaAtendimento/areaAtendimentoDataSet.xml"
	})
	public void updateAreaAtendimentoMustPast() {
		
		String novoNome = "Novo nome do areaAtendimento";
		
		AreaAtendimento areaAtendimento = this.areaAtendimentoService.findAreaAtendimentoById( 1000L );
		
		areaAtendimento.setNome( novoNome );
				
		areaAtendimento = this.areaAtendimentoService.updateAreaAtendimento( areaAtendimento );
		
		Assert.assertTrue( areaAtendimento.getNome().equals( novoNome) );

	}
	
	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value = {
		"/dataset/areaAtendimento/areaAtendimentoDataSet.xml"

	})
	public void updateAreaAtendimentoMustFail() {
		
		String novoNome = "";
		
		AreaAtendimento areaAtendimento = this.areaAtendimentoService.findAreaAtendimentoById( 1000L );
		
		areaAtendimento.setNome( novoNome );
				
		areaAtendimento = this.areaAtendimentoService.updateAreaAtendimento( areaAtendimento );

		Assert.fail();
	}
	
	
	
	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value = {
		"/dataset/areaAtendimento/areaAtendimentoDataSet.xml"

	})
	public void listAreaAtendimentoMustReturn3() {
		
		Page<AreaAtendimento> areaAtendimentos = this.areaAtendimentoService.listAreaAtendimentosByFilters( null, null );
		
		Assert.assertNotNull( areaAtendimentos );
		
		Assert.assertTrue( areaAtendimentos.getContent().size() >= 3 );

	}
	
	
	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value = {
		"/dataset/pessoa/enderecoDataSet.xml",
		"/dataset/areaAtendimento/areaAtendimentoDataSet.xml",
		"/dataset/areaAtendimento/formacaoDataSet.xml",

	})
	public void listAreaAtendimentoByFilterNameMustReturn1() {
		
		Page<AreaAtendimento> areaAtendimentos = this.areaAtendimentoService.listAreaAtendimentosByFilters( "Lucas", null );
		
		Assert.assertTrue( areaAtendimentos.getContent().size() == 1 );

	}
	
	
	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value = {
		"/dataset/pessoa/enderecoDataSet.xml",
		"/dataset/areaAtendimento/areaAtendimentoDataSet.xml",
		"/dataset/areaAtendimento/formacaoDataSet.xml",

	})
	public void listAreaAtendimentoByFilterPageMustReturn1() {
		
		PageRequest page = new PageRequest( 0, 1 ) ;
		
		Page<AreaAtendimento> areaAtendimentos = this.areaAtendimentoService.listAreaAtendimentosByFilters( null , page );
		
		Assert.assertTrue( areaAtendimentos.getContent().size() == 1 );

	}
	
	
	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value = {
		"/dataset/pessoa/enderecoDataSet.xml",
		"/dataset/areaAtendimento/areaAtendimentoDataSet.xml",
		"/dataset/areaAtendimento/formacaoDataSet.xml",

	})
	public void listAreaAtendimentoByFilterPageMustFail() {
		
		PageRequest page = new PageRequest( 0, 2 ) ;
		
		Page<AreaAtendimento> areaAtendimentos = this.areaAtendimentoService.listAreaAtendimentosByFilters( null , page );
		
		Assert.assertTrue( ! (areaAtendimentos.getContent().size() == 1));
		

	}
	
	
	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value = {
		"/dataset/pessoa/enderecoDataSet.xml",
		"/dataset/areaAtendimento/areaAtendimentoDataSet.xml",
		"/dataset/areaAtendimento/formacaoDataSet.xml",

	})
	public void findAreaAtendimentoByIdMustPast()
	{
		AreaAtendimento areaAtendimento = this.areaAtendimentoService.findAreaAtendimentoById( 1000L );
		
		Assert.assertNotNull( areaAtendimento );
	}
	
	@Test( expected=AssertionError.class )
	@DatabaseSetup(type = DatabaseOperation.INSERT, value = {
		"/dataset/areaAtendimento/areaAtendimentoDataSet.xml"

	})
	public void findAreaAtendimentoByIdMustFailWithInvalidId()
	{
		AreaAtendimento areaAtendimento = this.areaAtendimentoService.findAreaAtendimentoById( 1895L );
		
		Assert.assertNull( areaAtendimento );
		
		Assert.fail();
	}
	
	

}
