package sample.Controllers.Cells;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import sample.Database.EventHandlers.SongDeleteHandler;
import sample.Database.EventHandlers.SongFavoriteHandler;
import sample.Model.Playlist;
import sample.Model.Song;

import java.io.IOException;
import java.util.ArrayList;

public class SongListViewCell extends ListCell<Song> {

    @FXML
    private Labeled cellSongLbl;
    @FXML
    private Labeled cellArtistLbl;
    @FXML
    private Labeled cellAlbumLbl;
    @FXML
    private Labeled cellGenreLbl;
    @FXML
    private HBox cellHbox;
    @FXML
    private MenuItem deleteItem;
    @FXML
    private RadioMenuItem addfavItem;
    @FXML
    private Menu playlistSubMenu;

    FXMLLoader mLLoader;
    private int userID = -1;

    private ArrayList<Playlist> playlists = new ArrayList<>();


    @Override
    protected void updateItem(Song song, boolean empty) {
        super.updateItem(song, empty);

        System.out.println("anyayare");
        if (empty || song == null) {
            System.out.println("null yung song hayop");
            setText(null);
            setGraphic(null);

        } else {
            System.out.println("update item to sa songcell1 " + song.getSongTitle());
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getClassLoader().getResource("sample/Views/fxml/Program/listviewCells/songCell.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            cellSongLbl.setText(String.valueOf(song.getSongTitle()));
            cellArtistLbl.setText(song.getArtist());
            cellAlbumLbl.setText(song.getAlbum());
            cellGenreLbl.setText(song.getGenre());

            if(userID == -1){
                deleteItem.setDisable(true);
                addfavItem.setDisable(true);
                playlistSubMenu.setDisable(true);
            }

            deleteItem.setOnAction(event -> {
                SongDeleteHandler songDeleteHandler = new SongDeleteHandler();
                System.out.println("Delete " + getItem().getSongTitle() );
                songDeleteHandler.deleteSong(getItem().getSongID());
                getListView().getItems().remove(getItem());
            });

            addfavItem.setOnAction(event -> {
                SongFavoriteHandler songFavoriteHandler = new SongFavoriteHandler();
                songFavoriteHandler.favSong(getItem().getSongID(),userID);
            });

            for(int i = 0; i < playlists.size(); i++){
                Playlist playlist = playlists.get(i);
                MenuItem menuItem = new MenuItem(playlist.getPlaylistName());
                playlistSubMenu.getItems().add(menuItem);
            }

            setOnDragDetected(event -> {
                Dragboard db = this.startDragAndDrop(TransferMode.COPY_OR_MOVE);
                db.setDragView(this.snapshot(null, null));
                ClipboardContent cc = new ClipboardContent();
                cc.putString(this.getItem().getSongID()+"");
                db.setContent(cc);
            });


            setText(null);
            setGraphic(cellHbox);
        }
    }

    public void setUserID(int userID){
        this.userID = userID;
    }

    public void setPlaylist(ArrayList<Playlist> playlist){
        this.playlists = playlist;
    }




}
