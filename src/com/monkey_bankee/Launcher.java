package com.monkey_bankee;

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


    //Ouverture de de la fenetre SWING
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


    /*public static void main(String... args) {

        try {
            //Test add
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
        } catch (SQLException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}