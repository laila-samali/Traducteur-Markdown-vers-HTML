import java.io.File;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Chemin du fichier à lire
        String cheminFichier = "src/README_FR.md";

        //Test existance du fichier
        try {
            Main.getFileExist(cheminFichier);
           // System.out.println("Fichier trouvé : " + fichier.getAbsolutePath());
        } catch ( Exception e){

            System.out.println("Fichier non trouvé : " + new File(e.getMessage()).getAbsolutePath());
            return;
        }





        // Utilisation d'un BufferedReader pour lire le fichier
        try (BufferedReader br = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                System.out.println(ligne);

            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }



    }

    public static boolean getFileExist( String cheminFichier ) throws IOException{
        // Créer une instance de File
        File fichier = new File(cheminFichier);
        boolean find = true;
        // Vérifier si le fichier existe
        if (!fichier.exists()) {
            find = false;
            throw  new IOException(cheminFichier);
        }
        return find;

    }



}