/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algo.drone.simulation;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Snehal
 */
public class Drone {

    private static Drone drone;
    private Node currNode;
    private Node prevNode;
    private Node source;
    private Node dest;
    private Anomaly anomaly;
    HashMap<String, Node> nodeMap;
    private String path;
    private int fuel;

    public static Drone getInstance() {
        if (drone == null) {
            drone = new Drone();
        }
        return drone;
    }

    private Drone() {
        anomaly = new Anomaly();
        nodeMap = addNodes();
        source = nodeMap.get("twoTwo");
        dest = nodeMap.get("nineteenNineteen");
        currNode = source;
        path = "";
        fuel = 100;
        addNodes();
    }

    public static Drone getDrone() {
        return drone;
    }

    public static void setDrone(Drone drone) {
        Drone.drone = drone;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Node getCurrNode() {
        return currNode;
    }

    public void setCurrNode(Node currNode) {
        this.currNode = currNode;
    }

    public Node getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }

    public Node getSource() {
        return source;
    }

    public void setSource(Node source) {
        this.source = source;
    }

    public Node getDest() {
        return dest;
    }

    public void setDest(Node dest) {
        this.dest = dest;
    }

    public Anomaly getAnomaly() {
        return anomaly;
    }

    public void setAnomaly(Anomaly anomaly) {
        this.anomaly = anomaly;
    }

    public HashMap<String, Node> getNodeMap() {
        return nodeMap;
    }

    public void setNodeMap(HashMap<String, Node> nodeMap) {
        this.nodeMap = nodeMap;
    }

    public HashMap<String, Node> addNodes() {
        HashMap<String, Node> nodeComponentsMap = new HashMap();

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {

                StringBuffer sb = new StringBuffer();
                String xC = anomaly.getStringFromDigit(i);
                String yC = anomaly.getStringFromDigit(j);

                sb.append(xC);
                sb.append(yC.substring(0, 1).toUpperCase());
                sb.append(yC.substring(1));
                Node node = new Node(xC, yC.substring(0, 1).toUpperCase() + yC.substring(1), i, j);
                nodeComponentsMap.put(sb.toString(), node);

            }
        }
        return nodeComponentsMap;
    }

    public ArrayList<Node> getAdjacentNodes(Node currentNode) {
        ArrayList<Node> adjacentNodeList = new ArrayList<>();
        int x = currentNode.getxValue();
        int y = currentNode.getyValue();

        if (x == 0 && y == 0) {
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y + 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y + 1));

        } else if (x == 19 && y == 0) {
            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y + 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y + 1));

        } else if (x == 0 && y == 19) {

            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y));

        } else if (x == 19 && y == 19) {

            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y));

        } else if (x == 0 && (y > 0 || y < 19)) {

            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y + 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y + 1));

        } else if (y == 0 && (x > 0 || x < 19)) {

            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y + 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y + 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y + 1));

        } else if (x == 19 && (y > 0 || y < 19)) {

            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y + 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y + 1));

        } else if (y == 19 && (x > 0 || x < 19)) {

            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y));

        } else {

            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y + 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y + 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y + 1));

        }

        return adjacentNodeList;
    }

    public boolean flyDrone() {
        boolean flag = false;
        ArrayList<Node> adjacentNodes = getAdjacentNodes(getCurrNode());
        //System.out.println("Current Node:  " +currNode);
        int xTwo = getDest().getxValue();
        int yTwo = getDest().getyValue();
        double smallestDistance = 40;
        Node smallestDistanceNode = null;

        for (Node adjacentNode : adjacentNodes) {
            if (!adjacentNode.isIsAnomaly()) {
                int xOne = adjacentNode.getxValue();
                int yOne = adjacentNode.getyValue();
                //applying distance formula
                double distance = Math.sqrt((xTwo - xOne) * (xTwo - xOne) + (yTwo - yOne) * (yTwo - yOne));

                if (distance <= smallestDistance) {

                    smallestDistance = distance;
                    smallestDistanceNode = adjacentNode;

                }
            }

        }
        if (smallestDistanceNode == null) {

            for (Node adjacentNode : adjacentNodes) {
                if (!adjacentNode.isIsAnomaly() && !adjacentNode.isStrong()) {
                    int xOne = adjacentNode.getxValue();
                    int yOne = adjacentNode.getyValue();
                    //applying distance formula
                    double distance = Math.sqrt((xTwo - xOne) * (xTwo - xOne) + (yTwo - yOne) * (yTwo - yOne));

                    if (distance <= smallestDistance) {

                        smallestDistance = distance;
                        smallestDistanceNode = adjacentNode;

                    }
                }

            }

        }

        if (smallestDistanceNode != null) {
            setPrevNode(currNode);
            setCurrNode(smallestDistanceNode);
            if (getCurrNode().equals(getDest())) {

                flag = true;
            } else {

                flag = false;
            }
        }

        return flag;

    }

    public Node returnNodeFromCoOrdinates(int x, int y) {
        String xCoOrdinate = anomaly.getStringFromDigit(x);
        String yCoOrdinate = anomaly.getStringFromDigit(y).substring(0, 1).toUpperCase() + anomaly.getStringFromDigit(y).substring(1);
        StringBuilder sb = new StringBuilder();
        sb.append(xCoOrdinate);
        sb.append(yCoOrdinate);
        Node node = nodeMap.get(sb.toString());
        return node;

    }

}
