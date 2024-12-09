public class Album{
    private String artist, album;
    private int songsNumber, year, downloadNumber;

    public Album(String artist, String album, int songsNumber, int year, int downloadNumber) {
        this.artist = artist;
        this.album = album;
        this.songsNumber = songsNumber;
        this.year = year;
        this.downloadNumber = downloadNumber;
    }

    public void print() {
        System.out.println("Album{" +
                "artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", songsNumber=" + songsNumber +
                ", year=" + year +
                ", downloadNumber=" + downloadNumber +
                '}');
    }
}
