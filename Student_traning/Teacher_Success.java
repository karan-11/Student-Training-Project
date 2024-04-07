package com.Student_traning;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Teacher_Success extends JFrame implements ActionListener
{

    JPanel panel = new JPanel(null);

    JLabel l_wel = new JLabel("WELCOME TEACHER");

    JButton b_pr_Recrd = new JButton("ADD PROJECT RECORDS");

    JButton b_pr_step_search = new JButton("ALL PROJECTS");
    JButton b_rpt = new JButton("Student Details");

    JButton b_log = new JButton("LOG OUT");

    Font f = new Font("Ariel", Font.BOLD, 30);

    public Teacher_Success()
    {
        setTitle("Teacher Panel");
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(400,40,500,600);
        setResizable(false);

        add(panel);

        panel.add(l_wel);
        panel.add(b_pr_Recrd);
        panel.add(b_pr_step_search);
        panel.add(b_log);
        panel.add(b_rpt);

        l_wel.setFont(f);
        l_wel.setBounds(90, 70, 320, 50);

        b_log.setBounds(200, 450, 100, 30);

        b_pr_Recrd.setBounds(150, 200, 200, 40);

        b_pr_step_search.setBounds(150, 280, 200, 40);

        b_rpt.setBounds(150, 360, 200, 40);

        b_pr_Recrd.addActionListener(this);
        b_pr_step_search.addActionListener(this);
        b_rpt.addActionListener(this);
        b_log.addActionListener(this);

    }
    public static void main(String[] args)
    {
        new Teacher_Success();
    }
    @Override
    public void actionPerformed(ActionEvent a)
    {
        String mes = a.getActionCommand();

        if(mes.equals("ADD PROJECT RECORDS"))
        {
            new Add_Project_record();
            this.dispose();
        }
        if(mes.equals("ALL PROJECTS"))
        {
            new ViewALLProject();
            this.dispose();
        }
        if(mes.equals("Student Details"))
        {
            new Student_Details();
            this.dispose();
        }
        if(mes.equals("LOG OUT"))
        {
            new Teacher_Login();
            this.dispose();
        }


    }
}

