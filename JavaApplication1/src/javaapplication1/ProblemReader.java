package javaapplication1;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;

public class ProblemReader {

    public static States Read(String fileName) {
        States res = new States();

        try {
            FileInputStream fin = new FileInputStream(fileName);
            BufferedInputStream bin = new BufferedInputStream(fin);
            Scanner in = new Scanner(bin);

            for (; in.hasNextInt();) {

                // read chromosome representation
                int n = in.nextInt();
                ArrayList<Chromosom> state = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    String repr = nextNonEmpty(in);
                    int[] arr = new int[repr.length()];
                    for (int j = 0; j < repr.length(); ++j) {
                        if (repr.charAt(j) == '0') {
                            arr[j] = 0;
                        } else {
                            arr[j] = 1;
                        }
                    }

                    Chromosom now = new Chromosom(arr, -1, -1);
                    state.add(now);
                }

                res.states.add(state);

                if (!in.hasNextInt()) { // last iteration contains only the result
                    break;
                }

                // read edges
                ArrayList<Pair<Integer, Integer>> edges = new ArrayList<>();
                int m = in.nextInt();
                for (int i = 0; i < m; ++i) {
                    int a, b;
                    a = in.nextInt();
                    b = in.nextInt();
                    Pair<Integer, Integer> edge = new Pair(a, b);
                    edges.add(edge);
                }
                res.edges.add(edges);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProblemReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i = 1;i<res.states.size(); ++i) {
            for(int j = 0; j < res.edges.get(i-1).size(); ++j) {
                Pair<Integer, Integer> now = res.edges.get(i-1).get(j);
                res.states.get(i).get(j).setMom(now.getKey());
                res.states.get(i).get(j).setDad(now.getValue());
            }
        }

        return res;
    }
    
    private static String nextNonEmpty(Scanner in) {
        String res = null;
        do {
            res = in.nextLine();
        } while (res.isEmpty());
        return res;
    }
}
