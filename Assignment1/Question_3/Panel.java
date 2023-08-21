/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1.Question_3;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author xhu
 */
public class Panel extends JPanel implements KeyListener, ShipPositionCallback{
    
    int number_ship = 20;
    boolean program_starts = false;
    Ship[] ships = new Ship[number_ship];

    Ship singleShip;
    Port port;
    
    Image ship_image;
    Image island_image;
    Image boat_island_image;

    private int currentShipIndex = 0; // Keep track of the current ship to move

    private String crashMessage = ""; // Variable to store crash message

    public void setCrashMessage(String message) {
        crashMessage = message;
    }

    public Panel()
    {
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setBackground(Color.WHITE);
        port = new Port(900, 500);
        singleShip = new Ship(20, 0, port); // Create a single ship instance


        for(int i = 0; i < number_ship; i++)
        {
            ships[i] = new Ship(20, i*50, port);
        }

//        startShipThreads();

        ship_image = new ImageIcon("C:\\Users\\kentn\\IdeaProjects\\DSA\\Assignment1\\Question_3\\images\\boat.png").getImage();
        island_image = new ImageIcon("C:\\Users\\kentn\\IdeaProjects\\DSA\\Assignment1\\Question_3\\images\\land.png").getImage();
        boat_island_image = new ImageIcon("C:\\Users\\kentn\\IdeaProjects\\DSA\\Assignment1\\Question_3\\images\\boat_land.png").getImage();

    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setFont(new Font("Monospaced", Font.BOLD, 20));
        
        
        for(int i = 0; i < ships.length; i++)
        {
            g.drawImage(ship_image, ships[i].x, ships[i].y, this);
        }

        g.drawImage(island_image, port.x, port.y, this);

        if (!crashMessage.isEmpty()) {
            g.setColor(Color.RED);
            g.drawString(crashMessage, 20, 20);
        }
    }

    public void onPositionUpdated() {
        repaint(); // Repaint the panel when ship position changes
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        System.out.println("\""+ke.getKeyChar()+"\" is typed.");


            for (Ship ship : ships) {
                if (port.isPathAvailable) {
                    ship.setCallback(this);
                    setCrashMessage("");
                    new Thread(ship).start();
                } else {
                    System.out.println("Port is busy!");
                }
            }
        repaint();
    }


    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {
       
    }
    
}
