/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;

/**
 *
 * @author Oussamabh
 * @param <T>
 */
public interface IdesDao<T> {
    void addDes(T t);
    void updateCity(int id,String city);
    void updateCountry( int id,String country  );
    void removeById(int id);
    List<T> findAll();
    List<T> findByPays(String country);
}
