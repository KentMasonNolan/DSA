/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1.Question_33;

import javax.swing.JFrame;

/*
The chosen monitor object is the Port object. It's used to synchronize ship actions due 
to its role as a shared resource. The ships coordinate access to port availability and island path,
preventing concurrent conflicts and ensuring code consistency.
*/

public class ShipDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame("Java Paint");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel panel = new Panel();
        
        frame.getContentPane().add(panel);
        frame.setSize(1000, 1050);
        frame.setVisible(true);
    }
    
}
