package jsonpath.examples;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import org.testng.annotations.Test;
import java.util.Map;


public class ConvertJsonObjectResponseToMap {

    @Test
    public void convertJsonObjectResponseToMap(){
        Map jsonResponseMap = RestAssured
                .given()
                .get("https://run.mocky.io/v3/c7f7e0fd-19e7-47ce-814b-022577ce05c4")
                .as(Map.class);
        System.out.println(jsonResponseMap.get("address"));

        jsonResponseMap.keySet().forEach(key -> System.out.println(key));
        System.out.println("***********************");
        jsonResponseMap.values().forEach(value -> System.out.println(value));

        jsonResponseMap.forEach((key,value)-> System.out.println(key+"  "+value));

    }

    @Test
    public void convertJsonObjectResponseToMapWithTypeRef(){
        Map jsonResponseMap = RestAssured
                .given()
                .get("https://run.mocky.io/v3/c7f7e0fd-19e7-47ce-814b-022577ce05c4")
                .as(new TypeRef<Map<String,Object>>() {
                });
        System.out.println(jsonResponseMap.get("address"));

        jsonResponseMap.keySet().forEach(key -> System.out.println(key));
        System.out.println("***********************");
        jsonResponseMap.values().forEach(value -> System.out.println(value));

        jsonResponseMap.forEach((key,value)-> System.out.println(key+"  "+value));

    }
}
