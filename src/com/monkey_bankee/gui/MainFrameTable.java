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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

public class MainFrameTable extends JFrame {

    private ArrayList<Employee> employees;
    private JPanel panel;
    private JTable table;
    private EmployeeTable model;
    private Employee newEmployee;
    private JButton addEmployeeBtn;

    public MainFrameTable(ArrayList<Employee> employees){
        super();
        setVisible(true);
        setTitle("Les Banquiers");
        setBounds(200, 200, 800, 800);
        setMinimumSize(new Dimension(800, 800));
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
        this.addEmployeeBtn = new JButton("Ajouter un employee");
        panel.add(this.addEmployeeBtn, BorderLayout.SOUTH);
        addEmployeeBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new AddEmployeeFrame(getThis()).setVisible(true);
            }
        });
        getContentPane().add(panel);
    }

    public MainFrameTable getThis() {
        return this;
    }


    public Employee getNewEmployee(){
        return newEmployee;
    }

    public void setNewEmployee(Employee newEmployee){
        System.out.println("Ajout de l'employé :\n" + newEmployee);
        this.newEmployee = newEmployee;
    }

    public void refresh() throws SQLException {
        int row = FactoryDAO.getEmployeeDAO().getAllEmployee().size()-1;
        model.fireTableRowsInserted(row, row);
        table.repaint();
    }
}
