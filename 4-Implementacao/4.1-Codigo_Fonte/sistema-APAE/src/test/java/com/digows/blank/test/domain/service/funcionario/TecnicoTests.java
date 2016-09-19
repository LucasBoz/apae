/**
 * 
 */
package com.digows.blank.test.domain.service.funcionario;

import java.util.ArrayList;
import java.util.HashSet;

import javax.validation.ValidationException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.digows.blank.domain.entity.account.User;
import com.digows.blank.domain.entity.account.UserRole;
import com.digows.blank.domain.entity.funcionario.Cor;
import com.digows.blank.domain.entity.funcionario.CursosEspecificos;
import com.digows.blank.domain.entity.funcionario.Escolaridade;
import com.digows.blank.domain.entity.funcionario.Formacao;
import com.digows.blank.domain.entity.funcionario.Funcao;
import com.digows.blank.domain.entity.funcionario.Situacao;
import com.digows.blank.domain.entity.funcionario.TipoDeficiencia;
import com.digows.blank.domain.entity.funcionario.TipoInstituicao;
import com.digows.blank.domain.entity.pessoa.Endereco;
import com.digows.blank.domain.entity.pessoa.Sexo;
import com.digows.blank.domain.entity.tecnico.AreaAtendimento;
import com.digows.blank.domain.entity.tecnico.Tecnico;
import com.digows.blank.domain.service.funcionario.TecnicoService;
import com.digows.blank.domain.service.tecnico.AreaAtendimentoService;
import com.digows.blank.test.domain.AbstractIntegrationTests;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;


/**
 * @author lucas
 *
 */
public class TecnicoTests extends AbstractIntegrationTests
{
	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private AreaAtendimentoService areaAtendimentoService;

	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value = {
			"/dataset/funcionario/areaAtendimentoDataSet.xml",
		})
	public void saveTecnicoMustPass()
	{ 
		Tecnico tecnico = new Tecnico();
		
		AreaAtendimento areaAtendimento = areaAtendimentoService.findAreaAtendimentoById( 1000L );
		
		tecnico.setAreaAtendimento( areaAtendimento );
		
		tecnico.setCor( Cor.AMARELA );
		
		tecnico.setEmail( "asd@qsaed.com" );

//		Endereço
		Endereco endereco = new Endereco();
		endereco.setBairro( "BAIRRO" );
		endereco.setCep( "123123123" );
		endereco.setComplemento( "Complemento" );
		endereco.setLogradouro( "Rua logradouro" );
		endereco.setMunicipio( "Foz do iguaçu" );
		endereco.setNumero( "34-G" );
		endereco.setUf( "PR" );
		tecnico.setEndereco( endereco );
		
		tecnico.setEscolaridade( Escolaridade.FUNDAMENTAL_COMPLETO );
		
//		Formação
		tecnico.setFormacoes(  new ArrayList<Formacao>() );
	
		Formacao formacao = new Formacao();

		formacao.setAnoConclusao( 2017 );
		formacao.setAnoInicio( 2013 );
		formacao.setArea( "AREA" );
		formacao.setCodigo( "24F" );
		formacao.setFormacaoPedagoga( true );
		formacao.setNomeInstituicao( "NOME INSTITUICAO" );
		formacao.setSituacao( Situacao.EM_ANDAMENTO );
		formacao.setTipoInstituicao( TipoInstituicao.PRIVADA );

		tecnico.getFormacoes().add( formacao );
		
//		Cursos especificos		
		tecnico.setCursosEspecificos( new HashSet<CursosEspecificos>() );
		tecnico.getCursosEspecificos().add( CursosEspecificos.ANOS_FINAIS_ENSINO_FUNDAMENTAL );
		tecnico.getCursosEspecificos().add( CursosEspecificos.EDUCACAO_INDIGENA );
		tecnico.getCursosEspecificos().add( CursosEspecificos.CRECHE);
				
		
//		Funcao	
		tecnico.setFuncao( new HashSet<Funcao>() );
		tecnico.getFuncao().add( Funcao.DOCENTE_TITULAR );
		tecnico.getFuncao().add( Funcao.AUXILIAR_EDUCACIONAL );
		tecnico.getFuncao().add( Funcao.TRADUTOR_INTERPRETE_LIBRAS );
		
//		Local de nascimento
		Endereco localNascimento = new Endereco();
		localNascimento.setBairro( "BAIRRO" );
		localNascimento.setCep( "123123123" );
		localNascimento.setComplemento( "Complemento" );
		localNascimento.setLogradouro( "Rua logradouro" );
		localNascimento.setMunicipio( "Foz do iguaçu" );
		localNascimento.setNumero( "34-G" );
		localNascimento.setUf( "RS" );
		tecnico.setLocalNascimento( localNascimento );
		
		tecnico.setNome( "Lucas Fernando" );
		
		tecnico.setNomeMae( "Nome da mae teste " );
		
		tecnico.setNomePai( "Nome pai teste" );
		
		tecnico.setNumeroIdentificacaoSocial( "123123-213-F" );
		
		tecnico.setRg( "01234567890" );
		
		tecnico.setSexo( Sexo.MASCULINO );
		
		tecnico.setTipoDeficiencia( TipoDeficiencia.INTELECTUAL );
		
		/**
		 * USER
		 */
		User user = new User();
		user.setName( tecnico.getNome() );
		user.setPassword("SENHA123");
		user.setEnabled( true );
		user.setLogin( "LOGIN" );
		user.setRole( UserRole.TECNICO );
		
		tecnico.setUser( user );
		
		tecnico = tecnicoService.insertTecnico( tecnico );
		
		tecnicoService.updateTecnico( tecnico );
		
	}
	
	
	@Test( expected=ValidationException.class )
	@DatabaseSetup(type = DatabaseOperation.INSERT, value = {
			"/dataset/funcionario/areaAtendimentoDataSet.xml",
		})
	public void saveTecnicoMustFail() 
	{ 
		
		Tecnico tecnico = new Tecnico();
		
		AreaAtendimento areaAtendimento = areaAtendimentoService.findAreaAtendimentoById( 1000L );
		
		tecnico.setAreaAtendimento( areaAtendimento );
		
		tecnico.setCor( Cor.AMARELA );
		
		tecnico.setEmail( "asd@qsaed.com" );

//		Endereço
		Endereco endereco = new Endereco();
		endereco.setBairro( "BAIRRO" );
		endereco.setCep( "123123123" );
		endereco.setComplemento( "Complemento" );
		endereco.setLogradouro( "Rua logradouro" );
		endereco.setMunicipio( "Foz do iguaçu" );
		endereco.setNumero( "34-G" );
		endereco.setUf( "PR" );
		tecnico.setEndereco( endereco );
		
		tecnico.setEscolaridade( Escolaridade.FUNDAMENTAL_COMPLETO );
		
//		Formação
		tecnico.setFormacoes(  new ArrayList<Formacao>() );
		
		Formacao formacao = new Formacao();

		formacao.setAnoConclusao( 2017 );
		formacao.setAnoInicio( 2013 );
		formacao.setArea( "AREA" );
		formacao.setCodigo( "24F" );
		formacao.setFormacaoPedagoga( true );
		formacao.setNomeInstituicao( "NOME INSTITUICAO" );
		formacao.setSituacao( Situacao.EM_ANDAMENTO );
		formacao.setTipoInstituicao( TipoInstituicao.PRIVADA );

		tecnico.getFormacoes().add( formacao );
		
//		Cursos especificos		
		tecnico.setCursosEspecificos( new HashSet<CursosEspecificos>() );
		tecnico.getCursosEspecificos().add( CursosEspecificos.ANOS_FINAIS_ENSINO_FUNDAMENTAL );
		tecnico.getCursosEspecificos().add( CursosEspecificos.EDUCACAO_INDIGENA );
		tecnico.getCursosEspecificos().add( CursosEspecificos.CRECHE);
				
		
//		Funcao		
		tecnico.setFuncao( new HashSet<Funcao>() );
		tecnico.getFuncao().add( Funcao.DOCENTE_TITULAR );
		tecnico.getFuncao().add( Funcao.AUXILIAR_EDUCACIONAL );
		tecnico.getFuncao().add( Funcao.TRADUTOR_INTERPRETE_LIBRAS );
		
//		Local de nascimento
		Endereco localNascimento = new Endereco();
		localNascimento.setBairro( "BAIRRO" );
		localNascimento.setCep( "123123123" );
		localNascimento.setComplemento( "Complemento" );
		localNascimento.setLogradouro( "Rua logradouro" );
		localNascimento.setMunicipio( "Foz do iguaçu" );
		localNascimento.setNumero( "34-G" );
		localNascimento.setUf( "RS" );
		tecnico.setLocalNascimento( localNascimento );
		
		tecnico.setNome( null );
		
		tecnico.setNomeMae( "Nome da mae teste " );
		
		tecnico.setNomePai( "Nome pai teste" );
		
		tecnico.setNumeroIdentificacaoSocial( "123123-213-F" );
		
		tecnico.setRg( "01234567890" );
		
		tecnico.setSexo( Sexo.MASCULINO );
		
		tecnico.setTipoDeficiencia( TipoDeficiencia.INTELECTUAL );
		
		tecnicoService.insertTecnico( tecnico );
		
		Assert.fail();
		
	}
	
	
	
	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value = {
		"/dataset/pessoa/enderecoDataSet.xml",
		"/dataset/funcionario/tecnicoDataSet.xml",
		"/dataset/funcionario/formacaoDataSet.xml",

	})
	public void updateTecnicoMustPast() {
		
		String novoNome = "Novo nome do tecnico";
		
		Tecnico tecnico = this.tecnicoService.findTecnicoById( 1000L );
		
		tecnico.setNome( novoNome );
				
		tecnico = this.tecnicoService.updateTecnico( tecnico );
		
		Assert.assertTrue( tecnico.getNome().equals( novoNome) );

	}
	
	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value = {
		"/dataset/pessoa/enderecoDataSet.xml",
		"/dataset/funcionario/tecnicoDataSet.xml",
		"/dataset/funcionario/formacaoDataSet.xml",

	})
	public void updateTecnicoMustFail() {
		
		String novoNome = "";
		
		Tecnico tecnico = this.tecnicoService.findTecnicoById( 1000L );
		
		tecnico.setNome( novoNome );
				
		tecnico = this.tecnicoService.updateTecnico( tecnico );

		Assert.fail();
	}
	
	
	
	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value = {
		"/dataset/pessoa/enderecoDataSet.xml",
		"/dataset/funcionario/tecnicoDataSet.xml",
		"/dataset/funcionario/formacaoDataSet.xml",

	})
	public void listTecnicoMustReturn3() {
		
		Page<Tecnico> tecnicos = this.tecnicoService.listByFilters( null, null );
		
		Assert.assertNotNull( tecnicos );
		
		Assert.assertTrue( tecnicos.getContent().size() >= 3 );

	}
	
	
	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value = {
		"/dataset/pessoa/enderecoDataSet.xml",
		"/dataset/funcionario/tecnicoDataSet.xml",
		"/dataset/funcionario/formacaoDataSet.xml",

	})
	public void listTecnicoByFilterNameMustReturn1() {
		
		Page<Tecnico> tecnicos = this.tecnicoService.listByFilters( "Lucas", null );
		
		Assert.assertTrue( tecnicos.getContent().size() == 1 );

	}
	
	
	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value = {
		"/dataset/pessoa/enderecoDataSet.xml",
		"/dataset/funcionario/tecnicoDataSet.xml",
		"/dataset/funcionario/formacaoDataSet.xml",

	})
	public void listTecnicoByFilterPageMustReturn1() {
		
		PageRequest page = new PageRequest( 0, 1 ) ;
		
		Page<Tecnico> tecnicos = this.tecnicoService.listByFilters( null , page );
		
		Assert.assertTrue( tecnicos.getContent().size() == 1 );

	}
	
	
	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value = {
		"/dataset/pessoa/enderecoDataSet.xml",
		"/dataset/funcionario/tecnicoDataSet.xml",
		"/dataset/funcionario/formacaoDataSet.xml",

	})
	public void listTecnicoByFilterPageMustFail() {
		
		PageRequest page = new PageRequest( 0, 2 ) ;
		
		Page<Tecnico> tecnicos = this.tecnicoService.listByFilters( null , page );
		
		Assert.assertTrue( ! (tecnicos.getContent().size() == 1));
		

	}
	
	
	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value = {
		"/dataset/pessoa/enderecoDataSet.xml",
		"/dataset/funcionario/tecnicoDataSet.xml",
		"/dataset/funcionario/formacaoDataSet.xml",

	})
	public void findTecnicoByIdMustPast()
	{
		Tecnico tecnico = this.tecnicoService.findTecnicoById( 1000L );
		
		Assert.assertNotNull( tecnico );
	}
	
	@Test( expected=AssertionError.class )
	@DatabaseSetup(type = DatabaseOperation.INSERT, value = {
		"/dataset/pessoa/enderecoDataSet.xml",
		"/dataset/funcionario/tecnicoDataSet.xml",
		"/dataset/funcionario/formacaoDataSet.xml",

	})
	public void findTecnicoByIdMustFailWithInvalidId()
	{
		Tecnico tecnico = this.tecnicoService.findTecnicoById( 1895L );
		
		Assert.assertNull( tecnico );
		
		Assert.fail();
	}
	
	

}
