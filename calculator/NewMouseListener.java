/**
 * Created by Conni on 10/30/2016.
 */

package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class NewMouseListener implements MouseListener {
    private JButton thisBtn;
    public NewMouseListener(JButton thisBtn, Color color) {
        this.thisBtn = thisBtn;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        //do nothing
    }

    @Override
    public void mousePressed(MouseEvent e) {

        //do nothing
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        //do nothing
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        thisBtn.setBackground(Color.GREEN);
    }

    @Override
    public void mouseExited(MouseEvent e) {

        thisBtn.setBackground(Color.ORANGE);
    }
}