/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trade;

import Transformers.PersonneToPerson;
import DAO.UserDAO;
import Entities.User;
import Interfaces.IUser;
import Interfaces.IUserAdd;
import utils.DataSource;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ElarbiMohamedAymen
 */
public class UserAdd implements IUserAdd{
private Connection connection; 
    public UserAdd() {
        connection=DataSource.getInstance().getConnection();
    }

    
    @Override
    public boolean AddUser(String nom,String prenom,int adresse,
            String email, int tel,String identifiant,String mdp) {
        
            UserDAO udao = new UserDAO();
            User u = new User(nom, prenom, adresse, email, tel, identifiant, mdp);
            
            udao.addUser(u);
            return true;
    }

    @Override
    public List<PersonneToPerson> DisplayAllUser() {
        
        UserDAO pdao = new UserDAO();
        List <User> all = new ArrayList<>();
        List <PersonneToPerson>PP = new ArrayList();
        
        all =  pdao.findAllUser();
        for(User X:all)
        {
            
            PersonneToPerson PTP = new PersonneToPerson(X.getUserId(), X.getName(), X.getLastname(),
            X.getIdaddress(), X.getEmail(), X.getPhonenumber(),
            X.getLogin(), X.getPassword());
            PP.add(PTP);
        }
        
      return PP;
    }
    public List<PersonneToPerson> DisplayAllUser1() {
        
        UserDAO pdao = new UserDAO();
        List <User> all = new ArrayList<>();
        List <PersonneToPerson>PP = new ArrayList();
        
        all =  pdao.findUserByStatus(1);
        for(User X:all)
        {
            
            PersonneToPerson PTP = new PersonneToPerson(X.getUserId(), X.getName(), X.getLastname(),
            X.getIdaddress(), X.getEmail(), X.getPhonenumber(),
            X.getLogin(), X.getPassword());
            PP.add(PTP);
        }
        
      return PP;
    }
    public List<PersonneToPerson> DisplayAllUser2() {
        
        UserDAO pdao = new UserDAO();
        List <User> all = new ArrayList<>();
        List <PersonneToPerson>PP = new ArrayList();
        
        all =  pdao.findUserByStatus(2);
        for(User X:all)
        {
            
            PersonneToPerson PTP = new PersonneToPerson(X.getUserId(), X.getName(), X.getLastname(),
            X.getIdaddress(), X.getEmail(), X.getPhonenumber(),
            X.getLogin(), X.getPassword());
            PP.add(PTP);
        }
        
      return PP;
    }
    public List<PersonneToPerson> DisplayAllUser9() {
        
        UserDAO pdao = new UserDAO();
        List <User> all = new ArrayList<>();
        List <PersonneToPerson>PP = new ArrayList();
        
        all =  pdao.findUserByStatus(9);
        for(User X:all)
        {
            
            PersonneToPerson PTP = new PersonneToPerson(X.getUserId(), X.getName(), X.getLastname(),
            X.getIdaddress(), X.getEmail(), X.getPhonenumber(),
            X.getLogin(), X.getPassword());
            PP.add(PTP);
        }
        
      return PP;
    }
/*
    @Override
    public List<AirlineT> FindByName(String name) {
        AirlineCompanyDAO ADAO = new AirlineCompanyDAO();
        List<AirlineCompany> Tmp = ADAO.findByNameList(name);
        List<AirlineT> TTmp = new ArrayList<>();
        for(AirlineCompany X:Tmp)
        {
            AirlineT PTP = new AirlineT(X.getCompanyId(), X.getName(), X.getAdresse());
            TTmp.add(PTP);
        }
        return TTmp;
    }*/
    
    @Override
    public User FindWeener(String login,String mdp) {
        UserDAO udao = new UserDAO();
        User u;
        u=udao.findWeener(login, mdp);
        return u;
    }
    
    @Override
    public User FindAdmin(String login,String mdp) {
        UserDAO udao = new UserDAO();
        User u;
        u=udao.findAdmin(login, mdp);
        return u;
    }
    
    
    @Override
    public boolean UpdateUser(int id, String prenom, String nom, int idadresse, String email,
        int tel, String login, String mdp)
    {
           UserDAO pdao=new UserDAO();
        pdao.UpdateUser(id, prenom, nom, idadresse, email, tel, login, mdp);
           return true; 
    }

    @Override
    public boolean DeleteUser(int id) {
        UserDAO udao = new UserDAO();
        
        if(udao.findByUserId(id).getUserId()!=0){
            udao.removeUserById(id);
            return true;
        }
        return false;

    }

    @Override
    public boolean AddWeener(int id) {
        UserDAO pdao=new UserDAO();
        
        if(pdao.findByUserId(id).getUserId()!=0){
            pdao.isWeener(id);;
            return true;
        }
        return false;
        
        
    }
    
    @Override
    public boolean BlockUser(int id) {
        UserDAO pdao=new UserDAO();
        
        if(pdao.findByUserId(id).getUserId()!=0){
            pdao.isBlocked(id);
            return true;
        }
        return false;
        
        
    }
    
    public User FindUserById(int id){
        UserDAO udao=new UserDAO();
        return(udao.findByUserId(id));
        
    }
    public void Connect(int id){
        UserDAO udao=new UserDAO();
        udao.connect(id);
        
    }
    public void Deconnect(int id){
        UserDAO udao=new UserDAO();
        udao.deconnect(id);
        
    }
    
    @Override
    public List<PersonneToPerson> DisplayUserConnected() {
        
        UserDAO pdao = new UserDAO();
        List <User> all = new ArrayList<>();
        List <PersonneToPerson>PP = new ArrayList();
        
        all =  pdao.findUserConnected();
        for(User X:all)
        {
            
            PersonneToPerson PTP = new PersonneToPerson(X.getUserId(), X.getName(), X.getLastname(),
            X.getIdaddress(), X.getEmail(), X.getPhonenumber(),
            X.getLogin(), X.getPassword());
            PP.add(PTP);
        }
        
      return PP;
    }

    
    
    
    
    
    
    
}
