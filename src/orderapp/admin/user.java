/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderapp.admin;

/**
 *
 * @author pc
 */
public class user {
    public int id;
    public String name;
     public String email;
      public String password;
    public String mobile;
    public String role;

    user() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "user{" + "id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", mobile=" + mobile + ", role=" + role + '}';
    }

 
    

    public user(int id, String name, String email, String mobile,String password, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
         this.password=password;
        this.role = role;
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
}
