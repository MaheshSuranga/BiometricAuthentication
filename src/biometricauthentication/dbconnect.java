/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometricauthentication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mahesh
 */
public class dbconnect {
    public static final String url = "jdbc:sqlite::BiometricAuthentication.db";
    public static Connection conn = null;
    
    public static void connect() throws ClassNotFoundException{
        
         try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
            System.out.println("Database connected!");
            conn.createStatement().execute("create table if not exists user_credential(name varchar(32), password varchar(32), time varchar(120), pressdiff varchar(120), releasediff varchar(120), primary key(name))");
           
        } catch (SQLException ex) {
            //Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Cannot connect the database!");
            System.out.println(ex);
        }
            
    }

}
