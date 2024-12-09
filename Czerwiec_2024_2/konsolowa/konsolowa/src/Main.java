import java.io.*;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Album> albums = List.of();
        FileReader fileReader = new FileReader(new File("src/Data.txt"));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        String[] data = new String[0];
        while ((line = bufferedReader.readLine()) != null){
            data = line.split("\\s+");
        }
        for (int i = 0; i<data.length/6; i++){
            System.out.println(data[i]);
            int num = i*6;
            albums.add(new Album(data[num], data[1+num], parseInt(data[2+num]), parseInt(data[3+num]), parseInt(data[4+num])));
        }
        for(int i=0; i<albums.size(); i++){
            Album album = albums.get(i);
            album.print();
        }
    }
}