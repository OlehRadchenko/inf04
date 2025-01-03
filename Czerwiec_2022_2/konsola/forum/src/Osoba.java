public class Osoba {
    public static int liczbaOsob = 0;
    private int id;
    private String imie;

    public Osoba() {
        id = 0;
        imie = "";
        liczbaOsob++;
    }

    public Osoba(int id, String imie) {
        this.id = id;
        this.imie = imie;
        liczbaOsob++;
    }

    public Osoba(Osoba osoba){
        this.id = osoba.id;
        this.imie = osoba.imie;
        liczbaOsob++;
    }

    public void wypiszImie(String argument){
        if(imie != "" && !imie.isEmpty()){
            System.out.println("Cześć "+argument+", mam na imię "+imie);
        }else{
            System.out.println("Brak danych");
        }
    }
}
