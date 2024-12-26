public class Main {
    public static void main(String[] args) {
        Film testowyFilm = new Film();
        System.out.println("Testowy film ma pola: \nTytuł = "+testowyFilm.getTytul()+"\nLiczbę wyświetleń = "+testowyFilm.getLiczbaWypozyczen());
        testowyFilm.setTytul("Harry Potter");
        System.out.println("\nPo użyciu settera: \nTytuł = "+testowyFilm.getTytul());
        System.out.println("\nPrzed użyciem metody inkrementacji ilość wyświetleń wynosiła: "+testowyFilm.getLiczbaWypozyczen());
        testowyFilm.incrementLiczbaWypozyczen();
        System.out.println("Po użyciu metody inkrementacji ilość wyświetleń: "+testowyFilm.getLiczbaWypozyczen());
    }
}