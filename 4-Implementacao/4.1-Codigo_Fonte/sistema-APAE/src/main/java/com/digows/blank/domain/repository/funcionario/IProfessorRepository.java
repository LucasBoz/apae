/**
 * 
 */
package com.digows.blank.domain.repository.funcionario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.digows.blank.domain.entity.professor.Professor;

/**
 * @author lucas
 *
 */

public interface IProfessorRepository extends JpaRepository<Professor, Long>
{

	@Query( value = "FROM Professor professor "
			+ "WHERE FILTER( professor.nome, :filter) = TRUE "
			+ "OR FILTER ( professor.email, :filter) = TRUE ")
	public Page<Professor> listByFilters ( @Param("filter") String filter, Pageable page );
	
}

