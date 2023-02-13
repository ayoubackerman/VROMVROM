/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import entities.Reclamation;
import entities.reponse;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
//import services.reclamationcrud;
import services.reponsecrud;

/**
 * FXML Controller class
 *
 * @author BEDOUI
 */
public class AfficherRepController implements Initializable {

    @FXML
    private TableView<reponse> table_view;
    @FXML
    private TableColumn<reponse, Integer> a;
    @FXML
    private TableColumn<reponse, Integer> b;
    @FXML
    private TableColumn<reponse, Integer> c;
    @FXML
    private TableColumn<reponse, String> d;
    @FXML
    private TableColumn<reponse, String> e;
    @FXML
    private Button back3;
    @FXML
    private TextField idddd;
    @FXML
    private Button supp;
    @FXML
    private TextField search;
    @FXML
    private Button PDF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       showBox();
        // TODO
    }    
      public void showBox(){
        reponse r=new reponse();
        reponsecrud sp=new reponsecrud();
        List reponse=sp.afficher();
        ObservableList list=FXCollections.observableArrayList(reponse);
        table_view.setItems(list);
        a.setCellValueFactory(new PropertyValueFactory<>("Id_Rec"));
        b.setCellValueFactory(new PropertyValueFactory<>("Id_entreprise"));
        c.setCellValueFactory(new PropertyValueFactory<>("Id_user"));
        d.setCellValueFactory(new PropertyValueFactory<>("titre"));
        e.setCellValueFactory(new PropertyValueFactory<>("description"));
        
    }
    @FXML
    private void selectdl(MouseEvent event) {
        reponse evt = table_view.getSelectionModel().getSelectedItem();
            String a = Integer.toString(evt.getId_Rec());
        idddd.setText(a);
    }

    @FXML
    private void back3(ActionEvent event) {
            try{
           back3.getScene().getWindow().hide();
            Parent root =FXMLLoader.load(getClass().getResource("../GUI/reponse.fxml"));
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
    private void handleButtonActionsupprimer(ActionEvent event) {
        reponsecrud re = new reponsecrud();

        re.supprimer(Integer.parseInt(idddd.getText()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Votre evenement est supprimé  avec succees");
        alert.setHeaderText("Evenement supprimé");
                alert.showAndWait();
                   List reponse=re.afficher();
        ObservableList list=FXCollections.observableArrayList(reponse);
        table_view.setItems(list);
        a.setCellValueFactory(new PropertyValueFactory<>("Id_Rec"));
        b.setCellValueFactory(new PropertyValueFactory<>("Id_entreprise"));
        c.setCellValueFactory(new PropertyValueFactory<>("Id_user"));
        d.setCellValueFactory(new PropertyValueFactory<>("titre"));
        e.setCellValueFactory(new PropertyValueFactory<>("description"));
        //f.setCellValueFactory(new PropertyValueFactory<>("Titre_Rep"));
        idddd.clear();
    }

    @FXML
    private void pdf(ActionEvent event) {
    }
    
}
