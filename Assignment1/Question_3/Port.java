/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1.Question_3;

/**
 *
 * @author xhu
 */
public class Port {
    
    int x;
    int y;
    String name = "Port";

    boolean isPortAvailable = true;

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

    }
}
