/**
 * 
 */
package com.digows.blank.domain.repository.voluntario;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digows.blank.domain.entity.voluntario.Termo;

/**
 * @author lucas
 *
 */

public interface ITermoRepository extends JpaRepository<Termo, Long>
{
	
}

