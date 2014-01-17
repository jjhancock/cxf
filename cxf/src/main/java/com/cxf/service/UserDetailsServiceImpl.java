/**
 * 
 */
package com.cxf.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxf.domain.Role;

/**
 * @author jjhancock
 * 
 */
@Service(value="userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService
{		
	private static final Logger LOG = Logger.getLogger(UserDetailsServiceImpl.class);
	
	@Autowired
	private UserService userService;

	public UserDetailsServiceImpl()
	{
		super();
	}

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException
	{
		User result = null;

		try
		{
			com.cxf.domain.User domainUser = userService.findByUserIdAndVerified(username, Boolean.TRUE);
			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;

			if (domainUser != null)
			{
				result = new User(domainUser.getUserId(), domainUser.getPassword()
						.toLowerCase(), enabled, accountNonExpired,
						credentialsNonExpired, accountNonLocked,
						getAuthorities(domainUser.getRoles()));
				
				domainUser.setLoginBeforeLast(domainUser.getLastLogin());
				domainUser.setLastLogin(new Date());
				userService.saveAndFlush(domainUser);
			}
		}
		catch (Exception e)
		{
			LOG.error(e);
			throw new RuntimeException(e);
		}
		return result;		
	}

	public Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles)
	{
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();		
		authList = getGrantedAuthorities(roles);
		
		return authList;
	}

	public static List<GrantedAuthority> getGrantedAuthorities(
			Set<Role> roles)
	{
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Role role : roles)
		{
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		return authorities;
	}

}