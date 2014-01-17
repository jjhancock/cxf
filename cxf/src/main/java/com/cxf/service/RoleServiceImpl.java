/**
 * 
 */
package com.cxf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxf.domain.Role;
import com.cxf.repo.RoleRepo;

/**
 * @author justin.hancock
 *
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService
{
	@Autowired
	private RoleRepo roleRepo;
	
	/**
	 * 
	 */
	public RoleServiceImpl()
	{
		super();
	}

	@Override
	public Role findById(Long id)
	{
		return roleRepo.findById(id);
	}

	@Override
	public List<Role> findAll()
	{
		return roleRepo.findAll();
	}

	@Override
	public Role findByRoleName(String roleName)
	{
		return roleRepo.findByRoleName(roleName);
	}

}
