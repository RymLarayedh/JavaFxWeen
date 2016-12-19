/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Objects;

/**
 *
 * @author ElarbiMohamedAymen
 */
public class City {
    private int CityId ;
    private String Nom ;
    private int CountryId ; // clé etrangére de la classe Country

    public City(int CityId, String Nom, int CountryId) {
        this.CityId = CityId;
        this.Nom = Nom;
        this.CountryId = CountryId;
    }

    public int getCityId() {
        return CityId;
    }

    public void setCityId(int CityId) {
        this.CityId = CityId;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public int getCountryId() {
        return CountryId;
    }

    public void setCountryId(int CountryId) {
        this.CountryId = CountryId;
    }

    @Override
    public String toString() {
        return "City{" + "CityId=" + CityId + ", Nom=" + Nom + ", CountryId=" + CountryId + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final City other = (City) obj;
        if (this.CityId != other.CityId) {
            return false;
        }
        if (this.CountryId != other.CountryId) {
            return false;
        }
        if (!Objects.equals(this.Nom, other.Nom)) {
            return false;
        }
        return true;
    }
    
    
    
}
