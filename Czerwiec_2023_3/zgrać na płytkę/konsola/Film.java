/*******************************************************
        nazwa klasy: Film
        pola: tytul - przechowuje tytuł filmu
        liczbaWypozyczen - przechowuje ilość wypożyczeń filmu
        metody: getTytul, aktualną nazwę filmu - zwraca zmienną typu String o wartości aktualnego tytułu filmu
        setTytul, nic nie zwraca - ustawia wartość pola tytul
        Film, nic nie zwraca - konstruktor który buduje 'pusty' Film czyli bez tytułu i z 0 wyświetleniami
        getLiczbaWypozyczen, aktualną liczbę wyświetleń - zwraca zmienną typu int o wartości aktualnej liczby wyświetleń filmu
        incrementLiczbaWypozyczen, nic nie zwraca - inkrementuje pole odpowiadające za liczbę wyświetleń
        informacje: Klasa reprezentuje jeden Film, który posiada tytuł oraz liczbę wyświetleń
        autor: Oleh Radchenko
******************************************************/
public class Film {
    protected String tytul;
    protected int liczbaWypozyczen;

    public Film() {
        tytul = "";
        liczbaWypozyczen = 0;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public int getLiczbaWypozyczen() {
        return liczbaWypozyczen;
    }

    public void incrementLiczbaWypozyczen(){
        liczbaWypozyczen++;
    }
}
