import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;

import java.net.URISyntaxException;

import static io.restassured.RestAssured.given;

public class assertion{
    public static void main(String[] args) throws URISyntaxException {
        // URI url= new URI("https://gorest.co.in/public/v2/users");
        RestAssured.baseURI = "https://gorest.co.in/";
        RestAssured.basePath = "public/v2/users";


        String req = "{\n" +
                " \"name\": \"RahulTagra\",\n" +
                " \"gender\": \"male\",\n" +
                " \"email\": \"rahul04@gmail.com\",\n" +
                " \"status\": \"active\"\n" +
                "}";

        // given().contentType(ContentType.JSON).get(url).then().log().all(); // to print the all the detail of the response
        // given().contentType(ContentType.JSON).get(url).getBody().prettyPrint(); // to print only the required body not other info
        // get request
       /* int status=given().contentType(ContentType.JSON).header("content-type","application/json").
                and().body(req).post().getStatusCode();
              System.out.print(status);*/


        //assertion imp topic = it is basically check the codtion wether the given result
        // is true or false
       /* given().contentType(ContentType.JSON).header("Accept","application/json").header("Content-Type","application/json").header("Authorization","6be81c10d39e2e9219342ef6d986cd4b17f91da107ea44d30a01a2e263f7fc48").
                and().body(req).post().then().log().all();*/

        given().contentType(ContentType.JSON).headers(
                        "Authorization",
                        "Bearer " + "3dcb1b5b78f34a1ac036c9a7488c4d581c43c800f1eef19efc34e3ce0c3819c1",
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                and().body(req).post().then().assertThat().body(Matchers.equalTo(req));
        // Pass full expected response body with Hamcrest matchers
        // .body(Matchers.equalTo(req));

        // System.out.print(response.toString());


    }
}