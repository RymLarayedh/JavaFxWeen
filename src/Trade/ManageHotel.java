/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trade;

import DAO.HotelDAO;
import Interfaces.IHotelmanage;
import Entities.Hotel;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.cell.PropertyValueFactory;
import utils.DataSource;
import Transformers.PersonneToPerson1;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

/**
 *
 * @author macbookpro
 */
public class ManageHotel implements IHotelmanage {
    
    private Connection connection; 
    public ManageHotel() {
        connection=DataSource.getInstance().getConnection();
    }

    @Override
    public boolean AddHotel(String name, int stars, String country, float rating, String hoteladdress, String longitude, String latitude, float pricebynight) {
        HotelDAO pdao2 = new HotelDAO();
      Hotel H =new Hotel(name,stars,country,rating,hoteladdress,longitude,latitude,pricebynight);
       pdao2.add(H);
   return true;}}
            
        
       
    
  
