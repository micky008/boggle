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

    private final char[][] grille;

    private ManipNoeud noeud = ManipNoeud.getInstance();

    public Algo(char[][] grille) {
        this.grille = grille;
    }

    public void resolv() {
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                recurs(x, y, "");
            }
        }
    }
    
    public Set<String> getAllFindingMots() {
        return mots;
    }

    private void recurs(int x, int y, String mot) {
        mot += grille[x][y];
        if (!noeud.exist(mot)) {
            return;
        }
        if (mot.length() > 2 && noeud.isMotComplet(mot)) {
            mots.add(mot);
        }
        if (casePossible(x - 1, y - 1)) {
            recurs(x - 1, y - 1, mot);
        }
        if (casePossible(x, y - 1)) {
            recurs(x, y - 1, mot);
        }
        if (casePossible(x + 1, y - 1)) {
            recurs(x + 1, y - 1, mot);
        }
        if (casePossible(x - 1, y)) {
            recurs(x - 1, y, mot);
        }
        if (casePossible(x + 1, y)) {
            recurs(x + 1, y, mot);
        }
        if (casePossible(x - 1, y + 1)) {
            recurs(x - 1, y + 1, mot);
        }
        if (casePossible(x, y + 1)) {
            recurs(x, y + 1, mot);
        }
        if (casePossible(x + 1, y + 1)) {
            recurs(x + 1, y + 1, mot);
        }

    }


    private boolean casePossible(int x, int y) {
        if (x < 0 || y < 0) {
            return false;
        }
        if (x > 3 || y > 3) {
            return false;
        }
        return true;
    }

}
