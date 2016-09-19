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
import com.digows.blank.domain.entity.professor.Professor;
import com.digows.blank.domain.service.funcionario.ProfessorService;
import com.digows.blank.test.domain.AbstractIntegrationTests;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;


/**
 * @author lucas
 *
 */
public class ProfessorTests extends AbstractIntegrationTests
{
	@Autowired
	private ProfessorService professorService;

	@Test
	public void saveProfessorMustPass()
	{ 
		Professor professor = new Professor();
		
		professor.setCor( Cor.AMARELA );
		
		professor.setEmail( "asd@qsaed.com" );

//		Endereço
		Endereco endereco = new Endereco();
		endereco.setBairro( "BAIRRO" );
		endereco.setCep( "123123123" );
		endereco.setComplemento( "Complemento" );
		endereco.setLogradouro( "Rua logradouro" );
		endereco.setMunicipio( "Foz do iguaçu" );
		endereco.setNumero( "34-G" );
		endereco.setUf( "PR" );
		professor.setEndereco( endereco );
		
		professor.setEscolaridade( Escolaridade.FUNDAMENTAL_COMPLETO );
		
//		Formação
		professor.setFormacoes(  new ArrayList<Formacao>() );
	
		Formacao formacao = new Formacao();

		formacao.setAnoConclusao( 2017 );
		formacao.setAnoInicio( 2013 );
		formacao.setArea( "AREA" );
		formacao.setCodigo( "24F" );
		formacao.setFormacaoPedagoga( true );
		formacao.setNomeInstituicao( "NOME INSTITUICAO" );
		formacao.setSituacao( Situacao.EM_ANDAMENTO );
		formacao.setTipoInstituicao( TipoInstituicao.PRIVADA );

		professor.getFormacoes().add( formacao );
		
//		Cursos especificos		
		professor.setCursosEspecificos( new HashSet<CursosEspecificos>() );
		professor.getCursosEspecificos().add( CursosEspecificos.ANOS_FINAIS_ENSINO_FUNDAMENTAL );
		professor.getCursosEspecificos().add( CursosEspecificos.EDUCACAO_INDIGENA );
		professor.getCursosEspecificos().add( CursosEspecificos.CRECHE);
				
		
//		Funcao	
		professor.setFuncao( new HashSet<Funcao>() );
		professor.getFuncao().add( Funcao.DOCENTE_TITULAR );
		professor.getFuncao().add( Funcao.AUXILIAR_EDUCACIONAL );
		professor.getFuncao().add( Funcao.TRADUTOR_INTERPRETE_LIBRAS );
		
//		Local de nascimento
		Endereco localNascimento = new Endereco();
		localNascimento.setBairro( "BAIRRO" );
		localNascimento.setCep( "123123123" );
		localNascimento.setComplemento( "Complemento" );
		localNascimento.setLogradouro( "Rua logradouro" );
		localNascimento.setMunicipio( "Foz do iguaçu" );
		localNascimento.setNumero( "34-G" );
		localNascimento.setUf( "RS" );
		professor.setLocalNascimento( localNascimento );
		
		professor.setNome( "Lucas Fernando" );
		
		professor.setNomeMae( "Nome da mae teste " );
		
		professor.setNomePai( "Nome pai teste" );
		
		professor.setNumeroIdentificacaoSocial( "123123-213-F" );
		
		professor.setRg( "01234567890" );
		
		professor.setSexo( Sexo.MASCULINO );
		
		professor.setTipoDeficiencia( TipoDeficiencia.INTELECTUAL );
		
		professor = professorService.insertProfessor( professor );
		
		professorService.updateProfessor( professor );
		
	}
	
	
	@Test( expected=ValidationException.class )
	public void saveProfessorMustFail() 
	{ 
		
		Professor professor = new Professor();
		
		professor.setCor( Cor.AMARELA );
		
		professor.setEmail( "asd@qsaed.com" );

//		Endereço
		Endereco endereco = new Endereco();
		endereco.setBairro( "BAIRRO" );
		endereco.setCep( "123123123" );
		endereco.setComplemento( "Complemento" );
		endereco.setLogradouro( "Rua logradouro" );
		endereco.setMunicipio( "Foz do iguaçu" );
		endereco.setNumero( "34-G" );
		endereco.setUf( "PR" );
		professor.setEndereco( endereco );
		
		professor.setEscolaridade( Escolaridade.FUNDAMENTAL_COMPLETO );
		
//		Formação
		professor.setFormacoes(  new ArrayList<Formacao>() );
		
		Formacao formacao = new Formacao();

		formacao.setAnoConclusao( 2017 );
		formacao.setAnoInicio( 2013 );
		formacao.setArea( "AREA" );
		formacao.setCodigo( "24F" );
		formacao.setFormacaoPedagoga( true );
		formacao.setNomeInstituicao( "NOME INSTITUICAO" );
		formacao.setSituacao( Situacao.EM_ANDAMENTO );
		formacao.setTipoInstituicao( TipoInstituicao.PRIVADA );

		professor.getFormacoes().add( formacao );
		
//		Cursos especificos		
		professor.setCursosEspecificos( new HashSet<CursosEspecificos>() );
		professor.getCursosEspecificos().add( CursosEspecificos.ANOS_FINAIS_ENSINO_FUNDAMENTAL );
		professor.getCursosEspecificos().add( CursosEspecificos.EDUCACAO_INDIGENA );
		professor.getCursosEspecificos().add( CursosEspecificos.CRECHE);
				
		
//		Funcao		
		professor.setFuncao( new HashSet<Funcao>() );
		professor.getFuncao().add( Funcao.DOCENTE_TITULAR );
		professor.getFuncao().add( Funcao.AUXILIAR_EDUCACIONAL );
		professor.getFuncao().add( Funcao.TRADUTOR_INTERPRETE_LIBRAS );
		
//		Local de nascimento
		Endereco localNascimento = new Endereco();
		localNascimento.setBairro( "BAIRRO" );
		localNascimento.setCep( "123123123" );
		localNascimento.setComplemento( "Complemento" );
		localNascimento.setLogradouro( "Rua logradouro" );
		localNascimento.setMunicipio( "Foz do iguaçu" );
		localNascimento.setNumero( "34-G" );
		localNascimento.setUf( "RS" );
		professor.setLocalNascimento( localNascimento );
		
		professor.setNome( null );
		
		professor.setNomeMae( "Nome da mae teste " );
		
		professor.setNomePai( "Nome pai teste" );
		
		professor.setNumeroIdentificacaoSocial( "123123-213-F" );
		
		professor.setRg( "01234567890" );
		
		professor.setSexo( Sexo.MASCULINO );
		
		professor.setTipoDeficiencia( TipoDeficiencia.INTELECTUAL );
		
		professorService.insertProfessor( professor );
		
		Assert.fail();
		
	}
	
	
	
	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value = {
		"/dataset/pessoa/enderecoDataSet.xml",
		"/dataset/funcionario/professorDataSet.xml",
		"/dataset/funcionario/formacaoDataSet.xml",

	})
	public void updateProfessorMustPast() {
		
		String novoNome = "Novo nome do professor";
		
		Professor professor = this.professorService.findProfessorById( 1000L );
		
		professor.setNome( novoNome );
				
		professor = this.professorService.updateProfessor( professor );
		
		Assert.assertTrue( professor.getNome().equals( novoNome) );

	}
	
	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value = {
		"/dataset/pessoa/enderecoDataSet.xml",
		"/dataset/funcionario/professorDataSet.xml",
		"/dataset/funcionario/formacaoDataSet.xml",

	})
	public void updateProfessorMustFail() {
		
		String novoNome = "";
		
		Professor professor = this.professorService.findProfessorById( 1000L );
		
		professor.setNome( novoNome );
				
		professor = this.professorService.updateProfessor( professor );

		Assert.fail();
	}
	
	
	
	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value = {
		"/dataset/pessoa/enderecoDataSet.xml",
		"/dataset/funcionario/professorDataSet.xml",
		"/dataset/funcionario/formacaoDataSet.xml",

	})
	public void listProfessorMustReturn3() {
		
		Page<Professor> professors = this.professorService.listByFilters( null, null );
		
		Assert.assertNotNull( professors );
		
		Assert.assertTrue( professors.getContent().size() >= 3 );

	}
	
	
	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value = {
		"/dataset/pessoa/enderecoDataSet.xml",
		"/dataset/funcionario/professorDataSet.xml",
		"/dataset/funcionario/formacaoDataSet.xml",

	})
	public void listProfessorByFilterNameMustReturn1() {
		
		Page<Professor> professors = this.professorService.listByFilters( "Lucas", null );
		
		Assert.assertTrue( professors.getContent().size() == 1 );

	}
	
	
	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value = {
		"/dataset/pessoa/enderecoDataSet.xml",
		"/dataset/funcionario/professorDataSet.xml",
		"/dataset/funcionario/formacaoDataSet.xml",

	})
	public void listProfessorByFilterPageMustReturn1() {
		
		PageRequest page = new PageRequest( 0, 1 ) ;
		
		Page<Professor> professors = this.professorService.listByFilters( null , page );
		
		Assert.assertTrue( professors.getContent().size() == 1 );

	}
	
	
	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value = {
		"/dataset/pessoa/enderecoDataSet.xml",
		"/dataset/funcionario/professorDataSet.xml",
		"/dataset/funcionario/formacaoDataSet.xml",

	})
	public void listProfessorByFilterPageMustFail() {
		
		PageRequest page = new PageRequest( 0, 2 ) ;
		
		Page<Professor> professors = this.professorService.listByFilters( null , page );
		
		Assert.assertTrue( ! (professors.getContent().size() == 1));
		

	}
	
	
	@Test
	@DatabaseSetup(type = DatabaseOperation.INSERT, value = {
		"/dataset/pessoa/enderecoDataSet.xml",
		"/dataset/funcionario/professorDataSet.xml",
		"/dataset/funcionario/formacaoDataSet.xml",

	})
	public void findProfessorByIdMustPast()
	{
		Professor professor = this.professorService.findProfessorById( 1000L );
		
		Assert.assertNotNull( professor );
	}
	
	@Test( expected=AssertionError.class )
	@DatabaseSetup(type = DatabaseOperation.INSERT, value = {
		"/dataset/pessoa/enderecoDataSet.xml",
		"/dataset/funcionario/professorDataSet.xml",
		"/dataset/funcionario/formacaoDataSet.xml",

	})
	public void findProfessorByIdMustFailWithInvalidId()
	{
		Professor professor = this.professorService.findProfessorById( 1895L );
		
		Assert.assertNull( professor );
		
		Assert.fail();
	}
	
	

}
