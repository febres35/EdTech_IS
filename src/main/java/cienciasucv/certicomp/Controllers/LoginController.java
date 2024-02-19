package cienciasucv.certicomp.Controllers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class LoginController{

  public boolean checkCredentials(String mail, String password) {

    try {
      FileReader fileReader = new FileReader("src/main/resources/data/credentials.json");
      JSONTokener jsonTokener = new JSONTokener(fileReader);
      JSONObject jsonObject = new JSONObject(jsonTokener);
      JSONArray array = jsonObject.getJSONArray("Datos");

      for (int i = 0; i < array.length(); i++) {
        JSONObject jsonObject2 = array.getJSONObject(i);
        if (jsonObject2.getString("mail").equals(mail) && jsonObject2.getString("password").equals(password)) {
          return true;
        }
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (JSONException e) {
      e.printStackTrace();
    }

    return false;
  }

  public String typeOfUser(String id){

    

    return "Hi";
  }
}