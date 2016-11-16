package tests;

import model.AccountTracker;
import model.AccountType;

import static org.junit.Assert.*;

/**
 * Created by Kalya Subramanian on 11/14/16.
 * Tests to check correctness of AccountTracker#addAccount
 */
public class AccountTrackerTest {
    /**
    @ Before
    public void setUp() throws Exception {


    }

    @ After
    public void tearDown() throws Exception {

    }
    */

    @org.junit.Test
    public void addAccount() {
        AccountTracker at = new AccountTracker();

        assertTrue(at.addAccount("User", "Password", AccountType.User));
        assertFalse(at.addAccount("User", "Password", AccountType.User));

    }

}