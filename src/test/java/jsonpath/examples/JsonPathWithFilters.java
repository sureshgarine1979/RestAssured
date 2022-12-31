package jsonpath.examples;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class JsonPathWithFilters {
    @Test
    public void jsonPathWithFilter(){
        String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\jsonpath\\examples\\People.json";
        File file = new File(filePath);
        JsonPath jsonPath = new JsonPath(file);
        List<String> maleLastNames = jsonPath.getList("findAll{it.gender=='Male'}.last_name");
        System.out.println(maleLastNames.toString());

        List<String> hesbrookLastName = jsonPath.getList("findAll{it.first_name=='Shellie' | it.last_name=='Benazet'}.email");
        System.out.println(hesbrookLastName);

        List<String> firstNamesWhoseIdGreaterThan5 = jsonPath.getList("findAll{it.id >5}.first_name");
        System.out.println(firstNamesWhoseIdGreaterThan5.toString());

        String firstNamesWhoseIdIs6 = jsonPath.getString("find{it.id >5}.first_name");
        System.out.println(firstNamesWhoseIdIs6);

        //size of the array

        System.out.println(jsonPath.getInt("size()"));


    }
}
