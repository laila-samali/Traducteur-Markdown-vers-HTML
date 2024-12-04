import java.lang.reflect.Array;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.*;

public class ConvertMarkdown {

    public static void main(String[] args) {
        // Cas 1
        //String markdown1 = "# Titre";
        //System.out.println(titleMarkdownToHTML(markdown1)); // Résultat attendu : <h1>Titre</h1>

        // Cas 2
        //String markdown2 = "## Titre";
        //System.out.println(titleMarkdownToHTML(markdown2)); // Résultat attendu : <h2>Titre</h2>

        //Cas text en gras

        // Cas 3
        String markdown3 = "## Titre **lpmi**";
       System.out.println(boldMarkdownToHTML(markdown3));
        //System.out.println(titleMarkdownToHTML(markdown3));

        //CAs 4
        String markdown4 = "## Titre ****";
   //     System.out.println(boldMarkdownToHTML(markdown4));
   //     System.out.println(titleMarkdownToHTML(markdown4));

        //Cas 5
        String markdown5 = "## Titre ***";
    //    System.out.println(boldMarkdownToHTML(markdown5));
     //   System.out.println(titleMarkdownToHTML(markdown5));

        //Cas 6
        String markdown6 = "## Titre **";
       // System.out.println(boldMarkdownToHTML(markdown6));
        //System.out.println(titleMarkdownToHTML(markdown6));
    }



    //extrait le contenu de la balise Markdown
    public static String extract(String markdown, String typeToExctract) {
        String regex = "";

        switch (typeToExctract) {
            case "titre":
                // Expression régulière pour détecter # - ######
                regex = "^#{1,6} ";
                break;
            case "bold":
                regex = "\\*\\*(.+?)\\*\\*";
                break;
            default:
                return "";
        }

        // Compiler et chercher des correspondances
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(markdown);

        if (matcher.find()) {
            return matcher.group().trim(); // Retourne le contenu capturé (sans les **)
        }

        return ""; // Retour vide si aucune correspondance

    }

    //convert un titre markdown en titre html
    public static String titleMarkdownToHTML(String markdown) {
        String prefix = extract(markdown, "titre");
        int nbr = prefix.length();

        // Supprime le préfixe Markdown
        String title = markdown.replaceFirst("^#{1,6} ", "").trim();

        // Génère le titre HTML
        if (nbr >= 1 && nbr <= 6) {
            return "<h" + nbr + ">" + title + "</h" + nbr + ">";
        }

        // Valeur par défaut pour les cas invalides
        return "<h1>" + title + "</h1>";



    }
    // Convertit le texte en gras Markdown en HTML
    public static String boldMarkdownToHTML(String markdown) {
        String boldMarkdown = extract(markdown, "bold");

        if (!boldMarkdown.isEmpty()) {
            boldMarkdown = boldMarkdown.substring(2, boldMarkdown.length() - 2);
            // Crée la balise HTML pour le texte en gras
             String boldHtml = "<strong>" + boldMarkdown + "</strong>"
            // Remplace la balise Markdown par HTML
            markdown = markdown.replaceFirst("\\*\\*"+boldMarkdown+"\\*\\*", boldHtml);
        }
/*

"\\*\\*" + Pattern.quote(boldMarkdown) + "\\*\\*",

 */
        return markdown;
    }

    }





