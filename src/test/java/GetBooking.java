import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GetBooking {
    public static void main(String[] args) {
        RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("booking/{id}")
                .pathParam("id",1)
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .log()
                .all()
                .statusCode(200);
    }
}
