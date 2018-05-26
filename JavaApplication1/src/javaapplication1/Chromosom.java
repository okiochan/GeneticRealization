
package javaapplication1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Chromosom {
    
    public static  ArrayList <Chromosom> arr = new ArrayList<>();
    
    Chromosom (int arr1[]) {
        v = arr1.clone();
    }
    
    public void Draw(Graphics2D g, int x, int y) {
        
        for (int i=0; i< v.length; i++) {
            if(v[i] == 0) {
                g.setColor(Color.pink);
            } else {
                g.setColor(Color.gray);
            }
            g.fillOval(x, y+(i*size), size, size);
        }
        
    }
    
    public static void DrawAll(Graphics2D g, int x, int y) {
        
        for (int i =0; i < Chromosom.arr.size(); i++) {
            Chromosom.arr.get(i).Draw(g, x, y);
            x += Chromosom.arr.get(i).size+10;
        }
    }
    
    public int getLength() {
        return size*v.length; 
    }
    
    private int v[];
    private int size = 20;
}
