/**
 * 
 */
package com.digows.blank.domain.repository.voluntario;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digows.blank.domain.entity.voluntario.Voluntariado;

/**
 * @author lucas
 *
 */

public interface IVoluntariadoRepository extends JpaRepository<Voluntariado, Long>
{
	
}

