import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton signInButton, clearButton, signUpButton;
    JLabel cardNo, pin;
    JTextField cardNoTextField;
    JPasswordField pinPasswordField;

    Login(){
        setLayout(null);

        setTitle("AUTOMATED TELLER MACHINE (ATM)"); // title for frame

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel ilabel = new JLabel(i3);
        ilabel.setBounds(70, 10, 100, 100);
        add(ilabel);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iilabel = new JLabel(ii3);
        iilabel.setBounds(650, 350, 100, 100);
        add(iilabel);

        JLabel l1 = new JLabel("WELCOME TO ATM");
        l1.setFont(new Font("Times New Roman", Font.BOLD, 38));
        l1.setBounds(250,40,450,40);
        add(l1);

        cardNo = new JLabel("CARD NUMBER : ");
        cardNo.setFont(new Font("Arial", Font.BOLD, 28));
        cardNo.setBounds(100,150,375,30);
        add(cardNo);

        cardNoTextField = new JTextField(15);
        cardNoTextField.setBounds(370,150,230,30);
        cardNoTextField.setFont(new Font("Arial", Font.BOLD, 16));
        add(cardNoTextField);

        pin= new JLabel("ENTER PIN : ");
        pin.setFont(new Font("Arial", Font.BOLD, 28));
        pin.setBounds(100,220,375,30);
        add(pin);

        pinPasswordField = new JPasswordField(15);
        pinPasswordField.setFont(new Font("Arial", Font.BOLD, 16));
        pinPasswordField.setBounds(370,220,230,30);
        add(pinPasswordField);


        signInButton = new JButton("SIGN IN");
        signInButton.setBounds(370,300, 100, 30);
        signInButton.setBackground(Color.BLACK);
        signInButton.setForeground(Color.WHITE);
        add(signInButton);
        signInButton.addActionListener(this);

        clearButton = new JButton("CLEAR");
        clearButton.setBounds(500,300, 100, 30);
        clearButton.setBackground(Color.BLACK);
        clearButton.setForeground(Color.WHITE);
        add(clearButton);
        clearButton.addActionListener(this);

        signUpButton = new JButton("SIGN UP");
        signUpButton.setBounds(370,350, 230, 30);
        signUpButton.setBackground(Color.BLACK);
        signUpButton.setForeground(Color.WHITE);
        add(signUpButton);
        signUpButton.addActionListener(this);


        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image iii2 = iii1.getImage().getScaledInstance(800, 480, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiilabel = new JLabel(iii3);
        iiilabel.setBounds(0, 0, 800, 480);
        add(iiilabel);

        setSize(800, 480);
        setVisible(true);
        setLocation(350,200);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clearButton){
            cardNoTextField.setText("");
            pinPasswordField.setText("");
        }else if (ae.getSource() == signInButton){
            Conn conn = new Conn();
            String cardNumber = cardNoTextField.getText();
            String pinNumber = pinPasswordField.getText();
            String query = "select * from login where cardno = '"+cardNumber+"' and pin = '"+pinNumber+"'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card No. or PIN");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        } else if (ae.getSource() == signUpButton){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }


    public static void main(String[] args) {
        new Login();
    }
}
