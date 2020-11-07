package com.monkey_bankee.dao;

import com.monkey_bankee.dao.impl.*;
import java.sql.SQLException;

public class FactoryDAO {
    // static on passe par la classe et non l'objet pour y accéder
    private static EmployeeDAO employeeDAO;

    private FactoryDAO(){
        throw new IllegalStateException();
    }

    // Objectif : singleton, une instance par exécution, évite les problèmes d'incohérence en DB et d'accès concurrents à la
    public static EmployeeDAO getEmployeeDAO() throws SQLException{
        if(employeeDAO == null){
            employeeDAO = new EmployeeDAOImpl();
        }
        return employeeDAO;
    }
}
