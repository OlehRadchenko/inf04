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

namespace Zdjecia
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public int piesnr1;
        public int piesnr2;
        public int piesnr3;

        public MainWindow()
        {
            InitializeComponent();
        }
        private void prev(object sender, RoutedEventArgs e)
        {
            int[] piesnry = { piesnr1, piesnr2, piesnr3 };
            for (int i = 0; i < piesnry.Length; i++)
            {
                piesnry[i]--;
                if (piesnry[i] <= 0)
                {
                    piesnry[i] = 10;
                }
            }
            piesnr1 = piesnry[0];
            piesnr2 = piesnry[1];
            piesnr3 = piesnry[2];
            zaaktualizujZdjecia();
        }
        private void next(object sender, RoutedEventArgs e)
        {
            int[] piesnry = { piesnr1, piesnr2, piesnr3 };
            for (int i = 0; i < piesnry.Length; i++)
            {
                piesnry[i]++;
                if (piesnry[i] > 10)
                {
                    piesnry[i] = 1;
                }
            }
            piesnr1 = piesnry[0];
            piesnr2 = piesnry[1];
            piesnr3 = piesnry[2];
            zaaktualizujZdjecia();
        }


        private void prev1(object sender, RoutedEventArgs e)
        {
            if(piesnr1 > 1)
            {
                piesnr1--;
            }
            else
            {
                piesnr1 = 10;
            }
            image1.Source = new BitmapImage(new Uri("pies" + piesnr1 + ".png", UriKind.Relative));
        }
        private void next1(object sender, RoutedEventArgs e)
        {
            if (piesnr1 < 10)
            {
                piesnr1++;
            }
            else
            {
                piesnr1 = 1;
            }
            image1.Source = new BitmapImage(new Uri("pies" + piesnr1 + ".png", UriKind.Relative));
        }
        private void prev2(object sender, RoutedEventArgs e)
        {
            if (piesnr2 > 1)
            {
                piesnr2--;
            }
            else
            {
                piesnr2 = 10;
            }
            image2.Source = new BitmapImage(new Uri("pies" + piesnr2 + ".png", UriKind.Relative));
        }
        private void next2(object sender, RoutedEventArgs e)
        {
            if (piesnr2 < 10)
            {
                piesnr2++;
            }
            else
            {
                piesnr2 = 1;
            }
            image2.Source = new BitmapImage(new Uri("pies" + piesnr2 + ".png", UriKind.Relative));
        }
        private void prev3(object sender, RoutedEventArgs e)
        {
            if (piesnr3 > 1)
            {
                piesnr3--;
            }
            else
            {
                piesnr3 = 10;
            }
            image3.Source = new BitmapImage(new Uri("pies" + piesnr3 + ".png", UriKind.Relative));
        }
        private void next3(object sender, RoutedEventArgs e)
        {
            if (piesnr3 < 10)
            {
                piesnr3++;
            }
            else
            {
                piesnr3 = 1;
            }
            image3.Source = new BitmapImage(new Uri("pies" + piesnr3 + ".png", UriKind.Relative));
        }

        private void modeChecked(object sender, RoutedEventArgs e)
        {
            bigNext.Visibility = Visibility.Visible;
            bigPrev.Visibility = Visibility.Visible;
            smallNext1.Visibility = Visibility.Hidden;
            smallPrev1.Visibility = Visibility.Hidden;
            smallNext2.Visibility = Visibility.Hidden;
            smallPrev2.Visibility = Visibility.Hidden;
            smallNext3.Visibility = Visibility.Hidden;
            smallPrev3.Visibility = Visibility.Hidden;
            piesnr1 = 1;
            piesnr2 = 2;
            piesnr3 = 3;
            zaaktualizujZdjecia();
        }
        private void modeUnchecked(object sender, RoutedEventArgs e)
        {
            bigNext.Visibility = Visibility.Hidden;
            bigPrev.Visibility = Visibility.Hidden;
            smallNext1.Visibility = Visibility.Visible;
            smallPrev1.Visibility = Visibility.Visible;
            smallNext2.Visibility = Visibility.Visible;
            smallPrev2.Visibility = Visibility.Visible;
            smallNext3.Visibility = Visibility.Visible;
            smallPrev3.Visibility = Visibility.Visible;
            Random rand = new Random();
            piesnr1 = rand.Next(10) + 1;
            piesnr2 = rand.Next(10) + 1;
            piesnr3 = rand.Next(10) + 1;
            zaaktualizujZdjecia();
        }
        private void zaaktualizujZdjecia()
        {
            image1.Source = new BitmapImage(new Uri("pies" + piesnr1 + ".png", UriKind.Relative));
            image2.Source = new BitmapImage(new Uri("pies" + piesnr2 + ".png", UriKind.Relative));
            image3.Source = new BitmapImage(new Uri("pies" + piesnr3 + ".png", UriKind.Relative));
        }
    }
}
