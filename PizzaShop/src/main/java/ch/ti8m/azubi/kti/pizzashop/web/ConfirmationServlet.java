package ch.ti8m.azubi.kti.pizzashop.web;

import ch.ti8m.azubi.kti.pizzashop.dto.Order;
import ch.ti8m.azubi.kti.pizzashop.dto.Pizza;
import ch.ti8m.azubi.kti.pizzashop.dto.PizzaOrdering;
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
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * OrderID servlet
 */
@WebServlet("/confirmation")
public class ConfirmationServlet extends HttpServlet {
    private OrderService orderService;
    private PizzaService pizzaService;
    private Template template;

    @Override
    public void init() throws ServletException {
        orderService = ServiceRegistry.getInstance().get(OrderService.class);
        pizzaService = ServiceRegistry.getInstance().get(PizzaService.class);
        template = new FreemarkerConfig().loadTemplate("confirmation.ftl");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //        set Encoding to UTF-8
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        List<Order> orders;
        List<Pizza> pizzas;
        List<PizzaOrdering> pizzaOrderings;
        PrintWriter writer = resp.getWriter();
        Map<String, Object> model = new HashMap<>();
        int id = 0;

        try {
            orders = orderService.list();
            pizzas = pizzaService.list();
            for (Order order : orders) {
                id = order.getId();
            }
            pizzaOrderings = orderService.getPizzaOrderings(orderService.get(id));

            //Scale von Pizzen berechnen
            List<Integer> pricesScale = new LinkedList<>();
            for (Pizza pizza : pizzas){
                pricesScale.add(BigDecimal.valueOf(pizza.getPrice()).scale());
            }
            //Scale von Total
            Double total = 0.0;
            for (PizzaOrdering pizzaOrdering: pizzaOrderings){
               total += pizzaOrdering.getPizza().getPrice() * pizzaOrdering.getAmount();
            }
            Integer totalScale = BigDecimal.valueOf(total).scale();

            model.put("totalScale",totalScale);
            model.put("pricesScale", pricesScale);
            model.put("pizzaOrderings", pizzaOrderings);
            model.put("id", id);
            model.put("pizzas", pizzas);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            template.process(model, writer);
        } catch (TemplateException ex) {
            throw new IOException("Could not process template: " + ex.getMessage());
        }
    }
}
