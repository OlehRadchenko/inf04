import java.util.Scanner;

public class Main {
    protected static int[] tab = new int[10];
    public static int[] sort(int[] liczby){
        for(int i=0; i<liczby.length; i++){
            int min_index = max(liczby, i);
            int schowek = liczby[max(liczby, i)];
            liczby[min_index] = liczby[i];
            liczby[i] = schowek;
        }
        return liczby;
    }
    private static int max(int[] liczby, int startowy_index){
        int max_index = startowy_index;
        for(int i=startowy_index; i<liczby.length; i++){
            if(liczby[i] > liczby[max_index]){
                max_index = i;
            }
        }
        return max_index;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i<tab.length; i++) {
            System.out.print("Podaj liczbę " + (i + 1) + " : ");
            tab[i] = scanner.nextInt();
        }
        System.out.print("Tablica przed sortowaniem wygląda tak: [ ");
        for(int i=0; i<tab.length; i++){
            if(i+1 == tab.length){
                System.out.print(tab[i]);
            }else{
                System.out.print(tab[i]+", ");
            }
        }
        System.out.print(" ];");
        tab = sort(tab);
        System.out.print("\n\nTablica po sortowaniu wygląda tak: [ ");
        for(int i=0; i<tab.length; i++){
            if(i+1 == tab.length){
                System.out.print(tab[i]);
            }else{
                System.out.print(tab[i]+", ");
            }
        }
        System.out.print(" ];");
    }
}