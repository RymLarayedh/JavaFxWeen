/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entities.AirlineCompany;
import java.util.List;

/**
 *
 * @author ElarbiMohamedAymen
 */
public interface IAirlineCompany<T> {
    
    void add(T t);
    void updateName(int id,String NewName)throws Exception;
    void updateAdresse(int id,String NewAdresse)throws Exception;
    void removeById(int id);
    AirlineCompany findByAdresse(String address);
    AirlineCompany findByName(String name);
    List<T> findAll();
    T findById(int id);
    
}
