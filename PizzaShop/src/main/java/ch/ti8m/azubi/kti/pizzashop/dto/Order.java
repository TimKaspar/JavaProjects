package ch.ti8m.azubi.kti.pizzashop.dto;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Order {

    private Integer id;
    private List<PizzaOrdering> pizzaOrder;
    private Date date;
    private String phone;
    private String address;
    private double total;

    public Order(){
    }

    public Order(Integer id, List<PizzaOrdering> pizzaOrder, Date date, String phone, String address) {
        this.date = date;
        this.phone = phone;
        this.address = address;
        this.id = id;
        this.pizzaOrder = pizzaOrder;
        calculateTotal();
    }
    public Order(List<PizzaOrdering> pizzaOrder, Date date, String phone, String address) {
        this.date = date;
        this.phone = phone;
        this.address = address;
        this.pizzaOrder = pizzaOrder;
        calculateTotal();
    }
    public Order(List<PizzaOrdering> pizzaOrder, String phone, String address) {
        this.phone = phone;
        this.address = address;
        this.pizzaOrder = pizzaOrder;
        this.date = getLocalDate();
        calculateTotal();
    }

    public Date getLocalDate() {
        return Date.valueOf(LocalDateTime.now().toLocalDate().toString());
    }

    public double calculateTotal(){
        double totalPrice= 0;
        for (PizzaOrdering pizzaOrder : pizzaOrder){
            totalPrice += pizzaOrder.getAmount() * pizzaOrder.getPizza().getPrice();
        }
        this.total = totalPrice;
        return totalPrice;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<PizzaOrdering> getPizzaOrder() {
        return pizzaOrder;
    }

    public void setPizzaOrder(List<PizzaOrdering> order) {
        this.pizzaOrder = order;
    }

    @Override
    public String toString() {
        return "Order{" +"\n"+
                "id=" + id +"\n"+
                "pizzaOrder=" + pizzaOrder +"\n"+
                "date=" + date +"\n"+
                "phone='" + phone + "\n"+
                "address='" + address + "\n"+
                "   total=" + total +"\n"+
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (id == null) {
            return false;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass(), id);
    }
}
