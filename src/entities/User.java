/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author khale
 */
public class User {
    
    //private int idUser;
    private String nom;
    private String prenom;
    private String mail;
    private int numTel;
    private String domaine;

    public User(String nom, String prenom, String mail, int numTel, String domaine) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.numTel = numTel;
        this.domaine = domaine;
    }

    public User() {
    }
    

    /*public int getIdUser() {
    return idUser;
    }
    
    public void setIdUser(int idUser) {
    this.idUser = idUser;
    }*/

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getNumTel() {
        return numTel;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    @Override
    public String toString() {
        return "User{" + "nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", numTel=" + numTel + ", domaine=" + domaine + '}';
    }
    
    
}
