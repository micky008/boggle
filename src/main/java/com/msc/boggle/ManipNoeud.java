package com.msc.boggle;

/**
 *
 * @author Michael
 */
public class ManipNoeud {

    private ManipNoeud() {
    }
    private static final ManipNoeud instance = new ManipNoeud();

    public static ManipNoeud getInstance() {
        return instance;
    }

    private final Noeud racine = new Noeud();

    public void addMotEntier(String mot) {
        Noeud parcour = racine;
        boolean find = false;
        for (int i = 0; i < mot.length(); i++) {
            find = false;
            char encours = mot.charAt(i);
            for (Noeud n : parcour.list) {
                if (n.c == encours) {
                    parcour = n;
                    find = true;
                    break;
                }
            }
            if (!find) {
                Noeud nencours = new Noeud(encours);
                parcour.list.add(nencours);
                parcour = nencours;
            }
        }
        parcour.lastLettre = true;
    }

    public boolean exist(String mot) {
        Noeud parcour = racine;
        boolean find = false;
        for (int i = 0; i < mot.length(); i++) {
            find = false;
            char encours = mot.charAt(i);
            for (Noeud n : parcour.list) {
                if (n.c == encours) {
                    parcour = n;
                    find = true;
                    break;
                }
            }
            if (!find) {
                return false;
            }
        }
        return true;
    }

    public boolean isMotComplet(String mot) {
        Noeud parcour = racine;
        boolean find = false;
        for (int i = 0; i < mot.length(); i++) {
            find = false;
            char encours = mot.charAt(i);
            for (Noeud n : parcour.list) {
                if (n.c == encours) {
                    parcour = n;
                    find = true;
                    break;
                }
            }
            if (!find) {
                return false;
            }
        }
        return parcour.lastLettre;
    }

    public void printAllMot() {
        for (Noeud n : racine.list) {
            print(n, "");
        }
    }

    private void print(Noeud noeudParent, String mot) {
        if (noeudParent.c != '\0') {
            mot += noeudParent.c;
        }
        if (noeudParent.list.isEmpty()) {
            System.out.println(mot);
            return;
        }
        for (Noeud n : noeudParent.list) {
            print(n, mot);
        }

    }

}
