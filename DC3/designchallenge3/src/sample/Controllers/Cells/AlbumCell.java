package sample.Controllers.Cells;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListCell;
import sample.Model.Album;

import javax.swing.text.html.ImageView;
import java.io.IOException;

public class AlbumCell extends ListCell<Album> {

    @FXML
    ImageView albumCover;

    @FXML
    Labeled albumName;

    @FXML
    Labeled albumArtist;

    FXMLLoader mLLoader;

    @Override
    protected void updateItem(Album album, boolean empty) {
        super.updateItem(album, empty);

        if (empty || album == null) {
            setText(null);
            setGraphic(null);
        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("../Views/fxml/Program/listviewCells/albumCell.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            albumName.setText(album.getAlbumName());
            albumArtist.setText(album.getArtistID() + "");
        }
    }
}
