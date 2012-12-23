package main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paRRadox
 */
public class Solver {
    
    public Solver(byte[][] graph, byte[] robots) {
        this.graph = graph;
        this.robots = robots;
        this.whiteGraph = new ArrayList<>();
        this.blackGraph = new ArrayList<>();
    }
    
    public boolean haveSolution() {
        chooseWhite(0);
        chooseBlack();
        return (robotsNumber(whiteGraph) != 1 && robotsNumber(blackGraph) != 1);
    }
    
    private boolean canJump(int i, int j) {
        for (int k = 0; k < graph.length; ++k) {
            if (graph[i][k] > 0 && graph[k][j] > 0) {
                return true;
            }
        } 
        return false;
    }
    
    private void chooseWhite(int node) {
        whiteGraph.add(node);
        for (int i = 0; i < graph.length; ++i) {
            if (canJump(node, i) && !whiteGraph.contains(i)) {
                chooseWhite(i);
            }
        }
    }
    
    private void chooseBlack() {
        for (int i = 1; i < graph.length; ++i) {
            if (!whiteGraph.contains(i)) {
                blackGraph.add(i);
            }
        }
    }
    
    private int robotsNumber(List<Integer> subGraph) {
        int number = 0;
        for (int i = 0; i < graph.length; ++i) {
            if (subGraph.contains(i) && robots[i] > 0) {
                number++;
            }
        }
        return number;
    }
    
    private byte[][] graph;
    
    private byte[] robots;
    
    private List<Integer> whiteGraph;
    
    private List<Integer> blackGraph;
}
