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


public class DisplayObs implements Initializable{
    /***
     * This class is a controller for the JavaFX scene displayobs which displays recorded observatories.
     */

    @FXML
    private TableView<ModelTableObs> table1;
    /**
     * create new javafx tableview.
     */


    @FXML
    private TableColumn<ModelTableObs, String> colname;
    /**
     * Holds name of observatory retrieved from database
     */

    @FXML
    private TableColumn<ModelTableObs, String> colcountry;
    /**
     * Holds contry of observatory retrieved from database
     */


    @FXML
    private TableColumn<ModelTableObs, Integer> colyear;
    /**
     * Holds year value retrieved from database
     */


    @FXML
    private TableColumn<ModelTableObs, Double> colarea;
    /**
     * Holds area value retrieved from database
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
     * This method creates database connection and displays observatory data in javafx TableView
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {

        Connection connection = null;
        try {
            connection = Database.getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            assert connection != null;
            ResultSet rs = connection.createStatement() .executeQuery("select * from observatory");
            while(rs.next()){
                obsObservableList.add(new ModelTableObs(rs.getString("Name"),rs.getString("Country"),rs.getInt("Year"),rs.getDouble("Area")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /**This enters data retrieved from the database into the respective columns.
         *
         */
        colname.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colcountry.setCellValueFactory(new PropertyValueFactory<>("Country"));
        colyear.setCellValueFactory(new PropertyValueFactory<>("Year"));
        colarea.setCellValueFactory(new PropertyValueFactory<>("Area"));
        /**this initializes the Javafx TableView.
         *
         */
        table1.setItems(obsObservableList);

    }

    /**Array Variable to hold retrieved data.
     *
     */
    ObservableList<ModelTableObs> obsObservableList = FXCollections.observableArrayList();



}
