/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.InputStream;
import java.sql.Blob;

/**
 *
 * @author khale
 */
public class pub_offre {
    private int id;
    private String contenue;
    private InputStream imagePub;
    private String date;

    public pub_offre() {
    }

    public pub_offre(int id, String contenue) {
        this.id = id;
        this.contenue = contenue;
    }

    public pub_offre(String contenue) {
        this.contenue = contenue;
    }

    public pub_offre(String contenue, InputStream imagePub) {
        this.contenue = contenue;
        this.imagePub = imagePub;
    }
    

    public pub_offre(int id, String contenue,InputStream img, String date) {
        this.id = id;
        this.contenue = contenue;
        this.imagePub=img;
        this.date = date;
    }

    public pub_offre(int id, String contenue, String date) {
        this.id = id;
        this.contenue = contenue;
        this.date = date;
    }
    
    
    

    public pub_offre(int id) {
        this.id = id;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public InputStream getImagePub() {
        return imagePub;
    }

    public void setImagePub(InputStream imagePub) {
        this.imagePub = imagePub;
    }

    
    
    

    @Override
    public String toString() {
        return "Publication{" + "id=" + id + ", contenue=" + contenue + '}';
    }
    
    
}
