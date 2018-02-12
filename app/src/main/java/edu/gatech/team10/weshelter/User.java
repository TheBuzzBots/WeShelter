package edu.gatech.team10.weshelter;

/**
 * Created by Ben on 2/11/2018.
 */

public class User {
    private String name;
    private String email;
    private String password;

    User(){
        this("user", "password", "name");
    }
    User(String email, String password, String name){
        this.email = email;
        this.password = password;
        this.name = name;
    }
    public String getPassword(){
        return password;
    }
    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }
}
