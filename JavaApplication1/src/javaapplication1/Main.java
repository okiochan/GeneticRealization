/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.util.ArrayList;

public class Main {
    
    public static void main (String args[]) {
        
        int tmp0[] = {1,0,1,0,1,0};
        int tmp1[] = {1,1,1,1,0,1};
        int tmp2[] = {0,0,0,1,1,1};
        int tmp3[] = {1,1,1,1,1,1};
        
        Chromosom.arr.add(new Chromosom(tmp0));
        Chromosom.arr.add(new Chromosom(tmp1));
        Chromosom.arr.add(new Chromosom(tmp2));
        Chromosom.arr.add(new Chromosom(tmp3));
        
        //---------------------------------------------STANDARD---------------------------------------------
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Drawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Drawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Drawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Drawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Drawer().setVisible(true);
            }
        });
    }
}
