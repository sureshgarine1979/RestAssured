package jsonpath.examples;

import io.restassured.RestAssured;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CreateJsonObjectPayLoadUsingMap {

    public static void main(String[] args) {
        String jsonPayLoad ="{\n" +
                "    \"id\": 1,\n" +
                "    \"first_name\": \"Suresh Babu\",\n" +
                "    \"last_name\": \"Garine\",\n" +
                "    \"married\": true,\n" +
                "    \"salary\":200000,\n" +
                "    \"email\": \"suresh.garine@testmail.com\",\n" +
                "    \"gender\": \"Male\"\n" +
                "  }";

                Map<String,Object> payLoadMap = new LinkedHashMap<>();
                    payLoadMap.put("id",1);
                    payLoadMap.put("first_name","Suresh Babu");
                    payLoadMap.put("last_name","Garine");
                    payLoadMap.put("married",true);
                    payLoadMap.put("salary",200000);
                    payLoadMap.put("email","suresh.garine@testmail.com");
                    payLoadMap.put("gender","Male");

                Map<String,String> addressMap = new LinkedHashMap<>();

                addressMap.put("street","8415 44th ave NE");
                addressMap.put("city","Redmond");
                addressMap.put("state","WA");
                addressMap.put("zip code","98052");

                payLoadMap.put("address",addressMap);
                RestAssured
                        .given()
                        .log()
                        .all()
                        .body(payLoadMap)
                        .get()
                        .asPrettyString();
    }
}
