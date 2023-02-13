/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.pub_offre;
import entities.User;
import java.util.List;
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
public class pub_offrecrud implements IServices<pub_offre>{

    Connection cnx;
     public pub_offrecrud() {
         cnx = MyConnection.getInstance().getCnx();
    }
     
    @Override
    public void ajouter(pub_offre p) {
         try {
          
           String req="insert into puboffre(contenue,imagePub) values(?,?)";
                PreparedStatement smt = cnx.prepareStatement(req);
                smt.setString(1, p.getContenue());
                smt.setBlob(2, p.getImagePub());
                smt.executeUpdate();
                System.out.println("Ajout de publication avec succées");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
           
       }
    }
    //refaire ajouter(Publication p, int idUser)   pour identifier les pubs par ses responsables

    @Override
    public void modifier(pub_offre p) {
    try {
       String req="update puboffre set contenue=? where idPub=?";
                PreparedStatement smt = cnx.prepareStatement(req);
                
                smt.setString(1, p.getContenue());
                smt.setInt(2, p.getId());
                smt.executeUpdate();
                System.out.println("Modification de publication avec succées");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
    }

    @Override
    public void supprimer(pub_offre p) {
    try {
       String req="delete from puboffre where id=?";
                PreparedStatement smt = cnx.prepareStatement(req);
                smt.setInt(1, p.getId());
                smt.executeUpdate();
                System.out.println("Suppression de publication avec succées");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
    }

    @Override
    public List<pub_offre> find() {
    ArrayList l=new ArrayList(); 
        
        try {
       String req="select * from puboffre";
                PreparedStatement smt = cnx.prepareStatement(req);
                
                ResultSet rs= smt.executeQuery(req);
                while(rs.next()){
                   pub_offre p=new pub_offre(rs.getInt("id"),rs.getString("contenue"),rs.getBlob("imagePub").getBinaryStream(),rs.getString("date"));
                   l.add(p);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }

        return l;
    }
    
    //rec2.next();
      //     nb=rec2.getDouble(1);
   /* 
    public int nombreCommentaires(pub_offre p){
        int nbrCommentaires =0;
        try {
            String req="select count(*) from commentaire where idPub="+p.getId();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            rs.next();
            nbrCommentaires = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return nbrCommentaires;
    }
    */
    public List<pub_offre> find(int ids) {
    ArrayList l=new ArrayList(); 
        
        try {
       String req="select * from puboffre where id="+ids;
                PreparedStatement smt = cnx.prepareStatement(req);
                
                ResultSet rs= smt.executeQuery(req);
                while(rs.next()){
                       pub_offre p=new pub_offre(rs.getInt("id"),rs.getString("contenue"),rs.getBlob("imagePub").getBinaryStream(),rs.getString("date"));
                   l.add(p);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }

        return l;
    }
    
    
    //recuperer le nom de publisher 
    
    public String findPublisher(pub_offre p) {
    String nomPublisher=""; 
        
        try {
       String req="select nom from pub-offre p,user u where id="+p.getId()+"and p.idUser=u.idUser ";
                PreparedStatement smt = cnx.prepareStatement(req);
                
                ResultSet rs= smt.executeQuery(req);
                nomPublisher = rs.getString("nom");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }

        return nomPublisher;
    }
}
