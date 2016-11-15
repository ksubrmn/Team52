package tests;

import model.AccountTracker;
import model.AccountType;
import model.User;

import static org.junit.Assert.*;

/**
 * Created by Kalya Subramanian on 11/14/16.
 */
public class AccountTrackerTest {
    @org.junit.Before
    public void setUp() throws Exception {


    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void addAccount() throws Exception {
        AccountTracker at = new AccountTracker();

        assertTrue(at.addAccount("User", "Password", AccountType.User));
        assertFalse(at.addAccount("User", "Password", AccountType.User));

    }

}