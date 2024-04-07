package com.Student_traning;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewALLProject extends JFrame implements ActionListener {
    JPanel p1;
    JTable t;
    JLabel l;
    JButton b;
    JScrollPane sp;

    Connection connection;
    PreparedStatement statement;
    ResultSet set;
    String roll_no;

    String [] col={"Roll_no","Name","Branch","Course","Project","Language"};
    String [][] row;

    public ViewALLProject()
    {

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_traning", "root", "qwerty@1234");

            statement=connection.prepareStatement("select count(roll_no) from project_records");
            set=statement.executeQuery();
            set.next();
            roll_no=set.getString(1);

            row=new String[Integer.parseInt(roll_no)][6];

            statement=connection.prepareStatement("select * from project_records");
            set=statement.executeQuery();


            int i=0;
            while(set.next())
            {
                row[i][0]= set.getString(1);
                row[i][1]=set.getString(2);
                row[i][2]=set.getString(3);
                row[i][3]=set.getString(4);
                row[i][4]=set.getString(5);
                row[i][5]=set.getString(6);

                i++;
            }
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_traning", "root", "qwerty@123");

            statement=connection.prepareStatement("select count(roll_no) from project_records");
            set=statement.executeQuery();
            set.next();
            roll_no=set.getString(1);

            row=new String[Integer.parseInt(roll_no)][6];

            statement=connection.prepareStatement("select * from project_records");
            set=statement.executeQuery();


            int i=0;
            while(set.next())
            {
                row[i][0]= set.getString(1);
                row[i][1]=set.getString(2);
                row[i][2]=set.getString(3);
                row[i][3]=set.getString(4);
                row[i][4]=set.getString(5);
                row[i][5]=set.getString(6);

                i++;
            }
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        p1=new JPanel(null);
        t=new JTable(row, col);
        sp=new JScrollPane(t);
        l=new JLabel("Project Details");
        b=new JButton("Back");

        sp.setBounds(20,60,410,340);
        l.setBounds(160,20,200,30);
        b.setBounds(180,410,100,30);

        p1.add(sp);
        p1.add(l);
        p1.add(b);

        add(p1);


        setSize(500, 500);
        setVisible(true);
        setResizable(false);
        setBounds(500,100,500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("All Products");

        b.addActionListener(this);
    }

    public static void main(String[] args)
    {
        ViewALLProject vp = new ViewALLProject();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(b)){
            Teacher_Success.main(new String[10]);
            dispose();
        }
    }
}
