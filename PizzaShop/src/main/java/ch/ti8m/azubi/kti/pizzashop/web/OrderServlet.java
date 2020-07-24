package ch.ti8m.azubi.kti.pizzashop.web;

import ch.ti8m.azubi.kti.pizzashop.dto.Order;
import ch.ti8m.azubi.kti.pizzashop.dto.Pizza;
import ch.ti8m.azubi.kti.pizzashop.service.OrderService;
import ch.ti8m.azubi.kti.pizzashop.service.PizzaService;
import ch.ti8m.azubi.kti.pizzashop.service.ServiceRegistry;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Order servlet
 */
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    private OrderService orderService;
    private PizzaService pizzaService;
    private Template template;

    @Override
    public void init() throws ServletException {
        orderService = ServiceRegistry.getInstance().get(OrderService.class);
        pizzaService = ServiceRegistry.getInstance().get(PizzaService.class);
        template = new FreemarkerConfig().loadTemplate("order.ftl");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Order> orders = null;
        try {
            orders = orderService.list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        PrintWriter writer = resp.getWriter();
        Map<String, Object> model = new HashMap<>();
        model.put("orders", orders);

        try {
            template.process(model, writer);
        } catch (TemplateException ex) {
            throw new IOException("Could not process template: " + ex.getMessage());
        }
    }

    //    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//
//        String address = req.getParameter("address");
//        Date date = Date.valueOf(req.getParameter("date"));
//        String phone = req.getParameter("phone");
//        Order order = new Order();
//        order.setAddress(address);
//        order.setDate(date);
//        order.setPhone(phone);
//        try {
//            orderService.create(order);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // send a redirect to refresh the page
//        resp.sendRedirect(req.getRequestURI());
//    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String name = req.getParameter("name");
        Double price = Double.parseDouble(req.getParameter("price"));
        Pizza pizza = new Pizza();
        pizza.setName(name);
        pizza.setPrice(price);
        try {
            pizzaService.create(pizza);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // send a redirect to refresh the page
        resp.sendRedirect(req.getRequestURI());
    }
}
