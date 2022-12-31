package jsonpath.examples;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class NestedJsonExample {
    @Test
    public void nestedJsonPath(){
        String jsonStr = "{\n" +
                "  \"firstname\": \"James\",\n" +
                "  \"lastname\": \"Brown\",\n" +
                "  \"married\": true,\n" +
                "  \"salary\":145000,\n" +
                "  \"address\":{\n" +
                "    \"Street\": \"8425 166th AVE NE\",\n" +
                "    \"City\": \"Redmond\",\n" +
                "    \"State\": \"WA\",\n" +
                "    \"zipcode\":98052    \n" +
                "  }  \n" +
                "}";

        JsonPath jsonPath = new JsonPath(jsonStr);

        System.out.println(jsonPath.getInt("salary"));
        System.out.println((Object)jsonPath.get("address.Street"));
        System.out.println((Object)jsonPath.get("address.City"));
        System.out.println((Object)jsonPath.get("address"));
        System.out.println((Object)jsonPath.get("$"));

    }
}
