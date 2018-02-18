package edu.gatech.team10.weshelter;

/**
 * Created by Ben on 2/11/2018.
 */

public abstract class User {
    private String fName;
    private String lName;
    private String email;
    private String password;

    User(){
        this("user", "password", "fName", "lName");
    }

    User(String email, String password, String fName, String lName){
        this.email = email;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
    }
    public String getPassword(){
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFName() {
        return fName;
    }

    public String getlName() { return lName; }

    public void setPassword(String password){
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) { this.lName = lName; }
}
