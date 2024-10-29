import java.util.Scanner;

public class Main {
    public static int fib(int n) throws Exception {
        if(n>1){
            return fib(n-1) + fib(n-2);
        }else if (n >= 0){
            return n;
        }else{
            throw new Exception("Nie próbuj oszukać Fibonnaciego ;<");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, wynik = 0;
        System.out.print("Podaj liczbę z której mam obliczyć ciąg fibonnaciego: ");
        n = scanner.nextInt();
        try{
            wynik = fib(n);
        }catch (Exception e){
            System.out.println(e);
            System.exit(666);
        }
        System.out.println(n + " liczba w ciągu fibonnaciego to " + wynik);
    }
}