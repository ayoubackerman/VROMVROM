/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.sun.org.glassfish.gmbal.Description;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import services.reclamationcrud;
import entities.Reclamation;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author BEDOUI
 */
public class ReclamationController implements Initializable {

    @FXML
    private Button btnajouter;
    @FXML
    private TextField Titre_Rep;
    @FXML
    private TextArea Description;
    @FXML
    private TextField id_us;
    private TextField id_entre;
    @FXML
    private TextField Type_re;
    @FXML
    private TextField Id_entreprise;
    @FXML
    private TextField ids;
    @FXML
    private Button modif;
    @FXML
    private Button afficher;
    @FXML
    private Button back1;
    @FXML
    private Label Id_entreprise1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        if(Type_re.getText().trim().isEmpty()||Titre_Rep.getText().trim().isEmpty()||Description.getText().trim().isEmpty())
        {
              Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("failure");
        fail.setContentText("you havent typed something");
        fail.showAndWait();
            //id_us.getText().trim().isEmpty()||Id_entreprise.getText().trim().isEmpty()||
        }
              else
            
        {
            Reclamation r=new Reclamation();
       reclamationcrud re = new reclamationcrud();
           // int i=Integer.parseInt(id_us.getText());
                //   int j=Integer.parseInt(Id_entreprise.getText());
                   
         //  r.setId_user(i);
          // r.setId_entreprise(j);
             r.setType_rece(Type_re.getText());
           r.setTitre_Rep(Titre_Rep.getText());
                      r.setDescription(Description.getText());
                      // if(btnajouter.getText().equals("ajouter"))
            //{
            re.ajouter(r);
              Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("ajout avec succées");
        fail.setContentText("ajout terminé");
        fail.showAndWait();
        
       
    //}
    }
      /*  reclamationcrud re = new reclamationcrud();

           re.ajouter(new Reclamation(Integer.parseInt(id_us.getText()),Integer.parseInt(id_entre.getText()),Type_re.getText(),Description.getText(),Titre_Rep.getText()));
  */  }

    @FXML
    private void supprimer(ActionEvent event) {
       
 reclamationcrud re = new reclamationcrud();

        re.supprimer(Integer.parseInt(ids.getText()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Votre reclamation est supprimé  avec succees");
        alert.setHeaderText("reclamation supprimé");
               alert.showAndWait();
    
    
    }

    @FXML
    private void modifier(ActionEvent event) throws Exception{

        try{
           modif.getScene().getWindow().hide();
            Parent root =FXMLLoader.load(getClass().getResource("../GUI/modification.fxml"));
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
    private void afficher(ActionEvent event)  throws Exception{
        try{
           afficher.getScene().getWindow().hide();
            Parent root =FXMLLoader.load(getClass().getResource("../GUI/afficher.fxml"));
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
