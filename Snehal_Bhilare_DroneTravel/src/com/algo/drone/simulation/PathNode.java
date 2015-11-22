/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algo.drone.simulation;

import java.util.ArrayList;

/**
 *
 * @author Snehal
 */
public class PathNode {

    int cf;
    int distance;
    ArrayList<Node> path;
    PathNode next;
    int fuelConsumption;

    public PathNode() {
        next = null;
        cf = 0;
        distance = 0;
        path = new ArrayList<Node>();

        fuelConsumption = 0;

    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void addNode(Node n) {
        path.add(n);
    }

    public int getCf() {
        return cf;
    }

    public void setCf(int cf) {
        this.cf = cf;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public ArrayList<Node> getPath() {
        return path;
    }

    public void setPath(ArrayList<Node> path) {
        this.path = path;
    }

}
