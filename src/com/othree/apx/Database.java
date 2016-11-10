package com.othree.apx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 *
 * @author root
 */
public class Database {

    Connection conn = null;
    PreparedStatement pt = null;
    ResultSet res = null;
    public Database() {

    }

    public void create(String where) {

        try {
            // db parameters
            String url = "jdbc:sqlite:" + where;
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Database Created at " + where);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void closeDB() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean createTable(String where,String query) {

        boolean done = false;
        try {
            // db parameters
            String url = "jdbc:sqlite:" + where;
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            pt = conn.prepareStatement(query);
            
            done = pt.execute();
            if(done){
            System.out.println("Operation Completed");
            
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    pt.close();
                    conn.close();
                    
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return done;
    }

  
}
