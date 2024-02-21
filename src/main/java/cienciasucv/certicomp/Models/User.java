package cienciasucv.certicomp.Models;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

class User {

    protected String name;
    protected String lastname;
    protected String nationalID;
    protected String email;
    protected enum role{
        STUDENT,
        ADMIN;
    }
    protected role role;

    public User(String name, String lastname, String nationalID, String email) {
        
        this.name = name;
        this.lastname = lastname;
        this.nationalID = nationalID;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNationalID() {
        return nationalID;
    }

    public String getEmail() {
        return email;
    }

    public role getRole() {
        return role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public void setEmail(String email) {
        this.email= email;
    }

    public void setRole(role role) {
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
    

}
