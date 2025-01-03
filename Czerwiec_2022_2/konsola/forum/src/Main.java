import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Liczba zarejestrowanych osób to "+Osoba.liczbaOsob);
        Osoba osoba = new Osoba();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj id osoby: ");
        int id = scanner.nextInt();
        System.out.print("I jego imie: ");
        scanner.nextLine(); //naprawienie bug'a javy z przeskoczeniem scannera w linijce 12
        String imie = scanner.nextLine();
        Osoba osoba2 = new Osoba(id, imie);
        Osoba osoba3 = new Osoba(osoba2);
        String argument = "Jan";
        osoba.wypiszImie(argument);
        osoba2.wypiszImie(argument);
        osoba3.wypiszImie(argument);
        System.out.println("Liczba zarejestrowanych osób to "+Osoba.liczbaOsob);
    }
}