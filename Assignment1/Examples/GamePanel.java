package Assignment1.Examples;

import javax.swing.Timer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.*;


public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 1000;
    static final int SCREEN_HEIGHT = 1000;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
    static final int DELAY = 175;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];

    int applesEaten;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean running = false;

    char currentLetter;
    char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int numberX;
    int numberY;
    int numberIndex;

    LinkedList<Character> eatenLetters = new LinkedList<>();

    List<GeneratedNumber> generatedNumbers = new ArrayList<GeneratedNumber>();


    int bodyParts = eatenLetters.size() +1;


    Timer timer;
    Random random;

    GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame() {
        newApple();
        currentLetter = letters[random.nextInt(letters.length)];
        newNumber();
        generateRandomNumbers();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);

        g.setColor(Color.red);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString(String.valueOf(currentLetter), appleX+5, appleY+20); // Adjust the position to center the letter

        for (GeneratedNumber generatedNumber : generatedNumbers) {
            g.drawString(String.valueOf(numbers[generatedNumber.number]), generatedNumber.posX + UNIT_SIZE /4, generatedNumber.posY + 20);
        }

    }

    private void generateRandomNumbers() {
        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(numbers.length);
            int numberPosX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
            int numberPosY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;

// Constrain the coordinates to stay within the visible grid
            numberPosX = Math.min(numberPosX, SCREEN_WIDTH - UNIT_SIZE);
            numberPosY = Math.min(numberPosY, SCREEN_HEIGHT - UNIT_SIZE);

            generatedNumbers.add(new GeneratedNumber(randomNumber, numberPosX, numberPosY));

        }
    }


    public void draw(Graphics g) {

        if (running) {

            for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
                g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
                g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
            }

            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 24)); //draws the letter on the board.
//            g.drawString(String.valueOf(currentLetter), 20, 40); // Adjust the position to center the letter


            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    g.setColor(Color.green);
                    g.setFont(new Font("Arial", Font.BOLD, 20));
                    g.drawString("@", x[i] + UNIT_SIZE / 4, y[i] + 20);
                } else {
                    // Draw the snake's body using the letters from the eatenLetters list
                    g.setColor(new Color(45, 180, 0));
                    if (i - 1 < eatenLetters.size()) { // Check if there's a corresponding letter
                        char bodyLetter = eatenLetters.get(i - 1);
                        g.setFont(new Font("Arial", Font.BOLD, 20));
                        g.drawString(String.valueOf(bodyLetter), x[i] + UNIT_SIZE / 4, y[i] + 20);
                    } else {
                        g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                    }
                }
            }
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 24));
            FontMetrics metrics = getFontMetrics(g.getFont());
//            g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + applesEaten)) / 2, g.getFont().getSize());
        } else {
            gameOver(g);
        }
    }


    public void newNumber() {
        numberIndex = random.nextInt(numbers.length); // Add this line
        numberX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        numberY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
    }


    public void newApple() {
        appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];



        }


        switch (direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }

    }

    public void checkApple() {
        if ((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            applesEaten++;
            eatenLetters.add(currentLetter);
            Collections.sort(eatenLetters);
            currentLetter = letters[random.nextInt(letters.length)]; // Generate a new random letter
            newApple();
        }
    }
    public void moveNumber() {
        numberIndex = random.nextInt(numbers.length);
        numberX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        numberY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
        generatedNumbers.add(new GeneratedNumber(numberIndex, numberX, numberY));
    }

    public void checkCollisions() {
        for (GeneratedNumber generatedNumber : generatedNumbers) {
            if ((x[0] == generatedNumber.posX) && (y[0] == generatedNumber.posY)) {
                int numberToRemove = generatedNumber.number;

                // Check if there are any letters to remove
                if (!eatenLetters.isEmpty()) {
                    // If the number to remove is greater than the number of eaten letters,
                    // remove the last letter
                    if (numberToRemove >= eatenLetters.size()) {
                        eatenLetters.removeLast();
                        bodyParts--;
                    } else {
                        // Remove the specified number of letters from the beginning
                        for (int i = 0; i < numberToRemove; i++) {
                            eatenLetters.removeFirst();
                            bodyParts--;
                        }
                    }
                    generatedNumbers.remove(generatedNumber); // Remove the collided number
                    moveNumber();
                } else {
                    // If no letters are eaten, it's game over
                    running = false;
                    timer.stop();
                }
                break; // Break the loop if collision is detected
            }
        }





        //checks if head collides with body
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
            }
        }
        //check if head touches left border
        if (x[0] < 0) {
            running = false;
        }
        //check if head touches right border
        if (x[0] > SCREEN_WIDTH) {
            running = false;
        }
        //check if head touches top border
        if (y[0] < 0) {
            running = false;
        }
        //check if head touches bottom border
        if (y[0] > SCREEN_HEIGHT) {
            running = false;
        }

        if (!running) {
            timer.stop();
        }
    }

    public void gameOver(Graphics g) {
        //Score
        g.setColor(Color.red);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: " + applesEaten)) / 2, g.getFont().getSize());
        //Game Over text
        g.setColor(Color.red);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') {
                        direction = 'D';
                    }
                    break;
            }
        }
    }
}
