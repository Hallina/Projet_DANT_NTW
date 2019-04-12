package Controllers;

import index.Table;
import services.TableService;

import javax.ws.rs.*;
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
    public Table get (String name){
    	return tableService.get(name);
    }

    @GET
    public List<Object[]> search (List<String> colNames, List<Where> wheres){
    	
    }

}
