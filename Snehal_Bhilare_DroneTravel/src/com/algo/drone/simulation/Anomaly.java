/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algo.drone.simulation;

import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author Snehal
 */
public class Anomaly {

    public void createAnomalies(HashMap<String, Node> map) {
        int anomalyCount = 0 + (int) (Math.random() * 300);

        for (int i = 0; i <= anomalyCount; i++) {
            int xNum = 0 + (int) (Math.random() * 20);
            int yNum = 0 + (int) (Math.random() * 20);
            StringBuffer sb = new StringBuffer();
            sb.append(getStringFromDigit(xNum));
            sb.append(getStringFromDigit(yNum).substring(0, 1).toUpperCase());
            sb.append(getStringFromDigit(yNum).substring(1));

            Node n = map.get(sb.toString());
            if (xNum % 2 == 0 || yNum % 2 == 0) {
                n.setStrong(true);
            }
            n.setIsAnomaly(true);

        }
    }

    public void deleteAnomalies(HashMap<String, Node> map) {
        Collection<Node> nodeList = map.values();
        for (Node n : nodeList) {
            if (n.isIsAnomaly() == true) {
                n.setIsAnomaly(false);
                n.setStrong(false);
            }

        }

    }

    public String getStringFromDigit(int digit) {

        String digitToString = "";
        switch (digit) {
            case 0:
                digitToString = "zero";
                break;
            case 1:
                digitToString = "one";
                break;
            case 2:
                digitToString = "two";
                break;
            case 3:
                digitToString = "three";
                break;
            case 4:
                digitToString = "four";
                break;
            case 5:
                digitToString = "five";
                break;
            case 6:
                digitToString = "six";
                break;
            case 7:
                digitToString = "seven";
                break;
            case 8:
                digitToString = "eight";
                break;
            case 9:
                digitToString = "nine";
                break;
            case 10:
                digitToString = "ten";
                break;
            case 11:
                digitToString = "eleven";
                break;
            case 12:
                digitToString = "twelve";
                break;
            case 13:
                digitToString = "thirteen";
                break;
            case 14:
                digitToString = "fourteen";
                break;
            case 15:
                digitToString = "fifteen";
                break;
            case 16:
                digitToString = "sixteen";
                break;
            case 17:
                digitToString = "seventeen";
                break;
            case 18:
                digitToString = "eighteen";
                break;
            case 19:
                digitToString = "nineteen";
                break;
            default:
                digitToString = "Invalid";
                break;
        }
        return digitToString;

    }

}
