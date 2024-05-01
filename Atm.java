import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Atm extends JFrame implements ActionListener{

    int PASSWORD = 1234; //default password

    JFrame frame;
    JPanel backPanel, panel1, panel2, panel3, panel4, panel5, panel6, panel7, resPanel;
    JLabel error, chlang1, chlang2, epass, enewpass, report, eCash, eaccountNum, result;
    JButton lang1, lang2, passConfirm, newpassConfirm, transferConfirm;
    JButton passChange, takeCash, getReport, transferCash, back;
    JButton num1, num2, num3, num4;
    JPasswordField pass, newpass;
    JTextField transferedCash, accountNum;
    char Language;
    long balance = 56350000;

    Atm()
    {
        frame = new JFrame("ATM");
        Dimension frameSize = new Dimension(800,600);
        frame.setSize(frameSize);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        Color Lightblue = new Color (173, 223, 255);
        Color Mgreen = new Color(57, 173, 72);
        Font font = new Font("Serif", Font.PLAIN, 24);
        Font font1 = new Font("Sans Serif", Font.BOLD, 26);


        ////////////// Language panel //////////////

        panel1 = new JPanel();
        panel1.setBackground(Lightblue);
        panel1.setBounds(0,0,800,600);

        panel1.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        lang1 = new JButton("English");
        lang1.addActionListener(this);
        lang1.setFont(font);
        constraints.weightx = 3;
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel1.add(lang1,constraints);

        chlang1 = new JLabel("Choose Language");
        chlang1.setFont(font);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel1.add(chlang1,constraints);

        chlang2 = new JLabel("زبان خود را انتخاب کنید");
        chlang2.setFont(font);
        constraints.gridx = 2;
        constraints.gridy = 0;
        panel1.add(chlang2,constraints);

        lang2 = new JButton("فارسی");
        lang2.addActionListener(this);
        lang2.setFont(font);
        constraints.gridx = 3;
        constraints.gridy = 0;
        panel1.add(lang2,constraints);


        /////////////////// Password panel ///////////////////

        panel2 = new JPanel();
        panel2.setBackground(Lightblue);
        panel2.setBounds(0,0,800,600);
        panel2.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();

        epass = new JLabel("رمز خود را وارد کنید: *");
        constraints.insets = new Insets(20, 0, 20, 0);
        epass.setFont(font1);
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel2.add(epass,constraints);

        pass = new JPasswordField();
        pass.setPreferredSize(new Dimension(240,40));
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel2.add(pass,constraints);

        passConfirm = new JButton("ثبت");
        passConfirm.addActionListener(this);
        passConfirm.setFont(font1);
        passConfirm.setForeground(Mgreen);
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel2.add(passConfirm,constraints);

        error = new JLabel("");
        constraints.insets = new Insets(20, 0, 20, 0);
        error.setFont(font);
        error.setForeground(Color.red);
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel2.add(error,constraints);


        /////////////////// Back panel ///////////////////

        backPanel = new JPanel();
        backPanel.setBackground(new Color(0,0,0));
        backPanel.setOpaque(false);
        backPanel.setBounds(0,0,800,600);
        backPanel.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();

        back = new JButton("بازگشت");
        back.setFont(font);
        back.setForeground(Color.GRAY);
        back.addActionListener(this);
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.insets = new Insets(400,0,0,0);
        constraints.gridx = 0;
        constraints.gridy = 3;
        backPanel.add(back,constraints);


        /////////////////// Main panel ///////////////////

        panel3 = new JPanel();
        panel3.setBackground(Lightblue);
        panel3.setBounds(0,0,800,600);
        panel3.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();

        takeCash = new JButton("برداشت وجه");
        takeCash.addActionListener(this);
        takeCash.setFont(font);
        constraints.insets = new Insets(20, 200, 20, 200);
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel3.add(takeCash,constraints);

        passChange = new JButton("تغییر رمز");
        passChange.addActionListener(this);
        passChange.setFont(font);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel3.add(passChange,constraints);

        transferCash = new JButton("کارت به کارت");
        transferCash.addActionListener(this);
        transferCash.setFont(font);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel3.add(transferCash,constraints);

        getReport = new JButton("اعلام موجودی");
        getReport.addActionListener(this);
        getReport.setFont(font);
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel3.add(getReport,constraints);


        /////////////////// Result panel ///////////////////

        resPanel = new JPanel();
        resPanel.setBackground(Lightblue);
        resPanel.setBounds(0,0,800,600);
        resPanel.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();

        result = new JLabel("عملیات با موفقیت انجام شد!");
        result.setFont(font1);
        result.setForeground(Mgreen);
        resPanel.add(result, constraints);

        panel4 = new JPanel();
        panel4.setBackground(Lightblue);
        panel4.setBounds(0,0,800,600);
        panel4.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();


        /////////////////// Password Change panel ///////////////////

        enewpass = new JLabel("رمز جدید را وارد کنید: *");
        constraints.insets = new Insets(20, 0, 20, 0);
        enewpass.setFont(font1);
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel4.add(enewpass,constraints);

        newpass = new JPasswordField();
        newpass.setPreferredSize(new Dimension(240,40));
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel4.add(newpass,constraints);

        newpassConfirm = new JButton("تایید");
        newpassConfirm.addActionListener(this);
        newpassConfirm.setFont(font1);
        newpassConfirm.setForeground(Mgreen);
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel4.add(newpassConfirm,constraints);


        /////////////////// Report panel ///////////////////

        panel5 = new JPanel();
        panel5.setBackground(Lightblue);
        panel5.setBounds(0,0,800,600);
        panel5.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();

        report = new JLabel("موجودی حساب شما:" + balance + "ریال");
        report.setFont(font1);
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel5.add(report, constraints);


        /////////////////// Take Cash panel ///////////////////

        panel6 = new JPanel();
        panel6.setBackground(Lightblue);
        panel6.setBounds(0,0,800,600);
        panel6.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();

        num1 = new JButton("500000");
        num1.setFont(font);
        num1.addActionListener(this);
        constraints.insets = new Insets(20, 200, 20, 200);
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel6.add(num1,constraints);

        num2 = new JButton("1500000");
        num2.addActionListener(this);
        num2.setFont(font);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel6.add(num2,constraints);

        num3 = new JButton("1000000");
        num3.addActionListener(this);
        num3.setFont(font);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel6.add(num3,constraints);

        num4 = new JButton("2000000");
        num4.addActionListener(this);
        num4.setFont(font);
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel6.add(num4,constraints);


        /////////////////// Transfer Cash panel ///////////////////

        panel7 = new JPanel();
        panel7.setBackground(Lightblue);
        panel7.setBounds(0,0,800,600);
        panel7.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();

        eCash = new JLabel("مبلغ مورد نظر را وارد کنید: *");
        constraints.insets = new Insets(20, 0, 20, 0);
        eCash.setFont(font1);
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel7.add(eCash,constraints);

        transferedCash = new JTextField();
        transferedCash.setPreferredSize(new Dimension(240,40));
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel7.add(transferedCash,constraints);

        eaccountNum = new JLabel("شماره کارت مقصد را وارد کنید:");
        constraints.insets = new Insets(20, 0, 20, 0);
        eaccountNum.setFont(font1);
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel7.add(eaccountNum,constraints);

        accountNum = new JTextField();
        accountNum.setPreferredSize(new Dimension(240,40));
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel7.add(accountNum,constraints);

        transferConfirm = new JButton("ثبت");
        transferConfirm.addActionListener(this);
        transferConfirm.setFont(font1);
        transferConfirm.setForeground(Mgreen);
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel7.add(transferConfirm,constraints);

        frame.add(panel1);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Atm atm = new Atm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == lang2){
            frame.remove(panel1);
            frame.add(panel2);
            frame.revalidate();
            frame.repaint();
        }

        if (e.getSource() == passConfirm){

            if (Integer.parseInt(String.valueOf(pass.getPassword())) != PASSWORD)
                error.setText ("رمز اشتباه است (پیش‌فرض: ۱۲۳۴)");

            else{
            pass.setText("");
            error.setText("");
            frame.remove(panel2);
            frame.add(backPanel);
            frame.add(panel3);
            frame.revalidate();
            frame.repaint();
            }
        }

        if (e.getSource() == back){

            newpass.setText("");
            transferedCash.setText("");
            accountNum.setText("");

            frame.remove(panel3);
            frame.remove(panel4);
            frame.remove(panel5);
            frame.remove(panel6);
            frame.remove(panel7);
            frame.remove(resPanel);
            frame.remove(backPanel);
            frame.add(panel1);
            frame.revalidate();
            frame.repaint();
        }

        if (e.getSource() == passChange){
            frame.remove(panel3);
            frame.add(backPanel);
            frame.add(panel4);
            frame.revalidate();
            frame.repaint();
        }

        if (e.getSource() == newpassConfirm){

            //Updating Password

            PASSWORD = Integer.parseInt(String.valueOf(newpass.getPassword()));

            newpass.setText("");
            frame.remove(panel4);
            frame.add(backPanel);
            frame.add(resPanel);
            frame.revalidate();
            frame.repaint();
        }

        if (e.getSource() == getReport){
            frame.remove(panel3);
            frame.add(backPanel);
            frame.add(panel5);
            frame.revalidate();
            frame.repaint();
        }

        if (e.getSource() == takeCash){
            frame.remove(panel3);
            frame.add(backPanel);
            frame.add(panel6);
            frame.revalidate();
            frame.repaint();
        }

        if (e.getSource() == num1 || e.getSource() == num2 || e.getSource() == num3 || e.getSource() == num4){

            //Updating Account Balance

            long cost = Long.parseLong(((JButton) e.getSource()).getText());
            balance -= cost;
            report.setText("موجودی حساب شما:" + balance + "ریال");

            frame.remove(panel6);
            frame.add(backPanel);
            frame.add(resPanel);
            frame.revalidate();
            frame.repaint();
        }

        if (e.getSource() == transferCash){
            frame.remove(panel3);
            frame.add(backPanel);
            frame.add(panel7);
            frame.revalidate();
            frame.repaint();
        }

        if (e.getSource() == transferConfirm){

            //Updating Account Balance

            long cost = Long.parseLong(transferedCash.getText());
            balance -= cost;
            report.setText("موجودی حساب شما:" + balance + "ریال");

            transferedCash.setText("");
            accountNum.setText("");

            frame.remove(panel7);
            frame.add(backPanel);
            frame.add(resPanel);
            frame.revalidate();
            frame.repaint();
        }
    }
}
