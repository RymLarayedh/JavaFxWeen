package utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rymlarayedh
 */
public class DataSource {
    private Connection connection;
    private String url;
    private String login;
    private String mdp;
    private Properties properties;
    private static DataSource instance;
        
    private DataSource(){
        try {
            properties = new Properties();
            properties.load(new FileInputStream(new File("configuration.properties")));
            url=properties.getProperty("url");
            login=properties.getProperty("login");
            mdp=properties.getProperty("password");
            connection=DriverManager.getConnection(url,login,mdp);
        } catch (IOException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        return connection;
    }
    
    public static DataSource getInstance(){
        if(instance==null)
            instance=new DataSource();
        return instance;
    }
}
