// Name: Yifan 
// USC NetID: ychen865
// CS 455 PA1
// Fall 2019

/**
 * class CoinSimComponent
 * 
 * Extends JComponent. Overrides paintComponent to draw the bar graph,
 * using Bar objects for each bar in the graph. This class uses the 
 * CoinTossSimulator and Bar class.
 * 
 **/

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Color;

public class CoinSimComponent extends JComponent {

    private int twoHeads;
    private int twoTails;
    private int headTails;
    private int numTrials;
    private double twoHeadsPercent;
    private double twoTailsPercent;
    private double headTailsPercent;


    /**
        Run the simulation of coin toss.
        @param numTrials  number of trials to for simulation; must be >= 1
    **/
    public CoinSimComponent(int numTrials) {

        this .numTrials = numTrials;
        CoinTossSimulator coinToss = new CoinTossSimulator();
        coinToss.run(numTrials);

        // get results 
        twoHeads = coinToss.getTwoHeads();
        twoTails = coinToss.getTwoTails();
        headTails = coinToss.getHeadTails();

        //calculate the percentage of the numbers of the two heads, two tails, and a head and a tail
        twoHeadsPercent = (double) twoHeads / numTrials;
        twoTailsPercent = (double) twoTails / numTrials;
        headTailsPercent = (double) headTails / numTrials;
    }


    /**
        Display the result.
    **/
    public void paintComponent(Graphics g) { 
        // get width height
        int w = getWidth();
        int h = getHeight();

        // decide bottom, left, width and barHeight,
        int bottom = (int) (h * 0.85);
        int width = (int) (w * 0.10);
        int barHeight = (int) (h * 0.7);

        int left1 = (int) (w*0.25 - 0.5*width);
        int left2 = (int) (w*0.50 - 0.5*width);
        int left3 = (int) (w*0.75 - 0.5*width);

        // calculate the scale
        //double twoHeadsScale = twoHeadsPercent;
        //double headTailsScale = headTailsPercent;
        //double twoTailsScale = twoTailsPercent;
        double twoHeadsScale = twoHeadsPercent/headTailsPercent;
        double headTailsScale = 1.0;
        double twoTailsScale = twoTailsPercent/headTailsPercent;
        if ((twoHeads >= headTails) && (twoHeads >= twoTails)) {
            twoHeadsScale = 1.0;
            headTailsScale = headTailsPercent/twoHeadsPercent;
            twoTailsScale = twoTailsPercent/twoHeadsPercent;
        } else if ((twoTails >= headTails) && (twoTails >= twoHeads)) {
            twoHeadsScale = twoHeadsPercent/twoTailsPercent;
            headTailsScale = headTailsPercent/twoTailsPercent;
            twoTailsScale = 1.0;
        } else {
            // no code
        }

        // draw three bars  
        Graphics2D g2 = (Graphics2D) g;

        Bar bar1 = new Bar(bottom, left1, width, barHeight, 
                           twoHeadsScale, Color.red, 
                           "Two Heads: " + twoHeads + "(" + Math.round(twoHeadsPercent * 100) + "%)");
        bar1.draw(g2);

        Bar bar2 = new Bar(bottom, left2, width, barHeight,
                           headTailsScale, Color.green, 
                           "A Head and a Tail: " + headTails + "(" + Math.round(headTailsPercent * 100) + "%)");
        bar2.draw(g2);

        Bar bar3 = new Bar(bottom,left3,width,barHeight,
                           twoTailsScale, Color.blue, 
                           "Two Tails: " + twoTails + "(" + Math.round(twoTailsPercent * 100) + "%)");
        bar3.draw(g2);    
    }

}