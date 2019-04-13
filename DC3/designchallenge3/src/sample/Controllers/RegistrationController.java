package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Labeled;
import sample.Database.RegistrationHandler;

public class RegistrationController {

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

    @FXML
    void register(ActionEvent event){
        RegistrationHandler regis = new RegistrationHandler();
        String message = regis.registration(firstnameTf.getText(), lastnameTf.getText(), usernameTf.getText(), emailTf.getText(), passwordPf.getText());

        messageLbl.setText(message);
    }

    @FXML
    void exitProgram(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

}