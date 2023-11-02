package P3;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        //initilazrea scanner-ului pentru citit de la tastatura
        Scanner scan= new Scanner(System.in);

        //citirea sirului 1
        System.out.println("Introduceti sirul 1: ");
        String sir_1= scan.nextLine();

        //citirea sirului 2
        System.out.println("Introduceti sirul 2: ");
        String sir_2= scan.nextLine();

        String sir_3= "";
        //String sir_3= new String(""); // ii inutil asa

        //introducerea pozitia unde se doreste inserarea
        System.out.print("Introduceti pozitia la care doriti sa inserati sirul 2: ");
        int poz= scan.nextInt();

        //crearea si afisarea sirului concatenat
        sir_3 = sir_1.substring(0, poz) + sir_2 + sir_1.substring(poz); // nu trebe pana la sir_1.length();
        System.out.println(sir_3);

        //initializare unui sir auxiliar pentru stergere
        StringBuilder aux= new StringBuilder(sir_3);

        //inducerea intervalului pentru stergere
        System.out.println("Introduceti pozitia de la care incepe stergerea: ");
        int poz_inc= scan.nextInt();
        System.out.println("Introduceti pozitia de la care se ternmina stergerea: ");
        int poz_fin= scan.nextInt();

        //stergerea secventei si afisarea noului sir
        aux.delete(poz_inc,poz_fin);
        System.out.println(aux);

        scan.close();
    }
}
