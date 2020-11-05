package com.monkey_bankee.gui;


import com.monkey_bankee.dao.EmployeeDAO;
import com.monkey_bankee.dao.impl.EmployeeDAOImpl;
import com.monkey_bankee.model.Employee;
import com.monkey_bankee.dao.SingleDAO;
import com.monkey_bankee.model.Employee.TableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrameTable extends JFrame {

    private ArrayList<Employee> employees;
    private JPanel panel;
    private JTable table;
    private TableModel model;

    public MainFrameTable(ArrayList<Employee> employees){
        super();
        setVisible(true);
        setTitle("Les Banquiers");
        setBounds(200, 200, 450, 600);
        setMinimumSize(new Dimension(300, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.employees = employees;
        initComponent();
    }

    private void initComponent() {
        this.panel = new JPanel(new BorderLayout());
        ArrayList employees = EmployeeDAOImpl.getAllEmployee();
        model = new TableModel(employees);
        table = new JTable();
        table.setModel(model);
        panel.add(table, BorderLayout.NORTH);
        getContentPane().add(panel);
    }

    public MainFrameTable getThis() {
        return this;
    }
}
