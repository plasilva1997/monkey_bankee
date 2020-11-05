package com.monkey_bankee.model;

import javax.swing.table.AbstractTableModel;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class Employee {

    private int employee_id;
    private String employee_nom;
    private String employee_prenom;
    private String employee_ville;
    private String login;
    private String password;

    public Employee() {
    }

    public Employee(int employee_id, String employee_nom, String employee_prenom, String employee_ville, String login, String password, String employee_tel) {
        this.employee_id = employee_id;
        this.employee_nom = employee_nom;
        this.employee_prenom = employee_prenom;
        this.employee_ville = employee_ville;
        this.login = login;
        this.password = password;
        this.employee_tel = employee_tel;
    }

    private String employee_tel;
    private Timestamp created_at;
    private Timestamp modified_at;

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_nom() {
        return employee_nom;
    }

    public void setEmployee_nom(String employee_nom) {
        this.employee_nom = employee_nom;
    }

    public String getEmployee_prenom() {
        return employee_prenom;
    }

    public void setEmployee_prenom(String employee_prenom) {
        this.employee_prenom = employee_prenom;
    }

    public String getEmployee_ville() {
        return employee_ville;
    }

    public void setEmployee_ville(String employee_ville) {
        this.employee_ville = employee_ville;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployee_tel() {
        return employee_tel;
    }

    public void setEmployee_tel(String employee_tel) {
        this.employee_tel = employee_tel;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getModified_at() {
        return modified_at;
    }

    public void setModified_at(Timestamp modified_at) {
        this.modified_at = modified_at;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", employee_nom='" + employee_nom + '\'' +
                ", employee_prenom='" + employee_prenom + '\'' +
                ", employee_ville='" + employee_ville + '\'' +
                ", login='" + login + '\'' +
                ", employee_tel='" + employee_tel + '\'' +
                ", created_at=" + created_at +
                '}';
    }

    //TEST TABLEAU

    public class TableModel extends AbstractTableModel {

        private final String[] Titres = {
                "ID",
                "Nom Employe",
                "Prenom Employe",
                "Ville Banque",
                "Adresse Mail",
                "N° Telephone"
        };

        private final List Employees = new ArrayList();

        @Override
        public int getRowCount() {
            return Employees.size();
        }

        @Override
        public int getColumnCount() {
            return Titres.length;
        }

        @Override
        public String getColumnName(int column) {
            return Titres[column];
        }

        @Override
        public Object getValueAt(int row, int column) {
            switch (column) {
                case 0:
                    return employee_id;
                case 1:
                    return employee_nom;
                case 2:
                    return employee_prenom;
                case 3:
                    return employee_ville;
                case 4:
                    return login;
                case 5:
                    return employee_tel;
                default:
                    return "";
            }
        }
    }
}

