/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.AirlineCompany;
import Interfaces.IAirlineCompany;
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
 * @author ElarbiMohamedAymen
 */
public class AirlineCompanyDAO implements IAirlineCompany <AirlineCompany> {
    private Connection connection;
    private PreparedStatement pst;

    public AirlineCompanyDAO() {
        connection = DataSource.getInstance().getConnection();
    }
   
    @Override
    public void add(AirlineCompany t) {
        String req ="insert into airlinecompany(name,address)values(?,?)";
           try {         
            pst = connection.prepareStatement(req);
            pst.setString(1,t.getName());
            pst.setString(2,t.getAdresse());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AirlineCompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateName(int id, String NewName)throws Exception{
        String req ="UPDATE airlinecompany set name=? where idairlinecompany=?";
       
            pst = connection.prepareStatement(req);
            pst.setInt(2,id);
            pst.setString(1,NewName);
            pst.executeUpdate();

    }

    @Override
    public void updateAdresse(int id, String NewAdresse)throws Exception{
        String req ="UPDATE airlinecompany set address=? where idairlinecompany=?";
           try {         
            pst = connection.prepareStatement(req);
            pst.setInt(2,id);
            pst.setString(1,NewAdresse);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AirlineCompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeById(int id) {    
        String req ="delete from airlinecompany where idairlinecompany=?";
           try {         
            pst = connection.prepareStatement(req);
            pst.setInt(1,id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AirlineCompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<AirlineCompany> findAll() {
    String req = "select * from airlinecompany" ;
            AirlineCompany P ;
            List<AirlineCompany>La = new ArrayList<>();
                 try {   
            pst=connection.prepareStatement(req);
            ResultSet Rs = pst.executeQuery(req);
            while(Rs.next())
            {            
                P = new AirlineCompany ();
                P.setCompanyId(Rs.getInt(1));
                P.setName(Rs.getString(2));
                P.setAdresse(Rs.getString(3));
                La.add(P);             
            }
        } catch (SQLException ex) {
            Logger.getLogger(AirlineCompany.class.getName()).log(Level.SEVERE, null, ex);
        }
                 return La;
    }

    @Override
    public AirlineCompany findById(int id) {
        Statement ste;
        AirlineCompany p = new AirlineCompany();
        try {
            ste = connection.createStatement();
            String req="select * from airlinecompany where idairlinecompany='"+id+"'";
            ResultSet rs=ste.executeQuery(req);
            while(rs.next())
            {  
            p=new AirlineCompany(rs.getInt(1),rs.getString(2),rs.getString(3));
        } 
        }catch (SQLException ex) {
            Logger.getLogger(AirlineCompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            return p;
    }
    
        @Override
    public AirlineCompany findByAdresse(String address) {
        Statement ste;
        AirlineCompany p = new AirlineCompany();
        try {
            ste = connection.createStatement();
            String req="select * from airlinecompany where address='"+address+"'";
            ResultSet rs=ste.executeQuery(req);
            while(rs.next())
            {  
            p=new AirlineCompany(rs.getInt(1),rs.getString(2),rs.getString(3));
        } 
        }catch (SQLException ex) {
            Logger.getLogger(AirlineCompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            return p;
    }
    
        @Override
    public AirlineCompany findByName(String name) {
        Statement ste;
        AirlineCompany p = new AirlineCompany();
        try {
            ste = connection.createStatement();
            String req="select * from airlinecompany where name='"+name+"'";
            ResultSet rs=ste.executeQuery(req);
            while(rs.next())
            {  
            p=new AirlineCompany(rs.getInt(1),rs.getString(2),rs.getString(3));
        } 
        }catch (SQLException ex) {
            Logger.getLogger(AirlineCompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            return p;
    }
    
        public boolean checkexistance(String name,String address){
            String req="select address from airlinecompany where name='"+name+"'";
             Statement ste;
             List<String>La = new ArrayList<>();
        AirlineCompany p = new AirlineCompany();
        try {
            ste = connection.createStatement();
            ResultSet rs=ste.executeQuery(req);
            while(rs.next())
            {  
                La.add(rs.getString(1));
        } 
            if(La.contains(address))
            {
                return true;
            }
        }catch (SQLException ex) {
            Logger.getLogger(AirlineCompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            return false;
        }  
        
        public List<AirlineCompany> findByNameList(String name) {
        Statement ste;
        AirlineCompany p = new AirlineCompany();
        List<AirlineCompany> La = new ArrayList<>();
        try {
            ste = connection.createStatement();
            String req="select * from airlinecompany where name='"+name+"'";
            ResultSet rs=ste.executeQuery(req);
            while(rs.next())
            {  
            p=new AirlineCompany(rs.getInt(1),rs.getString(2),rs.getString(3));
            La.add(p);
        } 
        }catch (SQLException ex) {
            Logger.getLogger(AirlineCompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            return La;
    }
}
