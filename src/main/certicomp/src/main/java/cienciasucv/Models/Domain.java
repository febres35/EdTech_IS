package cienciasucv.Models;

public class Domain {
    int domainID;
    String name;
    public Domain(int domainID, String name){
        setDomainID(domainID);
        setName(name);
    }
    public int getDomainID() {
        return domainID;
    }
    public String getName() {
        return name;
    }
    public void setDomainID(int domainID) {
        this.domainID = domainID;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
