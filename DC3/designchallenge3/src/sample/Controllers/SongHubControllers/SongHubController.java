package sample.Controllers.SongHubControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Controllers.Cells.SongListViewCell;
import sample.Controllers.EventHandlers.uploadController;
import sample.Database.BuildTemp.PlaylistBuildTemp;
import sample.Database.BuildTemp.SongListBuildTemp;
import sample.Database.BuildTemp.UserBuildTemp;
import sample.Model.Album;
import sample.Model.Playlist;
import sample.Model.Song;
import sample.Model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SongHubController implements Initializable {

//    Top
    public MenuButton userMenu;
    public JFXButton uploadBtn;
    public JFXButton searchBtn;
    public JFXTextField searchTf;
    public AnchorPane searchPane;

//    General
    public JFXTabPane tabPane;

//    Home Tab
    public ScrollPane scrollAnchor;
    public AnchorPane accountPane;
    public Label usernameView1;
    public ListView favoritesListView;
    public Label mostPlayedLabel1;
    public TextField fnameTf;
    public TextField lnameTf;
    public TextField emailTf;

//      Songs Tab
    public ListView<Song> songsLv;
    private ObservableList songOL = FXCollections.observableArrayList();
    ArrayList<Song> arrayListsongs;

//    Albums Tab
    public ListView albumsLv;
    public ListView albumsongLv;
    private ObservableList albumOL = FXCollections.observableArrayList();
    ArrayList<Album> arrayListalbums;

//    Artists Tab
    public ListView artistLv;
    private ObservableList artistOL = FXCollections.observableArrayList();
    ArrayList<User> arrayListartists;

//    Genre Tab
    public ListView genreLv;
    private ObservableList genresOL = FXCollections.observableArrayList();
    ArrayList<String> arrayListgenres;

//    Playlists Tab
    public MenuButton playlistMenu;
    private ObservableList playlistOL = FXCollections.observableArrayList();
    ArrayList<Song> arrayListsongsofplaylists;
    ArrayList<Playlist> arrayListplaylists;
    public ListView playlistsongLv;

    //    Sidebar
    public JFXListView notifLv;


//    Non UI
    User user;

//    Database Access
    SongListBuildTemp songListBuildTemp = new SongListBuildTemp(); // gets songs from the db
    UserBuildTemp userBuildTemp = new UserBuildTemp();
    PlaylistBuildTemp playlistBuildTemp = new PlaylistBuildTemp();



//
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initSongList();
    }

    public void setUser(String username){

        if(username == null){
            userMenu.setText("Guest");
            user = new User(-1, "Guest", "John", "Sins", "hardcore","js@songhub.com", "listener");
        }

        else{
            userMenu.setText(username);
            user = userBuildTemp.getUser(username);
            System.out.println(user.getUserID());
            initPlaylist();

            System.out.println(user.getType());
            if(user.getType().equals("artist")){
                System.out.println("bakit ganito");
                uploadBtn.setVisible(true);
                uploadBtn.setDisable(false);
            }
        }

    }

    public void initSongList(){
        arrayListsongs = songListBuildTemp.getSongs(null,null);
        songOL.clear();
        songOL.setAll(arrayListsongs);
        songsLv.setItems(songOL);

        songsLv.setCellFactory(lv -> {
            SongListViewCell cell = new SongListViewCell();
            if(user != null){
                cell.setUserID(user.getUserID());
                cell.setPlaylist(user.getPlaylistList());
            }
            return cell;
        });
    }

    public void initSongList(ArrayList<Song> arrayListsongs, ObservableList songOL, ListView songsLv){
        songOL.clear();
        songOL.setAll(arrayListsongs);
        songsLv.setItems(songOL);

        songsLv.setCellFactory(lv -> {
            SongListViewCell cell = new SongListViewCell();
            cell.setUserID(user.getUserID());
            return cell;
        });
    }

    public void initPlaylist(){
        arrayListplaylists = playlistBuildTemp.getPlaylists(user.getUserID());

        for(int i = 0; i < arrayListplaylists.size(); i++){
            Playlist playlist = arrayListplaylists.get(i);
            MenuItem menuItem = new MenuItem(arrayListplaylists.get(i).getPlaylistName());

            menuItem.setOnAction((e -> {
                playlistMenu.setText(playlist.getPlaylistName());
                arrayListsongsofplaylists = songListBuildTemp.getSongsofPlaylist(playlist.getPlaylistID());
                initSongList(arrayListsongsofplaylists, playlistOL, playlistsongLv);
            }));

            playlistMenu.getItems().add(menuItem);
        }
    }

    public void initArtist(){

    }

    public void initFollowing(){

    }

    public void initGenre(){

    }



    public void logout(ActionEvent event) {
    }

    public void search(ActionEvent event) {
    }

    public void upload(ActionEvent event) {
        Stage stage = new Stage();
        Parent root;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("sample/Views/fxml/Program/events/upload/upload.fxml"));
        try {
            root = fxmlLoader.load();

            uploadController uploadController = (uploadController) fxmlLoader.getController();
            uploadController.setArtist(user);

            Scene scene = new Scene(root);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






    public void refreshAlbums(){

    }

    public void refreshPlaylists(){

    }

    public void refreshArtist(){

    }

    public void refreshFollowing(){

    }


    public void close(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
}
