/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import DAO.CityDAO;
import DAO.UserDAO;
import Entities.City;
import Entities.User;
import Trade.WeenerAdd;
import Transformers.PersonneToPerson;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.util.Duration;
import java.util.ResourceBundle;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;


/**
 * FXML Controller class
 *
 * @author rymlarayedh
 */
public class ProfileUserController implements Initializable {
    @FXML
    private TableView<PersonneToPerson> tableuser;
    @FXML
    private TableColumn<PersonneToPerson, String> nom;
    @FXML
    private TableColumn<PersonneToPerson, String> prenom;
    @FXML
    private TableColumn<PersonneToPerson, String> identifiant;
    ObservableList<PersonneToPerson>data=FXCollections.observableArrayList();
    
    
    @FXML
    private Button supprimer1;
    @FXML
    private Button addweener;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private Button statistic;
    @FXML
    private Button forum;
    @FXML
    private Button message;
    @FXML
    private Button profil;
    
    
    
    @FXML
    private TableView<PersonneToPerson> tableuser1;
    @FXML
    private TableColumn<PersonneToPerson, String> nom1;
    @FXML
    private TableColumn<PersonneToPerson, String> prenom1;
    @FXML
    private TableColumn<PersonneToPerson, String> email1;
    @FXML
    private TableColumn<PersonneToPerson, Integer> tel1;
    @FXML
    private TableColumn<PersonneToPerson, String> identifiant1;
    ObservableList<PersonneToPerson>data1=FXCollections.observableArrayList();
    
    
    
    
    @FXML
    private TableView<PersonneToPerson> tableuser2;
    @FXML
    private TableColumn<PersonneToPerson, String> nom2;
    @FXML
    private TableColumn<PersonneToPerson, String> prenom2;
    @FXML
    private TableColumn<PersonneToPerson, String> email2;
    @FXML
    private TableColumn<PersonneToPerson, Integer> tel2;
    @FXML
    private TableColumn<PersonneToPerson, String> identifiant2;
    ObservableList<PersonneToPerson>data2=FXCollections.observableArrayList();
    
    @FXML
    private TableView<PersonneToPerson> tableuser3;
    @FXML
    private TableColumn<PersonneToPerson, String> nom3;
    @FXML
    private TableColumn<PersonneToPerson, String> prenom3;
    @FXML
    private TableColumn<PersonneToPerson, String> email3;
    @FXML
    private TableColumn<PersonneToPerson, Integer> tel3;
    @FXML
    private TableColumn<PersonneToPerson, String> identifiant3;
    ObservableList<PersonneToPerson>data3=FXCollections.observableArrayList();
    @FXML
    private TabPane tabpane;
    @FXML
    private AnchorPane anchorupdate;
    @FXML
    private TextField emailtf;
    @FXML
    private TextField checkmdptf;
    @FXML
    private TextField mdptf;
    @FXML
    private TextField logintf;
    @FXML
    private TextField teltf;
    @FXML
    private TextField adressetf;
    @FXML
    private TextField prenomtf;
    @FXML
    private TextField nomtf;
    private int id;
    private int selected=0;
    @FXML
    private Button insertinfo;
    @FXML
    private Text status;
    @FXML
    private AnchorPane magicbar;
    @FXML
    private ImageView magic;
    @FXML
    private ImageView magic2;
    @FXML
    private Text myname;
    @FXML
    private Text mylastname;
    @FXML
    private AnchorPane anchormyinfo;
    @FXML
    private TextField mynametf;
    @FXML
    private TextField myidaddresstf;
    @FXML
    private TextField myemailtf;
    @FXML
    private AnchorPane anchormdp;
    @FXML
    private PasswordField mypasswordtf;
    @FXML
    private TextField mylogintf;
    @FXML
    private TextField mylastnametf;
    @FXML
    private TextField myphonetf;
    @FXML
    private PasswordField mypasswordtf1;
    @FXML
    private AnchorPane anchordelete;
    @FXML
    private TableView<PersonneToPerson> tableconnected;
    @FXML
    private TableColumn<PersonneToPerson, String> namecon;
    @FXML
    private TableColumn<PersonneToPerson, String> lastnamecon;
    ObservableList<PersonneToPerson>tablecon=FXCollections.observableArrayList();
    @FXML
    private Button historic;
    @FXML
    private Button friends;
    @FXML
    private Button home;
    @FXML
    private Button newtrip;
    @FXML
    private Button tripprogram;
    @FXML
    private Button trips;
    
    
    @FXML
    private TableView<PersonneToPerson> tableuser4;
    @FXML
    private TableColumn<PersonneToPerson, String> nom4;
    @FXML
    private TableColumn<PersonneToPerson, String> prenom4;
    @FXML
    private TableColumn<PersonneToPerson, String> identifiant4;
    ObservableList<PersonneToPerson>data4=FXCollections.observableArrayList();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      tabpane.setVisible(false);
        supprimer1.setVisible(false);
        supprimer.setVisible(false);
        addweener.setVisible(false);
        modifier.setVisible(false);   
        
        tripprogram.setVisible(false);
        newtrip.setVisible(false);
        historic.setVisible(false);
        anchorupdate.setVisible(false);
        magicbar.setVisible(false);  
        anchormdp.setVisible(false);
        anchormyinfo.setVisible(false);
        anchordelete.setVisible(false);
        tableconnected.setVisible(false);   
    }    

    @FXML
    private void BlockUser(ActionEvent event) {
        tabpane.setVisible(false);
        anchormyinfo.setVisible(false);
        anchordelete.setVisible(false);
    }

    @FXML
    private void UpdateInformations(ActionEvent event) {
        tabpane.setVisible(false);
        anchormyinfo.setVisible(false);
        anchormdp.setVisible(true);
        supprimer1.setVisible(false);
        supprimer.setVisible(false);
        addweener.setVisible(false);
        modifier.setVisible(false);
        anchordelete.setVisible(false);
    }

    @FXML
    private void DeleteAccount(ActionEvent event) {
        tabpane.setVisible(false);
        anchormyinfo.setVisible(false);
        anchordelete.setVisible(true);
    }
    @FXML
    private void DeleteMe(ActionEvent event) throws IOException{
        WeenerAdd p=new WeenerAdd();
        p.DeleteUser(this.myid);
        Parent root=FXMLLoader.load(getClass().getResource("Connect.fxml"));
        Scene scene=new Scene(root);
        Stage Sc=new Stage();
        Sc.setScene(scene);
        Sc.show();
        final Node source =(Node) event.getSource();
        final Stage stage=(Stage) source.getScene().getWindow();
        stage.close();
    }
    
     @FXML
    private void Deconnect(ActionEvent event) throws IOException {
        WeenerAdd p=new WeenerAdd();
        p.Deconnect(this.myid);
        Parent root=FXMLLoader.load(getClass().getResource("Connect.fxml"));
        Scene scene=new Scene(root);
        Stage Sc=new Stage();
        Sc.setScene(scene);
        Sc.show();
        final Node source =(Node) event.getSource();
        final Stage stage=(Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void supprimer(ActionEvent event) {
        if(this.selected==1){
            ObservableList <PersonneToPerson>userSelected,allUser;
        allUser=tableuser.getItems();
        userSelected=tableuser.getSelectionModel().getSelectedItems();
        PersonneToPerson ptp= tableuser.getSelectionModel().getSelectedItem();        
        userSelected.forEach(allUser::remove);
        
        System.out.println(ptp.getIdentifiant());
        //int id=userSelected.get(X.getUserId());
        WeenerAdd p=new WeenerAdd();
        p.DeleteUser(ptp.getIdutilisateur());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("User details has been deleted.");
                alert.showAndWait();
        RemplirTable();
        RemplirTable1();
        RemplirTable2();
        RemplirTable3();
        RemplirTable4();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("No User selected");
                alert.showAndWait();
                
            
        }
        
    }

    @FXML
    private void addweener(ActionEvent event) {
        
        WeenerAdd u=new WeenerAdd();
        u.AddWeener(id);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("New Weener added");
                alert.showAndWait();
        RemplirTable();
        RemplirTable1();
        RemplirTable2();
        RemplirTable3();
        RemplirTable4();
    }

    @FXML
    private void modifier(ActionEvent event) {
        
        
        if (this.selected==1){
            checkmdptf.clear();
            anchorupdate.setVisible(true);
        tabpane.setVisible(false);      
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("No User Selected");
                alert.showAndWait();
            
        }
       
    }

    @FXML
    private void message(ActionEvent event) {
        tabpane.setVisible(false);
        anchormyinfo.setVisible(false);
        anchormdp.setVisible(false);
        anchordelete.setVisible(false);
        
    }

    @FXML
    private void profil(ActionEvent event) {
        anchormdp.setVisible(false);
        anchormyinfo.setVisible(true);
        tabpane.setVisible(false);
        cachermagicbar();
        magic.setVisible(true);
        supprimer1.setVisible(false);
        supprimer.setVisible(false);
        addweener.setVisible(false);
        modifier.setVisible(false);
        anchordelete.setVisible(false);
        
    }

    @FXML
    private void historic(ActionEvent event) {
        anchormyinfo.setVisible(false);
        anchormdp.setVisible(false);
        tabpane.setVisible(false);
        anchordelete.setVisible(false);
    }

    @FXML
    private void newtrip(ActionEvent event) {
        anchormyinfo.setVisible(false);
        anchormdp.setVisible(false);
        anchordelete.setVisible(false);
        
    }

    @FXML
    private void tripprogram(ActionEvent event) {
        
        
        cacherbouton(tripprogram, newtrip, historic);
        
        
        anchormyinfo.setVisible(false);
        anchormdp.setVisible(false);
        anchorupdate.setVisible(false);
        anchordelete.setVisible(false);
        
        
        
    }

    @FXML
    private void trips(ActionEvent event) throws IOException {
        
        afficherbouton(tripprogram, newtrip, historic);
        
        tripprogram.setVisible(true);
        newtrip.setVisible(true);
        historic.setVisible(true);
    }

    

    

    

   

    @FXML
    private void statistic(ActionEvent event) {
        anchormyinfo.setVisible(false);
        anchormdp.setVisible(false);
        tabpane.setVisible(false);
        anchorupdate.setVisible(false);
        anchordelete.setVisible(false);
    }

    @FXML
    private void forum(ActionEvent event) {
        anchormdp.setVisible(false);
        anchormyinfo.setVisible(false);
        tabpane.setVisible(false);
        anchorupdate.setVisible(false);
        anchordelete.setVisible(false);
    }

    @FXML
    private void supprimer1(ActionEvent event) {
        if (this.selected==1){
            
        WeenerAdd u=new WeenerAdd();
        u.BlockUser(id);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("User blocked");
                alert.showAndWait();
        
        RemplirTable();
        RemplirTable1();
        RemplirTable2();
        RemplirTable3();
        RemplirTable4();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("No User Selected");
                alert.showAndWait();
            
        }
        
    }
    
    public void affichermagicbar(){
        Polyline polyline=new Polyline();
        polyline.getPoints().addAll(new Double[]{
        -85.0,320.0,
        85.0,320.0,
        75.0,320.0,
        85.0,320.0,
        80.0,320.0,
        85.0,320.0
        });
        PathTransition transation =new PathTransition();
        transation.setNode(magicbar);
        transation.setDuration(Duration.seconds(2));
        transation.setPath(polyline);
        transation.play();  
    }
    public void cachermagicbar(){
        Polyline polyline=new Polyline();
        polyline.getPoints().addAll(new Double[]{
        85.0,320.0,
        -85.0,320.0,
        
        });
        PathTransition transation =new PathTransition();
        transation.setNode(magicbar);
        transation.setDuration(Duration.seconds(2));
        transation.setPath(polyline);
        transation.play();  
    }
    
    public void afficherbouton(Button x,Button y,Button z){
        Polyline polyline=new Polyline();
        polyline.getPoints().addAll(new Double[]{
        100.0,30.0,
            100.0,52.0
        });
        
        PathTransition transation =new PathTransition();
        transation.setNode(x);
        transation.setDuration(Duration.seconds(2));
        transation.setPath(polyline);
        transation.play();
        
        
        Polyline polyline2=new Polyline();
        polyline2.getPoints().addAll(new Double[]{
        100.0,30.0,
        100.0,92.0,
        });
        PathTransition transation2 =new PathTransition();
        transation2.setNode(y);
        transation2.setDuration(Duration.seconds(2));
        transation2.setPath(polyline2);
        transation2.play();
        
        
        
        Polyline polyline3=new Polyline();
        polyline3.getPoints().addAll(new Double[]{
        100.0,30.0,
        100.0,132.0,
        });
        PathTransition transation3 =new PathTransition();
        transation3.setNode(z);
        transation3.setDuration(Duration.seconds(2));
        transation3.setPath(polyline3);
        transation3.play();
        
    }
    
    public void cacherbouton(Button x,Button y,Button z){
        Polyline polyline=new Polyline();
        polyline.getPoints().addAll(new Double[]{
        100.0,52.0,
            100.0,20.0
        });
        
        PathTransition transation =new PathTransition();
        transation.setNode(x);
        transation.setDuration(Duration.seconds(2));
        transation.setPath(polyline);
        transation.play();
        
        
        Polyline polyline2=new Polyline();
        polyline2.getPoints().addAll(new Double[]{
        100.0,92.0,
        100.0,20.0,
        });
        PathTransition transation2 =new PathTransition();
        transation2.setNode(y);
        transation2.setDuration(Duration.seconds(2));
        transation2.setPath(polyline2);
        transation2.play();
        
        
        
        Polyline polyline3=new Polyline();
        polyline3.getPoints().addAll(new Double[]{
        100.0,132.0,
        100.0,20.0,
        });
        PathTransition transation3 =new PathTransition();
        transation3.setNode(z);
        transation3.setDuration(Duration.seconds(2));
        transation3.setPath(polyline3);
        transation3.play();
        
    }

    @FXML
    private void selectuser(MouseEvent event) {
        PersonneToPerson PTP = tableuser.getSelectionModel().getSelectedItem();
        if(PTP!=null)
        {
        this.id= PTP.getIdutilisateur(); 
        nomtf.setText(PTP.getNom());
        prenomtf.setText(PTP.getPrenom());
        int a2=PTP.getIdadresse();
        String b2="";
        b2= Integer.toString(a2);
        adressetf.setText(b2);
        emailtf.setText(PTP.getEmail());
        int a=PTP.getTel();
        String b="";
        b= Integer.toString(a);
        teltf.setText(b);      
        logintf.setText(PTP.getIdentifiant());
        mdptf.setText(PTP.getMdp());
        this.selected=1;
        }    
        else this.selected=0;
    }

    @FXML
    private void insertinfo(ActionEvent event) {
        String nom = nomtf.getText();
        String prenom = prenomtf.getText();  
        String adresse = adressetf.getText();
        String email = emailtf.getText();  
        String tel = teltf.getText();
        String login = logintf.getText();  
        String mdp = mdptf.getText();
        String checkmdp=checkmdptf.getText();
        
        if((mdp.equals(checkmdp))&&(login.length()!=0)&&(nom.length()!=0)&&(prenom.length()!=0)&&(email.length()!=0)){
            WeenerAdd u = new WeenerAdd();
        u.UpdateUser(id, nom, prenom, parseInt(adresse), email, parseInt(tel), login, mdp);
        RemplirTable();
        RemplirTable1();
        RemplirTable2();
        RemplirTable3();
        RemplirTable4();
        anchorupdate.setVisible(false);
        tabpane.setVisible(true);
        
        }
        else {
            status.setText("Check Your informations");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Check your informations");
                alert.showAndWait();
            
        }
        
        
        
        
    }
    
    private void RemplirTable(){
        
        //***************************vider la table************************************
        ObservableList <PersonneToPerson>userSelected,allUser;
        allUser=tableuser.getItems();
        allUser.clear();
        //*****************************************************************************
        WeenerAdd p=new WeenerAdd();
        for(PersonneToPerson u:p.DisplayAllUser2()){         
            data.add(u);
        } 
       nom.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("nom"));
       prenom.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("prenom"));
       identifiant.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("identifiant"));
       tableuser.setItems(data);
        
    }
    
    private void RemplirTable1(){
        
        //***************************vider la table************************************
        ObservableList <PersonneToPerson>userSelected,allUser1;
        allUser1=tableuser1.getItems();
        allUser1.clear();
        //*****************************************************************************
        WeenerAdd p1=new WeenerAdd();
        for(PersonneToPerson u:p1.DisplayUserFriends(this.myid)){         
            data1.add(u);
        } 
       nom1.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("nom"));
       prenom1.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("prenom"));
       email1.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("email"));
       tel1.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,Integer>("tel"));
       identifiant1.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("identifiant"));
       tableuser1.setItems(data1);
        
    }
    
    private void RemplirTable2(){
        
        //***************************vider la table************************************
        ObservableList <PersonneToPerson>userSelected,allUser2;
        allUser2=tableuser2.getItems();
        allUser2.clear();
        //*****************************************************************************
        WeenerAdd p2=new WeenerAdd();
        for(PersonneToPerson u:p2.DisplayAllUser1()){         
            data2.add(u);
        } 
       nom2.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("nom"));
       prenom2.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("prenom"));
       email2.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("email"));
       tel2.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,Integer>("tel"));
       identifiant2.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("identifiant"));
       tableuser2.setItems(data2);
        
    }
    
    private void RemplirTable3(){
        
        //***************************vider la table************************************
        ObservableList <PersonneToPerson>userSelected,allUser3;
        allUser3=tableuser3.getItems();
        allUser3.clear();
        //*****************************************************************************
        WeenerAdd p3=new WeenerAdd();
        for(PersonneToPerson u:p3.DisplayAllUser9()){         
            data3.add(u);
        } 
       nom3.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("nom"));
       prenom3.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("prenom"));
       email3.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("email"));
       tel3.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,Integer>("tel"));
       identifiant3.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("identifiant"));
       tableuser3.setItems(data3);
        
    }
    
    private void RemplirTable4(){
        
        //***************************vider la table************************************
        ObservableList <PersonneToPerson>userSelected,allUser4;
        allUser4=tableuser4.getItems();
        allUser4.clear();
        //*****************************************************************************
        WeenerAdd p4=new WeenerAdd();
        for(PersonneToPerson u:p4.DisplayAllUser1()){         
            data4.add(u);
        } 
       nom4.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("nom"));
       prenom4.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("prenom"));
       identifiant4.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("identifiant"));
       tableuser4.setItems(data4);
        
    }
    
    private void RemplirTableCon(){
        
        //***************************vider la table************************************
        ObservableList <PersonneToPerson>userSelected,allUsercon;
        allUsercon=tableconnected.getItems();
        allUsercon.clear();
        //*****************************************************************************
        WeenerAdd pcon=new WeenerAdd();
        for(PersonneToPerson u:pcon.DisplayUserConnected()){         
            tablecon.add(u);
        } 
       namecon.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("nom"));
       lastnamecon.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("prenom"));
       
       tableconnected.setItems(tablecon);
        
    }

    @FXML
    private void selectuser1(MouseEvent event) {
        PersonneToPerson PTP = tableuser1.getSelectionModel().getSelectedItem();
        if(PTP!=null)
        {
        this.id= PTP.getIdutilisateur(); 
        nomtf.setText(PTP.getNom());
        prenomtf.setText(PTP.getPrenom());
        int a2=PTP.getIdadresse();
        String b2="";
        b2= Integer.toString(a2);
        adressetf.setText(b2);
        emailtf.setText(PTP.getEmail());
        int a=PTP.getTel();
        String b="";
        b= Integer.toString(a);
        teltf.setText(b);      
        logintf.setText(PTP.getIdentifiant());
        mdptf.setText(PTP.getMdp());
        this.selected=1;
        }    
        else this.selected=0;
    }

    @FXML
    private void selectuser2(MouseEvent event) {
        PersonneToPerson PTP = tableuser2.getSelectionModel().getSelectedItem();
        if(PTP!=null)
        {
        this.id= PTP.getIdutilisateur(); 
        nomtf.setText(PTP.getNom());
        prenomtf.setText(PTP.getPrenom());
        int a2=PTP.getIdadresse();
        String b2="";
        b2= Integer.toString(a2);
        adressetf.setText(b2);
        emailtf.setText(PTP.getEmail());
        int a=PTP.getTel();
        String b="";
        b= Integer.toString(a);
        teltf.setText(b);      
        logintf.setText(PTP.getIdentifiant());
        mdptf.setText(PTP.getMdp());
        this.selected=1;
        }    
        else this.selected=0;
    }

    @FXML
    private void selectuser3(MouseEvent event) {
        PersonneToPerson PTP = tableuser3.getSelectionModel().getSelectedItem();
        if(PTP!=null)
        {
        this.id= PTP.getIdutilisateur(); 
        nomtf.setText(PTP.getNom());
        prenomtf.setText(PTP.getPrenom());
        int a2=PTP.getIdadresse();
        String b2="";
        b2= Integer.toString(a2);
        adressetf.setText(b2);
        emailtf.setText(PTP.getEmail());
        int a=PTP.getTel();
        String b="";
        b= Integer.toString(a);
        teltf.setText(b);      
        logintf.setText(PTP.getIdentifiant());
        mdptf.setText(PTP.getMdp());
        this.selected=1;
        }    
        else this.selected=0;
    }

    @FXML
    private void magic(MouseEvent event) {
        magicbar.setVisible(true);
        affichermagicbar();
        magic.setVisible(false);
        
    }

    @FXML
    private void magic2(MouseEvent event) {
        magic.setVisible(false);
        cachermagicbar();
        magic.setVisible(true);
    }
    
    
    int myid;
    String mypassword;
    public void setInformation(int id){
        
        this.myid=id;
        WeenerAdd u=new WeenerAdd();   
        User user=u.FindUserById(myid);
        myname.setText(user.getName());
        mylastname.setText(user.getLastname());
        mynametf.setText(user.getName());
        mylastnametf.setText(user.getLastname());
        int a=user.getPhonenumber();
        String b="";
        b= Integer.toString(a);
        int a2=user.getIdaddress();
        String b2="";
        b2= Integer.toString(a2);
        myidaddresstf.setText(b2);
        myphonetf.setText(b);
        myemailtf.setText(user.getEmail());
        mylogintf.setText(user.getLogin());
        this.mypassword=user.getPassword();
    
    }
    
    
   /* private Connection connection; 
    public void fillCombo(City C) {
        
        try {
            
            String req="select * from City";
           PreparedStatement pst = connection.prepareStatement(req);
           ResultSet rs = pst.executeQuery();
           while (rs.next()) { 
            String nom=rs.getString("nomCity");
            Combobox.addItem(nom);
           }
            
        } catch (SQLException ex) {
            Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
          } */

    @FXML
    private void insertmynewinfo(ActionEvent event) {
         String prenom = mynametf.getText();
        String nom = mylastnametf.getText();  
        String adresse = myidaddresstf.getText();
        String email = myemailtf.getText();  
        String tel = myphonetf.getText();
        String login = mylogintf.getText();
        myname.setText(prenom);
        mylastname.setText(nom);
        if((prenom.length()!=0)&&(nom.length()!=0)&&(email.length()!=0)){
            
        
            WeenerAdd u = new WeenerAdd();
        u.UpdateUser(myid, prenom, nom, parseInt(adresse), email, parseInt(tel), login, mypassword);
        
        RemplirTable();
        RemplirTable1();
        RemplirTable2();
        RemplirTable3();
        RemplirTable4();
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Informations Changed");
                alert.showAndWait();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("check your informations");
                alert.showAndWait();
            
        }
        
    }


    @FXML
    private void insertmynewmdp(ActionEvent event) {
        String prenom = mynametf.getText();
        String nom = mylastnametf.getText();  
        String adresse = myidaddresstf.getText();
        String email = myemailtf.getText();  
        String tel = myphonetf.getText();
        String login = mylogintf.getText();  
        String mdp = mypasswordtf.getText();
        String checkmdp=mypasswordtf1.getText();
        
        if((mdp.equals(this.mypassword))&&(login.length()!=0)&&(mdp.length()!=0)){
            WeenerAdd u = new WeenerAdd();
        u.UpdateUser(myid, prenom, nom, parseInt(adresse), email, parseInt(tel), login, checkmdp);
        RemplirTable();
        RemplirTable1();
        RemplirTable2();
        RemplirTable3();
        RemplirTable4();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Password Changed");
                alert.showAndWait();
       
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Wrong: Check your new informations");
                alert.showAndWait();
        }
    }

    @FXML
    private void connectedweeners(ActionEvent event) {
        RemplirTableCon();
         if (tableconnected.isVisible()) {
            tableconnected.setVisible(false);
        } else {
            tableconnected.setVisible(true);
        }
         
    }

    @FXML
    private void friends(ActionEvent event) {
        tabpane.setVisible(true);
        supprimer1.setVisible(true);
        supprimer.setVisible(true);
        addweener.setVisible(true);
        modifier.setVisible(true);
        
        anchormyinfo.setVisible(false);
        anchormdp.setVisible(false);
        anchorupdate.setVisible(false);
        anchordelete.setVisible(false);
        
        RemplirTable();
        RemplirTable1();
        RemplirTable2();
        RemplirTable3();
        RemplirTable4();
    }

    @FXML
    private void home(ActionEvent event) {
    }



   
    
    
    
}
