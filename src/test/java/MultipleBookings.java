import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MultipleBookings {
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    @BeforeClass
    public void setupRequestSpec(){
        requestSpecification = RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType(ContentType.JSON);
    }
    @BeforeClass
    public void postMethodValidation(){
        responseSpecification =RestAssured.expect();
        responseSpecification
                .log()
                .all()
                .statusCode(200)
                .contentType(ContentType.JSON).
                time(Matchers.lessThan(5000L));
    }


    @Test
    public void createBooking1(){
        RestAssured
                .given()
                .spec(requestSpecification)
                .basePath("/booking")
                .body("{\n" +
                        "    \"firstname\" : \"SureshG\",\n" +
                        "    \"lastname\" : \"Garine\",\n" +
                        "    \"totalprice\" : 113,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2018-01-02\",\n" +
                        "        \"checkout\" : \"2019-01-02\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                .when()
                .post()
                .then()
                .spec(responseSpecification);
    }

    @Test
    public void updateBooking(){
        RestAssured
                .given()
                .spec(requestSpecification)
                .basePath("/booking/{id}")
                .pathParam("id",10)
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
                .spec(responseSpecification);

    }

}
