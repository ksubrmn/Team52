package model;

import java.util.ArrayList;
import java.util.List;

public class AccountTracker {

    private List<User> accounts;

    /**
     * Creates a new AccountTracker instance
     */
    public AccountTracker() {
        accounts = new ArrayList<>();
    }

    /**
     * Adds account to list of valid accounts
     * @param username New username
     * @param password New password
     * @param accountType Account type
     * @return true if account is added
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
     * Checks if user name and password are valid
     * @param username New username
     * @param password New password
     * @return true if account is valid
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
     * Finds User with given username
     * @param username Username to search for
     * @return proper User object
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
