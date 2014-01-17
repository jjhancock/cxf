package com.cxf.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cxf.domain.Role;

public interface RoleRepo extends JpaRepository<Role, Long>
{
	
	Role findById(Long id);
	
	List<Role> findAll();
	
	Role findByRoleName(String roleName);

}
