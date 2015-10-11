
import static com.jayway.restassured.RestAssured.*;
import com.jayway.restassured.parsing.Parser;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.BeforeClass;


public class RestAssured {

    public RestAssured() {
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        baseURI = "http://localhost:8080";
        defaultParser = Parser.JSON;
        basePath = "/CA2_project/api/person";
    }

    
    //Verifies that the person with the given id
    //has the given fName and lName.
    public void testGet() {
        when()
                .get("/1").
        then().
                statusCode(200).
                body("fName", equalTo("Kasper")).
                body("lName", equalTo("Olesen"));
    }

    //Verifies that the response is 200(OK) 
    //when inserting a new person
    public void testPost() {
        given().
                body("{\"fName\": \"HenningTest\", \"lName\": \"Troelsen\"}").
        when().
                post("/person").
        then().
                statusCode(200);
    }
}
