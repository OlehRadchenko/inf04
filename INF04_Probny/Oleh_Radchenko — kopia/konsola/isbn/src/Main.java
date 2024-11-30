import java.util.Scanner;

public class Main {
    /******************************************************************************************************
        nazwa funkcji: sprawdzSumeKontrolna
        opis funkcji: funkcja sprawdza czy numer ISBN jest poprawny poprzez wyliczenie sumy kontrolnej
        parametry: isbn - tablica wszystkich cyfr numeru ISBN po kolei
        zwracany typ i opis: boolean - prawda(gdy ISBN jest prawdziwy) czy fałsz(gdy ISBN jest fałszywy)
        autor: Oleh Radchenko
    ******************************************************************************************************/
    protected static boolean sprawdzSumeKontrolna(int[] isbn){
        int suma = 0;
        for(int i=0; i< isbn.length; i++){
            if( (i+1) % 2 == 0 ){
                suma+=isbn[i]*1;
            }else{
                suma+=isbn[i]*3;
            }
        }
        if(suma%10 == 0){
            return true;
        }else{
            return false;
        }
    }
    protected static boolean sprawdzKraj(int[] isbn){
        if(isbn[3] == 8 && isbn[4] == 3){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String isbn_str;
        int[] isbn = new int[13];
        System.out.print("Podaj numer ISBN: ");
        isbn_str = scanner.nextLine();
        if(isbn_str.length() != 13){
            System.out.println("Wprowadziłeś niepoprawny numer ISBN(prawdziwy ma posiadać 13 cyfr)");
        }else{
            for(int i=0; i<isbn_str.length(); i++){
                isbn[i] = isbn_str.charAt(i) - '0';
            }
            if(sprawdzSumeKontrolna(isbn)){
                System.out.println("Wprowadziłeś poprawny numer ISBN");
                if(sprawdzKraj(isbn)){
                    System.out.println("I została ona wyprodukowana w Polsce");
                }else{
                    System.out.println("I nie zostałą wyprodukowana w Polsce");
                }
            }else{
                System.out.println("Wprowadziłeś błędny numer ISBN\nI nie została wyprodukowana XD");
            }
        }
    }
}