/**
 * 
 */
package com.cxf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxf.domain.City;
import com.cxf.repo.CityRepo;

/**
 * @author justin.hancock
 *
 */
@Service("cityService")
public class CityServiceImpl implements CityService
{
	@Autowired
	private CityRepo cRepo;

	/**
	 * 
	 */
	public CityServiceImpl()
	{
		super();
	}

	/* (non-Javadoc)
	 * @see com.cxf.service.CityService#findAll()
	 */
	@Override
	public List<City> findAll()
	{
		return cRepo.findAll();
	}

	@Override
	public City findById(Long id)
	{
		return cRepo.findById(id);
	}

}
