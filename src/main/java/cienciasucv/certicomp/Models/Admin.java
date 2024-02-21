package cienciasucv.certicomp.Models;

public class Admin extends User {
    private String adminID;

    public Admin(String name, String lastname, String nationalID, String email, String adminID) {
        super(name, lastname, nationalID, email);
        this.adminID = adminID;
        setRole(role.ADMIN);
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

}
