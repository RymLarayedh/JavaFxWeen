/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Ines
 */
public class TripProgram {
    int IdTripProgram ;
 //Destination Destination;
   
    int NbrPassenger ;
    String Description ;
    float Price ;
    float rating ;
    Flight flight ;
    ArrayList<User> Subscribers ;
    ArrayList<Comment> comments;
    ArrayList<Like> likes ;

    public TripProgram(int IdTripProgram) {
        this.IdTripProgram = 0;
    }
/*
    public TripProgram(Destination destination, int NbrPassenger, String Description, float Price, Flight flight) {
        this.Destination = Destination;
        this.NbrPassenger = NbrPassenger;
        this.Description = Description;
        this.Price = Price;
        this.flight = flight;
    }
    
    

    public TripProgram(int IdTripProgram, Destination Destination, int NbrPassenger, String Description, float Price, float rating, Flight flight) {
        this.IdTripProgram = IdTripProgram;
        this.Destination = Destination;
        this.NbrPassenger = NbrPassenger;
        this.Description = Description;
        this.Price = Price;
        this.rating = rating;
        this.flight = flight;
    }

  
    public TripProgram() {
    }

   

    public int getIdTripProgram() {
        return IdTripProgram;
    }

    public void setIdTripProgram(int IdTripProgram) {
        this.IdTripProgram = IdTripProgram;
    }

    public Destination getDestination() {
        return Destination;
    }

    public void setDestination(Destination Destination) {
        this.Destination = Destination;
    }

    public int getNbrPassenger() {
        return NbrPassenger;
    }

    public void setNbrPassenger(int NbrPassenger) {
        this.NbrPassenger = NbrPassenger;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public ArrayList<User> getSubscribers() {
        return Subscribers;
    }

    public void setSubscribers(ArrayList<User> Subscribers) {
        this.Subscribers = Subscribers;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public ArrayList<Like> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<Like> likes) {
        this.likes = likes;
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
        final TripProgram other = (TripProgram) obj;
        if (this.IdTripProgram != other.IdTripProgram) {
            return false;
        }
        if (this.NbrPassenger != other.NbrPassenger) {
            return false;
        }
        if (Float.floatToIntBits(this.Price) != Float.floatToIntBits(other.Price)) {
            return false;
        }
        if (Float.floatToIntBits(this.rating) != Float.floatToIntBits(other.rating)) {
            return false;
        }
        if (!Objects.equals(this.Description, other.Description)) {
            return false;
        }
        if (!Objects.equals(this.Destination, other.Destination)) {
            return false;
        }
        if (!Objects.equals(this.flight, other.flight)) {
            return false;
        }
        if (!Objects.equals(this.Subscribers, other.Subscribers)) {
            return false;
        }
        if (!Objects.equals(this.comments, other.comments)) {
            return false;
        }
        if (!Objects.equals(this.likes, other.likes)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TripProgram{" + "IdTripProgram=" + IdTripProgram + ", Destination=" + Destination + ", NbrPassenger=" + NbrPassenger + ", Description=" + Description + ", Price=" + Price + ", rating=" + rating + ", flight=" + flight + ", Subscribers=" + Subscribers + ", comments=" + comments + ", likes=" + likes + '}';
    }
    
    
    */
    
    
    
}
