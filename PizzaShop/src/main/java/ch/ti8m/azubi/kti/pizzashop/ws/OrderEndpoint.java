package ch.ti8m.azubi.kti.pizzashop.ws;

import ch.ti8m.azubi.kti.pizzashop.dto.Order;
import ch.ti8m.azubi.kti.pizzashop.dto.PizzaOrdering;
import ch.ti8m.azubi.kti.pizzashop.service.OrderService;
import ch.ti8m.azubi.kti.pizzashop.service.ServiceRegistry;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/order")
public class OrderEndpoint {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> listOrders() throws Exception {
        return orderService().list();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Order getOrder(@PathParam("id") int id) throws Exception {
        return orderService().get(id);
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Order createOrder(List<PizzaOrdering> pizzaOrder, String phone, String address) throws Exception {
        Order order = new Order();
        order.setPizzaOrder(pizzaOrder);
        order.setDate(order.getCurrentDate());
        order.setPhone(phone);
        order.setAddress(address);
        return orderService().create(order);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateOrder(@PathParam("id") int id, Order order) throws Exception {
        order.setId(id);
        orderService().update(order);
    }

    @DELETE
    @Path("/{id}")
    public void deleteOrder(@PathParam("id") int id) throws Exception {
        orderService().remove(id);
    }

    private OrderService orderService() {
        return ServiceRegistry.getInstance().get(OrderService.class);
    }

}

