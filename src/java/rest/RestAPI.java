package rest;

import JSONConverter.JSONConverter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import entities.Hobby;
import entities.Person;
import exception.PersonNotFoundException;
import facade.Facade;
import java.util.List;
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
    @Path("person/{id}")
    @Produces("application/json")
    public String getPerson(@PathParam("id") String id) throws PersonNotFoundException{
        
        JsonObject response = new JsonObject();
        int newId = Integer.parseInt(id);
        Person p = facade.getPerson(newId);
        
        response.addProperty("fName", p.getfName());
        response.addProperty("lName", p.getlName());
        response.addProperty("email", p.getEmail());
        return gson.toJson(response);
    }
    
    @GET
    @Path("person/hobby/{id}")
    @Produces("application/json")
    public String getPersonsByHobby(@PathParam("id")String id){
        
        JsonArray response = new JsonArray();
        List<Person> pList = facade.getPersonsByHobbyId(id);
        
        for (int i = 0; i < pList.size(); i++) {
            
            JsonObject jsObj = new JsonObject();
            Person p = pList.get(i);
            
            jsObj.addProperty("fName", p.getfName());
            jsObj.addProperty("lName", p.getlName());
            response.add(jsObj);
            //response.addProperty("email", p.getEmail());
        }
        return gson.toJson(response);
    }
    
    @GET
    @Path("hobby/{id}")
    public String getHobby(@PathParam("id") String id){
    
            JsonObject response = new JsonObject();
            int newId = Integer.parseInt(id);
            Hobby hobby = facade.getHobbyById(newId);
            
            response.addProperty("id", hobby.getId());
            response.addProperty("description", hobby.getDescription());
            response.addProperty("name", hobby.getName());
            return gson.toJson(response);
    }
    
     @POST
    @Path("person")
    @Consumes("application/json")
    public void postPerson(String js){
        Person p = JSONConverter.getPersonFromJson(js);
        
        facade.addPerson(p);
    }
    
    @POST
    @Path("hobby")
    @Consumes("application/json")
    public void postHobby(String js){
        Hobby hobby = JSONConverter.getHobbyFromJson(js);
        
        facade.addHobby(hobby);
    }
    
    
}
