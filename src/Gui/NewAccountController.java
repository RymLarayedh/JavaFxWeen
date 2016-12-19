/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.User;
import Trade.UserAdd;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
public class NewAccountController implements Initializable {
    @FXML
    private Button ajouter;
    @FXML
    private TextField checkmdptf;
    @FXML
    private TextField mdptf;
    @FXML
    private TextField identifianttf;
    @FXML
    private TextField teltf;
    @FXML
    private TextField emailtf;
    @FXML
    private TextField adressetf;
    @FXML
    private TextField prenomtf;
    @FXML
    private TextField nomtf;
    private Text status;
    @FXML
    private Text alertmdp;
    @FXML
    private Text alertmdplogin;
    @FXML
    private Text alerttel;
    @FXML
    private Text alert;
private String msg="";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        String nom=nomtf.getText();
        String prenom=prenomtf.getText();     
        String adresse=adressetf.getText();
        String email=emailtf.getText();
        String tel=teltf.getText();
        String identifiant=identifianttf.getText();
        String mdp=mdptf.getText();
        String checkmdp=checkmdptf.getText();
        if(mdp.equals(checkmdp)){    
        int telint=parseInt(tel);
        int adresseint=parseInt(adresse);
        UserAdd p=new UserAdd();
        p.AddUser(nom, prenom, adresseint, email, telint, identifiant, mdp);
        System.out.println(nom+prenom);
       

        //afficher les utilisateurs
          FXMLLoader Loader=new FXMLLoader(getClass().getResource("NewAccountDone.fxml"));
          Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(new Scene((Pane) Loader.load()));
            NewAccountDoneController AFC = Loader.<NewAccountDoneController>getController();
        AFC.setInformation(nom);
        stage.show();
        final Node source =(Node) event.getSource();
        final Stage stagee=(Stage) source.getScene().getWindow();
        stagee.close();
        }
        else {msg="Check your Password\n";}
        
        alert.setText(msg);
        alertmdp.setText("*");
    }
    /*public String transmettre(String n){
        return(n=prenomtf.getText());
    }*/

    @FXML
    private void ConnectViaFacebook(ActionEvent event) {
    }

    
}
