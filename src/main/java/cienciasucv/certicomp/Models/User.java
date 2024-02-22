package cienciasucv.certicomp.Models;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class User {

    private String nationalId;
    private String name;
    private String lastname;
    private String role;

    public User(Map<String, Object> attributes) {

        if(!attributes.isEmpty()){
            this.nationalId =  attributes.get("nationalId").toString();
            this.name = attributes.get("name").toString();
            this.lastname =  attributes.get("lastname").toString();
            this.role =  attributes.get("role").toString();
        }else{
            this.nationalId =  "";
            this.name =  "";
            this.lastname = "";
            this.role = "";
        }
        
    }

    public User(){

    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNationalID() {
        return nationalId;
    }

    public String getRole() {
        return role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setNationalID(String nationalId) {
        this.nationalId = nationalId;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void registerUser(User user){

        String jsonData = new Gson().toJson(user); 
        
        try (FileWriter writer = new FileWriter("users.json")) {
            writer.write(jsonData);
        } catch (IOException e) {
        }
    }

    public static Map<String, String> getUsersInfo() {

        
        Gson gson = new Gson();
        java.lang.reflect.Type type = new TypeToken<Map<String, User>>(){}.getType();
        Map<String, String> usersInfo  = new HashMap<>();

        InputStream inputStream = Course.class.getResourceAsStream("/data/users.json");
        Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        Map<String, User> users = gson.fromJson(reader, type);
        try {
            reader.close();
            inputStream.close();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        

        for (Map.Entry<String, User> entry : users.entrySet()) {
            usersInfo.put(entry.getKey(), entry.getValue().getName());
        }
        return usersInfo;
    }
    
    public Map<String, Object> searchUserById(String jsonFilePath, String idToCompare) throws IOException {
   
        File file = new File(jsonFilePath);    
        Map<String, JsonElement> userAttributes = new HashMap<>();
        Map<String, Object> userGot = new HashMap<>();

        if (file.exists()) {
                
            try (FileReader reader = new FileReader(file)) {
                JsonObject users = new Gson().fromJson(reader, JsonObject.class);
                JsonObject receptor = new JsonObject();
                for (String userId : users.keySet()) {
                    
                    if(userId.equals(idToCompare)){
            
                        userGot.put("name", users.get(userId).getAsJsonObject().get("name").getAsString());
                        userGot.put("lastname", users.get(userId).getAsJsonObject().get("lastname").getAsString());
                        userGot.put("nationalId", userId);
                        userGot.put("role", users.get(userId).getAsJsonObject().get("role").getAsString());
                    
                        return userGot;
                    }
                }         
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
        return null;
    }
  
}
