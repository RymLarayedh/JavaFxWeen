/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Gui.*;
import Entities.User;
import Entities.TripProgram;
import Interfaces.IUser;
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
public class UserDAO implements IUser<User>{
    private Connection connection; 
    private PreparedStatement pst;
    //initialiser la connexion
    public UserDAO(){
    connection=DataSource.getInstance().getConnection();  
}
    //**************************************************************************
    //************************* UTILISATEUR  ***********************************
    //**************************************************************************
     @Override
    public void addUser(User u) {
        String req="insert into user (name,lastname,idaddress,email,phonenumber,login,password,status,isConnected) values(?,?,?,?,?,?,?,0,0)";
        try {
            pst=connection.prepareStatement(req);
            
            pst.setString(1,u.getName());
            pst.setString(2,u.getLastname());
            pst.setInt(3,u.getIdaddress());
            pst.setString(4,u.getEmail());
            pst.setLong(5,u.getPhonenumber());
            pst.setString(6,u.getLogin());
            pst.setString(7,u.getPassword());
            //pst.setString(9,u.getIsAdmin());
            pst.executeUpdate();
            System.out.println("utilisateur ajouté");
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
   //**************************  UPDATE  *******************************************
    @Override
    public void updateName(int idutilisateur,String nom1) {
        String req ="update user set name=? where UserId=?";
           try {         
            pst = connection.prepareStatement(req);
            pst.setInt(2,idutilisateur);
            pst.setString(1,nom1);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
     public void updateLastname(int idutilisateur,String prenom1) {
            String req="update user set lastname=? where UserId=?";
        try {
            pst=connection.prepareStatement(req);
            pst.setInt(2,idutilisateur);
            pst.setString(1,prenom1);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
      public void updateIdaddress(int idutilisateur,int adresse1) {
            String req="update user set idaddress=? where UserId=?";
        try {
            pst=connection.prepareStatement(req);
            pst.setInt(2,idutilisateur);
            pst.setInt(1,adresse1);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public void updateEmail(int idutilisateur,String email1) {
            String req="update user set email=? where UserId=?";
        try {
            pst=connection.prepareStatement(req);
            pst.setInt(2,idutilisateur);
            pst.setString(1,email1);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public void updatePhonenumber(int idutilisateur,int tel1) {
            String req="update user set phonenumber=? where UserId=?";
        try {
            pst=connection.prepareStatement(req);
            pst.setInt(2,idutilisateur);
            pst.setLong(1,tel1);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
       public void updateLogin(int idutilisateur,String identifiant1) {
            String req="update user set login=? where UserId=?";
        try {
            pst=connection.prepareStatement(req);
            pst.setInt(2,idutilisateur);
            pst.setString(1,identifiant1);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public void updatePassword(int idutilisateur,String mdp1) {
            String req="update user set password=? where UserId=?";
        try {
            pst=connection.prepareStatement(req);
            pst.setInt(2,idutilisateur);
            pst.setString(1,mdp1);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*@Override
    public void update(User u,int idutilisateur) {
            String req="update utilisateur set  idutilisateur=?,nom=?,prenom=?,adresse=?,mail=?,tel=?,identifiant=?,mdp=?";
        try {
            pst=connection.prepareStatement(req);
            pst.setInt(1,u.getIdutilisateur());
            pst.setString(2,u.getNom());
            pst.setString(3,u.getPrenom());
            pst.setString(4,u.getAdresse());
            pst.setString(5,u.getMail());
            pst.setLong(6,u.getTel());
            pst.setString(7,u.getIdentifiant());
            pst.setString(8,u.getMdp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

    @Override
    public void removeUserById(int id){
        User u = new User();
        String req = "delete from user where UserId = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(req);
            pst.setInt(1,id);
            pst.executeUpdate();
            System.out.println("utilisateur supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    @Override
    public List<User> findAllUser() {
            List<User>listeUtilisateur=new ArrayList<>();
            User u;
        try {
            String req="select * from user";
            pst=connection.prepareStatement(req);
            ResultSet resultat = pst.executeQuery();
            while(resultat.next()){
                u= new User();
                u.setUserId(resultat.getInt(1));
                u.setName(resultat.getString(2));
                u.setLastname(resultat.getString(3));
                u.setIdaddress(resultat.getInt(4));
                u.setEmail(resultat.getString(5));
                u.setPhonenumber(resultat.getInt(6));
                u.setLogin(resultat.getString(7));
                u.setPassword(resultat.getString(8));
                listeUtilisateur.add(u);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      return listeUtilisateur;  
    }
    
    
    
    @Override
    public List<User> findUserConnected() {
            List<User>listeUtilisateur=new ArrayList<>();
            User u;
        try {
            String req="select * from user where isConnected = 1";
            pst=connection.prepareStatement(req);
            ResultSet resultat = pst.executeQuery();
            while(resultat.next()){
                u= new User();
                u.setUserId(resultat.getInt(1));
                u.setName(resultat.getString(2));
                u.setLastname(resultat.getString(3));
                u.setIdaddress(resultat.getInt(4));
                u.setEmail(resultat.getString(5));
                u.setPhonenumber(resultat.getInt(6));
                u.setLogin(resultat.getString(7));
                u.setPassword(resultat.getString(8));
                listeUtilisateur.add(u);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      return listeUtilisateur;  
    }

    @Override
   public User findByUserId(int id) {
        User u = new User();
        String req = "select * from user where UserId = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(req);
            pst.setInt(1,id);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                u.setUserId(resultat.getInt(1));
                u.setLastname(resultat.getString(2));
                u.setName(resultat.getString(3));
                u.setIdaddress(resultat.getInt(4));
                u.setEmail(resultat.getString(5));
                u.setPhonenumber(resultat.getInt(6));
                u.setLogin(resultat.getString(7));
                u.setPassword(resultat.getString(8));
            }
            return u;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche de l'utilisateur " + ex.getMessage());
            return null;
        }
    }
   
   
   
   @Override
   public User findWeener(String login,String mdp) {
        User u = new User();
        String req = "select * from user where login = ? and password = ? and status = 2";
        try {
            PreparedStatement pst = connection.prepareStatement(req);
            pst.setString(1,login);
            pst.setString(2,mdp);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                u.setUserId(resultat.getInt(1));
                u.setLastname(resultat.getString(2));
                u.setName(resultat.getString(3));
                u.setIdaddress(resultat.getInt(4));
                u.setEmail(resultat.getString(5));
                u.setPhonenumber(resultat.getInt(6));
                u.setLogin(resultat.getString(7));
                u.setPassword(resultat.getString(8));
            }
            return u;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche de l'utilisateur " + ex.getMessage());
            return null;
        }
    }
   
   @Override
   public User findAdmin(String login,String mdp) {
        User u = new User();
        String req = "select * from user where login = ? and password = ? and status = 1";
        try {
            PreparedStatement pst = connection.prepareStatement(req);
            pst.setString(1,login);
            pst.setString(2,mdp);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                u.setUserId(resultat.getInt(1));
                u.setLastname(resultat.getString(2));
                u.setName(resultat.getString(3));
                u.setIdaddress(resultat.getInt(4));
                u.setEmail(resultat.getString(5));
                u.setPhonenumber(resultat.getInt(6));
                u.setLogin(resultat.getString(7));
                u.setPassword(resultat.getString(8));
            }
            return u;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche de l'utilisateur " + ex.getMessage());
            return null;
        }
    }
   //**************************************************************************
    //************************* ADMINISTRATEUR  ***********************************
    //**************************************************************************
    @Override
   public void isAdmin(int id) {
        try {
            String requete="update user set status=1 WHERE UserId="+id;
            
            Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(requete);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
   
    @Override
   public void isWeener(int id) {
        try {
            String requete="update user set status=2 WHERE UserId="+id;
            
            Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(requete);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
   
   @Override
   public void isBlocked(int id) {
        try {
            String requete="update user set status=9 WHERE UserId="+id;
            
            Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(requete);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
   
   
 
   
   /*@Override
    public void addVoyage(Tripprogram v) {
        String req="insert into voyage (idVoyage,description,nbrVoyageur,dest,moyenTransport,Note,dateDepart,dateArriver,commentaire,Voyageurlike,Voyageurinscrit) values(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pst=connection.prepareStatement(req);    
            pst.setString(1,v.getIdVoyage());
            pst.setString(2,v.getDescription());
            pst.setString(3,v.getNbrVoyageur());
            pst.setString(4,v.getDest());
            pst.setLong(5,v.getMoyenTransport());
            pst.setString(6,v.getNote());
            pst.setString(7,v.getDateDepar());
            pst.setString(8,v.getDateArriver());
            pst.setString(9,v.getCommentaire());
            pst.setString(10,v.getVoyageurLike());
            pst.setInt(11,v.getVoyageurInscrit());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void removeVoyageById(int id){
        Tripprogram v = new Tripprogram();
        String req = "delete from voyage where idvoyage = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(req);
            pst.setInt(1, v.getIdvoyage());
            pst.executeUpdate();
            System.out.println("voyage supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression du voyage " + ex.getMessage());
        }
    }
    
    @Override
    public List<Voyage> findAllVoyage() {
            List<Voyage>listeVoyage=new ArrayList<>();
            Tripprogram v;
        try {
            String req="select * from utilisateur";
            pst=connection.prepareStatement(req);
            ResultSet resultat = pst.executeQuery();
            while(resultat.next()){
                v= new Tripprogram();
                v.setIdutilisateur(resultat.getInt(1));
                v.setNom(resultat.getString(2));
                v.setPrenom(resultat.getString(3));
                listeVoyage.add(v);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      return listeVoyage;  
    }

    @Override
   public User findByIdVoyage(int id) {
        Tripprogram v = new Tripprogram();
        String req = "select * from voyage where id = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(req);
            pst.setInt(1, id);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                v.setIdVoyage(resultat.getInt(1));
                v.setDescription(resultat.getString(2));
                v.setNbrVoyageur(resultat.getString(3));
                v.setDest(resultat.getString(4));
                v.setMoyenTransport(resultat.getString(5));
                v.setNote(resultat.getLong(6));
                v.setDateDepart(resultat.getString(7));
                v.setDateArriver(resultat.getString(8));
                v.setCommentair(resultat.getString(9));
                v.setVoyageurLike(resultat.getString(10));
                v.setVoyageurInscrit(resultat.getString(11));
            }
            return v;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche de l'utilisateur " + ex.getMessage());
            return null;
        }
    }*/

   
    public void UpdateUser(int id,String nom,String prenom,int idadresse,String email,int tel,String login,String mdp) {
        String req="update user set name=?,lastname=?,idaddress=?,email=?,phonenumber=?,login=?,password=? where UserId=?";
        try {
            pst=connection.prepareStatement(req);
            pst.setString(1,nom);
            pst.setString(2,prenom);
            pst.setInt(3,idadresse);
            pst.setString(4,email);
            pst.setInt(5,tel);
            pst.setString(6,login);
            pst.setString(7,mdp);
            pst.setInt(8,id);
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
   /* public User findByUserStatus(int status) {
        User u = new User();
        String req = "select * from user where status = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(req);
            pst.setInt(1,status);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                u.setUserId(resultat.getInt(1));
                u.setLastname(resultat.getString(2));
                u.setName(resultat.getString(3));
                u.setAddress(resultat.getString(4));
                u.setEmail(resultat.getString(5));
                u.setPhonenumber(resultat.getInt(6));
                u.setLogin(resultat.getString(7));
                u.setPassword(resultat.getString(8));
            }
            return u;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche de l'utilisateur " + ex.getMessage());
            return null;
        }*/
    public List<User> findUserByStatus(int status) {
            List<User>listeUtilisateur=new ArrayList<>();
            User u;
        try {
            String req="select * from user where status=?";
            pst=connection.prepareStatement(req);
            pst.setInt(1,status);
            ResultSet resultat = pst.executeQuery();
            while(resultat.next()){
                u= new User();
                u.setUserId(resultat.getInt(1));
                u.setName(resultat.getString(2));
                u.setLastname(resultat.getString(3));
                u.setIdaddress(resultat.getInt(4));
                u.setEmail(resultat.getString(5));
                u.setPhonenumber(resultat.getInt(6));
                u.setLogin(resultat.getString(7));
                u.setPassword(resultat.getString(8));
                listeUtilisateur.add(u);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      return listeUtilisateur;  
    }
    
     @Override
   public void connect(int id) {
        try {
            String requete="update user set isConnected=1 WHERE UserId="+id;
            
            Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(requete);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
   
    @Override
   public void deconnect(int id) {
        try {
            String requete="update user set isConnected=0 WHERE UserId="+id;
            
            Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(requete);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
    
    }

    
    
    

    

