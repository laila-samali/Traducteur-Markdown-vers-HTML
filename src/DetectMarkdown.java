import java.util.regex.*;
public class DetectMarkdown {
        public static void main (String [] args)
        {
            String [] lignes = {
                    "# Titre 1",
                    "## Titre 2",
                    "Une ligne"
            };

            System.out.println(testTitre(lignes[2]));
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
}
