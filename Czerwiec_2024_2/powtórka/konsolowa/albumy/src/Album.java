public class Album {
    protected String artist, album;
    protected int songsNumber, year, downloadNumber;

    public Album(String artist, String album, int songsNumber, int year, int downloadNumber) {
        this.artist = artist;
        this.album = album;
        this.songsNumber = songsNumber;
        this.year = year;
        this.downloadNumber = downloadNumber;
    }
    public String albumWypisz(){
        return artist+"\n"+album+"\n"+songsNumber+"\n"+year+"\n"+downloadNumber;
    }
}
