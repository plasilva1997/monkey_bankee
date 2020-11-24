package com.monkey_bankee.gui;

import com.monkey_bankee.dao.FactoryDAO;
import com.monkey_bankee.dao.HashDAO;
import com.monkey_bankee.model.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;


public class MainFrameAddEmployee extends JFrame {
    private JTextField Name;
    private JTextField FirstName;
    private JTextField CityBank;
    private JTextField Login;
    private JPasswordField Password;
    private JTextField Mobile;
    private JButton Register;
    private JPanel JPanelAdd;
    private JPanel JPanelLogo;
    private JLabel Logo;
    private JPanel JpanelForm;
    private JPasswordField passwordConfirm;
    private JLabel PasswordLabel;
    private JLabel JlabelError;


    public MainFrameAddEmployee() {
        add(JPanelAdd);
        setTitle("MonkeyBankee | Ajouter Un Employee");
        setSize(700, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Register.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                HashDAO hash = new HashDAO();
                Employee employee = new Employee();

                Date date_util = new Date();
                java.sql.Date date_sql = new java.sql.Date(date_util.getTime());

                String name = FirstName.getText();
                String firstname = Name.getText();
                String login = Login.getText();
                String city = CityBank.getText();
                String mobile = Mobile.getText();
                String password = String.valueOf(Password.getPassword());
                String password_verify = String.valueOf(passwordConfirm.getPassword());

                String passwordEncoded = hash.hashPassword(password);
                String passwordVerifyEncoded = hash.hashPassword(password_verify);


                if (name.isEmpty() || firstname.isEmpty() || city.isEmpty() || login.isEmpty() || password.isEmpty() || password_verify.isEmpty() || mobile.isEmpty()) {
                    JlabelError.setText("Veuillez remplir tous les champs");
                    setVisible(true);

                } else {
                    employee.setEmployee_nom(name);
                    employee.setEmployee_prenom(firstname);
                    employee.setEmployee_ville(city);
                    employee.setLogin(login);
                    employee.setPassword(password);
                    employee.setEmployee_tel(mobile);
                    employee.setCreated_at(new java.sql.Timestamp(new java.util.Date().getTime()));

                    if (passwordEncoded.equals(passwordVerifyEncoded)) {

                        try {

                            FactoryDAO.getEmployeeDAO().addEmployee(employee);
                            JOptionPane.showMessageDialog(JPanelAdd, "Employé(e) ajouté(e)");
                            setVisible(false);

                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }


                    } else {
                        JlabelError.setText("Les mots de passe ne correspondent pas.");
                    }
                }
            }
        });
    }

}