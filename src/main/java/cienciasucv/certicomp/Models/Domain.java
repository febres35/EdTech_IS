package cienciasucv.certicomp.Models;

public class Domain {
    private String id;
    private String name;
    private String description;
   
    Domain(String id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;

    }

    String getID(){
        return id;
    }

    String getName(){
        return name;
    }

    String getDescription(){
        return description;
    }
}