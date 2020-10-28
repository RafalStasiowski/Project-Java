/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektzaliczeniowy;

import java.io.IOException;
import java.util.Random;

public class ProjektZaliczeniowy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        KontorlerGwiazd kontroler = new KontorlerGwiazd();
        
        GenerujGwiazdy(20, kontroler);
        
        kontroler.WyswietlMenu();
        

    }
    /**Metoda pomocnicza, służąca do generowania losowych gwiazd
     * 
     * @param n ilość gwiazd które chcemy wygenerować
     * @param kontroler obiekt kontrolera gwiazd
     */
    public static void GenerujGwiazdy(int n, KontorlerGwiazd kontroler)
    {
        for(int j=0;j<n;j++)
        {
            Random random = new Random();
            String nazwa = "";
            DMSvalue deklinacja = new DMSvalue(random.nextInt(181)-90, random.nextInt(60), random.nextInt(60));
            DMSvalue rektascensja = new DMSvalue(random.nextInt(25), random.nextInt(60), random.nextInt(60));
            double obserwowanaWlkGwiazdowa = random.nextInt(42)-27;
            obserwowanaWlkGwiazdowa += random.nextDouble();
            double odleglosc = random.nextInt(10000)+4.36d;
            odleglosc += random.nextDouble();

            String[] gwiazdozbiory = new String[] {"Centaur", "Orion", "Wolarz", "Andromeda", "Perseusz","Herkules"};

            int losowy = random.nextInt(gwiazdozbiory.length);
            String gwiazdozbior = gwiazdozbiory[losowy];
            double temperatura = random.nextInt(208000)+2000;
            temperatura += random.nextDouble();
            double masa = random.nextInt(49)+0.1;
            masa += random.nextDouble();



            for(int i=0;i<3;i++)
            {
                nazwa += (char)(random.nextInt(25)+65);
            }
            for(int i=0;i<4;i++)
            {
                nazwa += random.nextInt(9)+1;
            }


            kontroler.DodajGwiazde(nazwa, deklinacja, rektascensja, obserwowanaWlkGwiazdowa, odleglosc, gwiazdozbior, temperatura, masa);
    
        }
    }
    
    
}
