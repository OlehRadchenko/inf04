public class Main {
    protected static void uzupelnijTablice(boolean[] tab){
        for (int i=2; i<tab.length; i++){
            tab[i] = true;
        }
    }
    public static void main(String[] args) {
        int doKtorejLiczbySzukac = 100;
        boolean[] A = new boolean[doKtorejLiczbySzukac];
        uzupelnijTablice(A);
        for (int i=2; i<Math.sqrt(A.length); i++){
            if(A[i]){
                for(int j=2; j*i<A.length; j++){
                    A[j*i] = false;
                }
            }
        }
        System.out.println("Liczby pierwsze w zakresie od 2 do "+doKtorejLiczbySzukac+":");
        for (int i=0; i<doKtorejLiczbySzukac; i++){
            if(A[i]){
                System.out.print(i+" ; ");
            }
        }
    }
}