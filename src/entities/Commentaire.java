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
public class Commentaire {
    private int id;
    private int id_utilisateurn;
    private int id_pub;
    private String contenue;
    private String created_at;

    

    public Commentaire() {
    }
    
    public Commentaire(int id_pub, String contenue) {
        this.id_pub = id_pub;
        this.contenue = contenue;
    }
    
    public Commentaire(int id_pub,int idu, String contenue) {
        this.id_pub = id_pub;
        this.id_utilisateurn=idu;
        this.contenue = contenue;
    }
    
    public Commentaire(int id, int id_utilisateurn, int id_pub, String contenue, String created_at) {
        this.id = id;
        this.id_utilisateurn = id_utilisateurn;
        this.id_pub = id_pub;
        this.contenue = contenue;
        this.created_at = created_at;
    }
    

    public Commentaire(int id) {
        this.id = id;
    }
    
    
    
    
    public Commentaire( String contenue,int idcom) {
        this.id = idcom;
        this.contenue = contenue;
    }
    

    public Commentaire(String contenue) {
        this.contenue = contenue;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenue() {
        return contenue;
    }

    public void setContenue(String contenue) {
        this.contenue = contenue;
    }
    
    public int getId_utilisateurn() {
        return id_utilisateurn;
    }

    public void setId_utilisateurn(int id_utilisateurn) {
        this.id_utilisateurn = id_utilisateurn;
    }

    public int getId_pub() {
        return id_pub;
    }

    public void setId_pub(int id_pub) {
        this.id_pub = id_pub;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    
    

    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", id_utilisateurn=" + id_utilisateurn + ", id_pub=" + id_pub + ", contenue=" + contenue + ", created_at=" + created_at + '}';
    }

    
    
}
