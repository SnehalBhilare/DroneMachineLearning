/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algo.drone.simulation;

/**
 *
 * @author Snehal
 */
public class PathNodeLinkedList {

    private PathNode root;

    public PathNodeLinkedList() {
        root = new PathNode();
    }

    public void shuffle(PathNode n) {

        PathNode p = root;
        PathNode q = root;

        if (root != null) {
            while (!q.next.equals(n)) {
                q = q.next;
            }
            q.next = n.next;
            p = root;

            q = root;
            while (q.getCf() > n.getCf()) {
                p = q;
                q = q.next;
            }

            p.next = n;
            n.next = q;

        }

    }

    public void enqueue(PathNode n) {
        PathNode current = root;
        PathNode prev = null;
        while (current != null && current.getCf() < n.getCf()) {
            prev = current;
            current = current.next;
        }

        if (prev == null) // if beginning of list,
        {
            root = n;
        } else // not at beginning,
        {
            prev.next = n; // prev --> new 
        }
        n.next = current; // only for 2nd &&
    }

    public PathNode getRoot() {
        return root;
    }

    public void setRoot(PathNode root) {
        this.root = root;
    }

}
