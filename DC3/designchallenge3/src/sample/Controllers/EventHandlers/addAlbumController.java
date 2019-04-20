package sample.Controllers.EventHandlers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Model.Song;
import sample.Model.User;

import java.io.IOException;
import java.util.ArrayList;

public class addAlbumController {
    public JFXButton uploadFBtn;
    public Label message;
    public JFXTextField albumTf;
    public JFXButton songCBtn;
    public JFXButton confirmBtn;
    User artist;
    Song newSong;
    ArrayList<Song> songsinalbum;



    public void chooseSongCover(ActionEvent event) {
    }

    public void confirm(ActionEvent event) {
    }

    public void setArtist(User artist){
        this.artist = artist;
    }

    public void addSongtoAlbumFile(ActionEvent event) {
        Stage stage = new Stage();
        Parent root;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("sample/Views/fxml/Program/events/upload/addSongAlbum.fxml"));
        try {
            root = fxmlLoader.load();

            addSongAlbumController addSongAlbumController = (addSongAlbumController) fxmlLoader.getController();
            addSongAlbumController.setArtist(artist);

            Scene scene = new Scene(root);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

            newSong = addSongAlbumController.getSongAdded();

            if(newSong != null){
                songsinalbum.add(newSong);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
