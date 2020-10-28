/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektzaliczeniowy;

import java.io.Serializable;

public class Gwiazda implements Serializable{
    public String nazwa;
    public String nazwaKatalogowa;
    public DMSvalue deklinacja;
    public DMSvalue rektascensja;
    public double obserwowanaWielkoscGwiazdowa;
    public double absolutnaWielkoscGwiazdowa;
    public double odleglosc;
    public double odlegloscParsek;
    public String gwiazdozbior;
    public String polkula;
    public double temperatura;
    public double masa;
    public KontorlerGwiazd.GreckieLitery numerKatalogowy;
    
    public Gwiazda(String nazwa,
            DMSvalue deklinacja, 
            DMSvalue rektascensja,
            double obserwowanaWlkGwiazdowa,
            double odleglosc, 
            String gwiazdozbior,
            double temperatura, 
            double masa,
            KontorlerGwiazd.GreckieLitery numerKatalogowy)
    {
        this.nazwa = nazwa;
        this.nazwaKatalogowa = gwiazdozbior;
        this.deklinacja = deklinacja;
        DMSvalue tmp = rektascensja;
        if(rektascensja.degree>24)
        {
            tmp.degree = 24;
        }
        else if(rektascensja.degree<0)
        {
            tmp.degree = 0;
        }
        this.rektascensja = tmp;
        //półkula
        if(deklinacja.degree>0)
        {
            this.polkula = "Północna";
        }
        else
        {
            this.polkula = "Południowa";
        }
        //wielkość gwiazdowa
        if(obserwowanaWlkGwiazdowa>15.0d)
        {
            this.obserwowanaWielkoscGwiazdowa = 15.0d;
        }
        else if(obserwowanaWlkGwiazdowa<-26.74d)
        {
            this.obserwowanaWielkoscGwiazdowa = -26.74d;
        }
        else
        {
            this.obserwowanaWielkoscGwiazdowa = obserwowanaWlkGwiazdowa;
        }
        this.odleglosc = odleglosc;
        this.odlegloscParsek = odleglosc*3.26d;
        this.absolutnaWielkoscGwiazdowa = this.obserwowanaWielkoscGwiazdowa - 5*Math.log10(this.odlegloscParsek)+5;
        this.gwiazdozbior = gwiazdozbior;
        //temperatura
        if(temperatura<2000)
        {
            this.temperatura = 2000;
        }
        else
        {
            this.temperatura = temperatura;
        }
        //masa
        if(masa>50)
        {
            this.masa = 50;
        }
        else if(masa<0.1)
        {
            this.masa = 0.1;
        }
        else
        {
            this.masa = masa;
        }
        this.numerKatalogowy = numerKatalogowy;
        AktualizujNazweKatalogowa();
    }
    public void AktualizujNazweKatalogowa()
    {
        this.nazwaKatalogowa = this.numerKatalogowy.toString() + this.gwiazdozbior;
    }
}
