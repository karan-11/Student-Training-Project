package com.Student_traning;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home extends JFrame implements ActionListener
{
    JPanel panel = new JPanel(null);

    JLabel l_wel = new JLabel("WELCOME");

    JButton b_admin = new JButton("ADMIN PANEL");
    JButton b_teach = new JButton("TEACHER PANEL");


    Font f = new Font("Ariel", Font.BOLD+Font.ITALIC, 30);

    Font f2 = new Font("Ariel", Font.BOLD, 20);

    public Home()
    {
        setTitle("HOME");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(400,40,500,500);
        setResizable(false);

        add(panel);
        panel.add(l_wel);
        panel.add(b_admin);
        panel.add(b_teach);

        l_wel.setFont(f);
        l_wel.setBounds(150, 50, 200, 50);

        b_admin.setFont(f2);
        b_admin.setBounds(150, 180, 200, 50);

        b_teach.setFont(f2);
        b_teach.setBounds(150, 300, 200, 50);

        b_admin.addActionListener(this);
        b_teach.addActionListener(this);
    }
    public static void main(String[] args)
    {
        new Home();
    }
    @Override
    public void actionPerformed(ActionEvent a)
    {
        String mes = a.getActionCommand();

        if(mes.equals("TEACHER PANEL"))
        {
            new Teacher_Login();
            this.dispose();
        }
        if(mes.equals("ADMIN PANEL"))
        {
            new Admin_Login();
            this.dispose();
        }

    }

}

