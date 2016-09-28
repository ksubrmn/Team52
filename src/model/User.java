package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {

    private final StringProperty username = new SimpleStringProperty();
    private final StringProperty password = new SimpleStringProperty();
    private AccountType accountType;

    /* **********************
     * Getters and setters for properties
     */
    public String getUsername() { return username.get(); }
    public void setUsername(String name) { username.set(name); }

    public String getPassword() {return password.get(); }
    public void setPassword(String major) { password.set(major); }

    public AccountType getAccountType() { return accountType; }
    public void setAccountType(AccountType accountType) { this.accountType = accountType; }

    public User (String username, String password, AccountType accountType) {
        this.username.set(username);
        this.password.set(password);
        this.accountType = accountType;
    }
}
