/**
 * 
 */
package com.cxf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxf.domain.User;
import com.cxf.repo.UserRepo;

/**
 * @author justin.hancock
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService
{

	@Autowired
	private UserRepo uRepo;
	/**
	 * 
	 */
	public UserServiceImpl()
	{
		super();
	}

	@Override
	@Transactional(readOnly = true)
	public User findById(Long id)
	{
		return uRepo.findById(id);
	}

}
