/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Ines
 */
public class Flight {
    private int FlightId;
    private Date ArrivalDate;
    private Date DepartureDate;
    private float price;
    // int id Airline Compagny

    public Flight() {
        this.FlightId=0;
    }

    public Flight(Date ArrivalDate, Date DepartureDate) {
        this.ArrivalDate = ArrivalDate;
        this.DepartureDate = DepartureDate;
    }
    
 

    public Flight(int Flight_id, Date ArrivalDate, Date DepartureDate, float price) {
        this.FlightId = Flight_id;
        this.ArrivalDate = ArrivalDate;
        this.DepartureDate = DepartureDate;
        this.price = price;
    }

    public Flight(Date ArrivalDate, Date DepartureDate, float price) {
        this.ArrivalDate = ArrivalDate;
        this.DepartureDate = DepartureDate;
        this.price = price;
    }


    

    public int getFlightId() {
        return FlightId;
    }

    public void setFlight_id(int Flight_id) {
        this.FlightId = Flight_id;
    }

    public Date getArrivalDate() {
        return ArrivalDate;
    }

    public void setArrivalDate(Date ArrivalDate) {
        this.ArrivalDate = ArrivalDate;
    }

    public Date getDepartureDate() {
        return DepartureDate;
    }

    public void setDepartureDate(Date DepartureDate) {
        this.DepartureDate = DepartureDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

 

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Flight other = (Flight) obj;
        if (this.FlightId != other.FlightId) {
            return false;
        }
        if (Float.floatToIntBits(this.price) != Float.floatToIntBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.ArrivalDate, other.ArrivalDate)) {
            return false;
        }
        if (!Objects.equals(this.DepartureDate, other.DepartureDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Flight{" + "Flight_id=" + FlightId + ", ArrivalDate=" + ArrivalDate + ", DepartureDate=" + DepartureDate + ", price=" + price + '}';
    }

    
}
