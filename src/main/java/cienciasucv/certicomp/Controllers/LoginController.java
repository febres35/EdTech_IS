package cienciasucv.certicomp.Controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;


import cienciasucv.certicomp.Models.User;

public class LoginController{

  User user = new User();

  public Map <String, Object> checkCredentials(String mail, String password) {

    Map <String, Object> voidMap = new HashMap<>();


    try {
      FileReader fileReader = new FileReader("src/main/resources/data/credentials.json");
      JSONTokener jsonTokener = new JSONTokener(fileReader);
      JSONObject jsonObject = new JSONObject(jsonTokener);
      JSONArray array = jsonObject.getJSONArray("Datos");
      
      String path = "src/main/resources/data/users.json";

      for (int i = 0; i < array.length(); i++) {
        JSONObject jsonObject2 = array.getJSONObject(i);
        if (jsonObject2.getString("mail").equals(mail) && jsonObject2.getString("password").equals(password)) {
          
          return user.searchUserById(path,jsonObject2.getString("id"));
          
        }
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (JSONException e) {
      e.printStackTrace();
    }

    return voidMap;
  }
    
}
    
  
