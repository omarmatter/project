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
public class orders {
    public int id;
    public int product_id ;
    public int user_id;
    public int quantity;
    public String date;

    public orders(int id, int product_id, int user_id, int quantity, String date) {
        this.id = id;
        this.product_id = product_id;
        this.user_id = user_id;
        this.quantity = quantity;
        this.date = date;
    }

    orders() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "orders{" + "id=" + id + ", product_id=" + product_id + ", user_id=" + user_id + ", quantity=" + quantity + ", date=" + date + '}';
    }
    
    
}
