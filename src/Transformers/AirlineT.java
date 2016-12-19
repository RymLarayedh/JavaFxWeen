/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transformers;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ElarbiMohamedAymen
 */
public class AirlineT {
    private final SimpleIntegerProperty id ;
    private final SimpleStringProperty name;
    private final SimpleStringProperty Address;

    public AirlineT(Integer id, String Address, String name ) {
        this.id = new SimpleIntegerProperty(id);
        this.name =  new SimpleStringProperty(name);
        this.Address = new SimpleStringProperty(Address);
    }

    public Integer getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public String getAddress() {
        return Address.get();
    }

}
