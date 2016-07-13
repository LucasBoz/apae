package com.digows.blank.domain.repository.aluno;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.digows.blank.domain.entity.aluno.Cid;

/**
 * 
 * @author rodrigo.p.fraga@gmail.com 
 * @since 22/04/2014
 * @version 1.0
 * @category Repository
 */
public interface ICidRepository extends JpaRepository<Cid, Long>
{

	
	/**
	 * @param filter
	 * @param pageable
	 * @return
	 */
	@Query(value=
				   "FROM Cid cid " +
				  "WHERE ( FILTER(cid.id, :filter) = TRUE )")
	public Page<Cid> listByFilters( @Param("filter") String filter, Pageable pageable );

}
