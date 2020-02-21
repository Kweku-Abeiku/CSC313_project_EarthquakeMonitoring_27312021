package GalamseyProject;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController extends Application {
    /***
     * This class is a controller for the JavaFX scene home which displays homepage.
     */

    @Override
    /***
     * Starts javaFX scene.
     */

    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        primaryStage.setTitle("Galamsey Monitoring");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }



    /***
     * This method changes the scene to the inputgalamsey scene to enable input of galamsey activities.
     * @param event
     * @throws IOException
     */
    public void enterAbout (javafx.event.ActionEvent event) throws IOException {

        Parent aboutParent = FXMLLoader.load(getClass().getResource("about.fxml"));
        Scene aboutScene = new Scene(aboutParent);

        Stage window = (Stage) ((Node)event.getSource() ).getScene() .getWindow();
        window.setScene(aboutScene);
        window.show();

    }
    /***
     * This method changes the scene to the inputgalamsey scene to enable input of galamsey activities.
     * @param event
     * @throws IOException
     */
    public void enterGalamseyData (javafx.event.ActionEvent event) throws IOException {

        Parent enterGdataParent = FXMLLoader.load(getClass().getResource("inputGalamsey.fxml"));
        Scene enterGdataScene = new Scene(enterGdataParent);

        Stage window = (Stage) ((Node)event.getSource() ).getScene() .getWindow();
        window.setScene(enterGdataScene);
        window.show();

    }

    /**
     * This method changes the scene to the summary page to display a summary graph
     * @param event
     * @throws IOException
     */
    public void summaryPage (javafx.event.ActionEvent event) throws IOException {

        Parent summaryParent = FXMLLoader.load(getClass().getResource("summary.fxml"));
        Scene summaryScene = new Scene(summaryParent);

        Stage window = (Stage) ((Node)event.getSource() ).getScene() .getWindow();
        window.setScene(summaryScene);
        window.show();

    }


    /***
     * This method changes the scene to the inputObs scene to enable input of observatory details.
     * @param event
     * @throws IOException
     */

    public void enterObsData (javafx.event.ActionEvent event) throws IOException {

        Parent enterObsParent = FXMLLoader.load(getClass().getResource("inputObs.fxml"));
        Scene enterObsScene = new Scene(enterObsParent);

        Stage window = (Stage) ((Node)event.getSource() ).getScene() .getWindow();
        window.setScene(enterObsScene);
        window.show();

    }



    /**
     * This method changes the scene to the displayObs to display the observatories.
     * @param event
     * @throws IOException
     */
    public void DisplayObsData (javafx.event.ActionEvent event) throws IOException {

        Parent displayObsParent = FXMLLoader.load(getClass().getResource("displayObs.fxml"));
        Scene displayObsScene = new Scene(displayObsParent);

        Stage window = (Stage) ((Node)event.getSource() ).getScene() .getWindow();
        window.setScene(displayObsScene);
        window.show();

    }


    /**
     * This method changes the scene to the displayGalamsey to display recorded galamsey.
     * @param event
     * @throws IOException
     */
    public void displayGalamseyData (javafx.event.ActionEvent event) throws IOException {

        Parent displayGdataParent = FXMLLoader.load(getClass().getResource("displayGalamsey.fxml"));
        Scene displayGdataScene = new Scene(displayGdataParent);

        Stage window = (Stage) ((Node)event.getSource() ).getScene() .getWindow();
        window.setScene(displayGdataScene);
        window.show();

    }


    @FXML
    private javafx.scene.control.Button closeButton;

    @FXML
    /**Closes program.
     *
     */
    private void closeButtonAction(){

        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }



}
