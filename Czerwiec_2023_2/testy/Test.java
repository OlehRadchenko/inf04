import java.util.Random;

public class Test {
    public static void sort(int[] liczby){
        int temp;
        for (int i = 0; i < liczby.length - 1; i++) {
            for (int j = 0; j < liczby.length - i - 1; j++) {
                if (liczby[j] > liczby[j + 1]) {
                    temp = liczby[j];
                    liczby[j] = liczby[j + 1];
                    liczby[j + 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Random random = new Random();
        int[] liczby = new int[100];
        for(int i = 0; i < liczby.length; i++){
            liczby[i] = random.nextInt(0,1000);
        }
        sort(liczby);
        System.out.println("Posortowana tablica: ");
        for(int i = 0; i < liczby.length; i++){
            if (i == liczby.length-1){
                System.out.print(liczby[i]);
            }else{
                System.out.print(liczby[i] + " < ");
            }

        }
    }
}