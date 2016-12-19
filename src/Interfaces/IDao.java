/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;

/**
 *
 * @author macbookpro
 */
public interface IDao<T> {
    
    void add(T t);
    void update(T t ,String nom ); 
    void update(T t ,int id ); 
    void removeById(int id);
    List<T> findALL();
    T findById(int id);
    void UpdateHotel(int id,String name,int etoiles,String adresse,
           float note,String pays,String longitud,String latitud,float prixnuit) ;
    
}
