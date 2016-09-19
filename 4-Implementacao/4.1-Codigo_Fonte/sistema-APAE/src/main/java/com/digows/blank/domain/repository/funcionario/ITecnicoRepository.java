/**
 * 
 */
package com.digows.blank.domain.repository.funcionario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.digows.blank.domain.entity.tecnico.Tecnico;

/**
 * @author lucas
 *
 */

public interface ITecnicoRepository extends JpaRepository<Tecnico, Long>
{

	@Query( value = "FROM Tecnico tecnico "
			+ "WHERE FILTER( tecnico.nome, :filter) = TRUE "
			+ "OR FILTER ( tecnico.email, :filter) = TRUE ")
	public Page<Tecnico> listByFilters ( @Param("filter") String filter, Pageable page );
	
}
