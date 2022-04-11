import static io.restassured.RestAssured.*;

import java.net.URISyntaxException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import java.net.URI;
public class put {
    public static void main(String args[])throws URISyntaxException
    {
        URI url=new URI("https://gorest.co.in/public/v2/users/3579");
//
        String request="{\n" +

                "\"name\": \"AmanBro\",\n" +
                "\"email\": \"amanhero@gmail.com\",\n" +
                "\"gender\": \"male\",\n" +
                "\"status\": \"active\"\n" +
                "}";
        given().contentType(ContentType.JSON)
                .header("Authorization","Bearer 3dcb1b5b78f34a1ac036c9a7488c4d581c43c800f1eef19efc34e3ce0c3819c1")
                .and()
                .body(request).put(url).then().log().all();
    }
}