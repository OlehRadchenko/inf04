import java.util.Scanner;

public class Main {
    protected static char sprawdzPlec(int[] pesel){
        if(pesel[9] % 2 == 0){
            return 'K';
        }else{
            return 'M';
        }
    }
    protected static boolean sprawdzSumeKontrolna(int[] pesel){
        int cyfraKontrolna = pesel[10];
        int suma = 0;
        int[] wagi = {1,3,7,9,1,3,7,9,1,3};
        for(int i=0; i<pesel.length-1; i++){
            suma+=pesel[i] * wagi[i];
        }
        int M = suma%10;
        int R=0;
        if(M != 0){
            R = 10-M;
        }
        if(R == cyfraKontrolna){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj PESEL który mam sprawdzić: ");
        String peselWprowadzony = scanner.nextLine();
        if(peselWprowadzony.length() != 11){
            System.out.println("Wprowadziłeś niepoprawny PESEL(poprawny zawiera 11 cyfr)");
        }else{
            int[] pesel = new int[11];
            for (int i = 0; i < peselWprowadzony.length(); i++){
                pesel[i] = peselWprowadzony.charAt(i) - '0';
            }
            if(sprawdzPlec(pesel) == 'K'){
                System.out.println("Płeć: Kobieta");
            }else{
                System.out.println("Płeć: Mężczyzna");
            }
            if(sprawdzSumeKontrolna(pesel)){
                System.out.println("Wprowadzony PESEL jest prawdziwy, suma kontrolna się zgadza ;D");
            }else{
                System.out.println("Wprowadzony PESEL nie jest prawdziwy, ponieważ suma kontrolna się nie zgadza ;c");
            }
        }
    }
}