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
import Trade.UserAdd;
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
public class ProfileAdminController implements Initializable {
    @FXML
    private TableView<PersonneToPerson> tableuser;
    @FXML
    private TableColumn<PersonneToPerson, Integer> idutilisateur;
    @FXML
    private TableColumn<PersonneToPerson, String> nom;
    @FXML
    private TableColumn<PersonneToPerson, String> prenom;
    @FXML
    private TableColumn<PersonneToPerson, Integer> adresse;
    @FXML
    private TableColumn<PersonneToPerson, String> email;
    @FXML
    private TableColumn<PersonneToPerson, Integer> tel;
    @FXML
    private TableColumn<PersonneToPerson, String> identifiant;
    @FXML
    private TableColumn<PersonneToPerson, String> mdp;
    @FXML
    private TableColumn<PersonneToPerson, Integer> isadmin;
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
    private Button comment;
    @FXML
    private Button reservation;
    @FXML
    private Button users;
    @FXML
    private Button service;
    @FXML
    private Button countrycity;
    @FXML
    private Button airline;
    @FXML
    private Button trip;
    @FXML
    private Button manage;
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
    private TableColumn<PersonneToPerson, Integer> idutilisateur1;
    @FXML
    private TableColumn<PersonneToPerson, String> nom1;
    @FXML
    private TableColumn<PersonneToPerson, String> prenom1;
    @FXML
    private TableColumn<PersonneToPerson, Integer> adresse1;
    @FXML
    private TableColumn<PersonneToPerson, String> email1;
    @FXML
    private TableColumn<PersonneToPerson, Integer> tel1;
    @FXML
    private TableColumn<PersonneToPerson, String> identifiant1;
    @FXML
    private TableColumn<PersonneToPerson, String> mdp1;
    @FXML
    private TableColumn<PersonneToPerson, Integer> isadmin1;
    ObservableList<PersonneToPerson>data1=FXCollections.observableArrayList();
    
    
    
    
    @FXML
    private TableView<PersonneToPerson> tableuser2;
    @FXML
    private TableColumn<PersonneToPerson, Integer> idutilisateur2;
    @FXML
    private TableColumn<PersonneToPerson, String> nom2;
    @FXML
    private TableColumn<PersonneToPerson, String> prenom2;
    @FXML
    private TableColumn<PersonneToPerson, Integer> adresse2;
    @FXML
    private TableColumn<PersonneToPerson, String> email2;
    @FXML
    private TableColumn<PersonneToPerson, Integer> tel2;
    @FXML
    private TableColumn<PersonneToPerson, String> identifiant2;
    @FXML
    private TableColumn<PersonneToPerson, String> mdp2;
    @FXML
    private TableColumn<PersonneToPerson, Integer> isadmin2;
    ObservableList<PersonneToPerson>data2=FXCollections.observableArrayList();
    
    @FXML
    private TableView<PersonneToPerson> tableuser3;
    @FXML
    private TableColumn<PersonneToPerson, Integer> idutilisateur3;
    @FXML
    private TableColumn<PersonneToPerson, String> nom3;
    @FXML
    private TableColumn<PersonneToPerson, String> prenom3;
    @FXML
    private TableColumn<PersonneToPerson, Integer> adresse3;
    @FXML
    private TableColumn<PersonneToPerson, String> email3;
    @FXML
    private TableColumn<PersonneToPerson, Integer> tel3;
    @FXML
    private TableColumn<PersonneToPerson, String> identifiant3;
    @FXML
    private TableColumn<PersonneToPerson, String> mdp3;
    @FXML
    private TableColumn<PersonneToPerson, Integer> isadmin3;
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
        trip.setVisible(false);
        airline.setVisible(false);
        countrycity.setVisible(false);
        users.setVisible(false);
        reservation.setVisible(false);
        comment.setVisible(false);
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
        UserAdd p=new UserAdd();
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
        UserAdd p=new UserAdd();
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
        UserAdd p=new UserAdd();
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
        
        UserAdd u=new UserAdd();
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
    private void comment(ActionEvent event) {
        anchormyinfo.setVisible(false);
        anchormdp.setVisible(false);
        tabpane.setVisible(false);
        anchordelete.setVisible(false);
    }

    @FXML
    private void reservation(ActionEvent event) {
        anchormyinfo.setVisible(false);
        anchormdp.setVisible(false);
        anchordelete.setVisible(false);
        
    }

    @FXML
    private void users(ActionEvent event) {
        
        
        cacherbouton(users,reservation,comment);
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
        
    }

    @FXML
    private void service(ActionEvent event) throws IOException {
        
        afficherbouton(users, reservation, comment);
        trip.setVisible(false);
        airline.setVisible(false);
        countrycity.setVisible(false);
        users.setVisible(true);
        reservation.setVisible(true);
        comment.setVisible(true);
    }

    @FXML
    private void countrycity(ActionEvent event) {
        anchormyinfo.setVisible(false);
        anchormdp.setVisible(false);
        anchorupdate.setVisible(false);
        tabpane.setVisible(false);
        anchordelete.setVisible(false);
    }

    @FXML
    private void airline(ActionEvent event) {
        anchormyinfo.setVisible(false);
        anchormdp.setVisible(false);
        anchorupdate.setVisible(false);
        tabpane.setVisible(false);
    }

    @FXML
    private void trip(ActionEvent event) {
        anchormyinfo.setVisible(false);
        anchormdp.setVisible(false);
        anchorupdate.setVisible(false);
        tabpane.setVisible(false);
        anchordelete.setVisible(false);
    }

    @FXML
    private void manage(ActionEvent event) {
        
        afficherbouton(trip, airline, countrycity);
        users.setVisible(false);
        reservation.setVisible(false);
        comment.setVisible(false);
        trip.setVisible(true);
        airline.setVisible(true);
        countrycity.setVisible(true);
        
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
            
        UserAdd u=new UserAdd();
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
        77.0,30.0,
            77.0,52.0
        });
        
        PathTransition transation =new PathTransition();
        transation.setNode(x);
        transation.setDuration(Duration.seconds(2));
        transation.setPath(polyline);
        transation.play();
        
        
        Polyline polyline2=new Polyline();
        polyline2.getPoints().addAll(new Double[]{
        77.0,30.0,
        77.0,92.0,
        });
        PathTransition transation2 =new PathTransition();
        transation2.setNode(y);
        transation2.setDuration(Duration.seconds(2));
        transation2.setPath(polyline2);
        transation2.play();
        
        
        
        Polyline polyline3=new Polyline();
        polyline3.getPoints().addAll(new Double[]{
        77.0,30.0,
        77.0,132.0,
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
        77.0,52.0,
            77.0,20.0
        });
        
        PathTransition transation =new PathTransition();
        transation.setNode(x);
        transation.setDuration(Duration.seconds(2));
        transation.setPath(polyline);
        transation.play();
        
        
        Polyline polyline2=new Polyline();
        polyline2.getPoints().addAll(new Double[]{
        77.0,92.0,
        77.0,20.0,
        });
        PathTransition transation2 =new PathTransition();
        transation2.setNode(y);
        transation2.setDuration(Duration.seconds(2));
        transation2.setPath(polyline2);
        transation2.play();
        
        
        
        Polyline polyline3=new Polyline();
        polyline3.getPoints().addAll(new Double[]{
        77.0,132.0,
        77.0,20.0,
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
            UserAdd u = new UserAdd();
        u.UpdateUser(id, nom, prenom, parseInt(adresse), email, parseInt(tel), login, mdp);
        RemplirTable();
        RemplirTable1();
        RemplirTable2();
        RemplirTable3();
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
        UserAdd p=new UserAdd();
        for(PersonneToPerson u:p.DisplayAllUser()){         
            data.add(u);
        } 
        idutilisateur.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,Integer>("idutilisateur"));
       nom.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("nom"));
       prenom.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("prenom"));
       adresse.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,Integer>("adresse"));
       email.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("email"));
       tel.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,Integer>("tel"));
       identifiant.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("identifiant"));
       mdp.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("mdp"));
       isadmin.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,Integer>("isadmin"));
       tableuser.setItems(data);
        
    }
    
    private void RemplirTable1(){
        
        //***************************vider la table************************************
        ObservableList <PersonneToPerson>userSelected,allUser1;
        allUser1=tableuser1.getItems();
        allUser1.clear();
        //*****************************************************************************
        UserAdd p1=new UserAdd();
        for(PersonneToPerson u:p1.DisplayAllUser2()){         
            data1.add(u);
        } 
        idutilisateur1.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,Integer>("idutilisateur"));
       nom1.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("nom"));
       prenom1.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("prenom"));
       adresse1.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,Integer>("adresse"));
       email1.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("email"));
       tel1.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,Integer>("tel"));
       identifiant1.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("identifiant"));
       mdp1.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("mdp"));
       isadmin1.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,Integer>("isadmin"));
       tableuser1.setItems(data1);
        
    }
    
    private void RemplirTable2(){
        
        //***************************vider la table************************************
        ObservableList <PersonneToPerson>userSelected,allUser2;
        allUser2=tableuser2.getItems();
        allUser2.clear();
        //*****************************************************************************
        UserAdd p2=new UserAdd();
        for(PersonneToPerson u:p2.DisplayAllUser1()){         
            data2.add(u);
        } 
        idutilisateur2.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,Integer>("idutilisateur"));
       nom2.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("nom"));
       prenom2.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("prenom"));
       adresse2.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,Integer>("adresse"));
       email2.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("email"));
       tel2.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,Integer>("tel"));
       identifiant2.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("identifiant"));
       mdp2.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("mdp"));
       isadmin2.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,Integer>("isadmin"));
       tableuser2.setItems(data2);
        
    }
    
    private void RemplirTable3(){
        
        //***************************vider la table************************************
        ObservableList <PersonneToPerson>userSelected,allUser3;
        allUser3=tableuser3.getItems();
        allUser3.clear();
        //*****************************************************************************
        UserAdd p3=new UserAdd();
        for(PersonneToPerson u:p3.DisplayAllUser9()){         
            data3.add(u);
        } 
        idutilisateur3.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,Integer>("idutilisateur"));
       nom3.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("nom"));
       prenom3.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("prenom"));
       adresse3.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,Integer>("adresse"));
       email3.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("email"));
       tel3.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,Integer>("tel"));
       identifiant3.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("identifiant"));
       mdp3.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,String>("mdp"));
       isadmin3.setCellValueFactory(new PropertyValueFactory<PersonneToPerson,Integer>("isadmin"));
       tableuser3.setItems(data3);
        
    }
    
    private void RemplirTableCon(){
        
        //***************************vider la table************************************
        ObservableList <PersonneToPerson>userSelected,allUsercon;
        allUsercon=tableconnected.getItems();
        allUsercon.clear();
        //*****************************************************************************
        UserAdd pcon=new UserAdd();
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
        UserAdd u=new UserAdd();   
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
            
        
            UserAdd u = new UserAdd();
        u.UpdateUser(myid, prenom, nom, parseInt(adresse), email, parseInt(tel), login, mypassword);
        RemplirTable();
        RemplirTable1();
        RemplirTable2();
        RemplirTable3();
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
            UserAdd u = new UserAdd();
        u.UpdateUser(myid, prenom, nom, parseInt(adresse), email, parseInt(tel), login, checkmdp);
        RemplirTable();
        RemplirTable1();
        RemplirTable2();
        RemplirTable3();
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


   
    
    
    
}
