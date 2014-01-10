/**
 * 
 */
package com.cxf.rest.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.cxf.domain.Foo;
import com.cxf.rest.RestService;

/**
 * @author justin.hancock
 *
 */
@Path("/example")
@Service("exampleRestService")
public class ExampleRestService implements RestService
{

	public ExampleRestService()
	{
		super();
	}
	
	@GET
	@Path("/{num}")
	@Produces("application/json")
	public boolean isPrime(@PathParam("num") int num)
	{
		return (num % 2 == 0) == true;
	}
	
	@GET
	@Path("/foo")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public List<Foo> foo()
	{
		List<Foo> myFoo = new ArrayList<Foo>();
		myFoo.add(Foo.newInstance("duder", "el duderino"));
		myFoo.add(Foo.newInstance("yes", "no"));
		return myFoo;
		
	}

}
