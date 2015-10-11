package JSONConverter;


import com.google.gson.Gson;
import entities.Hobby;
import entities.Person;
import java.util.List;

public class JSONConverter {    
    
       public static Person getPersonFromJson(String js){
           
           Gson gson = new Gson(); 
           Person p = gson.fromJson(js, Person.class);
           return p;
       } 
       
       public static Hobby getHobbyFromJson(String js){
           Gson gson = new Gson();
           Hobby h = gson.fromJson(js,Hobby.class);
           return h;
       }
 
       
       public static String getJSONFromPerson(Person p) {
           
           Gson gson = new Gson();
           String s = gson.toJson(p);
           return s;
       }  
       
       public static String getJSONFromPersons(List<Person> persons){
           Gson gson = new Gson();
           String s = gson.toJson(persons);
           return s;
       } 
       
       
 
}