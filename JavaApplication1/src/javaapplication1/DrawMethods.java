/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author пк
 */
public class DrawMethods {
    
        
    public static void drawLine(Graphics2D g, int x, int y, int X, int Y) {
        g.setColor(Color.green);
        g.setStroke(new BasicStroke(3));
        g.drawLine(X, Y, x, y);
    }
}
