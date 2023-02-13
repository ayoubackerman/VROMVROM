/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.candidature;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.IServices;
import utils.MyConnection;
/**
 *
 * @author khale
 */
public class candidature_crud implements IServices<candidature>{
    Connection cnx;
     public candidature_crud() {
         cnx = MyConnection.getInstance().getCnx();
    }
     
    @Override
    public void ajouter(candidature c) {
         try {
          
           String req="insert into candidature(contenue,id_pub) values(?,?)";
                PreparedStatement smt = cnx.prepareStatement(req);
                smt.setString(1, c.getContenue());
                smt.setInt(2, c.getId_pub());
                smt.executeUpdate();
                System.out.println("Ajout de commentaire avec succées");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
           
       }
    }

    @Override
    public void modifier(candidature c) {
    try {
       String req="update candidature set contenue=? where id=?";
                PreparedStatement smt = cnx.prepareStatement(req);
                
                smt.setString(1, c.getContenue());
                smt.setInt(2, c.getId());
                smt.executeUpdate();
                System.out.println("Modification de commentaire avec succées");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
             }
    }

    @Override
    public void supprimer(candidature c) {
   try {
       String req="delete from candidature where id=?";
                PreparedStatement smt = cnx.prepareStatement(req);
                smt.setInt(1, c.getId());
                smt.executeUpdate();
                System.out.println("Suppression de commentaire avec succées");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
    }

    public List<candidature> find(int id_pub) {
    ArrayList l=new ArrayList(); 
        
        try {
       String req="select * from candidature where id_pub="+id_pub;
                Statement smt = cnx.createStatement();
              
                candidature c;
                ResultSet rs= smt.executeQuery(req);
                while(rs.next()){
                   c=new candidature(rs.getInt("id"),rs.getInt("id_utilisateur"),rs.getInt("id_pub"),rs.getString("contenue"),rs.getString("created_at"));
                   l.add(c);
                }
                System.out.println(l);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }

        return l;
    }

    @Override
    public List<candidature> find() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
