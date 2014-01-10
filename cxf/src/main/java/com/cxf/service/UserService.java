/**
 * 
 */
package com.cxf.service;

import com.cxf.domain.User;

/**
 * @author justin.hancock
 *
 */
public interface UserService
{
	User findById(Long id);
	
}
