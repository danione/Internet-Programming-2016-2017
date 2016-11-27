package bg.elsys.ip.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/phones")
@Api("phones")
public class PhoneResource {

	@GET
	@ApiOperation(value = "get list of phones", response = Phone.class, responseContainer = "List")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPhones() {
		PhoneService phoneService = PhoneService.getInstance();
		return Response.ok(phoneService.getPhones()).build();
	}

	@POST
	@ApiOperation(value = "add new phone", response = Phone.class, responseContainer = "Status")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createPhone(Phone phone) {
		
		for(Phone ph : PhoneService.getInstance().getPhones()) {
            if(ph.getId() == phone.getId())
            {
            	return Response.serverError().status(Status.CONFLICT).build();
            }
		}
		PhoneService.getInstance().addPhone(phone);
		return Response.ok(phone).status(Status.CREATED).build();
	}
}
