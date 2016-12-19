/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.Date;
import java.util.List;
import static javafx.scene.input.KeyCode.T;


/**
 *
 * @author Ines
 */
public interface IDAOFlight<T> {
      void add(T t);
    void updatePrice(T t,float price);
    void updateArrivalDate(T t,Date ArrivalDate);
    void updateDepartureDate(T t,Date DepartureDate);
    
   
    void removeById(int id);
    T findById(int id);
    
    List<T> findAll();
   
    
    
}
