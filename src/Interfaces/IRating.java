/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entities.Rating;
import java.util.List;

/**
 *
 * @author ElarbiMohamedAymen
 */
public interface IRating {
    
    void Add(Rating R);
    void Update(int id);
    void RemoveById(int id);
    Rating FindById(int id);
    List<Rating> FindAll();
    
    
    
}
