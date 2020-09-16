package ch.ti8m.azubi.kti.pizzashop.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Order {

    private Integer id;
    private List<PizzaOrdering> pizzaOrder;
    private Date date;
    private String phone;
    private String address;

    public Order(){
    }

    public Order(Integer id, List<PizzaOrdering> pizzaOrder, Date date, String phone, String address) {
        this.date = date;
        this.phone = phone;
        this.address = address;
        this.id = id;
        this.pizzaOrder = pizzaOrder;
    }
    public Order(List<PizzaOrdering> pizzaOrder, Date date, String phone, String address) {
        this.date = date;
        this.phone = phone;
        this.address = address;
        this.pizzaOrder = pizzaOrder;
    }
    public Order(List<PizzaOrdering> pizzaOrder, String phone, String address) {
        this.phone = phone;
        this.address = address;
        this.pizzaOrder = pizzaOrder;
        this.date = getCurrentDate();
    }

    public Date getCurrentDate(){
        //calculates currrent time but in String
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));

        //converts String to Date
        String sDate1=dtf.format(now);
        Date date1= null;
        try {
            date1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(sDate1);
            dtf.parse(sDate1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(sDate1+"\t"+date1);
        return date1;
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
