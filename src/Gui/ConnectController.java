/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Trade.UserAdd;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author rymlarayedh
 */
public class ConnectController implements Initializable {

    @FXML
    private Button ajouter;
    @FXML
    private TextField logintf;
    @FXML
    private PasswordField passwordtf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        String login = logintf.getText();
        String password = passwordtf.getText();

        UserAdd u = new UserAdd();
        
        int id=0;
        if (u.FindAdmin(login, password).getUserId() != 0) {
            id = u.FindAdmin(login, password).getUserId();
            u.Connect(id);
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("ProfileAdmin.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(new Scene((Pane) Loader.load()));
            ProfileAdminController AFC = Loader.<ProfileAdminController>getController();
            AFC.setInformation(id);
            stage.show();
            final Node source = (Node) event.getSource();
            final Stage stageee = (Stage) source.getScene().getWindow();
            stageee.close();
        } else if (u.FindWeener(login, password).getUserId() != 0) {
            id = u.FindWeener(login, password).getUserId();
            u.Connect(id);
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("ProfileUser.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(new Scene((Pane) Loader.load()));
            ProfileUserController AFC = Loader.<ProfileUserController>getController();
            AFC.setInformation(id);
            stage.show();
            final Node source = (Node) event.getSource();
            final Stage stageee = (Stage) source.getScene().getWindow();
            stageee.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Wrong");
            alert.showAndWait();
        }
        
    }

}
