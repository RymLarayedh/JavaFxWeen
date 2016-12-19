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
public class AirlineCompany {
    private int CompanyId ;
    private String adresse;
    private String name;

    public AirlineCompany() {
        this.CompanyId=0;
    }

    public AirlineCompany(int CompanyId, String adresse, String name) {
        this.CompanyId = CompanyId;
        this.adresse = adresse;
        this.name = name;
    }

    public AirlineCompany(String adresse, String name) {
        this.adresse = adresse;
        this.name = name;
    }
    
    public int getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(int CompanyId) {
        this.CompanyId = CompanyId;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        final AirlineCompany other = (AirlineCompany) obj;
        if (this.CompanyId != other.CompanyId) {
            return false;
        }
        return true;
    }
    
}
