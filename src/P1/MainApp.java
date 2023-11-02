package P1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws FileNotFoundException {

        //initializare sir-u de cuvinte si scanner
        Scanner scan= new Scanner(new File("judete.in"));
        String[] sir= new String[100];

        //citirea liniilor din fisier
        int i= 0;
        while(scan.hasNext()){
            sir[i]= scan.nextLine();
            i++;
        }

        //afisarea judeterlor din fisier
        String[] copy_sir= Arrays.copyOf(sir, 9); //9 pentru ca is 9 judete in fisier
        Arrays.sort(copy_sir); //daca are un null siru nu poate sorta, exact de aia ii 9 acolo
        System.out.println(Arrays.toString(copy_sir));

        //initializare judetului de cautat
        Scanner scan_cuvant= new Scanner(System.in);
        String judet_cautat= new String("");

        //citirea judetului cautat
        System.out.print("Introduceti judetul pe care il cautati: ");
        judet_cautat = scan_cuvant.nextLine();

        //cautarea pozitiei judetului cautat prin binarySearch
        int poz= Arrays.binarySearch(copy_sir, judet_cautat);
        System.out.print((poz >= 0) ? ("Pozitie judet = " + (poz + 1)) : ("Judetul nu se afla in lista"));

        scan.close();
    }
}
