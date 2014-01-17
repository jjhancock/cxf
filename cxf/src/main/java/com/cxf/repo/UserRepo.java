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
	
	User findByUserId(String userId);
	
	User findByUserIdAndVerified(String username, boolean verified);
	
	User saveAndFlush(User u);

}
