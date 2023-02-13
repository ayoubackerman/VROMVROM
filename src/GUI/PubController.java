/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Publication;
import java.awt.event.MouseEvent;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import services.SPublication;

/**
 * FXML Controller class
 *
 * @author khale
 */
public class PubController implements Initializable {

    @FXML
    private Label contenu;
    @FXML
    private Label date;
    
    @FXML
    private Label nbComs;
    
    @FXML
    private ImageView imgP;
    
    @FXML
    private Label publisher;
   

    /**
     * Initializes the controller class.
     
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    private SPublication spub;
    private Publication publication;
    private MylistenerOnPub mylistener;
    
    
    public void setData(Publication pub,SPublication spub, MylistenerOnPub Mylistener) {
        this.mylistener = Mylistener;
        this.publication = pub;
        contenu.setText(pub.getContenue());
        InputStream i =publication.getImagePub();
        Image image = new Image(i);
        imgP.setImage(image);

        date.setText(pub.getDate());
        
        //Ici je vais recuperer l'id de publisher et par suite recuperer son nom
        publisher.setText(spub.findPublisher(pub));
        
        
        nbComs.setText(String.valueOf(spub.nombreCommentaires(pub)));
    }
    
    /*public void setNbreComms(Publication pub, MylistenerOnPub Mylistener){
        String nbreComms =""+this.spub.nombreCommentaires(pub);
        
        this.publication=pub;
        nbComs.setText(nbreComms);
        
    }*/

    @FXML
    private void click(javafx.scene.input.MouseEvent event) {
        mylistener.onClickListener(publication);
    }

    
}
