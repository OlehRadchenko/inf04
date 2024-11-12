import java.util.Scanner;
import java.util.Random;

public class Main {
    /*************************************************
        nazwa: rzutKoscmi
        opis: losuje wybraną przez parametr liczbę kości, wyświetla oraz zapisuje to do tablicy
        parametry: ilosc - liczba całkowita - ilość potrzebnych losowań
        zwracany typ i opis: zwraca tablicę liczb całkowitych - wszystkie wylosowane oczki
    *************************************************/
    public static int[] rzutKoscmi(int ilosc) {
        Random random = new Random();
        int[] wylosowane = new int[ilosc];
        for(int i=0; i<ilosc; i++){
            wylosowane[i] = random.nextInt(1, 7);
            System.out.println("Kostka "+(i+1)+": "+wylosowane[i]);
        }
        return wylosowane;
    }

    /*************************************************
         nazwa: obliczPunkty
         opis: oblicza uzyskane punkty w rundzie na podstawie parametru który daje dane do obliczeń
         parametry: rzuty - tablica liczb całkowitych - wszystkie wylosowane oczka w turze
         zwracany typ i opis: zwraca liczbę całkowitą - liczba uzyskanych punktów w turze
    *************************************************/
    public static int obliczPunkty(int[] rzuty){
        int sumaPunktow = 0;
        int[] iloscWystapien = {0,0,0,0,0,0};

        for(int i=0; i<6; i++){
            for (int j=0; j< rzuty.length; j++){
                if(rzuty[j] == i+1){
                    iloscWystapien[i]++;
                }
            }
            if(iloscWystapien[i] > 1){
                sumaPunktow += (i+1)*iloscWystapien[i];
            }
        }
        return sumaPunktow;
    }
    public static void main(String[] args) {
        String czyPowtorzyc = "t";
        Scanner scanner = new Scanner(System.in);
        do {
            int ilosc_rzutow;
            do {
                System.out.println("Ile kostek chcesz rzucić? (3 - 10)");
                ilosc_rzutow = scanner.nextInt();
            }while (ilosc_rzutow < 3 || ilosc_rzutow > 10);
            int[] wylosowane = rzutKoscmi(ilosc_rzutow);
            System.out.println("Liczba uzyskanych punktów: "+obliczPunkty(wylosowane));
            System.out.println("Jeszcze raz? (t/n)");
            scanner.nextLine();
            czyPowtorzyc = scanner.nextLine();
        }while (czyPowtorzyc.equals("t"));
    }
}