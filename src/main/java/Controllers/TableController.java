package Controllers;

import index.Table;
import services.TableService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/table")
@Consumes("application/json")
@Produces("application/json")
public class TableController {
	//API REST avec les différentes type de requêtes
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
    public List<Object[]> search (List<String> colNames, List<Models.Where> wheres){
        //TODO a modifier
        return null;
    }

}
