/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;




/**
 *
 * @author medal
 */
public class reponse {
    private int Id_Rec;
    private int Id_entreprise;
    private int Id_user;
    private String Titre;
    private String Description;
  

      

   public reponse(int Id_Rec, int Id_entreprise, int Id_user, String Titre, String Description) {
       
        this.Id_Rec = Id_Rec;
        this.Id_entreprise = Id_entreprise;
        this.Id_user = Id_user;
        this.Titre = Titre;
        this.Description = Description;
        
    }
      

    

    public reponse() {
        
    }

    public reponse(int parseInt, String text, String text0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public reponse(String text, String text0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
 

   

    public void setId_Rec(int Id_Rec) {
        this.Id_Rec = Id_Rec;
    }

   public void setId_entreprise(int Id_entreprise) {
        this.Id_entreprise = Id_entreprise;
    }

    
        public void setId_user(int Id_user) {
        this.Id_user = Id_user;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    
}
    

    

    //====================================================
    
    public int getId_Rec() {
        return Id_Rec;
    }

   public int getId_entreprise() {
        return Id_entreprise;
    }

   
 public int getId_user() {
        return Id_user;
    }

    public String getTitre() {
        return Titre;
    }

    public String getDescription() {
        return Description;
    }

    @Override
    public String toString() {
        return "reponse{" + "Titre=" + Titre + ", Description=" + Description + '}';
    }
     

    

    
       
    
}
