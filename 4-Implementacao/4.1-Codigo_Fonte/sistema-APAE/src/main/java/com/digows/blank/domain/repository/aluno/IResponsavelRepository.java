package com.digows.blank.domain.repository.aluno;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.digows.blank.domain.entity.responsavel.Responsavel;

public interface IResponsavelRepository extends JpaRepository<Responsavel, Long>
{

	
	/**
	 * @param filter
	 * @param pageable
	 * @return
	 */
	@Query(value= "FROM Responsavel responsavel " +
			  "WHERE ( FILTER(responsavel.id, :filter) = TRUE "
			  	 + "OR FILTER(responsavel.nome, :filter) = TRUE )")
	public Page<Responsavel> listByFilters( @Param("filter") String filter, Pageable pageable );
	
	
	
}
