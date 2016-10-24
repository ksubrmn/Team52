package fxapp;

import controller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.AccountTracker;
import model.AccountType;
import model.User;
import model.WaterReportTracker;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {

    private Stage mainScreen;

    private BorderPane rootLayout;

    private AccountTracker accountTracker;

    private User user;

    private WaterReportTracker waterReportTracker;

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("../view/WelcomeScreen.fxml"));
//        primaryStage.setTitle("Team 52");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
        accountTracker = new AccountTracker();
        waterReportTracker = new WaterReportTracker();
        accountTracker.addAccount("user", "pass", AccountType.User);
        mainScreen = primaryStage;
        initHomeScreen(mainScreen);
    }

    /**
     * Initialize home screen to welcome screen
     * @param mainScreen
     */
    public void initHomeScreen(Stage mainScreen) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/WelcomeScreen.fxml"));
            rootLayout = loader.load();
            HomeScreenController controller = loader.getController();
            controller.setMainApp(this);
            mainScreen.setTitle("Title");
            Scene scene = new Scene(rootLayout);
            mainScreen.setScene(scene);
            mainScreen.show();
        } catch (IOException e) {
            Logger.getLogger("Main").log(Level.SEVERE, "Failed to init Home screen. fxml not loaded?");
        }
    }

    /**
     * Changes display to Login Screen
     */
    public void showLoginScreen() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/LoginDialog.fxml"));
            AnchorPane loginScreen = loader.load();
            rootLayout.setCenter(loginScreen);
            rootLayout.setBottom(null);
            rootLayout.setTop(null);
            LoginScreenController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            Logger.getLogger("Main").log(Level.SEVERE, "Failed to init Login screen. Fxml not loaded?");
        }
    }

    /**
     * Changes display to Application Screen
     */
    public void showApplicationScreen() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/ApplicationScreen.fxml"));
            AnchorPane loginScreen = loader.load();
            rootLayout.setCenter(loginScreen);
            rootLayout.setBottom(null);
            rootLayout.setTop(null);
            ApplicationController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            Logger.getLogger("Main").log(Level.SEVERE, "Failed to init Application screen. Fxml not loaded?");
        }
    }

    /**
     * Changes display to Home Screen
     */
    public void showHomeScreen() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/WelcomeScreen.fxml"));
            BorderPane loginScreen = loader.load();
            rootLayout.setCenter(loginScreen);
            HomeScreenController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            Logger.getLogger("Main").log(Level.SEVERE, "Failed to init Home screen. fxml not loaded?");
        }
    }

    /**
     * Changes display to Account Creation
     */
    public void showCreateAccountScreen() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/CreateAccount.fxml"));
            AnchorPane loginScreen = loader.load();
            rootLayout.setCenter(loginScreen);
            rootLayout.setBottom(null);
            rootLayout.setTop(null);
            CreateAccountController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            Logger.getLogger("Main").log(Level.SEVERE, "Failed to init Account Creation screen. fxml not loaded?");
        }
    }

    /**
     * Changes display to Profile Editing
     */
    public void showEditInformationScreen() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/EditProfileScreen.fxml"));
            AnchorPane loginScreen = loader.load();
            rootLayout.setCenter(loginScreen);
            EditProfileController controller = loader.getController();
            controller.setMainApp(this, user);
        } catch (IOException e) {
            Logger.getLogger("Main").log(Level.SEVERE, "Failed to init Account Creation screen. fxml not loaded?");
        }
    }

    /**
     * Changes display to Submit a Report Screen
     */
    public void showSubmitReportScreen() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/SubmitReportScreen.fxml"));
            AnchorPane loginScreen = loader.load();
            rootLayout.setCenter(loginScreen);
            SubmitReportController controller = loader.getController();
            controller.setMainApp(this, user);
        } catch (IOException e) {
            Logger.getLogger("Main").log(Level.SEVERE, "Failed to init Submit Water Report screen. fxml not loaded?");
        }
    }

    /**
     * Changes display to View Reports Screen
     */
    public void showViewReportScreen() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/ViewReportScreen.fxml"));
            AnchorPane loginScreen = loader.load();
            rootLayout.setCenter(loginScreen);
            ViewReportController controller = loader.getController();
            controller.setMainApp(this, user, waterReportTracker);
        } catch (IOException e) {
            Logger.getLogger("Main").log(Level.SEVERE, "Failed to init View Report screen. fxml not loaded?");
        }
    }

    /**
     * Changes display to show information about a particular report
     * @param reportNumber The report number to display
     */
    public void showReportDetailsScreen(int reportNumber) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/ReportDetailsScreen.fxml"));
            AnchorPane loginScreen = loader.load();
            rootLayout.setCenter(loginScreen);
            ReportDetailsController controller = loader.getController();
            controller.setMainApp(this, user, waterReportTracker, reportNumber);
        } catch (IOException e) {
            Logger.getLogger("Main").log(Level.SEVERE, "Failed to init View Report screen. fxml not loaded?");
        }
    }

    /**
     * Changes display to show the Map with report pins
     */
    public void showMapScreen() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/MapViewScreen.fxml"));
            AnchorPane loginScreen = loader.load();
            rootLayout.setCenter(loginScreen);
            MapScreenController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            Logger.getLogger("Main").log(Level.SEVERE, "Failed to init View Map screen. fxml not loaded?");
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
