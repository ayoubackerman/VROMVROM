/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;

/**
 *
 * @author remo
 */
public interface IService<T> {
    void ajouter(T o);
    void modifier(T o);
    void supprimer(int Id_Rec);
    List<T> afficher();
}
