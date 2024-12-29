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

namespace Paszsport
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            if(numer.Text != "" && imie.Text != "" && nazwisko.Text != "")
            {
                string kolorOczu = "nie podano";
                if(niebieskie.IsChecked == true)
                {
                    kolorOczu = "niebieskie";
                }
                else if(zielone.IsChecked == true)
                {
                    kolorOczu = "zielone";
                }
                else if(piwne.IsChecked == true)
                {
                    kolorOczu = "piwne";
                }
                MessageBox.Show(imie.Text + " " + nazwisko.Text + " kolor oczu " + kolorOczu);
            }
            else
            {
                MessageBox.Show("Wprowadź dane");
            }
        }

        private void zmianaNumeru(object sender, RoutedEventArgs e)
        {
            string zdjecieNazwa = "/images/" + numer.Text + "-zdjecie.jpg";
            string odciskNazwa = "/images/" + numer.Text + "-odcisk.jpg";
            BitmapImage zdjecieSource = new BitmapImage(new Uri(zdjecieNazwa, UriKind.Relative));
            BitmapImage odciskSource = new BitmapImage(new Uri(odciskNazwa, UriKind.Relative));
            zdjecie.Source = zdjecieSource;
            odcisk.Source = odciskSource;
        }
    }
}
