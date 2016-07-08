package com.digows.blank.domain.repository.aluno;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.digows.blank.domain.entity.transporte.Transporte;

/**
 * 
 * @author rodrigo.p.fraga@gmail.com 
 * @since 22/04/2014
 * @version 1.0
 * @category Repository
 */
public interface ITransporteRepository extends JpaRepository<Transporte, Long>
{

	
	/**
	 * @param filter
	 * @param pageable
	 * @return
	 */
	@Query(value=
				   "FROM Transporte transporte " +
				  "WHERE ( FILTER(transporte.id, :filter) = TRUE "
				  	 + "OR FILTER(transporte.nome, :filter) = TRUE )")
	public Page<Transporte> listByFilters( @Param("filter") String filter, Pageable pageable );
}
