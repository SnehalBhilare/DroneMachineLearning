/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algo.drone.userinterface;

import com.algo.drone.simulation.Drone;
import com.algo.drone.simulation.MachineLearning;

import com.algo.drone.simulation.PathNodeLinkedList;
import com.algo.drone.simulation.Node;
import com.algo.drone.simulation.PathNode;
import java.awt.Color;
import java.awt.Component;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

/**
 *
 * @author Snehal
 */
public class TravelMapJPanel extends javax.swing.JPanel {

    /**
     * Creates new form TravelMapJPanel
     */
    private int index; //to traveel learned path
    private int smallPathCount; // no of small paths to be inserted
    private Drone drone;
    PathNode searchPath; // learned path
    PathNode currentPath; // current travel path
    boolean insertPath; // wheather to insert path or not
    ArrayList<PathNode> smallPath; // all small paths to be inserted

    public TravelMapJPanel(Drone drone) {
        initComponents();

        this.drone = drone;
        drone.setFuel(100);
        fuelJTextField.setText(String.valueOf(drone.getFuel()));
        smallPathCount = 0;
        insertPath = false; // if we have any inbetween paths to insert
        setJLableName();

        smallPath = new ArrayList<PathNode>(); // arraylist of all small paths
        setJLableToNodes();

        printMachine();
        //System.out.println("if added? "+ MachineLearning.learning.containsKey(drone.getSource())+"source:"+drone.getSource());

        searchPath = new PathNode();
        currentPath = new PathNode();

        searchPath = searchPath(drone.getSource()); // get learned path if any into machiene 

        System.out.println("######################New start ##########################");
        if (searchPath == null) {
            System.out.println("no learned path ");
        } else {
            System.out.println("learned path found");
            colorSearchPath();  //coloring learned path
        }
        index = 0;

        timer();

    }

    public void colorSearchPath() //colors searched path we got from machine
    {
        for (Node n : searchPath.getPath()) {
            JLabel jlabel = (JLabel) n.getLable();
            jlabel.setForeground(Color.GREEN);
        }
    }

    public void colorTravelPath() //colors travelled path with white color
    {
        for (Node n : currentPath.getPath()) {
            JLabel jlabel = (JLabel) n.getLable();
            jlabel.setForeground(Color.white);
        }
    }

    public void printMachine() //print hashmap
    {
        try {
            FileInputStream fin = new FileInputStream("C:/Spring2015/Program Structure and Algo/Final_Project/Machine.txt");
            ObjectInputStream ois = new ObjectInputStream(fin);
            MachineLearning.learning = (Hashtable<Node, PathNodeLinkedList>) ois.readObject(); //read machine

        } catch (Exception e) {
            // System.out.println(e);
        }

        System.out.println("Machine Database : " + MachineLearning.learning.entrySet());

    }

    public PathNode searchPath(Node A) // search if trained path exist
    {
        if (MachineLearning.learning.isEmpty() || !MachineLearning.learning.containsKey(A)) {
            insertPath = true; // path is not there hence we need to insert path with which we are traversing
            return null;

        }
        index = 0;
        return MachineLearning.learning.get(A).getRoot();

    }

    public JLabel getComponentByName(String name) {
        if (drone.getNodeMap().containsKey(name)) {
            return (JLabel) drone.getNodeMap().get(name).getLable();
        } else {
            return null;
        }
    }

    //This method is to assign JLable componnent to the respective entry in HashMap node
    public void setJLableToNodes() {
        Component[] components = this.getComponents();

        for (Component comp : components) {
            if (comp instanceof JLabel) {
                Node n = drone.getNodeMap().get(comp.getName());

                n.setLable((JLabel) comp);

            }
        }

    }

    public void setJLableName() //naming each nodes so that we can access it using varibale names
    {
        zeroZero.setName("zeroZero");
        zeroOne.setName("zeroOne");
        zeroTwo.setName("zeroTwo");
        zeroThree.setName("zeroThree");
        zeroFour.setName("zeroFour");
        zeroFive.setName("zeroFive");
        zeroSix.setName("zeroSix");
        zeroSeven.setName("zeroSeven");
        zeroEight.setName("zeroEight");
        zeroNine.setName("zeroNine");
        zeroTen.setName("zeroTen");
        zeroEleven.setName("zeroEleven");
        zeroTwelve.setName("zeroTwelve");
        zeroThirteen.setName("zeroThirteen");
        zeroFourteen.setName("zeroFourteen");
        zeroFifteen.setName("zeroFifteen");
        zeroSixteen.setName("zeroSixteen");
        zeroSeventeen.setName("zeroSeventeen");
        zeroEighteen.setName("zeroEighteen");
        zeroNineteen.setName("zeroNineteen");
        oneZero.setName("oneZero");
        oneOne.setName("oneOne");
        oneTwo.setName("oneTwo");
        oneThree.setName("oneThree");
        oneFour.setName("oneFour");
        oneFive.setName("oneFive");
        oneSix.setName("oneSix");
        oneSeven.setName("oneSeven");
        oneEight.setName("oneEight");
        oneNine.setName("oneNine");
        oneTen.setName("oneTen");
        oneEleven.setName("oneEleven");
        oneTwelve.setName("oneTwelve");
        oneThirteen.setName("oneThirteen");
        oneFourteen.setName("oneFourteen");
        oneFifteen.setName("oneFifteen");
        oneSixteen.setName("oneSixteen");
        oneSeventeen.setName("oneSeventeen");
        oneEighteen.setName("oneEighteen");
        oneNineteen.setName("oneNineteen");
        twoZero.setName("twoZero");
        twoOne.setName("twoOne");
        twoTwo.setName("twoTwo");
        twoThree.setName("twoThree");
        twoFour.setName("twoFour");
        twoFive.setName("twoFive");
        twoSix.setName("twoSix");
        twoSeven.setName("twoSeven");
        twoEight.setName("twoEight");
        twoNine.setName("twoNine");
        twoTen.setName("twoTen");
        twoEleven.setName("twoEleven");
        twoTwelve.setName("twoTwelve");
        twoThirteen.setName("twoThirteen");
        twoFourteen.setName("twoFourteen");
        twoFifteen.setName("twoFifteen");
        twoSixteen.setName("twoSixteen");
        twoSeventeen.setName("twoSeventeen");
        twoEighteen.setName("twoEighteen");
        twoNineteen.setName("twoNineteen");
        threeZero.setName("threeZero");
        threeOne.setName("threeOne");
        threeTwo.setName("threeTwo");
        threeThree.setName("threeThree");
        threeFour.setName("threeFour");
        threeFive.setName("threeFive");
        threeSix.setName("threeSix");
        threeSeven.setName("threeSeven");
        threeEight.setName("threeEight");
        threeNine.setName("threeNine");
        threeTen.setName("threeTen");
        threeEleven.setName("threeEleven");
        threeTwelve.setName("threeTwelve");
        threeThirteen.setName("threeThirteen");
        threeFourteen.setName("threeFourteen");
        threeFifteen.setName("threeFifteen");
        threeSixteen.setName("threeSixteen");
        threeSeventeen.setName("threeSeventeen");
        threeEighteen.setName("threeEighteen");
        threeNineteen.setName("threeNineteen");
        fourZero.setName("fourZero");
        fourOne.setName("fourOne");
        fourTwo.setName("fourTwo");
        fourThree.setName("fourThree");
        fourFour.setName("fourFour");
        fourFive.setName("fourFive");
        fourSix.setName("fourSix");
        fourSeven.setName("fourSeven");
        fourEight.setName("fourEight");
        fourNine.setName("fourNine");
        fourTen.setName("fourTen");
        fourEleven.setName("fourEleven");
        fourTwelve.setName("fourTwelve");
        fourThirteen.setName("fourThirteen");
        fourFourteen.setName("fourFourteen");
        fourFifteen.setName("fourFifteen");
        fourSixteen.setName("fourSixteen");
        fourSeventeen.setName("fourSeventeen");
        fourEighteen.setName("fourEighteen");
        fourNineteen.setName("fourNineteen");
        fiveZero.setName("fiveZero");
        fiveOne.setName("fiveOne");
        fiveTwo.setName("fiveTwo");
        fiveThree.setName("fiveThree");
        fiveFour.setName("fiveFour");
        fiveFive.setName("fiveFive");
        fiveSix.setName("fiveSix");
        fiveSeven.setName("fiveSeven");
        fiveEight.setName("fiveEight");
        fiveNine.setName("fiveNine");
        fiveTen.setName("fiveTen");
        fiveEleven.setName("fiveEleven");
        fiveTwelve.setName("fiveTwelve");
        fiveThirteen.setName("fiveThirteen");
        fiveFourteen.setName("fiveFourteen");
        fiveFifteen.setName("fiveFifteen");
        fiveSixteen.setName("fiveSixteen");
        fiveSeventeen.setName("fiveSeventeen");
        fiveEighteen.setName("fiveEighteen");
        fiveNineteen.setName("fiveNineteen");
        sixZero.setName("sixZero");
        sixOne.setName("sixOne");
        sixTwo.setName("sixTwo");
        sixThree.setName("sixThree");
        sixFour.setName("sixFour");
        sixFive.setName("sixFive");
        sixSix.setName("sixSix");
        sixSeven.setName("sixSeven");
        sixEight.setName("sixEight");
        sixNine.setName("sixNine");
        sixTen.setName("sixTen");
        sixEleven.setName("sixEleven");
        sixTwelve.setName("sixTwelve");
        sixThirteen.setName("sixThirteen");
        sixFourteen.setName("sixFourteen");
        sixFifteen.setName("sixFifteen");
        sixSixteen.setName("sixSixteen");
        sixSeventeen.setName("sixSeventeen");
        sixEighteen.setName("sixEighteen");
        sixNineteen.setName("sixNineteen");
        sevenZero.setName("sevenZero");
        sevenOne.setName("sevenOne");
        sevenTwo.setName("sevenTwo");
        sevenThree.setName("sevenThree");
        sevenFour.setName("sevenFour");
        sevenFive.setName("sevenFive");
        sevenSix.setName("sevenSix");
        sevenSeven.setName("sevenSeven");
        sevenEight.setName("sevenEight");
        sevenNine.setName("sevenNine");
        sevenTen.setName("sevenTen");
        sevenEleven.setName("sevenEleven");
        sevenTwelve.setName("sevenTwelve");
        sevenThirteen.setName("sevenThirteen");
        sevenFourteen.setName("sevenFourteen");
        sevenFifteen.setName("sevenFifteen");
        sevenSixteen.setName("sevenSixteen");
        sevenSeventeen.setName("sevenSeventeen");
        sevenEighteen.setName("sevenEighteen");
        sevenNineteen.setName("sevenNineteen");
        eightZero.setName("eightZero");
        eightOne.setName("eightOne");
        eightTwo.setName("eightTwo");
        eightThree.setName("eightThree");
        eightFour.setName("eightFour");
        eightFive.setName("eightFive");
        eightSix.setName("eightSix");
        eightSeven.setName("eightSeven");
        eightEight.setName("eightEight");
        eightNine.setName("eightNine");
        eightTen.setName("eightTen");
        eightEleven.setName("eightEleven");
        eightTwelve.setName("eightTwelve");
        eightThirteen.setName("eightThirteen");
        eightFourteen.setName("eightFourteen");
        eightFifteen.setName("eightFifteen");
        eightSixteen.setName("eightSixteen");
        eightSeventeen.setName("eightSeventeen");
        eightEighteen.setName("eightEighteen");
        eightNineteen.setName("eightNineteen");
        nineZero.setName("nineZero");
        nineOne.setName("nineOne");
        nineTwo.setName("nineTwo");
        nineThree.setName("nineThree");
        nineFour.setName("nineFour");
        nineFive.setName("nineFive");
        nineSix.setName("nineSix");
        nineSeven.setName("nineSeven");
        nineEight.setName("nineEight");
        nineNine.setName("nineNine");
        nineTen.setName("nineTen");
        nineEleven.setName("nineEleven");
        nineTwelve.setName("nineTwelve");
        nineThirteen.setName("nineThirteen");
        nineFourteen.setName("nineFourteen");
        nineFifteen.setName("nineFifteen");
        nineSixteen.setName("nineSixteen");
        nineSeventeen.setName("nineSeventeen");
        nineEighteen.setName("nineEighteen");
        nineNineteen.setName("nineNineteen");
        tenZero.setName("tenZero");
        tenOne.setName("tenOne");
        tenTwo.setName("tenTwo");
        tenThree.setName("tenThree");
        tenFour.setName("tenFour");
        tenFive.setName("tenFive");
        tenSix.setName("tenSix");
        tenSeven.setName("tenSeven");
        tenEight.setName("tenEight");
        tenNine.setName("tenNine");
        tenTen.setName("tenTen");
        tenEleven.setName("tenEleven");
        tenTwelve.setName("tenTwelve");
        tenThirteen.setName("tenThirteen");
        tenFourteen.setName("tenFourteen");
        tenFifteen.setName("tenFifteen");
        tenSixteen.setName("tenSixteen");
        tenSeventeen.setName("tenSeventeen");
        tenEighteen.setName("tenEighteen");
        tenNineteen.setName("tenNineteen");
        elevenZero.setName("elevenZero");
        elevenOne.setName("elevenOne");
        elevenTwo.setName("elevenTwo");
        elevenThree.setName("elevenThree");
        elevenFour.setName("elevenFour");
        elevenFive.setName("elevenFive");
        elevenSix.setName("elevenSix");
        elevenSeven.setName("elevenSeven");
        elevenEight.setName("elevenEight");
        elevenNine.setName("elevenNine");
        elevenTen.setName("elevenTen");
        elevenEleven.setName("elevenEleven");
        elevenTwelve.setName("elevenTwelve");
        elevenThirteen.setName("elevenThirteen");
        elevenFourteen.setName("elevenFourteen");
        elevenFifteen.setName("elevenFifteen");
        elevenSixteen.setName("elevenSixteen");
        elevenSeventeen.setName("elevenSeventeen");
        elevenEighteen.setName("elevenEighteen");
        elevenNineteen.setName("elevenNineteen");
        twelveZero.setName("twelveZero");
        twelveOne.setName("twelveOne");
        twelveTwo.setName("twelveTwo");
        twelveThree.setName("twelveThree");
        twelveFour.setName("twelveFour");
        twelveFive.setName("twelveFive");
        twelveSix.setName("twelveSix");
        twelveSeven.setName("twelveSeven");
        twelveEight.setName("twelveEight");
        twelveNine.setName("twelveNine");
        twelveTen.setName("twelveTen");
        twelveEleven.setName("twelveEleven");
        twelveTwelve.setName("twelveTwelve");
        twelveThirteen.setName("twelveThirteen");
        twelveFourteen.setName("twelveFourteen");
        twelveFifteen.setName("twelveFifteen");
        twelveSixteen.setName("twelveSixteen");
        twelveSeventeen.setName("twelveSeventeen");
        twelveEighteen.setName("twelveEighteen");
        twelveNineteen.setName("twelveNineteen");
        thirteenZero.setName("thirteenZero");
        thirteenOne.setName("thirteenOne");
        thirteenTwo.setName("thirteenTwo");
        thirteenThree.setName("thirteenThree");
        thirteenFour.setName("thirteenFour");
        thirteenFive.setName("thirteenFive");
        thirteenSix.setName("thirteenSix");
        thirteenSeven.setName("thirteenSeven");
        thirteenEight.setName("thirteenEight");
        thirteenNine.setName("thirteenNine");
        thirteenTen.setName("thirteenTen");
        thirteenEleven.setName("thirteenEleven");
        thirteenTwelve.setName("thirteenTwelve");
        thirteenThirteen.setName("thirteenThirteen");
        thirteenFourteen.setName("thirteenFourteen");
        thirteenFifteen.setName("thirteenFifteen");
        thirteenSixteen.setName("thirteenSixteen");
        thirteenSeventeen.setName("thirteenSeventeen");
        thirteenEighteen.setName("thirteenEighteen");
        thirteenNineteen.setName("thirteenNineteen");
        fourteenZero.setName("fourteenZero");
        fourteenOne.setName("fourteenOne");
        fourteenTwo.setName("fourteenTwo");
        fourteenThree.setName("fourteenThree");
        fourteenFour.setName("fourteenFour");
        fourteenFive.setName("fourteenFive");
        fourteenSix.setName("fourteenSix");
        fourteenSeven.setName("fourteenSeven");
        fourteenEight.setName("fourteenEight");
        fourteenNine.setName("fourteenNine");
        fourteenTen.setName("fourteenTen");
        fourteenEleven.setName("fourteenEleven");
        fourteenTwelve.setName("fourteenTwelve");
        fourteenThirteen.setName("fourteenThirteen");
        fourteenFourteen.setName("fourteenFourteen");
        fourteenFifteen.setName("fourteenFifteen");
        fourteenSixteen.setName("fourteenSixteen");
        fourteenSeventeen.setName("fourteenSeventeen");
        fourteenEighteen.setName("fourteenEighteen");
        fourteenNineteen.setName("fourteenNineteen");
        fifteenZero.setName("fifteenZero");
        fifteenOne.setName("fifteenOne");
        fifteenTwo.setName("fifteenTwo");
        fifteenThree.setName("fifteenThree");
        fifteenFour.setName("fifteenFour");
        fifteenFive.setName("fifteenFive");
        fifteenSix.setName("fifteenSix");
        fifteenSeven.setName("fifteenSeven");
        fifteenEight.setName("fifteenEight");
        fifteenNine.setName("fifteenNine");
        fifteenTen.setName("fifteenTen");
        fifteenEleven.setName("fifteenEleven");
        fifteenTwelve.setName("fifteenTwelve");
        fifteenThirteen.setName("fifteenThirteen");
        fifteenFourteen.setName("fifteenFourteen");
        fifteenFifteen.setName("fifteenFifteen");
        fifteenSixteen.setName("fifteenSixteen");
        fifteenSeventeen.setName("fifteenSeventeen");
        fifteenEighteen.setName("fifteenEighteen");
        fifteenNineteen.setName("fifteenNineteen");
        sixteenZero.setName("sixteenZero");
        sixteenOne.setName("sixteenOne");
        sixteenTwo.setName("sixteenTwo");
        sixteenThree.setName("sixteenThree");
        sixteenFour.setName("sixteenFour");
        sixteenFive.setName("sixteenFive");
        sixteenSix.setName("sixteenSix");
        sixteenSeven.setName("sixteenSeven");
        sixteenEight.setName("sixteenEight");
        sixteenNine.setName("sixteenNine");
        sixteenTen.setName("sixteenTen");
        sixteenEleven.setName("sixteenEleven");
        sixteenTwelve.setName("sixteenTwelve");
        sixteenThirteen.setName("sixteenThirteen");
        sixteenFourteen.setName("sixteenFourteen");
        sixteenFifteen.setName("sixteenFifteen");
        sixteenSixteen.setName("sixteenSixteen");
        sixteenSeventeen.setName("sixteenSeventeen");
        sixteenEighteen.setName("sixteenEighteen");
        sixteenNineteen.setName("sixteenNineteen");
        seventeenZero.setName("seventeenZero");
        seventeenOne.setName("seventeenOne");
        seventeenTwo.setName("seventeenTwo");
        seventeenThree.setName("seventeenThree");
        seventeenFour.setName("seventeenFour");
        seventeenFive.setName("seventeenFive");
        seventeenSix.setName("seventeenSix");
        seventeenSeven.setName("seventeenSeven");
        seventeenEight.setName("seventeenEight");
        seventeenNine.setName("seventeenNine");
        seventeenTen.setName("seventeenTen");
        seventeenEleven.setName("seventeenEleven");
        seventeenTwelve.setName("seventeenTwelve");
        seventeenThirteen.setName("seventeenThirteen");
        seventeenFourteen.setName("seventeenFourteen");
        seventeenFifteen.setName("seventeenFifteen");
        seventeenSixteen.setName("seventeenSixteen");
        seventeenSeventeen.setName("seventeenSeventeen");
        seventeenEighteen.setName("seventeenEighteen");
        seventeenNineteen.setName("seventeenNineteen");
        eighteenZero.setName("eighteenZero");
        eighteenOne.setName("eighteenOne");
        eighteenTwo.setName("eighteenTwo");
        eighteenThree.setName("eighteenThree");
        eighteenFour.setName("eighteenFour");
        eighteenFive.setName("eighteenFive");
        eighteenSix.setName("eighteenSix");
        eighteenSeven.setName("eighteenSeven");
        eighteenEight.setName("eighteenEight");
        eighteenNine.setName("eighteenNine");
        eighteenTen.setName("eighteenTen");
        eighteenEleven.setName("eighteenEleven");
        eighteenTwelve.setName("eighteenTwelve");
        eighteenThirteen.setName("eighteenThirteen");
        eighteenFourteen.setName("eighteenFourteen");
        eighteenFifteen.setName("eighteenFifteen");
        eighteenSixteen.setName("eighteenSixteen");
        eighteenSeventeen.setName("eighteenSeventeen");
        eighteenEighteen.setName("eighteenEighteen");
        eighteenNineteen.setName("eighteenNineteen");
        nineteenZero.setName("nineteenZero");
        nineteenOne.setName("nineteenOne");
        nineteenTwo.setName("nineteenTwo");
        nineteenThree.setName("nineteenThree");
        nineteenFour.setName("nineteenFour");
        nineteenFive.setName("nineteenFive");
        nineteenSix.setName("nineteenSix");
        nineteenSeven.setName("nineteenSeven");
        nineteenEight.setName("nineteenEight");
        nineteenNine.setName("nineteenNine");
        nineteenTen.setName("nineteenTen");
        nineteenEleven.setName("nineteenEleven");
        nineteenTwelve.setName("nineteenTwelve");
        nineteenThirteen.setName("nineteenThirteen");
        nineteenFourteen.setName("nineteenFourteen");
        nineteenFifteen.setName("nineteenFifteen");
        nineteenSixteen.setName("nineteenSixteen");
        nineteenSeventeen.setName("nineteenSeventeen");
        nineteenEighteen.setName("nineteenEighteen");
        nineteenNineteen.setName("nineteenNineteen");
    }

    public void timer() //runs every second to traverse drone
    {
        final Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                drone.getAnomaly().createAnomalies(drone.getNodeMap());// creates Anomaly

                // color map based on anomaly
                for (Node node : drone.getNodeMap().values()) {
                    
                    // get node
                    StringBuilder sb = new StringBuilder();
                    sb.append(node.getxName());
                    sb.append(node.getyName());
                    String s = sb.toString();
                    JLabel jlabel = (JLabel) getComponentByName(s);

                    if (node.isIsAnomaly()) {
                        if (node.isStrong()) {
                            jlabel.setForeground(Color.RED);
                        } else {
                            jlabel.setForeground(Color.ORANGE);
                        }

                    } else {
                        jlabel.setForeground(Color.BLACK);
                    }
                } // end coloring

                if (searchPath != null) {
                    colorSearchPath();
                }
                if (currentPath != null) {
                    colorTravelPath();
                }

                boolean flag = false;
                if (searchPath == null) // if no path. calculate path using nearest neighbor chaining
                {

                    flag = drone.flyDrone(); // get nearest node name
                    String s = drone.getCurrNode().getxName() + drone.getCurrNode().getyName();
                    JLabel jlabel = (JLabel) getComponentByName(s);
                    jlabel.setForeground(Color.BLUE); // color that node
                    currentPath.addNode(drone.getCurrNode());  // add node to path

                    // searching path in machine
                    searchPath = searchPath(drone.getCurrNode()); // search path from diverted node to dest

                    insertPath = true;
                    index = 0;

                    if (!smallPath.isEmpty()) // if any small path exist add current node to all
                    {
                        for (PathNode p : smallPath) {
                            p.addNode(drone.getCurrNode());
                            if (drone.getCurrNode().isIsAnomaly()) {
                                p.setFuelConsumption(p.getFuelConsumption() + 3);
                            } else {
                                p.setFuelConsumption(p.getFuelConsumption() + 1);
                            }

                        }
                    }

                    if (searchPath == null) // if no path available from diverted one we have to add small path
                    {
                        PathNode small = new PathNode();
                        PathNodeLinkedList value = new PathNodeLinkedList();
                        value.setRoot(small);
                        MachineLearning.learning.put(drone.getCurrNode(), value);
                        smallPath.add(small);
                        smallPathCount++;
                    }

                    System.out.println("Nearest node : " + drone.getCurrNode().toString());

                    if (drone.getCurrNode().isIsAnomaly()) {
                        drone.setFuel(drone.getFuel() - 3);
                        //System.out.println("Fuel reduced by 3");
                    } else {
                        drone.setFuel(drone.getFuel() - 1);
                        //System.out.println("Fuel reduced by 1");
                    }
                    fuelJTextField.setText(String.valueOf(drone.getFuel()));
                } // end of nearest algo
                
                
                else { // means we have got path from machine to travel so follow that path

                    Node travel = searchPath.getPath().get(index); //get single node from search path
                    if (travel.isIsAnomaly()) // anomaly at search path node
                    {
                        System.out.println("Anomaly at learned Path:  " + travel.toString());
                        flag = drone.flyDrone();  // take new node from nearest neighbour
                        String s = drone.getCurrNode().getxName() + drone.getCurrNode().getyName();
                        JLabel jlabel = (JLabel) getComponentByName(s);

                        jlabel.setForeground(Color.BLUE);
                        currentPath.addNode(drone.getCurrNode());

                        if (!smallPath.isEmpty()) // if any small path exist add current node to it
                        {
                            for (PathNode p : smallPath) {
                                p.addNode(drone.getCurrNode());
                                if (drone.getCurrNode().isIsAnomaly()) {
                                    p.setFuelConsumption(p.getFuelConsumption() + 3);
                                } else {
                                    p.setFuelConsumption(p.getFuelConsumption() + 1);
                                }

                            }
                        }

                        System.out.println("Nearest node : " + drone.getCurrNode().toString());
                        if (drone.getCurrNode().isIsAnomaly()) {
                            drone.setFuel(drone.getFuel() - 3);
                            // System.out.println("Fuel reduced by 3");
                        } else {
                            drone.setFuel(drone.getFuel() - 1);
                            // System.out.println("Fuel reduced by 1");
                        }

                        fuelJTextField.setText(String.valueOf(drone.getFuel()));
                        searchPath = searchPath(drone.getCurrNode()); // search path from diverted node to dest
                        if (searchPath == null) // if no path available we have to add small path
                        {
                            PathNode small = new PathNode();
                            PathNodeLinkedList value = new PathNodeLinkedList();
                            value.setRoot(small);
                            MachineLearning.learning.put(drone.getCurrNode(), value);
                            smallPath.add(small);
                            smallPathCount++;
                        }
                        insertPath = true;
                        index = 0;
                    } 
                    else // travelling via trained path with no anomaly
                    {
                        drone.setCurrNode(travel);
                        currentPath.addNode(travel);

                        JLabel jlabel = travel.getLable();
                        jlabel.setForeground(Color.BLUE);
                        index++;

                        if (travel.equals(drone.getDest())) {
                            flag = true;
                        }

                        if (!smallPath.isEmpty()) // if any small path exist
                        {
                            for (PathNode p : smallPath) {
                                p.addNode(travel);
                                if (travel.isIsAnomaly()) {
                                    p.setFuelConsumption(p.getFuelConsumption() + 3);
                                } else {
                                    p.setFuelConsumption(p.getFuelConsumption() + 1);
                                }

                            }
                        }

                        System.out.println("Learned Path:  " + travel.toString());
                        if (travel.isIsAnomaly()) {
                            drone.setFuel(drone.getFuel() - 3);
                            //System.out.println("Fuel reduced by 3");
                        } else {
                            drone.setFuel(drone.getFuel() - 1);
                            //System.out.println("Fuel reduced by 1");
                        }
                        fuelJTextField.setText(String.valueOf(drone.getFuel()));

                    }//learned path end

                }

                if (flag) {
                    if (!insertPath) // we dont have to insert any path as travelled via trained path
                    {
                        System.out.println("Travelled via learned path: " + searchPath);
                        searchPath.setCf(searchPath.getCf() + 1);// increase confiedence factor
                        int fuel = (searchPath.getFuelConsumption() + (100 - drone.getFuel())) / 2; // calculate average fuel consumption
                        searchPath.setFuelConsumption(fuel);
                        MachineLearning.learning.get(drone.getSource()).shuffle(searchPath); // as confiedence factor has changed set nodes position via shuffle
//                   
                        System.out.println("-----------------------");
                    } else { // insert paths available
                        System.out.println("not travelled via learned path: ");
                        currentPath.setCf(currentPath.getCf() + 1);
                        currentPath.setDistance(currentPath.getPath().size());
                        currentPath.setFuelConsumption(100 - drone.getFuel());
                        if (!smallPath.isEmpty()) {
                            for (PathNode p : smallPath) {
                                if (p != null) {
                                    p.setDistance(p.getPath().size());
                                    p.setCf(1); // set confiedence factor as 1 for new paths
                                }
                            }
                        }
//                  
                        System.out.println("-----------------------");
                        if (MachineLearning.learning.contains(drone.getSource())) {
                            System.out.println("Adding new path to linked list");
                            MachineLearning.learning.get(drone.getSource()).enqueue(currentPath); // add new path to the source
                        } else {
                            //source entry is not there in machine
                            System.out.println("Adding new source to hashtable");
                            PathNodeLinkedList value = new PathNodeLinkedList();
                            value.setRoot(currentPath);
                            MachineLearning.learning.put(drone.getSource(), value);
                           
                        }

                    }
                    try {
                        // read machine
                        FileOutputStream fos = new FileOutputStream("C:/Spring2015/Program Structure and Algo/Final_Project/Machine.txt");
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                     
                        oos.writeObject(MachineLearning.learning); // write new machine state and save
            
                        oos.close();

                    } catch (IOException ex) {
                        //System.out.println(ex);
                    }

                    timer.cancel();
                }

                drone.getAnomaly().deleteAnomalies(drone.getNodeMap());
            }
        }, 1000, 1000);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tenZero = new javax.swing.JLabel();
        zeroSixteen = new javax.swing.JLabel();
        thirteenThree = new javax.swing.JLabel();
        sixteenFive = new javax.swing.JLabel();
        thirteenTwo = new javax.swing.JLabel();
        twoTen = new javax.swing.JLabel();
        zeroOne = new javax.swing.JLabel();
        seventeenTen = new javax.swing.JLabel();
        fourteenTen = new javax.swing.JLabel();
        nineteenTen = new javax.swing.JLabel();
        oneOne = new javax.swing.JLabel();
        twoSeventeen = new javax.swing.JLabel();
        nineZero = new javax.swing.JLabel();
        fourEleven = new javax.swing.JLabel();
        thirteenEleven = new javax.swing.JLabel();
        fourFour = new javax.swing.JLabel();
        twelveEighteen = new javax.swing.JLabel();
        zeroEight = new javax.swing.JLabel();
        zeroTwo = new javax.swing.JLabel();
        twelveSeventeen = new javax.swing.JLabel();
        nineEighteen = new javax.swing.JLabel();
        sixTen = new javax.swing.JLabel();
        seventeenSixteen = new javax.swing.JLabel();
        zeroTwelve = new javax.swing.JLabel();
        eightNine = new javax.swing.JLabel();
        thirteenFourteen = new javax.swing.JLabel();
        tenFourteen = new javax.swing.JLabel();
        twoFifteen = new javax.swing.JLabel();
        seventeenEighteen = new javax.swing.JLabel();
        threeThirteen = new javax.swing.JLabel();
        elevenSixteen = new javax.swing.JLabel();
        nineteenEleven = new javax.swing.JLabel();
        fourteenEleven = new javax.swing.JLabel();
        zeroZero = new javax.swing.JLabel();
        eightEleven = new javax.swing.JLabel();
        fourEight = new javax.swing.JLabel();
        fourteenSix = new javax.swing.JLabel();
        seventeenNineteen = new javax.swing.JLabel();
        oneEleven = new javax.swing.JLabel();
        fifteenZero = new javax.swing.JLabel();
        fiveSeven = new javax.swing.JLabel();
        eighteenTen = new javax.swing.JLabel();
        sevenSeventeen = new javax.swing.JLabel();
        eightTen = new javax.swing.JLabel();
        fifteenThree = new javax.swing.JLabel();
        twelveNine = new javax.swing.JLabel();
        sixZero = new javax.swing.JLabel();
        nineteenFive = new javax.swing.JLabel();
        sevenEighteen = new javax.swing.JLabel();
        thirteenZero = new javax.swing.JLabel();
        oneFifteen = new javax.swing.JLabel();
        fiveFifteen = new javax.swing.JLabel();
        fourSix = new javax.swing.JLabel();
        sixteenFour = new javax.swing.JLabel();
        elevenFour = new javax.swing.JLabel();
        zeroFourteen = new javax.swing.JLabel();
        elevenNineteen = new javax.swing.JLabel();
        tenTwo = new javax.swing.JLabel();
        nineThree = new javax.swing.JLabel();
        threeEleven = new javax.swing.JLabel();
        sevenFive = new javax.swing.JLabel();
        oneEighteen = new javax.swing.JLabel();
        twoTwo = new javax.swing.JLabel();
        nineThirteen = new javax.swing.JLabel();
        sixSeventeen = new javax.swing.JLabel();
        elevenEight = new javax.swing.JLabel();
        oneSixteen = new javax.swing.JLabel();
        eighteenOne = new javax.swing.JLabel();
        sevenTen = new javax.swing.JLabel();
        elevenFifteen = new javax.swing.JLabel();
        fourEighteen = new javax.swing.JLabel();
        fifteenSix = new javax.swing.JLabel();
        elevenEighteen = new javax.swing.JLabel();
        fifteenThirteen = new javax.swing.JLabel();
        fourTwelve = new javax.swing.JLabel();
        twoNineteen = new javax.swing.JLabel();
        elevenSeven = new javax.swing.JLabel();
        eighteenNine = new javax.swing.JLabel();
        eightSeven = new javax.swing.JLabel();
        nineNine = new javax.swing.JLabel();
        sevenFourteen = new javax.swing.JLabel();
        threeEight = new javax.swing.JLabel();
        fourteenFifteen = new javax.swing.JLabel();
        sevenTwo = new javax.swing.JLabel();
        oneTwelve = new javax.swing.JLabel();
        nineteenTwelve = new javax.swing.JLabel();
        nineteenZero = new javax.swing.JLabel();
        nineteenThirteen = new javax.swing.JLabel();
        fifteenTen = new javax.swing.JLabel();
        twoThirteen = new javax.swing.JLabel();
        twoEight = new javax.swing.JLabel();
        zeroEleven = new javax.swing.JLabel();
        sevenEight = new javax.swing.JLabel();
        sevenTwelve = new javax.swing.JLabel();
        twoSeven = new javax.swing.JLabel();
        elevenSix = new javax.swing.JLabel();
        fourFourteen = new javax.swing.JLabel();
        eightFifteen = new javax.swing.JLabel();
        sixteenNineteen = new javax.swing.JLabel();
        sixteenTwo = new javax.swing.JLabel();
        sevenThirteen = new javax.swing.JLabel();
        eighteenFourteen = new javax.swing.JLabel();
        eightTwelve = new javax.swing.JLabel();
        thirteenThirteen = new javax.swing.JLabel();
        nineFour = new javax.swing.JLabel();
        eightThree = new javax.swing.JLabel();
        fiveSixteen = new javax.swing.JLabel();
        twoEighteen = new javax.swing.JLabel();
        eightNineteen = new javax.swing.JLabel();
        twelveTwelve = new javax.swing.JLabel();
        nineteenEight = new javax.swing.JLabel();
        fourteenOne = new javax.swing.JLabel();
        twelveZero = new javax.swing.JLabel();
        nineFourteen = new javax.swing.JLabel();
        nineteenSixteen = new javax.swing.JLabel();
        fourOne = new javax.swing.JLabel();
        fiveFour = new javax.swing.JLabel();
        oneSix = new javax.swing.JLabel();
        fifteenFour = new javax.swing.JLabel();
        oneFour = new javax.swing.JLabel();
        sixteenSixteen = new javax.swing.JLabel();
        tenFive = new javax.swing.JLabel();
        eighteenFifteen = new javax.swing.JLabel();
        seventeenThirteen = new javax.swing.JLabel();
        sixThree = new javax.swing.JLabel();
        eightSeventeen = new javax.swing.JLabel();
        sixFifteen = new javax.swing.JLabel();
        sevenFifteen = new javax.swing.JLabel();
        elevenFourteen = new javax.swing.JLabel();
        twelveThirteen = new javax.swing.JLabel();
        fourteenEighteen = new javax.swing.JLabel();
        seventeenFifteen = new javax.swing.JLabel();
        twoSixteen = new javax.swing.JLabel();
        threeZero = new javax.swing.JLabel();
        eightEighteen = new javax.swing.JLabel();
        twoNine = new javax.swing.JLabel();
        oneNineteen = new javax.swing.JLabel();
        eightTwo = new javax.swing.JLabel();
        tenNineteen = new javax.swing.JLabel();
        tenEleven = new javax.swing.JLabel();
        sixteenThree = new javax.swing.JLabel();
        sixteenOne = new javax.swing.JLabel();
        oneThree = new javax.swing.JLabel();
        fourSeventeen = new javax.swing.JLabel();
        oneSeventeen = new javax.swing.JLabel();
        thirteenSeven = new javax.swing.JLabel();
        eightFive = new javax.swing.JLabel();
        fourteenTwelve = new javax.swing.JLabel();
        thirteenFifteen = new javax.swing.JLabel();
        twelveFour = new javax.swing.JLabel();
        eighteenFour = new javax.swing.JLabel();
        nineEight = new javax.swing.JLabel();
        eighteenThirteen = new javax.swing.JLabel();
        seventeenEleven = new javax.swing.JLabel();
        sixteenThirteen = new javax.swing.JLabel();
        sixTwo = new javax.swing.JLabel();
        twelveFive = new javax.swing.JLabel();
        nineSeventeen = new javax.swing.JLabel();
        twoThree = new javax.swing.JLabel();
        eighteenEleven = new javax.swing.JLabel();
        threeTwo = new javax.swing.JLabel();
        fifteenTwo = new javax.swing.JLabel();
        eighteenSix = new javax.swing.JLabel();
        nineSixteen = new javax.swing.JLabel();
        eighteenTwo = new javax.swing.JLabel();
        sixteenTwelve = new javax.swing.JLabel();
        nineteenFour = new javax.swing.JLabel();
        elevenSeventeen = new javax.swing.JLabel();
        fiveThirteen = new javax.swing.JLabel();
        fiveZero = new javax.swing.JLabel();
        zeroThirteen = new javax.swing.JLabel();
        threeSix = new javax.swing.JLabel();
        threeFifteen = new javax.swing.JLabel();
        sixFourteen = new javax.swing.JLabel();
        eightFourteen = new javax.swing.JLabel();
        fifteenOne = new javax.swing.JLabel();
        fourteenThirteen = new javax.swing.JLabel();
        sixSix = new javax.swing.JLabel();
        nineOne = new javax.swing.JLabel();
        threeFour = new javax.swing.JLabel();
        tenSeventeen = new javax.swing.JLabel();
        nineteenFifteen = new javax.swing.JLabel();
        eightThirteen = new javax.swing.JLabel();
        oneTwo = new javax.swing.JLabel();
        threeFourteen = new javax.swing.JLabel();
        fourSeven = new javax.swing.JLabel();
        twelveOne = new javax.swing.JLabel();
        fourteenSeventeen = new javax.swing.JLabel();
        eightSixteen = new javax.swing.JLabel();
        oneEight = new javax.swing.JLabel();
        oneFourteen = new javax.swing.JLabel();
        fiveSix = new javax.swing.JLabel();
        sixteenEleven = new javax.swing.JLabel();
        seventeenZero = new javax.swing.JLabel();
        twoFive = new javax.swing.JLabel();
        sixThirteen = new javax.swing.JLabel();
        fiveEight = new javax.swing.JLabel();
        threeTwelve = new javax.swing.JLabel();
        fiveTen = new javax.swing.JLabel();
        nineteenSeven = new javax.swing.JLabel();
        fifteenFive = new javax.swing.JLabel();
        fifteenNine = new javax.swing.JLabel();
        eighteenEighteen = new javax.swing.JLabel();
        fiveFourteen = new javax.swing.JLabel();
        elevenTen = new javax.swing.JLabel();
        twelveTen = new javax.swing.JLabel();
        zeroNine = new javax.swing.JLabel();
        zeroTen = new javax.swing.JLabel();
        fourteenSeven = new javax.swing.JLabel();
        twelveTwo = new javax.swing.JLabel();
        nineSeven = new javax.swing.JLabel();
        sixteenEight = new javax.swing.JLabel();
        seventeenSeventeen = new javax.swing.JLabel();
        nineteenThree = new javax.swing.JLabel();
        fiveTwelve = new javax.swing.JLabel();
        elevenOne = new javax.swing.JLabel();
        fourteenThree = new javax.swing.JLabel();
        sixNine = new javax.swing.JLabel();
        thirteenTen = new javax.swing.JLabel();
        fourFifteen = new javax.swing.JLabel();
        oneThirteen = new javax.swing.JLabel();
        oneSeven = new javax.swing.JLabel();
        zeroFive = new javax.swing.JLabel();
        thirteenEight = new javax.swing.JLabel();
        sixteenEighteen = new javax.swing.JLabel();
        fourteenFourteen = new javax.swing.JLabel();
        sevenSeven = new javax.swing.JLabel();
        eighteenEight = new javax.swing.JLabel();
        sixFour = new javax.swing.JLabel();
        eighteenThree = new javax.swing.JLabel();
        seventeenSeven = new javax.swing.JLabel();
        sevenEleven = new javax.swing.JLabel();
        tenSix = new javax.swing.JLabel();
        seventeenTwelve = new javax.swing.JLabel();
        threeThree = new javax.swing.JLabel();
        tenOne = new javax.swing.JLabel();
        oneNine = new javax.swing.JLabel();
        sixteenSeventeen = new javax.swing.JLabel();
        threeNine = new javax.swing.JLabel();
        sixteenTen = new javax.swing.JLabel();
        sixteenFifteen = new javax.swing.JLabel();
        seventeenSix = new javax.swing.JLabel();
        nineteenNineteen = new javax.swing.JLabel();
        zeroNineteen = new javax.swing.JLabel();
        eighteenFive = new javax.swing.JLabel();
        thirteenSix = new javax.swing.JLabel();
        twelveThree = new javax.swing.JLabel();
        thirteenFour = new javax.swing.JLabel();
        sixTwelve = new javax.swing.JLabel();
        nineFive = new javax.swing.JLabel();
        fifteenFifteen = new javax.swing.JLabel();
        nineFifteen = new javax.swing.JLabel();
        threeSixteen = new javax.swing.JLabel();
        fourteenTwo = new javax.swing.JLabel();
        twelveSix = new javax.swing.JLabel();
        nineEleven = new javax.swing.JLabel();
        fifteenSeventeen = new javax.swing.JLabel();
        tenEight = new javax.swing.JLabel();
        zeroSeventeen = new javax.swing.JLabel();
        fiveOne = new javax.swing.JLabel();
        fifteenSixteen = new javax.swing.JLabel();
        sixEighteen = new javax.swing.JLabel();
        sevenNine = new javax.swing.JLabel();
        sevenFour = new javax.swing.JLabel();
        thirteenNine = new javax.swing.JLabel();
        twoEleven = new javax.swing.JLabel();
        tenTen = new javax.swing.JLabel();
        sixteenSix = new javax.swing.JLabel();
        twoSix = new javax.swing.JLabel();
        eightFour = new javax.swing.JLabel();
        threeOne = new javax.swing.JLabel();
        zeroFour = new javax.swing.JLabel();
        nineNineteen = new javax.swing.JLabel();
        fourTen = new javax.swing.JLabel();
        sixEleven = new javax.swing.JLabel();
        fourteenFour = new javax.swing.JLabel();
        elevenThree = new javax.swing.JLabel();
        seventeenFive = new javax.swing.JLabel();
        fifteenEighteen = new javax.swing.JLabel();
        zeroSeven = new javax.swing.JLabel();
        elevenEleven = new javax.swing.JLabel();
        twoOne = new javax.swing.JLabel();
        nineteenOne = new javax.swing.JLabel();
        zeroEighteen = new javax.swing.JLabel();
        seventeenOne = new javax.swing.JLabel();
        elevenTwelve = new javax.swing.JLabel();
        tenEighteen = new javax.swing.JLabel();
        seventeenThree = new javax.swing.JLabel();
        fiveEleven = new javax.swing.JLabel();
        fiveNineteen = new javax.swing.JLabel();
        twoFourteen = new javax.swing.JLabel();
        threeTen = new javax.swing.JLabel();
        fourTwo = new javax.swing.JLabel();
        twoFour = new javax.swing.JLabel();
        twelveFifteen = new javax.swing.JLabel();
        eighteenNineteen = new javax.swing.JLabel();
        tenThree = new javax.swing.JLabel();
        fourteenZero = new javax.swing.JLabel();
        tenNine = new javax.swing.JLabel();
        elevenFive = new javax.swing.JLabel();
        eightOne = new javax.swing.JLabel();
        threeSeventeen = new javax.swing.JLabel();
        fifteenTwelve = new javax.swing.JLabel();
        eighteenSixteen = new javax.swing.JLabel();
        twelveFourteen = new javax.swing.JLabel();
        fourteenSixteen = new javax.swing.JLabel();
        zeroFifteen = new javax.swing.JLabel();
        thirteenFive = new javax.swing.JLabel();
        fourThirteen = new javax.swing.JLabel();
        fourNine = new javax.swing.JLabel();
        sixOne = new javax.swing.JLabel();
        fourteenFive = new javax.swing.JLabel();
        eighteenTwelve = new javax.swing.JLabel();
        nineTwelve = new javax.swing.JLabel();
        elevenTwo = new javax.swing.JLabel();
        sixSeven = new javax.swing.JLabel();
        threeEighteen = new javax.swing.JLabel();
        nineTwo = new javax.swing.JLabel();
        fourSixteen = new javax.swing.JLabel();
        twelveSixteen = new javax.swing.JLabel();
        thirteenSeventeen = new javax.swing.JLabel();
        fourThree = new javax.swing.JLabel();
        eighteenZero = new javax.swing.JLabel();
        eighteenSeventeen = new javax.swing.JLabel();
        fourteenNineteen = new javax.swing.JLabel();
        tenThirteen = new javax.swing.JLabel();
        tenFour = new javax.swing.JLabel();
        zeroThree = new javax.swing.JLabel();
        seventeenTwo = new javax.swing.JLabel();
        fifteenNineteen = new javax.swing.JLabel();
        fiveEighteen = new javax.swing.JLabel();
        fiveTwo = new javax.swing.JLabel();
        tenTwelve = new javax.swing.JLabel();
        fifteenSeven = new javax.swing.JLabel();
        twelveNineteen = new javax.swing.JLabel();
        oneTen = new javax.swing.JLabel();
        twoTwelve = new javax.swing.JLabel();
        threeSeven = new javax.swing.JLabel();
        fiveThree = new javax.swing.JLabel();
        threeFive = new javax.swing.JLabel();
        fourFive = new javax.swing.JLabel();
        seventeenFourteen = new javax.swing.JLabel();
        twoZero = new javax.swing.JLabel();
        sevenSixteen = new javax.swing.JLabel();
        sevenThree = new javax.swing.JLabel();
        sixFive = new javax.swing.JLabel();
        twelveEleven = new javax.swing.JLabel();
        thirteenNineteen = new javax.swing.JLabel();
        sevenNineteen = new javax.swing.JLabel();
        fiveFive = new javax.swing.JLabel();
        seventeenFour = new javax.swing.JLabel();
        tenFifteen = new javax.swing.JLabel();
        sevenOne = new javax.swing.JLabel();
        sixNineteen = new javax.swing.JLabel();
        eightEight = new javax.swing.JLabel();
        nineSix = new javax.swing.JLabel();
        thirteenEighteen = new javax.swing.JLabel();
        sixteenSeven = new javax.swing.JLabel();
        nineteenNine = new javax.swing.JLabel();
        sixEight = new javax.swing.JLabel();
        eightSix = new javax.swing.JLabel();
        fiveNine = new javax.swing.JLabel();
        nineTen = new javax.swing.JLabel();
        seventeenEight = new javax.swing.JLabel();
        nineteenSeventeen = new javax.swing.JLabel();
        thirteenTwelve = new javax.swing.JLabel();
        nineteenTwo = new javax.swing.JLabel();
        fourNineteen = new javax.swing.JLabel();
        eightZero = new javax.swing.JLabel();
        nineteenSix = new javax.swing.JLabel();
        fiveSeventeen = new javax.swing.JLabel();
        oneFive = new javax.swing.JLabel();
        oneZero = new javax.swing.JLabel();
        threeNineteen = new javax.swing.JLabel();
        elevenZero = new javax.swing.JLabel();
        thirteenOne = new javax.swing.JLabel();
        sixSixteen = new javax.swing.JLabel();
        nineteenFourteen = new javax.swing.JLabel();
        twelveSeven = new javax.swing.JLabel();
        seventeenNine = new javax.swing.JLabel();
        sixteenNine = new javax.swing.JLabel();
        eighteenSeven = new javax.swing.JLabel();
        sixteenFourteen = new javax.swing.JLabel();
        nineteenEighteen = new javax.swing.JLabel();
        tenSixteen = new javax.swing.JLabel();
        fourZero = new javax.swing.JLabel();
        fifteenEleven = new javax.swing.JLabel();
        fifteenFourteen = new javax.swing.JLabel();
        sixteenZero = new javax.swing.JLabel();
        sevenZero = new javax.swing.JLabel();
        fifteenEight = new javax.swing.JLabel();
        twelveEight = new javax.swing.JLabel();
        elevenNine = new javax.swing.JLabel();
        tenSeven = new javax.swing.JLabel();
        zeroSix = new javax.swing.JLabel();
        elevenThirteen = new javax.swing.JLabel();
        fourteenEight = new javax.swing.JLabel();
        sevenSix = new javax.swing.JLabel();
        fourteenNine = new javax.swing.JLabel();
        thirteenSixteen = new javax.swing.JLabel();
        fuelJTextField = new javax.swing.JTextField();

        tenZero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tenZero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tenZero.setText("($)");
        tenZero.setAlignmentY(0.0F);
        tenZero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tenZero.setName(""); // NOI18N
        tenZero.setPreferredSize(new java.awt.Dimension(15, 15));

        zeroSixteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        zeroSixteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zeroSixteen.setText("($)");
        zeroSixteen.setAlignmentY(0.0F);
        zeroSixteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zeroSixteen.setName(""); // NOI18N
        zeroSixteen.setPreferredSize(new java.awt.Dimension(15, 15));

        thirteenThree.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        thirteenThree.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thirteenThree.setText("($)");
        thirteenThree.setAlignmentY(0.0F);
        thirteenThree.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        thirteenThree.setName(""); // NOI18N
        thirteenThree.setPreferredSize(new java.awt.Dimension(15, 15));

        sixteenFive.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixteenFive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixteenFive.setText("($)");
        sixteenFive.setAlignmentY(0.0F);
        sixteenFive.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixteenFive.setName(""); // NOI18N
        sixteenFive.setPreferredSize(new java.awt.Dimension(15, 15));

        thirteenTwo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        thirteenTwo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thirteenTwo.setText("($)");
        thirteenTwo.setAlignmentY(0.0F);
        thirteenTwo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        thirteenTwo.setName(""); // NOI18N
        thirteenTwo.setPreferredSize(new java.awt.Dimension(15, 15));

        twoTen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twoTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twoTen.setText("($)");
        twoTen.setAlignmentY(0.0F);
        twoTen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twoTen.setName(""); // NOI18N
        twoTen.setPreferredSize(new java.awt.Dimension(15, 15));

        zeroOne.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        zeroOne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zeroOne.setText("($)");
        zeroOne.setAlignmentY(0.0F);
        zeroOne.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zeroOne.setName(""); // NOI18N
        zeroOne.setPreferredSize(new java.awt.Dimension(15, 15));

        seventeenTen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seventeenTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seventeenTen.setText("($)");
        seventeenTen.setAlignmentY(0.0F);
        seventeenTen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        seventeenTen.setName(""); // NOI18N
        seventeenTen.setPreferredSize(new java.awt.Dimension(15, 15));

        fourteenTen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourteenTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourteenTen.setText("($)");
        fourteenTen.setAlignmentY(0.0F);
        fourteenTen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourteenTen.setName(""); // NOI18N
        fourteenTen.setPreferredSize(new java.awt.Dimension(15, 15));

        nineteenTen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineteenTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineteenTen.setText("($)");
        nineteenTen.setAlignmentY(0.0F);
        nineteenTen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineteenTen.setName(""); // NOI18N
        nineteenTen.setPreferredSize(new java.awt.Dimension(15, 15));

        oneOne.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        oneOne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oneOne.setText("($)");
        oneOne.setAlignmentY(0.0F);
        oneOne.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        oneOne.setName(""); // NOI18N
        oneOne.setPreferredSize(new java.awt.Dimension(15, 15));

        twoSeventeen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twoSeventeen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twoSeventeen.setText("($)");
        twoSeventeen.setAlignmentY(0.0F);
        twoSeventeen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twoSeventeen.setName(""); // NOI18N
        twoSeventeen.setPreferredSize(new java.awt.Dimension(15, 15));

        nineZero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineZero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineZero.setText("($)");
        nineZero.setAlignmentY(0.0F);
        nineZero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineZero.setName(""); // NOI18N
        nineZero.setPreferredSize(new java.awt.Dimension(15, 15));

        fourEleven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourEleven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourEleven.setText("($)");
        fourEleven.setAlignmentY(0.0F);
        fourEleven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourEleven.setName(""); // NOI18N
        fourEleven.setPreferredSize(new java.awt.Dimension(15, 15));

        thirteenEleven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        thirteenEleven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thirteenEleven.setText("($)");
        thirteenEleven.setAlignmentY(0.0F);
        thirteenEleven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        thirteenEleven.setName(""); // NOI18N
        thirteenEleven.setPreferredSize(new java.awt.Dimension(15, 15));

        fourFour.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourFour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourFour.setText("($)");
        fourFour.setAlignmentY(0.0F);
        fourFour.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourFour.setName(""); // NOI18N
        fourFour.setPreferredSize(new java.awt.Dimension(15, 15));

        twelveEighteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twelveEighteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twelveEighteen.setText("($)");
        twelveEighteen.setAlignmentY(0.0F);
        twelveEighteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twelveEighteen.setName(""); // NOI18N
        twelveEighteen.setPreferredSize(new java.awt.Dimension(15, 15));

        zeroEight.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        zeroEight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zeroEight.setText("($)");
        zeroEight.setAlignmentY(0.0F);
        zeroEight.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zeroEight.setName(""); // NOI18N
        zeroEight.setPreferredSize(new java.awt.Dimension(15, 15));

        zeroTwo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        zeroTwo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zeroTwo.setText("($)");
        zeroTwo.setAlignmentY(0.0F);
        zeroTwo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zeroTwo.setName(""); // NOI18N
        zeroTwo.setPreferredSize(new java.awt.Dimension(15, 15));

        twelveSeventeen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twelveSeventeen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twelveSeventeen.setText("($)");
        twelveSeventeen.setAlignmentY(0.0F);
        twelveSeventeen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twelveSeventeen.setName(""); // NOI18N
        twelveSeventeen.setPreferredSize(new java.awt.Dimension(15, 15));

        nineEighteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineEighteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineEighteen.setText("($)");
        nineEighteen.setAlignmentY(0.0F);
        nineEighteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineEighteen.setName(""); // NOI18N
        nineEighteen.setPreferredSize(new java.awt.Dimension(15, 15));

        sixTen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixTen.setText("($)");
        sixTen.setAlignmentY(0.0F);
        sixTen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixTen.setName(""); // NOI18N
        sixTen.setPreferredSize(new java.awt.Dimension(15, 15));

        seventeenSixteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seventeenSixteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seventeenSixteen.setText("($)");
        seventeenSixteen.setAlignmentY(0.0F);
        seventeenSixteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        seventeenSixteen.setName(""); // NOI18N
        seventeenSixteen.setPreferredSize(new java.awt.Dimension(15, 15));

        zeroTwelve.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        zeroTwelve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zeroTwelve.setText("($)");
        zeroTwelve.setAlignmentY(0.0F);
        zeroTwelve.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zeroTwelve.setName(""); // NOI18N
        zeroTwelve.setPreferredSize(new java.awt.Dimension(15, 15));

        eightNine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eightNine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eightNine.setText("($)");
        eightNine.setAlignmentY(0.0F);
        eightNine.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eightNine.setName(""); // NOI18N
        eightNine.setPreferredSize(new java.awt.Dimension(15, 15));

        thirteenFourteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        thirteenFourteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thirteenFourteen.setText("($)");
        thirteenFourteen.setAlignmentY(0.0F);
        thirteenFourteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        thirteenFourteen.setName(""); // NOI18N
        thirteenFourteen.setPreferredSize(new java.awt.Dimension(15, 15));

        tenFourteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tenFourteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tenFourteen.setText("($)");
        tenFourteen.setAlignmentY(0.0F);
        tenFourteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tenFourteen.setName(""); // NOI18N
        tenFourteen.setPreferredSize(new java.awt.Dimension(15, 15));

        twoFifteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twoFifteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twoFifteen.setText("($)");
        twoFifteen.setAlignmentY(0.0F);
        twoFifteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twoFifteen.setName(""); // NOI18N
        twoFifteen.setPreferredSize(new java.awt.Dimension(15, 15));

        seventeenEighteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seventeenEighteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seventeenEighteen.setText("($)");
        seventeenEighteen.setAlignmentY(0.0F);
        seventeenEighteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        seventeenEighteen.setName(""); // NOI18N
        seventeenEighteen.setPreferredSize(new java.awt.Dimension(15, 15));

        threeThirteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        threeThirteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        threeThirteen.setText("($)");
        threeThirteen.setAlignmentY(0.0F);
        threeThirteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        threeThirteen.setName(""); // NOI18N
        threeThirteen.setPreferredSize(new java.awt.Dimension(15, 15));

        elevenSixteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        elevenSixteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        elevenSixteen.setText("($)");
        elevenSixteen.setAlignmentY(0.0F);
        elevenSixteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        elevenSixteen.setName(""); // NOI18N
        elevenSixteen.setPreferredSize(new java.awt.Dimension(15, 15));

        nineteenEleven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineteenEleven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineteenEleven.setText("($)");
        nineteenEleven.setAlignmentY(0.0F);
        nineteenEleven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineteenEleven.setName(""); // NOI18N
        nineteenEleven.setPreferredSize(new java.awt.Dimension(15, 15));

        fourteenEleven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourteenEleven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourteenEleven.setText("($)");
        fourteenEleven.setAlignmentY(0.0F);
        fourteenEleven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourteenEleven.setName(""); // NOI18N
        fourteenEleven.setPreferredSize(new java.awt.Dimension(15, 15));

        zeroZero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        zeroZero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zeroZero.setText("($)");
        zeroZero.setAlignmentY(0.0F);
        zeroZero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zeroZero.setName(""); // NOI18N
        zeroZero.setPreferredSize(new java.awt.Dimension(15, 15));

        eightEleven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eightEleven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eightEleven.setText("($)");
        eightEleven.setAlignmentY(0.0F);
        eightEleven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eightEleven.setName(""); // NOI18N
        eightEleven.setPreferredSize(new java.awt.Dimension(15, 15));

        fourEight.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourEight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourEight.setText("($)");
        fourEight.setAlignmentY(0.0F);
        fourEight.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourEight.setName(""); // NOI18N
        fourEight.setPreferredSize(new java.awt.Dimension(15, 15));

        fourteenSix.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourteenSix.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourteenSix.setText("($)");
        fourteenSix.setAlignmentY(0.0F);
        fourteenSix.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourteenSix.setName(""); // NOI18N
        fourteenSix.setPreferredSize(new java.awt.Dimension(15, 15));

        seventeenNineteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seventeenNineteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seventeenNineteen.setText("($)");
        seventeenNineteen.setAlignmentY(0.0F);
        seventeenNineteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        seventeenNineteen.setName(""); // NOI18N
        seventeenNineteen.setPreferredSize(new java.awt.Dimension(15, 15));

        oneEleven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        oneEleven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oneEleven.setText("($)");
        oneEleven.setAlignmentY(0.0F);
        oneEleven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        oneEleven.setName(""); // NOI18N
        oneEleven.setPreferredSize(new java.awt.Dimension(15, 15));

        fifteenZero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fifteenZero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fifteenZero.setText("($)");
        fifteenZero.setAlignmentY(0.0F);
        fifteenZero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fifteenZero.setName(""); // NOI18N
        fifteenZero.setPreferredSize(new java.awt.Dimension(15, 15));

        fiveSeven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fiveSeven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveSeven.setText("($)");
        fiveSeven.setAlignmentY(0.0F);
        fiveSeven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fiveSeven.setName(""); // NOI18N
        fiveSeven.setPreferredSize(new java.awt.Dimension(15, 15));

        eighteenTen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eighteenTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eighteenTen.setText("($)");
        eighteenTen.setAlignmentY(0.0F);
        eighteenTen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eighteenTen.setName(""); // NOI18N
        eighteenTen.setPreferredSize(new java.awt.Dimension(15, 15));

        sevenSeventeen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sevenSeventeen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sevenSeventeen.setText("($)");
        sevenSeventeen.setAlignmentY(0.0F);
        sevenSeventeen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sevenSeventeen.setName(""); // NOI18N
        sevenSeventeen.setPreferredSize(new java.awt.Dimension(15, 15));

        eightTen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eightTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eightTen.setText("($)");
        eightTen.setAlignmentY(0.0F);
        eightTen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eightTen.setName(""); // NOI18N
        eightTen.setPreferredSize(new java.awt.Dimension(15, 15));

        fifteenThree.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fifteenThree.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fifteenThree.setText("($)");
        fifteenThree.setAlignmentY(0.0F);
        fifteenThree.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fifteenThree.setName(""); // NOI18N
        fifteenThree.setPreferredSize(new java.awt.Dimension(15, 15));

        twelveNine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twelveNine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twelveNine.setText("($)");
        twelveNine.setAlignmentY(0.0F);
        twelveNine.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twelveNine.setName(""); // NOI18N
        twelveNine.setPreferredSize(new java.awt.Dimension(15, 15));

        sixZero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixZero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixZero.setText("($)");
        sixZero.setAlignmentY(0.0F);
        sixZero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixZero.setName(""); // NOI18N
        sixZero.setPreferredSize(new java.awt.Dimension(15, 15));

        nineteenFive.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineteenFive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineteenFive.setText("($)");
        nineteenFive.setAlignmentY(0.0F);
        nineteenFive.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineteenFive.setName(""); // NOI18N
        nineteenFive.setPreferredSize(new java.awt.Dimension(15, 15));

        sevenEighteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sevenEighteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sevenEighteen.setText("($)");
        sevenEighteen.setAlignmentY(0.0F);
        sevenEighteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sevenEighteen.setName(""); // NOI18N
        sevenEighteen.setPreferredSize(new java.awt.Dimension(15, 15));

        thirteenZero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        thirteenZero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thirteenZero.setText("($)");
        thirteenZero.setAlignmentY(0.0F);
        thirteenZero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        thirteenZero.setName(""); // NOI18N
        thirteenZero.setPreferredSize(new java.awt.Dimension(15, 15));

        oneFifteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        oneFifteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oneFifteen.setText("($)");
        oneFifteen.setAlignmentY(0.0F);
        oneFifteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        oneFifteen.setName(""); // NOI18N
        oneFifteen.setPreferredSize(new java.awt.Dimension(15, 15));

        fiveFifteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fiveFifteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveFifteen.setText("($)");
        fiveFifteen.setAlignmentY(0.0F);
        fiveFifteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fiveFifteen.setName(""); // NOI18N
        fiveFifteen.setPreferredSize(new java.awt.Dimension(15, 15));

        fourSix.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourSix.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourSix.setText("($)");
        fourSix.setAlignmentY(0.0F);
        fourSix.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourSix.setName(""); // NOI18N
        fourSix.setPreferredSize(new java.awt.Dimension(15, 15));

        sixteenFour.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixteenFour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixteenFour.setText("($)");
        sixteenFour.setAlignmentY(0.0F);
        sixteenFour.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixteenFour.setName(""); // NOI18N
        sixteenFour.setPreferredSize(new java.awt.Dimension(15, 15));

        elevenFour.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        elevenFour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        elevenFour.setText("($)");
        elevenFour.setAlignmentY(0.0F);
        elevenFour.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        elevenFour.setName(""); // NOI18N
        elevenFour.setPreferredSize(new java.awt.Dimension(15, 15));

        zeroFourteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        zeroFourteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zeroFourteen.setText("($)");
        zeroFourteen.setAlignmentY(0.0F);
        zeroFourteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zeroFourteen.setName(""); // NOI18N
        zeroFourteen.setPreferredSize(new java.awt.Dimension(15, 15));

        elevenNineteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        elevenNineteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        elevenNineteen.setText("($)");
        elevenNineteen.setAlignmentY(0.0F);
        elevenNineteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        elevenNineteen.setName(""); // NOI18N
        elevenNineteen.setPreferredSize(new java.awt.Dimension(15, 15));

        tenTwo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tenTwo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tenTwo.setText("($)");
        tenTwo.setAlignmentY(0.0F);
        tenTwo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tenTwo.setName(""); // NOI18N
        tenTwo.setPreferredSize(new java.awt.Dimension(15, 15));

        nineThree.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineThree.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineThree.setText("($)");
        nineThree.setAlignmentY(0.0F);
        nineThree.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineThree.setName(""); // NOI18N
        nineThree.setPreferredSize(new java.awt.Dimension(15, 15));

        threeEleven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        threeEleven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        threeEleven.setText("($)");
        threeEleven.setAlignmentY(0.0F);
        threeEleven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        threeEleven.setName(""); // NOI18N
        threeEleven.setPreferredSize(new java.awt.Dimension(15, 15));

        sevenFive.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sevenFive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sevenFive.setText("($)");
        sevenFive.setAlignmentY(0.0F);
        sevenFive.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sevenFive.setName(""); // NOI18N
        sevenFive.setPreferredSize(new java.awt.Dimension(15, 15));

        oneEighteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        oneEighteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oneEighteen.setText("($)");
        oneEighteen.setAlignmentY(0.0F);
        oneEighteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        oneEighteen.setName(""); // NOI18N
        oneEighteen.setPreferredSize(new java.awt.Dimension(15, 15));

        twoTwo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twoTwo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twoTwo.setText("($)");
        twoTwo.setAlignmentY(0.0F);
        twoTwo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twoTwo.setName(""); // NOI18N
        twoTwo.setPreferredSize(new java.awt.Dimension(15, 15));

        nineThirteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineThirteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineThirteen.setText("($)");
        nineThirteen.setAlignmentY(0.0F);
        nineThirteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineThirteen.setName(""); // NOI18N
        nineThirteen.setPreferredSize(new java.awt.Dimension(15, 15));

        sixSeventeen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixSeventeen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixSeventeen.setText("($)");
        sixSeventeen.setAlignmentY(0.0F);
        sixSeventeen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixSeventeen.setName(""); // NOI18N
        sixSeventeen.setPreferredSize(new java.awt.Dimension(15, 15));

        elevenEight.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        elevenEight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        elevenEight.setText("($)");
        elevenEight.setAlignmentY(0.0F);
        elevenEight.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        elevenEight.setName(""); // NOI18N
        elevenEight.setPreferredSize(new java.awt.Dimension(15, 15));

        oneSixteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        oneSixteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oneSixteen.setText("($)");
        oneSixteen.setAlignmentY(0.0F);
        oneSixteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        oneSixteen.setName(""); // NOI18N
        oneSixteen.setPreferredSize(new java.awt.Dimension(15, 15));

        eighteenOne.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eighteenOne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eighteenOne.setText("($)");
        eighteenOne.setAlignmentY(0.0F);
        eighteenOne.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eighteenOne.setName(""); // NOI18N
        eighteenOne.setPreferredSize(new java.awt.Dimension(15, 15));

        sevenTen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sevenTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sevenTen.setText("($)");
        sevenTen.setAlignmentY(0.0F);
        sevenTen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sevenTen.setName(""); // NOI18N
        sevenTen.setPreferredSize(new java.awt.Dimension(15, 15));

        elevenFifteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        elevenFifteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        elevenFifteen.setText("($)");
        elevenFifteen.setAlignmentY(0.0F);
        elevenFifteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        elevenFifteen.setName(""); // NOI18N
        elevenFifteen.setPreferredSize(new java.awt.Dimension(15, 15));

        fourEighteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourEighteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourEighteen.setText("($)");
        fourEighteen.setAlignmentY(0.0F);
        fourEighteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourEighteen.setName(""); // NOI18N
        fourEighteen.setPreferredSize(new java.awt.Dimension(15, 15));

        fifteenSix.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fifteenSix.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fifteenSix.setText("($)");
        fifteenSix.setAlignmentY(0.0F);
        fifteenSix.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fifteenSix.setName(""); // NOI18N
        fifteenSix.setPreferredSize(new java.awt.Dimension(15, 15));

        elevenEighteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        elevenEighteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        elevenEighteen.setText("($)");
        elevenEighteen.setAlignmentY(0.0F);
        elevenEighteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        elevenEighteen.setName(""); // NOI18N
        elevenEighteen.setPreferredSize(new java.awt.Dimension(15, 15));

        fifteenThirteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fifteenThirteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fifteenThirteen.setText("($)");
        fifteenThirteen.setAlignmentY(0.0F);
        fifteenThirteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fifteenThirteen.setName(""); // NOI18N
        fifteenThirteen.setPreferredSize(new java.awt.Dimension(15, 15));

        fourTwelve.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourTwelve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourTwelve.setText("($)");
        fourTwelve.setAlignmentY(0.0F);
        fourTwelve.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourTwelve.setName(""); // NOI18N
        fourTwelve.setPreferredSize(new java.awt.Dimension(15, 15));

        twoNineteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twoNineteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twoNineteen.setText("($)");
        twoNineteen.setAlignmentY(0.0F);
        twoNineteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twoNineteen.setName(""); // NOI18N
        twoNineteen.setPreferredSize(new java.awt.Dimension(15, 15));

        elevenSeven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        elevenSeven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        elevenSeven.setText("($)");
        elevenSeven.setAlignmentY(0.0F);
        elevenSeven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        elevenSeven.setName(""); // NOI18N
        elevenSeven.setPreferredSize(new java.awt.Dimension(15, 15));

        eighteenNine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eighteenNine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eighteenNine.setText("($)");
        eighteenNine.setAlignmentY(0.0F);
        eighteenNine.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eighteenNine.setName(""); // NOI18N
        eighteenNine.setPreferredSize(new java.awt.Dimension(15, 15));

        eightSeven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eightSeven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eightSeven.setText("($)");
        eightSeven.setAlignmentY(0.0F);
        eightSeven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eightSeven.setName(""); // NOI18N
        eightSeven.setPreferredSize(new java.awt.Dimension(15, 15));

        nineNine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineNine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineNine.setText("($)");
        nineNine.setAlignmentY(0.0F);
        nineNine.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineNine.setName(""); // NOI18N
        nineNine.setPreferredSize(new java.awt.Dimension(15, 15));

        sevenFourteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sevenFourteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sevenFourteen.setText("($)");
        sevenFourteen.setAlignmentY(0.0F);
        sevenFourteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sevenFourteen.setName(""); // NOI18N
        sevenFourteen.setPreferredSize(new java.awt.Dimension(15, 15));

        threeEight.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        threeEight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        threeEight.setText("($)");
        threeEight.setAlignmentY(0.0F);
        threeEight.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        threeEight.setName(""); // NOI18N
        threeEight.setPreferredSize(new java.awt.Dimension(15, 15));

        fourteenFifteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourteenFifteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourteenFifteen.setText("($)");
        fourteenFifteen.setAlignmentY(0.0F);
        fourteenFifteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourteenFifteen.setName(""); // NOI18N
        fourteenFifteen.setPreferredSize(new java.awt.Dimension(15, 15));

        sevenTwo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sevenTwo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sevenTwo.setText("($)");
        sevenTwo.setAlignmentY(0.0F);
        sevenTwo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sevenTwo.setName(""); // NOI18N
        sevenTwo.setPreferredSize(new java.awt.Dimension(15, 15));

        oneTwelve.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        oneTwelve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oneTwelve.setText("($)");
        oneTwelve.setAlignmentY(0.0F);
        oneTwelve.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        oneTwelve.setName(""); // NOI18N
        oneTwelve.setPreferredSize(new java.awt.Dimension(15, 15));

        nineteenTwelve.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineteenTwelve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineteenTwelve.setText("($)");
        nineteenTwelve.setAlignmentY(0.0F);
        nineteenTwelve.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineteenTwelve.setName(""); // NOI18N
        nineteenTwelve.setPreferredSize(new java.awt.Dimension(15, 15));

        nineteenZero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineteenZero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineteenZero.setText("($)");
        nineteenZero.setAlignmentY(0.0F);
        nineteenZero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineteenZero.setName(""); // NOI18N
        nineteenZero.setPreferredSize(new java.awt.Dimension(15, 15));

        nineteenThirteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineteenThirteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineteenThirteen.setText("($)");
        nineteenThirteen.setAlignmentY(0.0F);
        nineteenThirteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineteenThirteen.setName(""); // NOI18N
        nineteenThirteen.setPreferredSize(new java.awt.Dimension(15, 15));

        fifteenTen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fifteenTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fifteenTen.setText("($)");
        fifteenTen.setAlignmentY(0.0F);
        fifteenTen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fifteenTen.setName(""); // NOI18N
        fifteenTen.setPreferredSize(new java.awt.Dimension(15, 15));

        twoThirteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twoThirteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twoThirteen.setText("($)");
        twoThirteen.setAlignmentY(0.0F);
        twoThirteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twoThirteen.setName(""); // NOI18N
        twoThirteen.setPreferredSize(new java.awt.Dimension(15, 15));

        twoEight.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twoEight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twoEight.setText("($)");
        twoEight.setAlignmentY(0.0F);
        twoEight.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twoEight.setName(""); // NOI18N
        twoEight.setPreferredSize(new java.awt.Dimension(15, 15));

        zeroEleven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        zeroEleven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zeroEleven.setText("($)");
        zeroEleven.setAlignmentY(0.0F);
        zeroEleven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zeroEleven.setName(""); // NOI18N
        zeroEleven.setPreferredSize(new java.awt.Dimension(15, 15));

        sevenEight.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sevenEight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sevenEight.setText("($)");
        sevenEight.setAlignmentY(0.0F);
        sevenEight.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sevenEight.setName(""); // NOI18N
        sevenEight.setPreferredSize(new java.awt.Dimension(15, 15));

        sevenTwelve.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sevenTwelve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sevenTwelve.setText("($)");
        sevenTwelve.setAlignmentY(0.0F);
        sevenTwelve.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sevenTwelve.setName(""); // NOI18N
        sevenTwelve.setPreferredSize(new java.awt.Dimension(15, 15));

        twoSeven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twoSeven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twoSeven.setText("($)");
        twoSeven.setAlignmentY(0.0F);
        twoSeven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twoSeven.setName(""); // NOI18N
        twoSeven.setPreferredSize(new java.awt.Dimension(15, 15));

        elevenSix.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        elevenSix.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        elevenSix.setText("($)");
        elevenSix.setAlignmentY(0.0F);
        elevenSix.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        elevenSix.setName(""); // NOI18N
        elevenSix.setPreferredSize(new java.awt.Dimension(15, 15));

        fourFourteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourFourteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourFourteen.setText("($)");
        fourFourteen.setAlignmentY(0.0F);
        fourFourteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourFourteen.setName(""); // NOI18N
        fourFourteen.setPreferredSize(new java.awt.Dimension(15, 15));

        eightFifteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eightFifteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eightFifteen.setText("($)");
        eightFifteen.setAlignmentY(0.0F);
        eightFifteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eightFifteen.setName(""); // NOI18N
        eightFifteen.setPreferredSize(new java.awt.Dimension(15, 15));

        sixteenNineteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixteenNineteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixteenNineteen.setText("($)");
        sixteenNineteen.setAlignmentY(0.0F);
        sixteenNineteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixteenNineteen.setName(""); // NOI18N
        sixteenNineteen.setPreferredSize(new java.awt.Dimension(15, 15));

        sixteenTwo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixteenTwo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixteenTwo.setText("($)");
        sixteenTwo.setAlignmentY(0.0F);
        sixteenTwo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixteenTwo.setName(""); // NOI18N
        sixteenTwo.setPreferredSize(new java.awt.Dimension(15, 15));

        sevenThirteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sevenThirteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sevenThirteen.setText("($)");
        sevenThirteen.setAlignmentY(0.0F);
        sevenThirteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sevenThirteen.setName(""); // NOI18N
        sevenThirteen.setPreferredSize(new java.awt.Dimension(15, 15));

        eighteenFourteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eighteenFourteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eighteenFourteen.setText("($)");
        eighteenFourteen.setAlignmentY(0.0F);
        eighteenFourteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eighteenFourteen.setName(""); // NOI18N
        eighteenFourteen.setPreferredSize(new java.awt.Dimension(15, 15));

        eightTwelve.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eightTwelve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eightTwelve.setText("($)");
        eightTwelve.setAlignmentY(0.0F);
        eightTwelve.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eightTwelve.setName(""); // NOI18N
        eightTwelve.setPreferredSize(new java.awt.Dimension(15, 15));

        thirteenThirteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        thirteenThirteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thirteenThirteen.setText("($)");
        thirteenThirteen.setAlignmentY(0.0F);
        thirteenThirteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        thirteenThirteen.setName(""); // NOI18N
        thirteenThirteen.setPreferredSize(new java.awt.Dimension(15, 15));

        nineFour.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineFour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineFour.setText("($)");
        nineFour.setAlignmentY(0.0F);
        nineFour.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineFour.setName(""); // NOI18N
        nineFour.setPreferredSize(new java.awt.Dimension(15, 15));

        eightThree.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eightThree.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eightThree.setText("($)");
        eightThree.setAlignmentY(0.0F);
        eightThree.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eightThree.setName(""); // NOI18N
        eightThree.setPreferredSize(new java.awt.Dimension(15, 15));

        fiveSixteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fiveSixteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveSixteen.setText("($)");
        fiveSixteen.setAlignmentY(0.0F);
        fiveSixteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fiveSixteen.setName(""); // NOI18N
        fiveSixteen.setPreferredSize(new java.awt.Dimension(15, 15));

        twoEighteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twoEighteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twoEighteen.setText("($)");
        twoEighteen.setAlignmentY(0.0F);
        twoEighteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twoEighteen.setName(""); // NOI18N
        twoEighteen.setPreferredSize(new java.awt.Dimension(15, 15));

        eightNineteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eightNineteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eightNineteen.setText("($)");
        eightNineteen.setAlignmentY(0.0F);
        eightNineteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eightNineteen.setName(""); // NOI18N
        eightNineteen.setPreferredSize(new java.awt.Dimension(15, 15));

        twelveTwelve.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twelveTwelve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twelveTwelve.setText("($)");
        twelveTwelve.setAlignmentY(0.0F);
        twelveTwelve.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twelveTwelve.setName(""); // NOI18N
        twelveTwelve.setPreferredSize(new java.awt.Dimension(15, 15));

        nineteenEight.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineteenEight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineteenEight.setText("($)");
        nineteenEight.setAlignmentY(0.0F);
        nineteenEight.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineteenEight.setName(""); // NOI18N
        nineteenEight.setPreferredSize(new java.awt.Dimension(15, 15));

        fourteenOne.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourteenOne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourteenOne.setText("($)");
        fourteenOne.setAlignmentY(0.0F);
        fourteenOne.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourteenOne.setName(""); // NOI18N
        fourteenOne.setPreferredSize(new java.awt.Dimension(15, 15));

        twelveZero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twelveZero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twelveZero.setText("($)");
        twelveZero.setAlignmentY(0.0F);
        twelveZero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twelveZero.setName(""); // NOI18N
        twelveZero.setPreferredSize(new java.awt.Dimension(15, 15));

        nineFourteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineFourteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineFourteen.setText("($)");
        nineFourteen.setAlignmentY(0.0F);
        nineFourteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineFourteen.setName(""); // NOI18N
        nineFourteen.setPreferredSize(new java.awt.Dimension(15, 15));

        nineteenSixteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineteenSixteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineteenSixteen.setText("($)");
        nineteenSixteen.setAlignmentY(0.0F);
        nineteenSixteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineteenSixteen.setName(""); // NOI18N
        nineteenSixteen.setPreferredSize(new java.awt.Dimension(15, 15));

        fourOne.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourOne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourOne.setText("($)");
        fourOne.setAlignmentY(0.0F);
        fourOne.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourOne.setName(""); // NOI18N
        fourOne.setPreferredSize(new java.awt.Dimension(15, 15));

        fiveFour.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fiveFour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveFour.setText("($)");
        fiveFour.setAlignmentY(0.0F);
        fiveFour.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fiveFour.setName(""); // NOI18N
        fiveFour.setPreferredSize(new java.awt.Dimension(15, 15));

        oneSix.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        oneSix.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oneSix.setText("($)");
        oneSix.setAlignmentY(0.0F);
        oneSix.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        oneSix.setName(""); // NOI18N
        oneSix.setPreferredSize(new java.awt.Dimension(15, 15));

        fifteenFour.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fifteenFour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fifteenFour.setText("($)");
        fifteenFour.setAlignmentY(0.0F);
        fifteenFour.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fifteenFour.setName(""); // NOI18N
        fifteenFour.setPreferredSize(new java.awt.Dimension(15, 15));

        oneFour.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        oneFour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oneFour.setText("($)");
        oneFour.setAlignmentY(0.0F);
        oneFour.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        oneFour.setName(""); // NOI18N
        oneFour.setPreferredSize(new java.awt.Dimension(15, 15));

        sixteenSixteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixteenSixteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixteenSixteen.setText("($)");
        sixteenSixteen.setAlignmentY(0.0F);
        sixteenSixteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixteenSixteen.setName(""); // NOI18N
        sixteenSixteen.setPreferredSize(new java.awt.Dimension(15, 15));

        tenFive.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tenFive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tenFive.setText("($)");
        tenFive.setAlignmentY(0.0F);
        tenFive.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tenFive.setName(""); // NOI18N
        tenFive.setPreferredSize(new java.awt.Dimension(15, 15));

        eighteenFifteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eighteenFifteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eighteenFifteen.setText("($)");
        eighteenFifteen.setAlignmentY(0.0F);
        eighteenFifteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eighteenFifteen.setName(""); // NOI18N
        eighteenFifteen.setPreferredSize(new java.awt.Dimension(15, 15));

        seventeenThirteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seventeenThirteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seventeenThirteen.setText("($)");
        seventeenThirteen.setAlignmentY(0.0F);
        seventeenThirteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        seventeenThirteen.setName(""); // NOI18N
        seventeenThirteen.setPreferredSize(new java.awt.Dimension(15, 15));

        sixThree.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixThree.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixThree.setText("($)");
        sixThree.setAlignmentY(0.0F);
        sixThree.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixThree.setName(""); // NOI18N
        sixThree.setPreferredSize(new java.awt.Dimension(15, 15));

        eightSeventeen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eightSeventeen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eightSeventeen.setText("($)");
        eightSeventeen.setAlignmentY(0.0F);
        eightSeventeen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eightSeventeen.setName(""); // NOI18N
        eightSeventeen.setPreferredSize(new java.awt.Dimension(15, 15));

        sixFifteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixFifteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixFifteen.setText("($)");
        sixFifteen.setAlignmentY(0.0F);
        sixFifteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixFifteen.setName(""); // NOI18N
        sixFifteen.setPreferredSize(new java.awt.Dimension(15, 15));

        sevenFifteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sevenFifteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sevenFifteen.setText("($)");
        sevenFifteen.setAlignmentY(0.0F);
        sevenFifteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sevenFifteen.setName(""); // NOI18N
        sevenFifteen.setPreferredSize(new java.awt.Dimension(15, 15));

        elevenFourteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        elevenFourteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        elevenFourteen.setText("($)");
        elevenFourteen.setAlignmentY(0.0F);
        elevenFourteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        elevenFourteen.setName(""); // NOI18N
        elevenFourteen.setPreferredSize(new java.awt.Dimension(15, 15));

        twelveThirteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twelveThirteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twelveThirteen.setText("($)");
        twelveThirteen.setAlignmentY(0.0F);
        twelveThirteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twelveThirteen.setName(""); // NOI18N
        twelveThirteen.setPreferredSize(new java.awt.Dimension(15, 15));

        fourteenEighteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourteenEighteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourteenEighteen.setText("($)");
        fourteenEighteen.setAlignmentY(0.0F);
        fourteenEighteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourteenEighteen.setName(""); // NOI18N
        fourteenEighteen.setPreferredSize(new java.awt.Dimension(15, 15));

        seventeenFifteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seventeenFifteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seventeenFifteen.setText("($)");
        seventeenFifteen.setAlignmentY(0.0F);
        seventeenFifteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        seventeenFifteen.setName(""); // NOI18N
        seventeenFifteen.setPreferredSize(new java.awt.Dimension(15, 15));

        twoSixteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twoSixteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twoSixteen.setText("($)");
        twoSixteen.setAlignmentY(0.0F);
        twoSixteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twoSixteen.setName(""); // NOI18N
        twoSixteen.setPreferredSize(new java.awt.Dimension(15, 15));

        threeZero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        threeZero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        threeZero.setText("($)");
        threeZero.setAlignmentY(0.0F);
        threeZero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        threeZero.setName(""); // NOI18N
        threeZero.setPreferredSize(new java.awt.Dimension(15, 15));

        eightEighteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eightEighteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eightEighteen.setText("($)");
        eightEighteen.setAlignmentY(0.0F);
        eightEighteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eightEighteen.setName(""); // NOI18N
        eightEighteen.setPreferredSize(new java.awt.Dimension(15, 15));

        twoNine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twoNine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twoNine.setText("($)");
        twoNine.setAlignmentY(0.0F);
        twoNine.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twoNine.setName(""); // NOI18N
        twoNine.setPreferredSize(new java.awt.Dimension(15, 15));

        oneNineteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        oneNineteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oneNineteen.setText("($)");
        oneNineteen.setAlignmentY(0.0F);
        oneNineteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        oneNineteen.setName(""); // NOI18N
        oneNineteen.setPreferredSize(new java.awt.Dimension(15, 15));

        eightTwo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eightTwo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eightTwo.setText("($)");
        eightTwo.setAlignmentY(0.0F);
        eightTwo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eightTwo.setName(""); // NOI18N
        eightTwo.setPreferredSize(new java.awt.Dimension(15, 15));

        tenNineteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tenNineteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tenNineteen.setText("($)");
        tenNineteen.setAlignmentY(0.0F);
        tenNineteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tenNineteen.setName(""); // NOI18N
        tenNineteen.setPreferredSize(new java.awt.Dimension(15, 15));

        tenEleven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tenEleven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tenEleven.setText("($)");
        tenEleven.setAlignmentY(0.0F);
        tenEleven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tenEleven.setName(""); // NOI18N
        tenEleven.setPreferredSize(new java.awt.Dimension(15, 15));

        sixteenThree.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixteenThree.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixteenThree.setText("($)");
        sixteenThree.setAlignmentY(0.0F);
        sixteenThree.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixteenThree.setName(""); // NOI18N
        sixteenThree.setPreferredSize(new java.awt.Dimension(15, 15));

        sixteenOne.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixteenOne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixteenOne.setText("($)");
        sixteenOne.setAlignmentY(0.0F);
        sixteenOne.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixteenOne.setName(""); // NOI18N
        sixteenOne.setPreferredSize(new java.awt.Dimension(15, 15));

        oneThree.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        oneThree.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oneThree.setText("($)");
        oneThree.setAlignmentY(0.0F);
        oneThree.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        oneThree.setName(""); // NOI18N
        oneThree.setPreferredSize(new java.awt.Dimension(15, 15));

        fourSeventeen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourSeventeen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourSeventeen.setText("($)");
        fourSeventeen.setAlignmentY(0.0F);
        fourSeventeen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourSeventeen.setName(""); // NOI18N
        fourSeventeen.setPreferredSize(new java.awt.Dimension(15, 15));

        oneSeventeen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        oneSeventeen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oneSeventeen.setText("($)");
        oneSeventeen.setAlignmentY(0.0F);
        oneSeventeen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        oneSeventeen.setName(""); // NOI18N
        oneSeventeen.setPreferredSize(new java.awt.Dimension(15, 15));

        thirteenSeven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        thirteenSeven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thirteenSeven.setText("($)");
        thirteenSeven.setAlignmentY(0.0F);
        thirteenSeven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        thirteenSeven.setName(""); // NOI18N
        thirteenSeven.setPreferredSize(new java.awt.Dimension(15, 15));

        eightFive.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eightFive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eightFive.setText("($)");
        eightFive.setAlignmentY(0.0F);
        eightFive.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eightFive.setName(""); // NOI18N
        eightFive.setPreferredSize(new java.awt.Dimension(15, 15));

        fourteenTwelve.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourteenTwelve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourteenTwelve.setText("($)");
        fourteenTwelve.setAlignmentY(0.0F);
        fourteenTwelve.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourteenTwelve.setName(""); // NOI18N
        fourteenTwelve.setPreferredSize(new java.awt.Dimension(15, 15));

        thirteenFifteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        thirteenFifteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thirteenFifteen.setText("($)");
        thirteenFifteen.setAlignmentY(0.0F);
        thirteenFifteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        thirteenFifteen.setName(""); // NOI18N
        thirteenFifteen.setPreferredSize(new java.awt.Dimension(15, 15));

        twelveFour.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twelveFour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twelveFour.setText("($)");
        twelveFour.setAlignmentY(0.0F);
        twelveFour.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twelveFour.setName(""); // NOI18N
        twelveFour.setPreferredSize(new java.awt.Dimension(15, 15));

        eighteenFour.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eighteenFour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eighteenFour.setText("($)");
        eighteenFour.setAlignmentY(0.0F);
        eighteenFour.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eighteenFour.setName(""); // NOI18N
        eighteenFour.setPreferredSize(new java.awt.Dimension(15, 15));

        nineEight.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineEight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineEight.setText("($)");
        nineEight.setAlignmentY(0.0F);
        nineEight.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineEight.setName(""); // NOI18N
        nineEight.setPreferredSize(new java.awt.Dimension(15, 15));

        eighteenThirteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eighteenThirteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eighteenThirteen.setText("($)");
        eighteenThirteen.setAlignmentY(0.0F);
        eighteenThirteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eighteenThirteen.setName(""); // NOI18N
        eighteenThirteen.setPreferredSize(new java.awt.Dimension(15, 15));

        seventeenEleven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seventeenEleven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seventeenEleven.setText("($)");
        seventeenEleven.setAlignmentY(0.0F);
        seventeenEleven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        seventeenEleven.setName(""); // NOI18N
        seventeenEleven.setPreferredSize(new java.awt.Dimension(15, 15));

        sixteenThirteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixteenThirteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixteenThirteen.setText("($)");
        sixteenThirteen.setAlignmentY(0.0F);
        sixteenThirteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixteenThirteen.setName(""); // NOI18N
        sixteenThirteen.setPreferredSize(new java.awt.Dimension(15, 15));

        sixTwo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixTwo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixTwo.setText("($)");
        sixTwo.setAlignmentY(0.0F);
        sixTwo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixTwo.setName(""); // NOI18N
        sixTwo.setPreferredSize(new java.awt.Dimension(15, 15));

        twelveFive.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twelveFive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twelveFive.setText("($)");
        twelveFive.setAlignmentY(0.0F);
        twelveFive.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twelveFive.setName(""); // NOI18N
        twelveFive.setPreferredSize(new java.awt.Dimension(15, 15));

        nineSeventeen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineSeventeen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineSeventeen.setText("($)");
        nineSeventeen.setAlignmentY(0.0F);
        nineSeventeen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineSeventeen.setName(""); // NOI18N
        nineSeventeen.setPreferredSize(new java.awt.Dimension(15, 15));

        twoThree.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twoThree.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twoThree.setText("($)");
        twoThree.setAlignmentY(0.0F);
        twoThree.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twoThree.setName(""); // NOI18N
        twoThree.setPreferredSize(new java.awt.Dimension(15, 15));

        eighteenEleven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eighteenEleven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eighteenEleven.setText("($)");
        eighteenEleven.setAlignmentY(0.0F);
        eighteenEleven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eighteenEleven.setName(""); // NOI18N
        eighteenEleven.setPreferredSize(new java.awt.Dimension(15, 15));

        threeTwo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        threeTwo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        threeTwo.setText("($)");
        threeTwo.setAlignmentY(0.0F);
        threeTwo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        threeTwo.setName(""); // NOI18N
        threeTwo.setPreferredSize(new java.awt.Dimension(15, 15));

        fifteenTwo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fifteenTwo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fifteenTwo.setText("($)");
        fifteenTwo.setAlignmentY(0.0F);
        fifteenTwo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fifteenTwo.setName(""); // NOI18N
        fifteenTwo.setPreferredSize(new java.awt.Dimension(15, 15));

        eighteenSix.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eighteenSix.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eighteenSix.setText("($)");
        eighteenSix.setAlignmentY(0.0F);
        eighteenSix.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eighteenSix.setName(""); // NOI18N
        eighteenSix.setPreferredSize(new java.awt.Dimension(15, 15));

        nineSixteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineSixteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineSixteen.setText("($)");
        nineSixteen.setAlignmentY(0.0F);
        nineSixteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineSixteen.setName(""); // NOI18N
        nineSixteen.setPreferredSize(new java.awt.Dimension(15, 15));

        eighteenTwo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eighteenTwo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eighteenTwo.setText("($)");
        eighteenTwo.setAlignmentY(0.0F);
        eighteenTwo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eighteenTwo.setName(""); // NOI18N
        eighteenTwo.setPreferredSize(new java.awt.Dimension(15, 15));

        sixteenTwelve.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixteenTwelve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixteenTwelve.setText("($)");
        sixteenTwelve.setAlignmentY(0.0F);
        sixteenTwelve.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixteenTwelve.setName(""); // NOI18N
        sixteenTwelve.setPreferredSize(new java.awt.Dimension(15, 15));

        nineteenFour.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineteenFour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineteenFour.setText("($)");
        nineteenFour.setAlignmentY(0.0F);
        nineteenFour.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineteenFour.setName(""); // NOI18N
        nineteenFour.setPreferredSize(new java.awt.Dimension(15, 15));

        elevenSeventeen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        elevenSeventeen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        elevenSeventeen.setText("($)");
        elevenSeventeen.setAlignmentY(0.0F);
        elevenSeventeen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        elevenSeventeen.setName(""); // NOI18N
        elevenSeventeen.setPreferredSize(new java.awt.Dimension(15, 15));

        fiveThirteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fiveThirteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveThirteen.setText("($)");
        fiveThirteen.setAlignmentY(0.0F);
        fiveThirteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fiveThirteen.setName(""); // NOI18N
        fiveThirteen.setPreferredSize(new java.awt.Dimension(15, 15));

        fiveZero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fiveZero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveZero.setText("($)");
        fiveZero.setAlignmentY(0.0F);
        fiveZero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fiveZero.setName(""); // NOI18N
        fiveZero.setPreferredSize(new java.awt.Dimension(15, 15));

        zeroThirteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        zeroThirteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zeroThirteen.setText("($)");
        zeroThirteen.setAlignmentY(0.0F);
        zeroThirteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zeroThirteen.setName(""); // NOI18N
        zeroThirteen.setPreferredSize(new java.awt.Dimension(15, 15));

        threeSix.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        threeSix.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        threeSix.setText("($)");
        threeSix.setAlignmentY(0.0F);
        threeSix.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        threeSix.setName(""); // NOI18N
        threeSix.setPreferredSize(new java.awt.Dimension(15, 15));

        threeFifteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        threeFifteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        threeFifteen.setText("($)");
        threeFifteen.setAlignmentY(0.0F);
        threeFifteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        threeFifteen.setName(""); // NOI18N
        threeFifteen.setPreferredSize(new java.awt.Dimension(15, 15));

        sixFourteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixFourteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixFourteen.setText("($)");
        sixFourteen.setAlignmentY(0.0F);
        sixFourteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixFourteen.setName(""); // NOI18N
        sixFourteen.setPreferredSize(new java.awt.Dimension(15, 15));

        eightFourteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eightFourteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eightFourteen.setText("($)");
        eightFourteen.setAlignmentY(0.0F);
        eightFourteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eightFourteen.setName(""); // NOI18N
        eightFourteen.setPreferredSize(new java.awt.Dimension(15, 15));

        fifteenOne.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fifteenOne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fifteenOne.setText("($)");
        fifteenOne.setAlignmentY(0.0F);
        fifteenOne.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fifteenOne.setName(""); // NOI18N
        fifteenOne.setPreferredSize(new java.awt.Dimension(15, 15));

        fourteenThirteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourteenThirteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourteenThirteen.setText("($)");
        fourteenThirteen.setAlignmentY(0.0F);
        fourteenThirteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourteenThirteen.setName(""); // NOI18N
        fourteenThirteen.setPreferredSize(new java.awt.Dimension(15, 15));

        sixSix.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixSix.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixSix.setText("($)");
        sixSix.setAlignmentY(0.0F);
        sixSix.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixSix.setName(""); // NOI18N
        sixSix.setPreferredSize(new java.awt.Dimension(15, 15));

        nineOne.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineOne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineOne.setText("($)");
        nineOne.setAlignmentY(0.0F);
        nineOne.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineOne.setName(""); // NOI18N
        nineOne.setPreferredSize(new java.awt.Dimension(15, 15));

        threeFour.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        threeFour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        threeFour.setText("($)");
        threeFour.setAlignmentY(0.0F);
        threeFour.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        threeFour.setName(""); // NOI18N
        threeFour.setPreferredSize(new java.awt.Dimension(15, 15));

        tenSeventeen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tenSeventeen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tenSeventeen.setText("($)");
        tenSeventeen.setAlignmentY(0.0F);
        tenSeventeen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tenSeventeen.setName(""); // NOI18N
        tenSeventeen.setPreferredSize(new java.awt.Dimension(15, 15));

        nineteenFifteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineteenFifteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineteenFifteen.setText("($)");
        nineteenFifteen.setAlignmentY(0.0F);
        nineteenFifteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineteenFifteen.setName(""); // NOI18N
        nineteenFifteen.setPreferredSize(new java.awt.Dimension(15, 15));

        eightThirteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eightThirteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eightThirteen.setText("($)");
        eightThirteen.setAlignmentY(0.0F);
        eightThirteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eightThirteen.setName(""); // NOI18N
        eightThirteen.setPreferredSize(new java.awt.Dimension(15, 15));

        oneTwo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        oneTwo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oneTwo.setText("($)");
        oneTwo.setAlignmentY(0.0F);
        oneTwo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        oneTwo.setName(""); // NOI18N
        oneTwo.setPreferredSize(new java.awt.Dimension(15, 15));

        threeFourteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        threeFourteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        threeFourteen.setText("($)");
        threeFourteen.setAlignmentY(0.0F);
        threeFourteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        threeFourteen.setName(""); // NOI18N
        threeFourteen.setPreferredSize(new java.awt.Dimension(15, 15));

        fourSeven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourSeven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourSeven.setText("($)");
        fourSeven.setAlignmentY(0.0F);
        fourSeven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourSeven.setName(""); // NOI18N
        fourSeven.setPreferredSize(new java.awt.Dimension(15, 15));

        twelveOne.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twelveOne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twelveOne.setText("($)");
        twelveOne.setAlignmentY(0.0F);
        twelveOne.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twelveOne.setName(""); // NOI18N
        twelveOne.setPreferredSize(new java.awt.Dimension(15, 15));

        fourteenSeventeen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourteenSeventeen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourteenSeventeen.setText("($)");
        fourteenSeventeen.setAlignmentY(0.0F);
        fourteenSeventeen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourteenSeventeen.setName(""); // NOI18N
        fourteenSeventeen.setPreferredSize(new java.awt.Dimension(15, 15));

        eightSixteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eightSixteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eightSixteen.setText("($)");
        eightSixteen.setAlignmentY(0.0F);
        eightSixteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eightSixteen.setName(""); // NOI18N
        eightSixteen.setPreferredSize(new java.awt.Dimension(15, 15));

        oneEight.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        oneEight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oneEight.setText("($)");
        oneEight.setAlignmentY(0.0F);
        oneEight.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        oneEight.setName(""); // NOI18N
        oneEight.setPreferredSize(new java.awt.Dimension(15, 15));

        oneFourteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        oneFourteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oneFourteen.setText("($)");
        oneFourteen.setAlignmentY(0.0F);
        oneFourteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        oneFourteen.setName(""); // NOI18N
        oneFourteen.setPreferredSize(new java.awt.Dimension(15, 15));

        fiveSix.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fiveSix.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveSix.setText("($)");
        fiveSix.setAlignmentY(0.0F);
        fiveSix.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fiveSix.setName(""); // NOI18N
        fiveSix.setPreferredSize(new java.awt.Dimension(15, 15));

        sixteenEleven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixteenEleven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixteenEleven.setText("($)");
        sixteenEleven.setAlignmentY(0.0F);
        sixteenEleven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixteenEleven.setName(""); // NOI18N
        sixteenEleven.setPreferredSize(new java.awt.Dimension(15, 15));

        seventeenZero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seventeenZero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seventeenZero.setText("($)");
        seventeenZero.setAlignmentY(0.0F);
        seventeenZero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        seventeenZero.setName(""); // NOI18N
        seventeenZero.setPreferredSize(new java.awt.Dimension(15, 15));

        twoFive.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twoFive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twoFive.setText("($)");
        twoFive.setAlignmentY(0.0F);
        twoFive.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twoFive.setName(""); // NOI18N
        twoFive.setPreferredSize(new java.awt.Dimension(15, 15));

        sixThirteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixThirteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixThirteen.setText("($)");
        sixThirteen.setAlignmentY(0.0F);
        sixThirteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixThirteen.setName(""); // NOI18N
        sixThirteen.setPreferredSize(new java.awt.Dimension(15, 15));

        fiveEight.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fiveEight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveEight.setText("($)");
        fiveEight.setAlignmentY(0.0F);
        fiveEight.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fiveEight.setName(""); // NOI18N
        fiveEight.setPreferredSize(new java.awt.Dimension(15, 15));

        threeTwelve.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        threeTwelve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        threeTwelve.setText("($)");
        threeTwelve.setAlignmentY(0.0F);
        threeTwelve.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        threeTwelve.setName(""); // NOI18N
        threeTwelve.setPreferredSize(new java.awt.Dimension(15, 15));

        fiveTen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fiveTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveTen.setText("($)");
        fiveTen.setAlignmentY(0.0F);
        fiveTen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fiveTen.setName(""); // NOI18N
        fiveTen.setPreferredSize(new java.awt.Dimension(15, 15));

        nineteenSeven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineteenSeven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineteenSeven.setText("($)");
        nineteenSeven.setAlignmentY(0.0F);
        nineteenSeven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineteenSeven.setName(""); // NOI18N
        nineteenSeven.setPreferredSize(new java.awt.Dimension(15, 15));

        fifteenFive.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fifteenFive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fifteenFive.setText("($)");
        fifteenFive.setAlignmentY(0.0F);
        fifteenFive.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fifteenFive.setName(""); // NOI18N
        fifteenFive.setPreferredSize(new java.awt.Dimension(15, 15));

        fifteenNine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fifteenNine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fifteenNine.setText("($)");
        fifteenNine.setAlignmentY(0.0F);
        fifteenNine.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fifteenNine.setName(""); // NOI18N
        fifteenNine.setPreferredSize(new java.awt.Dimension(15, 15));

        eighteenEighteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eighteenEighteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eighteenEighteen.setText("($)");
        eighteenEighteen.setAlignmentY(0.0F);
        eighteenEighteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eighteenEighteen.setName(""); // NOI18N
        eighteenEighteen.setPreferredSize(new java.awt.Dimension(15, 15));

        fiveFourteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fiveFourteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveFourteen.setText("($)");
        fiveFourteen.setAlignmentY(0.0F);
        fiveFourteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fiveFourteen.setName(""); // NOI18N
        fiveFourteen.setPreferredSize(new java.awt.Dimension(15, 15));

        elevenTen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        elevenTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        elevenTen.setText("($)");
        elevenTen.setAlignmentY(0.0F);
        elevenTen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        elevenTen.setName(""); // NOI18N
        elevenTen.setPreferredSize(new java.awt.Dimension(15, 15));

        twelveTen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twelveTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twelveTen.setText("($)");
        twelveTen.setAlignmentY(0.0F);
        twelveTen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twelveTen.setName(""); // NOI18N
        twelveTen.setPreferredSize(new java.awt.Dimension(15, 15));

        zeroNine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        zeroNine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zeroNine.setText("($)");
        zeroNine.setAlignmentY(0.0F);
        zeroNine.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zeroNine.setName(""); // NOI18N
        zeroNine.setPreferredSize(new java.awt.Dimension(15, 15));

        zeroTen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        zeroTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zeroTen.setText("($)");
        zeroTen.setAlignmentY(0.0F);
        zeroTen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zeroTen.setName(""); // NOI18N
        zeroTen.setPreferredSize(new java.awt.Dimension(15, 15));

        fourteenSeven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourteenSeven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourteenSeven.setText("($)");
        fourteenSeven.setAlignmentY(0.0F);
        fourteenSeven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourteenSeven.setName(""); // NOI18N
        fourteenSeven.setPreferredSize(new java.awt.Dimension(15, 15));

        twelveTwo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twelveTwo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twelveTwo.setText("($)");
        twelveTwo.setAlignmentY(0.0F);
        twelveTwo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twelveTwo.setName(""); // NOI18N
        twelveTwo.setPreferredSize(new java.awt.Dimension(15, 15));

        nineSeven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineSeven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineSeven.setText("($)");
        nineSeven.setAlignmentY(0.0F);
        nineSeven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineSeven.setName(""); // NOI18N
        nineSeven.setPreferredSize(new java.awt.Dimension(15, 15));

        sixteenEight.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixteenEight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixteenEight.setText("($)");
        sixteenEight.setAlignmentY(0.0F);
        sixteenEight.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixteenEight.setName(""); // NOI18N
        sixteenEight.setPreferredSize(new java.awt.Dimension(15, 15));

        seventeenSeventeen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seventeenSeventeen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seventeenSeventeen.setText("($)");
        seventeenSeventeen.setAlignmentY(0.0F);
        seventeenSeventeen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        seventeenSeventeen.setName(""); // NOI18N
        seventeenSeventeen.setPreferredSize(new java.awt.Dimension(15, 15));

        nineteenThree.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineteenThree.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineteenThree.setText("($)");
        nineteenThree.setAlignmentY(0.0F);
        nineteenThree.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineteenThree.setName(""); // NOI18N
        nineteenThree.setPreferredSize(new java.awt.Dimension(15, 15));

        fiveTwelve.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fiveTwelve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveTwelve.setText("($)");
        fiveTwelve.setAlignmentY(0.0F);
        fiveTwelve.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fiveTwelve.setName(""); // NOI18N
        fiveTwelve.setPreferredSize(new java.awt.Dimension(15, 15));

        elevenOne.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        elevenOne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        elevenOne.setText("($)");
        elevenOne.setAlignmentY(0.0F);
        elevenOne.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        elevenOne.setName(""); // NOI18N
        elevenOne.setPreferredSize(new java.awt.Dimension(15, 15));

        fourteenThree.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourteenThree.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourteenThree.setText("($)");
        fourteenThree.setAlignmentY(0.0F);
        fourteenThree.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourteenThree.setName(""); // NOI18N
        fourteenThree.setPreferredSize(new java.awt.Dimension(15, 15));

        sixNine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixNine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixNine.setText("($)");
        sixNine.setAlignmentY(0.0F);
        sixNine.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixNine.setName(""); // NOI18N
        sixNine.setPreferredSize(new java.awt.Dimension(15, 15));

        thirteenTen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        thirteenTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thirteenTen.setText("($)");
        thirteenTen.setAlignmentY(0.0F);
        thirteenTen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        thirteenTen.setName(""); // NOI18N
        thirteenTen.setPreferredSize(new java.awt.Dimension(15, 15));

        fourFifteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourFifteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourFifteen.setText("($)");
        fourFifteen.setAlignmentY(0.0F);
        fourFifteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourFifteen.setName(""); // NOI18N
        fourFifteen.setPreferredSize(new java.awt.Dimension(15, 15));

        oneThirteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        oneThirteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oneThirteen.setText("($)");
        oneThirteen.setAlignmentY(0.0F);
        oneThirteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        oneThirteen.setName(""); // NOI18N
        oneThirteen.setPreferredSize(new java.awt.Dimension(15, 15));

        oneSeven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        oneSeven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oneSeven.setText("($)");
        oneSeven.setAlignmentY(0.0F);
        oneSeven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        oneSeven.setName(""); // NOI18N
        oneSeven.setPreferredSize(new java.awt.Dimension(15, 15));

        zeroFive.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        zeroFive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zeroFive.setText("($)");
        zeroFive.setAlignmentY(0.0F);
        zeroFive.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zeroFive.setName(""); // NOI18N
        zeroFive.setPreferredSize(new java.awt.Dimension(15, 15));

        thirteenEight.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        thirteenEight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thirteenEight.setText("($)");
        thirteenEight.setAlignmentY(0.0F);
        thirteenEight.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        thirteenEight.setName(""); // NOI18N
        thirteenEight.setPreferredSize(new java.awt.Dimension(15, 15));

        sixteenEighteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixteenEighteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixteenEighteen.setText("($)");
        sixteenEighteen.setAlignmentY(0.0F);
        sixteenEighteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixteenEighteen.setName(""); // NOI18N
        sixteenEighteen.setPreferredSize(new java.awt.Dimension(15, 15));

        fourteenFourteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourteenFourteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourteenFourteen.setText("($)");
        fourteenFourteen.setAlignmentY(0.0F);
        fourteenFourteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourteenFourteen.setName(""); // NOI18N
        fourteenFourteen.setPreferredSize(new java.awt.Dimension(15, 15));

        sevenSeven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sevenSeven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sevenSeven.setText("($)");
        sevenSeven.setAlignmentY(0.0F);
        sevenSeven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sevenSeven.setName(""); // NOI18N
        sevenSeven.setPreferredSize(new java.awt.Dimension(15, 15));

        eighteenEight.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eighteenEight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eighteenEight.setText("($)");
        eighteenEight.setAlignmentY(0.0F);
        eighteenEight.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eighteenEight.setName(""); // NOI18N
        eighteenEight.setPreferredSize(new java.awt.Dimension(15, 15));

        sixFour.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixFour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixFour.setText("($)");
        sixFour.setAlignmentY(0.0F);
        sixFour.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixFour.setName(""); // NOI18N
        sixFour.setPreferredSize(new java.awt.Dimension(15, 15));

        eighteenThree.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eighteenThree.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eighteenThree.setText("($)");
        eighteenThree.setAlignmentY(0.0F);
        eighteenThree.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eighteenThree.setName(""); // NOI18N
        eighteenThree.setPreferredSize(new java.awt.Dimension(15, 15));

        seventeenSeven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seventeenSeven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seventeenSeven.setText("($)");
        seventeenSeven.setAlignmentY(0.0F);
        seventeenSeven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        seventeenSeven.setName(""); // NOI18N
        seventeenSeven.setPreferredSize(new java.awt.Dimension(15, 15));

        sevenEleven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sevenEleven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sevenEleven.setText("($)");
        sevenEleven.setAlignmentY(0.0F);
        sevenEleven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sevenEleven.setName(""); // NOI18N
        sevenEleven.setPreferredSize(new java.awt.Dimension(15, 15));

        tenSix.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tenSix.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tenSix.setText("($)");
        tenSix.setAlignmentY(0.0F);
        tenSix.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tenSix.setName(""); // NOI18N
        tenSix.setPreferredSize(new java.awt.Dimension(15, 15));

        seventeenTwelve.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seventeenTwelve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seventeenTwelve.setText("($)");
        seventeenTwelve.setAlignmentY(0.0F);
        seventeenTwelve.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        seventeenTwelve.setName(""); // NOI18N
        seventeenTwelve.setPreferredSize(new java.awt.Dimension(15, 15));

        threeThree.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        threeThree.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        threeThree.setText("($)");
        threeThree.setAlignmentY(0.0F);
        threeThree.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        threeThree.setName(""); // NOI18N
        threeThree.setPreferredSize(new java.awt.Dimension(15, 15));

        tenOne.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tenOne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tenOne.setText("($)");
        tenOne.setAlignmentY(0.0F);
        tenOne.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tenOne.setName(""); // NOI18N
        tenOne.setPreferredSize(new java.awt.Dimension(15, 15));

        oneNine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        oneNine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oneNine.setText("($)");
        oneNine.setAlignmentY(0.0F);
        oneNine.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        oneNine.setName(""); // NOI18N
        oneNine.setPreferredSize(new java.awt.Dimension(15, 15));

        sixteenSeventeen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixteenSeventeen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixteenSeventeen.setText("($)");
        sixteenSeventeen.setAlignmentY(0.0F);
        sixteenSeventeen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixteenSeventeen.setName(""); // NOI18N
        sixteenSeventeen.setPreferredSize(new java.awt.Dimension(15, 15));

        threeNine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        threeNine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        threeNine.setText("($)");
        threeNine.setAlignmentY(0.0F);
        threeNine.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        threeNine.setName(""); // NOI18N
        threeNine.setPreferredSize(new java.awt.Dimension(15, 15));

        sixteenTen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixteenTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixteenTen.setText("($)");
        sixteenTen.setAlignmentY(0.0F);
        sixteenTen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixteenTen.setName(""); // NOI18N
        sixteenTen.setPreferredSize(new java.awt.Dimension(15, 15));

        sixteenFifteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixteenFifteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixteenFifteen.setText("($)");
        sixteenFifteen.setAlignmentY(0.0F);
        sixteenFifteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixteenFifteen.setName(""); // NOI18N
        sixteenFifteen.setPreferredSize(new java.awt.Dimension(15, 15));

        seventeenSix.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seventeenSix.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seventeenSix.setText("($)");
        seventeenSix.setAlignmentY(0.0F);
        seventeenSix.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        seventeenSix.setName(""); // NOI18N
        seventeenSix.setPreferredSize(new java.awt.Dimension(15, 15));

        nineteenNineteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineteenNineteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineteenNineteen.setText("($)");
        nineteenNineteen.setAlignmentY(0.0F);
        nineteenNineteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineteenNineteen.setName(""); // NOI18N
        nineteenNineteen.setPreferredSize(new java.awt.Dimension(15, 15));

        zeroNineteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        zeroNineteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zeroNineteen.setText("($)");
        zeroNineteen.setAlignmentY(0.0F);
        zeroNineteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zeroNineteen.setName(""); // NOI18N
        zeroNineteen.setPreferredSize(new java.awt.Dimension(15, 15));

        eighteenFive.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eighteenFive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eighteenFive.setText("($)");
        eighteenFive.setAlignmentY(0.0F);
        eighteenFive.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eighteenFive.setName(""); // NOI18N
        eighteenFive.setPreferredSize(new java.awt.Dimension(15, 15));

        thirteenSix.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        thirteenSix.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thirteenSix.setText("($)");
        thirteenSix.setAlignmentY(0.0F);
        thirteenSix.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        thirteenSix.setName(""); // NOI18N
        thirteenSix.setPreferredSize(new java.awt.Dimension(15, 15));

        twelveThree.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twelveThree.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twelveThree.setText("($)");
        twelveThree.setAlignmentY(0.0F);
        twelveThree.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twelveThree.setName(""); // NOI18N
        twelveThree.setPreferredSize(new java.awt.Dimension(15, 15));

        thirteenFour.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        thirteenFour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thirteenFour.setText("($)");
        thirteenFour.setAlignmentY(0.0F);
        thirteenFour.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        thirteenFour.setName(""); // NOI18N
        thirteenFour.setPreferredSize(new java.awt.Dimension(15, 15));

        sixTwelve.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixTwelve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixTwelve.setText("($)");
        sixTwelve.setAlignmentY(0.0F);
        sixTwelve.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixTwelve.setName(""); // NOI18N
        sixTwelve.setPreferredSize(new java.awt.Dimension(15, 15));

        nineFive.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineFive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineFive.setText("($)");
        nineFive.setAlignmentY(0.0F);
        nineFive.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineFive.setName(""); // NOI18N
        nineFive.setPreferredSize(new java.awt.Dimension(15, 15));

        fifteenFifteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fifteenFifteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fifteenFifteen.setText("($)");
        fifteenFifteen.setAlignmentY(0.0F);
        fifteenFifteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fifteenFifteen.setName(""); // NOI18N
        fifteenFifteen.setPreferredSize(new java.awt.Dimension(15, 15));

        nineFifteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineFifteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineFifteen.setText("($)");
        nineFifteen.setAlignmentY(0.0F);
        nineFifteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineFifteen.setName(""); // NOI18N
        nineFifteen.setPreferredSize(new java.awt.Dimension(15, 15));

        threeSixteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        threeSixteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        threeSixteen.setText("($)");
        threeSixteen.setAlignmentY(0.0F);
        threeSixteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        threeSixteen.setName(""); // NOI18N
        threeSixteen.setPreferredSize(new java.awt.Dimension(15, 15));

        fourteenTwo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourteenTwo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourteenTwo.setText("($)");
        fourteenTwo.setAlignmentY(0.0F);
        fourteenTwo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourteenTwo.setName(""); // NOI18N
        fourteenTwo.setPreferredSize(new java.awt.Dimension(15, 15));

        twelveSix.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twelveSix.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twelveSix.setText("($)");
        twelveSix.setAlignmentY(0.0F);
        twelveSix.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twelveSix.setName(""); // NOI18N
        twelveSix.setPreferredSize(new java.awt.Dimension(15, 15));

        nineEleven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineEleven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineEleven.setText("($)");
        nineEleven.setAlignmentY(0.0F);
        nineEleven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineEleven.setName(""); // NOI18N
        nineEleven.setPreferredSize(new java.awt.Dimension(15, 15));

        fifteenSeventeen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fifteenSeventeen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fifteenSeventeen.setText("($)");
        fifteenSeventeen.setAlignmentY(0.0F);
        fifteenSeventeen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fifteenSeventeen.setName(""); // NOI18N
        fifteenSeventeen.setPreferredSize(new java.awt.Dimension(15, 15));

        tenEight.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tenEight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tenEight.setText("($)");
        tenEight.setAlignmentY(0.0F);
        tenEight.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tenEight.setName(""); // NOI18N
        tenEight.setPreferredSize(new java.awt.Dimension(15, 15));

        zeroSeventeen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        zeroSeventeen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zeroSeventeen.setText("($)");
        zeroSeventeen.setAlignmentY(0.0F);
        zeroSeventeen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zeroSeventeen.setName(""); // NOI18N
        zeroSeventeen.setPreferredSize(new java.awt.Dimension(15, 15));

        fiveOne.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fiveOne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveOne.setText("($)");
        fiveOne.setAlignmentY(0.0F);
        fiveOne.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fiveOne.setName(""); // NOI18N
        fiveOne.setPreferredSize(new java.awt.Dimension(15, 15));

        fifteenSixteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fifteenSixteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fifteenSixteen.setText("($)");
        fifteenSixteen.setAlignmentY(0.0F);
        fifteenSixteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fifteenSixteen.setName(""); // NOI18N
        fifteenSixteen.setPreferredSize(new java.awt.Dimension(15, 15));

        sixEighteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixEighteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixEighteen.setText("($)");
        sixEighteen.setAlignmentY(0.0F);
        sixEighteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixEighteen.setName(""); // NOI18N
        sixEighteen.setPreferredSize(new java.awt.Dimension(15, 15));

        sevenNine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sevenNine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sevenNine.setText("($)");
        sevenNine.setAlignmentY(0.0F);
        sevenNine.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sevenNine.setName(""); // NOI18N
        sevenNine.setPreferredSize(new java.awt.Dimension(15, 15));

        sevenFour.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sevenFour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sevenFour.setText("($)");
        sevenFour.setAlignmentY(0.0F);
        sevenFour.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sevenFour.setName(""); // NOI18N
        sevenFour.setPreferredSize(new java.awt.Dimension(15, 15));

        thirteenNine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        thirteenNine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thirteenNine.setText("($)");
        thirteenNine.setAlignmentY(0.0F);
        thirteenNine.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        thirteenNine.setName(""); // NOI18N
        thirteenNine.setPreferredSize(new java.awt.Dimension(15, 15));

        twoEleven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twoEleven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twoEleven.setText("($)");
        twoEleven.setAlignmentY(0.0F);
        twoEleven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twoEleven.setName(""); // NOI18N
        twoEleven.setPreferredSize(new java.awt.Dimension(15, 15));

        tenTen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tenTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tenTen.setText("($)");
        tenTen.setAlignmentY(0.0F);
        tenTen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tenTen.setName(""); // NOI18N
        tenTen.setPreferredSize(new java.awt.Dimension(15, 15));

        sixteenSix.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixteenSix.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixteenSix.setText("($)");
        sixteenSix.setAlignmentY(0.0F);
        sixteenSix.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixteenSix.setName(""); // NOI18N
        sixteenSix.setPreferredSize(new java.awt.Dimension(15, 15));

        twoSix.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twoSix.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twoSix.setText("($)");
        twoSix.setAlignmentY(0.0F);
        twoSix.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twoSix.setName(""); // NOI18N
        twoSix.setPreferredSize(new java.awt.Dimension(15, 15));

        eightFour.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eightFour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eightFour.setText("($)");
        eightFour.setAlignmentY(0.0F);
        eightFour.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eightFour.setName(""); // NOI18N
        eightFour.setPreferredSize(new java.awt.Dimension(15, 15));

        threeOne.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        threeOne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        threeOne.setText("($)");
        threeOne.setAlignmentY(0.0F);
        threeOne.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        threeOne.setName(""); // NOI18N
        threeOne.setPreferredSize(new java.awt.Dimension(15, 15));

        zeroFour.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        zeroFour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zeroFour.setText("($)");
        zeroFour.setAlignmentY(0.0F);
        zeroFour.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zeroFour.setName(""); // NOI18N
        zeroFour.setPreferredSize(new java.awt.Dimension(15, 15));

        nineNineteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineNineteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineNineteen.setText("($)");
        nineNineteen.setAlignmentY(0.0F);
        nineNineteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineNineteen.setName(""); // NOI18N
        nineNineteen.setPreferredSize(new java.awt.Dimension(15, 15));

        fourTen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourTen.setText("($)");
        fourTen.setAlignmentY(0.0F);
        fourTen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourTen.setName(""); // NOI18N
        fourTen.setPreferredSize(new java.awt.Dimension(15, 15));

        sixEleven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixEleven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixEleven.setText("($)");
        sixEleven.setAlignmentY(0.0F);
        sixEleven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixEleven.setName(""); // NOI18N
        sixEleven.setPreferredSize(new java.awt.Dimension(15, 15));

        fourteenFour.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourteenFour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourteenFour.setText("($)");
        fourteenFour.setAlignmentY(0.0F);
        fourteenFour.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourteenFour.setName(""); // NOI18N
        fourteenFour.setPreferredSize(new java.awt.Dimension(15, 15));

        elevenThree.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        elevenThree.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        elevenThree.setText("($)");
        elevenThree.setAlignmentY(0.0F);
        elevenThree.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        elevenThree.setName(""); // NOI18N
        elevenThree.setPreferredSize(new java.awt.Dimension(15, 15));

        seventeenFive.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seventeenFive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seventeenFive.setText("($)");
        seventeenFive.setAlignmentY(0.0F);
        seventeenFive.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        seventeenFive.setName(""); // NOI18N
        seventeenFive.setPreferredSize(new java.awt.Dimension(15, 15));

        fifteenEighteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fifteenEighteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fifteenEighteen.setText("($)");
        fifteenEighteen.setAlignmentY(0.0F);
        fifteenEighteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fifteenEighteen.setName(""); // NOI18N
        fifteenEighteen.setPreferredSize(new java.awt.Dimension(15, 15));

        zeroSeven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        zeroSeven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zeroSeven.setText("($)");
        zeroSeven.setAlignmentY(0.0F);
        zeroSeven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zeroSeven.setName(""); // NOI18N
        zeroSeven.setPreferredSize(new java.awt.Dimension(15, 15));

        elevenEleven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        elevenEleven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        elevenEleven.setText("($)");
        elevenEleven.setAlignmentY(0.0F);
        elevenEleven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        elevenEleven.setName(""); // NOI18N
        elevenEleven.setPreferredSize(new java.awt.Dimension(15, 15));

        twoOne.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twoOne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twoOne.setText("($)");
        twoOne.setAlignmentY(0.0F);
        twoOne.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twoOne.setName(""); // NOI18N
        twoOne.setPreferredSize(new java.awt.Dimension(15, 15));

        nineteenOne.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineteenOne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineteenOne.setText("($)");
        nineteenOne.setAlignmentY(0.0F);
        nineteenOne.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineteenOne.setName(""); // NOI18N
        nineteenOne.setPreferredSize(new java.awt.Dimension(15, 15));

        zeroEighteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        zeroEighteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zeroEighteen.setText("($)");
        zeroEighteen.setAlignmentY(0.0F);
        zeroEighteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zeroEighteen.setName(""); // NOI18N
        zeroEighteen.setPreferredSize(new java.awt.Dimension(15, 15));

        seventeenOne.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seventeenOne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seventeenOne.setText("($)");
        seventeenOne.setAlignmentY(0.0F);
        seventeenOne.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        seventeenOne.setName(""); // NOI18N
        seventeenOne.setPreferredSize(new java.awt.Dimension(15, 15));

        elevenTwelve.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        elevenTwelve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        elevenTwelve.setText("($)");
        elevenTwelve.setAlignmentY(0.0F);
        elevenTwelve.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        elevenTwelve.setName(""); // NOI18N
        elevenTwelve.setPreferredSize(new java.awt.Dimension(15, 15));

        tenEighteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tenEighteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tenEighteen.setText("($)");
        tenEighteen.setAlignmentY(0.0F);
        tenEighteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tenEighteen.setName(""); // NOI18N
        tenEighteen.setPreferredSize(new java.awt.Dimension(15, 15));

        seventeenThree.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seventeenThree.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seventeenThree.setText("($)");
        seventeenThree.setAlignmentY(0.0F);
        seventeenThree.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        seventeenThree.setName(""); // NOI18N
        seventeenThree.setPreferredSize(new java.awt.Dimension(15, 15));

        fiveEleven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fiveEleven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveEleven.setText("($)");
        fiveEleven.setAlignmentY(0.0F);
        fiveEleven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fiveEleven.setName(""); // NOI18N
        fiveEleven.setPreferredSize(new java.awt.Dimension(15, 15));

        fiveNineteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fiveNineteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveNineteen.setText("($)");
        fiveNineteen.setAlignmentY(0.0F);
        fiveNineteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fiveNineteen.setName(""); // NOI18N
        fiveNineteen.setPreferredSize(new java.awt.Dimension(15, 15));

        twoFourteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twoFourteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twoFourteen.setText("($)");
        twoFourteen.setAlignmentY(0.0F);
        twoFourteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twoFourteen.setName(""); // NOI18N
        twoFourteen.setPreferredSize(new java.awt.Dimension(15, 15));

        threeTen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        threeTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        threeTen.setText("($)");
        threeTen.setAlignmentY(0.0F);
        threeTen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        threeTen.setName(""); // NOI18N
        threeTen.setPreferredSize(new java.awt.Dimension(15, 15));

        fourTwo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourTwo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourTwo.setText("($)");
        fourTwo.setAlignmentY(0.0F);
        fourTwo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourTwo.setName(""); // NOI18N
        fourTwo.setPreferredSize(new java.awt.Dimension(15, 15));

        twoFour.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twoFour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twoFour.setText("($)");
        twoFour.setAlignmentY(0.0F);
        twoFour.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twoFour.setName(""); // NOI18N
        twoFour.setPreferredSize(new java.awt.Dimension(15, 15));

        twelveFifteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twelveFifteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twelveFifteen.setText("($)");
        twelveFifteen.setAlignmentY(0.0F);
        twelveFifteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twelveFifteen.setName(""); // NOI18N
        twelveFifteen.setPreferredSize(new java.awt.Dimension(15, 15));

        eighteenNineteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eighteenNineteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eighteenNineteen.setText("($)");
        eighteenNineteen.setAlignmentY(0.0F);
        eighteenNineteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eighteenNineteen.setName(""); // NOI18N
        eighteenNineteen.setPreferredSize(new java.awt.Dimension(15, 15));

        tenThree.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tenThree.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tenThree.setText("($)");
        tenThree.setAlignmentY(0.0F);
        tenThree.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tenThree.setName(""); // NOI18N
        tenThree.setPreferredSize(new java.awt.Dimension(15, 15));

        fourteenZero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourteenZero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourteenZero.setText("($)");
        fourteenZero.setAlignmentY(0.0F);
        fourteenZero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourteenZero.setName(""); // NOI18N
        fourteenZero.setPreferredSize(new java.awt.Dimension(15, 15));

        tenNine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tenNine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tenNine.setText("($)");
        tenNine.setAlignmentY(0.0F);
        tenNine.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tenNine.setName(""); // NOI18N
        tenNine.setPreferredSize(new java.awt.Dimension(15, 15));

        elevenFive.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        elevenFive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        elevenFive.setText("($)");
        elevenFive.setAlignmentY(0.0F);
        elevenFive.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        elevenFive.setName(""); // NOI18N
        elevenFive.setPreferredSize(new java.awt.Dimension(15, 15));

        eightOne.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eightOne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eightOne.setText("($)");
        eightOne.setAlignmentY(0.0F);
        eightOne.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eightOne.setName(""); // NOI18N
        eightOne.setPreferredSize(new java.awt.Dimension(15, 15));

        threeSeventeen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        threeSeventeen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        threeSeventeen.setText("($)");
        threeSeventeen.setAlignmentY(0.0F);
        threeSeventeen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        threeSeventeen.setName(""); // NOI18N
        threeSeventeen.setPreferredSize(new java.awt.Dimension(15, 15));

        fifteenTwelve.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fifteenTwelve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fifteenTwelve.setText("($)");
        fifteenTwelve.setAlignmentY(0.0F);
        fifteenTwelve.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fifteenTwelve.setName(""); // NOI18N
        fifteenTwelve.setPreferredSize(new java.awt.Dimension(15, 15));

        eighteenSixteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eighteenSixteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eighteenSixteen.setText("($)");
        eighteenSixteen.setAlignmentY(0.0F);
        eighteenSixteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eighteenSixteen.setName(""); // NOI18N
        eighteenSixteen.setPreferredSize(new java.awt.Dimension(15, 15));

        twelveFourteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twelveFourteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twelveFourteen.setText("($)");
        twelveFourteen.setAlignmentY(0.0F);
        twelveFourteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twelveFourteen.setName(""); // NOI18N
        twelveFourteen.setPreferredSize(new java.awt.Dimension(15, 15));

        fourteenSixteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourteenSixteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourteenSixteen.setText("($)");
        fourteenSixteen.setAlignmentY(0.0F);
        fourteenSixteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourteenSixteen.setName(""); // NOI18N
        fourteenSixteen.setPreferredSize(new java.awt.Dimension(15, 15));

        zeroFifteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        zeroFifteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zeroFifteen.setText("($)");
        zeroFifteen.setAlignmentY(0.0F);
        zeroFifteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zeroFifteen.setName(""); // NOI18N
        zeroFifteen.setPreferredSize(new java.awt.Dimension(15, 15));

        thirteenFive.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        thirteenFive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thirteenFive.setText("($)");
        thirteenFive.setAlignmentY(0.0F);
        thirteenFive.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        thirteenFive.setName(""); // NOI18N
        thirteenFive.setPreferredSize(new java.awt.Dimension(15, 15));

        fourThirteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourThirteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourThirteen.setText("($)");
        fourThirteen.setAlignmentY(0.0F);
        fourThirteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourThirteen.setName(""); // NOI18N
        fourThirteen.setPreferredSize(new java.awt.Dimension(15, 15));

        fourNine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourNine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourNine.setText("($)");
        fourNine.setAlignmentY(0.0F);
        fourNine.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourNine.setName(""); // NOI18N
        fourNine.setPreferredSize(new java.awt.Dimension(15, 15));

        sixOne.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixOne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixOne.setText("($)");
        sixOne.setAlignmentY(0.0F);
        sixOne.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixOne.setName(""); // NOI18N
        sixOne.setPreferredSize(new java.awt.Dimension(15, 15));

        fourteenFive.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourteenFive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourteenFive.setText("($)");
        fourteenFive.setAlignmentY(0.0F);
        fourteenFive.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourteenFive.setName(""); // NOI18N
        fourteenFive.setPreferredSize(new java.awt.Dimension(15, 15));

        eighteenTwelve.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eighteenTwelve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eighteenTwelve.setText("($)");
        eighteenTwelve.setAlignmentY(0.0F);
        eighteenTwelve.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eighteenTwelve.setName(""); // NOI18N
        eighteenTwelve.setPreferredSize(new java.awt.Dimension(15, 15));

        nineTwelve.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineTwelve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineTwelve.setText("($)");
        nineTwelve.setAlignmentY(0.0F);
        nineTwelve.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineTwelve.setName(""); // NOI18N
        nineTwelve.setPreferredSize(new java.awt.Dimension(15, 15));

        elevenTwo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        elevenTwo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        elevenTwo.setText("($)");
        elevenTwo.setAlignmentY(0.0F);
        elevenTwo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        elevenTwo.setName(""); // NOI18N
        elevenTwo.setPreferredSize(new java.awt.Dimension(15, 15));

        sixSeven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixSeven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixSeven.setText("($)");
        sixSeven.setAlignmentY(0.0F);
        sixSeven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixSeven.setName(""); // NOI18N
        sixSeven.setPreferredSize(new java.awt.Dimension(15, 15));

        threeEighteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        threeEighteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        threeEighteen.setText("($)");
        threeEighteen.setAlignmentY(0.0F);
        threeEighteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        threeEighteen.setName(""); // NOI18N
        threeEighteen.setPreferredSize(new java.awt.Dimension(15, 15));

        nineTwo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineTwo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineTwo.setText("($)");
        nineTwo.setAlignmentY(0.0F);
        nineTwo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineTwo.setName(""); // NOI18N
        nineTwo.setPreferredSize(new java.awt.Dimension(15, 15));

        fourSixteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourSixteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourSixteen.setText("($)");
        fourSixteen.setAlignmentY(0.0F);
        fourSixteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourSixteen.setName(""); // NOI18N
        fourSixteen.setPreferredSize(new java.awt.Dimension(15, 15));

        twelveSixteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twelveSixteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twelveSixteen.setText("($)");
        twelveSixteen.setAlignmentY(0.0F);
        twelveSixteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twelveSixteen.setName(""); // NOI18N
        twelveSixteen.setPreferredSize(new java.awt.Dimension(15, 15));

        thirteenSeventeen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        thirteenSeventeen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thirteenSeventeen.setText("($)");
        thirteenSeventeen.setAlignmentY(0.0F);
        thirteenSeventeen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        thirteenSeventeen.setName(""); // NOI18N
        thirteenSeventeen.setPreferredSize(new java.awt.Dimension(15, 15));

        fourThree.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourThree.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourThree.setText("($)");
        fourThree.setAlignmentY(0.0F);
        fourThree.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourThree.setName(""); // NOI18N
        fourThree.setPreferredSize(new java.awt.Dimension(15, 15));

        eighteenZero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eighteenZero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eighteenZero.setText("($)");
        eighteenZero.setAlignmentY(0.0F);
        eighteenZero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eighteenZero.setName(""); // NOI18N
        eighteenZero.setPreferredSize(new java.awt.Dimension(15, 15));

        eighteenSeventeen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eighteenSeventeen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eighteenSeventeen.setText("($)");
        eighteenSeventeen.setAlignmentY(0.0F);
        eighteenSeventeen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eighteenSeventeen.setName(""); // NOI18N
        eighteenSeventeen.setPreferredSize(new java.awt.Dimension(15, 15));

        fourteenNineteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourteenNineteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourteenNineteen.setText("($)");
        fourteenNineteen.setAlignmentY(0.0F);
        fourteenNineteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourteenNineteen.setName(""); // NOI18N
        fourteenNineteen.setPreferredSize(new java.awt.Dimension(15, 15));

        tenThirteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tenThirteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tenThirteen.setText("($)");
        tenThirteen.setAlignmentY(0.0F);
        tenThirteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tenThirteen.setName(""); // NOI18N
        tenThirteen.setPreferredSize(new java.awt.Dimension(15, 15));

        tenFour.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tenFour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tenFour.setText("($)");
        tenFour.setAlignmentY(0.0F);
        tenFour.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tenFour.setName(""); // NOI18N
        tenFour.setPreferredSize(new java.awt.Dimension(15, 15));

        zeroThree.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        zeroThree.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zeroThree.setText("($)");
        zeroThree.setAlignmentY(0.0F);
        zeroThree.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zeroThree.setName(""); // NOI18N
        zeroThree.setPreferredSize(new java.awt.Dimension(15, 15));

        seventeenTwo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seventeenTwo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seventeenTwo.setText("($)");
        seventeenTwo.setAlignmentY(0.0F);
        seventeenTwo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        seventeenTwo.setName(""); // NOI18N
        seventeenTwo.setPreferredSize(new java.awt.Dimension(15, 15));

        fifteenNineteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fifteenNineteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fifteenNineteen.setText("($)");
        fifteenNineteen.setAlignmentY(0.0F);
        fifteenNineteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fifteenNineteen.setName(""); // NOI18N
        fifteenNineteen.setPreferredSize(new java.awt.Dimension(15, 15));

        fiveEighteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fiveEighteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveEighteen.setText("($)");
        fiveEighteen.setAlignmentY(0.0F);
        fiveEighteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fiveEighteen.setName(""); // NOI18N
        fiveEighteen.setPreferredSize(new java.awt.Dimension(15, 15));

        fiveTwo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fiveTwo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveTwo.setText("($)");
        fiveTwo.setAlignmentY(0.0F);
        fiveTwo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fiveTwo.setName(""); // NOI18N
        fiveTwo.setPreferredSize(new java.awt.Dimension(15, 15));

        tenTwelve.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tenTwelve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tenTwelve.setText("($)");
        tenTwelve.setAlignmentY(0.0F);
        tenTwelve.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tenTwelve.setName(""); // NOI18N
        tenTwelve.setPreferredSize(new java.awt.Dimension(15, 15));

        fifteenSeven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fifteenSeven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fifteenSeven.setText("($)");
        fifteenSeven.setAlignmentY(0.0F);
        fifteenSeven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fifteenSeven.setName(""); // NOI18N
        fifteenSeven.setPreferredSize(new java.awt.Dimension(15, 15));

        twelveNineteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twelveNineteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twelveNineteen.setText("($)");
        twelveNineteen.setAlignmentY(0.0F);
        twelveNineteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twelveNineteen.setName(""); // NOI18N
        twelveNineteen.setPreferredSize(new java.awt.Dimension(15, 15));

        oneTen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        oneTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oneTen.setText("($)");
        oneTen.setAlignmentY(0.0F);
        oneTen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        oneTen.setName(""); // NOI18N
        oneTen.setPreferredSize(new java.awt.Dimension(15, 15));

        twoTwelve.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twoTwelve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twoTwelve.setText("($)");
        twoTwelve.setAlignmentY(0.0F);
        twoTwelve.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twoTwelve.setName(""); // NOI18N
        twoTwelve.setPreferredSize(new java.awt.Dimension(15, 15));

        threeSeven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        threeSeven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        threeSeven.setText("($)");
        threeSeven.setAlignmentY(0.0F);
        threeSeven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        threeSeven.setName(""); // NOI18N
        threeSeven.setPreferredSize(new java.awt.Dimension(15, 15));

        fiveThree.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fiveThree.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveThree.setText("($)");
        fiveThree.setAlignmentY(0.0F);
        fiveThree.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fiveThree.setName(""); // NOI18N
        fiveThree.setPreferredSize(new java.awt.Dimension(15, 15));

        threeFive.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        threeFive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        threeFive.setText("($)");
        threeFive.setAlignmentY(0.0F);
        threeFive.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        threeFive.setName(""); // NOI18N
        threeFive.setPreferredSize(new java.awt.Dimension(15, 15));

        fourFive.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourFive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourFive.setText("($)");
        fourFive.setAlignmentY(0.0F);
        fourFive.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourFive.setName(""); // NOI18N
        fourFive.setPreferredSize(new java.awt.Dimension(15, 15));

        seventeenFourteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seventeenFourteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seventeenFourteen.setText("($)");
        seventeenFourteen.setAlignmentY(0.0F);
        seventeenFourteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        seventeenFourteen.setName(""); // NOI18N
        seventeenFourteen.setPreferredSize(new java.awt.Dimension(15, 15));

        twoZero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twoZero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twoZero.setText("($)");
        twoZero.setAlignmentY(0.0F);
        twoZero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twoZero.setName(""); // NOI18N
        twoZero.setPreferredSize(new java.awt.Dimension(15, 15));

        sevenSixteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sevenSixteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sevenSixteen.setText("($)");
        sevenSixteen.setAlignmentY(0.0F);
        sevenSixteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sevenSixteen.setName(""); // NOI18N
        sevenSixteen.setPreferredSize(new java.awt.Dimension(15, 15));

        sevenThree.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sevenThree.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sevenThree.setText("($)");
        sevenThree.setAlignmentY(0.0F);
        sevenThree.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sevenThree.setName(""); // NOI18N
        sevenThree.setPreferredSize(new java.awt.Dimension(15, 15));

        sixFive.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixFive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixFive.setText("($)");
        sixFive.setAlignmentY(0.0F);
        sixFive.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixFive.setName(""); // NOI18N
        sixFive.setPreferredSize(new java.awt.Dimension(15, 15));

        twelveEleven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twelveEleven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twelveEleven.setText("($)");
        twelveEleven.setAlignmentY(0.0F);
        twelveEleven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twelveEleven.setName(""); // NOI18N
        twelveEleven.setPreferredSize(new java.awt.Dimension(15, 15));

        thirteenNineteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        thirteenNineteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thirteenNineteen.setText("($)");
        thirteenNineteen.setAlignmentY(0.0F);
        thirteenNineteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        thirteenNineteen.setName(""); // NOI18N
        thirteenNineteen.setPreferredSize(new java.awt.Dimension(15, 15));

        sevenNineteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sevenNineteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sevenNineteen.setText("($)");
        sevenNineteen.setAlignmentY(0.0F);
        sevenNineteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sevenNineteen.setName(""); // NOI18N
        sevenNineteen.setPreferredSize(new java.awt.Dimension(15, 15));

        fiveFive.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fiveFive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveFive.setText("($)");
        fiveFive.setAlignmentY(0.0F);
        fiveFive.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fiveFive.setName(""); // NOI18N
        fiveFive.setPreferredSize(new java.awt.Dimension(15, 15));

        seventeenFour.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seventeenFour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seventeenFour.setText("($)");
        seventeenFour.setAlignmentY(0.0F);
        seventeenFour.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        seventeenFour.setName(""); // NOI18N
        seventeenFour.setPreferredSize(new java.awt.Dimension(15, 15));

        tenFifteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tenFifteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tenFifteen.setText("($)");
        tenFifteen.setAlignmentY(0.0F);
        tenFifteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tenFifteen.setName(""); // NOI18N
        tenFifteen.setPreferredSize(new java.awt.Dimension(15, 15));

        sevenOne.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sevenOne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sevenOne.setText("($)");
        sevenOne.setAlignmentY(0.0F);
        sevenOne.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sevenOne.setName(""); // NOI18N
        sevenOne.setPreferredSize(new java.awt.Dimension(15, 15));

        sixNineteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixNineteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixNineteen.setText("($)");
        sixNineteen.setAlignmentY(0.0F);
        sixNineteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixNineteen.setName(""); // NOI18N
        sixNineteen.setPreferredSize(new java.awt.Dimension(15, 15));

        eightEight.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eightEight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eightEight.setText("($)");
        eightEight.setAlignmentY(0.0F);
        eightEight.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eightEight.setName(""); // NOI18N
        eightEight.setPreferredSize(new java.awt.Dimension(15, 15));

        nineSix.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineSix.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineSix.setText("($)");
        nineSix.setAlignmentY(0.0F);
        nineSix.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineSix.setName(""); // NOI18N
        nineSix.setPreferredSize(new java.awt.Dimension(15, 15));

        thirteenEighteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        thirteenEighteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thirteenEighteen.setText("($)");
        thirteenEighteen.setAlignmentY(0.0F);
        thirteenEighteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        thirteenEighteen.setName(""); // NOI18N
        thirteenEighteen.setPreferredSize(new java.awt.Dimension(15, 15));

        sixteenSeven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixteenSeven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixteenSeven.setText("($)");
        sixteenSeven.setAlignmentY(0.0F);
        sixteenSeven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixteenSeven.setName(""); // NOI18N
        sixteenSeven.setPreferredSize(new java.awt.Dimension(15, 15));

        nineteenNine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineteenNine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineteenNine.setText("($)");
        nineteenNine.setAlignmentY(0.0F);
        nineteenNine.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineteenNine.setName(""); // NOI18N
        nineteenNine.setPreferredSize(new java.awt.Dimension(15, 15));

        sixEight.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixEight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixEight.setText("($)");
        sixEight.setAlignmentY(0.0F);
        sixEight.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixEight.setName(""); // NOI18N
        sixEight.setPreferredSize(new java.awt.Dimension(15, 15));

        eightSix.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eightSix.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eightSix.setText("($)");
        eightSix.setAlignmentY(0.0F);
        eightSix.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eightSix.setName(""); // NOI18N
        eightSix.setPreferredSize(new java.awt.Dimension(15, 15));

        fiveNine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fiveNine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveNine.setText("($)");
        fiveNine.setAlignmentY(0.0F);
        fiveNine.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fiveNine.setName(""); // NOI18N
        fiveNine.setPreferredSize(new java.awt.Dimension(15, 15));

        nineTen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineTen.setText("($)");
        nineTen.setAlignmentY(0.0F);
        nineTen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineTen.setName(""); // NOI18N
        nineTen.setPreferredSize(new java.awt.Dimension(15, 15));

        seventeenEight.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seventeenEight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seventeenEight.setText("($)");
        seventeenEight.setAlignmentY(0.0F);
        seventeenEight.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        seventeenEight.setName(""); // NOI18N
        seventeenEight.setPreferredSize(new java.awt.Dimension(15, 15));

        nineteenSeventeen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineteenSeventeen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineteenSeventeen.setText("($)");
        nineteenSeventeen.setAlignmentY(0.0F);
        nineteenSeventeen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineteenSeventeen.setName(""); // NOI18N
        nineteenSeventeen.setPreferredSize(new java.awt.Dimension(15, 15));

        thirteenTwelve.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        thirteenTwelve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thirteenTwelve.setText("($)");
        thirteenTwelve.setAlignmentY(0.0F);
        thirteenTwelve.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        thirteenTwelve.setName(""); // NOI18N
        thirteenTwelve.setPreferredSize(new java.awt.Dimension(15, 15));

        nineteenTwo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineteenTwo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineteenTwo.setText("($)");
        nineteenTwo.setAlignmentY(0.0F);
        nineteenTwo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineteenTwo.setName(""); // NOI18N
        nineteenTwo.setPreferredSize(new java.awt.Dimension(15, 15));

        fourNineteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourNineteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourNineteen.setText("($)");
        fourNineteen.setAlignmentY(0.0F);
        fourNineteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourNineteen.setName(""); // NOI18N
        fourNineteen.setPreferredSize(new java.awt.Dimension(15, 15));

        eightZero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eightZero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eightZero.setText("($)");
        eightZero.setAlignmentY(0.0F);
        eightZero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eightZero.setName(""); // NOI18N
        eightZero.setPreferredSize(new java.awt.Dimension(15, 15));

        nineteenSix.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineteenSix.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineteenSix.setText("($)");
        nineteenSix.setAlignmentY(0.0F);
        nineteenSix.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineteenSix.setName(""); // NOI18N
        nineteenSix.setPreferredSize(new java.awt.Dimension(15, 15));

        fiveSeventeen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fiveSeventeen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fiveSeventeen.setText("($)");
        fiveSeventeen.setAlignmentY(0.0F);
        fiveSeventeen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fiveSeventeen.setName(""); // NOI18N
        fiveSeventeen.setPreferredSize(new java.awt.Dimension(15, 15));

        oneFive.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        oneFive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oneFive.setText("($)");
        oneFive.setAlignmentY(0.0F);
        oneFive.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        oneFive.setName(""); // NOI18N
        oneFive.setPreferredSize(new java.awt.Dimension(15, 15));

        oneZero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        oneZero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oneZero.setText("($)");
        oneZero.setAlignmentY(0.0F);
        oneZero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        oneZero.setName(""); // NOI18N
        oneZero.setPreferredSize(new java.awt.Dimension(15, 15));

        threeNineteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        threeNineteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        threeNineteen.setText("($)");
        threeNineteen.setAlignmentY(0.0F);
        threeNineteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        threeNineteen.setName(""); // NOI18N
        threeNineteen.setPreferredSize(new java.awt.Dimension(15, 15));

        elevenZero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        elevenZero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        elevenZero.setText("($)");
        elevenZero.setAlignmentY(0.0F);
        elevenZero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        elevenZero.setName(""); // NOI18N
        elevenZero.setPreferredSize(new java.awt.Dimension(15, 15));

        thirteenOne.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        thirteenOne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thirteenOne.setText("($)");
        thirteenOne.setAlignmentY(0.0F);
        thirteenOne.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        thirteenOne.setName(""); // NOI18N
        thirteenOne.setPreferredSize(new java.awt.Dimension(15, 15));

        sixSixteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixSixteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixSixteen.setText("($)");
        sixSixteen.setAlignmentY(0.0F);
        sixSixteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixSixteen.setName(""); // NOI18N
        sixSixteen.setPreferredSize(new java.awt.Dimension(15, 15));

        nineteenFourteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineteenFourteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineteenFourteen.setText("($)");
        nineteenFourteen.setAlignmentY(0.0F);
        nineteenFourteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineteenFourteen.setName(""); // NOI18N
        nineteenFourteen.setPreferredSize(new java.awt.Dimension(15, 15));

        twelveSeven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twelveSeven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twelveSeven.setText("($)");
        twelveSeven.setAlignmentY(0.0F);
        twelveSeven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twelveSeven.setName(""); // NOI18N
        twelveSeven.setPreferredSize(new java.awt.Dimension(15, 15));

        seventeenNine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seventeenNine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seventeenNine.setText("($)");
        seventeenNine.setAlignmentY(0.0F);
        seventeenNine.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        seventeenNine.setName(""); // NOI18N
        seventeenNine.setPreferredSize(new java.awt.Dimension(15, 15));

        sixteenNine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixteenNine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixteenNine.setText("($)");
        sixteenNine.setAlignmentY(0.0F);
        sixteenNine.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixteenNine.setName(""); // NOI18N
        sixteenNine.setPreferredSize(new java.awt.Dimension(15, 15));

        eighteenSeven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eighteenSeven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eighteenSeven.setText("($)");
        eighteenSeven.setAlignmentY(0.0F);
        eighteenSeven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eighteenSeven.setName(""); // NOI18N
        eighteenSeven.setPreferredSize(new java.awt.Dimension(15, 15));

        sixteenFourteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixteenFourteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixteenFourteen.setText("($)");
        sixteenFourteen.setAlignmentY(0.0F);
        sixteenFourteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixteenFourteen.setName(""); // NOI18N
        sixteenFourteen.setPreferredSize(new java.awt.Dimension(15, 15));

        nineteenEighteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nineteenEighteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nineteenEighteen.setText("($)");
        nineteenEighteen.setAlignmentY(0.0F);
        nineteenEighteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nineteenEighteen.setName(""); // NOI18N
        nineteenEighteen.setPreferredSize(new java.awt.Dimension(15, 15));

        tenSixteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tenSixteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tenSixteen.setText("($)");
        tenSixteen.setAlignmentY(0.0F);
        tenSixteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tenSixteen.setName(""); // NOI18N
        tenSixteen.setPreferredSize(new java.awt.Dimension(15, 15));

        fourZero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourZero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourZero.setText("($)");
        fourZero.setAlignmentY(0.0F);
        fourZero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourZero.setName(""); // NOI18N
        fourZero.setPreferredSize(new java.awt.Dimension(15, 15));

        fifteenEleven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fifteenEleven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fifteenEleven.setText("($)");
        fifteenEleven.setAlignmentY(0.0F);
        fifteenEleven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fifteenEleven.setName(""); // NOI18N
        fifteenEleven.setPreferredSize(new java.awt.Dimension(15, 15));

        fifteenFourteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fifteenFourteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fifteenFourteen.setText("($)");
        fifteenFourteen.setAlignmentY(0.0F);
        fifteenFourteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fifteenFourteen.setName(""); // NOI18N
        fifteenFourteen.setPreferredSize(new java.awt.Dimension(15, 15));

        sixteenZero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sixteenZero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sixteenZero.setText("($)");
        sixteenZero.setAlignmentY(0.0F);
        sixteenZero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sixteenZero.setName(""); // NOI18N
        sixteenZero.setPreferredSize(new java.awt.Dimension(15, 15));

        sevenZero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sevenZero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sevenZero.setText("($)");
        sevenZero.setAlignmentY(0.0F);
        sevenZero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sevenZero.setName(""); // NOI18N
        sevenZero.setPreferredSize(new java.awt.Dimension(15, 15));

        fifteenEight.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fifteenEight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fifteenEight.setText("($)");
        fifteenEight.setAlignmentY(0.0F);
        fifteenEight.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fifteenEight.setName(""); // NOI18N
        fifteenEight.setPreferredSize(new java.awt.Dimension(15, 15));

        twelveEight.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        twelveEight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twelveEight.setText("($)");
        twelveEight.setAlignmentY(0.0F);
        twelveEight.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        twelveEight.setName(""); // NOI18N
        twelveEight.setPreferredSize(new java.awt.Dimension(15, 15));

        elevenNine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        elevenNine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        elevenNine.setText("($)");
        elevenNine.setAlignmentY(0.0F);
        elevenNine.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        elevenNine.setName(""); // NOI18N
        elevenNine.setPreferredSize(new java.awt.Dimension(15, 15));

        tenSeven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tenSeven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tenSeven.setText("($)");
        tenSeven.setAlignmentY(0.0F);
        tenSeven.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tenSeven.setName(""); // NOI18N
        tenSeven.setPreferredSize(new java.awt.Dimension(15, 15));

        zeroSix.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        zeroSix.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zeroSix.setText("($)");
        zeroSix.setAlignmentY(0.0F);
        zeroSix.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zeroSix.setName(""); // NOI18N
        zeroSix.setPreferredSize(new java.awt.Dimension(15, 15));

        elevenThirteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        elevenThirteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        elevenThirteen.setText("($)");
        elevenThirteen.setAlignmentY(0.0F);
        elevenThirteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        elevenThirteen.setName(""); // NOI18N
        elevenThirteen.setPreferredSize(new java.awt.Dimension(15, 15));

        fourteenEight.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourteenEight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourteenEight.setText("($)");
        fourteenEight.setAlignmentY(0.0F);
        fourteenEight.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourteenEight.setName(""); // NOI18N
        fourteenEight.setPreferredSize(new java.awt.Dimension(15, 15));

        sevenSix.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sevenSix.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sevenSix.setText("($)");
        sevenSix.setAlignmentY(0.0F);
        sevenSix.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sevenSix.setName(""); // NOI18N
        sevenSix.setPreferredSize(new java.awt.Dimension(15, 15));

        fourteenNine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fourteenNine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fourteenNine.setText("($)");
        fourteenNine.setAlignmentY(0.0F);
        fourteenNine.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fourteenNine.setName(""); // NOI18N
        fourteenNine.setPreferredSize(new java.awt.Dimension(15, 15));

        thirteenSixteen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        thirteenSixteen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thirteenSixteen.setText("($)");
        thirteenSixteen.setAlignmentY(0.0F);
        thirteenSixteen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        thirteenSixteen.setName(""); // NOI18N
        thirteenSixteen.setPreferredSize(new java.awt.Dimension(15, 15));

        fuelJTextField.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(oneZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(oneOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(oneTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(oneThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(oneFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(oneFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(oneSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(oneSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(oneEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(oneNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(oneTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(oneEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(oneTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(oneThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(oneFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(oneFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(oneSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(oneSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(oneEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(oneNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(twoZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(twoOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(twoTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(twoThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(twoFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(twoFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(twoSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(twoSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(twoEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(twoNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(twoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(twoEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(twoTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(twoThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(twoFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(twoFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(twoSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(twoSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(twoEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(twoNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(threeZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(threeOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(threeTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(threeThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(threeFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(threeFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(threeSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(threeSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(threeEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(threeNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(threeTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(threeEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(threeTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(threeThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(threeFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(threeFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(threeSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(threeSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(threeEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(threeNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fourZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(fourOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(fourTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fourThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fourFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fourFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(fourSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(fourSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fourEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fourNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fourTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(fourEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(fourTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fourThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fourFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fourFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(fourSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(fourSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fourEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fourNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fiveZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(fiveOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(fiveTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fiveThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fiveFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fiveFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(fiveSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(fiveSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fiveEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fiveNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fiveTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(fiveEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(fiveTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fiveThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fiveFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fiveFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(fiveSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(fiveSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fiveEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fiveNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sixZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(sixOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(sixTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(sixThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(sixFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(sixFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(sixSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(sixSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(sixEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(sixNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(sixTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(sixEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(sixTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(sixThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(sixFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(sixFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(sixSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(sixSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(sixEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(sixNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sevenZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(sevenOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(sevenTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(sevenThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(sevenFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(sevenFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(sevenSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(sevenSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(sevenEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(sevenNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(sevenTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(sevenEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(sevenTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(sevenThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(sevenFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(sevenFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(sevenSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(sevenSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(sevenEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(sevenNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(eightZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eightOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(eightTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(eightThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(eightFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(eightFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(eightSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(eightSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(eightEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(eightNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(eightTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(eightEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(eightTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(eightThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(eightFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(eightFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(eightSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(eightSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(eightEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(eightNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nineZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(nineOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nineTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(nineThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(nineFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(nineFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(nineSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(nineSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(nineEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(nineNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(nineTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(nineEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(nineTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(nineThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(nineFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(nineFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(nineSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(nineSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(nineEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(nineNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tenZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tenOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(tenTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(tenThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(tenFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(tenFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(tenSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(tenSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(tenEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(tenNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(tenTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(tenEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(tenTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(tenThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(tenFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(tenFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(tenSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(tenSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(tenEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(tenNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(elevenZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(elevenOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(elevenTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(elevenThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(elevenFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(elevenFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(elevenSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(elevenSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(elevenEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(elevenNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(elevenTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(elevenEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(elevenTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(elevenThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(elevenFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(elevenFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(elevenSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(elevenSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(elevenEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(elevenNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(twelveZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(twelveOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(twelveTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(twelveThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(twelveFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(twelveFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(twelveSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(twelveSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(twelveEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(twelveNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(twelveTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(twelveEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(twelveTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(twelveThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(twelveFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(twelveFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(twelveSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(twelveSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(twelveEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(thirteenZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(thirteenOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(thirteenTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(thirteenThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(thirteenFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(thirteenFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(thirteenSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(thirteenSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(thirteenEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(thirteenNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(thirteenTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(thirteenEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(thirteenTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(thirteenThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(thirteenFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(thirteenFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(thirteenSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(thirteenSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thirteenEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(thirteenNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(twelveNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fifteenZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(fifteenOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(fifteenTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fifteenThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fifteenFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fifteenFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(fifteenSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(fifteenSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fifteenEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fifteenNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fifteenTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(fifteenEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(fifteenTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fifteenThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fifteenFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fifteenFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(fifteenSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(fifteenSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fifteenEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fifteenNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(nineteenZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(nineteenOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(nineteenTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(nineteenThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(nineteenFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(nineteenFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nineteenSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(nineteenSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nineteenEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nineteenNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nineteenTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(nineteenEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nineteenTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nineteenThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(nineteenFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nineteenFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nineteenSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nineteenSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nineteenEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(nineteenNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(seventeenZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(seventeenOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(seventeenTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(seventeenThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(seventeenFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(seventeenFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(seventeenSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(seventeenSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(seventeenEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(eighteenZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(eighteenOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(eighteenTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(eighteenThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(eighteenFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(eighteenFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(eighteenSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(eighteenSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(eighteenEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(seventeenNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(seventeenTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(seventeenEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(seventeenTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(seventeenThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(seventeenFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(seventeenFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(seventeenSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(seventeenSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(seventeenEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(eighteenNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(eighteenTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(eighteenEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(eighteenTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(eighteenThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(eighteenFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(eighteenFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(eighteenSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(eighteenSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(eighteenEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(eighteenNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(seventeenNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(sixteenZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(sixteenOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(sixteenTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(sixteenThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(sixteenFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(sixteenFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(sixteenSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(sixteenSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(sixteenEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(sixteenNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(sixteenTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(sixteenEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(sixteenTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(sixteenThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(sixteenFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(sixteenFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(sixteenSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(sixteenSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(sixteenEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(sixteenNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fourteenZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fourteenOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fourteenTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(fourteenThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fourteenFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fourteenFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fourteenSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fourteenSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(fourteenEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fourteenNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(fourteenTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fourteenEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fourteenTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fourteenThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fourteenFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fourteenFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fourteenSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fourteenSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fourteenEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fourteenNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(zeroZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(zeroOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(zeroTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(zeroThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(zeroFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(zeroFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(zeroSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(zeroSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(zeroEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(zeroNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(zeroTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(zeroEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(zeroTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(zeroThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(zeroFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(zeroFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(zeroSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(zeroSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(zeroEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(zeroNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fuelJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fuelJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(zeroZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zeroOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zeroTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zeroThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zeroFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zeroFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zeroSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zeroSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zeroEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zeroNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zeroTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zeroEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zeroTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zeroThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zeroFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zeroFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zeroSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zeroSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zeroEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zeroNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(oneZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oneOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oneTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oneThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oneFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oneFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oneSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oneSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oneEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oneNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oneTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oneEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oneTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oneThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oneFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oneFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oneSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oneSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oneEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oneNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(twoZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twoOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twoTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twoThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twoFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twoFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twoSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twoSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twoEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twoNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twoEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twoTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twoThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twoFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twoFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twoSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twoSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twoEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twoNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(threeZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(threeOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(threeTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(threeThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(threeFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(threeFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(threeSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(threeSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(threeEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(threeNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(threeTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(threeEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(threeTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(threeThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(threeFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(threeFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(threeSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(threeSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(threeEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(threeNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fourZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fourOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fourTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fourThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fourFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fourFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fourSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fourSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fourEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fourNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fourTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fourEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fourTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fourThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fourFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fourFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fourSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fourSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fourEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fourNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fiveZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiveOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiveTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiveThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiveFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiveFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiveSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiveSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiveEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiveNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiveTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiveEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiveTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiveThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiveFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiveFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiveSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiveSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiveEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiveNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sixZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sevenZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sevenOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sevenTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sevenThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sevenFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sevenFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sevenSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sevenSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sevenEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sevenNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sevenTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sevenEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sevenTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sevenThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sevenFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sevenFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sevenSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sevenSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sevenEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sevenNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(eightZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(eightOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(eightTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eightThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eightFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eightFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eightSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eightSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eightEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eightNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eightTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eightEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eightTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eightThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eightFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eightFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eightSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eightSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eightEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eightNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nineZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nineTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nineOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nineThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nineFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nineFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nineSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nineSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nineEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nineNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nineTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nineEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nineTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nineThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nineFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nineFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nineSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nineSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nineEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nineNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tenZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tenOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tenTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(elevenZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(elevenOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(elevenTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elevenThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elevenFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elevenFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elevenSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elevenSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elevenEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elevenNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elevenTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elevenEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elevenTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elevenThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elevenFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elevenFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elevenSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elevenSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elevenEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elevenNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(twelveZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(twelveOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(twelveTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twelveThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twelveFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twelveFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twelveSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twelveSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twelveEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twelveNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twelveTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twelveEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twelveTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twelveThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twelveFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twelveFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twelveSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twelveSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twelveEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twelveNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(thirteenOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(thirteenZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(thirteenThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(thirteenTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(thirteenFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(thirteenFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(thirteenSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(thirteenEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(thirteenSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(thirteenNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thirteenTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thirteenEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thirteenTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thirteenThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thirteenFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thirteenFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thirteenSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(thirteenSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(thirteenEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(thirteenNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fourteenEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fourteenNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fourteenTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fourteenEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fourteenTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fourteenThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fourteenFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fourteenFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fourteenSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fourteenSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fourteenEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fourteenNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fourteenZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fourteenOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fourteenFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fourteenThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fourteenFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fourteenTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fourteenSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fourteenSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fifteenZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fifteenOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fifteenTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fifteenThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fifteenFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fifteenFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fifteenSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fifteenSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fifteenEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fifteenNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fifteenTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fifteenEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fifteenTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fifteenThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fifteenFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fifteenFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fifteenSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fifteenSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fifteenEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fifteenNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sixteenZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixteenOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixteenTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixteenThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixteenFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixteenFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixteenSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixteenSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixteenEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixteenNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixteenTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixteenEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixteenTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixteenThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixteenFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixteenFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixteenSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixteenSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sixteenEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sixteenNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(seventeenZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seventeenOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seventeenTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seventeenThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seventeenFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seventeenFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seventeenSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seventeenSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seventeenEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seventeenNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seventeenTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seventeenEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seventeenTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seventeenThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seventeenFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seventeenFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seventeenSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seventeenSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seventeenEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seventeenNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(eighteenThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(eighteenTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(eighteenFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(eighteenFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(eighteenSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(eighteenTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(eighteenEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(eighteenThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(eighteenFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(eighteenFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(eighteenSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(eighteenSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(eighteenEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(eighteenNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(eighteenZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eighteenOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(eighteenSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eighteenEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eighteenNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eighteenTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nineteenZero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nineteenOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nineteenTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nineteenThree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nineteenFour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nineteenFive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nineteenSix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nineteenSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nineteenEight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nineteenNine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nineteenTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nineteenEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nineteenThirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nineteenTwelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nineteenFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nineteenFifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nineteenSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nineteenSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nineteenEighteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nineteenNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel eightEight;
    private javax.swing.JLabel eightEighteen;
    private javax.swing.JLabel eightEleven;
    private javax.swing.JLabel eightFifteen;
    private javax.swing.JLabel eightFive;
    private javax.swing.JLabel eightFour;
    private javax.swing.JLabel eightFourteen;
    private javax.swing.JLabel eightNine;
    private javax.swing.JLabel eightNineteen;
    private javax.swing.JLabel eightOne;
    private javax.swing.JLabel eightSeven;
    private javax.swing.JLabel eightSeventeen;
    private javax.swing.JLabel eightSix;
    private javax.swing.JLabel eightSixteen;
    private javax.swing.JLabel eightTen;
    private javax.swing.JLabel eightThirteen;
    private javax.swing.JLabel eightThree;
    private javax.swing.JLabel eightTwelve;
    private javax.swing.JLabel eightTwo;
    private javax.swing.JLabel eightZero;
    private javax.swing.JLabel eighteenEight;
    private javax.swing.JLabel eighteenEighteen;
    private javax.swing.JLabel eighteenEleven;
    private javax.swing.JLabel eighteenFifteen;
    private javax.swing.JLabel eighteenFive;
    private javax.swing.JLabel eighteenFour;
    private javax.swing.JLabel eighteenFourteen;
    private javax.swing.JLabel eighteenNine;
    private javax.swing.JLabel eighteenNineteen;
    private javax.swing.JLabel eighteenOne;
    private javax.swing.JLabel eighteenSeven;
    private javax.swing.JLabel eighteenSeventeen;
    private javax.swing.JLabel eighteenSix;
    private javax.swing.JLabel eighteenSixteen;
    private javax.swing.JLabel eighteenTen;
    private javax.swing.JLabel eighteenThirteen;
    private javax.swing.JLabel eighteenThree;
    private javax.swing.JLabel eighteenTwelve;
    private javax.swing.JLabel eighteenTwo;
    private javax.swing.JLabel eighteenZero;
    private javax.swing.JLabel elevenEight;
    private javax.swing.JLabel elevenEighteen;
    private javax.swing.JLabel elevenEleven;
    private javax.swing.JLabel elevenFifteen;
    private javax.swing.JLabel elevenFive;
    private javax.swing.JLabel elevenFour;
    private javax.swing.JLabel elevenFourteen;
    private javax.swing.JLabel elevenNine;
    private javax.swing.JLabel elevenNineteen;
    private javax.swing.JLabel elevenOne;
    private javax.swing.JLabel elevenSeven;
    private javax.swing.JLabel elevenSeventeen;
    private javax.swing.JLabel elevenSix;
    private javax.swing.JLabel elevenSixteen;
    private javax.swing.JLabel elevenTen;
    private javax.swing.JLabel elevenThirteen;
    private javax.swing.JLabel elevenThree;
    private javax.swing.JLabel elevenTwelve;
    private javax.swing.JLabel elevenTwo;
    private javax.swing.JLabel elevenZero;
    private javax.swing.JLabel fifteenEight;
    private javax.swing.JLabel fifteenEighteen;
    private javax.swing.JLabel fifteenEleven;
    private javax.swing.JLabel fifteenFifteen;
    private javax.swing.JLabel fifteenFive;
    private javax.swing.JLabel fifteenFour;
    private javax.swing.JLabel fifteenFourteen;
    private javax.swing.JLabel fifteenNine;
    private javax.swing.JLabel fifteenNineteen;
    private javax.swing.JLabel fifteenOne;
    private javax.swing.JLabel fifteenSeven;
    private javax.swing.JLabel fifteenSeventeen;
    private javax.swing.JLabel fifteenSix;
    private javax.swing.JLabel fifteenSixteen;
    private javax.swing.JLabel fifteenTen;
    private javax.swing.JLabel fifteenThirteen;
    private javax.swing.JLabel fifteenThree;
    private javax.swing.JLabel fifteenTwelve;
    private javax.swing.JLabel fifteenTwo;
    private javax.swing.JLabel fifteenZero;
    private javax.swing.JLabel fiveEight;
    private javax.swing.JLabel fiveEighteen;
    private javax.swing.JLabel fiveEleven;
    private javax.swing.JLabel fiveFifteen;
    private javax.swing.JLabel fiveFive;
    private javax.swing.JLabel fiveFour;
    private javax.swing.JLabel fiveFourteen;
    private javax.swing.JLabel fiveNine;
    private javax.swing.JLabel fiveNineteen;
    private javax.swing.JLabel fiveOne;
    private javax.swing.JLabel fiveSeven;
    private javax.swing.JLabel fiveSeventeen;
    private javax.swing.JLabel fiveSix;
    private javax.swing.JLabel fiveSixteen;
    private javax.swing.JLabel fiveTen;
    private javax.swing.JLabel fiveThirteen;
    private javax.swing.JLabel fiveThree;
    private javax.swing.JLabel fiveTwelve;
    private javax.swing.JLabel fiveTwo;
    private javax.swing.JLabel fiveZero;
    private javax.swing.JLabel fourEight;
    private javax.swing.JLabel fourEighteen;
    private javax.swing.JLabel fourEleven;
    private javax.swing.JLabel fourFifteen;
    private javax.swing.JLabel fourFive;
    private javax.swing.JLabel fourFour;
    private javax.swing.JLabel fourFourteen;
    private javax.swing.JLabel fourNine;
    private javax.swing.JLabel fourNineteen;
    private javax.swing.JLabel fourOne;
    private javax.swing.JLabel fourSeven;
    private javax.swing.JLabel fourSeventeen;
    private javax.swing.JLabel fourSix;
    private javax.swing.JLabel fourSixteen;
    private javax.swing.JLabel fourTen;
    private javax.swing.JLabel fourThirteen;
    private javax.swing.JLabel fourThree;
    private javax.swing.JLabel fourTwelve;
    private javax.swing.JLabel fourTwo;
    private javax.swing.JLabel fourZero;
    private javax.swing.JLabel fourteenEight;
    private javax.swing.JLabel fourteenEighteen;
    private javax.swing.JLabel fourteenEleven;
    private javax.swing.JLabel fourteenFifteen;
    private javax.swing.JLabel fourteenFive;
    private javax.swing.JLabel fourteenFour;
    private javax.swing.JLabel fourteenFourteen;
    private javax.swing.JLabel fourteenNine;
    private javax.swing.JLabel fourteenNineteen;
    private javax.swing.JLabel fourteenOne;
    private javax.swing.JLabel fourteenSeven;
    private javax.swing.JLabel fourteenSeventeen;
    private javax.swing.JLabel fourteenSix;
    private javax.swing.JLabel fourteenSixteen;
    private javax.swing.JLabel fourteenTen;
    private javax.swing.JLabel fourteenThirteen;
    private javax.swing.JLabel fourteenThree;
    private javax.swing.JLabel fourteenTwelve;
    private javax.swing.JLabel fourteenTwo;
    private javax.swing.JLabel fourteenZero;
    private javax.swing.JTextField fuelJTextField;
    private javax.swing.JLabel nineEight;
    private javax.swing.JLabel nineEighteen;
    private javax.swing.JLabel nineEleven;
    private javax.swing.JLabel nineFifteen;
    private javax.swing.JLabel nineFive;
    private javax.swing.JLabel nineFour;
    private javax.swing.JLabel nineFourteen;
    private javax.swing.JLabel nineNine;
    private javax.swing.JLabel nineNineteen;
    private javax.swing.JLabel nineOne;
    private javax.swing.JLabel nineSeven;
    private javax.swing.JLabel nineSeventeen;
    private javax.swing.JLabel nineSix;
    private javax.swing.JLabel nineSixteen;
    private javax.swing.JLabel nineTen;
    private javax.swing.JLabel nineThirteen;
    private javax.swing.JLabel nineThree;
    private javax.swing.JLabel nineTwelve;
    private javax.swing.JLabel nineTwo;
    private javax.swing.JLabel nineZero;
    private javax.swing.JLabel nineteenEight;
    private javax.swing.JLabel nineteenEighteen;
    private javax.swing.JLabel nineteenEleven;
    private javax.swing.JLabel nineteenFifteen;
    private javax.swing.JLabel nineteenFive;
    private javax.swing.JLabel nineteenFour;
    private javax.swing.JLabel nineteenFourteen;
    private javax.swing.JLabel nineteenNine;
    private javax.swing.JLabel nineteenNineteen;
    private javax.swing.JLabel nineteenOne;
    private javax.swing.JLabel nineteenSeven;
    private javax.swing.JLabel nineteenSeventeen;
    private javax.swing.JLabel nineteenSix;
    private javax.swing.JLabel nineteenSixteen;
    private javax.swing.JLabel nineteenTen;
    private javax.swing.JLabel nineteenThirteen;
    private javax.swing.JLabel nineteenThree;
    private javax.swing.JLabel nineteenTwelve;
    private javax.swing.JLabel nineteenTwo;
    private javax.swing.JLabel nineteenZero;
    private javax.swing.JLabel oneEight;
    private javax.swing.JLabel oneEighteen;
    private javax.swing.JLabel oneEleven;
    private javax.swing.JLabel oneFifteen;
    private javax.swing.JLabel oneFive;
    private javax.swing.JLabel oneFour;
    private javax.swing.JLabel oneFourteen;
    private javax.swing.JLabel oneNine;
    private javax.swing.JLabel oneNineteen;
    private javax.swing.JLabel oneOne;
    private javax.swing.JLabel oneSeven;
    private javax.swing.JLabel oneSeventeen;
    private javax.swing.JLabel oneSix;
    private javax.swing.JLabel oneSixteen;
    private javax.swing.JLabel oneTen;
    private javax.swing.JLabel oneThirteen;
    private javax.swing.JLabel oneThree;
    private javax.swing.JLabel oneTwelve;
    private javax.swing.JLabel oneTwo;
    private javax.swing.JLabel oneZero;
    private javax.swing.JLabel sevenEight;
    private javax.swing.JLabel sevenEighteen;
    private javax.swing.JLabel sevenEleven;
    private javax.swing.JLabel sevenFifteen;
    private javax.swing.JLabel sevenFive;
    private javax.swing.JLabel sevenFour;
    private javax.swing.JLabel sevenFourteen;
    private javax.swing.JLabel sevenNine;
    private javax.swing.JLabel sevenNineteen;
    private javax.swing.JLabel sevenOne;
    private javax.swing.JLabel sevenSeven;
    private javax.swing.JLabel sevenSeventeen;
    private javax.swing.JLabel sevenSix;
    private javax.swing.JLabel sevenSixteen;
    private javax.swing.JLabel sevenTen;
    private javax.swing.JLabel sevenThirteen;
    private javax.swing.JLabel sevenThree;
    private javax.swing.JLabel sevenTwelve;
    private javax.swing.JLabel sevenTwo;
    private javax.swing.JLabel sevenZero;
    private javax.swing.JLabel seventeenEight;
    private javax.swing.JLabel seventeenEighteen;
    private javax.swing.JLabel seventeenEleven;
    private javax.swing.JLabel seventeenFifteen;
    private javax.swing.JLabel seventeenFive;
    private javax.swing.JLabel seventeenFour;
    private javax.swing.JLabel seventeenFourteen;
    private javax.swing.JLabel seventeenNine;
    private javax.swing.JLabel seventeenNineteen;
    private javax.swing.JLabel seventeenOne;
    private javax.swing.JLabel seventeenSeven;
    private javax.swing.JLabel seventeenSeventeen;
    private javax.swing.JLabel seventeenSix;
    private javax.swing.JLabel seventeenSixteen;
    private javax.swing.JLabel seventeenTen;
    private javax.swing.JLabel seventeenThirteen;
    private javax.swing.JLabel seventeenThree;
    private javax.swing.JLabel seventeenTwelve;
    private javax.swing.JLabel seventeenTwo;
    private javax.swing.JLabel seventeenZero;
    private javax.swing.JLabel sixEight;
    private javax.swing.JLabel sixEighteen;
    private javax.swing.JLabel sixEleven;
    private javax.swing.JLabel sixFifteen;
    private javax.swing.JLabel sixFive;
    private javax.swing.JLabel sixFour;
    private javax.swing.JLabel sixFourteen;
    private javax.swing.JLabel sixNine;
    private javax.swing.JLabel sixNineteen;
    private javax.swing.JLabel sixOne;
    private javax.swing.JLabel sixSeven;
    private javax.swing.JLabel sixSeventeen;
    private javax.swing.JLabel sixSix;
    private javax.swing.JLabel sixSixteen;
    private javax.swing.JLabel sixTen;
    private javax.swing.JLabel sixThirteen;
    private javax.swing.JLabel sixThree;
    private javax.swing.JLabel sixTwelve;
    private javax.swing.JLabel sixTwo;
    private javax.swing.JLabel sixZero;
    private javax.swing.JLabel sixteenEight;
    private javax.swing.JLabel sixteenEighteen;
    private javax.swing.JLabel sixteenEleven;
    private javax.swing.JLabel sixteenFifteen;
    private javax.swing.JLabel sixteenFive;
    private javax.swing.JLabel sixteenFour;
    private javax.swing.JLabel sixteenFourteen;
    private javax.swing.JLabel sixteenNine;
    private javax.swing.JLabel sixteenNineteen;
    private javax.swing.JLabel sixteenOne;
    private javax.swing.JLabel sixteenSeven;
    private javax.swing.JLabel sixteenSeventeen;
    private javax.swing.JLabel sixteenSix;
    private javax.swing.JLabel sixteenSixteen;
    private javax.swing.JLabel sixteenTen;
    private javax.swing.JLabel sixteenThirteen;
    private javax.swing.JLabel sixteenThree;
    private javax.swing.JLabel sixteenTwelve;
    private javax.swing.JLabel sixteenTwo;
    private javax.swing.JLabel sixteenZero;
    private javax.swing.JLabel tenEight;
    private javax.swing.JLabel tenEighteen;
    private javax.swing.JLabel tenEleven;
    private javax.swing.JLabel tenFifteen;
    private javax.swing.JLabel tenFive;
    private javax.swing.JLabel tenFour;
    private javax.swing.JLabel tenFourteen;
    private javax.swing.JLabel tenNine;
    private javax.swing.JLabel tenNineteen;
    private javax.swing.JLabel tenOne;
    private javax.swing.JLabel tenSeven;
    private javax.swing.JLabel tenSeventeen;
    private javax.swing.JLabel tenSix;
    private javax.swing.JLabel tenSixteen;
    private javax.swing.JLabel tenTen;
    private javax.swing.JLabel tenThirteen;
    private javax.swing.JLabel tenThree;
    private javax.swing.JLabel tenTwelve;
    private javax.swing.JLabel tenTwo;
    private javax.swing.JLabel tenZero;
    private javax.swing.JLabel thirteenEight;
    private javax.swing.JLabel thirteenEighteen;
    private javax.swing.JLabel thirteenEleven;
    private javax.swing.JLabel thirteenFifteen;
    private javax.swing.JLabel thirteenFive;
    private javax.swing.JLabel thirteenFour;
    private javax.swing.JLabel thirteenFourteen;
    private javax.swing.JLabel thirteenNine;
    private javax.swing.JLabel thirteenNineteen;
    private javax.swing.JLabel thirteenOne;
    private javax.swing.JLabel thirteenSeven;
    private javax.swing.JLabel thirteenSeventeen;
    private javax.swing.JLabel thirteenSix;
    private javax.swing.JLabel thirteenSixteen;
    private javax.swing.JLabel thirteenTen;
    private javax.swing.JLabel thirteenThirteen;
    private javax.swing.JLabel thirteenThree;
    private javax.swing.JLabel thirteenTwelve;
    private javax.swing.JLabel thirteenTwo;
    private javax.swing.JLabel thirteenZero;
    private javax.swing.JLabel threeEight;
    private javax.swing.JLabel threeEighteen;
    private javax.swing.JLabel threeEleven;
    private javax.swing.JLabel threeFifteen;
    private javax.swing.JLabel threeFive;
    private javax.swing.JLabel threeFour;
    private javax.swing.JLabel threeFourteen;
    private javax.swing.JLabel threeNine;
    private javax.swing.JLabel threeNineteen;
    private javax.swing.JLabel threeOne;
    private javax.swing.JLabel threeSeven;
    private javax.swing.JLabel threeSeventeen;
    private javax.swing.JLabel threeSix;
    private javax.swing.JLabel threeSixteen;
    private javax.swing.JLabel threeTen;
    private javax.swing.JLabel threeThirteen;
    private javax.swing.JLabel threeThree;
    private javax.swing.JLabel threeTwelve;
    private javax.swing.JLabel threeTwo;
    private javax.swing.JLabel threeZero;
    private javax.swing.JLabel twelveEight;
    private javax.swing.JLabel twelveEighteen;
    private javax.swing.JLabel twelveEleven;
    private javax.swing.JLabel twelveFifteen;
    private javax.swing.JLabel twelveFive;
    private javax.swing.JLabel twelveFour;
    private javax.swing.JLabel twelveFourteen;
    private javax.swing.JLabel twelveNine;
    private javax.swing.JLabel twelveNineteen;
    private javax.swing.JLabel twelveOne;
    private javax.swing.JLabel twelveSeven;
    private javax.swing.JLabel twelveSeventeen;
    private javax.swing.JLabel twelveSix;
    private javax.swing.JLabel twelveSixteen;
    private javax.swing.JLabel twelveTen;
    private javax.swing.JLabel twelveThirteen;
    private javax.swing.JLabel twelveThree;
    private javax.swing.JLabel twelveTwelve;
    private javax.swing.JLabel twelveTwo;
    private javax.swing.JLabel twelveZero;
    private javax.swing.JLabel twoEight;
    private javax.swing.JLabel twoEighteen;
    private javax.swing.JLabel twoEleven;
    private javax.swing.JLabel twoFifteen;
    private javax.swing.JLabel twoFive;
    private javax.swing.JLabel twoFour;
    private javax.swing.JLabel twoFourteen;
    private javax.swing.JLabel twoNine;
    private javax.swing.JLabel twoNineteen;
    private javax.swing.JLabel twoOne;
    private javax.swing.JLabel twoSeven;
    private javax.swing.JLabel twoSeventeen;
    private javax.swing.JLabel twoSix;
    private javax.swing.JLabel twoSixteen;
    private javax.swing.JLabel twoTen;
    private javax.swing.JLabel twoThirteen;
    private javax.swing.JLabel twoThree;
    private javax.swing.JLabel twoTwelve;
    private javax.swing.JLabel twoTwo;
    private javax.swing.JLabel twoZero;
    private javax.swing.JLabel zeroEight;
    private javax.swing.JLabel zeroEighteen;
    private javax.swing.JLabel zeroEleven;
    private javax.swing.JLabel zeroFifteen;
    private javax.swing.JLabel zeroFive;
    private javax.swing.JLabel zeroFour;
    private javax.swing.JLabel zeroFourteen;
    private javax.swing.JLabel zeroNine;
    private javax.swing.JLabel zeroNineteen;
    private javax.swing.JLabel zeroOne;
    private javax.swing.JLabel zeroSeven;
    private javax.swing.JLabel zeroSeventeen;
    private javax.swing.JLabel zeroSix;
    private javax.swing.JLabel zeroSixteen;
    private javax.swing.JLabel zeroTen;
    private javax.swing.JLabel zeroThirteen;
    private javax.swing.JLabel zeroThree;
    private javax.swing.JLabel zeroTwelve;
    private javax.swing.JLabel zeroTwo;
    private javax.swing.JLabel zeroZero;
    // End of variables declaration//GEN-END:variables
}
