package Assignment2.maze;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JPanel;


public class Panel extends JPanel {


    private HashMap<String, Node> nodes; // stores all nodes of the maze
    private Node startNode; // stores the start node of the maze
    private Node exitNode; // stores the exit node of the maze
    private ArrayList<Node> path; // stores the path from start to exit

    public Panel() {
        setBackground(Color.WHITE);
        loadMaze("maze1.txt"); // change this to load the other maze
    }

    // loads the maze from the specified file
    private void loadMaze(String fileName) {
        nodes = new HashMap<String, Node>();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            String[] header = scanner.nextLine().split(",");
            int numLinks = Integer.parseInt(header[0]);
            int numColumns = Integer.parseInt(header[1]);
            int numRows = Integer.parseInt(header[2]);
            for (int i = 0; i < numLinks; i++) {
                String[] line = scanner.nextLine().split(",");
                String name = line[0];
                int x = Integer.parseInt(line[1]);
                int y = Integer.parseInt(line[2]);
                String next1 = line[3];
                String next2 = line[4];
                Node node = new Node(name, x, y);
                if (!next1.equals("A")) {
                    node.addNeighbor(nodes.get(next1));
                }
                if (!next2.equals("A")) {
                    node.addNeighbor(nodes.get(next2));
                }
                nodes.put(name, node);
                if (name.equals("START")) {
                    startNode = node;
                } else if (name.equals("EXIT")) {
                    exitNode = node;
                }
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // finds the path from start to exit using depth-first search
    private void findPath() {
        path = new ArrayList<Node>();
        startNode.setVisited(true);
//        findPath(startNode);
        startNode.setVisited(false);
    }

//    private boolean findPath(Node node) {
//        if (node.equals(exitNode)) {
//            path.add(node);
//            return true;
//        }
//        for (Node neighbor : node.getNeighbors()) {
//            if (!neighbor.isVisited()) {
//                neighbor.setVisited(true);
//                if (findPath(neighbor)) {
//                    path.add(0, node);
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    // draws the maze on the panel
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        for (Node node : nodes.values()) {
            g.setColor(Color.BLACK);
            g.drawString(node.getName(), node.getX() * 50 + 10, node.getY() * 50 + 25);
            g.setColor(Color.BLUE);
        }
    }
}
