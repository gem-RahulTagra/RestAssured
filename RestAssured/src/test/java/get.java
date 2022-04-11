import static io.restassured.RestAssured.*;

import java.net.URI;
import java.net.URISyntaxException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

//import java.net.URI;
public class get {
    public static void main(String args[]) throws URISyntaxException
    {
        URI url=new URI("https://gorest.co.in/public/v2/users");
//        RestAssured.baseURI="https://reqres.in/";
//        RestAssured.basePath= "api/users?page=2";
        given().contentType(ContentType.JSON).get(url).then().log().all();

    }
}