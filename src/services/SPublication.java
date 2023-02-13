/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Publication;
//import entites.Users;
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
import utils.MyConnection;

/**
 *
 * @author khale
 */
public class SPublication implements IServices<Publication>{

    Connection cnx;
     public SPublication() {
         cnx = MyConnection.getInstance().getCnx();
    }
     
     //UsersSession us =new UsersSession();
     
     //Users
     
     /*@Override
     public void ajouter(Publication p) {
     try {
     
     String req="insert into publication(contenue,imgPub) values(?,?)";
     PreparedStatement smt = cnx.prepareStatement(req);
     smt.setString(1, p.getContenue());
     smt.setBlob(2, p.getImagePub());
     smt.executeUpdate();
     System.out.println("Ajout de publication avec succées");
     } catch (SQLException ex) {
     System.out.println(ex.getMessage());
     
     }
     }*/
     //@Override
    public void ajouter(Publication p) {
         try {
          
           String req="insert into publication(Id,contenue,imgPub) values(?,?,?)";
                PreparedStatement smt = cnx.prepareStatement(req);
                smt.setInt(1, UsersSession.getId());
                smt.setString(2, p.getContenue());
                smt.setBlob(3, p.getImagePub());
                smt.executeUpdate();
                System.out.println("Ajout de publication avec succées");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
           
       }
    }
    //refaire ajouter(Publication p, int idUser)   pour identifier les pubs par ses responsables

    @Override
    public void modifier(Publication p) {
    try {
       String req="update publication set contenue=? where idPub=?";
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
    public void supprimer(Publication p) {
    try {
       String req="delete from publication where idPub=?";
                PreparedStatement smt = cnx.prepareStatement(req);
                smt.setInt(1, p.getId());
                smt.executeUpdate();
                System.out.println("Suppression de publication avec succées");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
    }

    @Override
    public List<Publication> find() {
    ArrayList l=new ArrayList(); 
        
        try {
       String req="select * from publication";
                PreparedStatement smt = cnx.prepareStatement(req);
                
                ResultSet rs= smt.executeQuery(req);
                
                while(rs.next()){
                   Publication p=new Publication(rs.getInt("idPub"),rs.getString("contenue"),rs.getBlob("imgPub").getBinaryStream(),rs.getString("dateCreation"));
                   l.add(p);
                   
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }

        return l;
    }
    
    //rec2.next();
      //     nb=rec2.getDouble(1);
    
    public int nombreCommentaires(Publication p){
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
    
    public List<Publication> find(int id) {
    ArrayList l=new ArrayList(); 
        
        try {
       String req="select * from publication where idPub="+id;
                PreparedStatement smt = cnx.prepareStatement(req);
                
                ResultSet rs= smt.executeQuery(req);
                while(rs.next()){
                   Publication p=new Publication(rs.getInt("idPub"),rs.getInt("Id"),rs.getString("contenue"),rs.getBlob("imgPub").getBinaryStream(),rs.getString("dateCreation"));
                   l.add(p);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }

        return l;
    }
    
    
    //recuperer le nom de publisher 
    
    public String findPublisher(Publication p) {
    String nomPublisher=""; 
        
        try {
       String req="select name from users u,publication p where u.Id = p.Id and p.idPub="+p.getId();
                Statement smt = cnx.createStatement();
                
                ResultSet rs= smt.executeQuery(req);
               rs.next();
                    nomPublisher = rs.getString("name");
                
                nomPublisher = rs.getString("name");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }
        System.out.println(nomPublisher);
        return nomPublisher;
    }
    
    public int findPublisherPub(Publication p) {
    int idPublisher=0; 
        
        try {
       String req="select Id from publication p,users u where p.Id=u.Id and p.idPub="+p.getId();
                PreparedStatement smt = cnx.prepareStatement(req);
                
                ResultSet rs= smt.executeQuery(req);
                rs.next();
                idPublisher = rs.getInt("Id");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }

        return idPublisher;
    }

    
    
}
