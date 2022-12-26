import io.restassured.RestAssured;

public class PartialUpdateBooking {
    public static void main(String[] args) {
        RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/1")
                .header("Content-Type","application/json")
                .header("accept","application/json")
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .body("{\n" +
                        "    \"firstname\" : \"James\",\n" +
                        "    \"lastname\" : \"Brown\"\n" +
                        "}")
                .when()
                .patch()
                .then()
                .log()
                .all()
                .statusCode(200);
    }

}
