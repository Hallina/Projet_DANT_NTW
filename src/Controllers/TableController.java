package Controllers;

import index.Table;
import services.TableService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/api/table")
@Consumes("application/json")
@Produces("application/json")
public class TableController {
	//API REST avec les différentes type de reqûetes
    private static final TableService tableService = new TableService();

    @POST
    public Response create (Table table){
        tableService.add(table);
        return Response.ok().build();
    }

    @GET
    public Response get (String name){
    	tableService.get(name);
    	return Response.ok().build();
    }

}
