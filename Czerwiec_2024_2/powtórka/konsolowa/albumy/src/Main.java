import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    protected static List<Album> albums = new ArrayList();
    public static void wczytaj(){
        try{
            BufferedReader bfr = new BufferedReader(new FileReader("src/Data.txt"));
            bfr.read();
            String line;
            int i = 0;
            String[] albumData = new String[6];
            while((line = bfr.readLine()) != null){
                albumData[i] = line;
                if(i == 4){
                    albums.add(new Album(albumData[0], albumData[1], Integer.parseInt(albumData[2]), Integer.parseInt(albumData[3]), Integer.parseInt(albumData[4])));
                    i++;
                }else if(i == 5){
                    i = 0;
                }else{
                    i++;
                }
            }
        }catch (Exception e){
            System.out.println("Exception: " + e);
        }
    }
    public static void wypisz(){
        for (int i = 0; i<albums.size(); i++){
            System.out.println(albums.get(i).albumWypisz()+"\n");
        }
    }
    public static void main(String[] args) {
        wczytaj();
        wypisz();
    }
}