package jsonpath.examples;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class JsonPathSimpleExample {

    @Test
    public void jsonpathSimpleExample1(){
        String jsonStr = "{\n" +
                "  \"firstname\": \"Suresh Babu\",\n" +
                "  \"lastname\": \"Garine\"\n" +
                "}";

        JsonPath jsonPath = new JsonPath(jsonStr);

        Object fname = jsonPath.get("firstname");
        Object lname = jsonPath.get("lastname");

       // System.out.println(fname+" "+lname);
        System.out.println((Object) jsonPath.get("$"));
        System.out.println(jsonPath.getString("$"));
    }
}
