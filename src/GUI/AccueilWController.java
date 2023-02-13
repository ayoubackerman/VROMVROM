 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.pub_offre;
import java.awt.Color;
import static java.awt.Color.green;
import java.awt.Insets;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import static javafx.scene.paint.Color.color;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.pub_offrecrud;

/**
 * FXML Controller class
 *
 * @author khale
 */
public class AccueilWController implements Initializable  {

    @FXML
    private Button publier;
    @FXML
    private Label controleSaisie;
    @FXML
    private TextArea contenu;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    
    @FXML
    private ImageView imgP;
    
    
    private MylistenerOnPubW Mylisteneree;
    @FXML
    private Button upload;
    
    private String path = null;
    
    private pub_offre pub;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    @SuppressWarnings("static-access")
    public void initialize(URL url, ResourceBundle rb) {
        
                
        Mylisteneree = new MylistenerOnPubW() {
                
                @Override
                public void onClickListener(pub_offre p) {
                  FXMLLoader fxmlLoader = new FXMLLoader();
                    //System.out.println(p);
                  try{
                      
                      fxmlLoader.setLocation(getClass().getResource("/GUI/pubDetailW.fxml"));
                      Parent root = fxmlLoader.load();
                      Stage mainStage = new Stage();
                      Scene scene = new Scene(root);
                      mainStage.setScene(scene);
                      PubDetailWController pubDetail_C = fxmlLoader.getController();
                      pubDetail_C.setData(p);
                      mainStage.show();
                      
                  }catch(Exception e){
                      JOptionPane.showMessageDialog(null, e);
                      
                  }
                }
                };
       afficher();
    }

    public pub_offrecrud spub = new pub_offrecrud();
    
    public void afficher(){
         
        grid.getColumnConstraints().clear();
        grid.getRowConstraints().clear();
        grid.getChildren().clear();
        pub_offrecrud ps = new pub_offrecrud();
        List<pub_offre> L = ps.find();
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < L.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/GUI/pubW.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                PubWController pController = fxmlLoader.getController();
                pController.setData(L.get(i),Mylisteneree);
                //
             
                row++;
                

                grid.add(anchorPane, column, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);
              
               GridPane.setMargin(anchorPane, new javafx.geometry.Insets(10, 10, 10, 10));
              
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void ajouter(ActionEvent event) throws FileNotFoundException {
        
        if(contenu.getText()!= null && !contenu.getText().isEmpty()){
        pub_offrecrud P = new pub_offrecrud();
        InputStream is = new FileInputStream(new File(this.path));
        pub_offre p = new pub_offre(contenu.getText(),is);
        P.ajouter(p);
        afficher();
        
        Alert alertAjout = new Alert(Alert.AlertType.INFORMATION);
        
        alertAjout.setTitle("Ajout publication");
        alertAjout.setHeaderText(null);
        alertAjout.setContentText("votre publication est ajoutée avec succées");
        alertAjout.showAndWait();
        //controleSaisie.setText("Votre publication est ajoutée");
        //controleSaisie.setTextFill(color(0, 255, 0));
        }
        else{
          controleSaisie.setText("Vous n'avez saisi aucune chose pour publier  !!!");
          controleSaisie.setTextFill(color(255, 0, 0));
        }
    }

    

    @FXML
    private void actualiser(ActionEvent event) {
    afficher();
    }
    
//private void goToUsers(ActionEvent event) {
//    try {
//        Parent root = FXMLLoader.load(getClass().getResource("listeUtilisateurs.fxml"));
//        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    } catch (IOException ex) {
//        Logger.getLogger(AccueilWController.class.getName()).log(Level.SEVERE, null, ex);
//    }
//}
    
    @FXML
    private void clear() {
    contenu.setText("");
    }

    @FXML
    private void ajouterImg(ActionEvent event) {
        FileChooser open = new FileChooser();
        Stage stage =(Stage)upload.getScene().getWindow();
        File file = open.showOpenDialog(stage);
        if(file != null){
        path = file.getAbsolutePath();
    
        Image imagee = new Image(file.toURI().toString(), 110,110,false,true);
        imgP.setImage(imagee);
        }else{
        System.out.println("No FILE EXIST");
        }
    }
    
    /*private void upload(ActionEvent event) {
    FileChooser open = new FileChooser();
    Stage stage =(Stage)upload.getScene().getWindow();
    File file = open.showOpenDialog(stage);
    if(file != null){
    path = file.getAbsolutePath();
    
    Image imagee = new Image(file.toURI().toString(), 110,110,false,true);
    img.setImage(imagee);
    }else{
    System.out.println("No FILE EXIST");
    }
    }*/

    
    
}
