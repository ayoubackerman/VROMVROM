/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ASUS
 */
public class UserCode {
    private int id ;
    private int id_user ;
    private String code ;
    private String codeType ;

    public UserCode(int id, int id_user, String code, String codeType) {
        this.id = id;
        this.id_user = id_user;
        this.code = code;
        this.codeType = codeType;
    }

    public UserCode(int id_user, String code, String codeType) {
        this.id_user = id_user;
        this.code = code;
        this.codeType = codeType;
    }

    public UserCode() {
    }

    public int getId() {
        return id;
    }

    public int getId_user() {
        return id_user;
    }

    public String getCode() {
        return code;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    @Override
    public String toString() {
        return "UserCode{" + "id=" + id + ", id_user=" + id_user + ", code=" + code + ", codeType=" + codeType + '}';
    }
    
}
