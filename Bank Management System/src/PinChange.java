import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class PinChange extends JFrame implements ActionListener{
    JLabel text, pinText, repinText;
    JPasswordField pinPasswordField,repinPasswordField;
    JButton change,back;

    String pinNumber;
    PinChange(String pinNumber){
        this.pinNumber= pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        text = new JLabel("CHANGE YOUR PIN");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(250,280,500,35);
        image.add(text);

        pinText = new JLabel("NEW PIN");
        pinText.setFont(new Font("System", Font.BOLD, 16));
        pinText.setForeground(Color.WHITE);
        pinText.setBounds(165,320,180,30);
        image.add(pinText);

        pinPasswordField =new JPasswordField();
        pinPasswordField.setFont(new Font("Raleway", Font.BOLD, 25));
        pinPasswordField.setBounds(330, 320, 180, 25);
        image.add(pinPasswordField);

        repinText = new JLabel("RE-ENTER PIN");
        repinText.setFont(new Font("System", Font.BOLD, 16));
        repinText.setForeground(Color.WHITE);
        repinText.setBounds(165,370,180,30);
        image.add(repinText);

        repinPasswordField =new JPasswordField();
        repinPasswordField.setFont(new Font("Raleway", Font.BOLD, 25));
        repinPasswordField.setBounds(330, 370, 180, 25);
        image.add(repinPasswordField);

        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);


        back = new JButton("BACK");
        back.setBounds(355,520,150,35);
        back.addActionListener(this);
        image.add(back);


        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String npin = pinPasswordField.getText();
        String rpin = repinPasswordField.getText();
        if (ae.getSource() == change) {
            try {
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                    return;
                }
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                    return;
                }

                Conn c1 = new Conn();
                String q1 = "update bank set pin = '" + rpin + "' where pin = '" + pinNumber + "' ";
                String q2 = "update login set pin = '" + rpin + "' where pin = '" + pinNumber + "' ";
                String q3 = "update signup3 set pin = '" + rpin + "' where pin = '" + pinNumber + "' ";

                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                c1.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");

                setVisible(false);
                new Transactions(rpin).setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }



    public static void main(String[] args){
        new PinChange("").setVisible(true);
    }
}
