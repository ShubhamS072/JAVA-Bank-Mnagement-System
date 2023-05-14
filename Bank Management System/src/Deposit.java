import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class Deposit extends JFrame implements ActionListener{
    JTextField enterAmountTextField;
    JButton deposit,back;
    JLabel enterAmount;
    String pinNumber;
    Deposit(String pinNumber){
        this.pinNumber = pinNumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);


        enterAmount = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        enterAmount.setForeground(Color.WHITE);
        enterAmount.setFont(new Font("System", Font.BOLD, 16));
        enterAmount.setBounds(170,300,400,20);
        image.add(enterAmount);

        enterAmountTextField = new JTextField();
        enterAmountTextField.setFont(new Font("Raleway", Font.BOLD, 22));
        enterAmountTextField.setBounds(170,350,320,25);
        image.add(enterAmountTextField);

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(355,485,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);


        setLayout(null);



        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            String amount = enterAmountTextField.getText();
            Date date = new Date();
            if(ae.getSource()==deposit){
                if(enterAmountTextField.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }else{
                    Conn c1 = new Conn();
                    c1.s.executeUpdate("insert into bank values('"+pinNumber+"', '"+date+"', 'Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
            }else if(ae.getSource()==back){
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }


    public static void main(String[] args){
        new Deposit("").setVisible(true);
    }
}
