package com.digows.blank.domain.repository.funcionario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.digows.blank.domain.entity.tecnico.AreaAtendimento;

public interface IAreaAtendimentoRepository extends JpaRepository<AreaAtendimento, Long>
{

	
	/**
	 * @param filter
	 * @param pageable
	 * @return
	 */
	@Query(value= "FROM AreaAtendimento areaAtendimento " +
			  "WHERE ( FILTER(areaAtendimento.id, :filter) = TRUE "
			  	 + "OR FILTER(areaAtendimento.nome, :filter) = TRUE )")
	public Page<AreaAtendimento> listByFilters( @Param("filter") String filter, Pageable pageable );
	
	
}
