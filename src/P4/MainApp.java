package P4;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        //cream scannerul de citire
        Scanner scan = new Scanner(System.in);

        //citim numarul de persoane
        System.out.print("Introduceti numarul de persoane (n): ");
        int n= scan.nextInt();

        //dam un nextLine ca daca nu, nu o sa citeasca primul nume
        scan.nextLine(); //echivalent cin.get()

        //cream vectorul de persoane
        Persoana[] pers= new Persoana[n];

        //luam fiecare n persoana in parte
        for(int i= 0; i < n; i++){
            System.out.println("Introduceti datele pentru persoana #" +  (i + 1) + ": ");

            //citim numele fiecarei persoane
            System.out.print("Nume: ");
            String Nume= scan.nextLine();

            //citim CNP-ul fiecarei persoane
            String CNP;
            boolean validCNP= false;

            //validarea CNP-ului
            do{
                System.out.print("CNP (13 cifre): ");
                CNP= scan.nextLine();
                validCNP= isValidCNP(CNP);
                if(!validCNP){
                    System.out.println("CNP invalid. Introduceti unul nou!!");
                }
            }while(!validCNP);

            //cream obiectele de tip persoana
            pers[i] = new Persoana(Nume, CNP);

            //aternativa de scriere a fiecarei persoane
            //int Varsta = pers[i].getVarsta();
            //System.out.print("Nume: " + Nume);
            //System.out.print(" CNP: " + CNP);
            //System.out.print(" Varsta: " + Varsta);

            //scrierea fiecarei persoane folosind functia Overrited toString()
            System.out.println("------------------------");
            System.out.println(pers[i].toString());
            System.out.println("------------------------");
            System.out.println();

        }

        scan.close();
    }

    //validare CNP pentru primele 9 cifre + cealalta validare
    public static boolean isValidCNP(String CNP){
        return CNP.matches("[1-256][0-9]{12}") && isValidControlDigit(CNP);
    }

    //validam ultimele 4 cifre prin formatul romanesc de CNP
    public static boolean isValidControlDigit(String CNP){
        int[] weights= {2,7,9,1,4,6,3,5,8,2,7,9};
        int controlDigit= Integer.parseInt(String.valueOf(CNP.charAt(12)));
        int computedControlDigit= 0;
        for(int i= 0; i < 12; i++){
            int digit = Integer.parseInt(String.valueOf(CNP.charAt(i)));
            computedControlDigit += digit * weights[i];
        }
        computedControlDigit %= 11;
        if(computedControlDigit == 10)
            computedControlDigit= 1;

        return computedControlDigit == controlDigit;
    }
}
