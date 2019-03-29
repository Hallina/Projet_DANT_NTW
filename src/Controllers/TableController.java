package Controllers;

import index.Table;
import services.TableService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/api/table")
@Consumes("application/json")
@Produces("application/json")
public class TableController {

    private static final TableService tableService = new TableService();

    @POST
    public Response create (Table table){
        tableService.add(table);
        return Response.ok().build();
    }

}
