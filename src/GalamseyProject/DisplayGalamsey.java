package GalamseyProject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;



public class DisplayGalamsey implements Initializable {
    /***
     * This class is a controller for the JavaFX scene displaygalamsey which displays recorded galamsey activities.
     */


    @FXML
    private TableView<ModelTableGal> table1;
    /**
     * create new javafx tableview.
     */

    @FXML
    private TableColumn<ModelTableGal, String> vegCol;
    /**
     * Holds vegetation color retrieved from database
     */

    @FXML
    private TableColumn<ModelTableGal, Integer> colVal;
    /**
     * Holds color value retrieved from database
     */

    @FXML
    private TableColumn<ModelTableGal, String> posr;

    /**
     * Holds postion value retrieved from database
     */

    @FXML
    private TableColumn<ModelTableGal, Integer> yrOfEv;
    /**
     * Holds year retrieved from database
     */

    @FXML
    private TableColumn<ModelTableGal, String> obs;

    /**
     * Holds observatory it belongs to retrieved from database
     */


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

    /***
     * This method creates database connection and displays data in javafx TableView
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {

        Connection connection = null;
        /**variable for database connection.
         *
         */

        try {
            connection = Database.getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            assert connection != null;
            ResultSet rs = connection.createStatement() .executeQuery("select * from galamsey_tbl");

            /**This holds returned data set from the database
             */
            while(rs.next()){
                obsObservableList2.add(new ModelTableGal(rs.getString("Vegcolor"),rs.getInt("colorVal"),rs.getString("position"),rs.getInt("yearOfEvent"),rs.getString("ObsName")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /**This enters data retrieved from the database into the respective columns.
         *
         */
        vegCol.setCellValueFactory(new PropertyValueFactory<>("Vegcolor"));
        colVal.setCellValueFactory(new PropertyValueFactory<>("colorVal"));
        posr.setCellValueFactory(new PropertyValueFactory<>("position"));
        yrOfEv.setCellValueFactory(new PropertyValueFactory<>("year"));
        obs.setCellValueFactory(new PropertyValueFactory<>("ObsName"));

        //this initializes the Javafx TableView.
        table1.setItems(obsObservableList2);

    }

    /**Array Variable to hold retrieved data.
     *
     */
    ObservableList<ModelTableGal> obsObservableList2 = FXCollections.observableArrayList();



}
