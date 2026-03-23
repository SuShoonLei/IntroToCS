package space;

import painter.SPainter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SpaceInvasion {
    private ArrayList<Alien> SpaceInvasion;

    public SpaceInvasion(int nrOfAlien, Color color) {
        this.SpaceInvasion = new ArrayList<Alien>(nrOfAlien);
        for (int i = 0; i < nrOfAlien; i++) {
            String name = JOptionPane.showInputDialog(null,
                    "Please enter Name of Alien" + (i + 1));
            int size = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Please enter Size of Alien" + (i + 1)));
            int legs = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "How many legs Alien" + (i + 1) + " has?"));
            int eyes = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "How many eyes Alien" + (i + 1) + " has?"));
            Alien atien = new Alien(name, size, legs, eyes, color);
            SpaceInvasion.add(atien);

        }
    }

    public String toString() {
        String st = "";
        for (int i = 0; i < SpaceInvasion.size(); i++) {
            st = st + SpaceInvasion.get(i).toString() + "\n";
        }
        return st;
    }

    public void paint(SPainter sp) {
        sp.mlt(sp.painterWidth / 2.0);
        double mv = (sp.painterWidth) / (SpaceInvasion.size() + 1);
        for (int i = 0; i < SpaceInvasion.size(); i++) {
            sp.mrt(mv);
            SpaceInvasion.get(i).paint(sp);
        }
    }
}