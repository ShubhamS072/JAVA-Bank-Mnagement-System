import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Signup2 extends JFrame implements ActionListener{
    JTextField panTextField, aadharTextField;
    JButton next;
    JRadioButton yes, no, yess, noo;
    JComboBox religionTextField, categoryTextField, incomeTextField, educationTextField, occuationTextField;
    String formno;

    Signup2(String formno){
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 25, 100, 100);
        add(image);

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion : ");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 100,30);
        add(religion);

        String religionVal[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religionTextField = new JComboBox(religionVal);
        religionTextField.setBackground(Color.WHITE);
        religionTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        religionTextField.setBounds(350, 140, 400, 30);
        add(religionTextField);


        JLabel category = new JLabel("Category : ");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200,30);
        add(category);

        String categoryVal[] = {"General","OBC","SC","ST","Other"};
        categoryTextField = new JComboBox(categoryVal);
        categoryTextField.setBackground(Color.WHITE);
        categoryTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        categoryTextField.setBounds(350, 190, 400, 30);
        add(categoryTextField);

        JLabel income = new JLabel("Income : ");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200,30);
        add(income);

        String incomeVal[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        incomeTextField = new JComboBox(incomeVal);
        incomeTextField.setBackground(Color.WHITE);
        incomeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        incomeTextField.setBounds(350, 240, 400,30);
        add(incomeTextField);

        JLabel educationalQalification = new JLabel("Educational Qualification: ");
        educationalQalification.setFont(new Font("Raleway", Font.BOLD, 20));
        educationalQalification.setBounds(100, 290, 200,30);
        add(educationalQalification);

        String educationVal[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        educationTextField = new JComboBox(educationVal);
        educationTextField.setBackground(Color.WHITE);
        educationTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        educationTextField.setBounds(350, 290, 400,30);
        add(educationTextField);

        JLabel occupation = new JLabel("Occupation : ");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 390, 200,30);
        add(occupation);

        String occupationVal[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        occuationTextField = new JComboBox(occupationVal);
        occuationTextField.setBackground(Color.WHITE);
        occuationTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        occuationTextField.setBounds(350, 390, 400,30);
        add(occuationTextField);

        JLabel pan = new JLabel("PAN number : ");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 440, 200,30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(350, 440, 400, 30);
        add(panTextField);

        JLabel aadhar = new JLabel("Aadhar Number : ");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 490, 200,30);
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(350, 490, 400, 30);
        add(aadharTextField);

        JLabel seniorCitizen = new JLabel("Senior Citizen : ");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizen.setBounds(100, 540, 200,30);
        add(seniorCitizen);

        yes = new JRadioButton("Yes");
        yes.setBounds(350, 540, 100, 30);
        yes.setBackground(Color.WHITE);
        add(yes);

        no = new JRadioButton("No");
        no.setBounds(500, 540, 100, 30);
        no.setBackground(Color.WHITE);
        add(no);

        ButtonGroup groupstatus = new ButtonGroup();
        groupstatus.add(yes);
        groupstatus.add(no);

        JLabel existingAccount = new JLabel("Existing Account : ");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        existingAccount.setBounds(100, 590, 200,30);
        add(existingAccount);

        yess = new JRadioButton("Yes");
        yess.setBounds(350, 590, 100, 30);
        yess.setBackground(Color.WHITE);
        add(yess);

        noo = new JRadioButton("No");
        noo.setBounds(500, 590, 100, 30);
        noo.setBackground(Color.WHITE);
        add(noo);

        ButtonGroup groupstatus2 = new ButtonGroup();
        groupstatus2.add(yess);
        groupstatus2.add(noo);

        next = new JButton("NEXT");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(650,660,100,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(new Color(255, 204, 153));
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        String religion = (String)religionTextField.getSelectedItem();
        String category = (String)categoryTextField.getSelectedItem();
        String income = (String)incomeTextField.getSelectedItem();
        String education = (String)educationTextField.getSelectedItem();
        String occupation = (String)occuationTextField.getSelectedItem();

        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();

        String seniorCitizen = null;
        if(yes.isSelected()){
            seniorCitizen = "Yes";
        }
        else if(no.isSelected()){
            seniorCitizen = "No";
        }

        String existingAccount = null;
        if(yess.isSelected()){
            existingAccount = "Yes";
        }else if(noo.isSelected()){
            existingAccount = "No";
        }

        try{
            if(panTextField.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }else{
                Conn c1 = new Conn();
                String q1 = "insert into signup2 values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+seniorCitizen+"','"+existingAccount+"')";
                c1.s.executeUpdate(q1);
            }

            setVisible(false);
            new Signup3(formno).setVisible(true);

        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {

        new Signup2("").setVisible(true);
    }
}
