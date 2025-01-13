import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = null;
        try {
            bfr = new BufferedReader(new FileReader("Data.txt"));
            bfr.read();
        } catch (FileNotFoundException e) {
            System.out.println("Taki plik nie istnieje ;c");
        }
        List<String> lines = new ArrayList<>();
        String line = "";
        while ((line = bfr.readLine()) != null){
            lines.add(line);
            System.out.println(line);
        }
    }
}