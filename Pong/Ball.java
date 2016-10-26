/**
 * Created by Conni on 10/21/2016.
 */package Game8;

import java.awt.*;

public class Ball {
    private static final int DIAMETER = 30;

    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;
    private Game game;
    private int racketContact = 0;      //for power ups; counts the number of collisions (ball vs racquet)

    public Ball(Game game) {
        this.game = game;
    }

    void move() throws InterruptedException{
        boolean changeDirection = true;

        if (x + xa < 0)
            xa = game.speed;
        else if (x + xa > game.getWidth() - DIAMETER)
            xa = -game.speed;
        else if ((y + ya > game.getHeight() - DIAMETER)){
            setRacketContact();     //if a player scores, racketContact resets to 0
            game.racquet.setScore();
            Sound.LUSOT.play();
            game.racquet.setUsedPowerUp(false);     //since the racketContact counter is 0, possession of power up
                                                    //for both players is now 0
            game.racquet2.setUsedPowerUp(false);
            game.speed++;
            x = 150;
            y = 200;
        }
        else if (y+ya<0){
            setRacketContact();
            game.racquet2.setScore();
            game.racquet.setUsedPowerUp(false);
            game.racquet2.setUsedPowerUp(false);
            game.speed++;
            x = 150;
            y = 200;
        }
        else if (collision(game.racquet)){
            //if ball collides with racquet
            racketContact++;
            ya = -game.speed;
            y = game.racquet.getTopY() - DIAMETER;
            game.speed++;
        }
        else if (collision(game.racquet2)){
            //if ball collides with racquet2
            racketContact++;
            ya = game.speed;
            y = game.racquet2.getTopY() + DIAMETER;
            game.speed++;
        }
        else
            changeDirection = false;

        if(racketContact == 6){     //if counter is 6, power up is enabled
            game.racquet.setPowerUp(true);
            game.racquet2.setPowerUp(true);
        }

        if (changeDirection)
            Sound.BALL.play();
        x = x + xa;
        y = y + ya;
        //if player1 scores to 3pts first, gameOver will call it out as the winner
        if(game.racquet.getScore() == 3){
            game.gameOver(1);
        }
        else if(game.racquet2.getScore() == 3){
            //same goes if player2 gets 3pts first
            game.gameOver(2);
        }
    }

    private boolean collision(Racquet rac) {    //if they collided, return true
        return rac.getBounds().intersects(getBounds());
    }

    public void paint(Graphics2D g) {  //ball specs: color, size, and then filling
        g.setColor(Color.WHITE);
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    public Rectangle getBounds() {  //return ball boundaries
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }

    public void setRacketContact(){     //reset racketcontact counter to  0
        racketContact = 0;
    }

    public int getRacketContact(){      //for those who don't have access outside class Ball
        return racketContact;
    }
}