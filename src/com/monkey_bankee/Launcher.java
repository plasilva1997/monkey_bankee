package com.monkey_bankee;

import com.monkey_bankee.model.*;
import com.monkey_bankee.dao.SingleDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Launcher {

    public static void main(String... args) {

        try {
            ArrayList<Employee> employees = SingleDAO.getEmployeeDAO().getAllEmployee();
            employees.forEach(System.out::println);

            //Test add

            SingleDAO.getEmployeeDAO().addEmployee(new Employee(
                    0,
                    "Robert",
                    "Bob",
                    "Marseille",
                    "bb@gmail.com",
                    "bob",
                    "025488569"
            ));
        } catch (SQLException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}