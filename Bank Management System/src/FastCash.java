import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener{

    JLabel text;
    JButton C, D, M,MM ,V_M,X_M,back;
    String pinNumber;
    FastCash(String pinNumber){
        setLayout(null);
        this.pinNumber = pinNumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(235,300,700,35);
        image.add(text);

        C = new JButton("₹ 100");
        C.setBounds(170,415,150,30);
        C.addActionListener(this);
        image.add(C);


        D = new JButton("₹ 500");
        D.setBounds(355,415,150,30);
        D.addActionListener(this);
        image.add(D);

        M = new JButton("₹ 1000");
        M.setBounds(170,450,150,30);
        M.addActionListener(this);
        image.add(M);

        MM = new JButton("₹ 2000");
        MM.setBounds(355,450,150,30);
        MM.addActionListener(this);
        image.add(MM);

        V_M = new JButton("₹ 5000");
        V_M.setBounds(170,485,150,30);
        V_M.addActionListener(this);
        image.add(V_M);

        X_M = new JButton("₹ 10000");
        X_M.setBounds(355,485,150,30);
        X_M.addActionListener(this);
        image.add(X_M);

        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);


        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        try {
            String amount = ((JButton)ae.getSource()).getText().substring(2);
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }

            if (ae.getSource() == back) {
                this.setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }else{
                Date date = new Date();
                c.s.executeUpdate("insert into bank values('"+pinNumber+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "₹ "+amount+" Debited Successfully");

                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args){
        new Transactions("").setVisible(true);
    }
}
