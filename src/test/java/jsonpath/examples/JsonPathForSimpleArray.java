package jsonpath.examples;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.util.List;

public class JsonPathForSimpleArray {
    @Test
    public void jsonPathForSimpleArray(){
        String jsonPathString = "[\n" +
                "  \"10\",\n" +
                "  \"20\",\n" +
                "  \"30\",\n" +
                "  \"40\",\n" +
                "  \"50\",\n" +
                "  \"60\",\n" +
                "  \"70\"  \n" +
                "]";

        String jsonPathString2 = "[[\n" +
                "  \"10\",\n" +
                "  \"20\",\n" +
                "  \"30\",\n" +
                "  \"40\",\n" +
                "  \"50\",\n" +
                "  \"60\"  \n" +
                "],\n" +
                "  [\n" +
                "  \"70\",\n" +
                "  \"80\",\n" +
                "  \"90\",\n" +
                "  \"100\",\n" +
                "  \"110\",\n" +
                "  \"120\"  \n" +
                "]]";

        JsonPath jsonPath = new JsonPath(jsonPathString);

        System.out.println(jsonPath.getString("[5]"));

        System.out.println(jsonPath.getList("$")); // list of elements in the arrayList
        System.out.println(jsonPath.getList("$").size()); // size of the List so that it helps to iterate over the list

        System.out.println("***********");
        jsonPath = new JsonPath(jsonPathString2);

        System.out.println(jsonPath.getString("[0][1]"));
        System.out.println(jsonPath.getString("[1][1]"));
        System.out.println(jsonPath.getString("[1]"));
        System.out.println("*******************************");
        List<Object> list = (List<Object>)jsonPath.getList("$").get(0);
        System.out.println(list.size());


    }
}
