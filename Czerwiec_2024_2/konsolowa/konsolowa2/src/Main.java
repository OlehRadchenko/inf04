import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Main {
    private static List<Album> albums = new ArrayList<>();
    private static void wczytaj(){
        try {
            FileReader fr = new FileReader(new File("src/Data.txt"));
            BufferedReader bfr = new BufferedReader(fr);
            List<String> lines = new ArrayList<>();
            String line;
            while((line = bfr.readLine()) != null){
                line = line.replace("\uFEFF", "");
                lines.add(line);
            }
            bfr.close();
            for(int i=0; i<(lines.size()+1); i+=6){
                albums.add(new Album(lines.get(i), lines.get(i+1),parseInt(lines.get(i+2)),parseInt(lines.get(i+3)),parseInt(lines.get(i+4))));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Plik nie istnieje");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void wyswietl(){
        for(int i=0; i<albums.size(); i++){
            System.out.println(albums.get(i).wypisz());
        }
    }
    public static void main(String[] args) {
        wczytaj();
        wyswietl();
    }
}