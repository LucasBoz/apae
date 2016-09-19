/**
 * 
 */
package com.digows.blank.domain.service.funcionario;

import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.digows.blank.domain.entity.professor.Professor;
import com.digows.blank.domain.repository.funcionario.IProfessorRepository;

/**
 * @author lucas
 *
 */
@Service
@RemoteProxy
@Transactional
public class ProfessorService
{

	@Autowired
	private IProfessorRepository professorRepository;

	@Transactional(readOnly=true)
	public Professor findProfessorById( Long id )
	{
		final Professor professor = this.professorRepository.findOne( id );
		return professor;
	}
	
	public Professor insertProfessor( Professor professor)
	{
//		Assert.notNull( professor );

//		professor.isValid();

		return this.professorRepository.save( professor );
	}
	
	public Professor updateProfessor( Professor professor)
	{
		Assert.notNull( professor );

		return this.professorRepository.save( professor );
	}
	
	
	public void removeProfessor(  Long professorId)
	{
		this.professorRepository.delete( professorId );
	}
	
	
	public Page<Professor> listByFilters( String filter, PageRequest page ){
		
		return this.professorRepository.listByFilters( filter, page );
		
	}
	
}
