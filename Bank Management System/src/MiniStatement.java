import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{
    JButton exit;
    JLabel text, bankName, card, finalBalance;
    String pinNumber;
    MiniStatement(String pinNumber){
        this.pinNumber = pinNumber;

        setTitle("Mini Statement");
        setLayout(null);


        text = new JLabel();
        text.setBounds(20, 140, 400, 200);
        add(text);

        bankName = new JLabel("Indian Bank");
        bankName.setBounds(150, 20, 100, 20);
        add(bankName);

        card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        finalBalance = new JLabel();
        finalBalance.setBounds(20, 400, 300, 20);
        add(finalBalance);

        exit = new JButton("Exit");
        exit.addActionListener(this);
        exit.setBounds(20, 500, 100, 25);
        add(exit);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pinNumber+"'");
            while(rs.next()){
                card.setText("Card Number:    " + rs.getString("cardno").substring(0, 4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }

        try{
            int balance = 0;
            Conn c1  = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '"+pinNumber+"'");
            while(rs.next()){
                text.setText(text.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            finalBalance.setText("Your total Balance is ₹ "+balance);
        }catch(Exception e){
            e.printStackTrace();
        }



        getContentPane().setBackground(Color.PINK);
        setSize(400,600);
        setLocation(20,20);
        setVisible(true);



    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }

    public static void main(String[] args){
        new MiniStatement("").setVisible(true);
    }
}
