package cienciasucv.certicomp.Models;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class Domain {
    private String id;
    private String name;
    private String description;
    public static Map<String, Domain> domains;
    public final static String path="src/main/resources/data/domains.json";
  //  private String description;

    public Domain(String id, String name){
        this.id = id;
        this.name = name;
     //   this.description = description;

    }

    static {
        loadDomainsFromFile();
    }
    
    public String getID(){
        return id;
    }

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }

    public static String getDescription(String domainID) {
        Domain domain = domains.get(domainID);
        return (domain != null) ? domain.getDescription() : null;
    }

    private static Map<String, Domain> loadDomainsFromFile() {
        Gson gson = new Gson();
        java.lang.reflect.Type type = new TypeToken<Map<String, Domain>>(){}.getType();
        try (Reader reader = new FileReader(path)) {
            domains = gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return domains;
    }
    

    public Domain getDomain(String domainID){

        return domains.get(domainID);

    }
  
    static public String getDomainByName(String domainName){
        for (Map.Entry<String,Domain> entry: domains.entrySet()){
            if(entry.getValue().getName().equals(domainName)){
                return entry.getKey();
            }
        }
        return null;
    }
    
    public static void createNewDom(Domain domain) {
    Domain.domains.put(domain.getID(), domain);
    Domain.organizarPorID();
    saveDomainsToJson();
}
    
    private static void organizarPorID() {
    Map<String, Domain> sortedDomsMap = new TreeMap<>(Domain.domains);
    Domain.domains.clear();
    Domain.domains.putAll(sortedDomsMap);
    }

    public static boolean domainExists(String name){  
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    JsonObject domains = new JsonObject();
    File file = new File(path);

    if (file.exists()) {
        try (FileReader reader = new FileReader(file)) {
            domains = gson.fromJson(reader, JsonObject.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        for (Map.Entry<String, JsonElement> entry : domains.entrySet()) {
            JsonObject jsonDomain = entry.getValue().getAsJsonObject();
            String domainName = jsonDomain.get("name").getAsString();
            
            if (domainName.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void saveDomainsToJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(path)) {
            gson.toJson(domains, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   public void deleteDomain(String domainToDeleteID) {
        domains.remove(domainToDeleteID);
        saveDomainsToJson();
    }

    public void editDomain(String originalDomainID, Domain editedDomain) {
       domains.put(originalDomainID, editedDomain);
       saveDomainsToJson();
    }


}