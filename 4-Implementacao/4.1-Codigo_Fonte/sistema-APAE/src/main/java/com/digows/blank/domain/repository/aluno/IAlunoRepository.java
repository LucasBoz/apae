package com.digows.blank.domain.repository.aluno;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.digows.blank.domain.entity.aluno.Aluno;

/**
 * 
 * @author rodrigo.p.fraga@gmail.com 
 * @since 22/04/2014
 * @version 1.0
 * @category Repository
 */
public interface IAlunoRepository extends JpaRepository<Aluno, Long>
{

	
	/**
	 * @param filter
	 * @param pageable
	 * @return
	 */
	@Query(value=
				   "FROM Aluno aluno " +
				  "WHERE ( FILTER(aluno.id, :filter) = TRUE "
				  	 + "OR FILTER(aluno.nome, :filter) = TRUE )")
	public Page<Aluno> listByFilters( @Param("filter") String filter, Pageable pageable );
}
