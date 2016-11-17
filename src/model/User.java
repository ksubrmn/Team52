package model;

import java.io.PrintWriter;
import java.io.Serializable;

/**
 * Represents a User
 */
public class User implements Serializable {

    private final String username;
    private final String password;
    private String email;
    private String address;
    private String title;
    private final AccountType accountType;


    /**
     * Returns the username
     * @return the username
     */
    public String getUsername() { return username; }
    //public void setUsername(String name) { username = name; }

    /**
     * Returns the password
     * @return the password
     */
    public String getPassword() {return password; }
    //public void setPassword(String pass) { password = pass; }

    /**
     * Returns the account type
     * @return the account type
     */
    public AccountType getAccountType() { return accountType; }
    //public void setAccountType(AccountType accountType) {
    // this.accountType = accountType; }

    /**
     * returns the email
     * @return the email
     */
    public String getEmail() { return email; }

    /**
     * Sets the email
     * @param email the email to set
     */
    public void setEmail(String email) { this.email = email; }

    /**
     * Returns the address
     * @return the address
     */
    public String getAddress() { return address; }

    /**
     * Sets the address
     * @param address the address to set
     */
    public void setAddress(String address) { this.address = address; }

    /**
     * Returns the title
     * @return the title
     */
    public String getTitle() { return title; }

    /**
     * Sets the title
     * @param title the title
     */
    public void setTitle(String title) { this.title = title; }

    /**
     * Saves this account's information to a new line
     * @param out The Writer to write the account information to
     */
    //Don't comment this out, needed for login
    public void saveTo(PrintWriter out) {

        out.println(username + "\t" + password + "\t" + email + "\t" + address
                + title + "\t" + "\t" + accountType);

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
