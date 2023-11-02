package P4;

import java.time.LocalDate;

public class Persoana {
    private String Nume;
    private String CNP;

    public Persoana(String Nume, String CNP) {
        this.Nume = Nume;
        this.CNP = CNP;
    }

    public String getNume() {
        return Nume;
    }

    public String getCNP() {
        return CNP;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public int getVarsta(){

        //aflarea anului, lunii, si zilei de nastere din cnp
        int an= Integer.parseInt(CNP.substring(1,3));
        int luna= Integer.parseInt(CNP.substring(3,5));
        int zi= Integer.parseInt(CNP.substring(5,7));

        //crearea unor var LocalDate care tine minte ziua de nastere si ziua de azi
        LocalDate ziDeNastere= LocalDate.of(2000 + an,luna,zi);
        LocalDate ziCurenta= LocalDate.now();

        //calculul varstei si returnarea lui
        return ziCurenta.getYear() - ziDeNastere.getYear();

    }
    @Override
    //overrite la functia toString pentru a ne scrie ce avem nevoie
    public String toString(){
        return Nume + ", " + CNP + ", " + getVarsta() + " ani";
    }
}
