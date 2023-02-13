/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Commentaire;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import services.SCommentaire;

/**
 * FXML Controller class
 *
 * @author khale
 */
public class CommentaireController implements Initializable {

    @FXML
    private Label contenu;
    @FXML
    private Label date;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    private Commentaire commentaire;
    private MylistenerOnComment Mylistener;
    public void setData(Commentaire pub, MylistenerOnComment Mylistener) {
        this.Mylistener = Mylistener;
        this.commentaire = pub;
        contenu.setText(pub.getContenue());
        date.setText(pub.getCreated_at());
    }

    @FXML
    private void click(javafx.scene.input.MouseEvent event) {
        Mylistener.onClickListener(commentaire);
    }

    
}
