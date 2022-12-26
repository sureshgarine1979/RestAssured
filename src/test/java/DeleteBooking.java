import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DeleteBooking {
    public static void main(String[] args) {
        RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/5")
                .header("Content-Type","application/json")
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .when()
                .delete()
                .then()
                .log()
                .all()
                .statusCode(201);
    }
}
