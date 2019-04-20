package sample.Controllers.Start;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Labeled;
import javafx.scene.control.MenuButton;
import sample.Database.EventHandlers.RegistrationHandler;

public class RegistrationController {

    public MenuButton typeMenu;

    @FXML
    private JFXButton exitBtn;

    @FXML
    private JFXTextField firstnameTf;
    @FXML
    private JFXTextField lastnameTf;

    @FXML
    private JFXTextField usernameTf;

    @FXML
    private JFXTextField emailTf;

    @FXML
    private JFXPasswordField passwordPf;

    @FXML
    private Labeled messageLbl;

    private String registrationtype = "listener";
    
    @FXML
    void register(ActionEvent event){
        RegistrationHandler register = new RegistrationHandler();
        String message = register.registration(firstnameTf.getText(), lastnameTf.getText(), usernameTf.getText(), emailTf.getText(), passwordPf.getText(), registrationtype);

        messageLbl.setText(message);
    }

    @FXML
    void exitProgram(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }


    public void setUsertype(ActionEvent event) {
        typeMenu.setText("Listener");
        registrationtype = "listener";
    }

    public void setArtisttype(ActionEvent event) {
        typeMenu.setText("Artist");
        registrationtype = "artist";
    }
}
