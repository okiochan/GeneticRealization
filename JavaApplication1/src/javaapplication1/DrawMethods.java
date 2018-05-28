/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author пк
 */
public class DrawMethods {
    
        
    public static void drawLine(Graphics2D g, int x, int y, int X, int Y) {
        g.setColor(Color.green);
        g.setStroke(new BasicStroke(2));
        g.drawLine(X, Y, x, y);
    }
    
    public static void drawChromosomes(Graphics2D g, ArrayList <Chromosom> cur, ArrayList <Chromosom> nxt, int X, int Y) {
        int x= X, y = Y;
        for (int i =0; i < cur.size(); i++) {
            cur.get(i).draw(g, x, y);
            x += cur.get(i).getSize()+10;
        }

        y = y + cur.get(0).getYLength() + 100;

        x=X;
        for (int i =0; i < nxt.size(); i++) {
            int id = nxt.get(i).getMom();
            if(id != -1) {
                int xp = X+(nxt.get(i).getSize()+10)*id;
                int yp = Y+nxt.get(id).getYLength();
                DrawMethods.drawLine(g, x+nxt.get(i).getSize()/2, y, xp+nxt.get(i).getSize()/2, yp); 
            }

            id = nxt.get(i).getDad();
            if(id != -1) {
                int xp = X+(nxt.get(i).getSize()+10)*id;
                int yp = Y+nxt.get(i).getYLength();
                DrawMethods.drawLine(g, x+nxt.get(i).getSize()/2, y, xp+nxt.get(i).getSize()/2, yp); 
            }

        nxt.get(i).draw(g, x, y);
        x += nxt.get(i).getSize()+10;
        }
    }
}
