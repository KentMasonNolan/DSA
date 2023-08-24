/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
Which object have you chosen as a monitor object to synchronize your code?



Why did you choose that object as a monitor oject to synchronize your code?


*/

package Assignment1.Question_3;

/**
 *
 * @author xhu
 */
public class Ship implements Runnable{
    public boolean hasReachedPort;
    int x;
    int y;
    private Port port;

    final int originalX = 20;

    String name = "Ship";
    
    public Ship(int x, int y, Port port)
    {
        this.x = x;
        this.y = y;
        this.port = port;
    }

    private ShipPositionCallback callback;

    public void setCallback(ShipPositionCallback callback) {
        this.callback = callback;
    }


    public void moveTowardsPort(Port port) {

        while (x < port.x) {
            port.setPathAvailable(false);
            x += 1;
            callback.onPositionUpdated(); // Update the panel to show ship movement
            try {
                Thread.sleep(5); // Introduce a delay to control ship speed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Ship reached the port's x position, wait and return
        try {
            if (port.isPortAvailable){
                port.setPortAvailable(false);
                hasReachedPort = true;
                Thread.sleep(1000); // Wait for 1 second
                port.setPortAvailable(true);
                hasReachedPort = false;
            } else {
                callback.setCrashMessage("CRASH!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Return movement
        while (x > originalX) {
            x -= 1; // Adjust the step size based on your preference
            callback.onPositionUpdated();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        port.setPathAvailable(true);
    }

    public void moveTowardsPortSynchronized() {
        synchronized (port) {
            moveTowardsPort(port);
        }
    }

    @Override
    public void run() {
            moveTowardsPort(port);
        }

    public void moveTowardsPort() {
        moveTowardsPort(port);
    }
}
