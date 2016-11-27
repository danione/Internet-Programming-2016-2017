package bg.elsys.ip.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/filter")
@Api("filter")
public class FilterResource {
	
	@POST
	@ApiOperation(value = "filter phones", response = Filter.class, responseContainer = "List")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getFilteredPhones(Filter filt) {
		FilterService filterService = FilterService.getInstance();
		return Response.ok(filterService.filter(filt)).build();
	}

}
