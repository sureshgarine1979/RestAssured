import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class GetAllBookings {
    @Test
    public void generateAuth(){

             RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .when()
                .get()
                .then()
                     .log()
                     .all()
                .body("bookingid",Matchers.hasItems(1,2232));

/*        System.out.println("**************************************");
        System.out.println(response);

        JsonPath jsonPath = new JsonPath(response);
        System.out.println("**************************************");
        System.out.println(jsonPath.getString("token"));
        Assert.assertNotNull(jsonPath.getString("token"));*/


    }
}
