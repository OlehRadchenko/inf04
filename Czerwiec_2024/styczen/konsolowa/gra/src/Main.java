import java.util.Random;
import java.util.Scanner;

public class Main {
    protected static int[] rzucKosci(int n){
        Random random = new Random();
        int[] wyrzuconeKosci = new int[n];
        for(int i=0; i<n; i++){
            wyrzuconeKosci[i] = random.nextInt(1,7);
        }
        return wyrzuconeKosci;
    }
    protected static int obliczSumePunktow(int[] kosci){
        int[] oczka = new int[6];
        int punkty = 0;
        for(int i=0; i<kosci.length; i++){
            oczka[kosci[i]-1]++;
        }
        for (int i=0; i<oczka.length; i++){
            if(oczka[i] > 1){
                punkty+=(i+1)*oczka[i];
            }
        }
        return punkty;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String powtorz = "t";
        int liczbaKosci;
        while (powtorz.equals("t")){
            liczbaKosci = 0;
            while(liczbaKosci < 3 || liczbaKosci > 10){
                System.out.println("Ile kostek chcesz rzucić?(3 - 10)");
                liczbaKosci = scanner.nextInt();
            }
            int[] wylosowaneKosci = rzucKosci(liczbaKosci);
            for(int i=0; i<wylosowaneKosci.length; i++){
                System.out.println("Kostka "+(i+1)+": "+wylosowaneKosci[i]);
            }
            System.out.println("Liczba uzyskanych punktów: "+obliczSumePunktow(wylosowaneKosci));
            System.out.println("Jeszcze raz? (t/n)");
            scanner.nextLine(); //naprawa bug'u javy polegającym na pominięciu scaner.nextLine() w następnej linijce
            powtorz = scanner.nextLine();
        }
    }
}