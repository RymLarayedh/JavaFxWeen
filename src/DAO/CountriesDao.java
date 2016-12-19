/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Countries;
import Interfaces.ICountriesDao;
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



public class CountriesDao implements ICountriesDao<Countries> {
   

    private Connection connection;
    //private Statement st;//requete 1
    private PreparedStatement pst;//

    public CountriesDao() {
        //initialiser la connection
        connection = DataSource.getInstance().getConnection();
    }

    /**
     *
     * @param c
     */
   @Override
    public void add (Countries c) {
   String req = "insert into countries (name) values (?)";
        try {
            pst = connection.prepareStatement(req);
                       pst.setString(1, c.getName()); 
                  
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CountriesDao.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }

    @Override
    public void updatename(int id ,String name ) {
         
         String req = "update countries set name=? where id =?";
        try {
            pst = connection.prepareStatement(req);
            pst.setString(1, name);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CountriesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    public void delete(Countries t) {
 String requete = "delete from countries where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, t.getId());
            ps.executeUpdate();
            System.out.println("countries Dleted ");
        } catch (SQLException ex) {
            System.out.println("error  " + ex.getMessage());
        }
    }    

    @Override
    public List<Countries> findAll() {
        List<Countries> listeCountries = new ArrayList<>();
        Countries  C ;
        try {
            String req = "select * from countries";
            pst = connection.prepareStatement(req);
            ResultSet resultat = pst.executeQuery();
            while(resultat.next()){
              C = new Countries();
              C.setName(resultat.getString(1));
              C.setId (resultat.getInt(2));
               listeCountries.add(C);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CountriesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeCountries;

    }
    

    public List<Countries> findByname(String name) {
            Countries d = new Countries ();
        List<Countries>Ld = new ArrayList<>();
        String requete = "select * from destination where name='"+name+"'";
        try {
            Statement stm = null;
            stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(requete);
            //PreparedStatement ps = connection.prepareStatement(requete);
            //ps.setString(1,country);
            //ResultSet resultat = ps.executeQuery();
            while (rs.next()) 
            {
                d.setName(rs.getString(1));
           
               d.setId(rs.getInt(2));
                Ld.add(d);
            }
            return Ld;

        } catch (SQLException ex) {
            System.out.println("error " + ex.getMessage());
            return null;
        }
    }


   
        
        
    }


