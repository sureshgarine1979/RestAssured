package jsonpath.examples;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CreateJsonArrayPayloadUsingMap {

    public static void main(String[] args) {
        String jsonArrayStr = "[{\n" +
                "  \"id\": 1,\n" +
                "  \"first_name\": \"Hedda\",\n" +
                "  \"last_name\": \"Snalom\",\n" +
                "  \"email\": \"hsnalom0@g.co\",\n" +
                "  \"gender\": \"Female\",\n" +
                "  \"city\": \"Al Jamīmah\",\n" +
                "  \"address\": \"6 Hooker Pass\"\n" +
                "}, {\n" +
                "  \"id\": 2,\n" +
                "  \"first_name\": \"Dietrich\",\n" +
                "  \"last_name\": \"Ullrich\",\n" +
                "  \"email\": \"dullrich1@a8.net\",\n" +
                "  \"gender\": \"Male\",\n" +
                "  \"city\": \"Malian\",\n" +
                "  \"address\": \"51 Golf Lane\"\n" +
                "}]";

        JsonPath jsonPath = new JsonPath(jsonArrayStr);
        int length = jsonPath.getList("$").size();
        System.out.println(length);

        Map<String,Object> empDetailsMap = new LinkedHashMap<>();

        empDetailsMap.put("id",2);
        empDetailsMap.put("first_name","Dietrich");
        empDetailsMap.put("last_name","Ullrich");
        empDetailsMap.put("email","dullrich1@a8.net");
        empDetailsMap.put("gender","Male");
        empDetailsMap.put("city","Malian");
        empDetailsMap.put("address","51 Golf Lane");

        List<Map<String,Object>> empList = new ArrayList<>();

        empList.add(empDetailsMap);

        empDetailsMap = new LinkedHashMap<>();

        empDetailsMap.put("id",3);
        empDetailsMap.put("first_name","Suresh");
        empDetailsMap.put("last_name","garine");
        empDetailsMap.put("email","garine@a8.net");
        empDetailsMap.put("gender","Male");
        empDetailsMap.put("city","RedM");
        empDetailsMap.put("address","WA");

        empList.add(empDetailsMap);


        RestAssured
                .given()
                .log()
                .all()
                .body(empList)
                .get();
    }

}
