package com.monkey_bankee;

import com.monkey_bankee.gui.MainFrameAddClient;
import com.monkey_bankee.gui.MainFrameAddEmployee;
import com.monkey_bankee.gui.MainFrameLogin;
import com.monkey_bankee.gui.MainFrameTable;
import com.monkey_bankee.model.*;
import com.monkey_bankee.dao.FactoryDAO;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Launcher {


    //Ouverture de la fenetre SWING
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, InvocationTargetException, InterruptedException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                MainFrameLogin login = new MainFrameLogin();
                login.setVisible(true);
            }
        });
    }


    //Ouverture de la fenetre  Swing Add Employee
/*
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, InvocationTargetException, InterruptedException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                MainFrameAddEmployee addemployee = new MainFrameAddEmployee();
                addemployee.setVisible(true);
            }
        });
    }
*/
/*
    //Ouverture de la fenetre  Swing Add Client

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, InvocationTargetException, InterruptedException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                MainFrameAddClient addclient = new MainFrameAddClient();
                addclient.setVisible(true);
            }
        });
    }
*/

    /*public static void main(String... args) {

//        try {
//            ArrayList<Employee> employees = FactoryDAO.getEmployeeDAO().getAllEmployee();
//            employees.forEach(System.out::println);
//
//            //Test add
//
//            FactoryDAO.getEmployeeDAO().addEmployee(new Employee(
//                    0,
//                    "Robert",
//                    "Bob",
//                    "Marseille",
//                    "bb@gmail.com",
//                    "bob",
//                    "025488569"
//            ));
//        } catch (SQLException ex) {
//            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
//        }

        try {
            //Test add
            FactoryDAO.getEmployeeDAO().addEmployee(new Employee(
            
            //Test add employee
           FactoryDAO.getEmployeeDAO().addEmployee(new Employee(
                    0,
                    "Didier",
                    "Maxime",
                    "Lille",
                    "dm@gmail.com",
                    "azerty",
                    "06584426658"
            ));
            ArrayList<Employee> employees = FactoryDAO.getEmployeeDAO().getAllEmployee();
            MainFrameTable mf = new MainFrameTable(employees);

/*            ArrayList<Client> clients = FactoryDAO.getClientDAO().getAllClient();
            clients.forEach(System.out::println);*/

            //add Client

            FactoryDAO.getClientDAO().addClient(new Client(
                    0,
                    "John",
                    "Barzoy",
                    "01/01/2020",
                    "john.barzoy@gmail.com",
                    "0102030405",
                    "Célibataire",
                    "100000",
                    "1702.98",
                    "1053.67",
                    "Livret A",
                    "24",
                    "appartement 53b3",
                    " rue bidon",
                    "76000",
                    "Rouen"

            ));

        } catch (SQLException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}