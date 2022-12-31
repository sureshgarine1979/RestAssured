package jsonpath.examples;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.Map;


public class ConvertNestedJsonObjectResponseToMap {

    @Test
    public void convertJsonObjectResponseToMap(){
        Map jsonResponseMap = RestAssured
                .given()
                .get("https://run.mocky.io/v3/61bc6d86-1e53-4cb0-bd58-b163c193ee45")
                .as(Map.class);
        System.out.println(jsonResponseMap.get("address"));

        jsonResponseMap.keySet().forEach(key -> System.out.println(key));
        System.out.println("***********************");
        jsonResponseMap.values().forEach(value -> System.out.println(value));

        jsonResponseMap.forEach((key,value)-> System.out.println(key+"  "+value));

        System.out.println("****************************");
        System.out.println(jsonResponseMap.get("skills"));
        Map<String,String > skillsMap = (Map<String,String >) jsonResponseMap.get("skills");
        skillsMap.forEach((key,value)-> System.out.println(key+"  " +value));

    }
}
