/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyConnection;

/**
 *
 * @author khale
 */
public class SUser {
    
    Connection cnx;
     public SUser() {
         cnx = MyConnection.getInstance().getCnx();
    }
     
    //public  ObservableList<User> l = FXCollections.observableArrayList();
     
    public ObservableList<User> find() {
    //ArrayList l=new ArrayList(); 
    ObservableList<User> l = FXCollections.observableArrayList();
        
        try {
       String req="select nom,prenom,mail,numTel,domaine from user";
                PreparedStatement smt = cnx.prepareStatement(req);
                
                ResultSet rs= smt.executeQuery(req);
                while(rs.next()){
                   User u=new User(rs.getString("nom"),rs.getString("prenom"),rs.getString("mail"),rs.getInt("numTel"),
                   rs.getString("domaine"));
                   l.add(u);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }

        return l;
    }
     
    
}
