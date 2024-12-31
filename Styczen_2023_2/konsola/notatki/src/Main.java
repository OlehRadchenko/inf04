public class Main {
    public static void main(String[] args) {
        Notatka notatka = new Notatka("Nauka do egzaminu", "Przygotować się do egzaminu inf04 na ostatnią chwilę");
        Notatka notatka2 = new Notatka("Nauka do matury", "Przygotować się do matury(po egzaminie zawodowym)");
        notatka.wyswietlTytulTresc();
        notatka.diagnostyka();
        notatka2.wyswietlTytulTresc();
        notatka2.diagnostyka();
    }
}