/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektzaliczeniowy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class ZapisOdczytZPliku{
    public static DaneGwiazd doZapisu;
    public static String sciezka = "gwiazdy.dat";
    
    /**Metoda która zapisuje listę obiektów do pliku o podanej ścieżce
    *@param sciezka Sciezka do pliku w którym ma zostać zapisana lista gwiazd
    * */
    public static void ZapiszDoPliku(String sciezka) throws IOException{
        try 
        {
            FileOutputStream fileOut = new FileOutputStream(sciezka);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(doZapisu);
            objectOut.close();
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        } 
        
    }
    /**Metoda która zapisuje listę obiektów do pliku o podanej ścieżce
    *
    * */
    public static void ZapiszDoPliku() throws IOException{
        try 
        {
            FileOutputStream fileOut = new FileOutputStream(sciezka);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(doZapisu);
            objectOut.close();
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        } 
    }
    /**Funkcja która zwraca listę gwiazd odczytaną z pliku 
     * 
     * @param sciezka Ścieżka do pliku w którym znajdują się obiekty
     * @return Lista obiektów typu Gwiazda
     */
    public static DaneGwiazd OdczytajZPliku(String sciezka) throws IOException {
        DaneGwiazd result = null;
        try 
        {
 
            FileInputStream fileIn = new FileInputStream(sciezka);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
 
            result = (DaneGwiazd)objectIn.readObject();
            
            objectIn.close();
            return result;
 
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
            return null;
        }
    }
    /**Funkcja która zwraca listę gwiazd odczytaną z pliku 
     * 
     * @return Lista obiektów typu Gwiazda
     */
    public static DaneGwiazd OdczytajZPliku() throws IOException {
        DaneGwiazd result = null;
        try 
        {
 
            FileInputStream fileIn = new FileInputStream(sciezka);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
 
            result = (DaneGwiazd)objectIn.readObject();
            
            objectIn.close();
            return result;
 
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
            return null;
        }
    }
}
