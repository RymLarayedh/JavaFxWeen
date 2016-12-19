/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Entities.Report;
import Entities.User;
import Entities.TripProgram;
import Interfaces.IReport;
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
 * @author rymlarayedh
 */
public class ReportDAO implements IReport{
    private Connection connection; 
    private PreparedStatement pst;
    //initialiser la connexion
    public ReportDAO(){
    connection=DataSource.getInstance().getConnection();  
}
    /*
     @Override
    public void addReportUser(User u1,User u2) {
        String req="insert into report (reportid,0,reporteduserid,userid) values(?,?,?,?)";
        try {
            pst=connection.prepareStatement(req);
            
            pst.setInt(1,u1.getUserId());
            pst.setInt(2,u2.getUserId());
            
            pst.executeUpdate();
            System.out.println("Report user done");
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     @Override
    public void addReportTrip(User u,TripProgram p) {
        String req="insert into report (reportid,tripid,0,userid) values(?,?,?,?)";
        try {
            pst=connection.prepareStatement(req);
            
            pst.setInt(1,p.getIdTripProgram());
            pst.setInt(2,u.getUserId());
            
            pst.executeUpdate();
            System.out.println("Report trip done");
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    @Override
    public void removeReport(int id){
        User u = new User();
        String req = "delete from report where reportid = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(req);
            pst.setInt(1,id);
            pst.executeUpdate();
            System.out.println("Report Deleted");
        } catch (SQLException ex) {
            System.out.println("error while deleting " + ex.getMessage());
        }
    }

    @Override
    public List<Report> findAllReport(){
            List<Report>listeReport=new ArrayList<>();
            Report u;
        try {
            String req="select * from report";
            pst=connection.prepareStatement(req);
            ResultSet resultat = pst.executeQuery();
            while(resultat.next()){
                u= new Report();
                u.setReportid(resultat.getInt(1));
                u.setTripid(resultat.getInt(2));
                u.setReporteduserid(resultat.getInt(3));
                u.setUserid(resultat.getInt(4));    
                listeReport.add(u);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      return listeReport;  
    }

    @Override
   public     Report findByReportByIdUser(int id) {
        Report u = new Report();
        String req = "select * from report where userid = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(req);
            pst.setInt(1,id);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                u.setReportid(resultat.getInt(1));
                u.setTripid(resultat.getInt(2));
                u.setReporteduserid(resultat.getInt(3));
                u.setUserid(resultat.getInt(4));
                
            }
            return u;

        } catch (SQLException ex) {
            System.out.println("error while searching for Report " + ex.getMessage());
            return null;
        }
    }*/
}