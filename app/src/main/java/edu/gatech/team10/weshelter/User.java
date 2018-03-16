package edu.gatech.team10.weshelter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ben on 2/11/2018.
 */

public abstract class User {
    private String name;
    private String username;
    private String password;
    private String type;
    public static List<String> legalTypes = Arrays.asList("User", "Admin");

    User(){
        this("user", "password", "name", "User");
    }

    User(String username, String password, String name, String type){
        this.username = username;
        this.password = password;
        this.name = name;
        this.type = type;
    }

    public String getPassword(){
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean checkPassword(String pass) {
        return password.equals(pass);
    }

    public boolean canCheckIn() {
        return type.equals("User");
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) { return false; }
        if (this == other) { return true; }
        if (!(other instanceof User)) {return false; }
        User o = (User) other;
        if (o.username.equals(this.username)) { return true; }
        else { return false; }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        for (int i = 0; i < this.username.length(); i++) {
            hash = hash*31 + this.username.charAt(i);
        }
        return hash;
    }
}
