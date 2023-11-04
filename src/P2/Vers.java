package P2;

import java.util.Random;

public class Vers {
    private String vers;

    public Vers(String vers) {
        this.vers = vers;
    }

    public String getVers() {
        return vers;
    }

    public void setVers(String vers) {
        this.vers = vers;
    }

    public int numarCuvinte(){
        String[] cuvinte = vers.split("\\s+");
        return cuvinte.length;
    }

    public int numarVocale(){
        int k = 0;
        for(char c: vers.toCharArray()) {
            if("AEIOUaeiou".indexOf(c) >= 0) {
                k++;
            }
        }
        return k;
    }

    public String formatareVers(){
        int randomValue = new Random().nextInt(100) / 100.0 < 0.1 ? 1 : 0;
        String formatedVers = vers;
        if(formatedVers.matches(".*ret\\b")){
            formatedVers += " *";
        }
        if(randomValue == 1){
            formatedVers = formatedVers.toUpperCase();
        }
        formatedVers += " [ " + numarCuvinte() + " cuvinte, " + numarVocale() + " numar vocale]";
        return formatedVers;
    }
}
