package com.Student_traning;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import java.util.Vector;

public class Student_Details extends JFrame implements ActionListener {
    JPanel p;
    JLabel l,l1;
    JTextField t;
    JButton b,b1;
    JTable t1;

    JScrollPane sp;

    Connection connection;
    PreparedStatement statement;
    ResultSet set;
    Vector<String> col;

    Vector<Vector<String>> v1;

    public Student_Details(){
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_traning", "root", "qwerty@1234");

        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }

        col=new Vector<>();
        v1=new Vector<>();

        col.add("Roll_no");
        col.add("Name");
        col.add("Branch");
        col.add("Course");


        p=new JPanel(null);
        l=new JLabel("Student's Details");
        l1=new JLabel("Enter roll_no");
        t=new JTextField();
        b=new JButton("Show");
        b1=new JButton("Back");

        l.setBounds(150,30,300,50);
        l1.setBounds(100,120,100,30);
        t.setBounds(230,120,100,30);
        b.setBounds(100,180,100,30);
        b1.setBounds(230,180,100,30);

        p.add(l1);
        p.add(l);
        p.add(t);
        p.add(b);
        p.add(b1);

        Font font = new Font("Times New Roman", Font.BOLD, 25);
        l.setFont(font);

        Font ft = new Font("Times New Roman", Font.BOLD,14 );
        l1.setFont(ft);

        add(p);
        setSize(500, 500);
        setVisible(true);
        setResizable(false);
        setBounds(500,100,500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        b.addActionListener(this);
        b1.addActionListener(this);
    }

    public static void main(String[] args) {
        Student_Details sd = new Student_Details();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(b)){

            v1.removeAllElements();

            String n=t.getText();

            try {

                statement=connection.prepareStatement("select * from project_records where roll_no=?");
                statement.setString(1,n);
                set=statement.executeQuery();

                int i=1;
                while(set.next())
                {
                    Vector<String> v2 = new Vector<>();

                    v2.add(set.getString(1));
                    v2.add(set.getString(2));
                    v2.add(set.getString(3));
                    v2.add(set.getString(4));
                    i++;

                    v1.add(v2);

                }

                t1=new JTable(v1, col);
                sp=new JScrollPane(t1);

                sp.setBounds(40,230,400,200);

                p.add(sp);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        if (e.getSource().equals(b1)){
            new Teacher_Success();
            this.dispose();
        }
    }
}
