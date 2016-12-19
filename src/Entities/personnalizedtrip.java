/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author macbookpro
 */
public class personnalizedtrip {
    private int idtrip;
    private Date departuredate;
    private Date arrivaldate;
    private int nights;
    private int flightid;
    private int hotelid;
      private int userid;
      private float price;

    public personnalizedtrip() {
    }

    public personnalizedtrip(int idtrip, Date departuredate, Date arrivaldate, int nights, int flightid, int hotelid,int userid,float price) {
        this.idtrip = idtrip;
        this.departuredate = departuredate;
        this.arrivaldate = arrivaldate;
        this.nights = nights;
        this.flightid = flightid;
        this.hotelid = hotelid;
        this.userid = userid;
        this.price = price;
    }

    public personnalizedtrip(Date departuredate, Date arrivaldate, int nights, int flightid, int hotelid,float price) {
        this.departuredate = departuredate;
        this.arrivaldate = arrivaldate;
        this.nights = nights;
        this.flightid = flightid;
        this.hotelid = hotelid;
        this.userid = userid;
        this.price = price;
    }

    public int getIdtrip() {
        return idtrip;
    }

    public void setIdtrip(int idtrip) {
        this.idtrip = idtrip;
    }

    public Date getDeparturedate() {
        return departuredate;
    }

    public void setDeparturedate(Date departuredate) {
        this.departuredate = departuredate;
    }

    public Date getArrivaldate() {
        return arrivaldate;
    }

    public void setArrivaldate(Date arrivaldate) {
        this.arrivaldate = arrivaldate;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    public int getFlightid() {
        return flightid;
    }

    public void setFlightid(int flightid) {
        this.flightid = flightid;
    }

    public int getHotelid() {
        return hotelid;
    }

    public void setHotelid(int hotelid) {
        this.hotelid = hotelid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
