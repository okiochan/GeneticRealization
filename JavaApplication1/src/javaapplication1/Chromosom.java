
package javaapplication1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Chromosom {
    
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
    
    public int getYLength() {
        return size*v.length; 
    }

    public int getMom() {
        return mom;
    }

    public void setMom(int mom) {
        this.mom = mom;
    }

    public int getDad() {
        return dad;
    }

    public void setDad(int dad) {
        this.dad = dad;
    }
    
    public int getSize() {
        return size;
    }

    private int v[];
    private int mom, dad;
    private int size = 30;    
}
