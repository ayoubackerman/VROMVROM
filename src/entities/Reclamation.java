/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Enumeration;




/**
 *
 * @author medal
 */
public class Reclamation {

 
    private int Id_Rec;
    private int Id_user;
    private int Id_entreprise;
    private String Type_rec;
    private String Description;
    private String Titre_Rep;

    public Reclamation(String Type_rec, String Description, String Titre_Rep) {
        this.Type_rec = Type_rec;
        this.Description = Description;
        this.Titre_Rep = Titre_Rep;
    }

      

   public Reclamation(int Id_Rec, int Id_user, int Id_entreprise, String Type_rec, String Description, String Titre_Rep) {
       
        this.Id_Rec = Id_Rec;
        this.Id_user = Id_user;
        this.Id_entreprise = Id_entreprise;
        this.Type_rec = Type_rec;
        this.Description = Description;
        this.Titre_Rep = Titre_Rep;
        
    }
      public Reclamation( int Id_user, int Id_entreprise, String Type_rec, String Description, String Titre_Rep) {
       

        this.Id_user = Id_user;
        this.Id_entreprise = Id_entreprise;
        this.Type_rec = Type_rec;
        this.Description = Description;
        this.Titre_Rep = Titre_Rep;
        
    }

    

    public Reclamation() {
        
    }

    public Reclamation(int parseInt, String text, String text0, String text1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
 

   

    public void setId_Rec(int Id_Rec) {
        this.Id_Rec = Id_Rec;
    }

    public void setId_user(int Id_user) {
        this.Id_user = Id_user;
    }

    public void setId_entreprise(int Id_entreprise) {
        this.Id_entreprise = Id_entreprise;
    }

    public void setType_rece(String Type_rec) {
        this.Type_rec = Type_rec;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    public void setTitre_Rep(String Titre_Rep) {
        this.Titre_Rep = Titre_Rep;
    }

    

    

    //====================================================
    
    public int getId_Rec() {
        return Id_Rec;
    }

    public int getId_user() {
        return Id_user;
    }

    public int getId_entreprise() {
        return Id_entreprise;
    }

    public String getType_rec() {
        return Type_rec;
    }

    public String getDescription() {
        return Description;
    }
     public String getTitre_Rep() {
        return Titre_Rep;
    }

    

    
       @Override
    public String toString() {
        return "reclamation{" + "Id_Rec=" + Id_Rec + ", Id_user=" + Id_user + ", Id_entreprise=" + Id_entreprise + ", Type_rec=" + Type_rec + ", Description=" + Description +", Titre_Rep=" + Titre_Rep + '}';
    }


    
}
