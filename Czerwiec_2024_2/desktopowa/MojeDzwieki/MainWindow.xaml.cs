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
    public partial class MainWindow : Window
    {
        public int aktualnyAlbum;
        public List<Album> albums;
        public class Album
        {
            public string artist { get; set; }
            public string album { get; set; }
            public int songsNumber { get; set; }
            public int year { get; set; }
            public int downloadNumber { get; set; }

        }
        
        public MainWindow()
        {
            InitializeComponent();
            albums = new List<Album>();
            try
            {
                var lines = File.ReadAllLines("Data.txt");
                for (var i = 0; i < lines.Length; i += 6)
                {
                    albums.Add(new Album
                    {
                        artist = lines[i],
                        album = lines[i + 1],
                        songsNumber = int.Parse(lines[i + 2]),
                        year = int.Parse(lines[i + 3]),
                        downloadNumber = int.Parse(lines[i + 4])
                    });
                }
            }catch (Exception ex)
            {
                Console.WriteLine($"Błąd podczas odczytu pliku: {ex.Message}");
            }
            aktualnyAlbum = 0;
            ZaaktualizujWyglad();
        }
        public void ZaaktualizujWyglad()
        {
            if(albums != null)
            {
                if (aktualnyAlbum < 0)
                {
                    aktualnyAlbum = albums.Count - 1;
                }
                else if (aktualnyAlbum == albums.Count)
                {
                    aktualnyAlbum = 0;
                }
                artist.Content = albums[aktualnyAlbum].artist;
                album.Content = albums[aktualnyAlbum].album;
                songsNumber.Content = albums[aktualnyAlbum].songsNumber;
                year.Content = albums[aktualnyAlbum].year;
                downloadNumber.Content = albums[aktualnyAlbum].downloadNumber;
            }
        }
        private void Prev(object sender, RoutedEventArgs e)
        {
            aktualnyAlbum--;
            ZaaktualizujWyglad();
        }
        private void Next(object sender, RoutedEventArgs e)
        {
            aktualnyAlbum++;
            ZaaktualizujWyglad();
        }
        private void Pobierz(object sender, RoutedEventArgs e)
        {
            albums[aktualnyAlbum].downloadNumber++;
            ZaaktualizujWyglad();
        }
    }
}
