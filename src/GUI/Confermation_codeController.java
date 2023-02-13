/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Users;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import services.SendMail;
import services.UserCode;
import services.UsersCRUD;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Confermation_codeController implements Initializable {

    @FXML
    private TextField codeinput;
    @FXML
    private Button resend;
    
    public static int u_id;
    public static String u_email;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void resendcode(ActionEvent event) {
        try {
            Users us=new Users();
            us.setEmail(u_email);
            System.out.println("bellah ekhdem"+u_id);
            us.setId(u_id);
            SendMail.sendCode(us,true);
            
            JFrame frame = new JFrame("JOptionPane showMessageDialog example");
            frame.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(frame, "A verification code have been sent to your email!", "Success", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(Confermation_codeController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }

    @FXML
    private void verifycode(ActionEvent event) {
        if(UserCode.GetUserCode(u_id,codeinput.getText())!=null){
            UsersCRUD.modifierUsersStatus(u_id,1);
              JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                frame.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(frame, "Your account is now active!", "Success", JOptionPane.ERROR_MESSAGE);
                                                   NewFXMain.setScene("InterfaceLogin");

        }else{
              JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                frame.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(frame, "Wrong Code", "wrong Code", JOptionPane.ERROR_MESSAGE);
 
        }
    }

    @FXML
    private void cancelcode(ActionEvent event) {
                                                  NewFXMain.setScene("InterfaceLogin");

    }
    
}
