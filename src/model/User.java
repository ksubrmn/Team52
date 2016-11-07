package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;

public class User implements Serializable {

    private String username;
    private String password;
    private String email, address, title;
    private AccountType accountType;


    /* **********************
     * Getters and setters for properties
     */
    public String getUsername() { return username; }
    public void setUsername(String name) { username = name; }

    public String getPassword() {return password; }
    public void setPassword(String pass) { password = pass; }

    public AccountType getAccountType() { return accountType; }
    public void setAccountType(AccountType accountType) { this.accountType = accountType; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public void saveTo(PrintWriter out) {

        out.println(username + "\t" + password + "\t" + email + "\t" + address + title + "\t" + "\t" + accountType);

    }

    public String toString() {
        String res = "User: " + username + ":  " + accountType;
        return res;
    }

    public User (String username, String password, AccountType accountType) {
        this.username = username;
        this.password = password;
        this.accountType = accountType;
        email = "[Not Set]";
        address = "[Not Set]";
        title = "[Not Set]";
    }


}
