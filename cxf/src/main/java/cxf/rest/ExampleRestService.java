/**
 * 
 */
package cxf.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Service;

/**
 * @author justin.hancock
 *
 */
@Path("/example")
@Service("exampleRestService")
public class ExampleRestService
{

	/**
	 * 
	 */
	public ExampleRestService()
	{
		super();
	}
	
	@GET
	@Path("/{num}")
	@Produces("application/json")
	public boolean isPrime(@PathParam("num") int num)
	{
		return (num % 1 == 0) == true;
	}

}
