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
 * @author rymlarayedh
 */
public class PersonneToPerson {
    private final SimpleIntegerProperty idutilisateur;
    private final SimpleStringProperty nom;
    private final SimpleStringProperty prenom;
    
    private final SimpleIntegerProperty adresse;
    private final SimpleStringProperty email;
    private final SimpleIntegerProperty tel;
    
    private final SimpleStringProperty identifiant;
    private final SimpleStringProperty mdp;
   // private final SimpleIntegerProperty isadmin;

    public PersonneToPerson(Integer idutilisateur, String nom, String prenom,Integer adresse, String email, Integer tel,String identifiant, String mdp) {
        this.idutilisateur = new SimpleIntegerProperty(idutilisateur);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        
        
        this.adresse = new SimpleIntegerProperty(adresse);
        this.email = new SimpleStringProperty(email);
        this.tel = new SimpleIntegerProperty(tel);
        
        
        this.identifiant = new SimpleStringProperty(identifiant);
        this.mdp = new SimpleStringProperty(mdp);
       // this.isadmin = new SimpleIntegerProperty(isadmin);
    }

    public Integer getIdutilisateur() {
        return idutilisateur.get();
    }

    public String getNom() {
        return nom.get();
    }

    public String getPrenom() {
        return prenom.get();
    }

    public Integer getIdadresse() {
        return adresse.get();
    }

    public String getEmail() {
        return email.get();
    }

    public Integer getTel() {
        return tel.get();
    }

    public String getIdentifiant() {
        return identifiant.get();
    }

    public String getMdp() {
        return mdp.get();
    }

   /* public Integer getIsadmin() {
        return isadmin.get();
    }*/
    
    
}
