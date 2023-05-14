import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener{
    JLabel accountDetails, type, card ,cardNumber, cardDetail, cardInfo, pin, pinNumber, pinInfo, service;
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;

    Signup3(String formno){
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 25, 100, 100);
        add(image);

        accountDetails = new JLabel("Page 3: Additional Details");
        accountDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        accountDetails.setBounds(290, 80, 400, 30);
        add(accountDetails);

        type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100,140,200,30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(150,180,150,30);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(450,180,230,30);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(150,220,150,30);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(450,220,230,30);
        add(r4);

        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);
        groupgender.add(r3);
        groupgender.add(r4);

        card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 18));
        card.setBounds(100,300,200,30);
        add(card);

        cardNumber = new JLabel("XXXX-XXXX-XXXX-4184");
        cardNumber.setFont(new Font("Raleway", Font.BOLD, 18));
        cardNumber.setBounds(330,300,250,30);
        add(cardNumber);

        cardDetail = new JLabel("(Your 16-digit Card number)");
        cardDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        cardDetail.setBounds(100,330,200,20);
        add(cardDetail);

        cardInfo = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        cardInfo.setFont(new Font("Raleway", Font.BOLD, 12));
        cardInfo.setBounds(330,330,500,20);
        add(cardInfo);

        pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 18));
        pin.setBounds(100,370,200,30);
        add(pin);

        pinNumber = new JLabel("XXXX");
        pinNumber.setFont(new Font("Raleway", Font.BOLD, 18));
        pinNumber.setBounds(330,370,200,30);
        add(pinNumber);

        pinInfo = new JLabel("(4-digit password)");
        pinInfo.setFont(new Font("Raleway", Font.BOLD, 12));
        pinInfo.setBounds(100,400,200,20);
        add(pinInfo);

        service = new JLabel("Services Required:");
        service.setFont(new Font("Raleway", Font.BOLD, 18));
        service.setBounds(100,450,200,30);
        add(service);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100,500,150,30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350,500,150,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100,550,150,30);
        add(c3);

        c4 = new JCheckBox("EMAIL Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350,550,150,30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100,600,150,30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350,600,150,30);
        add(c6);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/provider.png"));
        Image ii2 = ii1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(550, 500, 150, 150);
        add(iimage);

        c7 = new JCheckBox("I hereby declares that all the above entered details are correct to the best of my knowledge.",true);
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100,680,550,20);
        add(c7);

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);



        getContentPane().setBackground(new Color(205,254,255));
        setSize(800,800);
        setLocation(350,10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String accountType = null;
        if(r1.isSelected()){
            accountType = "Saving Account";
        }
        else if(r2.isSelected()){
            accountType = "Fixed Deposit Account";
        }
        else if(r3.isSelected()){
            accountType = "Current Account";
        }else if(r4.isSelected()){
            accountType = "Recurring Deposit Account";
        }

        Random ran = new Random();
        long cardnumber = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String cardno = "" + Math.abs(cardnumber);

        long pinno = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(pinno);

        String facility = "";
        if(c1.isSelected()){
            facility = facility + " ATM Card";
        }
        if(c2.isSelected()){
            facility = facility + " Internet Banking";
        }
        if(c3.isSelected()){
            facility = facility + " Mobile Banking";
        }
        if(c4.isSelected()){
            facility = facility + " EMAIL Alerts";
        }
        if(c5.isSelected()){
            facility = facility + " Cheque Book";
        }
        if(c6.isSelected()){
            facility = facility + " E-Statement";
        }

        try{
            if(ae.getSource()==submit){

                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                }else{
                    Conn c1 = new Conn();
                    String q1 = "insert into signup3 values('"+formno+"','"+accountType+"','"+cardno+"','"+pin+"','"+facility+"')";
                    String q2 = "insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin:"+ pin);

                    new Deposit(pin).setVisible(true);
                    setVisible(false);


                }

            }else if(ae.getSource()==cancel){
                setVisible(false);
                new Login().setVisible(true);
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args){
        new Signup3("").setVisible(true);
    }
}
