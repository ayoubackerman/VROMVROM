/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import entites.Users;
import entities.User;
import entities.Users;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.SUser;
import services.UsersCRUD;
//import services.SUser;
import utils.APISms;

/**
 * FXML Controller class
 *
 * @author khale
 */
public class ListeUtilisateursController implements Initializable {
    
    @FXML
    private Label numeroTel;
    @FXML
    private TextArea msgSms;
    @FXML
    private Button btnSms;
    

    @FXML
    private TableColumn<User, String> nomU;
    @FXML
    private TableColumn<User, String> prenomU;
    @FXML
    private TableColumn<User, String> mailU;
    @FXML
    private TableColumn<User, String > telU;
    @FXML
    private TableColumn<User, String> domaineU;
    @FXML
    private TextField filterField;
    @FXML
    private TableView<User> tableview;
    
    public  ObservableList<User> personnes = FXCollections.observableArrayList();
    
    public SUser su = new SUser();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //ObservableList list = FXCollections.observableArrayList(personnes);
        
        nomU.setCellValueFactory(new PropertyValueFactory<>("nom"));       
        prenomU.setCellValueFactory(new PropertyValueFactory<>("prenom"));        
        mailU.setCellValueFactory(new PropertyValueFactory<>("mail"));        
        telU.setCellValueFactory(new PropertyValueFactory<>("numTel"));        
        domaineU.setCellValueFactory(new PropertyValueFactory<>("domaine"));
        
        personnes = su.find();
        
        
        // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<User> filteredData = new FilteredList<>(personnes, b -> true);
        
        
        // 2. Set the filter Predicate whenever the filter changes.
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(user -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (user.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (user.getMail().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}else if (user.getDomaine().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches domaine.
				}
				else if (String.valueOf(user.getNumTel()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<User> sortedData = new SortedList<User>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tableview.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tableview.setItems(sortedData);
    }

    @FXML
    private void goToA(ActionEvent event) throws IOException{
            Parent root = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }


    @FXML
    public void selectData(){
        
        User data = tableview.getSelectionModel().getSelectedItem();
        
        int num = tableview.getSelectionModel().getSelectedIndex();
        
        if((num-1) < -1)
            return;
        
        numeroTel.setText("+216"+String.valueOf(data.getNumTel()));
        numeroTel.setDisable(false);
        msgSms.setDisable(false);
        btnSms.setDisable(false);
        
        //cosommer API SMS
        
    }
    
    @FXML
    private void envoyerSms(MouseEvent event) {
        
        APISms s=new APISms();
        s.sms("achraf001", "Achrafelj1", numeroTel.getText(), msgSms.getText());
    }

    
    
}
