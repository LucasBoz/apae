/**
 * 
 */
package com.digows.blank.test.domain.entity.account;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.digows.blank.domain.entity.aluno.Aluno;
import com.digows.blank.domain.entity.aluno.TipoResponsavel;
import com.digows.blank.domain.entity.funcionario.CursosEspecificos;
import com.digows.blank.domain.entity.responsavel.Familiar;
import com.digows.blank.domain.entity.responsavel.Responsavel;
import com.digows.blank.domain.service.aluno.AlunoService;
import com.digows.blank.test.domain.AbstractIntegrationTests;

/**
 * @author lucas
 *
 */
public class AlunoTests extends AbstractIntegrationTests
{
	
	@Autowired
	private AlunoService alunoService;

	@Test
	public void saveAlunoMustPass()
	{
		Aluno aluno = new Aluno();
		
		aluno.setNome( "Nome do aluno" );
	
		Responsavel responsavel = new Responsavel();
		
		responsavel.setNome( "NOME DO RESPONSAVEL DO ALUNO" );
		
		Familiar familiar = new Familiar();
		
		familiar.setResponsavel( responsavel );
		familiar.setTipoResponsavel( TipoResponsavel.PAI );
		
		aluno.setFamiliares( new HashSet<Familiar>() );
		aluno.getFamiliares().add( familiar );

		
		aluno = alunoService.insertAluno( aluno );
		
		Assert.assertNotNull( aluno );

	}
	
	@Test
	public void saveAlunoMustFail()
	{
		Aluno aluno = new Aluno();
		
		aluno = alunoService.insertAluno( aluno );

	
	}
	
	
}
