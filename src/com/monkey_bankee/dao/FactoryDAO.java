package com.monkey_bankee.dao;

import com.monkey_bankee.dao.impl.*;
import java.sql.SQLException;

public class FactoryDAO {
    private static EmployeeDAO employeeDAO;

    private FactoryDAO(){
        throw new IllegalStateException();
    }

    public static EmployeeDAO getEmployeeDAO() throws SQLException{
        if(employeeDAO == null){
            employeeDAO = new EmployeeDAOImpl();
        }
        return employeeDAO;
    }
}
