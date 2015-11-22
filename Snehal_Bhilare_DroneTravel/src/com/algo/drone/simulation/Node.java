/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algo.drone.simulation;

import javax.swing.JLabel;

/**
 *
 * @author Snehal
 */
public class Node {

    String xName;
    String yName;
    int xValue;
    int yValue;
    boolean isAnomaly;
    boolean strong;
    JLabel lable;

    Node(String xC, String yC, int x, int y) {
        xName = xC;
        yName = yC;
        xValue = x;
        yValue = y;
        isAnomaly = false;
        strong = false;
        lable = new JLabel();
    }

    public boolean isStrong() {
        return strong;
    }

    public void setStrong(boolean strong) {
        this.strong = strong;
    }

    public String getxName() {
        return xName;
    }

    public void setxName(String xName) {
        this.xName = xName;
    }

    public String getyName() {
        return yName;
    }

    public void setyName(String yName) {
        this.yName = yName;
    }

    public int getxValue() {
        return xValue;
    }

    public void setxValue(int xValue) {
        this.xValue = xValue;
    }

    public int getyValue() {
        return yValue;
    }

    public void setyValue(int yValue) {
        this.yValue = yValue;
    }

    public boolean isIsAnomaly() {
        return isAnomaly;
    }

    public void setIsAnomaly(boolean isAnomaly) {
        this.isAnomaly = isAnomaly;
    }

    public JLabel getLable() {
        return lable;
    }

    public void setLable(JLabel lable) {
        this.lable = lable;
    }

    @Override
    public String toString() {
        return xName + yName;
    }

}
