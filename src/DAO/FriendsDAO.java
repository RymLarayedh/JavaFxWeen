/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Friends;
import Entities.Rating;
import Entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;
import Interfaces.IFriends;

/**
 *
 * @author rymlarayedh
 */
public class FriendsDAO implements IFriends {
    private Connection connection;
    private Statement st; 
    private PreparedStatement pst;
    
    public FriendsDAO() {
        connection=DataSource.getInstance().getConnection();
    }
    
    @Override
    public List<Integer> findById(int id) {
        List<Integer>listeUtilisateur=new ArrayList<>();
       Friends f;
        
        try {
            String req = "select * from friends where userid = ?";
            PreparedStatement pst = connection.prepareStatement(req);
            pst.setInt(1,id);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                f=new Friends();
                f.setUserid(resultat.getInt(1));
                f.setFriendid(resultat.getInt(2));
                listeUtilisateur.add(resultat.getInt(2));
                
                  
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      return listeUtilisateur;  
    }
    
    
}
