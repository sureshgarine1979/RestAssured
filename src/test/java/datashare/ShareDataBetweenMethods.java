package datashare;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class ShareDataBetweenMethods {

    private int bookingId;

    @Test(priority = 1)
    public void createBooking(){
        bookingId =   RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"firstname\" : \"Suresh\",\n" +
                        "    \"lastname\" : \"Garine\",\n" +
                        "    \"totalprice\" : 100,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2018-01-01\",\n" +
                        "        \"checkout\" : \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                .when()
                .post()
                .then()
                .extract()
                .jsonPath().getInt("bookingid");
        System.out.println(bookingId);
    }

    @Test(priority = 2)
    public void getBookingDetailsWithId(){
        RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/{id}")
                .pathParam("id",bookingId)
                .get()
                .then()
                .log()
                .all()
                .extract()
                .asPrettyString();
    }
}
