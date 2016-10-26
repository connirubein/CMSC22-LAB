/**
 * Created by Conni on 10/21/2016.
 */
package Game8;
import Game7.Sound;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.lang.InterruptedException;

@SuppressWarnings("serial")
public class Game extends JPanel {

    Ball ball = new Ball(this);
    Racquet racquet = new Racquet(this,310);
    Racquet racquet2 = new Racquet(this,30);
    int speed = 1;

    public Game() {

        addKeyListener(new KeyListener() {
            @Override                           // instance of listener
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                racquet.keyReleased(e);         //if released
                racquet2.keyReleased(e);        //if released
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) racquet.xa = -speed;  //if left arrow is pressed, racquet to the left
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) racquet.xa = speed;  //if right arrow is pressed, racquet to the right
                if (e.getKeyCode() == KeyEvent.VK_A) racquet2.xa = -speed;    //if A is pressed, racquet2 moves to the left
                if (e.getKeyCode() == KeyEvent.VK_D) racquet2.xa = speed;     //if D, racquet2 moves to the left

                if(racquet.hasPowerUp()){               //when power up is enabled
                    if (e.getKeyCode() == KeyEvent.VK_S) {  //if player1 presses S, player 2 can't access the power up
                        racquet.setPowerUp(false);
                        racquet2.setPowerUp(false);
                        racquet.setUsedPowerUp(true);   //player1 used power up
                    }
                }

                if(racquet2.hasPowerUp()){
                    if (e.getKeyCode() == KeyEvent.VK_DOWN) {   //if player2 presses down, player1 can't access power up
                        racquet.setPowerUp(false);
                        racquet2.setPowerUp(false);
                        racquet2.setUsedPowerUp(true);  //player2 used power up
                    }
                }
            }
        });
        setFocusable(true);     //jpanel will receive alerts from keyboard events
        Sound.PLAY.loop();      //bg music
    }

    private void move() throws InterruptedException {
        ball.move();        //ball movement
        racquet.move();     //racquet movement
        racquet2.move();    //racquet2 movement
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);                 //cls
        Graphics2D g2d = (Graphics2D) g;    //Graphics2D: library  //g is type Graphics and is typecasted to Graphics2D
        g.setColor(Color.BLACK);    //bg
        g.fillRect(0, 0, 300, 380);     //bg rect
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2d);        //displays ball, racquet, and racquet2 with color
        if(racquet2.usedPowerUp()==false) {
            racquet2.paint(g2d);    //if commented out, object is still there but cannot be seen

        }

        if (racquet.usedPowerUp()==false) {
            racquet.paint(g2d);
        }

        g2d.setColor(Color.GRAY);   //font
        g2d.setFont(new Font("Verdana", Font.BOLD, 20));
        g2d.drawString(String.valueOf("Player 1: " + racquet.getScore()), 10, 30);  //display scores
        g2d.drawString(String.valueOf("Player 2: " + racquet2.getScore()), 10, 350);
        if(ball.getRacketContact()>5) { //if power up is enabled, this is displayed
            g2d.setFont(new Font("Verdana", Font.BOLD, 15));
            g2d.drawString(String.valueOf("Power Up!"), 30, 150);
            g2d.drawString(String.valueOf("Player 1 - Press S!"), 30, 170);
            g2d.drawString(String.valueOf("Player 2 - Press Arrow Down!"), 30, 190);
        }

    }

    public void gameOver(int x) throws InterruptedException {
        Sound.PLAY.stop();  //bg music stops
        Sound.GAMEOVER.play();      //fail music plays

        if(x==1) {
            JOptionPane.showMessageDialog(this,         //dialog window pops up for player 1 as the winner
                    "WINNER: PLAYER 1\n\nPLAYER 1: " + racquet.getScore() + " | PLAYER 2: " + racquet2.getScore(),
                    "GAME OVER", JOptionPane.YES_NO_OPTION);
        }

        else{
            JOptionPane.showMessageDialog(this,         //dialog window pops up for player 2 as the winner
                    "WINNER: PLAYER 2\n\nPLAYER 1: " + racquet.getScore() +" | PLAYER 2: " + racquet2.getScore(),
                    "GAME OVER", JOptionPane.YES_NO_OPTION);
        }

        if(JOptionPane.showConfirmDialog(this,"Play Again?","PONG!",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            newGame();     //if player/s chose yes, then the game would restart //else game terminates
        }

        else{
            System.exit(ABORT); //else: game will stop
        }
    }

    public static void newGame() throws InterruptedException {
        JFrame frame = new JFrame("Mini Tennis"); //new window "Mini Tennis"
        Game game = new Game();
        frame.add(game);
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//when "X" is clicked for closing the
                                                            // window of the game, the game will also stop running.
                                                            // without it, the game will continue to run even when the
                                                            // window is closed. unless, you stop the game (ctrl+F2)
        frame.setVisible(true); //set Mini Tennis as visible

        while (true) {
            game.move();
            game.repaint();
            Thread.sleep(20);	//pause/sleep for 10 milliseconds
        }
    }

    public static void main(String[] args) throws InterruptedException {
        newGame();
    }
}
