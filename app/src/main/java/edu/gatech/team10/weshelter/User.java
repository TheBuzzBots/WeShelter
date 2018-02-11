package edu.gatech.team10.weshelter;

/**
 * Created by Ben on 2/11/2018.
 */

public class User {
    private String email;
    private String password;

    User(){
        this("user", "password");
    }
    User(String email, String password){
        this.email = email;
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
}
