package apiConfig;
import java.util.HashMap;
import java.util.Map;


public class ParamsConfig {


    public Map<String, String> loginParams(String username , String password){
        Map<String, String> defaultParam = new HashMap<String, String>();
        defaultParam.put("username", username);
        defaultParam.put("password" ,password);


        return defaultParam;

    }



}