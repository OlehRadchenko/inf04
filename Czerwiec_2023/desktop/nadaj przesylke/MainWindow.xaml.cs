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

namespace nadaj_przesylke
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

        private void zatwierdz(object sender, RoutedEventArgs e)
        {
            string kodPocztowyString = kodPocztowy.Text;
            if(kodPocztowyString.Length != 5)
            {
                MessageBox.Show("Nieprawidłowa liczba cyfr w kodzie pocztowym");
            }else if (kodPocztowyString.All(char.IsDigit))
            {
                MessageBox.Show("Dane przesyłki zostały wprowadzone");
            }
            else
            {
                MessageBox.Show("Kod pocztowy powinien się składać z samych cyfr");
            }
        }

        private void sprawdzCene(object sender, RoutedEventArgs e)
        {
            BitmapImage bitmapImage = new BitmapImage();
            string cenaString = "Cena: ";
            if (pocztowka.IsChecked == true)
            {
                bitmapImage = new BitmapImage(new Uri("/img/pocztowka.png", UriKind.Relative));
                cenaString += "1 zł";
            }else if(list.IsChecked == true)
            {
                bitmapImage = new BitmapImage(new Uri("/img/list.png", UriKind.Relative));
                cenaString += "1,5 zł";
            }
            else if(paczka.IsChecked == true)
            {
                bitmapImage = new BitmapImage(new Uri("/img/paczka.png", UriKind.Relative));
                cenaString += "10 zł";
            }
            zdjecie.Source = bitmapImage;
            cena.Content = cenaString;
        }
    }
}
