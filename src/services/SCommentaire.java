/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Commentaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyConnection;
/**
 *
 * @author khale
 */
public class SCommentaire implements IServices<Commentaire>{
    Connection cnx;
     public SCommentaire() {
         cnx = MyConnection.getInstance().getCnx();
    }
     
    @Override
    public void ajouter(Commentaire c) {
         try {
          
           String req="insert into commentaire(Id,contenue,idPub) values(?,?,?)";
                PreparedStatement smt = cnx.prepareStatement(req);
                smt.setInt(1, UsersSession.getId());
                smt.setString(2, c.getContenue());
                smt.setInt(3, c.getId_pub());
                smt.executeUpdate();
                System.out.println("Ajout de commentaire avec succées");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
           
       }
    }

    @Override
    public void modifier(Commentaire c) {
    try {
       String req="update commentaire set contenue=? where idCom=?";
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
    public void supprimer(Commentaire c) {
   try {
       String req="delete from commentaire where idCom=?";
                PreparedStatement smt = cnx.prepareStatement(req);
                smt.setInt(1, c.getId());
                smt.executeUpdate();
                System.out.println("Suppression de commentaire avec succées");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
    }

    public List<Commentaire> find(int id_pub) {
    ArrayList l=new ArrayList(); 
        
        try {
       String req="select * from commentaire where idPub="+id_pub;
                Statement smt = cnx.createStatement();
              
                Commentaire c;
                ResultSet rs= smt.executeQuery(req);
                while(rs.next()){
                   c=new Commentaire(rs.getInt("idCom"),rs.getInt("Id"),rs.getInt("idPub"),rs.getString("contenue"),rs.getString("dateCreation"));
                   l.add(c);
                }
                System.out.println(l);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }

        return l;
    }

    @Override
    public List<Commentaire> find() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
