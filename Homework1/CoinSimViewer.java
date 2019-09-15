// Name: Yifan 
// USC NetID: ychen865
// CS 455 PA1
// Fall 2019

/**
 * class CoinSimViewer
 * 
 * graphical display
 * 
 **/

import java.util.*;
import javax.swing.JFrame;

public class CoinSimViewer {

    /** 
        The main function for graphical interface display.
    **/

    public static void main(String[] args) {

        // get the input 
        Scanner in = new Scanner(System.in);

        System.out.print("Enter number of trials: ");
        // input validation 
        int inputNum = in.nextInt();
        while (inputNum <= 0) {
            System.out.println("EERROR: Number entered must be greater than 0.");
            System.out.print("Enter number of trials: ");
            inputNum = in.nextInt();
        }

        // JFrame
        JFrame frame = new JFrame();
        frame.setSize(800, 500);
        frame.setTitle("CoinSim");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // CoinSimComponent and draw output
        CoinSimComponent component = new CoinSimComponent(inputNum);
        frame.add(component);
        
        frame.setVisible(true);
    }

}