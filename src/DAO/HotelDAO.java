/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interfaces.IDao;
import Entities.Hotel;
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

/**
 *
 * @author macbookpro
 */

    public class HotelDAO implements IDao<Hotel>{
    private Connection connection;
    private Statement st; //qui va cotenir la requete cote java 
    private PreparedStatement pst;//diff entre statement et preparedstatement 
    //Statement requete static simple (insert select.. 
    //statementprepared une requete incomplete exemple id=?

    public HotelDAO() {
        connection=DataSource.getInstance().getConnection();
    }
          
  

    @Override
    public void add(Hotel h) {
        String req="insert into hotel (name,hoteladdress,stars,country,rating,longitude,latitude,pricebynight) values (?,?,?,?,?,?,?,?)";
        try {
            
            
            pst=connection.prepareStatement(req);
            
            pst.setString(1,h.getName());
            pst.setString(2,h.getHoteladdress());
            pst.setInt(3,h.getStars());
            pst.setString(4,h.getCountry());
            pst.setFloat(5,h.getRating());
            pst.setString(6,h.getLongitude());
            pst.setString(7,h.getLatitude());
             pst.setFloat(8,h.getPricebynight());
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HotelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        
       

  
    public void update(Hotel h, String nom) {
        try {
            String req="UPDATE hotel SET name =? WHERE idhotel=?";
            pst=connection.prepareStatement(req);
            pst.setString(1,nom);
            pst.setInt(2,h.getIdhotel());
            pst.executeUpdate();
 //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(HotelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeById(int id) {
       try {
            String req="DELETE FROM hotel WHERE idhotel=?";
            pst=connection.prepareStatement(req);
            pst.setInt(1,id);
            pst.executeUpdate();
            }
       catch (SQLException ex) {
            Logger.getLogger(HotelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Hotel> findALL() {
         List<Hotel>listehotel=new ArrayList<>();
            Hotel h;
            
        try {
           String req="select * from hotel";
            pst=connection.prepareStatement(req);
            ResultSet resultat =pst.executeQuery();
            while(resultat.next()){
                h=new Hotel();
                h.setIdhotel(resultat.getInt(1));
                h.setName(resultat.getString(2));
                h.setStars(resultat.getInt(3));
                h.setCountry(resultat.getString(4));
                h.setRating(resultat.getFloat(5));
                h.setHoteladdress(resultat.getString(6));
                h.setLongitude(resultat.getString(7));
                h.setLatitude(resultat.getString(8));
                h.setPricebynight(resultat.getFloat(9));
                listehotel.add(h);
            }
            
             //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(HotelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listehotel;
    }

    @Override
    public Hotel findById(int id) {
       Hotel h = new Hotel();
        String req = "select * from hotel where idhotel = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(req);
            pst.setInt(1,id);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                h.setIdhotel(resultat.getInt(1));
                h.setName(resultat.getString(2));
                h.setStars(resultat.getInt(3));
                h.setCountry(resultat.getString(4));
                h.setRating(resultat.getFloat(5));
                h.setHoteladdress(resultat.getString(6));
                h.setLongitude(resultat.getString(7));
                h.setLatitude(resultat.getString(8));
                 h.setPricebynight(resultat.getFloat(9));
                  
            }
            return h;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche de l'utilisateur " + ex.getMessage());
            return null;
        }
    }
         
    

    public void UpdateHotel(int id,String name,int etoiles,String adresse,float note,String pays,String longitud,String latitud,float prixnuit) {
        String req="update hotel set name=?,stars=?,country=?,rating=?,hoteladdress=?,logitude=?,latitude=?,pricebynight where idhotel=?";
        try {
            pst=connection.prepareStatement(req);
            pst.setString(1,name);
            pst.setInt(2,etoiles);
            pst.setString(3,adresse);
            pst.setFloat(4,note);
            pst.setString(5,pays);
            pst.setString(6,longitud);
            pst.setString(7,latitud);
            pst.setFloat(8,prixnuit);
            
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HotelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   //To change body of generated methods, choose Tools | Templates.

    @Override
    public void update(Hotel t, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }

    

    

    
