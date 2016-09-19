package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by kalyasubramanian1 on 9/19/16.
 */
public class User {

    private final StringProperty _username = new SimpleStringProperty();
    private final StringProperty _password = new SimpleStringProperty();

    /* **********************
     * Getters and setters for properties
     */
    public String getUsername() { return _username.get(); }
    public void setUsername(String name) { _username.set(name); }

    public String getPassword() {return _password.get(); }
    public void setPassword(String major) { _password.set(major); }
}
