import java.io.*;
import java.util.ArrayList;
import java.io.IOException;

public class CreerfichierHTML {
    public static void main(String[] args) {
        // Spécifie le nom du fichier HTML
        String nomFichier = "/src/index.html";

        // Le contenu HTML à écrire dans le fichier
        String head = "<!DOCTYPE html>\n<html lang=\"fr\">\n<head>\n\t<meta charset=\"UTF-8\">\n\t<title>Ma Page HTML</title>\n</head>\n<body>\n";

        // Utilisation d'une ArrayList pour concaténer le contenu du body
        ArrayList<String> contenuBody = new ArrayList<>();
        contenuBody.add("<h1>Bienvenue sur ma page !</h1>");
        contenuBody.add("<p>C'est un paragrahe</p>");
        contenuBody.add("<ul>");
        contenuBody.add("<li>liste 1</li>");
        contenuBody.add("<li>liste 2</li>");
        contenuBody.add("</ul>");

        // La fermeture de la balise body et html
        String footer = "</body>\n</html>";

        // Créer ou ouvrir le fichier HTML
        creerFichierHTML(nomFichier, head, contenuBody, footer);
    }
    public static void creerFichierHTML(String nomFichier, String head, ArrayList<String> contenuBody, String footer) {
        // Créer ou ouvrir le fichier HTML
        try {
            // Créer un objet File pour le fichier
            File file = new File("index.html");
            if(file.createNewFile()) {
                System.out.println("File created");
            }else {
                System.out.println("File already exists");
            }
            // Utiliser FileWriter pour écrire dans un fichier
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Ecrire l'en-tête HTML
            bufferedWriter.write(head);
            // Ajouter le contenu du corps de la page
            for (int i = 0; i < contenuBody.size(); i++) {
                bufferedWriter.write("\t" + contenuBody.get(i) + "\n");
            }
            // Ajouter le pied de la page (fermeture de la balise HTML)
            bufferedWriter.write(footer);

            // Fermer le bufferWriter pour enregistrer le fichier
            bufferedWriter.close();
            System.out.println("Le fichier HTML a été crée avec succès !");
        } catch (IOException e) {
            System.out.println("Une erreur est survenue lors de la création du fichier");
            e.printStackTrace();
        }
    }
}
