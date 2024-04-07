package com.Student_traning;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Admin_Success extends JFrame implements ActionListener
{
    JPanel panel = new JPanel(null);

    JLabel l_wel = new JLabel("WELCOME ADMIN");

    JButton b_teach = new JButton("ADD TEACHER");

    JButton b_pr_Recrd = new JButton("ADD TRAINING DETAILS");

    JButton b_pr_step_search = new JButton("ALL TRAINING DETAILS");

    JButton b_dev = new JButton("CONTACT DEVELOPER");

    JButton b_log = new JButton("LOG OUT");


    Font f = new Font("Ariel", Font.BOLD, 30);

    public Admin_Success()
    {
        setTitle("Admin Panel");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(400,40,500,600);
        setResizable(false);

        add(panel);

        panel.add(l_wel);
        panel.add(b_teach);
        panel.add(b_pr_Recrd);
        panel.add(b_pr_step_search);
        panel.add(b_dev);
        panel.add(b_log);


        l_wel.setFont(f);
        l_wel.setBounds(110, 50, 280, 50);

        b_log.setBounds(200, 450, 100, 30);

        b_teach.setBounds(150,150,200,40);

        b_pr_Recrd.setBounds(150, 210, 200, 40);

        b_pr_step_search.setBounds(150, 270, 200, 40);

        b_dev.setBounds(150, 330, 200, 40);

        b_teach.addActionListener(this);
        b_pr_Recrd.addActionListener(this);
        b_pr_step_search.addActionListener(this);
        b_log.addActionListener(this);
        b_dev.addActionListener(this);



    }
    public static void main(String[] args)
    {
        new Admin_Success();
    }
    @Override
    public void actionPerformed(ActionEvent a)
    {
        String mes = a.getActionCommand();

        if(mes.equals("ADD TEACHER"))
        {
            new Add_Teacher();
            this.dispose();
        }
        if(mes.equals("ADD TRAINING DETAILS"))
        {
            new Add_Training_Details();
            this.dispose();
        }
        if(mes.equals("ALL TRAINING DETAILS"))
        {
            new All_Training_Details();
            this.dispose();
        }
        if(mes.equals("CONTACT DEVELOPER"))
        {
            new Contact();

        }
//        if(mes.equals("SEARCH REPORT FILE"))
//        {
//            new Report_File_Search();
//            this.dispose();
//        }
//
        if(mes.equals("LOG OUT"))
        {
            new Home();
            this.dispose();
        }


    }
}

