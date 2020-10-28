/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektzaliczeniowy;

import java.io.Serializable;

/**
 *
 * Wartość która przyjmuje wartości podane w stopniach, minutach, oraz sekundach.
 */
public class DMSvalue implements Serializable{
    public int degree;
    public int minutes;
    public int seconds;
    
    public DMSvalue(int degree, int minutes, int seconds)
    {
        if(degree > 90)
            this.degree = 90;
        else if(degree < -90)
            this.degree = -90;
        else
            this.degree = degree;
        if(minutes > 60)
            this.minutes = 60;
        else if(minutes < 0)
            this.minutes = 0;
        else
            this.minutes = minutes;
         if(seconds > 60)
            this.seconds = 60;
        else if(seconds < 0)
            this.seconds = 0;
        else
            this.seconds = seconds;
    }
    /** Funkcja która zwraca wartość obiektu
     * 
     * @param degree dopisek po liczbie stopni
     * @param minutes dopisek po liczbie minut
     * @param seconds dopisek po liczbie sekund
     * @return 
     */
    public String get(String degree, String minutes, String seconds)
    {
        String result = "";
        if(this.degree<10 && this.degree >= 0)
        {
            result += "0"+this.degree+degree;
        }
        else
        {
            result += this.degree+degree;
        }
            
        if(this.minutes<10 && this.minutes>=0)
        {
            result += "0"+this.minutes+minutes;
        }
        else
        {
            result += this.minutes+minutes;
        }
        if(this.seconds<10 && this.seconds >= 0)
        {
            result += "0"+this.seconds+seconds;
        }
        else
        {
            result += this.seconds+seconds+"";
        }
        return result;
    }
    
}
