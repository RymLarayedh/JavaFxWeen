/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Transformers.AirlineT;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author ElarbiMohamedAymen
 */
public interface IAirlineCompnayService {
    public boolean Add(String name, String address);
    public List<AirlineT> DisplayAll();
    public List<AirlineT> FindByName(String name);
    public boolean CheckUpdate(String name,String address,int id);
    public boolean Delete(int id);
    
}
