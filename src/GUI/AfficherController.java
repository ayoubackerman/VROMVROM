/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entities.Reclamation;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import static javafx.scene.input.KeyCode.C;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import services.reclamationcrud;
import utils.MyConnection;


/**
 * FXML Controller class
 *
 * @author BEDOUI
 */
public class AfficherController implements Initializable {

    @FXML
    private TableColumn<Reclamation, Integer> a;
    @FXML
    private TableColumn<Reclamation, Integer> b;
    @FXML
    private TableColumn<Reclamation, Integer> c;
    @FXML
    private TableColumn<Reclamation, String> d;
    @FXML
    private TableColumn<Reclamation, String> e;
    @FXML
    private TableColumn<Reclamation, String> f;
    @FXML
    private TableView<Reclamation> table_view;
    @FXML
    private Button back3;
    @FXML
    private Button supp;
    @FXML
    private TextField idddd;
    private Button mail;
    private Reclamation reclamation;
    @FXML
    private TextField rechercher;
    private final  ObservableList<Reclamation> liste = FXCollections.observableArrayList();
    @FXML
    private Button pdf;
    @FXML
    private TextField idddd1;
    @FXML
    private TextField idddd11;
    @FXML
    private TextField idddd12;
    @FXML
    private Button mode;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             showBox();  
               
               Reclamation r=new Reclamation();
        reclamationcrud sp = new reclamationcrud();
        List Reclamation=sp.afficher();
        ObservableList liste=FXCollections.observableArrayList(Reclamation);
        table_view.setItems(liste);
        a.setCellValueFactory(new PropertyValueFactory<>("Id_Rec"));
        b.setCellValueFactory(new PropertyValueFactory<>("Id_user"));
        c.setCellValueFactory(new PropertyValueFactory<>("Id_entreprise"));
        d.setCellValueFactory(new PropertyValueFactory<>("Type_rec"));
        e.setCellValueFactory(new PropertyValueFactory<>("Description"));
        f.setCellValueFactory(new PropertyValueFactory<>("Titre_Rep"));
        idddd.clear();

                FilteredList<Reclamation> filteredData = new FilteredList<>(liste, b -> true);
		
		rechercher.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(new Predicate<Reclamation>() {
                            public boolean test(Reclamation Reclamation) {
                                
                                if (newValue == null || newValue.isEmpty()) {
                                    return true;
                                }
                                
                                String lowerCaseFilter = newValue.toLowerCase();
                                
                                if (Reclamation.getType_rec().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                                    return true; 
                                } else if (Reclamation.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                                    return true; 
                                }
                                else if (Reclamation.getTitre_Rep().toLowerCase().indexOf(lowerCaseFilter) != -1)
                                    return true;
                              
                                else
                                    return false; 
                            }
                        });
		});
		
		SortedList<Reclamation> sortedData = new SortedList<>(filteredData);
	
		sortedData.comparatorProperty().bind( table_view.comparatorProperty());
		
		 table_view.setItems(sortedData);
                 //  showBox();

    }    


        
        
    
    public void showBox(){
        Reclamation r=new Reclamation();
        reclamationcrud sp=new reclamationcrud();
        List Reclamation=sp.afficher();
        ObservableList list=FXCollections.observableArrayList(Reclamation);
        table_view.setItems(list);
        a.setCellValueFactory(new PropertyValueFactory<>("Id_Rec"));
        b.setCellValueFactory(new PropertyValueFactory<>("Id_user"));
        c.setCellValueFactory(new PropertyValueFactory<>("Id_entreprise"));
        d.setCellValueFactory(new PropertyValueFactory<>("Type_rec"));
        e.setCellValueFactory(new PropertyValueFactory<>("Description"));
        f.setCellValueFactory(new PropertyValueFactory<>("Titre_Rep"));
    }
    

    @FXML
    private void back3(ActionEvent event) {
                try{
           back3.getScene().getWindow().hide();
            Parent root =FXMLLoader.load(getClass().getResource("../GUI/reclamation.fxml"));
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
    private void selectdl(MouseEvent event) {
        Reclamation evt = table_view.getSelectionModel().getSelectedItem();
            String a = Integer.toString(evt.getId_Rec());
        idddd.setText(a);
          idddd12.setText(evt.getType_rec());
        idddd1.setText(evt.getDescription());
        idddd11.setText(evt.getTitre_Rep());
        
        
        
    }
   
    

    @FXML
    private void handleButtonActionsupprimer(ActionEvent event) {
     reclamationcrud re = new reclamationcrud();

        re.supprimer(Integer.parseInt(idddd.getText()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Votre evenement est supprimé  avec succees");
        alert.setHeaderText("Evenement supprimé");
                alert.showAndWait();
                   List Reclamation=re.afficher();
        ObservableList list=FXCollections.observableArrayList(Reclamation);
        table_view.setItems(list);
        a.setCellValueFactory(new PropertyValueFactory<>("Id_Rec"));
        b.setCellValueFactory(new PropertyValueFactory<>("Id_user"));
        c.setCellValueFactory(new PropertyValueFactory<>("Id_entreprise"));
        d.setCellValueFactory(new PropertyValueFactory<>("Type_rec"));
        e.setCellValueFactory(new PropertyValueFactory<>("Description"));
        f.setCellValueFactory(new PropertyValueFactory<>("Titre_Rep"));
        idddd.clear();
             
    }

    
                
         // table.setHeaderRows(1);
//         ObservableList<Produit> list = (ObservableList<Produit>) ps.afficherProduit();
 //  colids.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("id"));
//      colprix.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("prix"));
//      colquan.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("quantite"));
//      date_exp.setCellValueFactory(new PropertyValueFactory<Produit,Date>("date_exp"));
//      coltype.setCellValueFactory(new PropertyValueFactory<Produit,String>("type"));
//     
//        tab_s.setItems(list);
       
//        table.addCell("");
//   table.addCell("1.1");
//             table.addCell("1.2");
//               table.addCell("2.1");
//                table.addCell("2.2");
//                 table.addCell("2.3");
          /*      doc.add(table);
                
                doc.close();
                Desktop.getDesktop().open(new File("C:\\Users\\Dhia\\OneDrive\\Bureau\\produit.pdf"));
             } catch (Exception e) {
          System.err.print(e);
        }
  
    */
    
    @FXML
    private void pdf(ActionEvent event) {
       
    try { 
                 
              
                com.itextpdf.text.Document doc = new com.itextpdf.text.Document() {} ;
                PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\BEDOUI\\Desktop\\a.pdf"));
                doc.open();
                
                
                doc.add(new Paragraph(" "));
               doc.add(new Paragraph("liste des reclamation : "));
               doc.add(new Paragraph(" "));
                
                
//                 Paragraph p =new Paragraph();
//                p.add("liste de produit");
//              
//                
//                 
//                
//                
//             doc.add(p);
             
                 PdfPTable t = new PdfPTable(6);
                 t.setWidthPercentage(100);
            PdfPCell c = new PdfPCell(new Phrase("Id_Rec"));
            c.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            c.setBackgroundColor(BaseColor.GRAY);
            t.addCell(c);
             c = new PdfPCell(new Phrase("Id_user"));
             c.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            c.setBackgroundColor(BaseColor.GRAY);
            t.addCell(c);
              c = new PdfPCell(new Phrase("Id_entreprise"));
              c.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            c.setBackgroundColor(BaseColor.GRAY);
            t.addCell(c);
              c = new PdfPCell(new Phrase("Type_rec"));
              c.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            c.setBackgroundColor(BaseColor.GRAY);
            t.addCell(c);
             c = new PdfPCell(new Phrase("Description"));
              c.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            c.setBackgroundColor(BaseColor.GRAY);
            t.addCell(c);
            c = new PdfPCell(new Phrase("Titre_rep"));
              c.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            c.setBackgroundColor(BaseColor.GRAY);
            t.addCell(c);
            
            
            doc.add(t);
               
            
              Connection cnx =MyConnection.getInstance().getCnx();;
            String query = "select * from reclamation";
            Statement stmt = null;
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            Paragraph p3 = null;
                PdfPTable table = new PdfPTable(6);
                 table.setWidthPercentage(100);
               while(rs.next()){ 
           
//                 
//            PdfPCell  c1 = new PdfPCell(new Phrase(rs.getString("id_rec")));
//            c1.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
//            c1.setBackgroundColor(BaseColor.WHITE);
//            table.addCell(c1);
                 
          PdfPCell   c1 = new PdfPCell(new Phrase(rs.getString("Id_Rec")));
             c1.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            c1.setBackgroundColor(BaseColor.WHITE);
            table.addCell(c1);
            
               c1 = new PdfPCell(new Phrase(rs.getString("Id_user")));
             c1.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            c1.setBackgroundColor(BaseColor.WHITE);
            table.addCell(c1);
                 
             c1 = new PdfPCell(new Phrase(rs.getString("Id_entreprise")));
             c1.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            c1.setBackgroundColor(BaseColor.WHITE);
            table.addCell(c1);
             c1 = new PdfPCell(new Phrase(rs.getString("Type_rec")));
             c1.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            c1.setBackgroundColor(BaseColor.WHITE);
            table.addCell(c1);
            
             c1 = new PdfPCell(new Phrase(rs.getString("Description")));
             c1.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            c1.setBackgroundColor(BaseColor.WHITE);
            table.addCell(c1);
            
             c1 = new PdfPCell(new Phrase(rs.getString("Titre_rep")));
             c1.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            c1.setBackgroundColor(BaseColor.WHITE);
            table.addCell(c1);
             
               }
               
         // table.setHeaderRows(1);
//         ObservableList<Produit> list = (ObservableList<Produit>) ps.afficherProduit();
 //  colids.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("id"));
//      colprix.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("prix"));
//      colquan.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("quantite"));
//      date_exp.setCellValueFactory(new PropertyValueFactory<Produit,Date>("date_exp"));
//      coltype.setCellValueFactory(new PropertyValueFactory<Produit,String>("type"));
//     
//        tab_s.setItems(list);
       
//        table.addCell("");
//   table.addCell("1.1");
//             table.addCell("1.2");
//               table.addCell("2.1");
//                table.addCell("2.2");
//                 table.addCell("2.3");
               doc.add(table);
                
                doc.close();
                Desktop.getDesktop().open(new File("C:\\Users\\ASUS\\OneDrive\\Bureau\\a.pdf"));
             } catch (Exception e) {
          System.err.print(e);
        }
  
    
    }

    @FXML
    private void modifier(ActionEvent event) {
           reclamationcrud ce = new reclamationcrud();
      Reclamation c = new Reclamation();
        
        int id = Integer.parseInt(idddd.getText());
        c.setId_Rec(id);
        c.setType_rece(idddd12.getText());
        c.setTitre_Rep(idddd1.getText());
        c.setDescription(idddd11.getText());
        
        ce.modifier(c);
        showBox();
    }
  
    
    
    
    
}
    
     

  

  



