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


    public MainFrameAddEmployee() {
        add(JPanelAdd);
        setTitle("Add Employee");
        setSize(700, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    }



    private void initComponent(){
        JPanel panel = new JPanel(new GridLayout(8, 2));

        JLabel label1 = new JLabel("Nom");
        panel.add(label1);
        Name = new JTextField();
        panel.add(Name);

        JLabel label2 = new JLabel("Prenom");
        panel.add(label2);
        FirstName = new JTextField();
        panel.add(FirstName);

        JLabel label3 = new JLabel("Ville banque");
        panel.add(label3);
        CityBank = new JTextField();
        panel.add(CityBank);

        JLabel label4 = new JLabel("Adresse mail");
        panel.add(label4);
        Login = new JTextField();
        panel.add(Login);

        JLabel label5 = new JLabel("Password");
        panel.add(label5);
        Password = new JPasswordField();
        panel.add(Password);

        JLabel label6 = new JLabel("Confirmation Password");
        panel.add(label6);
        passwordConfirm = new JPasswordField();
        panel.add(passwordConfirm);

        JLabel label7 = new JLabel("N° Telephone");
        panel.add(label7);
        Mobile = new JTextField();
        panel.add(Mobile);

        Register = new JButton("Ajouter");
        panel.add(Register);

        Register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                HashDAO hash = new HashDAO();
                Employee employee = new Employee();

                String nom = Name.getText();
                String prenom = FirstName.getText();
                String ville  = CityBank.getText();
                String login = Login.getText();
                String pass = Password.getText();
                String passVerif = String.valueOf(passwordConfirm.getPassword());
                String tel = Mobile.getText();

                String passHash = hash.hashPassword(pass);
                String passVerifHash = hash.hashPassword(passVerif);

                if (nom.isEmpty() || prenom.isEmpty() || ville.isEmpty() || login.isEmpty() || pass.isEmpty() || passVerif.isEmpty() || tel.isEmpty()){
                    JOptionPane.showMessageDialog(panel, "Veuillez remplir tous les champs");
                } else {
                    employee.setEmployee_nom(nom);
                    employee.setEmployee_prenom(prenom);
                    employee.setEmployee_ville(ville);
                    employee.setLogin(login);
                    employee.setPassword(passHash);
                    employee.setEmployee_tel(tel);
                    employee.setCreated_at(new Timestamp(new Date().getTime()));

                    if (passHash.equals(passVerifHash)){
                        try{
                            FactoryDAO.getEmployeeDAO().addEmployee(employee);
                        } catch (SQLException se){
                            se.printStackTrace();
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }
}