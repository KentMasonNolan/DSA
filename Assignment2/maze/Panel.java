package Assignment2.maze;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;
import javax.swing.*;


public class Panel extends JPanel {

    private final JPanel buttonPanel;
    private final JButton previousMaze;
    private final JButton nextMaze;
    private FileManager fileManager;
    private int currentMazeNum;
    private Node root;
    private final HashMap<String, Node> nodeMap = new HashMap<>();
    private final Stack<Node> pathNodes = new Stack<>();
    private final ArrayList<String> pathNodeNames = new ArrayList<>();


    // Panel constructor
    public Panel() {
        // set the current maze number to 1
        this.currentMazeNum = 1;
        // initialize the root of the maze to null
        this.root = null;
        // load the maze based on the current maze number
        loadMazeFile(currentMazeNum);

        // create a button to navigate to the first maze
        previousMaze = createButton("Maze 1", evt -> navigateMaze(1));
        // create a button to navigate to the second maze
        nextMaze = createButton("Maze 2", evt -> navigateMaze(2));

        // initialize the button panel and add the two maze navigation buttons
        buttonPanel = new JPanel();
        buttonPanel.add(previousMaze);
        buttonPanel.add(nextMaze);

        // set the layout for this panel and add the button panel to the south
        setLayout(new BorderLayout());
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    // method to create a button with the given label and action
    private JButton createButton(String label, ActionListener action) {
        // create a new button with the given label
        JButton button = new JButton(label);
        // add the specified action to the button
        button.addActionListener(action);
        // return the newly created button
        return button;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        paintNodesAndPaths(g);
        paintPathToExit(g);
        pauseThread();
        paintCurrentNode(g);
        paintExitNode(g);
    }


    // method to paint nodes and their connecting paths
    private void paintNodesAndPaths(Graphics g) {
        // get the set of keys from the nodeMap
        Set eSet = nodeMap.keySet();
        // create an iterator for the keySet
        Iterator it = eSet.iterator();

        // iterate over all the nodes
        while (it.hasNext()) {
            // get the node's name
            String nodeName = (String) it.next();
            // get the corresponding Node object from the map
            Node currentNode = nodeMap.get(nodeName);
            // calculate the x and y positions for the node based on its stored position and a scaling factor
            int x = currentNode.posX * 80 + 100;
            int y = currentNode.posY * 80 + 100;

            // set the paint color to blue for nodes
            g.setColor(Color.BLUE);
            // draw a circle for the node
            g.fillOval(x, y, 10, 10);
            // display the node's identifier next to the node
            g.drawString(currentNode.identifier, x - 10, y - 2);

            // if the current node has a left connection, paint a line to that node
            if (currentNode.leftConnection != null) {
                paintLineBetweenNodes(g, currentNode, currentNode.leftConnection);
            }

            // if the current node has a right connection, paint a line to that node
            if (currentNode.rightConnection != null) {
                paintLineBetweenNodes(g, currentNode, currentNode.rightConnection);
            }
        }
    }


    // draws a line between two given nodes
    private void paintLineBetweenNodes(Graphics g, Node from, Node to) {
        int x1 = from.posX * 80 + 105;
        int y1 = from.posY * 80 + 105;
        int x2 = to.posX * 80 + 105;
        int y2 = to.posY * 80 + 105;

        g.drawLine(x1, y1, x2, y2);
    }


    private void paintPathToExit(Graphics g) {
        // if there are still nodes left in pathNodes
        if (!pathNodes.empty()) {
            // get the top node and add its name to the list
            Node currentNode = pathNodes.pop();
            pathNodeNames.add(currentNode.identifier);

            // go through the names in the list
            for (int i = 0; i < pathNodeNames.size(); i++) {
                // making sure we don't run out of names for the next node
                if (i + 1 < pathNodeNames.size()) {
                    // get current and next node from their names
                    Node currentPathNode = nodeMap.get(pathNodeNames.get(i));
                    Node nextPathNode = nodeMap.get(pathNodeNames.get(i + 1));

                    // draw a green line between these two nodes
                    g.setColor(Color.GREEN);
                    paintLineBetweenNodes(g, currentPathNode, nextPathNode);

                    // draw the current and next nodes in blue
                    g.setColor(Color.BLUE);
                    g.fillOval(currentPathNode.posX * 80 + 100, currentPathNode.posY * 80 + 100, 10, 10);
                    g.fillOval(nextPathNode.posX * 80 + 100, nextPathNode.posY * 80 + 100, 10, 10);
                }
            }
        }
    }


    // pause the current thread for 1 second
    private void pauseThread() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // draw the current node from the stack as green on the panel
    private void paintCurrentNode(Graphics g) {
        // check if there are nodes in the stack
        if (!pathNodes.empty()) {
            // get the top node without removing it
            Node currentNode = pathNodes.peek();

            // set the color to green
            g.setColor(Color.GREEN);

            // draw the node
            g.fillOval(currentNode.posX * 80 + 101, currentNode.posY * 80 + 101, 8, 8);

            // repaint to show the new drawing
            repaint();
        }
    }


    // draw the exit node in red
    private void paintExitNode(Graphics g) {
        // get the EXIT node's position
        int x = nodeMap.get("EXIT").posX * 80 + 100;
        int y = nodeMap.get("EXIT").posY * 80 + 100;

        // set color to red and draw the node
        g.setColor(Color.RED);
        g.fillOval(x + 1, y + 1, 8, 8);
    }


    private void navigateMaze(int maze) {
        loadMazeFile(maze);
        repaint();
    }

    private boolean checkMazeFileExistence(int mazeNumber) {
        return new File("Maze" + mazeNumber + ".txt").exists();
    }

    private void loadMazeFile(int mazeNumber) {
        // check if the maze file exists
        if (checkMazeFileExistence(mazeNumber)) {
            // create a file manager for the specified maze file
            fileManager = new FileManager("Maze" + mazeNumber + ".txt");
            // read the file
            fileManager.readFile(null);
            // after reading, construct the binary tree representation of the maze
            constructBinaryTree();
        }
    }


    private void readNodesFromFile() {
        // start from the second line since first line might be header/info
        for (int i = 1; i < fileManager.lineData.length; i++) {
            // split each line based on comma
            String[] parts = fileManager.lineData[i].split(",");
            // extract node name from the split data
            String nodeName = parts[0];
            // create a new Node object using extracted details
            Node node = new Node(
                    nodeName,
                    Integer.parseInt(parts[1]),  // x-coordinate
                    Integer.parseInt(parts[2]),  // y-coordinate
                    parts[3],  // left connection
                    parts[4]   // right connection
            );
            // add this node to our node map
            nodeMap.put(nodeName, node);
        }
    }


    private void constructBinaryTree() {
        // clear any previous data
        nodeMap.clear();
        pathNodes.clear();
        pathNodeNames.clear();

        // read nodes from the file
        readNodesFromFile();
        // set the starting node as the root
        this.root = nodeMap.get("START");
        addNode(root);
        // set the path to the exit node
        setMazePath(nodeMap.get("EXIT"));
    }


    private void addNode(Node root) {
        // check if left node is available and not already connected
        if (!root.leftNodeName.equals("A")) {
            // check if the left node is the exit node
            if (root.leftNodeName.equals("W")) {
                root.leftConnection = nodeMap.get("EXIT");
            }
            // connect the left node if not already connected
            else if (root.leftConnection == null) {
                root.leftConnection = nodeMap.get(root.leftNodeName);
                addNode(root.leftConnection);
            }
            // set prior node reference for left node
            root.leftConnection.prior = root;
        }

        // same logic for the right node as above
        if (!root.rightNodeName.equals("A")) {
            if (root.rightNodeName.equals("W")) {
                root.rightConnection = nodeMap.get("EXIT");
            } else if (root.rightConnection == null) {
                root.rightConnection = nodeMap.get(root.rightNodeName);
                addNode(root.rightConnection);
            }
            root.rightConnection.prior = root;
        }
    }


    private void setMazePath(Node exitNode) {
        // check if node is not null
        if (exitNode != null) {
            // add node to the pathNodes stack
            pathNodes.add(exitNode);
            // recursively trace back through the prior node
            setMazePath(exitNode.prior);
        }
    }

}
