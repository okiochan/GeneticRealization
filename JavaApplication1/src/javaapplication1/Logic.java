/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;

public class Logic {
    
    public static ArrayList<Chromosom> cur = new ArrayList<>();
    public static ArrayList<Chromosom> nxt = new ArrayList<>();
    
    
    Logic() {
        States s = ProblemReader.Read("..\\example_input.txt");
        cur = s.states.get(0);
        nxt = s.states.get(1);
        System.out.println(s.states.size());
    }
    
}
