import java.io.File;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Chemin du fichier à lire
        String cheminFichier = "src/README_FR.md";

        //Test existance du fichier
        try {
            Main.isExist(cheminFichier);
           // System.out.println("Fichier trouvé : " + fichier.getAbsolutePath());
        } catch ( Exception e){

            System.out.println("Fichier non trouvé : " + new File(e.getMessage()).getAbsolutePath());
            return;
        }

        ArrayList<String> contenuBody = new ArrayList<>();



        // Utilisation d'un BufferedReader pour lire le fichier
        try (BufferedReader br = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            System.out.println("les titres");
            while ((ligne = br.readLine()) != null) {
                if (DetectMarkdown.testTitre(ligne)) {
                    System.out.println(ConvertMarkdown.titleMarkdownToHTML(ligne));
                    contenuBody.add(ConvertMarkdown.titleMarkdownToHTML(ligne));
                }else{
                    contenuBody.add(ligne);

                }


            }
            CreerfichierHTML.creerFichierHTML(contenuBody);
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }



    }

    public static boolean isExist( String cheminFichier ) throws IOException{
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