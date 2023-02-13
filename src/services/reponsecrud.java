/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Reclamation;
import entities.reponse;
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
public class reponsecrud implements Iservicereponse<reponse> {

    public static Object getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    



    private Connection conn;
    private Statement ste;
    private PreparedStatement pste;

    public reponsecrud() {
        conn = MyConnection.getInstance().getCnx();
    }
 
   
    private int Id_Rec;
    private int Id_entreprise;
     private int Id_user;
    private String titre;
    private String Description;
    
         
   
    @Override
    public void ajouter(reponse u) {
         String req = "INSERT INTO `reponse_rec` (`titre`,`description`) VALUE (?,?)";
        try {
            pste = conn.prepareStatement(req);
            //pste.setInt(1,u.getId_Rec());
            //pste.setInt(2,u.getId_entreprise());
            //pste.setInt(3,u.getId_user());
            pste.setString(1,u.getTitre());
            pste.setString(2,u.getDescription());
           
            pste.executeUpdate();
            System.out.println("reponse créée");
        } catch (SQLException ex) {
            Logger.getLogger(reponsecrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    public void modifier( reponse u)    {
     
 
        String req = "UPDATE `reponse_rec`  SET "
                +"titre=?,description=?"
                + "WHERE Id_Rec =?";
    
        try {
           
           
            pste = conn.prepareStatement(req);
            pste.setInt(1, u.getId_Rec());
            //pste.setInt(1, u.getId_entreprise());
            //pste.setInt(2,u.getId_user());
            pste.setString(2, u.getTitre());
             pste.setString(3, u.getDescription());
            
             
            pste.executeUpdate();
            System.out.println(" modifier");
        } catch (SQLException ex) {
            System.err.println("fdsgfdgfds");
        }
    }
    @Override
    public void supprimer(int Id_Rec )  {
      String delete = "DELETE FROM reponse_rec  where Id_Rec = ?";
        try {
            pste = conn.prepareStatement(delete);
            pste.setInt(1,Id_Rec);
            pste.executeUpdate();
       
        } catch (SQLException ex) {
                  
            Logger.getLogger(reponsecrud.class.getName()).log(Level.SEVERE, null, ex);        
       
        }
    
    }

    @Override
    public List<reponse> afficher() {
        //List<reponse> reponse;
        
       ArrayList reponse = new ArrayList<>();
        String req = "SELECT * FROM `reponse_rec`";
        
        try {

            ste = conn.createStatement();
            ResultSet rs = ste.executeQuery(req);
            
            while(rs.next()){
               reponse u = new reponse();
                u.setId_Rec(rs.getInt(1));
                
                u.setId_user (rs.getInt(2));
                u.setId_entreprise (rs.getInt(3));      
                u.setTitre(rs.getString(4));
                 u.setDescription(rs.getString(5));
             
              
              
                 reponse.add(u) ;                                        
                                                   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(reponsecrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return reponse;
    }

    
  

            
         

 

    
    
  

  

  
}
