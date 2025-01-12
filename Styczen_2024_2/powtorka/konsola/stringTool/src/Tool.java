public class Tool {
    public static int liczSamogloski(String text){
        if(text.isEmpty() || text == null || text == ""){
            return 0;
        }else{
            text = text.toLowerCase();
            char[] samogloski = {'a', 'ą', 'e', 'ę', 'i', 'o', 'u', 'ó', 'y'};
            int samogloskiLiczba = 0;
            for(int i=0; i<text.length(); i++){
                for(int j=0; j<samogloski.length; j++){
                    if(text.charAt(i) == samogloski[j]){
                        samogloskiLiczba++;
                    }
                }
            }
            return samogloskiLiczba;
        }
    }
    public static String usunPowtorzenia(String text){
        String bezPowtorzen = "";
        if(text.isEmpty() || text == null || text == ""){
            return "";
        }else {
            for (int i = 0; i < text.length() - 1; i++) {
                if (text.charAt(i) != text.charAt(i + 1)) {
                    bezPowtorzen+=text.charAt(i);
                }
            }
            bezPowtorzen+=text.charAt(text.length()-1);
            return bezPowtorzen;
        }
    }
}
