/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author BEDOUI
 */
public class MenuController implements Initializable {

    @FXML
    private Button Gestion_reclamation;
    @FXML
    private Button Gestion_reponse;
    @FXML
    private Button btn_Conge1;
    @FXML
    private Button btn_Conge2;
    @FXML
    private Button btn_Conge3;
    @FXML
    private Button btn_Conge31;
    @FXML
    private Button btn_Conge32;
    @FXML
    private Button btn_Conge321;
    @FXML
    private Button btn_Conge322;
    @FXML
    private Button btn_Conge323;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

 

    @FXML
    private void Gestion_reclamation(ActionEvent event)  throws Exception{
         

        try{
           Gestion_reclamation.getScene().getWindow().hide();
            Parent root =FXMLLoader.load(getClass().getResource("../GUI/reclamation.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
                
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        } 
    }

    @FXML
    private void Gestion_reponse(ActionEvent event) throws Exception {
        
        try{
           Gestion_reponse.getScene().getWindow().hide();
            Parent root =FXMLLoader.load(getClass().getResource("../gui/reponse.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
                
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        } 
    }
    
}
