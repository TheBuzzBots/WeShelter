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

    /**
     * Constructs a default User.
     */
    User(){
        this("user", "password", "name", "User");
    }

    /**
     * Contructs a User given the provided information.
     * @param username username of the User
     * @param password password of the User
     * @param name name of the User
     * @param type type of the User (Admin or HomelessPerson)
     */
    User(String username, String password, String name, String type){
        this.username = username;
        this.password = password;
        this.name = name;
        this.type = type;
    }

    /**
     * Getter for password.
     * @return String password
     */
    public String getPassword(){
        return password;
    }

    /**
     * Getter for username.
     * @return String username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Getter for name.
     * @return String name of user
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for password.
     * @param password password of the user
     */
    public void setPassword(String password){
        this.password = password;
    }

    /**
     * Setter for username.
     * @param username username of the user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Setter for name.
     * @param name name of the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for type.
     * @return String type of user
     */
    public String getType() {
        return type;
    }

    /**
     * Setter for type.
     * @param type type of user
     */
    public void setType(String type) {
        if (legalTypes.contains(type)) {
            this.type = type;
        }
    }

    /**
     * Checks if a given password matches the User's password.
     * @param pass password provided
     * @return boolean whether or not pass matches password
     */
    public boolean checkPassword(String pass) {
        return password.equals(pass);
    }

    /**
     * Checks if a User is able to use the check-in feature
     * @return boolean if the User can check-in
     */
    public boolean canCheckIn() {
        return type.equals("User");
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (this == other) {
            return true;
        } else if (!(other instanceof User)) {
            return false;
        }
        User o = (User) other;
        return o.username.equals(this.username);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        for (int i = 0; i < this.username.length(); i++) {
            hash = hash * 31 + this.username.charAt(i);
        }
        return hash;
    }
}
