/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Flight;
import Interfaces.IDAOFlight;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import utils.DataSource;


/**
 *
 * @author Ines
 */
public class FlightDAO implements IDAOFlight<Flight> {
    private Connection connection ;
    private PreparedStatement pst;// la requete
    private Statement ste ;


    public FlightDAO() {
        connection = DataSource.getInstance().getConnection();
    }
    

    @Override
    public void add(Flight F) {
   
         String req="insert into flight  (arrivaldate,departuredate,price,idairlinecompany) values (?,?,?,1)"; 
                try {
                pst=connection.prepareStatement(req);             
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                java.util.Date date1 = null;
                java.util.Date date2 = null;
        try {
            date1 = sdf.parse(sdf.format(F.getArrivalDate()));
            date2 = sdf.parse(sdf.format(F.getDepartureDate()));

        } catch (ParseException ex) {
            Logger.getLogger(FlightDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());
                java.sql.Date sqlDate2 = new java.sql.Date(date2.getTime());     
              
              pst.setDate(1,sqlDate1 );
              pst.setDate(2, sqlDate2);
              pst.setFloat(3,F.getPrice());
              
              pst.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(FlightDAO.class.getName()).log(Level.SEVERE, null, ex);
          }    }
    

    @Override
    public void updatePrice(Flight F, float price) {
         String req="update flight set price=? where idflight=?";

          try {
              pst=connection.prepareStatement(req);
              pst.setFloat(1, price);
              pst.setInt(2, F.getFlightId());
              pst.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(FlightDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
        
    }

    @Override
    public void updateArrivalDate(Flight F, Date ArrivalDate) {
           
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                java.util.Date date = null;
        try {
            date = sdf.parse(sdf.format(ArrivalDate));
        } catch (ParseException ex) {
            Logger.getLogger(FlightDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                String req="update flight set arrivaldate=? where idflight=?";

          try {
              pst=connection.prepareStatement(req);
              pst.setDate(1,sqlDate );
              pst.setInt(2, F.getFlightId());
              pst.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(FlightDAO.class.getName()).log(Level.SEVERE, null, ex);
          } 
    }

    @Override
    public void updateDepartureDate(Flight F, Date DepartureDate) {
          
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                java.util.Date date = null;
        try {
            date = sdf.parse(sdf.format(DepartureDate));
        } catch (ParseException ex) {
            Logger.getLogger(FlightDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                String req="update flight set departuredate=? where idflight=?";

          try {
              pst=connection.prepareStatement(req);
              pst.setDate(1,sqlDate );
              pst.setInt(2, F.getFlightId());
              pst.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(FlightDAO.class.getName()).log(Level.SEVERE, null, ex);
          } 
    }

    @Override
    public void removeById(int id) {
        
                String req="delete from flight where idflight=?";
                try
                {
                    pst=connection.prepareCall(req);
                    pst.setInt(1,id);
                    pst.executeUpdate();
                                               
                }
                catch(SQLException E)
                {
                    Logger.getLogger(FlightDAO.class.getName()).log(Level.SEVERE, null, E);
                }    }

    @Override
    public Flight findById(int id) {
          Flight F=null;
            try {
                
              ste=connection.createStatement();
              
              String req ="select * from flight where idflight="+id;

              ResultSet resultat =ste.executeQuery(req);
              resultat.next();
              F=new Flight();
                  F.setFlight_id(resultat.getInt(1));
                  F.setArrivalDate(resultat.getDate(2));
                  F.setDepartureDate(resultat.getDate(3));
                  F.setPrice(resultat.getFloat(4));
                                   
               }
            catch (SQLException ex) {
             // Logger.getLogger(VoyageDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(" Flight inexistant");
          }
       
      return F ;
            }

    @Override
    public List<Flight> findAll() {
    List<Flight> listFlight=new ArrayList<>();
              Flight F;
              try {
              String req ="select* from flight";
              pst=connection.prepareStatement(req);
              ResultSet resultat =pst.executeQuery();
              while(resultat.next())
              {
                  F=new Flight();
                  F.setFlight_id(resultat.getInt(1));
                  F.setArrivalDate(resultat.getDate(2));
                  F.setDepartureDate(resultat.getDate(3));
                  F.setPrice(resultat.getFloat(4));
                  
                 
                  
                  listFlight.add(F);
              } } catch (SQLException ex) {
              Logger.getLogger(FlightDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
        
      return listFlight  ;    }

   
    
    
}
