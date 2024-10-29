import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int[] tab = new int[51];
    private static int przeszukaj(int[] liczby){
        int szukana = liczby[liczby.length-1];
        int i = 0;
        while (liczby[i] != szukana){
            i++;
        }
        return i;
    }
    private static void losowanie_liczb(){
        Random random = new Random();
        for(int i=0; i<tab.length-1; i++){
            tab[i] = random.nextInt(1, 101);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        losowanie_liczb();
        System.out.print("Podaj liczbę jaką mam znaleźć: ");
        tab[tab.length-1] = scanner.nextInt();
        int szukany_index = przeszukaj(tab);
        System.out.print("Tablica wygląda tak: [ ");
        for(int i=0; i<tab.length-1; i++){
            if(i+2 == tab.length){
                System.out.print(tab[i]);
            }else{
                System.out.print(tab[i]+", ");
            }
        }
        System.out.println(" ];");
        if (szukany_index == 50){
            System.out.println("W tej tablicy nie ma szukanej liczby ;c");
        }else{
            System.out.println("Szukana liczba jest na "+szukany_index+" miejscu w tablicy");
        }
    }
}