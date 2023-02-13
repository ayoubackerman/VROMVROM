/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Reclamation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import utils.MyConnection;

/**
 *
 * @author medal
 */
public class reclamationcrud implements IService<Reclamation> {

    public static Object getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    



    private Connection conn;
    private Statement ste;
    private PreparedStatement pste;

    public reclamationcrud() {
        conn = MyConnection.getInstance().getCnx();
    }
 
   
    private int Id_Rec;
    private int Id_user;
    private int Id_entreprise;
    private String Type_rec;
    private String Description;
    private String Titre_Rep; 
         
   
    @Override
    public void ajouter(Reclamation u) {
         String req = "INSERT INTO `reclamation` (`Type_rec`,`Description`,`Titre_Rep`) VALUE (?,?,?)";
        try {
            pste = conn.prepareStatement(req);
            //pste.setInt(1,u.getId_user());
            //pste.setInt(2,u.getId_entreprise());
            pste.setString(1,u.getType_rec());
            pste.setString(2,u.getDescription());
            pste.setString(3,u.getTitre_Rep());
           
            pste.executeUpdate();
            System.out.println("reclamation créée");
        } catch (SQLException ex) {
            Logger.getLogger(reclamationcrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    public void modifier( Reclamation u)    {
     
 
        String req = "UPDATE reclamation SET "
                +"Type_rec=?,Description=?,Titre_Rep=?"
                + "WHERE Id_Rec =?";
    
        try {
           
            pste = conn.prepareStatement(req);
            //pste.setInt(1, u.getId_user());
            //pste.setInt(2, u.getId_entreprise());
            pste.setString(1,u.getType_rec());
            pste.setString(2, u.getDescription());
             pste.setString(3, u.getTitre_Rep());
             pste.setInt(4, u.getId_Rec());
             
            pste.executeUpdate();
            System.out.println("reclamation modifier");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    @Override
    public void supprimer(int Id_Rec )  {
      String delete = "DELETE FROM reclamation  where Id_Rec = ?";
        try {
            pste = conn.prepareStatement(delete);
            pste.setInt(1,Id_Rec);
            pste.executeUpdate();
       
        } catch (SQLException ex) {
                  
            Logger.getLogger(reclamationcrud.class.getName()).log(Level.SEVERE, null, ex);        
       
        }
    
    }

    @Override
    public List<Reclamation> afficher() {
        List<Reclamation> reclamation;
        reclamation = new ArrayList<>();
        String req = "SELECT * FROM `reclamation`";
        
        try {

            ste = conn.createStatement();
            ResultSet rs = ste.executeQuery(req);
            
            while(rs.next()){
                Reclamation u = new Reclamation();
                u.setId_Rec(rs.getInt(1));
                
                u.setId_user (rs.getInt(2));
                u.setId_entreprise (rs.getInt(3));      
                u.setType_rece(rs.getString(4));
                 u.setDescription(rs.getString(5));
                u.setTitre_Rep( rs.getString(6));
              
              
                 reclamation.add(u) ;                                        
                                                   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(reclamationcrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return reclamation;
    }

    
  

            
         

 

    
    
  

  

  
}
