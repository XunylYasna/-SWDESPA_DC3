package sample.Controllers.EventHandlers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import sample.Model.Album;
import sample.Model.Song;
import sample.Model.User;

public class addSongAlbumController {
    public JFXTextField titleTf;
    public JFXButton uploadFBtn;
    public Label message;
    public JFXTextField genreTf;
    public JFXButton confirmBtn;
    public Label statusLbl;

    private User artist;
    private Album album;
    private Song songadded;

    public void uploadSongFile(ActionEvent event) {
    }

    public void confirm(ActionEvent event) {
    }

    public void setArtist(User artist) {
        this.artist = artist;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Song getSongAdded() {
        return songadded;
    }
}
