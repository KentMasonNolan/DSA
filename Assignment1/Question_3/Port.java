/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1.Question_3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author xhu
 */
public class Port {
    
    int x;
    int y;
    String name = "Port";

    private Lock portLock;

    boolean isPortAvailable = true;
    boolean isPathAvailable = true;

    public boolean isPathAvailable() {
        return isPathAvailable;
    }

    public void setPathAvailable(boolean pathAvailable) {
        isPathAvailable = pathAvailable;
    }

    public boolean isPortAvailable() {
        return isPortAvailable;
    }

    public void setPortAvailable(boolean portAvailable) {
        isPortAvailable = portAvailable;
    }

    public Port(int x, int y)
    {
        this.x = x;
        this.y = y;
        portLock = new ReentrantLock();

    }

    public boolean tryUsePort() {
        return portLock.tryLock(); // Attempt to acquire the lock
    }

    public void leavePort() {
        portLock.unlock(); // Release the lock
    }
}
