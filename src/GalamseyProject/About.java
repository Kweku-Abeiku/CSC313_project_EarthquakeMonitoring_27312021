package GalamseyProject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class About {

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

}
