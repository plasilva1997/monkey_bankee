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

public class MainFrameClient extends JFrame {

    private ArrayList<Client> clients;
    private JPanel panel;
    private JTable table;
    private ClientTable model;


    public MainFrameClient(ArrayList<Client> clients){
        super();
        setVisible(true);
        setTitle("Les Clients");
        setBounds(200, 200, 800, 600);
        setMinimumSize(new Dimension(300, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.clients = clients;
        try {
            initComponent();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void initComponent() throws SQLException {
        this.panel = new JPanel(new BorderLayout());
        clients = FactoryDAO.getClientDAO().getAllClient();
        model = new ClientTable();
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.NORTH);
        getContentPane().add(panel);
    }
}
