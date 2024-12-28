/*************************************************
 klasa: Tool
 opis: Reprezentuje narzędzie do zliczania samogłosek w zdaniu/wyrazie oraz usuwania powtarzających się znaków
 metody: liczSamogloski - zwraca liczbę samogłosek w napisie który został przekazany jako parametr napis o typie String
 usunPowtorzenia - zwraca zmodyfikowany ciąg znaków(bez powtarzających się obok siebie znaków)
 autor: Oleh Radchenko
 *************************************************/
public class Tool {
    public static int liczSamogloski(String napis){
        if(napis == null || napis == "" || napis.isEmpty()){
            return 0;
        }else{
            int iloscSamoglosek = 0;
            napis = napis.toLowerCase();
            for(int i=0; i<napis.length(); i++){
                char znak = napis.charAt(i);
                if (znak == 'a' || znak == '\u0105' || znak == 'e' || znak == '\u0119' || znak == 'i' || znak == 'o' || znak == 'u' || znak == '\u00F3' || znak == 'y') {
                    iloscSamoglosek++;
                }
            }
            return iloscSamoglosek;
        }
    }

    public static String usunPowtorzenia(String napis){
        if(napis == null || napis == "" || napis.isEmpty()){
            return "";
        }else{
            String newString = ""+napis.charAt(0);
            for(int i=1; i<napis.length(); i++){
                if(napis.charAt(i) != napis.charAt(i-1)){
                    newString += napis.charAt(i);
                }
            }
            return newString;
        }
    }
}
