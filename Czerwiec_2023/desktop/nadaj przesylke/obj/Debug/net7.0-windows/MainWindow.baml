   M S B A M L   `   `   `  ����J  Fnadaj przesylke, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null1clr-namespace:nadaj_przesylkenadaj_przesylke  5   	        nadaj_przesylke.MainWindow   5   	   W SPresentationCore, Version=7.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=7.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=7.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   /localclr-namespace:nadaj_przesylke     5   	     � Title$.  (Nadaj Przesyłkę, Autor: Oleh Radchenko��5   	    � SizeToContent$ WidthAndHeight=�68   $	��250��6W   .��5	      �� $
��10,0q�6   .+�5
   
   �� $��10q�6    �� Orientation$ 
Horizontal=�6!   .+�5      �� .+�5      �� $��Rodzaj przesyłki��6   $��0,0,0,10q�65   .��5      �� .+�5      	� -   5         	�Name$ 	pocztowka��5   &    d� 	IsChecked$
 TrueY�69    	� 	GroupName$ 	przesylka��6J   $��
Pocztówka��6`   $��	0,0,130,0q�6t   	� 5      -   5        $
 list��5   &   $ 	przesylka��64   $
��List��6J   	� 5      -   5        $ paczka��5   &   $ 	przesylka��66   $��Paczka��6L   5      5      �� 5      -   5        $��Sprawdź Cenę��5   -   �� 5      $ 
Horizontal=�6   .+�5      �� -   5         ��Name$ zdjecie��5      $��63��6-   $��/img/pocztowka.png��69   $
��Fill=�6U   $
��0,10q�6d   �� 5      -   5         ��Name$
 cena��5      $��Cena: ��6*   $
��Bold"�6;   $��18(�6M   $��10q�6[   5      5      �� 5      $��Dane adresowe��6   $��	70,0,0,20q�6.   .��5      �� .+�5      �� $��Ulica z numerem��6   $	��250��66   �� 5      -   5         ��Name$ ulica��5      $	��5,0q�6-   �� 5      $��Kod pocztowy��6   �� 5      -   5        $ kodPocztowy��5      $	��110��63   $
��Left=�6?   $	��5,0q�6Z   �� 5       $��Miasto��6   �� 5!      -	   5        $ miasto��5!      $	��5,0q�6.   5"      5#      5$      �� 5%   
   -
   5        $��
Zatwierdź��5%   #   $��Center=�67   $	��550��6T   5&      5'      