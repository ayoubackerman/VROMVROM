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
public class Publication {
    private int id;
    private int idUser;
    private String contenue;
    private InputStream imagePub;
    private String date;

    public Publication() {
    }

    public Publication(int id, String contenue) {
        this.id = id;
        this.contenue = contenue;
    }
    
    public Publication(int id,int idu, String contenue) {
        this.id = id;
        this.idUser=idu;
        this.contenue = contenue;
    }
    
    
    
    public Publication(String contenue,int idu) {
        this.idUser = idu;
        this.contenue = contenue;
    }

    public Publication(String contenue) {
        this.contenue = contenue;
    }

    public Publication(String contenue, InputStream imagePub) {
        this.contenue = contenue;
        this.imagePub = imagePub;
    }
    
    public Publication(int idu,String contenue, InputStream imagePub) {
        this.idUser=idu;
        this.contenue = contenue;
        this.imagePub = imagePub;
    }
    

    public Publication(int id,int idu, String contenue,InputStream img, String date) {
        this.id = id;
        this.idUser = idu;
        this.contenue = contenue;
        this.imagePub=img;
        this.date = date;
    }
    
    public Publication(int id, String contenue,InputStream img, String date) {
        this.id = id;
        
        this.contenue = contenue;
        this.imagePub=img;
        this.date = date;
    }

    public Publication(int id, String contenue, String date) {
        this.id = id;
        this.contenue = contenue;
        this.date = date;
    }
    
    
    

    public Publication(int id) {
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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    
    
    

    @Override
    public String toString() {
        return "Publication{" + "id=" + id + ", contenue=" + contenue + '}';
    }
    
    
}
