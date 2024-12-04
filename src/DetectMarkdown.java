import java.util.Arrays;
import java.util.regex.*;
public class DetectMarkdown {
    public static void main (String [] args)
    {
        String [] lignes = {
                "## **Titre 1**",
                "## Titre 2",
                "**Une ligne**",
                "****"
        };
        // Vérifie si le texte contient du  gras
        boolean texteContientGras = false;
        for (int i = 0; i < lignes.length; i++) {
            /*if (contientTexteGras(lignes[i])) {
                texteContientGras = true;
                break; // Pas besoin de continuer si du gras est trouvé
            }*/
            System.out.println(lignes[i]);
            System.out.println(isBold(lignes[i]));
        }

        /*

        if(texteContientGras){
            System.out.println("Le texte contient du gras.");
        } else {
            System.out.println("Le texte ne contient pas du gras.");
        }*/

        //System.out.println(testTitre(lignes[2]));
        // for(int i=0; i<lignes.length; i++)
        // {
        //     System.out.println(lignes[i]);
        //     String ligne = lignes[i];
        //     if(ligne.matches("^#{1,6} [a-zA-Z].*")) {
        //             System.out.println("C'est un Markdown");
        //         }
        //     else{
        //         System.out.println("Ce n'est pas un Markdown");
        //     }
        // }
    }
    static Boolean testTitre(String lignes){

        if(lignes.matches("^#{1,6} [a-zA-Z].*"))
            return true;
        else
            return false;
    }
    static  Boolean isBold(String lignes){


        String regex = "\\*\\*(.+?)\\*\\*";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(lignes);

        if (matcher.find()) {
            return true;
        }else{
            return false;
        }
    }
    static Boolean contientTexteGras(String lignes) {

        if (lignes.matches("\\*\\*(.+?)\\*\\*")) {
            return true;
        }
        else {
            return false;
        }
        // Vérifier si le texte commence par un titre (ex : # ou ##)

        //boolean estTitre = lignes.trim().startsWith("^#{1-6}");

        // Vérifier si d texte en gras est présent
       // boolean contientGras = lignes.contains("**");
        // Si le texte est un titre et contient du gras ou simplement contient du gras
        //if (estTitre & contientGras) {
         /*   System.out.println("Le texte en gras se trouve dans un titre");
            return true;
        }else if(contientGras){
            System.out.println("Le texte en gras se trouve dans le corps");
            return true;
        }
        return false;*/
    }
}