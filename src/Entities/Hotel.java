/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author macbookpro
 */
public class Hotel {
private int idhotel;
private String name;
private int stars;
private String country;
private float rating;
private String hoteladdress;
private String longitude;
private String latitude;
private float pricebynight;


    public Hotel() {
    }


   
    public Hotel(int idhotel, String name, int stars, String country, float rating, String hoteladdress, String longitude, String latitude, float pricebynight) {
        this.idhotel = idhotel;
        this.name = name;
        this.stars = stars;
        this.country = country;
        this.rating = rating;
        this.hoteladdress = hoteladdress;
        this.longitude = longitude;
        this.latitude = latitude;
        this.pricebynight = pricebynight;
    }

    public Hotel(String name, int stars, String country, float rating, String hoteladdress, String longitude, String latitude, float pricebynight) {
        this.name = name;
        this.stars = stars;
        this.country = country;
        this.rating = rating;
        this.hoteladdress = hoteladdress;
        this.longitude = longitude;
        this.latitude = latitude;
        this.pricebynight = pricebynight;
    }

    public int getIdhotel() {
        return idhotel;
    }

    public void setIdhotel(int idhotel) {
        this.idhotel = idhotel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getHoteladdress() {
        return hoteladdress;
    }

    public void setHoteladdress(String hoteladdress) {
        this.hoteladdress = hoteladdress;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public float getPricebynight() {
        return pricebynight;
    }

    public void setPricebynight(float pricebynight) {
        this.pricebynight = pricebynight;
    }

    @Override
    public String toString() {
        return "Hotel{" + "idhotel=" + idhotel + ", name=" + name + ", stars=" + stars + ", country=" + country + ", rating=" + rating + ", hoteladdress=" + hoteladdress + ", longitude=" + longitude + ", latitude=" + latitude + ", pricebynight=" + pricebynight + '}';
    }

   


    
}
