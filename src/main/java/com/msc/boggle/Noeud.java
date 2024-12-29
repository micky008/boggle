package com.msc.boggle;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Michael
 */
public class Noeud {

    public Noeud(char c) {
        this.c = c;
    }

    public Noeud() {
    }

    public char c = '\0';
    public List<Noeud> list = new LinkedList<>();
    public boolean lastLettre = false;

    @Override
    public String toString() {
        return "" + c;
    }

}
