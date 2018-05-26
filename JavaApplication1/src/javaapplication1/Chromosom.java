
package javaapplication1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Chromosom {
    
    Chromosom (ArrayList<Integer> arr1) {
        arr = (ArrayList<Integer>)arr1.clone();
    }
    
    public void Draw(Graphics2D g) {
        
        
        
        g.setColor(Color.red);
        
        g.fillOval(50, 50, 100, 100);
    }
    
    private ArrayList <Integer> arr;
}
