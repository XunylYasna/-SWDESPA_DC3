package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class SongHubController {

//    Top
    public MenuButton userMenu;
    public JFXButton uploadBtn;
    public JFXButton searchBtn;
    public JFXTextField searchTf;
    public AnchorPane searchPane;

//    General
    public JFXTabPane tabPane;

//    Home
    public ScrollPane scrollAnchor;
    public AnchorPane accountPane;
    public Label usernameView1;
    public ListView favoritesListView;
    public Label mostPlayedLabel1;
    public TextField fnameTf;
    public TextField lnameTf;
    public TextField emailTf;

//    List Views of the tabs
    public JFXListView songsLv;
    public JFXListView albumsLv;
    public JFXListView artistLv;
    public JFXListView genreLv;
    public JFXListView notifLv;



    public void logout(ActionEvent event) {
    }

    public void search(ActionEvent event) {
    }

    public void upload(ActionEvent event) {
    }

    public void setUsername(String username){

    }
}
