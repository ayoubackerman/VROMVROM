/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import utils.MyConnection;

/**
 *
 * @author ASUS
 */
public class UserCode {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */

    public static boolean ajouteruserCode(entities.UserCode u) {
        System.out.println("here"+u.toString());
        try {
            String requete = "INSERT into usercode (`Id_user`, `Code`, `CodeType`) values(?,?,?)";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1, u.getId_user());
            pst.setString(2, u.getCode());
            pst.setString(3, u.getCodeType());
            pst.execute();
            System.out.println("Client ajouteé avec succées !");
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
public static boolean modifieruserCode(String code,int u_id){
    System.out.println("code"+code+" "+u_id);
    try {
            String requete = "UPDATE  usercode set  `Code`=? where Id_user="+u_id;
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, code);
            
            pst.executeUpdate();
            System.out.println("code Client modifié avec succées !");
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false; 
}
    public static entities.UserCode GetUserCode(int u_id,String code) {
        entities.UserCode c = null;

        String role = "";
        try {
            String requete = "SELECT `Id`, `Id_user`, `Code`, `CodeType` FROM `usercode` WHERE Id_user="+u_id+" AND Code="+code+" AND CodeType='ACCOUNT_VERIFICATION'  ";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()) {
                c=new entities.UserCode();
                c.setId(rs.getInt("Id"));
                c.setId_user(rs.getInt("Id_user"));
                c.setCode(rs.getString("Code"));
                c.setCodeType(rs.getString("CodeType"));
                if (rs.getString("role").equals("ROLE_ADMIN")) {
                    role = "Admin";
                } else if (rs.getString("role").equals("ROLE_CAMPER")) {
                    role = "Camper";
                } else if (rs.getString("role").equals("ROLE_HOST")) {
                    role = "Host";
                } else if (rs.getString("role").equals("ROLE_Fournisseur")) {
                    role = "Fournisseur";
                }

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return c;

    }

}


