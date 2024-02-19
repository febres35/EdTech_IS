package cienciasucv.certicomp.Models;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

public class User {

    private String name;
    private String lastname;
    private String nationalID;
    private String email;
    private String role;

    public User(String name, String lastname, String nationalID, String email, String role) {
        
        this.name = name;
        this.lastname = lastname;
        this.nationalID = nationalID;
        this.email = email;
        this.role = role;
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

    public String getRole() {
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

}
