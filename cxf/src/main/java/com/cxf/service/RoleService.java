/**
 * 
 */
package com.cxf.service;

import java.util.List;

import com.cxf.domain.Role;

/**
 * @author justin.hancock
 * 
 */
public interface RoleService
{

	Role findById(Long id);

	List<Role> findAll();

	Role findByRoleName(String roleName);

}
