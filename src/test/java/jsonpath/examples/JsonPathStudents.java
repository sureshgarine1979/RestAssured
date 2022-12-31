package jsonpath.examples;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class JsonPathStudents {
    @Test
    public void jsonPathForStudents(){
        String jsonString = "{\"students\": [\n" +
                "  {\n" +
                "    \"firstname\": \"James\",\n" +
                "    \"lastname\": \"Brown\",\n" +
                "    \"age\": 25,\n" +
                "    \"address\": [\n" +
                "      {\n" +
                "        \"city\": \"hyd\",\n" +
                "        \"state\": \"TN\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"city\": \"Seattle\",\n" +
                "        \"state\": \"WA\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"firstname\": \"sailu\",\n" +
                "    \"lastname\": \"Garine\",\n" +
                "    \"age\": 25,\n" +
                "    \"address\": [\n" +
                "      {\n" +
                "        \"city\": \"Chennai\",\n" +
                "        \"state\": \"TN\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"city\": \"Seattle\",\n" +
                "        \"state\": \"WA\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"firstname\": \"Ujwal\",\n" +
                "    \"lastname\": \"Garine\",\n" +
                "    \"age\": 25,\n" +
                "    \"address\": [\n" +
                "      {\n" +
                "        \"city\": \"NRT\",\n" +
                "        \"state\": \"TN\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"city\": \"Seattle\",\n" +
                "        \"state\": \"WA\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"firstname\": \"Sailaja\",\n" +
                "    \"lastname\": \"Garine\",\n" +
                "    \"age\": 25,\n" +
                "    \"address\": [\n" +
                "      {\n" +
                "        \"city\": \"hyd\",\n" +
                "        \"state\": \"TN\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"city\": \"Seattle\",\n" +
                "        \"state\": \"WA\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]}";

        JsonPath jsonPath = new JsonPath(jsonString);

        System.out.println(jsonPath.getString("students[1].address[0].city"));
        System.out.println("*********************** all cities - Suresh");
        System.out.println(jsonPath.getList("students.address.city"));

    }
}
