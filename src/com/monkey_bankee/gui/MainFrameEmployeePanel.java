package com.monkey_bankee.gui;

import com.monkey_bankee.dao.FactoryDAO;
import com.monkey_bankee.model.Client;
import com.monkey_bankee.model.ClientTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JScrollPane;

public class MainFrameEmployeePanel extends JFrame {

    private JButton action1Button;
    private JButton action2Button;
    private JButton action3Button;
    private JButton action4Button;
    private JTextField search;
    private JButton actionsearch;
    private JPanel JPanelClient;
    private ClientTable model;
    private JTable table12;
    private JScrollPane JscrollPanel5;


    public MainFrameEmployeePanel() {
        super();
        setVisible(true);
        add(JPanelClient);
        setTitle("MonkeyBankee | Panel");
        setSize(700, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        //Show table our clients
        action1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }

        });



        //show all clients of the bank
        action2Button.addActionListener(new ActionListener() {
            private JPanel JPanelClient;
            public ArrayList<Client> clients;

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    initComponent();

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            private void initComponent() throws SQLException {
                this.JPanelClient = new JPanel();
                clients = FactoryDAO.getClientDAO().getAllClient();
                model = new ClientTable();
                table12 = new JTable(model);
                table12.requestFocus();
                JScrollPane scrollPane = new JScrollPane(table12);
                JPanelClient.add(scrollPane);

                getContentPane().add(JPanelClient);
//                getContentPane().add(scrollPane);
//                pack();
            }
        });


        //Add client
        action3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainFrameAddClient addClient = new MainFrameAddClient();
                addClient.setVisible(true);

            }
        });


        //Add employee
        action4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainFrameAddEmployee addEmployee = new MainFrameAddEmployee();
                addEmployee.setVisible(true);

            }
        });


        //Add employee
        actionsearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainFrameAddEmployee addEmployee = new MainFrameAddEmployee();
                addEmployee.setVisible(true);

            }
        });

    }
}
