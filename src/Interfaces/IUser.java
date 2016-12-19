/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entities.User;
import java.util.List;

/**
 *
 * @author rymlarayedh
 */
public interface IUser <T>{
    void addUser(T t);
    void updateName(int id,String m);
    void updateLastname(int id,String m);
    void updateEmail(int id,String m);
    void updatePhonenumber(int id,int m);
    void updateIdaddress(int id,int m);
    void updateLogin(int id,String m);
    void updatePassword(int id,String m);
    
    //*****************************************************
    //********* Gestion Utilisateur de l'admin ************
   void isAdmin(int id);
    void removeUserById(int id);
    List<T> findAllUser();
    
    public List<User> findUserConnected();
    T findByUserId(int id);
    public User findWeener(String login,String mdp) ;
    public User findAdmin(String login,String mdp) ;
    void UpdateUser(int id,String nom,String prenom,int idadresse,String email,int tel,String login,String mdp);
        
    public List<User> findUserByStatus(int status);

    void isWeener(int id);
    public void isBlocked(int id);
    public void connect(int id);
    public void deconnect(int id);
    //*****************************************************
    //********* Gestion Voyage de l'admin ************
    
    //void removeVoyageById(int id);
    //T findByIdVoyage(int id);*/
    
}
