package com.monkey_bankee.gui;

import com.monkey_bankee.dao.FactoryDAO;
import com.monkey_bankee.dao.HashDAO;
import com.monkey_bankee.model.Client;
import com.monkey_bankee.model.ClientTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainFrameEmployeePanel extends JFrame {

    private JButton action1Button;
    private JButton action2Button;
    private JButton action3Button;
    private JButton action4Button;
    private JTextField search;
    private JTable table1;
    private JButton actionsearch;
    private JPanel JPanelClient;
    private ClientTable model;


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
            private ArrayList<Client> clients;
            @Override
            public void actionPerformed(ActionEvent e) {


                this.clients = clients;
                try {
                    initComponent();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            private void initComponent() throws SQLException {
                clients = FactoryDAO.getClientDAO().getAllClient();
                model = new ClientTable();
                table1 = new JTable(model);
                JScrollPane scrollPane = new JScrollPane(table1);
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

    }
}
