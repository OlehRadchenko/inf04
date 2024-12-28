import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Wprowdź zdanie które mam przetestować: ");
        String s = scanner.nextLine();
        System.out.println("Liczba samogłosek w tym zdaniu: "+Tool.liczSamogloski(s));
        System.out.println("A tak zdanie wygląda bez powtórzeń: "+Tool.usunPowtorzenia(s));

        /*System.out.println(Tool.liczSamogloski("Ala ma kota")); // Wynik: 5
        System.out.println(Tool.liczSamogloski("Żółw ĄĘÓ")); // Wynik: 3 ale wychodzi 0 bo java nie umie w poslkie znaki ;c
        System.out.println(Tool.liczSamogloski("")); // Wynik: 0
        System.out.println(Tool.liczSamogloski(null)); // Wynik: 0

        System.out.println(Tool.usunPowtorzenia("Przykład  tekstu")); // Wynik: "Przykład tekstu"
        System.out.println(Tool.usunPowtorzenia("Abba;;;to zespół")); // Wynik: "Aba;to zespół"
        System.out.println(Tool.usunPowtorzenia("aaabbbcccdde")); // Wynik: "abcde"
        System.out.println(Tool.usunPowtorzenia("aabbccddeeffgghh")); // Wynik: "abcdefgh"*/
    }
}