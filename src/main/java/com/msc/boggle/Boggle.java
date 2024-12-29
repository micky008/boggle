/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.msc.boggle;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Michael
 */
public class Boggle {

    public static void main(String[] args) throws IOException {
        //char[][] grille = {{'S', 'X', 'L', 'E'}, {'D', 'H', 'A', 'R'}, {'E', 'T', 'R', 'D'}, {'E', 'U', 'I', 'S'}};
        //char[][] grille = {{'R', 'A', 'S', 'C'}, {'O', 'N', 'H', 'V'}, {'A', 'I', 'I', 'T'}, {'U', 'A', 'Z', 'N'}};
        char[][] grille = {{'O', 'D', 'B', 'E'}, {'X', 'I', 'N', 'E'}, {'I', 'A', 'E', 'D'}, {'O', 'E', 'V', 'N'}};

        File allmots = new File("C:\\Users\\micky\\Pictures\\boggle\\allmots.txt");
        List<String> mots = FileUtils.readLines(allmots, "UTF-8");

        ManipNoeud mn = ManipNoeud.getInstance();
        for (String mot : mots) {
            mn.addMotEntier(mot);
        }

        Algo algo = new Algo(grille);
        algo.resolv();

        for (String mot : algo.getAllFindingMots()) {
            System.out.println(mot);
        }

        System.out.println("--------------------------------------");
        System.out.println("liste.txt");
        
        File motTirage2 = new File("C:\\Users\\micky\\Pictures\\boggle\\tirage3\\liste.txt");
        List<String> listMotTirage2 = FileUtils.readLines(motTirage2, "UTF-8");
        listMotTirage2.sort((o1, o2) -> o1.compareTo(o2));
          for (String mot : listMotTirage2) {
            System.out.println(mot);
        }

    }
}
