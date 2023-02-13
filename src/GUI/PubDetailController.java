/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Commentaire;
import entities.Publication;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import static javafx.scene.paint.Color.color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.SCommentaire;
import services.SPublication;
import services.UsersSession;
//import gui.FXMLController;
/**
 * FXML Controller class
 *
 * @author khale
 */
public class PubDetailController implements Initializable {

    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private Button commenter;
    @FXML
    private Label controleSaisie;
    @FXML
    private TextField contenu;
    @FXML
    private TextField ajoutC;
    @FXML
    private GridPane grid;
    
    @FXML
    private Button btnB;
    
    @FXML
    private Label nbreCommentaires;
    
    private MylistenerOnComment Mylistener;
    @FXML
    private ImageView imgP;
    
    private SPublication spub= new SPublication();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Mylistener = new MylistenerOnComment() {
        
        @Override
        public void onClickListener(Commentaire c) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        //System.out.println(p);
        try{
        
        fxmlLoader.setLocation(getClass().getResource("/GUI/commentaireDetail.fxml"));
        Parent root = fxmlLoader.load();
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        CommentaireDetailController fullpostController = fxmlLoader.getController();
        fullpostController.setData(c);
        mainStage.show();
        
        }catch(IOException e){
        JOptionPane.showMessageDialog(null, e);
        
        }
        }
        };
        //Ici je vais donner l'accés au proprietaire du pub de modifier ou supprimer son pub 
        /*if(UsersSession.getId()== spub.findPublisherPub(publication)) {
        modifier.setDisable(false);
        supprimer.setDisable(false);
        contenu.setDisable(false);
        }  */
        
    }
    //private SPublication spub;    
    private Publication publication;
    
    public void setData(Publication pub) {
        
        
        this.publication = pub;
        contenu.setText(pub.getContenue());
        SPublication sp = new SPublication();
        List<Publication>  c = sp.find(publication.getId());
        Image image = new Image(c.get(0).getImagePub());
        imgP.setImage(image);
        
      afficher();

        
    }

    @FXML
    private void modifier(ActionEvent event) {
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Modification Pub");
        alert.setHeaderText("Etes vous sure de modifier la publication?");
        
      Optional<ButtonType> option = alert.showAndWait();
      
      if (option.get() == ButtonType.OK) {
        SPublication ps = new SPublication();
        publication.setContenue(contenu.getText());
        ps.modifier(publication);
      }
      else{
        //publication.setContenue(publication.getContenue());
        return;
      }
    }

    @FXML
    private void supprimer(ActionEvent event) {
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Suppression Pub");
        alert.setHeaderText("Etes vous sure de supprimer la publication?");
        
      Optional<ButtonType> option = alert.showAndWait();
      
      if (option.get() == ButtonType.OK) {
        SPublication ps = new SPublication();
        ps.supprimer(publication);
        
        Stage stage = (Stage) supprimer.getScene().getWindow();
        stage.close();
        afficher(); 
      }
      else{
        return;
      }
    }

    @FXML
    private void publierC(ActionEvent event) {
        if(ajoutC.getText()!= null && !ajoutC.getText().isEmpty()){
           Commentaire c = new Commentaire(publication.getId(),ajoutC.getText());
           SCommentaire sc = new SCommentaire();
           sc.ajouter(c);
           afficher(); 
       
           Alert alertAjout = new Alert(Alert.AlertType.INFORMATION);
        
           alertAjout.setTitle("Ajout commentaire");
           alertAjout.setHeaderText(null);
           alertAjout.setContentText("votre commentaire est ajoutée avec succées");
           alertAjout.showAndWait();
        }
        else{
           controleSaisie.setText("Vous n'avez saisi aucune chose pour commenter  !!!");
           controleSaisie.setTextFill(color(255, 0, 0));  
        }
        
    }
    
    public void afficher(){
        System.out.println("test");
        grid.getColumnConstraints().clear();
        grid.getRowConstraints().clear();
        grid.getChildren().clear();
        
        SCommentaire ps = new SCommentaire();
        List<Commentaire> C = ps.find(publication.getId());
        System.out.println(C);
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < C.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/GUI/commentaire.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                CommentaireController CommentaireController = fxmlLoader.getController();
                CommentaireController.setData(C.get(i),Mylistener);
                

               
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
    private void actualiser(ActionEvent event) {
        afficher();
    }
    
    @FXML
    private void returnToA(ActionEvent event) throws IOException{
            Parent root = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }
     
    
    
    @FXML
    private void clear2() {
        ajoutC.setText("");
    }


    
}
    

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            