/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import entities.Users;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import services.SendMail;

import services.UsersCRUD;
import services.UsersSession;

/**
 * FXML Controller class
 *
 * @author chayma
 */
public class InterfaceLoginController implements Initializable {
   private static String profilePicture="";
   private static final String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
     private static final String regex2 = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{8,20}$";

   @FXML
    private TextField TFname;
    @FXML
    private TextField TFlastname;
    @FXML
    private TextField TFemail;
    @FXML
    private PasswordField TFpassword;
    @FXML
    private ImageView sigupimage;
    private String cImageUrl = "";
    @FXML
    private PasswordField TFpassword2;
    @FXML
    private TextField TFemail2;
    @FXML
    private CheckBox cbox;
    @FXML
    private ComboBox<String> combobox1;
    ObservableList<String> list = FXCollections.observableArrayList("Admin","condidat","entreprise");
    //ValidationSupport validationSupport = new ValidationSupport();
    @FXML
    private TextField captchainput;
    @FXML
    private ImageView captchagenerate;
    private JLabel tempLabel;
     //String hashed = BCrypt.hashpw(TFpassword.getText(), BCrypt.gensalt());


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     combobox1.setItems(list);
 
  /*tempLabel = new JLabel();
       
        //cap.setImageCaptcha(tempLabel);
        captchagenerate.setImage(SwingFXUtils.toFXImage(NewFXMain.iconToImage(tempLabel.getIcon()),null));
         JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                    frame.setAlwaysOnTop(true);*/
    }    

    @FXML
    public  void ajouteruser(ActionEvent event) throws Exception {
      Pattern pattern = Pattern.compile(regex);
      Pattern pattern2 = Pattern.compile(regex2);
       UsersCRUD cc = new UsersCRUD(); 
        Matcher matcher = pattern.matcher(TFemail.getText());
        Matcher matcher1 = pattern.matcher(TFemail.getText());
        if (cImageUrl.equals("")) {
            JFrame frame = new JFrame("JOptionPane showMessageDialog example");
            frame.setAlwaysOnTop(true);
           JOptionPane.showMessageDialog(frame,"select a picture");
        }else if (TFname.getText().length() < 3) {
            JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                 frame.setAlwaysOnTop(true);
           JOptionPane.showMessageDialog(frame,"enter a valid name");
        } else if (TFlastname.getText().length() < 3) {
            JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                 frame.setAlwaysOnTop(true);
           JOptionPane.showMessageDialog(frame,"your lastname must be valid  ");
        } else if (!matcher.matches()) {
            JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                 frame.setAlwaysOnTop(true);
           JOptionPane.showMessageDialog(frame,"enter a valid email format");
        } else if (TFpassword.getText().length() < 6 && (!matcher1.matches()))
        {
            JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                 frame.setAlwaysOnTop(true);
JOptionPane.showMessageDialog(frame,"enter a strong password that mus contains uppercase char and symbol and numbers");
        } else if (!cc.validateEmail(TFemail.getText())) {
            JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                 frame.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(frame,"This mail is already used");
        } else {
            JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                 frame.setAlwaysOnTop(true);
        JOptionPane.showMessageDialog(frame,"Please wait we are creating your account");
        Users u = new Users();
       
        u.setName(TFname.getText());
        u.setLastname(TFlastname.getText());
        u.setEmail(TFemail.getText());
        u.setPassword(TFpassword.getText());
        u.setRole(combobox1.getValue());
        u.setProfilePicture(cImageUrl);
        if(cc.ajouteruser(u))
        { 
            JOptionPane.showMessageDialog(null,"Your Account has been successfully created!");
            NewFXMain.setScene("Userprofile");   
            System.out.println("User added");
            SendMail.send(TFemail.getText());
             
               
                     
            TFname.setText("");
            TFlastname.setText("");
            TFemail.setText("");
            TFpassword.setText("");
            combobox1.setValue("");
            cImageUrl="";
           
            
            
        }
        else {
            System.out.println("User was not added");
        }
        }
    }
    
    //Captcha cap = new Captcha();
    @FXML
    private void validate(ActionEvent event) throws Exception{
        Users u = new Users(); 
        UsersCRUD cc = new UsersCRUD(); 
       String access = (combobox1.getItems().toString());
       /*  if(cap.Validate(tempLabel, captchainput.getText()))
       {
           System.out.println("captcha valid");
       }else
       {
           System.out.println("captcha invalid");
           
        cap.setImageCaptcha(tempLabel);
        captchagenerate.setImage(SwingFXUtils.toFXImage(NewFXMain.iconToImage(tempLabel.getIcon()),null));

           return;
       }*/

        
        boolean result = UsersCRUD.Login(TFemail2.getText(), TFpassword2.getText());
        
        if(!result)
        {
            return;
        }
        
        if((UsersSession.getRole().equals("Admin")) && (true==result))
        {
         NewFXMain.setScene("InterfaceAdmin");    
        } else if ((UsersSession.getRole().equals("Admin")) && (true==result)) {
            
           NewFXMain.setScene("Interface_User");
        } else if ((UsersSession.getRole().equals("condidat")) && (true==result)) {
           NewFXMain.setScene("Interface_User");        
        } else if ((UsersSession.getRole().equals("entreprise")) && (true==result)) {
           NewFXMain.setScene("Interface_User"); 
        } 
        
    }
       
    

    @FXML
    private void uploadsiguppic(ActionEvent event) {
         FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        fileChooser.setInitialDirectory(new File("C:\\Users\\ASUS\\OneDrive\\Bureau\\PIDEV\\src\\images"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            String TempprofilePicture = file.toURI().toString();
            System.out.println(TempprofilePicture);
            profilePicture= file.getName();
            System.out.println(profilePicture);
            Image image = new Image(TempprofilePicture);
            sigupimage.setImage(image);
            cImageUrl = TempprofilePicture;
        }
    }

    @FXML
    private void checkbox(ActionEvent event) {
        if (cbox.isSelected()){
            TFpassword2.setPromptText(TFpassword2.getText());
            TFpassword2.setText("");
            TFpassword2.setDisable(true);
        }else {
            TFpassword2.setText(TFpassword2.getPromptText());
            TFpassword2.setPromptText("");
            TFpassword2.setDisable(false);
        }
    }

    @FXML
    private void closeapplication(MouseEvent event) {
       Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
       alert.setTitle("You are going to close the application");
       alert.setHeaderText("Are you sure you want to close the application?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.exit(0);
        }else {
            alert.close();
        }
    }
    
}
