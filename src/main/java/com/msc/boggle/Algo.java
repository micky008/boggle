package com.msc.boggle;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Michael
 */
public class Algo {

    private Set<String> mots = new TreeSet<>();

    private static final char RIEN = '-';
    private static final char KO = '*';

    private final char[][] grille;
    private char[][] grilleEnCours = {{RIEN, RIEN, RIEN, RIEN}, {RIEN, RIEN, RIEN, RIEN}, {RIEN, RIEN, RIEN, RIEN}, {RIEN, RIEN, RIEN, RIEN}};
    private final char[][] grilleOriginal = {{RIEN, RIEN, RIEN, RIEN}, {RIEN, RIEN, RIEN, RIEN}, {RIEN, RIEN, RIEN, RIEN}, {RIEN, RIEN, RIEN, RIEN}};

    private final ManipNoeud noeud = ManipNoeud.getInstance();

    public Algo(char[][] grille) {
        this.grille = grille;
    }

    public void resolv() {
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                recurs(x, y, "");
                grilleEnCours = grilleOriginal;
            }
        }
    }

    public Set<String> getAllFindingMots() {
        return mots;
    }

    private void recurs(int x, int y, String mot) {
        grilleEnCours[x][y] = grille[x][y];
        mot += grille[x][y];
        if (!noeud.exist(mot)) {
            grilleEnCours[x][y] = KO;
            return;
        }
        if (mot.length() > 2 && noeud.isMotComplet(mot)) {
            mots.add(mot);
        }
        if (casePossible(x - 1, y - 1)) {
            recurs(x - 1, y - 1, mot);
            grilleEnCours[x - 1][y - 1] = RIEN;
        }
        if (casePossible(x, y - 1)) {
            recurs(x, y - 1, mot);
            grilleEnCours[x][y - 1] = RIEN;
        }
        if (casePossible(x + 1, y - 1)) {
            recurs(x + 1, y - 1, mot);
            grilleEnCours[x + 1][y - 1] = RIEN;
        }
        if (casePossible(x - 1, y)) {
            recurs(x - 1, y, mot);
            grilleEnCours[x - 1][y] = RIEN;
        }
        if (casePossible(x + 1, y)) {
            recurs(x + 1, y, mot);
            grilleEnCours[x + 1][y] = RIEN;
        }
        if (casePossible(x - 1, y + 1)) {
            recurs(x - 1, y + 1, mot);
            grilleEnCours[x - 1][y + 1] = RIEN;
        }
        if (casePossible(x, y + 1)) {
            recurs(x, y + 1, mot);
            grilleEnCours[x][y + 1] = RIEN;
        }
        if (casePossible(x + 1, y + 1)) {
            recurs(x + 1, y + 1, mot);
            grilleEnCours[x + 1][y + 1] = RIEN;
        }
        grilleEnCours[x][y] = RIEN;
    }

    private boolean dejavisite(int x, int y) {
        return grilleEnCours[x][y] != RIEN;
    }

    private boolean casePossible(int x, int y) {
        if (x < 0 || y < 0) {
            return false;
        }
        if (x > 3 || y > 3) {
            return false;
        }
        if (dejavisite(x, y)) {
            return false;
        }
        return true;
    }

}
