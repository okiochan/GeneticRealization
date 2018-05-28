/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.util.ArrayList;

public class Main {
    
    public static void main (String args[]) {
        
        States s = ProblemReader.Read("..\\example_input.txt");
        Chromosom.cur = s.states.get(0);
        Chromosom.nxt = s.states.get(1);
        
//        int tmp0[] = {1,0,1,0,1,0};
//        int tmp1[] = {1,1,1,1,0,1};
//        int tmp2[] = {0,0,0,1,1,1};
//        int tmp3[] = {1,1,1,1,1,1};
//        
//        Chromosom.cur.add(new Chromosom(tmp0, -1, -1));
//        Chromosom.cur.add(new Chromosom(tmp1,  -1, -1));
//        Chromosom.cur.add(new Chromosom(tmp2,  -1, -1));
//        Chromosom.cur.add(new Chromosom(tmp3,  -1, -1));
//        
//        
//        int tmp4[] = {1,1,1,0,1,0};
//        int tmp5[] = {0,0,1,1,0,1};
//        int tmp6[] = {0,0,0,1,0,1};
//        int tmp7[] = {0,0,0,0,0,0};
//        
//        Chromosom.nxt.add(new Chromosom(tmp4,0,3));
//        Chromosom.nxt.add(new Chromosom(tmp5,-1,-1));
//        Chromosom.nxt.add(new Chromosom(tmp6,0,-1));
//        Chromosom.nxt.add(new Chromosom(tmp7,1,3));
        
        
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
