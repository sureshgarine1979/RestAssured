package jsonpath.examples;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;


public class ConvertDynamicJsonObjectToJavaObject {

    @Test
    public void vonvertDynamicJsonObjectToJavaObject(){
        Map jsonResponseMap = RestAssured
                .given()
                .get("https://run.mocky.io/v3/c7f7e0fd-19e7-47ce-814b-022577ce05c4")
                .as(Map.class);

        Response response = RestAssured.get("https://run.mocky.io/v3/b61ffc6e-5de0-4a9c-9bd8-c33ba1c67849");

        Object responseAsObject = response.as(Object.class);

        if(responseAsObject instanceof List){
            List responseAsList =(List)responseAsObject;
            System.out.println(responseAsList.size());
        }

        if(responseAsObject instanceof Map){
            Map responseAsMap = (Map)responseAsObject;
            System.out.println(responseAsMap.keySet());
        }

        /*System.out.println(jsonResponseMap.get("address"));

        jsonResponseMap.keySet().forEach(key -> System.out.println(key));
        System.out.println("***********************");
        jsonResponseMap.values().forEach(value -> System.out.println(value));

        jsonResponseMap.forEach((key,value)-> System.out.println(key+"  "+value));*/

    }

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
