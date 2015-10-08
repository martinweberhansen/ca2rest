package rest;

import JSONConverter.JSONConverter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entities.Person;
import facade.Facade;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

@Path("info")
public class RestAPI {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    JsonParser parser = new JsonParser();
    Facade facade = new Facade();
    JSONConverter converter = new JSONConverter();
    
    
    @Context
    private UriInfo context;

   
    public RestAPI() {
    }

    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public String getPerson(@PathParam("id") String id){
        JsonObject response = new JsonObject();
        int newId = Integer.parseInt(id);
        Person p = facade.getPerson(newId);
        
        response.addProperty("fName", p.getfName());
        response.addProperty("lName", p.getlName());
        response.addProperty("email", p.getEmail());
        return gson.toJson(response);
    }
    
    @POST
    @Path("/person")
    @Consumes("application/json")
    public void postPerson(String js){
        Person p = JSONConverter.getPersonFromJson(js);
        
        facade.addPerson(p);
    }
    
    
    
    
}
