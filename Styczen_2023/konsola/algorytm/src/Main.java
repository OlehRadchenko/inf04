import java.util.Scanner;

public class Main {
    protected static int NWD(int a, int b){
        while (a != b){
            if(a > b){
                a = a-b;
            }else{
                b = b-a;
            }
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj a: ");
        int a = scanner.nextInt();
        System.out.print("Podaj b: ");
        int b = scanner.nextInt();
        int NWD = NWD(a,b);
        System.out.println("Największy wspólny dzielnik dla liczb "+a+" i "+b+" to: "+NWD);
    }
}