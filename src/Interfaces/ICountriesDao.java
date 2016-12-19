package Interfaces;

import java.util.List;

/**
 *

 * @param <T>
 */
public interface ICountriesDao<T> {
    void add(T t);
    void updatename(int id ,String name);
    void delete(T t);
    List<T> findAll();
    List<T> findByname(String name);
}













/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
