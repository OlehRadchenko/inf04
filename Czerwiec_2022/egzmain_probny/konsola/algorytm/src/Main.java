import java.util.Random;
import java.util.Scanner;

public class Main {
    protected static int[] liczby = new int[51];
    protected static void wylosujLiczby(){
        Random random = new Random();
        for (int i=0; i<liczby.length-1; i++){
            liczby[i] = random.nextInt(1, 101);
        }
    }
    protected static int wyszukajElement(int element){
        liczby[liczby.length-1] = element;
        for(int i=0; i<liczby.length; i++){
            if(liczby[i] == element){
                return i;
            }
        }
        return liczby.length-1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        wylosujLiczby();
        System.out.print("Jaką liczbę mam szukać? -> ");
        int szukana = scanner.nextInt();
        int indexSzukanej = wyszukajElement(szukana);
        for(int i=0; i<liczby.length; i++){
            if(i==liczby.length-1){
                if(indexSzukanej == liczby.length-1){
                    System.out.println(liczby[i] + " \nAle nie udało się znaleźć wartości szukanej");
                }else{
                    System.out.println(liczby[i] + " \nIndex wartości szukanej to: " + indexSzukanej);
                }
            }else{
                System.out.print(liczby[i] + ", ");
            }
        }
    }
}