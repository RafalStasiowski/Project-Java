/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektzaliczeniowy;

import java.io.Serializable;
import java.util.ArrayList;


public class DaneGwiazd implements Serializable{
    public ArrayList<Object> gwiazdy;
    
    public DaneGwiazd()
    {
       gwiazdy = new ArrayList<>();
    }
    
}
