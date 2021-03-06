package fxapp;
import java.util.Collection;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import controller.ApplicationController;
import controller.CreateAccountController;
import controller.EditProfileController;
import controller.HomeScreenController;
import controller.LoginScreenController;
import controller.MapScreenController;
import controller.PurityReportDetailsController;
import controller.ReportDetailsController;
import controller.SelectHistoryGraphController;
import controller.SubmitPurityReportController;
import controller.SubmitReportController;
import controller.ViewHistoryGraphController;
import controller.ViewPurityReportsController;
import controller.ViewReportController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.AccountTracker;
import model.AccountType;
import model.User;
import model.WaterPurityReport;
import model.WaterReportTracker;
import model.WaterSourceReport;

/**
 * Handles main program logic including switching screens
 */
public class Main extends Application {

    private BorderPane rootLayout;

    private AccountTracker accountTracker;

    private User user;

    private WaterReportTracker waterReportTracker;


    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass()
// .getResource("../view/WelcomeScreen.fxml"));
//        primaryStage.setTitle("Team 52");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
        accountTracker = new AccountTracker();
        waterReportTracker = new WaterReportTracker();

        accountTracker.addAccount("user", "pass", AccountType.User);
        initHomeScreen(primaryStage);
    }

    /**
     * Initialize home screen to welcome screen
     * @param mainScreen the main screen
     */
    private void initHomeScreen(Stage mainScreen) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class
                    .getResource("../view/WelcomeScreen.fxml"));
            rootLayout = loader.load();
            HomeScreenController controller = loader.getController();
            controller.setMainApp(this);
            mainScreen.setTitle("Title");
            Scene scene = new Scene(rootLayout);
            mainScreen.setScene(scene);
            mainScreen.show();
        } catch (IOException e) {
            Logger.getLogger("Main").log(Level.SEVERE,
                    "Failed to init Home screen. fxml not loaded?");
        }
    }

    /**
     * Changes display to Login Screen
     */
    public void showLoginScreen() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(
                    "../view/LoginDialog.fxml"));
            AnchorPane loginScreen = loader.load();
            rootLayout.setCenter(loginScreen);
            rootLayout.setBottom(null);
            rootLayout.setTop(null);
            LoginScreenController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            Logger.getLogger("Main").log(Level.SEVERE,
                    "Failed to init Login screen. Fxml not loaded?");
        }
    }

    /**
     * Changes display to Application Screen
     */
    public void showApplicationScreen() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(
                    "../view/ApplicationScreen.fxml"));
            AnchorPane loginScreen = loader.load();
            rootLayout.setCenter(loginScreen);
            rootLayout.setBottom(null);
            rootLayout.setTop(null);
            ApplicationController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            Logger.getLogger("Main").log(Level.SEVERE,
                    "Failed to init Application screen. Fxml not loaded?");
        }
    }

    /**
     * Changes display to Home Screen
     */
    public void showHomeScreen() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(
                    "../view/WelcomeScreen.fxml"));
            BorderPane loginScreen = loader.load();
            rootLayout.setCenter(loginScreen);
            HomeScreenController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            Logger.getLogger("Main").log(Level.SEVERE,
                    "Failed to init Home screen. fxml not loaded?");
        }
    }

    /**
     * Changes display to Account Creation
     */
    public void showCreateAccountScreen() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(
                    "../view/CreateAccount.fxml"));
            AnchorPane loginScreen = loader.load();
            rootLayout.setCenter(loginScreen);
            rootLayout.setBottom(null);
            rootLayout.setTop(null);
            CreateAccountController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            Logger.getLogger("Main").log(Level.SEVERE,
                    "Failed to init Account Creation screen. fxml not loaded?");
        }
    }

    /**
     * Changes display to Profile Editing
     */
    public void showEditInformationScreen() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(
                    "../view/EditProfileScreen.fxml"));
            AnchorPane loginScreen = loader.load();
            rootLayout.setCenter(loginScreen);
            EditProfileController controller = loader.getController();
            controller.setMainApp(this, user);
        } catch (IOException e) {
            Logger.getLogger("Main").log(Level.SEVERE,
                    "Failed to init Account Creation screen. fxml not loaded?");
        }
    }

    /**
     * Changes display to Submit a Report Screen
     */
    public void showSubmitReportScreen() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(
                    "../view/SubmitReportScreen.fxml"));
            AnchorPane loginScreen = loader.load();
            rootLayout.setCenter(loginScreen);
            SubmitReportController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            Logger.getLogger("Main").log(Level.SEVERE,
                    "Failed to init Submit Water Report screen. " +
                            "fxml not loaded?");
        }
    }

    /**
     * Changes display to View Reports Screen
     */
    public void showViewReportScreen() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(
                    "../view/ViewReportScreen.fxml"));
            AnchorPane loginScreen = loader.load();
            rootLayout.setCenter(loginScreen);
            ViewReportController controller = loader.getController();
            controller.setMainApp(this, waterReportTracker);
        } catch (IOException e) {
            Logger.getLogger("Main").log(Level.SEVERE,
                    "Failed to init View Report screen. fxml not loaded?");
        }
    }

    /**
     * Changes display to show information about a particular report
     * @param reportNumber The report number to display
     */
    public void showReportDetailsScreen(int reportNumber) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(
                    "../view/ReportDetailsScreen.fxml"));
            AnchorPane loginScreen = loader.load();
            rootLayout.setCenter(loginScreen);
            ReportDetailsController controller = loader.getController();
            controller.setMainApp(this, waterReportTracker, reportNumber);
        } catch (IOException e) {
            Logger.getLogger("Main").log(Level.SEVERE,
                    "Failed to init View Report screen. fxml not loaded?");
        }
    }

    /**
     * Changes display to show the Map with report pins
     */
    public void showMapScreen() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(
                    "../view/MapViewScreen.fxml"));
            AnchorPane loginScreen = loader.load();
            rootLayout.setCenter(loginScreen);
            MapScreenController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            Logger.getLogger("Main").log(Level.SEVERE,
                    "Failed to init View Map screen. fxml not loaded?");
        }
    }
/*

    */
    /*

    public void showSelectReportScreen() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(
            "../view/SelectReportScreen.fxml"));
            AnchorPane loginScreen = loader.load();
            rootLayout.setCenter(loginScreen);
            SelectReportController controller = loader.getController();
            controller.setMainApp(this, user, waterReportTracker);
        } catch (IOException e) {
            Logger.getLogger("Main").log(Level.SEVERE,
            "Failed to init Select Report screen. fxml not loaded?");
        }
    }
*/



    /**
     * Changes display to Submit a Purity Report Screen
     */
    public void showSubmitPurityReportScreen() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(
                    "../view/SubmitPurityReportScreen.fxml"));
            AnchorPane loginScreen = loader.load();
            rootLayout.setCenter(loginScreen);
            SubmitPurityReportController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            Logger.getLogger("Main").log(Level.SEVERE,
                    "Failed to init Submit Water Purity Report screen. " +
                            "fxml not loaded?");
        }
    }




    /**
     * Changes display to View Purity Reports Screen
     */
    public void showViewPurityReportsScreen() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(
                    "../view/ViewPurityReportsScreen.fxml"));
            AnchorPane loginScreen = loader.load();
            rootLayout.setCenter(loginScreen);
            ViewPurityReportsController controller = loader.getController();
            controller.setMainApp(this, waterReportTracker);
        } catch (IOException e) {
            Logger.getLogger("Main").log(Level.SEVERE,
                    "Failed to init View Purity Reports screen. " +
                            "fxml not loaded?");
        }
    }


    /**
     * Changes display to show information about a particular purity report
     * @param reportNumber The report number to display
     */
    public void showPurityReportDetailsScreen(int reportNumber) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(
                    "../view/PurityReportDetailsScreen.fxml"));
            AnchorPane loginScreen = loader.load();
            rootLayout.setCenter(loginScreen);
            PurityReportDetailsController controller = loader.getController();
            controller.setMainApp(this, waterReportTracker, reportNumber);
        } catch (IOException e) {
            Logger.getLogger("Main").log(Level.SEVERE,
                    "Failed to init View Purity Report screen. " +
                            "fxml not loaded?");
        }
    }

    /**
     * Changes display to show information about a particular purity report
     */
    public void showSelectHistoryGraphScreen() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(
                    "../view/SelectHistoryGraphScreen.fxml"));
            AnchorPane loginScreen = loader.load();
            rootLayout.setCenter(loginScreen);
            SelectHistoryGraphController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            Logger.getLogger("Main").log(Level.SEVERE,
                    "Failed to init Select History Graph screen. " +
                            "fxml not loaded?");
        }
    }

    /**
     * Changes display to show information about a particular purity report
     * @param location The desired location
     * @param type The type of graph to show
     * @param year What year to show graph from
     */
    public void showViewHistoryGraphScreen(String location, int year,
                                           String type) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(
                    "../view/ViewHistoryGraphScreen.fxml"));
            AnchorPane loginScreen = loader.load();
            rootLayout.setCenter(loginScreen);
            ViewHistoryGraphController controller = loader.getController();
            controller.setMainApp(this, location, year, type);
        } catch (IOException e) {
            Logger.getLogger("Main").log(Level.SEVERE,
                    "Failed to init Select History Graph screen. " +
                            "fxml not loaded?");
        }
    }

    /**
     * Allows access to the accounts
     * @return The tracker of the accounts
     */
    public AccountTracker getAccountTracker() {
        return accountTracker;
    }

    /**
     * Initializes the Account Tracker
     * @param l The Account Tracker
     */
    public void setAccountTracker(Collection<User> l) {
        accountTracker.setList(l);
    }

    /**
     * Initializes the Purity Reports
     * @param l The Report Tracker
     */
    public void setPurityReports(Collection<WaterPurityReport> l) {
        waterReportTracker.setPurityReports(l);
    }

    /**
     * Initializes the list of Source Reports
     * @param l The Source Reports
     */
    public void setSourceReports(Collection<WaterSourceReport> l) {
        waterReportTracker.setSourceReports(l);
    }


    /**
     * Allows access to the water reports through the tracker
     * @return The water report tracker
     */
    public WaterReportTracker getWaterReportTracker() {
        return waterReportTracker;
    }


    /**
     * Gets the currently logged in user
     * @return The user currently logged in
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the current user
     * @param user The user to set as logged in
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Launches the application
     * @param args Launch arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
