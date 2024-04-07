package com.Student_traning;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Contact extends JFrame
{
    JPanel panel = new JPanel(null);

    JLabel l_con = new JLabel("CONTACT US");
    JLabel l_no = new JLabel("CONTACT NO : ");
    JLabel l_mail = new JLabel("Email address");

    Font f = new Font("Ariel", Font.BOLD+Font.ITALIC, 25);

    Font f2 = new Font("Ariel", Font.BOLD, 20);

    public Contact()
    {
        setTitle("Admin Panel");
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(500,100,500,500);
        setResizable(false);

        add(panel);

        panel.add(l_con);
        panel.add(l_no);
        panel.add(l_mail);

        l_con.setFont(f);
        l_no.setFont(f2);
        l_mail.setFont(f2);

        l_con.setBounds(100, 50, 200, 50);
        l_no.setBounds(100, 150, 300, 50);
        l_mail.setBounds(80, 250, 400, 50);

    }
    public static void main(String[] args)
    {
        new Contact();
    }
}

