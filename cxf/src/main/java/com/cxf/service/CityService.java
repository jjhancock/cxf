/**
 * 
 */
package com.cxf.service;

import java.util.List;

import com.cxf.domain.City;

/**
 * @author justin.hancock
 *
 */
public interface CityService
{
	List<City> findAll();
	
	City findById(Long id);
}
