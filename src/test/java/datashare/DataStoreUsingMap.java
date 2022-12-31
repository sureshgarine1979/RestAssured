package datashare;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class DataStoreUsingMap {
    private DataStoreUsingMap(){};

    private static HashMap<String,Object> dataMap = new LinkedHashMap<>();

    public static void setValue(String key,Object value){
        dataMap.put(key,value);
    }

    public static Object getValue(String key){
        return dataMap.get(key);
    }

}
