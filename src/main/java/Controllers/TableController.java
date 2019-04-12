package Controllers;

import index.Table;
import services.TableService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/table")
@Consumes("application/json")
@Produces("application/json")
public class TableController {
	//API REST avec les différentes type de requêtes
    private static final TableService tableService = new TableService();

    //TODO a supprimer
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String helloWorld() {
        return "Hello World";
    }

    @POST
    @Path("/create")
    public Response create (Table table){ // remplacer par String
        tableService.add(table);
        return Response.ok().build();
    }

    @GET
    public Table get (@QueryParam("name") String name){
    	return tableService.get(name);
    }

    @GET
    @Path("/search")
    public List<Object[]> search (List<String> colNames, List<Models.Where> wheres){
        //TODO a modifier
        return null;
    }

}
