package P2;

import java.io.*;

public class MainApp {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("cantec_in.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("cantec_out.txt"));

            String line;
            while((line = reader.readLine()) != null){
                Vers vers = new Vers(line);

                //String formatedVers = vers.formatareVers();
                //writer.write(formatedVers);
                writer.write(vers.formatareVers());
                writer.newLine();
            }

            reader.close();
            writer.close();
            System.out.println("S-a actualizat fisierul de iesire!!!");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
