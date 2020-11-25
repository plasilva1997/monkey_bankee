package com.monkey_bankee.gui;


import com.monkey_bankee.dao.FactoryDAO;
import com.monkey_bankee.model.Employee;
import com.monkey_bankee.model.EmployeeTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainFrameTableEmployee extends JFrame {

    private ArrayList<Employee> employees;
    private JPanel panel;
    private JTable table;
    private EmployeeTable model;
    private JButton returnbutton;


    public MainFrameTableEmployee() {
        super();
        setVisible(true);
        setTitle("Les Banquiers");
        setBounds(200, 200, 800, 600);
        setMinimumSize(new Dimension(300, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.employees = employees;
        try {
            initComponent();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private void initComponent() throws SQLException {
        this.panel = new JPanel(new BorderLayout());
        employees = FactoryDAO.getEmployeeDAO().getAllEmployee();
        model = new EmployeeTable();
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.NORTH);
        this.returnbutton = new JButton("Retour");
        panel.add(this.returnbutton, BorderLayout.SOUTH);
        returnbutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                MainFrameEmployeePanel employeePanel = new MainFrameEmployeePanel();
                employeePanel.setVisible(true);
            }
        });

        getContentPane().add(panel);
    }

    public MainFrameTableEmployee getThis() {
        return this;
    }


}
