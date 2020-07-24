package ch.ti8m.azubi.kti.pizzashop.ws;

import ch.ti8m.azubi.kti.pizzashop.persistence.PizzaDAO;
import ch.ti8m.azubi.kti.pizzashop.service.ConnectionUtil;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws Exception {
        PizzaDAO pizzaDAO = new PizzaDAO(ConnectionUtil.createDBConnection());
        System.out.println(pizzaDAO.list());
    }
}
