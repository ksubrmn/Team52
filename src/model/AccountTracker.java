package model;

import java.util.ArrayList;
import java.util.List;

public class AccountTracker {

    private List<User> accounts;

    /**
     * Creates new account tracker
     */
    public AccountTracker() {
        accounts = new ArrayList<>();
    }

    /**
     * Adds a new account
     *
     * @param username the username
     * @param password the password
     * @param accountType the account type
     * @return whether or not it was added
     */
    public boolean addAccount(String username, String password, AccountType accountType) {
        for (User account: accounts) {
            if (account.getUsername().equals(username)) {
                return false;
            }
        }
        accounts.add(new User(username, password, accountType));
        return true;
    }

    /**
     * Checks if the account is in the tracker
     *
     * @param username the username
     * @param password the password
     * @return whether or not the acocunt was found
     */
    public boolean checkAccount(String username, String password) {
        for (User account: accounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns user
     *
     * @param username the username
     * @return the user
     */
    public User getUser(String username) {
        for (User user: accounts) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
