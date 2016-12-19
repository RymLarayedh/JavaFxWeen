/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transformers;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author macbookpro
 */
public class PersonneToPerson1 {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty namehotel;
    private final SimpleIntegerProperty starshotel;
    private final SimpleStringProperty countryhotel;
    private final SimpleFloatProperty ratinghotel;
    private final SimpleStringProperty addresshotel;
    private final SimpleStringProperty longitudehotel;
    private final SimpleStringProperty latitudehotel;
     private final SimpleFloatProperty pricehotel;
     
    public PersonneToPerson1(Integer id, String namehotel, Integer starshotel,String countryhotel,float ratinghotel,String addresshotel,String longitudehotel,String latitudehotel,float pricehotel) {
        this.id = new SimpleIntegerProperty (id);
        this.namehotel = new SimpleStringProperty (namehotel);
        this.starshotel = new SimpleIntegerProperty (starshotel);
        this.countryhotel = new SimpleStringProperty (countryhotel);
        this.ratinghotel = new SimpleFloatProperty (ratinghotel);
        this.addresshotel = new SimpleStringProperty (addresshotel);
        this.longitudehotel = new SimpleStringProperty (longitudehotel);
        this.latitudehotel = new SimpleStringProperty (latitudehotel);
        this.pricehotel = new SimpleFloatProperty (pricehotel);
    }

    public Integer getId() {
        return id.get();
    }

    public String getNamehotel() {
        return namehotel.get();
    }

    public Integer getStarshotel() {
        return starshotel.get();
    }

    public String getCountryhotel() {
        return countryhotel.get();
    }

    public Float getRatinghotel() {
        return ratinghotel.get();
    }

    public String getAddresshotel() {
        return addresshotel.get();
    }

    public String getLongitudehotel() {
        return longitudehotel.get();
    }

    public String getLatitudehotel() {
        return latitudehotel.get();
    }

    public Float getPriceHotel() {
        return pricehotel.get();
    }
    

   
    
}
