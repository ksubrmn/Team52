package model;

import java.io.PrintWriter;
import java.io.Serializable;

public class User implements Serializable {

    private final String username;
    private final String password;
    private String email, address, title;
    private final AccountType accountType;


    /* **********************
     * Getters and setters for properties
     */
    public String getUsername() { return username; }
    //public void setUsername(String name) { username = name; }

    public String getPassword() {return password; }
    //public void setPassword(String pass) { password = pass; }

    public AccountType getAccountType() { return accountType; }
    //public void setAccountType(AccountType accountType) { this.accountType = accountType; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    //Don't comment this out, needed for login
    public void saveTo(PrintWriter out) {

        out.println(username + "\t" + password + "\t" + email + "\t" + address + title + "\t" + "\t" + accountType);

    }

    @Override
    public String toString() {
        return "User: " + username + ":  " + accountType;
    }

    /**
     * Creates new User
     *
     * @param username the username
     * @param password the password
     * @param accountType the account type
     */
    public User (String username, String password, AccountType accountType) {
        this.username = username;
        this.password = password;
        this.accountType = accountType;
        email = "[Not Set]";
        address = "[Not Set]";
        title = "[Not Set]";
    }


}
