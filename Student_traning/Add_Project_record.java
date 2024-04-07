package com.Student_traning;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Add_Project_record extends JFrame implements ActionListener
{
    JPanel panel = new JPanel(null);

    JLabel l_roll = new JLabel("Roll No");
    JLabel l_name = new JLabel("NAME");
    JLabel l_branch = new JLabel("BRANCH");
    JLabel l_course = new JLabel("COURSE");
    JLabel l_project = new JLabel("PROJECT");
    JLabel l_tech = new JLabel("LANGUAGE USED");
    JLabel l6= new JLabel("");

    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JTextField t3 = new JTextField();
    JTextField t4 = new JTextField();
    JTextField t5 = new JTextField();
    JTextField t6 = new JTextField();

    JButton b_insert = new JButton("INSERT");
    JButton b_exit = new JButton("EXIT");

    Font f = new Font("Ariel", Font.BOLD, 13);
    Font f1 = new Font("Ariel", Font.PLAIN, 13);

    String roll_no,name,branch,course,project,technologies;
    Connection connection;
    PreparedStatement statement;

    public Add_Project_record()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_traning", "root", "qwerty@1234");

        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        setVisible(true);
        setTitle("Insert Records");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(500,90,500,620);
        setResizable(false);

        add(panel);

        panel.add(l_roll);
        panel.add(l_name);
        panel.add(l_branch);
        panel.add(l_course);
        panel.add(l_project);
        panel.add(l_tech);
        panel.add(l6);

        panel.add(t1);
        panel.add(t2);
        panel.add(t3);
        panel.add(t4);
        panel.add(t5);
        panel.add(t6);

        panel.add(b_insert);
        panel.add(b_exit);

        l_roll.setFont(f);
        l_roll.setBounds(60, 40, 100, 40);
        t1.setFont(f1);
        t1.setBounds(290, 40,150,40);

        l_name.setFont(f);
        l_name.setBounds(60, 100, 100, 40);
        t2.setFont(f1);
        t2.setBounds(290, 100, 150, 40);

        l_branch.setFont(f);
        l_branch.setBounds(60, 160, 100, 40);
        t3.setFont(f1);
        t3.setBounds(290, 160, 150, 40);

        l_course.setFont(f);
        l_course.setBounds(60, 220, 100, 40);
        t4.setFont(f1);
        t4.setBounds(290, 220, 150, 40);



        l_project.setFont(f);
        l_project.setBounds(60, 340, 100, 40);
        t5.setFont(f1);
        t5.setBounds(290, 340, 150, 40);

        l_tech.setFont(f);
        l_tech.setBounds(60, 400, 200, 40);
        t6.setFont(f1);
        t6.setBounds(290, 400, 150, 40);

        b_insert.setFont(f);
        b_insert.setBounds(70, 480, 150, 40);


        b_exit.setFont(f);
        b_exit.setBounds(260, 480, 150, 40);

        l6.setBounds(250,570,400,40);

        b_insert.addActionListener(this);

        b_exit.addActionListener(this);

    }
    public static void main(String[] args)
    {
        new Add_Project_record();
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {

        if(e.getSource().equals(b_insert))
        {

            roll_no=String.valueOf(t1.getText());
            name=String.valueOf(t2.getText());
            branch=String.valueOf(t3.getText());
            course=String.valueOf(t4.getText());
            project=String.valueOf(t5.getText());
            technologies=String.valueOf(t6.getText());
            try
            {
                statement=connection.prepareStatement("insert into project_records values(?,?,?,?,?,?)");
                statement.setString(1,roll_no);
                statement.setString(2,name);
                statement.setString(3, branch);
                statement.setString(4, course);
                statement.setString(5, project);
                statement.setString(6, technologies);
                int i=statement.executeUpdate();
                if(i>0)
                {
                    l6.setText("Teacher has been added");
                }
                else
                {
                    l6.setText("an error occurred... try again");
                }
                t1.setText("");t2.setText("");t3.setText("");t4.setText("");t5.setText("");t6.setText("");l6.setText("");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        if(e.getSource().equals(b_exit))
        {
            new Teacher_Success();
            this.dispose();
        }
    }
}
