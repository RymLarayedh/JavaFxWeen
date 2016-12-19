/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javax.sound.midi.Transmitter;

/**
 * FXML Controller class
 *
 * @author rymlarayedh
 */
public class NewAccountDoneController implements Initializable {
    @FXML
    private Button ajouter;
    @FXML
    private Text yourname;
    private String name;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
    }
    
    public void setInformation(String n){
        this.name=n;
        yourname.setText(name);
    }
}
