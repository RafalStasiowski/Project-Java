/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektzaliczeniowy;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author runer
 */
public class KontorlerGwiazd implements Serializable{
    public static enum GreckieLitery
    {
        ALFA,
        BETA,
        GAMMA,
        DELTA,
        ETA,
        TETA,
        JOTA,
        KAPPA,
        LAMBDA,
        MI,
        NI,
        KSI,
        OMNIKRON,
        PI,
        RO,
        SIGMA,
        TAU,
        YPSILON,
        FI,
        CHI,
        PSI,
        OMEGA
    }
    
    public DaneGwiazd gwiazdy;
    private char menu;
    
    public KontorlerGwiazd()
    {
        gwiazdy = new DaneGwiazd();
        ZapisOdczytZPliku.doZapisu = gwiazdy;

        try
        {
            ZapisOdczytZPliku.ZapiszDoPliku("gwiazdy.dat");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        menu = 'g';
    }
    
    //Procedura która wypisuje na wyjście informacje o gwieździe
    //Parametr int i jest indeksem gwiazdy w liście obiektów
    public void WyswietlGwiazde(int i)
    {
        Gwiazda tmp = (Gwiazda)gwiazdy.gwiazdy.get(i);
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("Nazwa: "+tmp.nazwa);
        System.out.println("Nazwa katalogowa: "+tmp.nazwaKatalogowa);
        System.out.println("Deklinacja: "+tmp.deklinacja.get(" Stopni ", "Minut ", "Sekund "));
        System.out.println("Rektascensja: "+tmp.rektascensja.get("h ", "m ", "s "));
        System.out.println("Obserwowana wielkość gwiazdowa: "+tmp.obserwowanaWielkoscGwiazdowa);
        System.out.println("Absolutna wielkość gwiazdowa: : "+tmp.absolutnaWielkoscGwiazdowa);
        System.out.println("Odległość w latach świetlnych: "+tmp.odleglosc);
        System.out.println("Półkula: "+tmp.polkula);
        System.out.println("Temperatura: "+tmp.temperatura);
        System.out.println("Masa: "+tmp.masa);
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
    }
    
    /**Procedura która dodaje gwiazde
     * 
     */
    public void DodajGwiazde()
    {
        String nazwa;
        DMSvalue deklinacja = new DMSvalue(0, 0, 0);
        DMSvalue rektascensja = new DMSvalue(0, 0, 0);
        double obserwowanaWlkGwiazdowa;
        double odleglosc;
        String gwiazdozbior;
        double temperatura;
        double masa;
        
        Scanner scan = new Scanner(System.in);
        System.out.print("\nPodaj nazwę gwiazdy: ");
        nazwa = scan.nextLine();
        System.out.println("Podaj deklinacje");
        System.out.print("Podaj ilość stopni(deklinacja): ");
        deklinacja.degree = Integer.parseInt(scan.nextLine());
        System.out.print("\nPodaj ilość minut(deklinacja): ");
        deklinacja.minutes = Integer.parseInt(scan.nextLine());
        System.out.print("\nPodaj ilość sekund(deklinacja): ");
        deklinacja.seconds = Integer.parseInt(scan.nextLine());
        System.out.println("Podaj rektascensja");
        System.out.print("Podaj ilość stopni(rektascensja): ");
        rektascensja.degree = Integer.parseInt(scan.nextLine());
        System.out.print("\nPodaj ilość minut(rektascensja): ");
        rektascensja.minutes = Integer.parseInt(scan.nextLine());
        System.out.print("\nPodaj ilość sekund(rektascensja): ");
        rektascensja.seconds = Integer.parseInt(scan.nextLine());
        System.out.print("\nPodaj obserwowalną wielkość gwiazdową: ");
        obserwowanaWlkGwiazdowa = Double.parseDouble(scan.nextLine());
        System.out.print("\nPodaj odległość od gwiazdy: ");
        odleglosc = Double.parseDouble(scan.nextLine());
        System.out.print("\nPodaj nazwę gwiazdozbioru: ");
        gwiazdozbior = scan.nextLine();
        System.out.print("\nPodaj temperaturę: ");
        temperatura = Double.parseDouble(scan.nextLine());
        System.out.print("\nPodaj masę: ");
        masa = Double.parseDouble(scan.nextLine());
        
        GreckieLitery tmp = OstatniaWGwiazdozbiorze(gwiazdozbior);
        System.out.println(tmp);
        if(tmp!=null)
        {
            gwiazdy.gwiazdy.add(new Gwiazda(nazwa, deklinacja, rektascensja, obserwowanaWlkGwiazdowa, odleglosc, gwiazdozbior, temperatura, masa,tmp));

            ZapisOdczytZPliku.doZapisu = gwiazdy;

            try
            {
                ZapisOdczytZPliku.ZapiszDoPliku();
                System.out.println("Gwiazda została dodana");
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            System.out.println("Nie udało się dodać gwiazdy! Gwiazdozbiór pełny");
        }
        
    }
    public void DodajGwiazde(String nazwa,
            DMSvalue deklinacja, 
            DMSvalue rektascensja,
            double obserwowanaWlkGwiazdowa,
            double odleglosc, 
            String gwiazdozbior,
            double temperatura, 
            double masa)
    {
        GreckieLitery tmp = OstatniaWGwiazdozbiorze(gwiazdozbior);
        if(tmp!=null)
        {
            try
            {
                gwiazdy = ZapisOdczytZPliku.OdczytajZPliku();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            gwiazdy.gwiazdy.add(new Gwiazda(nazwa, deklinacja, rektascensja, obserwowanaWlkGwiazdowa, odleglosc, gwiazdozbior, temperatura, masa,tmp));
            ZapisOdczytZPliku.doZapisu = gwiazdy;
            try
            {
                ZapisOdczytZPliku.doZapisu = gwiazdy;
                ZapisOdczytZPliku.ZapiszDoPliku();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            System.out.println("Gwiazda została dodana");
        }
        else
        {
            System.out.println("Nie udało się dodać gwiazdy! Gwiazdozbiór pełny");
        }
        
    }
    
    /**Procedura która usuwa gwiazde
     * 
     */
    public void UsunGwiazde()
    {
        System.out.print("\nWpisz nazwę gwiazdy którą chcesz usunąć: ");
        Scanner scan = new Scanner(System.in);
        String tmp = scan.nextLine();
        Gwiazda gwiazda;
        for(int i=0;i<gwiazdy.gwiazdy.size();i++)
        {
            gwiazda = (Gwiazda)gwiazdy.gwiazdy.get(i);
            if(gwiazda.nazwa.equals(tmp))
            {
                gwiazdy.gwiazdy.remove(i);
                KorektaNumeracjiGwiazdozbiorow(gwiazda.numerKatalogowy, gwiazda.gwiazdozbior);
                
                System.out.println("Gwiazda została usunięta");
                break;
            }
        }
        
    }
    
    /**Procedura kontrolująca które menu ma zostać wyświetlone w danym momencie
     * 
     */
    public void WyswietlMenu()
    {
        while(menu!='e')
        {
            try
            {
                gwiazdy = ZapisOdczytZPliku.OdczytajZPliku();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            if(menu=='g')
            {
                MenuGlowne();
            }
            if(menu=='w')
            {
                MenuWyszukiwania();
            }
        }
        
    }
    /**Procedura wypisująca na wyjście informacje dla użytkownika o dostępnych wyborach
     * 
     */
    public void MenuGlowne()
    {
        int wybor;

        do
        {
            System.out.println("***************************************************");
            System.out.println("1. Dodaj gwiazdę");
            System.out.println("2. Usuń gwiazdę");
            System.out.println("3. Wyświetl wszystkie gwiazdy  ");
            System.out.println("4. Wyszukaj...");
            System.out.println("5. Zakończ");
            System.out.println("***************************************************");
            System.out.print("Twój wybór: ");
            Scanner scan = new Scanner(System.in);
            String linia = scan.nextLine();
            if(linia.equals(""))
            {
                linia = "1000";
            }
            wybor = Integer.parseInt(linia);
            
            if(wybor == 1)
            {
                DodajGwiazde();
                
            }
            if(wybor == 2)
            {
                UsunGwiazde();
            }
            if(wybor == 3)
            {
                for(int i=0;i<gwiazdy.gwiazdy.size();i++)
                {
                    WyswietlGwiazde(i);
                }
                System.out.println("Wcisnij enter wrócić do menu...");
                while(scan.nextLine()==null)
                {}
                break;
            }
            if(wybor == 4)
            {
                menu = 'w';
                break;
            }
            if(wybor == 5)
            {
                menu = 'e';
            }
            
        }while(wybor>5||wybor<1);
        
        
    }
    /**Procedura wypisująca na wyjście informacje dla użytkownika o dostępnych wyborach wyszukiwania
     * 
     */
    public void MenuWyszukiwania()
    {
        int wybor = 0;
        do
        {
            System.out.println("***************************************************");
            System.out.println("1. Wyszukaj gwiazdy w gwiazdozbiorze");
            System.out.println("2. Wyszukaj gwiazdy w podanej odległości");
            System.out.println("3. Wyszukaj gwiazdy o podanej temperaturze");
            System.out.println("4. Wyszukaj gwiazdy o podanej wielkości gwiazdowej");
            System.out.println("5. Wyszukaj gwiazdy na danej półkuli");
            System.out.println("6. Wyszukaj potencjalne supernowe");
            System.out.println("7. Powrót do menu głównego");
            System.out.println("***************************************************");
            System.out.print("Twój wybór: ");
            Scanner scan = new Scanner(System.in);
            String linia = scan.nextLine();
            if(linia.equals(""))
            {
                linia = "1000";
            }
            wybor = Integer.parseInt(linia);
            String tmp;
            if(wybor==1)
            {
                System.out.print("\nPodaj nazwę gwiazdozbioru: ");
                tmp = scan.nextLine();
                WyszukajWGwiazdozbiorze(tmp);
            }
            if(wybor==2)
            {
                System.out.print("\nPodaj odległość: ");
                tmp = scan.nextLine();
                WyszukajWOdleglosci(Double.parseDouble(tmp));
            }
            if(wybor==3)
            {
                System.out.print("\nPodaj dolną wartość temperatury: ");
                tmp = scan.nextLine();
                String tmp2;
                System.out.print("\nPodaj górną wartość temperatury: ");
                tmp2 = scan.nextLine();
                WyszukajTemperatura(Double.parseDouble(tmp),Double.parseDouble(tmp2));
            }
            if(wybor==4)
            {
                System.out.print("\nPodaj dolną wartość wielkości gwiazdowej: ");
                tmp = scan.nextLine();
                String tmp2;
                System.out.print("\nPodaj górną wartość wielkości gwiazdowej: ");
                tmp2 = scan.nextLine();
                WyszukajWielkosc(Double.parseDouble(tmp),Double.parseDouble(tmp2));
            }
            if(wybor==5)
            {
                System.out.print("\nCzy wyświetlić północną półkulę(T/N): ");
                tmp = scan.nextLine();
                tmp = tmp.toLowerCase();
                if(tmp.charAt(0)=='t')
                    WyszukajPolkula(true);
                else if(tmp.charAt(0)=='n')
                    WyszukajPolkula(false);
            }
            if(wybor==6)
            {
                WyszukajSupernowe();
            }
            if(wybor==7)
            {
                menu = 'g';
            }
            else
            {
                System.out.println("Wcisnij enter wrócić do menu...");
                while(scan.nextLine()==null)
                {}
            }
        } while(wybor>7||wybor<1);   
    }
    
    /**Procedura wypisuje na wyjście dane wszystkie gwiazdy w podanym gwiazdozbiorze
     * 
     * @param gwiazdozbior Nazwa gwiazdozbioru
     */
    public void WyszukajWGwiazdozbiorze(String gwiazdozbior)
    {
        boolean znaleziono = false;
        Gwiazda gwiazda;
        for(int i=0;i<gwiazdy.gwiazdy.size();i++)
        {
            gwiazda = (Gwiazda)gwiazdy.gwiazdy.get(i);
            if(gwiazda.gwiazdozbior.equals(gwiazdozbior))
            {
                WyswietlGwiazde(i);
                znaleziono = true;
            }
        }
        if(!znaleziono)
        {
            System.out.println("Nie znaleziono gwiazdy o podanej nazwie");
        }
    }
    
    /**Procedura wypisuje na wyjście dane wszystkich gwiazd w podanej odległości
     * 
     * @param odleglosc Odległość od gwiazdy podana w parsekach
     */
    public void WyszukajWOdleglosci(double odleglosc)
    {
        boolean znaleziono = false;
        Gwiazda gwiazda;
        for(int i=0;i<gwiazdy.gwiazdy.size();i++)
        {
            gwiazda = (Gwiazda)gwiazdy.gwiazdy.get(i);
            if(gwiazda.odlegloscParsek<=odleglosc)
            {
                WyswietlGwiazde(i);
                znaleziono = true;
            }
        }
        if(!znaleziono)
        {
            System.out.println("Nie znaleziono gwiazdy w podanej odległości");
        }
    }
    
    /**Procedura wypisuje na wyjście dane wszystkich gwiazd któych temperatura zaweira się w podanym przedziale
     * 
     * @param minTemp Dolny przedział temperatury
     * @param maxTemp Górny przedział temperatury 
     */
    public void WyszukajTemperatura(double minTemp, double maxTemp)
    {
        boolean znaleziono = false;
        Gwiazda gwiazda;
        for(int i=0;i<gwiazdy.gwiazdy.size();i++)
        {
            gwiazda = (Gwiazda)gwiazdy.gwiazdy.get(i);
            if(gwiazda.temperatura>=minTemp && gwiazda.temperatura<=maxTemp)
            {
                WyswietlGwiazde(i);
                znaleziono = true;
            }
        }
        if(!znaleziono)
        {
            System.out.println("Nie znaleziono gwiazdy o temperaturze w podanym przedziale");
        }
    }
    /**Procedura wypisuje na wyjście dane wszystkich gwiazd których wielkość zawiera się w podanym przedziale
     * 
     * @param minWielkosc Dolny przedział wielkości gwiazdy
     * @param maxWielkosc Górny przedział wielkości gwiazdy
     */
    
    public void WyszukajWielkosc(double minWielkosc, double maxWielkosc)
    {
        boolean znaleziono = false;
        Gwiazda gwiazda;
        for(int i=0;i<gwiazdy.gwiazdy.size();i++)
        {
            gwiazda = (Gwiazda)gwiazdy.gwiazdy.get(i);
            if(gwiazda.obserwowanaWielkoscGwiazdowa>=minWielkosc && gwiazda.obserwowanaWielkoscGwiazdowa<=maxWielkosc)
            {
                WyswietlGwiazde(i);
                znaleziono = true;
            }
        }
        if(!znaleziono)
        {
            System.out.println("Nie znaleziono gwiazdy o wielkości w podanym przedziale");
        }
    }
    /**Procedura wypisuje na wyjście wszystkie gwiazdy na podanej półkuli
     * @param polnocna True - gwiazdy z półkuli północnej; False - gwiazdy z półkuli południowej
     */
    public void WyszukajPolkula(boolean polnocna)
    {
        Gwiazda gwiazda;
        if(polnocna)
        {
            System.out.println("Wyświetlam gwiazdy na półkuli północnej");
        }
        else
        {
            System.out.println("Wyświetlam gwiazdy na półkuli południowej");
        }
        for(int i=0;i<gwiazdy.gwiazdy.size();i++)
        {
            gwiazda = (Gwiazda)gwiazdy.gwiazdy.get(i);
            if(gwiazda.polkula.equals("Północna") && polnocna)
            {
                WyswietlGwiazde(i);
            }
            else if(gwiazda.polkula.equals("Południowa") && !polnocna)
            {
                WyswietlGwiazde(i);
            }
        }
        
    }
    /**Procedura wypisuje na wyjście wszystkie potencjalne supernowe
     * 
     */
    public void WyszukajSupernowe()
    {
        boolean znaleziono = false;
        Gwiazda gwiazda;
        for(int i=0;i<gwiazdy.gwiazdy.size();i++)
        {
            gwiazda = (Gwiazda)gwiazdy.gwiazdy.get(i);
            if(gwiazda.masa>1.44d)
            {
                WyswietlGwiazde(i);
                znaleziono = true;
            }
        }
        if(!znaleziono)
        {
            System.out.println("Nie znaleziono potencjalnych supernowych");
        }
    }
    /**Funkcja zwraca litere greckiego alfabetu, która posłuży do przypsiania nazwy katalogowej nowego obiektu
     * 
     * @param nazwaGwiazdozbioru nazwa gwiazdozbioru
     * @return nastepna wolna litera greckiego alfabetu do nazwy katalogowej gwiazdy
     */
    public KontorlerGwiazd.GreckieLitery OstatniaWGwiazdozbiorze(String nazwaGwiazdozbioru)
    {
        boolean znaleziono = false;
        KontorlerGwiazd.GreckieLitery tmp = KontorlerGwiazd.GreckieLitery.ALFA;
        
        ArrayList<Object> gwiazdozbior = WczytajGwiazdozbior(nazwaGwiazdozbioru);
        
        for(int i=0;i<gwiazdozbior.size();i++)
        {
            znaleziono = false;
            Gwiazda gwiazda = (Gwiazda)gwiazdy.gwiazdy.get(i);
            if(gwiazda.numerKatalogowy.compareTo(tmp)<=0)
            {
                //tmp = gwiazda.numerKatalogowy;
                if(!tmp.equals(GreckieLitery.OMEGA))
                {
                    tmp = GreckieLitery.values()[tmp.ordinal()+1];
                }
            }
        }
        
        if(tmp.equals(GreckieLitery.OMEGA))
        {
            return null;
        }
        
        return tmp;
    }
    
    /**Funkcja zwraca Listę obiektów typu Gwiazda które znajdują się w podanym gwiazdozbiorze
     * 
     * @param nazwaGwiazdozbioru nazwa gwiazdozbioru z którego chcemy wczytać gwiazdy
     * @return lista obiektów typu Gwiazda z danego gwiazdozbioru
     */
    public ArrayList<Object> WczytajGwiazdozbior(String nazwaGwiazdozbioru)
    {
        ArrayList<Object> gwiazdozbior = new ArrayList();
        
        Gwiazda gwiazda;
        for(int i=0;i<gwiazdy.gwiazdy.size();i++)
        {
            gwiazda = (Gwiazda)gwiazdy.gwiazdy.get(i);
            if(gwiazda.gwiazdozbior.equals(nazwaGwiazdozbioru))
            {
                gwiazdozbior.add(gwiazda);
            }
        }
        
        return gwiazdozbior;
    }
    
    /**Procedura która koryguje nazwy katalogowe gwiazd po usunięciu jednej z nich
     * 
     * @param litera grecka litera gwiazdy która została usunięta
     * @param nazwaGwiazdozbioru nazwa gwiazdozbioru z którego usunięto gwiazdę
     */
    public void KorektaNumeracjiGwiazdozbiorow(KontorlerGwiazd.GreckieLitery litera, String nazwaGwiazdozbioru)
    {
        ArrayList<Object> gwiazdozbior = WczytajGwiazdozbior(nazwaGwiazdozbioru);
        Gwiazda gwiazda;
        for(int i=0;i<gwiazdozbior.size();i++)
        {
            gwiazda = (Gwiazda)gwiazdozbior.get(i);
            if(gwiazda.numerKatalogowy.compareTo(litera)>0)
            {
                gwiazda.numerKatalogowy = GreckieLitery.values()[gwiazda.numerKatalogowy.ordinal()-1];
                gwiazda.AktualizujNazweKatalogowa();
            }
        }
        try
        {
            ZapisOdczytZPliku.doZapisu = gwiazdy;
            ZapisOdczytZPliku.ZapiszDoPliku();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}
