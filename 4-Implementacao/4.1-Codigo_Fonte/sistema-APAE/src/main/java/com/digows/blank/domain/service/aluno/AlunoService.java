package com.digows.blank.domain.service.aluno;

import java.util.Arrays;
import java.util.List;

import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.digows.blank.domain.entity.aluno.Aluno;
import com.digows.blank.domain.entity.aluno.TipoResponsavel;
import com.digows.blank.domain.repository.aluno.IAlunoRepository;

/**
 * 
 * @author rodrigo.p.fraga@gmail.com
 */
@Service
@RemoteProxy
@Transactional
public class AlunoService
{
	/*-------------------------------------------------------------------
	 *				 		     ATTRIBUTES
	 *-------------------------------------------------------------------*/

	//Repositories
	/**
	 * 
	 */
	@Autowired
	private IAlunoRepository alunoRepository;

	/*-------------------------------------------------------------------
	 *				 		     SERVICES
	 *-------------------------------------------------------------------*/

	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly=true)
	public Aluno findAlunoById( Long id )
	{
		final Aluno aluno = this.alunoRepository.findOne( id );
		return aluno;
	}
	
	
	/**
	 * 
	 * @param aluno
	 * @return
	 */
//	@PreAuthorize("hasAnyAuthority('s"+UserRole.ADMINISTRATOR_VALUE+"','"+UserRole.MANAGER_VALUE+"')")
	public Aluno insertAluno( Aluno aluno)
	{
		Assert.notNull( aluno );

		aluno.isValid();

		return this.alunoRepository.save( aluno );
	}
	
//	@PreAuthorize("hasAnyAuthority('"+UserRole.ADMINISTRATOR_VALUE+"','"+UserRole.MANAGER_VALUE+"')")
	public Aluno updateAluno( Aluno aluno)
	{
		Assert.notNull( aluno );

		aluno.isValid();

		return this.alunoRepository.save( aluno );
	}
	
	
	/**
	 * 
	 * @param pageable
	 * @param filters
	 * @return
	 */
	@Transactional(readOnly=true)
	public Page<Aluno> listAlunosByFilters( String filter, PageRequest pageable )
	{
		return this.alunoRepository.listByFilters( filter, pageable );
	}
	
	
	
//	@PreAuthorize("hasAnyAuthority('"+UserRole.ADMINISTRATOR_VALUE+"','"+UserRole.MANAGER_VALUE+"')")
	public void removeAluno(  Long alunoId)
	{
		this.alunoRepository.delete( alunoId );
	}
	
	
	public List<TipoResponsavel> listTipoFamiliar(){
		return Arrays.asList(TipoResponsavel.values());
	}
	
}