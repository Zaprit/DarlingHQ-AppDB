/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.darlinghq.appdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author henry
 */
public class DBConnector {
   public static void insertEntry(String appName, ArrayList<String> contributors, String notes, boolean installs, boolean runs, String version, String appDescription, String darlingCommit, String hostSystem){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/appdb?ApplicationName=AppDB", ServerMain.config.getProperty("db_user"), ServerMain.config.getProperty("db_pass"))){
            String sql = "INSERT INTO appdb (app_name, contributors, notes, installs, runs, version, app_description, darling_commit, host_system) VALUES(?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, appName);
            ps.setArray(2, connection.createArrayOf("text", contributors.toArray()));
            ps.setString(3, notes);
            ps.setBoolean(4, installs);
            ps.setBoolean(5, runs);
            ps.setString(6, version);
            ps.setString(7, appDescription);
            ps.setString(8, darlingCommit);
            ps.setString(9, hostSystem);
            
            ps.execute(sql);
            
        }catch(SQLException e){
            throw new RuntimeException("Error Initialising Database Connection");
        }
   } 
}
