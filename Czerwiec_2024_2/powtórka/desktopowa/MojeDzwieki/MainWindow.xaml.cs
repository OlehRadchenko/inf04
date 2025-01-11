using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace MojeDzwieki
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public class Album
        {
            public string artist { get; set; }
            public string album { get; set; }
            public int songsNumber { get; set; }
            public int year { get; set; }
            public int downloadNumber { get; set; }

        }
        public Album[] albums;
        public int aktualnyAlbum;
        public void wczytaj()
        {
            string[] lines = File.ReadAllLines("src/Data.txt");
            albums = new Album[(lines.Length+1)/6];
            for(int i=0; i<lines.Length; i += 6)
            {
                Album album = new Album();
                album.artist = lines[i];
                album.album = lines[i+1];
                album.songsNumber = int.Parse(lines[i + 2]);
                album.year = int.Parse(lines[i + 3]);
                album.downloadNumber = int.Parse(lines[i + 4]);
                albums[i/6] = album;
            }
        }
        public MainWindow()
        {
            InitializeComponent();
            wczytaj();
            aktualnyAlbum = 0;
            odswiez();
        }
        public void odswiez()
        {
            artist.Content = albums[aktualnyAlbum].artist;
            album.Content = albums[aktualnyAlbum].album;
            songsNumber.Content = albums[aktualnyAlbum].songsNumber;
            year.Content = albums[aktualnyAlbum].year;
            downloadNumber.Content = albums[aktualnyAlbum].downloadNumber;
        }

        private void pobierz(object sender, RoutedEventArgs e)
        {
            albums[aktualnyAlbum].downloadNumber++;
            downloadNumber.Content = albums[aktualnyAlbum].downloadNumber;
        }
        private void odwroc(object sender, RoutedEventArgs e)
        {
            BitmapImage bitmapImage = new BitmapImage(new Uri("src/obraz2.png", UriKind.Relative));
            BitmapImage bitmapImage2 = new BitmapImage(new Uri("src/obraz3.png", UriKind.Relative));
            lewo.Source = bitmapImage;
            prawo.Source = bitmapImage2;
        }
        private void next(object sender, RoutedEventArgs e)
        {
            if(aktualnyAlbum+1 == albums.Length)
            {
                aktualnyAlbum = 0;
            }
            else
            {
                aktualnyAlbum++;
            }
            odswiez();
        }
        private void prev(object sender, RoutedEventArgs e)
        {
            if (aktualnyAlbum == 0)
            {
                aktualnyAlbum = albums.Length-1;
            }
            else
            {
                aktualnyAlbum--;
            }
            odswiez();
        }
    }
}
