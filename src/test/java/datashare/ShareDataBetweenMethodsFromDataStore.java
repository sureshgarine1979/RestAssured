package datashare;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class ShareDataBetweenMethodsFromDataStore {

    @Test(priority = 1)
    public void createBooking(){
        int id =   RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"firstname\" : \"Suresh\",\n" +
                        "    \"lastname\" : \"Garine\",\n" +
                        "    \"totalprice\" : 1000,\n" +
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
        DataStoreUsingMap.setValue(Constants.BOOKING_ID, id);
        System.out.println(DataStoreUsingMap.getValue(Constants.BOOKING_ID));

    }

    @Test(priority = 2)
    public void getBookingDetailsWithId(){
        RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/{id}")
                .pathParam("id",DataStoreUsingMap.getValue(Constants.BOOKING_ID))
                .get()
                .then()
                .log()
                .all()
                .extract()
                .asPrettyString();
    }
}
