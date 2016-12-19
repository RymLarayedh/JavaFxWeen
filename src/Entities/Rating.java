/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author ElarbiMohamedAymen
 */
public class Rating {
    private int userId ;
    private int rate  ;
    private int ratingid ;

    public Rating(int userId, int rate, int ratingid) {
        this.userId = userId;
        this.rate = rate;
        this.ratingid = ratingid;
    }

    public Rating() {
    }

    public Rating(int userId, int rate) {
        this.userId = userId;
        this.rate = rate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getRatingid() {
        return ratingid;
    }

    public void setRatingid(int ratingid) {
        this.ratingid = ratingid;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Rating other = (Rating) obj;
        if (this.ratingid != other.ratingid) {
            return false;
        }
        return true;
    }
    
    
    
    
}
