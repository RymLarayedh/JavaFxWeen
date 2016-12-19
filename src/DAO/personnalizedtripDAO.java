/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interfaces.IDao;

import Entities.personnalizedtrip;
import java.sql.Connection;
import java.sql.Date;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.input.KeyCode.H;
import utils.DataSource;

/**
 *
 * @author macbookpro
 */
public class personnalizedtripDAO implements IDao<personnalizedtrip>{
    private Connection connection;
    private Statement st;
    private PreparedStatement pst;

    public personnalizedtripDAO() {
        connection=DataSource.getInstance().getConnection();
    }
    
    

    @Override
    public void add(personnalizedtrip t) {
      String req="insert into personnalizedtrip(departuredate,arrivaldate,nights,flightid,hotelid,price,userid) values (?,?,?,?,?,?,?)";
        try {
            
            
           
              pst=connection.prepareStatement(req);             
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                java.util.Date date1 = null;
                java.util.Date date2 = null;
        try {
            date1 = sdf.parse(sdf.format(t.getArrivaldate()));
            date2 = sdf.parse(sdf.format(t.getDeparturedate()));

        } catch (ParseException ex) {
            Logger.getLogger(personnalizedtripDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());
                java.sql.Date sqlDate2 = new java.sql.Date(date2.getTime());     
              
              pst.setDate(1,sqlDate1 );
              pst.setDate(2, sqlDate2);
             pst.setInt(3,t.getNights());
            pst.setInt(4,t.getFlightid());
            pst.setInt(5,t.getHotelid());
            pst.setFloat(6,t.getPrice());
            pst.setInt(7,t.getUserid());
             
              
              pst.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(personnalizedtripDAO.class.getName()).log(Level.SEVERE, null, ex);
          }    
    }

    @Override
    public void update(personnalizedtrip t, int id) {
       try {
            String req="UPDATE personnalizedtrip SET departuredate=?,arrivaldate=?,nights=? WHERE id=?";
            pst=connection.prepareStatement(req);
            pst.setDate(1,t.getDeparturedate());
            pst.setDate(2,t.getArrivaldate());
            pst.setInt(3,t.getNights());
            pst.setInt(4,id);
            pst.executeUpdate();
 //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(HotelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeById(int id) {
       try {
            String req="DELETE FROM personnalizedtrip WHERE idtrip=?";
            pst=connection.prepareStatement(req);
            pst.setInt(1,id);
            pst.executeUpdate();
            }
       catch (SQLException ex) {
            Logger.getLogger(HotelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<personnalizedtrip> findALL() {
        List<personnalizedtrip>listepersotrip=new ArrayList<>();
            personnalizedtrip p;
            
        try {
           String req="select * from hotel";
            pst=connection.prepareStatement(req);
            ResultSet resultat =pst.executeQuery();
            while(resultat.next()){
                p=new personnalizedtrip();
                p.setIdtrip(resultat.getInt(1));
                p.setDeparturedate(resultat.getDate(2));
                p.setArrivaldate(resultat.getDate(3));
                p.setNights(resultat.getInt(4));
                p.setFlightid(resultat.getInt(5));
                p.setHotelid(resultat.getInt(6));
                p.setUserid(resultat.getInt(7));
                
                listepersotrip.add(p);
            }
    } catch (SQLException ex) {
            Logger.getLogger(HotelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listepersotrip;

    }
    @Override
    public personnalizedtrip findById(int id) {
        List<personnalizedtrip>listepersotrip=new ArrayList<>();
       personnalizedtrip p;
            
        try {
           String req="select * from hotel";
            pst=connection.prepareStatement(req);
            ResultSet resultat =pst.executeQuery();
            while(resultat.next()){
                p=new personnalizedtrip();
                p.setIdtrip(resultat.getInt(1));
                p.setDeparturedate(resultat.getDate(2));
                p.setArrivaldate(resultat.getDate(3));
                p.setNights(resultat.getInt(4));
                p.setFlightid(resultat.getInt(5));
                p.setHotelid(resultat.getInt(6));
                p.setUserid(resultat.getInt(7));
                
                listepersotrip.add(p);
            }
    } catch (SQLException ex) {
            Logger.getLogger(HotelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (personnalizedtrip) listepersotrip;
    
}

    @Override
    public void UpdateHotel(int id, String name, int etoiles, String adresse, float note, String pays, String longitud, String latitud, float prixnuit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(personnalizedtrip t, String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
