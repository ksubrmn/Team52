package model;

import java.util.ArrayList;
import java.util.List;

public class AccountTracker {

    private List<User> accounts;

    public AccountTracker() {
        accounts = new ArrayList<>();
    }

    public boolean addAccount(String username, String password, AccountType accountType) {
        for (User account: accounts) {
            if (account.getUsername().equals(username)) {
                return false;
            }
        }
        accounts.add(new User(username, password, accountType));
        return true;
    }

    public boolean checkAccount(String username, String password) {
        for (User account: accounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public User getUser(String username) {
        for (User user: accounts) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
