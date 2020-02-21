package GalamseyProject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class InputObs {
    /***
     * This class is a controller for the JavaFX scene inputObs which displays recorded observatory details.
     */

    public TextField obsYear;
    public TextField obsArea;
    public TextField obsCountry;
    public TextField obsName;

    /**
     * This method returns the user home.
     * @param event
     * @throws IOException
     */

    public void goHome (javafx.event.ActionEvent event) throws IOException {

        Parent goHomeParent = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene goHomeScene = new Scene(goHomeParent);

        Stage window = (Stage) ((Node)event.getSource() ).getScene() .getWindow();
        window.setScene(goHomeScene);
        window.show();

    }

    /**
     * This method inputs the observatory data into the observatory table
     * @param event
     * @throws SQLException
     */
    public void enterOBS (javafx.event.ActionEvent event) {

        String year = obsYear.getText();
        String area =obsArea.getText();
        String country = obsCountry.getText();
        String name = obsName.getText();

        String query = "INSERT INTO observatory (name, country, year, area) VALUES(?,?,?,?)";
        Database a = new Database();
        try {
            a.addObservatory(name, country,Integer.valueOf(year),Double.valueOf(area));
        } catch (SQLException ignored) {
        }

        /**
         * Set input fields to defaults
         */
        obsCountry.setText("");
        obsArea.setText("");
        obsName.setText("");
        obsYear.setText("");


        }

    }

