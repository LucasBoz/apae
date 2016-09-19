/**
 * 
 */
package com.digows.blank.test.domain.service;

import java.util.Calendar;

import javax.validation.ValidationException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.digows.blank.domain.entity.pessoa.Sexo;
import com.digows.blank.domain.entity.voluntario.Voluntario;
import com.digows.blank.domain.service.voluntario.VoluntarioService;
import com.digows.blank.test.domain.AbstractIntegrationTests;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;

/**
 * @author lucas
 *
 */
public class VoluntarioTests extends AbstractIntegrationTests
{
	@Autowired
	private VoluntarioService voluntarioService;

	@Test
	public void saveVoluntarioMustPass()
	{
		Voluntario voluntario = new Voluntario();

		voluntario.setCpf( "123" );
		voluntario.setDataNascimento( Calendar.getInstance() );
		voluntario.setNome( "Nome do volutario" );
		voluntario.setRg( "123213" );
		voluntario.setSexo( Sexo.FEMININO );

		voluntarioService.insertVoluntario( voluntario );
	}

	@Test(expected = ValidationException.class)
	public void saveFuncionarioMustFail()
	{

	}

	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value =
	{ "/dataset/voluntario/voluntarioDataSet.xml",

	})
	public void updateFuncionarioMustPast()
	{

	}

	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value =
	{ "/dataset/voluntario/voluntarioDataSet.xml",

	})
	public void updateFuncionarioMustFail()
	{

	}

	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value =
	{ "/dataset/voluntario/voluntarioDataSet.xml",

	})
	public void listFuncionarioMustReturn3()
	{

		Page<Voluntario> funcionarios = this.voluntarioService.listByFilters( null, null );

		Assert.assertNotNull( funcionarios );

		Assert.assertTrue( funcionarios.getContent().size() >= 3 );

	}

	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value =
	{ "/dataset/voluntario/voluntarioDataSet.xml",

	})
	public void listFuncionarioByFilterNameMustReturn1()
	{

		Page<Voluntario> voluntarios = this.voluntarioService.listByFilters( "Lucas", null );

		Assert.assertTrue( voluntarios.getContent().size() == 1 );

	}

	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value =
	{ "/dataset/voluntario/voluntarioDataSet.xml",

	})
	public void listFuncionarioByFilterPageMustReturn1()
	{

		PageRequest page = new PageRequest( 0, 1 );

		Page<Voluntario> voluntarios = this.voluntarioService.listByFilters( null, page );

		Assert.assertTrue( voluntarios.getContent().size() == 1 );

	}

	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value =
	{ "/dataset/voluntario/voluntarioDataSet.xml",

	})
	public void listFuncionarioByFilterPageMustFail()
	{

		PageRequest page = new PageRequest( 0, 2 );

		Page<Voluntario> voluntarios = this.voluntarioService.listByFilters( null, page );

		Assert.assertTrue( !( voluntarios.getContent().size() == 1 ) );

	}

	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value =
	{ "/dataset/voluntario/voluntarioDataSet.xml",

	})
	public void findFuncionarioByIdMustPast()
	{
		Voluntario voluntario = this.voluntarioService.findVoluntarioById( 1000L );

		Assert.assertNotNull( voluntario );
	}

	@Test(expected = AssertionError.class)
	@DatabaseSetup(type = DatabaseOperation.INSERT, value =
	{ "/dataset/voluntario/voluntarioDataSet.xml",

	})
	public void findFuncionarioByIdMustFailWithInvalidId()
	{
		Voluntario voluntario = this.voluntarioService.findVoluntarioById( 1895L );

		Assert.assertNull( voluntario );

		Assert.fail();
	}

}
