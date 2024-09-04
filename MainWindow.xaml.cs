using System.Reflection.Metadata;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace INF04_Styczen_2024
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

        private void Button_Click(object sender, RoutedEventArgs e)
        {

        }

        private void Numer_LostFocus(object sender, RoutedEventArgs e)
        {
            string numer = Numer.Text;
            Imie.Text = numer;
            /*Zdjecie.Source = new BitmapImage(new Uri(@"000-zdjecie.png", UriKind.Relative));
            Odcisk.Source = new BitmapImage(new Uri(@"000-odcisk.png", UriKind.Relative));*/
        }
    }
}