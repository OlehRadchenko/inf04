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

namespace Pracowniki
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public string hasloString = "";
        public MainWindow()
        {
            InitializeComponent();
        }
        private void GeneratePass(object sender, RoutedEventArgs e)
        {
            int dlugoscHasla = int.Parse(ileZnakow.Text);
            hasloString = "";
            char[] haslo = new char[dlugoscHasla];
            string maleLitery = "qwertyuiopasdfghjklzxcvbnm";
            string duzeLitery = "QWERTYUIOPASDFGHJKLZXCVBNM";
            string cyfry = "1234567890";
            string specjalne = "!@#$%^&*()_+-=";
            Random r = new Random();
            for(int i=0; i<dlugoscHasla; i++)
            {
                haslo[i] = ' ';
            }
            if(cyfryCheckBox.IsChecked == true)
            {
                haslo[0] = cyfry[r.Next(0, cyfry.Length - 1)];
            }
            if(znakiSpecjalneCheckBox.IsChecked == true)
            {
                haslo[1] = specjalne[r.Next(0, specjalne.Length - 1)];
            }
            if(maleDuzeLiteryCheckBox.IsChecked == true)
            {
                haslo[r.Next(2, dlugoscHasla)] = duzeLitery[r.Next(0, duzeLitery.Length - 1)];
            }
            for(int i=0; i<dlugoscHasla; i++)
            {
                if (haslo[i] == ' ')
                {
                    haslo[i] = maleLitery[r.Next(0, maleLitery.Length - 1)];
                }
                hasloString += haslo[i];
            }
            MessageBox.Show(hasloString);
        }

        private void ZatwierdzClick(object sender, RoutedEventArgs e)
        {
            MessageBox.Show("Dane pracownika: "+imie.Text+" "+nazwisko.Text+" "+stanowisko.Text+" Hasło: "+hasloString);
        }
    }
}
