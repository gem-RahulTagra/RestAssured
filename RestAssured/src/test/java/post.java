import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.containsString;

import java.net.URISyntaxException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import java.net.URI;
public class post {
    public static void main(String args[])throws URISyntaxException
    {
        URI url=new URI("https://gorest.co.in/public/v2/users");
//

        String request="{\n" +

                "\"name\": \"rahultagra\",\n" +
                "\"email\": \"rt05@gmail.com\",\n" +
                "\"gender\": \"male\",\n" +
                "\"status\": \"active\"\n" +
                "}";
        given().contentType(ContentType.JSON)
                .header("Authorization","Bearer 3dcb1b5b78f34a1ac036c9a7488c4d581c43c800f1eef19efc34e3ce0c3819c1")
                .and()
                .body(request).post(url).then().log().all().assertThat().body("email",containsString("$")) ;
    }
}