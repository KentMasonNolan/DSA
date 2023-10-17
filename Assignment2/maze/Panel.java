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


    public Panel() {
        this.currentMazeNum = 1;
        this.root = null;
        loadMazeFile(currentMazeNum);

        previousMaze = createButton("Maze 1", evt -> navigateMaze(1));
        nextMaze = createButton("Maze 2", evt -> navigateMaze(2));

        buttonPanel = new JPanel();
        buttonPanel.add(previousMaze);
        buttonPanel.add(nextMaze);
        setLayout(new BorderLayout());
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    private JButton createButton(String label, ActionListener action) {
        JButton button = new JButton(label);
        button.addActionListener(action);
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


    private void paintNodesAndPaths(Graphics g) {
        Set eSet = nodeMap.keySet();
        Iterator it = eSet.iterator();
        while (it.hasNext()) {
            String nodeName = (String) it.next();
            Node currentNode = nodeMap.get(nodeName);
            int x = currentNode.posX * 80 + 100;
            int y = currentNode.posY * 80 + 100;

            g.setColor(Color.BLUE);
            g.fillOval(x, y, 10, 10);
            g.drawString(currentNode.identifier, x - 10, y - 2);

            if (currentNode.leftConnection != null) {
                paintLineBetweenNodes(g, currentNode, currentNode.leftConnection);
            }

            if (currentNode.rightConnection != null) {
                paintLineBetweenNodes(g, currentNode, currentNode.rightConnection);
            }
        }
    }

    private void paintLineBetweenNodes(Graphics g, Node from, Node to) {
        int x1 = from.posX * 80 + 105;
        int y1 = from.posY * 80 + 105;
        int x2 = to.posX * 80 + 105;
        int y2 = to.posY * 80 + 105;

        g.drawLine(x1, y1, x2, y2);
    }

    private void paintPathToExit(Graphics g) {
        if (!pathNodes.empty()) {
            Node currentNode = pathNodes.pop();
            pathNodeNames.add(currentNode.identifier);

            for (int i = 0; i < pathNodeNames.size(); i++) {
                if (i + 1 < pathNodeNames.size()) {
                    Node currentPathNode = nodeMap.get(pathNodeNames.get(i));
                    Node nextPathNode = nodeMap.get(pathNodeNames.get(i + 1));

                    g.setColor(Color.GREEN);
                    paintLineBetweenNodes(g, currentPathNode, nextPathNode);

                    g.setColor(Color.BLUE);
                    g.fillOval(currentPathNode.posX * 80 + 100, currentPathNode.posY * 80 + 100, 10, 10);
                    g.fillOval(nextPathNode.posX * 80 + 100, nextPathNode.posY * 80 + 100, 10, 10);
                }
            }
        }
    }

    private void pauseThread() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void paintCurrentNode(Graphics g) {
        if (!pathNodes.empty()) {
            Node currentNode = pathNodes.peek(); // use peek() instead of pop() to get the top element without removing it.
            g.setColor(Color.GREEN);
            g.fillOval(currentNode.posX * 80 + 101, currentNode.posY * 80 + 101, 8, 8);
            repaint();
        }
    }

    private void paintExitNode(Graphics g) {
        int x = nodeMap.get("EXIT").posX * 80 + 100;
        int y = nodeMap.get("EXIT").posY * 80 + 100;
        g.setColor(Color.RED);
        g.fillOval(x + 1, y + 1, 8, 8);
    }

    private void navigateMaze(int maze) {
        loadMazeFile(maze);
        repaint();
    }

    private void enableValidButtons() {
        previousMaze.setEnabled(checkMazeFileExistence(currentMazeNum - 1));
        nextMaze.setEnabled(checkMazeFileExistence(currentMazeNum + 1));
    }

    private boolean checkMazeFileExistence(int mazeNumber) {
        return new File("Maze" + mazeNumber + ".txt").exists();
    }

    private void loadMazeFile(int mazeNumber) {
        if (checkMazeFileExistence(mazeNumber)) {
            fileManager = new FileManager("Maze" + mazeNumber + ".txt");
            fileManager.readFile(null);
            constructBinaryTree();
        }
    }

    private void readNodesFromFile() {
        for (int i = 1; i < fileManager.lineData.length; i++) {
            String[] parts = fileManager.lineData[i].split(",");
            String nodeName = parts[0];
            Node node = new Node(
                    nodeName,
                    Integer.parseInt(parts[1]),
                    Integer.parseInt(parts[2]),
                    parts[3],
                    parts[4]
            );
            nodeMap.put(nodeName, node);
        }
    }

    private void constructBinaryTree() {
        nodeMap.clear();
        pathNodes.clear();
        pathNodeNames.clear();

        readNodesFromFile();
        this.root = nodeMap.get("START");
        addNode(root);
        setMazePath(nodeMap.get("EXIT"));
    }

    private void addNode(Node root) {
        if (!root.leftNodeName.equals("A")) {
            if (root.leftNodeName.equals("W")) {
                root.leftConnection = nodeMap.get("EXIT");
            } else if (root.leftConnection == null) {
                root.leftConnection = nodeMap.get(root.leftNodeName);
                addNode(root.leftConnection);
            }
            root.leftConnection.prior = root;
        }
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
        if (exitNode != null) {
            pathNodes.add(exitNode);
            setMazePath(exitNode.prior);
        }
    }
}
