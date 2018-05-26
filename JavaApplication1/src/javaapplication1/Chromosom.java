
package javaapplication1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Chromosom {
    
    public static  ArrayList <Chromosom> cur = new ArrayList<>();
    public static  ArrayList <Chromosom> nxt = new ArrayList<>();
    
    //-1 == no parent
    Chromosom (int arr1[], int mom, int dad) {
        v = arr1.clone();
        this.mom = mom;
        this.dad = dad;
    }
    
    public void draw(Graphics2D g, int x, int y) {
        
        for (int i=0; i< v.length; i++) {
            if(v[i] == 0) {
                g.setColor(Color.pink);
            } else {
                g.setColor(Color.gray);
            }
            g.fillOval(x, y+(i*size), size, size);
        }
        
    }
    
    public static void drawAll(Graphics2D g, int X, int Y) {
        
        int x= X, y = Y;
        for (int i =0; i < Chromosom.cur.size(); i++) {
            Chromosom.cur.get(i).draw(g, x, y);
            x += size+10;
        }
        
        y = y + Chromosom.cur.get(0).getYLength() + 100;
        
        x=X;
        for (int i =0; i < Chromosom.nxt.size(); i++) {
            
            int id = Chromosom.nxt.get(i).mom;
            if(id != -1) {
                int xp = X+(size+10)*id;
                int yp = Y+Chromosom.nxt.get(id).getYLength();
                DrawMethods.drawLine(g, x+size/2, y, xp+size/2, yp); 
            }
            
            id = Chromosom.nxt.get(i).dad;
            if(id != -1) {
                int xp = X+(size+10)*id;
                int yp = Y+Chromosom.nxt.get(id).getYLength();
                DrawMethods.drawLine(g, x+size/2, y, xp+size/2, yp); 
            }
            
            Chromosom.nxt.get(i).draw(g, x, y);
            x += Chromosom.nxt.get(i).size+10;
        }
        
    }
    
    public int getYLength() {
        return size*v.length; 
    }

    
    private static int size = 30;
    
    private int v[];
    private int mom, dad;
}
