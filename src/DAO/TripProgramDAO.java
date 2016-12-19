/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Flight;
import Entities.TripProgram;
import Interfaces.IDAOTripProgram;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author Ines
 */
public class TripProgramDAO implements IDAOTripProgram<TripProgram> {
    private Connection connection ;
    private PreparedStatement pst;// la requete
    private Statement ste ;

    public TripProgramDAO() {
   
            connection = DataSource.getInstance().getConnection(); }
/*
    @Override
    public void add(TripProgram T) {
     String req="insert into tripprogram  (nbrpassenger,iddestination,description,price,rating,idflight) values (?,?,?,?,?,?)"; 
                 try {
              pst=connection.prepareStatement(req);
              pst.setInt(1, T.getNbrPassenger());
             // pst.setInt(2, T.getDestination().getIdDestination());
              pst.setInt(2, 1);

              pst.setString(3,T.getDescription());
              pst.setFloat(4, T.getPrice());
              pst.setFloat(5, T.getRating());
             // pst.setInt(6, T.getFlight().getFlightId());
              pst.setInt(6, 12);
              
              pst.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(TripProgramDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @Override
    public void updatePrice(TripProgram T, float price) {
                 String req="update tripprogram set price=? where idtripprogram=?";

          try {
              pst=connection.prepareStatement(req);
              pst.setFloat(1, price);
              pst.setInt(2, T.getIdTripProgram());
              pst.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(TripProgramDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
        
    }

    @Override
    public void updateNbrPassenger(TripProgram t, int nbr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateDescription(TripProgram t, String description) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    @Override
    public void updateFlight(TripProgram t, Flight flight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeById(int id) {
        try {
            String req="delete from tripprogram where idtripprogram=?";
            
            pst=connection.prepareCall(req);
            pst.setInt(1,id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TripProgramDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                                               
               
    }

    @Override
    public TripProgram findById(int id) {
          TripProgram T=null;
            try {
           //  DestinationDAO dao = new DestinationDAO();
              FlightDAO Fdao = new FlightDAO();
              ste=connection.createStatement();
              
              String req ="select * from tripprogram where idtripprogram="+id;

              ResultSet resultat =ste.executeQuery(req);
              resultat.next();
              T=new TripProgram();
                  T.setIdTripProgram(resultat.getInt(1));
                  T.setNbrPassenger(resultat.getInt(2));
                 // T.setDestination(dao.findById(resultat.getInt(3)));
                  T.setDescription(resultat.getString(4));
                  T.setPrice(resultat.getFloat(5));
                  T.setRating(resultat.getFloat(6));
                  T.setFlight(Fdao.findById(resultat.getInt(7)));
               }
            catch (SQLException ex) {
             // Logger.getLogger(VoyageDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(" Trip inexistant");
          }
       
      return T;
    }

    @Override
    public List<TripProgram> findAll() {
        List<TripProgram> listTrip=new ArrayList<>();
              TripProgram T;
            //DestinationDAO D;
              FlightDAO F;
              try {
              String req ="select* from tripprogram";
              pst=connection.prepareStatement(req);
              ResultSet resultat =pst.executeQuery();
              while(resultat.next())
              {
                  T = new TripProgram();
               // D=new DestinationDAO ();
                  F= new FlightDAO ();
                  T.setIdTripProgram(resultat.getInt(1));
                  T.setNbrPassenger(resultat.getInt(2));
                  //T.setDestination(D.findById(resultat.getInt(3)));
                 // T.setDestination(D);

                  T.setDescription(resultat.getString(4));
                  T.setPrice(resultat.getFloat(5));
                  T.setFlight(F.findById(resultat.getInt(6)));
                //  T.setFlight(F);

                
                  
                 
                  
                  listTrip.add(T);
              } } catch (SQLException ex) {
              Logger.getLogger(TripProgramDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
        
      return listTrip  ;    }

   

*/
    
}
