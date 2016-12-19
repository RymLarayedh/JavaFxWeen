/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entities.User;
import Transformers.PersonneToPerson;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author ElarbiMohamedAymen
 */
public interface IWeenerAdd {
    public boolean AddUser(String nom,String prenom,int adresse,
            String email, int tel,String identifiant,String mdp);
    
    public List<PersonneToPerson> DisplayAllUser1();
    public List<PersonneToPerson> DisplayAllUser2();
    public List<PersonneToPerson> DisplayAllUser9();
   /* 
    public List<AirlineT> FindByName(String name);
    public boolean CheckUpdate(String name,String address,int id);*/
    public boolean DeleteUser(int id);
    public boolean AddWeener(int id);
    public boolean BlockUser(int id);
    public User FindWeener(String login,String mdp);
    public User FindAdmin(String login,String mdp);
    
    public boolean UpdateUser(int id, String prenom, String nom, int idadresse, String email,
        int tel, String login, String mdp);
    public void Connect(int id);
    public void Deconnect(int id);
    public List<PersonneToPerson> DisplayUserConnected();
    public List<PersonneToPerson> DisplayUserFriends(int id);
    
}
