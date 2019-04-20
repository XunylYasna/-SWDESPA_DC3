package sample.Controllers.EventHandlers;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class uploadController {

    public AnchorPane parentAnchor;
    public VBox Parentpane;

    Parent root;

    public void uploadSong(ActionEvent event) {


        FadeTransition fadeOutTransition = new FadeTransition(Duration.millis(200), Parentpane);
        fadeOutTransition.setFromValue(1.0);
        fadeOutTransition.setToValue(0.0);
        fadeOutTransition.play();

        fadeOutTransition.setOnFinished((e) -> {
            try {

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("sample/Views/fxml/Program/events/upload/addSong.fxml"));
                root = fxmlLoader.load();;
                Parentpane.getChildren().remove(parentAnchor);
                Parentpane.getChildren().add(root);
                FadeTransition fadeInTransition = new FadeTransition(Duration.millis(200), Parentpane);
                fadeInTransition.setFromValue(0.0);
                fadeInTransition.setToValue(1.0);
                fadeInTransition.play();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


    }

    public void uploadAlbum(ActionEvent event) {
        FadeTransition fadeOutTransition = new FadeTransition(Duration.millis(200), Parentpane);
        fadeOutTransition.setFromValue(1.0);
        fadeOutTransition.setToValue(0.0);
        fadeOutTransition.play();

        fadeOutTransition.setOnFinished((e) -> {
            try {

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("sample/Views/fxml/Program/events/upload/addAlbum.fxml"));
                root = fxmlLoader.load();;
                Parentpane.getChildren().remove(parentAnchor);
                Parentpane.getChildren().add(root);
                FadeTransition fadeInTransition = new FadeTransition(Duration.millis(200), Parentpane);
                fadeInTransition.setFromValue(0.0);
                fadeInTransition.setToValue(1.0);
                fadeInTransition.play();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}
