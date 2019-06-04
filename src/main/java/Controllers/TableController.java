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

    //TODO à supprimer
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String helloWorld() {
        return "Hello World";
    }

    @POST
    @Path("/create/{name_table}")
    public Response create(@PathParam("name_table") String name){
        tableService.add(new Table(name));
        return Response.status(200).entity("Création de la table : " + name).build();
    }

    @GET
    @Path("/get/{name_table}")
    @Produces(MediaType.APPLICATION_JSON)
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
