package jsonpath.examples;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class JsonPathWithFilters1 {
    @Test
    public void jsonPathWithFilter(){
        String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\jsonpath\\examples\\People1.json";
        File file = new File(filePath);
        JsonPath jsonPath = new JsonPath(file);
        List<String> maleLastNames = jsonPath.getList("data.findAll{it.gender=='Male'}.last_name");
        System.out.println(maleLastNames.toString());


    }
}
