package ch.ti8m.azubi.kti.pizzashop.web;

import ch.ti8m.azubi.kti.pizzashop.dto.Pizza;
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
 * Pizza servlet
 */
@WebServlet("/pizza")
public class PizzaServlet extends HttpServlet {
    private PizzaService pizzaService;
    private Template template;

    @Override
    public void init() throws ServletException {
        pizzaService = ServiceRegistry.getInstance().get(PizzaService.class);
        template = new FreemarkerConfig().loadTemplate("pizza.ftl");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Pizza> pizzas = null;
        try {
            pizzas = pizzaService.list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        PrintWriter writer = resp.getWriter();
        Map<String, Object> model = new HashMap<>();
        model.put("pizzas", pizzas);

        try {
            template.process(model, writer);
        } catch (TemplateException ex) {
            throw new IOException("Could not process template: " + ex.getMessage());
        }
    }

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
