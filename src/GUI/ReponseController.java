/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.reponse;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.reclamationcrud;
import services.reponsecrud;

/**
 * FXML Controller class
 *
 * @author BEDOUI
 */
public class ReponseController implements Initializable {

    @FXML
    private AnchorPane ajouterrep;
    private TextField id_us;
    @FXML
    private TextField id_entre;
    private TextField Titre_Rep;
    @FXML
    private TextArea Description;
    @FXML
    private Button btnajouter;
    @FXML
    private Button modif;
    @FXML
    private Button afficher;
    @FXML
    private Button back1;
    @FXML
    private TextField idsup;
    @FXML
    private TextField Id_Rec;
    @FXML
    private TextField Id_user;
    @FXML
    private TextField titre;
    @FXML
    private Label Id_entreprise2;
    @FXML
    private Button btsupprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        if(titre.getText().trim().isEmpty()||Description.getText().trim().isEmpty())
        {
              Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("failure");
        fail.setContentText("you havent typed something");
        fail.showAndWait();
            
        }
              else
            
        {
            reponse r=new reponse();
       reponsecrud re = new reponsecrud();
            //int i=Integer.parseInt(Id_Rec.getText());
              //     int j=Integer.parseInt(id_entre.getText());
                //   int k=Integer.parseInt(Id_user.getText());
                   
           //r.setId_Rec(i);
          // r.setId_entreprise(j);
           //r.setId_user(k);
             r.setTitre(titre.getText());
           r.setDescription(Description.getText());
                     
            if(btnajouter.getText().equals("ajouter"))
            {
            re.ajouter(r);
              Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("ajout avec succées");
        fail.setContentText("ajout terminé");
        fail.showAndWait();
       
    }
    }
     
    

   

    }

    @FXML
    private void supprimer(ActionEvent event) {
         reponsecrud re = new reponsecrud();

        re.supprimer(Integer.parseInt(idsup.getText()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Votre reponse est supprimé  avec succees");
        alert.setHeaderText("reponse supprimé");
               alert.showAndWait();
    
    
    }

    @FXML
    private void modifier(ActionEvent event) throws Exception{

        try{
           modif.getScene().getWindow().hide();
            Parent root =FXMLLoader.load(getClass().getResource("../GUI/modificationRep.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
                
        } 
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @FXML
    private void afficher(ActionEvent event)  throws Exception {
        try{
           afficher.getScene().getWindow().hide();
            Parent root =FXMLLoader.load(getClass().getResource("../gui/afficherRep.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
                
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    @FXML
    private void backmenu(ActionEvent event) {
         try{
           back1.getScene().getWindow().hide();
            Parent root =FXMLLoader.load(getClass().getResource("../GUI/menu.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
                
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    }
