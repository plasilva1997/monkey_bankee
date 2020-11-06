package com.monkey_bankee.gui;


import com.monkey_bankee.dao.EmployeeDAO;
import com.monkey_bankee.dao.impl.EmployeeDAOImpl;
import com.monkey_bankee.model.Employee;
import com.monkey_bankee.dao.SingleDAO;
import com.monkey_bankee.model.EmployeeTable;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainFrameTable extends JFrame {

    private ArrayList<Employee> employees;
    private JPanel panel;
    private JTable table;
    private EmployeeTable model;

    public MainFrameTable(ArrayList<Employee> employees){
        super();
        setVisible(true);
        setTitle("Les Banquiers");
        setBounds(200, 200, 450, 600);
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
        employees = SingleDAO.getEmployeeDAO().getAllEmployee();
        model = new EmployeeTable();
        table = new JTable(model);
        panel.add(table, BorderLayout.NORTH);
        getContentPane().add(panel);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);
    }

    public MainFrameTable getThis() {
        return this;
    }
}
