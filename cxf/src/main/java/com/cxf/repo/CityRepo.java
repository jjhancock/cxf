/**
 * 
 */
package com.cxf.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cxf.domain.City;

/**
 * @author justin.hancock
 *
 */
public interface CityRepo extends JpaRepository<City, Long>
{
	List<City> findAll();
	
	City findById(Long id);

}
