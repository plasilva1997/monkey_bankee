package com.monkey_bankee;

import com.monkey_bankee.gui.MainFrameTable;
import com.monkey_bankee.model.*;
import com.monkey_bankee.dao.FactoryDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Launcher {

    public static void main(String... args) {

        try {
            //Test add
            /*FactoryDAO.getEmployeeDAO().addEmployee(new Employee(
                    0,
                    "Michel",
                    "Robert",
                    "Dieppe",
                    "mr@gmail.com",
                    "azerty",
                    "0658852632"
            ));*/
            ArrayList<Employee> employees = FactoryDAO.getEmployeeDAO().getAllEmployee();
            MainFrameTable mf = new MainFrameTable(employees);
        } catch (SQLException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}