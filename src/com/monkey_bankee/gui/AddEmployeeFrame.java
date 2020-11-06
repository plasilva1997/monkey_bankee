package com.monkey_bankee.gui;

import com.monkey_bankee.dao.FactoryDAO;
import com.monkey_bankee.model.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class AddEmployeeFrame extends JFrame {

    private Employee employee;
    private JTextField nom;
    private JTextField prenom;
    private JTextField ville;
    private JTextField login;
    private JPasswordField password;
    private JPasswordField passwordConfirm;
    private JTextField tel;
    private JButton save;
    private MainFrameTable mother;

    public AddEmployeeFrame(MainFrameTable mother){
        super();
        setTitle("Ajout Employee");
        setBounds(100, 100, 400, 800);
        setMinimumSize(new Dimension(200,200));
        this.employee = new Employee();
        this.mother = mother;
        initComponent();
    }

    private void initComponent(){
        JPanel panel = new JPanel(new GridLayout(8, 2));

        JLabel label1 = new JLabel("Nom");
        panel.add(label1);
        nom = new JTextField();
        panel.add(nom);

        JLabel label2 = new JLabel("Prenom");
        panel.add(label2);
        prenom = new JTextField();
        panel.add(prenom);

        JLabel label3 = new JLabel("Ville banque");
        panel.add(label3);
        ville = new JTextField();
        panel.add(ville);

        JLabel label4 = new JLabel("Adresse mail");
        panel.add(label4);
        login = new JTextField();
        panel.add(login);

        JLabel label5 = new JLabel("Password");
        panel.add(label5);
        password = new JPasswordField();
        panel.add(password);

        JLabel label6 = new JLabel("Confirmation Password");
        panel.add(label6);
        passwordConfirm = new JPasswordField();
        panel.add(passwordConfirm);

        JLabel label7 = new JLabel("N° Telephone");
        panel.add(label7);
        tel = new JTextField();
        panel.add(tel);

        save = new JButton("Ajouter");
        panel.add(save);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employee employee = new Employee();

                employee.setEmployee_nom(nom.getText());
                employee.setEmployee_prenom(prenom.getText());
                employee.setEmployee_ville(ville.getText());
                employee.setLogin(login.getText());
                employee.setPassword(String.valueOf(password.getPassword()));
                employee.setEmployee_tel(tel.getText());
                employee.setCreated_at(new java.sql.Timestamp(new java.util.Date().getTime()));
                try {
                    if (password.getPassword() == passwordConfirm.getPassword()){
                        FactoryDAO.getEmployeeDAO().addEmployee(employee);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AddEmployeeFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                mother.setNewEmployee(employee);
                setVisible(false);
            }
        });
        getContentPane().add(panel);
    }
}
