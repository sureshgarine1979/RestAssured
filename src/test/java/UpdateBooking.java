import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UpdateBooking {
    public static void main(String[] args) {
        RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/{id}")
                .pathParam("id",1)
                .contentType(ContentType.JSON)
                .accept("application/json")
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .body("{\n" +
                        "    \"firstname\" : \"James\",\n" +
                        "    \"lastname\" : \"Brown\",\n" +
                        "    \"totalprice\" : 111,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2018-01-01\",\n" +
                        "        \"checkout\" : \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                .when()
                .put()
                .then()
                .log()
                .all()
                .statusCode(200);
    }
}
