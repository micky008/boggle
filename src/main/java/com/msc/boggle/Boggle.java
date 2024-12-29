package com.msc.boggle;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Michael
 */
public class Boggle {

    public static void main(String[] args) throws IOException {
        long timestart = System.currentTimeMillis();
        //char[][] grille = {{'O', 'D', 'B', 'E'}, {'X', 'I', 'N', 'E'}, {'I', 'A', 'E', 'D'}, {'O', 'E', 'V', 'N'}};
        char[][] grille = new char[4][4];
        File grilleFile = new File("./grille.txt");
        List<String> grilleString = FileUtils.readLines(grilleFile, "UTF-8");
        int x = 0;
        System.out.println("Grille:");
        for (String line : grilleString) {
            System.out.println(line);
            for (int y = 0; y < 4; y++) {
                grille[x][y] = line.charAt(y);
            }
            x++;
        }

        File allmots = new File("./ods6.txt");
        List<String> mots = FileUtils.readLines(allmots, "UTF-8");

        ManipNoeud mn = ManipNoeud.getInstance();
        for (String mot : mots) {
            mn.addMotEntier(mot);
        }

        mots.clear();

        Algo algo = new Algo(grille);
        algo.resolv();

        System.out.println("");
        System.out.println("mots trouvés: " + algo.getAllFindingMots().size());

        for (String mot : algo.getAllFindingMots()) {
            System.out.println(mot);
        }

        System.out.println("Temps d'éxecution: " + (System.currentTimeMillis() - timestart) + " ms");

    }
}
