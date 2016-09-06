/**
 * 
 */
package com.digows.blank.domain.repository.funcionario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.digows.blank.domain.entity.funcionario.Funcionario;

/**
 * @author lucas
 *
 */

public interface IFuncionarioRepository extends JpaRepository<Funcionario, Long>
{

	@Query( value = "FROM Funcionario funcionario "
			+ "WHERE FILTER( funcionario.nome, :filter) = TRUE "
			+ "OR FILTER ( funcionario.email, :filter) = TRUE ")
	public Page<Funcionario> listByFilters ( @Param("filter") String filter, Pageable page );
	
}

