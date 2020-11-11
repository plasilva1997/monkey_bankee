package com.monkey_bankee;

import com.monkey_bankee.model.*;
import com.monkey_bankee.dao.FactoryDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Launcher {

    public static void main(String... args) {

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

            ArrayList<Client> clients = FactoryDAO.getClientDAO().getAllClient();
            clients.forEach(System.out::println);

            //add

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
    }
}