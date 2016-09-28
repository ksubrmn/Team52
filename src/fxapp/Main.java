package fxapp;

import controller.ApplicationController;
import controller.CreateAccountController;
import controller.HomeScreenController;
import controller.LoginScreenController;
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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {

    private Stage mainScreen;

    private BorderPane rootLayout;

    private AccountTracker accountTracker;

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("../view/WelcomeScreen.fxml"));
//        primaryStage.setTitle("Team 52");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
        accountTracker = new AccountTracker();
        mainScreen = primaryStage;
        initHomeScreen(mainScreen);
    }

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

    public AccountTracker getAccountTracker() {
        return accountTracker;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
