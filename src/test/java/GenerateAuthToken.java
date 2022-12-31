import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class GenerateAuthToken {
    @Test
    public void generateAuth(){

             RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"username\" : \"admin\",\n" +
                        "    \"password\" : \"password123\"\n" +
                        "}")
                .when()
                .post()
                .then()
                .body("token.length()", Matchers.is(15))
                .body("token.length()",Matchers.equalTo(15))
                        .body("token",Matchers.matchesRegex("^[a-z0-9]+$"));

/*        System.out.println("**************************************");
        System.out.println(response);

        JsonPath jsonPath = new JsonPath(response);
        System.out.println("**************************************");
        System.out.println(jsonPath.getString("token"));
        Assert.assertNotNull(jsonPath.getString("token"));*/


    }
}
