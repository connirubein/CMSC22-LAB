/**
 * Created by Conni on 10/30/2016.
 */

package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class Calculator extends JFrame{
    private String ans = "";
    //all buttons
    private JPanel btnPad;
    //+,-,*,/,=
    private JButton addition, minus, times, divide, equals;
    //other buttons all clear, %, . , clear, (-)
    private JButton acButton, percent, decimal, cButton, nega;
    //all number buttons stored
    private JButton[] numBtns = JButton[10];
    //display
    private JTextArea result;
    //for the two numbers
    private BigDecimal[] numbers = new BigDecimal[2];
    //checker of operator //if true, use the operation
    private Boolean[] operation = new Boolean[4];

    private Font myFont = new Font("Calibri",Font.BOLD,20);

    Calculator(){
        //JTextArea result = new JTextArea();
        result = new JTextArea();
        result.setBackground(Color.WHITE);
        result.setPreferredSize(new Dimension(150,50));
        result.setFont(myFont);
        result.setEditable(false);      //text area can't be edited while the program is running
        result.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); //text starts from right sid eof text area
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(220,300);
        result.setText("0");
        //no operation used at beginning
        for (int i = 0; i<4; i++){
            operation[i] = false;
        }

        //button settings


        addition = new JButton("+");
            addition.setBackground(Color.ORANGE);
            addition.addMouseListener(new NewMouseListener(addition, Color.ORANGE));

        minus = new JButton("-");
            minus.setBackground(Color.ORANGE);
            minus.addMouseListener(new NewMouseListener(minus, Color.ORANGE));

        times = new JButton("x");
            times.setBackground(Color.ORANGE);
            times.addMouseListener(new NewMouseListener(times, Color.ORANGE));

        divide = new JButton("/");
            divide.setBackground(Color.ORANGE);
            divide.addMouseListener(new NewMouseListener(divide, Color.ORANGE));

        equals = new JButton("=");
            equals.setBackground(Color.ORANGE);
            equals.addMouseListener(new NewMouseListener(equals, Color.ORANGE));

        acButton = new JButton("AC");
            acButton.setBackground(Color.ORANGE);
            acButton.addMouseListener(new NewMouseListener(acButton, Color.WHITE));

        percent = new JButton("%");
            percent.setBackground(Color.ORANGE);
            percent.addMouseListener(new NewMouseListener(percent, Color.WHITE));

        decimal = new JButton(".");
            decimal.setBackground(Color.ORANGE);
            decimal.addMouseListener(new NewMouseListener(decimal, Color.WHITE));

        cButton = new JButton("C");
            cButton.setBackground(Color.ORANGE);
            cButton.addMouseListener(new NewMouseListener(cButton, Color.WHITE));

        nega = new JButton("(-)");
            nega.setBackground(Color.ORANGE);
            nega.addMouseListener(new NewMouseListener(nega, Color.WHITE));

        btnPad = new JPanel();

        for(int i = 0; i<10; i++){
            numBtns[i] = new JButton(String.valueOf(i));
            numBtns[i].setBackground(Color.LIGHT_GRAY);
        }

        //for the two numbers
        for(int i=0;i<2; i++){
            numbers[i] = BigDecimal.valueOf(0);
        }

        btnPad.setLayout(new GridLayout(5,4));

        btnPad.add(acButton);	btnPad.add(cButton);	btnPad.add(nega);	btnPad.add(divide);
        btnPad.add(numBtns[7]);	btnPad.add(numBtns[8]);	btnPad.add(numBtns[9]);	btnPad.add(times);
        btnPad.add(numBtns[4]);	btnPad.add(numBtns[5]);	btnPad.add(numBtns[6]);	btnPad.add(minus);
        btnPad.add(numBtns[1]);	btnPad.add(numBtns[2]);	btnPad.add(numBtns[3]);	btnPad.add(addition);
        btnPad.add(numBtns[0]);	btnPad.add(percent);    btnPad.add(decimal);	btnPad.add(equals);
        setVisible(true);
        add(btnPad, BorderLayout.CENTER);
        add(result, BorderLayout.NORTH);


        numBtns[0].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == numBtns[0]) {
                    result.append("0");
                }
            }
        });

        numBtns[1].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == numBtns[1]) {
                    result.append("1");
                }
            }
        });

        numBtns[2].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == numBtns[2]) {
                    result.append("2");
                }
            }
        });

        numBtns[3].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == numBtns[3]) {
                    result.append("3");
                }
            }
        });

        numBtns[4].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == numBtns[4]) {
                    result.append("4");
                }
            }
        });

        numBtns[5].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == numBtns[5]) {
                    result.append("5");
                }
            }
        });

        numBtns[6].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == numBtns[6]) {
                    result.append("6");
                }
            }
        });

        numBtns[7].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == numBtns[7]) {
                    result.append("7");
                }
            }
        });

        numBtns[8].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == numBtns[8]) {
                    result.append("8");
                }
            }
        });

        numBtns[9].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == numBtns[9]) {
                    result.append("9");
                }
            }
        });

        acButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == acButton) {
                    result.setText("");
                }
            }
        });

        cButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == cButton) {
                    String forClear = result.getText();
                    String forClearing  = "";
                    for(int i = 0; i < forClear.length() - 1; i++){
                        forClearing += forClear.charAt(i);
                    }
                    result.setText(forClearing);
                }
            }
        });

        addition.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == addition){
                    ans = result.getText();
                    BigDecimal bd = new BigDecimal(ans);
                    numbers[0] = bd;
                    operation[0] = true;
                    result.setText("");
                }
            }
        });

        minus.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == minus){
                    ans = result.getText();
                    BigDecimal bd = new BigDecimal(ans);
                    numbers[0] = bd;
                    operation[1] = true;
                    result.setText("");
                }
            }
        });

        times.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == times){
                    ans = result.getText();
                    BigDecimal bd = new BigDecimal(ans);
                    numbers[0] = bd;
                    operation[2] = true;
                    result.setText("");
                }
            }
        });

        divide.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == divide){
                    ans = result.getText();
                    BigDecimal bd = new BigDecimal(ans);
                    numbers[0] = bd;
                    operation[3] = true;
                    result.setText("");
                }
            }
        });

        percent.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == percent){
                    ans = result.getText();
                    BigDecimal bd = new BigDecimal(ans);
                    numbers[0] = bd;
                    result.setText(""+bd.divide(BigDecimal.valueOf(100)) );
                }
            }
        });

        equals.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == equals) {
                    getResult();
                }
            }
        });

        nega.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == nega) {
                    result.append("-");
                }
            }
        });

        decimal.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == decimal) {
                    result.append(".");
                }
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }


    public void getResult(){
        //initialize ans
        BigDecimal ans = BigDecimal.valueOf(0);

        if ((result.getText()).contains("-")){
            String other = (result.getText()).replaceAll("-","");
            numbers[1] = (new BigDecimal(other)).multiply(BigDecimal.valueOf(-1));
        }
        else{
            numbers[1] = new BigDecimal(result.getText());
        }

        if(operation[0]){
            ans = numbers[0].add(numbers[1]);
        }

        if(operation[1]){
            ans = numbers[0].subtract(numbers[1]);
        }

        if(operation[2]){
            ans = numbers[0].multiply(numbers[1]);
        }

        if(operation[3]){
            ans = numbers[0].divide(numbers[1],5,BigDecimal.ROUND_HALF_UP);
        }

        result.setText(""+ans);
        //reset
        for(int i = 0; i<4; i++){
            operation[i] = false;
        }
    }

    public static void main(String args[]){
        new Calculator();
    }

}
