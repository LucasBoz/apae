/**
 * 
 */
package com.digows.blank.domain.repository.voluntario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.digows.blank.domain.entity.voluntario.Voluntario;

/**
 * @author lucas
 *
 */

public interface IVoluntarioRepository extends JpaRepository<Voluntario, Long>
{

	@Query( value = "FROM Voluntario voluntario "
			+ "WHERE FILTER( voluntario.nome, :filter) = TRUE "
			+ "OR FILTER ( voluntario.nome, :filter) = TRUE ")
	public Page<Voluntario> listByFilters ( @Param("filter") String filter, Pageable page );
	
}

