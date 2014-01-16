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

	@Override
	public User findByUserIdAndVerified(String username, boolean verified)
	{
		return uRepo.findByUserIdAndVerified(username, verified);
	}

	@Override
	@Transactional
	public User saveAndFlush(User u)
	{
		return uRepo.saveAndFlush(u);
	}

	@Override
	public User findByUserId(String userId)
	{
		return uRepo.findByUserId(userId);
	}

}
