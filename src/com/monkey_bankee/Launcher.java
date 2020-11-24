package com.monkey_bankee;

import com.monkey_bankee.dao.FactoryDAO;
import com.monkey_bankee.gui.MainFrameClient;
import com.monkey_bankee.gui.MainFrameLogin;
import com.monkey_bankee.gui.MainFrameTable;
import com.monkey_bankee.model.Client;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Launcher {


    //Ouverture de la fenetre SWING
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, InvocationTargetException, InterruptedException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeAndWait(() -> {
            MainFrameLogin login = new MainFrameLogin();
            login.setVisible(true);
        });
    }

    /*//Ouverture de la fenetre  Swing Add Client
    public static void main(String[] args) throws SQLException {

        ArrayList<Client> clients = FactoryDAO.getClientDAO().getAllClient();
        MainFrameClient client = new MainFrameClient(clients);

    }*/

}