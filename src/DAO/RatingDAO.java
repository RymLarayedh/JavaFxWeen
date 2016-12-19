/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Rating;
import Interfaces.IRating;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author ElarbiMohamedAymen
 */
public class RatingDAO implements IRating{
    private Connection connection;
    private PreparedStatement pst;

    public RatingDAO() {
        connection = DataSource.getInstance().getConnection();

    }

    @Override
    public void Add(Rating R) {
        String req ="insert into Rating(UserId,rate)values(?,?)";
           try {         
            pst = connection.prepareStatement(req);
            pst.setInt(1,R.getUserId());
            pst.setInt(2,R.getRate());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RatingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Update(int id) {
       Rating R = FindById(id);
       if (R != null)
       {
           
       }
    }

    @Override
    public void RemoveById(int id) {
           
        String req ="delete from Rating where RatingId=?";
           try {         
            pst = connection.prepareStatement(req);
            pst.setInt(1,id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RatingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Rating FindById(int id) {
      String req = "select * from Rating where RatingId=? " ;
            Rating R=null ;
                 try {   
            pst=connection.prepareStatement(req);
            pst.setInt(1,id);
            ResultSet Rs = pst.executeQuery(req);          
                R = new Rating ();
                R.setRatingid(Rs.getInt(1));
                R.setRate(Rs.getInt(2));
                R.setUserId(Rs.getInt(3));                       
        } catch (SQLException ex) {
            Logger.getLogger(RatingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                 return R;   
    }

    @Override
    public List<Rating> FindAll() {
        String req = "select * from Rating" ;
            Rating R ;
            List<Rating>Lr = new ArrayList<>();
                 try {   
            pst=connection.prepareStatement(req);
            ResultSet Rs = pst.executeQuery(req);
            while(Rs.next())
            {            
                R = new Rating ();
                R.setRatingid(Rs.getInt(1));
                R.setRate(Rs.getInt(2));
                R.setUserId(Rs.getInt(3));
                Lr.add(R);             
            }
        } catch (SQLException ex) {
            Logger.getLogger(RatingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                 return Lr;
    
    }
    
    
    
    
    
}
