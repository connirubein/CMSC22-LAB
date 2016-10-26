/**
 * Created by Conni on 10/21/2016.
 */
package Game8;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Racquet {
    private int Y;
    private static final int WITH = 60;
    private static final int HEIGHT = 10;
    private int score = 0;
    private Game game;
    private boolean powerUp = false;
    private boolean useOfPowerUp = false;
    int x=0;
    int xa = 0;

    public Racquet(Game game, int Y) {      //parameter int Y was added bc rackets are placed at different
                                            //lengths/heights on the window during the game
        this.game = game;
        this.Y = Y;
    }

    public void move() {        //the left and right movement of the rackets
        if (x + xa > 0 && x + xa < game.getWidth() - WITH)
            x = x + xa;
    }

    public void paint(Graphics2D g) {       //racket specs: color, without fill
        g.setColor(Color.WHITE);
        g.drawRect(x,Y,WITH, HEIGHT);
    }

    public void keyReleased(KeyEvent e) {
        xa = 0;
    }

    public Rectangle getBounds() {      //returns rect boundaries
        return new Rectangle(x, Y, WITH, HEIGHT);
    }

    public int getTopY() {

        return Y - HEIGHT;
    }

    public int getScore() {     //bc score is private
        return score;
    }

    public void setScore() {   //increment score by 1 for points;
        score+=1;
    }

    public boolean hasPowerUp(){        //if power up is enabled
        return powerUp;
    }

    public void setPowerUp(boolean bool){       //when racketContact is 6, powerUp = true
        powerUp = bool;                         //when someone scores, or racketCounter is set to 0, powerUp = false
        if(bool == false){
            game.ball.setRacketContact();
        }
    }

    public void setUsedPowerUp(boolean bool){       //after the player used the power up, this is then set to false
        useOfPowerUp = bool;
    }

    public boolean usedPowerUp(){       //state of player if they used power up
        return useOfPowerUp;
    }

}

