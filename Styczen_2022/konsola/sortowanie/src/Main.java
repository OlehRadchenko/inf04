import java.util.Scanner;

public class Main {
    protected static int[] liczby = new int[10];
    public static void sortuj(){
        for(int i = 0; i < liczby.length; i++){
            int maxIndex = znajdzMax(i);
            int max = liczby[maxIndex];
            liczby[maxIndex] = liczby[i];
            liczby[i] = max;
        }
    }
    private static int znajdzMax(int poczatek){
        int max = liczby[poczatek];
        int indexMax = poczatek;
        for(int i = poczatek; i < liczby.length; i++){
            if(liczby[i] > max){
                max = liczby[i];
                indexMax = i;
            }
        }
        return indexMax;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < liczby.length; i++){
            System.out.print("Podaj liczbę "+(i+1)+": ");
            liczby[i] = scanner.nextInt();
        }
        sortuj();
        System.out.println("Posortowana tablica wygląda tak: ");
        for (int i = 0; i < liczby.length; i++){
            System.out.println(liczby[i]);
        }
    }
}