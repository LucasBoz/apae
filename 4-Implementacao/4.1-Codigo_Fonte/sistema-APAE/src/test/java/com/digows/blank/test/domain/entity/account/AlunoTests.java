/**
 * 
 */
package com.digows.blank.test.domain.entity.account;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.digows.blank.domain.entity.aluno.Aluno;
import com.digows.blank.domain.service.aluno.AlunoService;
import com.digows.blank.test.domain.AbstractUnitTests;

/**
 * @author lucas
 *
 */
public class AlunoTests extends AbstractUnitTests
{
	
	@Autowired
	private AlunoService alunoService;

	@Test
	public void saveAlunoMustPass()
	{
		Aluno aluno = new Aluno();
		
		String alunoNome = "Nome Teste";
	
		aluno.setNome( alunoNome );
		
		aluno = alunoService.insertAluno( aluno );
		
		Assert.assertNotNull( aluno );
		
		alunoService.findAlunoById( aluno.getId() );
		
		Assert.assertNotNull( aluno );
		
		Assert.assertEquals( alunoNome, aluno.getNome());
	}
	
	@Test
	public void saveAlunoMustFail()
	{
		Aluno aluno = new Aluno();
		
		aluno = alunoService.insertAluno( aluno );

	
	}
	
	
}
