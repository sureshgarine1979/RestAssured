package jsonpath.examples;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.List;


public class ConvertJsonObjectArrayResponseToMap {

    @Test
    public void convertJsonObjecArraytResponseToMap(){
        List<Map<String,Object>> jsonResponseMap = RestAssured
                .given()
                .get("https://run.mocky.io/v3/b61ffc6e-5de0-4a9c-9bd8-c33ba1c67849")
                //.as(List.class);
                .as(new TypeRef<List<Map<String,Object>>>() {
                });
       // System.out.println(jsonResponseMap.get("address"));

        Map<String,Object> emp1Map = (Map<String,Object>)jsonResponseMap.get(0);

        emp1Map.forEach((key,value)-> System.out.println(key+"   "+value));


/*        jsonResponseMap.keySet().forEach(key -> System.out.println(key));
        System.out.println("***********************");
        jsonResponseMap.values().forEach(value -> System.out.println(value));

        jsonResponseMap.forEach((key,value)-> System.out.println(key+"  "+value));*/

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
