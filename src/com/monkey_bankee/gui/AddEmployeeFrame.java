package com.monkey_bankee.gui;

import com.monkey_bankee.dao.FactoryDAO;
import com.monkey_bankee.dao.HashDAO;
import com.monkey_bankee.model.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddEmployeeFrame extends JFrame {

    private Employee employee;
    private JTextField nomtf;
    private JTextField prenomtf;
    private JTextField villetf;
    private JTextField logintf;
    private JPasswordField passwordpf;
    private JPasswordField passwordConfirmpf;
    private JTextField teltf;
    private JButton save;
    private MainFrameTable mother;

    public AddEmployeeFrame(MainFrameTable mother) {
        super();
        setTitle("Ajout Employee");
        setBounds(100, 100, 400, 800);
        setMinimumSize(new Dimension(200, 200));
        this.employee = new Employee();
        this.mother = mother;
        initComponent();
    }

    private void initComponent() {
        JPanel panel = new JPanel(new GridLayout(8, 2));

        JLabel label1 = new JLabel("Nom");
        panel.add(label1);
        nomtf = new JTextField();
        panel.add(nomtf);

        JLabel label2 = new JLabel("Prenom");
        panel.add(label2);
        prenomtf = new JTextField();
        panel.add(prenomtf);

        JLabel label3 = new JLabel("Ville banque");
        panel.add(label3);
        villetf = new JTextField();
        panel.add(villetf);

        JLabel label4 = new JLabel("Adresse mail");
        panel.add(label4);
        logintf = new JTextField();
        panel.add(logintf);

        JLabel label5 = new JLabel("Password");
        panel.add(label5);
        passwordpf = new JPasswordField();
        panel.add(passwordpf);

        JLabel label6 = new JLabel("Confirmation Password");
        panel.add(label6);
        passwordConfirmpf = new JPasswordField();
        panel.add(passwordConfirmpf);

        JLabel label7 = new JLabel("N° Telephone");
        panel.add(label7);
        teltf = new JTextField();
        panel.add(teltf);

        save = new JButton("Ajouter");
        panel.add(save);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                HashDAO hash = new HashDAO();
                Employee employee = new Employee();

                String nom = nomtf.getText();
                String prenom = prenomtf.getText();
                String ville = villetf.getText();
                String login = logintf.getText();
                String pass = passwordpf.getText();
                String passVerif = passwordConfirmpf.getText();
                String tel = teltf.getText();

                String passHash = hash.hashPassword(pass);
                String passVerifHash = hash.hashPassword(passVerif);

                if (nom.isEmpty() || prenom.isEmpty() || ville.isEmpty() || login.isEmpty() || pass.isEmpty() || passVerif.isEmpty() || tel.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Veuillez remplir tous les champs");
                    setVisible(true);
                } else {
                    employee.setEmployee_nom(nom);
                    employee.setEmployee_prenom(prenom);
                    employee.setEmployee_ville(ville);
                    employee.setLogin(login);
                    employee.setPassword(passHash);
                    employee.setEmployee_tel(tel);
                    employee.setCreated_at(new java.sql.Timestamp(new java.util.Date().getTime()));

                    if (passHash.equals(passVerifHash)) {
                        try {
                            FactoryDAO.getEmployeeDAO().addEmployee(employee);
                            JOptionPane.showMessageDialog(panel, "Employé(e) ajouté(e)");
                            setVisible(false);
                        } catch (SQLException se) {
                            se.printStackTrace();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        mother.refresh();
                        mother.setNewEmployee(employee);

                    } else {
                        JOptionPane.showMessageDialog(panel, "Les mots de passe ne sont pas identiques");
                        setVisible(true);
                    }
                }
            }
        });
        getContentPane().add(panel);
    }
}
