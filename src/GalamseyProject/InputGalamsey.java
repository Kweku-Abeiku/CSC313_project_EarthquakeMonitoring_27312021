package GalamseyProject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

import static java.lang.Integer.*;

public class InputGalamsey {

    /***
     * This class is a controller for the JavaFX scene inputgalamsey which aloow input activities.
     */
    public TextField VegetationCol;
    public TextField colVal;
    public TextField longT;
    public TextField latI;
    public TextField year;
    public TextField obs;

    /***
     * This methods takes user to the homepage.
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
     * this method inputs the galamsey data into the galamsey_tbl table
     * @param event
     * @throws SQLException
     */
    public void enterGal (javafx.event.ActionEvent event) throws SQLException {


        Database a = new Database();

        a.addGalamsey((VegetationCol.getText()), Integer.valueOf(colVal.getText()), "(" + longT.getText() + ", " + latI.getText() + ")" , Integer.valueOf(year.getText()), this.obs.getText());


        /**
         * Set input fields to defaults
         */
        VegetationCol.setText("");
        colVal.setText("");
        longT.setText("");
        latI.setText("");
        year.setText("");
        obs.setText("");



    }








}
