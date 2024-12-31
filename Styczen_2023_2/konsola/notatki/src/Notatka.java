public class Notatka {
     private static int licznikNotatek = 0;
     private int idNotatki;
     protected String tytulNotatki, trescNotatki;

     public Notatka(String tytulNotatki, String trescNotatki) {
          licznikNotatek++;
          idNotatki = licznikNotatek;
          this.tytulNotatki = tytulNotatki;
          this.trescNotatki = trescNotatki;
     }

     public void wyswietlTytulTresc(){
          System.out.println("Tytuł notatki: "+tytulNotatki+"\nTreść notatki: "+trescNotatki);
     }
     public void diagnostyka(){
          System.out.println(licznikNotatek + " ; " + idNotatki + " ; " + tytulNotatki + " ; " + trescNotatki);
     }
}
