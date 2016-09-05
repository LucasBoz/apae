/**
 * 
 */
package com.digows.blank.domain.repository.funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digows.blank.domain.entity.funcionario.Funcionario;

/**
 * @author lucas
 *
 */

public interface IFuncionarioRepository extends JpaRepository<Funcionario, Long>
{

	
}

