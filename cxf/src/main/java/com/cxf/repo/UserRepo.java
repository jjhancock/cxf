/**
 * 
 */
package com.cxf.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cxf.domain.User;

/**
 * @author justin.hancock
 *
 */
public interface UserRepo extends JpaRepository<User, Long>
{
	User findById(Long id);

}
