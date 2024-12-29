using System;
using System.Collections.Generic;
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

namespace Styczen_2024
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        /***********************************************
        nazwa funkcji: Numer_LostFocus
        opis funkcji: Pobiera wprowadzoną wartość pola Numer i aktualizuje zdjęcia
        zwracany typ i opis: nie zwraca typu ;c
        autor: Oleh Radchenko
        ************************************************/
        private void Numer_LostFocus(object sender, RoutedEventArgs e)
        {
            string numer = Numer.Text;
            try
            {
                Zdjecie.Source = new BitmapImage(new Uri($"../Images/{numer}-zdjecie.png", UriKind.Relative));
                Odcisk.Source = new BitmapImage(new Uri($"../Images/{numer}-odcisk.png", UriKind.Relative));
                //MessageBox.Show("Images/" + numer + "-zdjecie.png" + "\nZdjęcie: " + Zdjecie.Source + "\nOdcisk: " + Odcisk.Source);
            }
            catch (Exception ex) {
                MessageBox.Show("Coś poszło nie tak");
            }
        }

        /***********************************************
        nazwa funkcji: Button_Click
        opis funkcji: Obsługa zdarzenia kliknięcia przycisku
        zwracany typ i opis: nie zwraca typu ;c
        autor: Oleh Radchenko
        ************************************************/
        private void Button_Click(object sender, RoutedEventArgs e)
        {
            string numer = Numer.Text.Trim();
            string imie = Imie.Text.Trim();
            string nazwisko = Nazwisko.Text.Trim();
            string kolorOczu = niebieskie.IsChecked == true ? "niebieskie" :
                   zielone.IsChecked == true ? "zielone" :
                   piwne.IsChecked == true ? "piwne" : "Brak wyboru";
            if (kolorOczu != "Brak wyboru" && numer != "" && imie != "" && nazwisko != "")
            {
                MessageBox.Show($"{imie} {nazwisko} kolor oczu {kolorOczu}");
            }
            else
            {
                MessageBox.Show("Wprowadź dane");
            }
        }
    }
}
