/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author pc
 */
public class Invoices {
    public int id;
    public int order_id;
    public double total_price;
    public String date;

    public Invoices(int id, int order_id, double total_price, String date) {
        this.id = id;
        this.order_id = order_id;
        this.total_price = total_price;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Invoices{" + "id=" + id + ", order_id=" + order_id + ", total_price=" + total_price + ", date=" + date + '}';
    }
    
}
