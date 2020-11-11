package com.monkey_bankee.dao;

import com.monkey_bankee.dao.impl.*;
import java.sql.SQLException;

public class FactoryDAO {
    private static EmployeeDAO employeeDAO;
    private static ClientDAOImpl clientDAO;

    private FactoryDAO() {
        throw new IllegalStateException();
    }

    public static EmployeeDAO getEmployeeDAO() throws SQLException {
        if (employeeDAO == null) {
            employeeDAO = new EmployeeDAOImpl();
        }
        return employeeDAO;
    }

    public static ClientDAO getClientDAO() throws SQLException {
        if (clientDAO == null) {
            clientDAO = new ClientDAOImpl();
        }
        return clientDAO;
    }
}
