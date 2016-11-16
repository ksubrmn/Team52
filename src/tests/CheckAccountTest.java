package tests;

import model.AccountTracker;
import model.AccountType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * Created by kevin on 11/15/2016.
 * Tests to check correctness of AccountTracker#checkAccount
 */
public class CheckAccountTest {

    private AccountTracker tracker;

    @Before
    public void setUp() {
        tracker = new AccountTracker();
    }

    @Test
    public void testEmptyList() {
        Assert.assertFalse(tracker.checkAccount("u", "p"));
    }

    @Test
    public void testOneElementList() {
        tracker.addAccount("u", "p", AccountType.Admin);
        Assert.assertTrue(tracker.checkAccount("u", "p"));
    }

    @Test
    public void testTwoOtherElements() {
        tracker.addAccount("1", "1", AccountType.Admin);
        tracker.addAccount("2", "2", AccountType.Admin);
        Assert.assertFalse(tracker.checkAccount("u", "p"));
    }

    @Test
    public void testFindingUser() {
        tracker.addAccount("u", "p", AccountType.User);
        Assert.assertTrue(tracker.checkAccount("u", "p"));
    }

    @Test
    public void testFindingManager() {
        tracker.addAccount("u", "p", AccountType.Manager);
        Assert.assertTrue(tracker.checkAccount("u", "p"));
    }

    @Test
    public void testFindingWorker() {
        tracker.addAccount("u", "p", AccountType.Worker);
        Assert.assertTrue(tracker.checkAccount("u", "p"));
    }

    @Test
    public void testAddThenRemove() {
        tracker.addAccount("u", "p", AccountType.Admin);
        Assert.assertTrue(tracker.checkAccount("u", "p"));
        tracker.setList(new ArrayList<>());
        Assert.assertFalse(tracker.checkAccount("u", "p"));
    }
}
