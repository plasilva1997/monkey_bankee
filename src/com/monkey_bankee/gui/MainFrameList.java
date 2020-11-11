package com.monkey_bankee.gui;

import com.monkey_bankee.dao.FactoryDAO;
import com.monkey_bankee.model.Employee;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class MainFrameList extends JFrame {

    private ArrayList<Employee> employees;
    private JPanel panel;
    private JButton addEmployeeBtn;
    private DefaultListModel model = new DefaultListModel();

    public MainFrameList(ArrayList<Employee> employees) {
        super();
        setVisible(true);
        setTitle("Les Banquiers");
        setBounds(200, 200, 600, 400);
        setMinimumSize(new Dimension(300, 200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.employees = employees;
        initComponent();
    }

    private void initComponent() {
        this.panel = new JPanel(new BorderLayout());
        for (Employee employee : employees) {
            model.addElement(employee);
        }
        JList list = new JList(model);
        panel.add(list, BorderLayout.NORTH);
        getContentPane().add(panel);
    }

    public void refresh() {
        try {
            employees = FactoryDAO.getEmployeeDAO().getAllEmployee();
            model.addElement(employees.get(employees.size() - 1));
            //initComponent();
            //SwingUtilities.updateComponentTreeUI(this);
        } catch (SQLException ex) {
            Logger.getLogger(MainFrameList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public MainFrameList getThis() {
        return this;
    }
}
