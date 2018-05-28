/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;
import javax.swing.JFrame;

public class Logic {

    public static ArrayList<Chromosom> cur;
    public static ArrayList<Chromosom> nxt;

    Logic() {
        s = ProblemReader.Read("..\\example_input.txt");
        cur = s.states.get(0);
        nxt = s.states.get(1);
    }

    public static void loadNextStep(JFrame frame) {
        Drawer d = (Drawer) frame;

        if (step >= s.states.size()) {
            return;
        }
        step++;
        cur = s.states.get(step);
        nxt = s.states.get(step + 1);
        d.getCountdownLabel().setText(step + "/" + s.states.size());
        d.getDrawPanel().repaint();
    }

    public static void loadPrevStep(JFrame frame) {
        Drawer d = (Drawer) frame;

        if (step - 1 < 0) {
            return;
        }
        step--;
        cur = s.states.get(step);
        nxt = s.states.get(step + 1);
        d.getCountdownLabel().setText(step + "/" + s.states.size());
        d.getDrawPanel().repaint();
    }

    private static int step = 0;
    private static States s;
}
