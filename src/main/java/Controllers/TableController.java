package Controllers;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import Models.Where;
import index.CSVParser;
import index.Index;
import index.Table;
import services.TableService;

import java.util.ArrayList;
import java.util.Map.Entry;

@Path("/api/table")
@Consumes("application/json")
@Produces("application/json")
public class TableController {
	//API REST avec les différentes type de requêtes
    private static final TableService tableService = new TableService();

    //Création de Table et ajout à "tables"
    @POST
    @Path("/create/{name_table}")
    public Response create(@PathParam("name_table") String name){
        tableService.add(new Table(name));
        return Response.status(200).entity("Creation de la table : " + name).build();
    }
    
    //GET table "name" en JSON
    @GET
    @Path("/get/{name_table}")
    public String select(@PathParam("name_table") String name){
    	return new Gson().toJson(tableService.get(name));
    }
    
    //GET all tables en JSON
    @GET
    @Path("/get/all")
    public String get_all() {
    	return new Gson().toJson(tableService.getTables());
    }
    
    //POST indexation de données dans table "name_table"
    @POST
    @Path("/update/{name_table}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get (@PathParam("name_table") String name){
    	Table maTable = tableService.get(name);
    	tableService.add(maTable);
		ArrayList<Index> mesIndexes = maTable.getIndexes();
		
		try {
			new CSVParser("C:\\Users\\yasse\\Downloads\\test2.csv").separe_lines_champ();	
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		for(int i = 0; i < CSVParser.getChamps().size(); i++) {
			maTable.ajouterIndex();
		}
		
		int champPos = 0;
		for(int j = 0; j < mesIndexes.size(); j++) {
			Index index = mesIndexes.get(j);
			for(int k = 0; k < CSVParser.getLines().size(); k++) {
				String word = CSVParser.getLines().get(k)[champPos];
				index.insert(word);
			}
			champPos++;
		}
    	return Response.status(200).entity("Indéxation de données dans la table : " + name).build();
    }
    
    //GET requete select from where
    @GET
    @Path("/get/{field}/{value}")
    public String search(@PathParam("field") String field, @PathParam("value") String value) {
    	ArrayList<ArrayList<String[]>> res = new ArrayList<>();
    	for(Entry<String, Table> keyvalue : tableService.getTables().entrySet()) {
    		ArrayList<String[]> aux = keyvalue.getValue().select(CSVParser.getChamps(), new Where(field,value));
    		if(aux != null) {
    			res.add(aux);
    		}
    	}
    	return new Gson().toJson(res);
    }
}
