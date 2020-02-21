package GalamseyProject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static GalamseyProject.Database.getConnection;

public class summary implements Initializable {

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private Button btnReload;

    private Connection con;
    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {

    }

    /***
     * This Methods takes the users to the homepage.
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
     * This Method is populates the bar chart in the JavaFXscene with values from the data base.
     * @param event
     * @throws SQLException
     */
    public void reloadG (ActionEvent event) throws SQLException {
        //sql query to return values.
       String query = "SELECT COUNT(colorVal), Vegcolor FROM galamsey_tbl WHERE Vegcolor = 'brown' GROUP BY Vegcolor";
        XYChart.Series<String, Integer> series = new XYChart.Series<>();

            try {
                con = getConnection();//Variable for database connection
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        ResultSet rs =  con.createStatement().executeQuery(query);//This holds returned data set from the database
            while (rs.next()){
                series.getData().add(new XYChart.Data<>(rs.getString(2), rs.getInt(1)));
                series.setName("Brown");
            }

        //sql query to return values.
        String query1 = "SELECT COUNT(colorVal), Vegcolor FROM galamsey_tbl WHERE Vegcolor = 'yellow' GROUP BY Vegcolor";
        XYChart.Series<String, Integer> series1 = new XYChart.Series<>();

        try {
            con = getConnection();
        } catch (SQLException e) {//Variable for database connection
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ResultSet rs1 =  con.createStatement().executeQuery(query1);
        while (rs1.next()){
            series1.getData().add(new XYChart.Data<>(rs1.getString(2), rs1.getInt(1)));
            series1.setName("Yellow");
        }

        //sql query to return values.
        String query2 = "SELECT COUNT(colorVal), Vegcolor FROM galamsey_tbl WHERE Vegcolor = 'green' GROUP BY Vegcolor";
        XYChart.Series<String, Integer> series2 = new XYChart.Series<>();

        try {
            con = getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ResultSet rs2 =  con.createStatement().executeQuery(query2);//This holds returned data set from the database
        while (rs2.next()){
            series2.getData().add(new XYChart.Data<>(rs2.getString(2), rs2.getInt(1)));
            series2.setName("Green");
        }
        //this draw bar chart with provided data.
        barChart.getData().addAll(series,series1,series2);

    }
}
