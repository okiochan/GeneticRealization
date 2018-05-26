package javaapplication1;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProblemReader {

    public States Read(String fileName) {
        States res = new States();

        try {
            FileInputStream fin = new FileInputStream(fileName);
            BufferedInputStream bin = new BufferedInputStream(fin);
            Scanner in = new Scanner(bin);
            
            for(;in.hasNextInt();) {
                
                // read chromosome representation
                int n = in.nextInt();
                ArrayList<Chromosom> state = new ArrayList<>();
                for(int i =0; i < n; i++) {
                    String repr = in.nextLine();
                    int[] arr = new int[repr.length()];
                    for(int j = 0; j < repr.length();++j) {
                        if(repr.charAt(j) == '0') {
                            arr[j] = 0;
                        } else {
                            arr[j] = 1;
                        }
                    }
                    Chromosom now = new Chromosom(arr);
                    state.add(now);
                }
                
                res.states.add(state);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProblemReader.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;
    }
}
