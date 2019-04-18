package sample.Controllers.SongHubControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import sample.Controllers.SongListViewCell;
import sample.Database.BuildTemp.SongListBuildTemp;
import sample.Database.BuildTemp.UserBuildTemp;
import sample.Model.Playlist;
import sample.Model.Song;
import sample.Model.User;

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
    public JFXListView albumsLv;
    private ObservableList albumOL = FXCollections.observableArrayList();
    ArrayList<String> arrayListalbums;

//    Artists Tab
    public JFXListView artistLv;
    private ObservableList artistOL = FXCollections.observableArrayList();
    ArrayList<User> arrayListartists;

//    Genre Tab
    public JFXListView genreLv;
    private ObservableList genresOL = FXCollections.observableArrayList();
    ArrayList<String> arrayListgenres;

//    Playlists Tab

    private ObservableList playlistOL = FXCollections.observableArrayList();
    ArrayList<Playlist> arrayListplaylists;

//    Sidebar
    public JFXListView notifLv;


//    Non UI
    User user;

//    Database Access
    SongListBuildTemp songListBuildTemp = new SongListBuildTemp(); // gets songs from the db
    UserBuildTemp userBuildTemp = new UserBuildTemp();



//
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initSongList();
    }

    public void setUser(String username){
        if(username == null){
            userMenu.setText("Guest");
        }

        else{
            userMenu.setText(username);
            UserBuildTemp userBuildTemp = new UserBuildTemp();
            user = userBuildTemp.getUser(username);
            System.out.println(user.getUserID());
        }
    }

    public void initSongList(){
        arrayListsongs = songListBuildTemp.getSongs(null,null);
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
    }






    public void refreshAlbums(){

    }

    public void refreshPlaylists(){

    }

    public void refreshArtist(){

    }

    public void refreshFollowing(){

    }
}
