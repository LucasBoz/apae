/**
 * 
 */
package com.digows.blank.test.domain.service.funcionario;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.digows.blank.domain.entity.funcionario.Cor;
import com.digows.blank.domain.entity.funcionario.CursosEspecificos;
import com.digows.blank.domain.entity.funcionario.Escolaridade;
import com.digows.blank.domain.entity.funcionario.Formacao;
import com.digows.blank.domain.entity.funcionario.Funcao;
import com.digows.blank.domain.entity.funcionario.Funcionario;
import com.digows.blank.domain.entity.funcionario.FuncionarioCursoEspecifico;
import com.digows.blank.domain.entity.funcionario.FuncionarioFuncao;
import com.digows.blank.domain.entity.funcionario.Situacao;
import com.digows.blank.domain.entity.funcionario.TipoDeficiencia;
import com.digows.blank.domain.entity.funcionario.TipoInstituicao;
import com.digows.blank.domain.entity.pessoa.Endereco;
import com.digows.blank.domain.entity.pessoa.Sexo;
import com.digows.blank.domain.service.funcionario.FuncionarioService;
import com.digows.blank.test.domain.AbstractIntegrationTests;


/**
 * @author lucas
 *
 */
public class FuncionarioTests extends AbstractIntegrationTests
{
	@Autowired
	private FuncionarioService funcionarioService;

	@Test
	public void saveFuncionarioMustPass()
	{ 
		Funcionario funcionario = new Funcionario();
		
		funcionario.setCor( Cor.AMARELA );
		
		funcionario.setEmail( "asd@qsaed.com" );

//		Endereço
		Endereco endereco = new Endereco();
		endereco.setBairro( "BAIRRO" );
		endereco.setCep( "123123123" );
		endereco.setComplemento( "Complemento" );
		endereco.setLogradouro( "Rua logradouro" );
		endereco.setMunicipio( "Foz do iguaçu" );
		endereco.setNumero( "34-G" );
		endereco.setUf( "PR" );
		funcionario.setEndereco( endereco );
		
		funcionario.setEscolaridade( Escolaridade.FUNDAMENTAL_COMPLETO );
		
//		Formação
		funcionario.setFormacoes(  new ArrayList<Formacao>() );
		
		Formacao formacao = new Formacao();

		formacao.setAnoConclusao( 2017);
		formacao.setAnoInicio( 2013 );
		formacao.setArea( "AREA" );
		formacao.setCodigo( "24F" );
		formacao.setFormacaoPedagoga( true );
		formacao.setNomeInstituicao( "NOME INSTITUICAO" );
		formacao.setSituacao( Situacao.EM_ANDAMENTO );
		formacao.setTipoInstituicao( TipoInstituicao.PRIVADA );

		funcionario.getFormacoes().add( formacao );
		
//		Cursos especificos
//		funcionario.setFuncionarioCursoEspecifico( new HashSet<FuncionarioCursoEspecifico>() );
//		funcionario.getFuncionarioCursoEspecifico().add( new FuncionarioCursoEspecifico(funcionario, CursosEspecificos.CRECHE) );
//		funcionario.getFuncionarioCursoEspecifico().add( new FuncionarioCursoEspecifico(funcionario, CursosEspecificos.ANOS_FINAIS_ENSINO_FUNDAMENTAL) );
//		funcionario.getFuncionarioCursoEspecifico().add( new FuncionarioCursoEspecifico(funcionario, CursosEspecificos.EDUCACAO_INDIGENA) );
		
		funcionario.setCursosEspecificos( new HashSet<CursosEspecificos>() );
		funcionario.getCursosEspecificos().add( CursosEspecificos.ANOS_FINAIS_ENSINO_FUNDAMENTAL );
		funcionario.getCursosEspecificos().add( CursosEspecificos.EDUCACAO_INDIGENA );
		funcionario.getCursosEspecificos().add( CursosEspecificos.CRECHE);
				
		
//		Funcao
//		funcionario.setFuncionarioFuncao( new HashSet<FuncionarioFuncao>() );
//		funcionario.getFuncionarioFuncao().add( new FuncionarioFuncao(funcionario, Funcao.AUXILIAR_EDICACIONAL) );
//		funcionario.getFuncionarioFuncao().add( new FuncionarioFuncao(funcionario, Funcao.DOCENTE) );
//		funcionario.getFuncionarioFuncao().add( new FuncionarioFuncao(funcionario, Funcao.TRADUTOR_INTERPRETE_LIBRAS) );
		
		funcionario.setFuncao( new HashSet<Funcao>() );
		funcionario.getFuncao().add( Funcao.DOCENTE_TITULAR );
		funcionario.getFuncao().add( Funcao.AUXILIAR_EDUCACIONAL );
		funcionario.getFuncao().add( Funcao.TRADUTOR_INTERPRETE_LIBRAS );
		
//		Local de nascimento
		Endereco localNascimento = new Endereco();
		localNascimento.setBairro( "BAIRRO" );
		localNascimento.setCep( "123123123" );
		localNascimento.setComplemento( "Complemento" );
		localNascimento.setLogradouro( "Rua logradouro" );
		localNascimento.setMunicipio( "Foz do iguaçu" );
		localNascimento.setNumero( "34-G" );
		localNascimento.setUf( "RS" );
		funcionario.setLocalNascimento( localNascimento );
		
		funcionario.setNome( "Lucas Fernando" );
		
		funcionario.setNomeMae( "Nome da mae teste " );
		
		funcionario.setNomePai( "Nome pai teste" );
		
		funcionario.setNumeroIdentificacaoSocial( "123123-213-F" );
		
		funcionario.setRg( "01234567890" );
		
		funcionario.setSexo( Sexo.MASCULINO );
		
		funcionario.setTipodeficiencia( TipoDeficiencia.INTELECTUAL );
		
		funcionarioService.insertFuncionario( funcionario );
		
		
	}
	
	

}
