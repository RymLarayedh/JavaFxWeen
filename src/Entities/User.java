package Entities;


import java.util.ArrayList;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rymlarayedh
 */
public class User {
    private int UserId;
    private String name;
    private String lastname;
    private int idaddress;
    private String email;
    private int phonenumber;
    private String login;
    private String password;
    private int status;
    ArrayList <TripProgram> liste_voyages;
    ArrayList <TripProgram> liste_favoris_programme;
    ArrayList <User> liste_amis;
    ArrayList <TripProgram> liste_likes;
    
        public User() {
        }
        
        public User(String nom, String prenom,int adresse, String mail, int tel, String identifiant, String mdp) {
        this.name = nom;
        this.lastname = prenom;
        this.idaddress = adresse;
        this.email = mail;
        this.phonenumber = tel;
        this.login = identifiant;
        this.password = mdp;
    }

    public User(int idutilisateur, String nom, String prenom, 
            int adresse, String mail, int tel, String identifiant, String mdp) {
        this.UserId = idutilisateur;
        this.name = nom;
        this.lastname = prenom;
        this.idaddress = adresse;
        this.email = mail;
        this.phonenumber = tel;
        this.login = identifiant;
        this.password = mdp;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String prenom) {
        this.lastname = prenom;
    }

    public int getIdaddress() {
        return idaddress;
    }

    public void setIdaddress(int address) {
        this.idaddress = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) {
        this.email = mail;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.UserId != other.UserId) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "idutilisateur=" + UserId + ", nom=" + name + ", prenom=" + lastname + ", idadresse=" + idaddress + ", email=" + email + ", tel=" + phonenumber + ", identifiant=" + login + ", mdp=" + password + ", liste_voyages=" + liste_voyages + ", liste_favoris=" + liste_favoris_programme + ", liste_amis=" + liste_amis + ", liste_likes=" + liste_likes + '}';
    }
    
    
    
}

    

