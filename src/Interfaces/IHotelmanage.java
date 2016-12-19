/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Transformers.PersonneToPerson;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author ElarbiMohamedAymen
 */
public interface IHotelmanage {
    public boolean AddHotel(String name, int stars,String country,float rating,
            String hoteladdress,String longitude,String latitude,float pricebynight);
 //   public List<PersonneToPerson> DisplayAllUserStatus1();
   /* 
    public List<AirlineT> FindByName(String name);
    public boolean CheckUpdate(String name,String address,int id);
    public boolean Delete(int id);*/
    
}
