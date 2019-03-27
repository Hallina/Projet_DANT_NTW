package Controllers;

import services.UserService;
import Models.User;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonArray;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/users")
public class UserController {
    @Inject
    private UserService userService;

    @Path("/all")
    @GET
    @Produces("application/json")
    public JsonArray getAll(){
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for (User user : userService.getAll()){
            builder.add(Json.createObjectBuilder().add("email",user.getEmail()));
        }
        return builder.build();
    }

}
