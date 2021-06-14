/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafxapplication30.product;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class ProjController implements Initializable  {

    @FXML
    private ComboBox<String>  combobox;
    @FXML
    private TextField quantitytf;
    @FXML
    private DatePicker datetf;
    @FXML
    private Button addtf;
    @FXML
    private TextField productidfield;
    @FXML
    private Button deletebtn;
    @FXML
    private TextField quantityfield;
    @FXML
    private DatePicker datefield;
    @FXML
    private TableView<order> viewtable;
    @FXML
    private TableColumn<product, Integer> productidcolumn;
    @FXML
    private TableColumn<order, String> datecolumn;
    @FXML
    private TableView<order> searchtable;
    @FXML
    private TableView<client> viewprofile;
    @FXML
    private TableColumn<client,String> namecolumn;
    @FXML
    private TableColumn<client, String> emailcolumn;
    @FXML
    private TableColumn<client, String> mobilecolumn;
    @FXML
    private TextField namefield;
    @FXML
    private TextField emailfield;
    @FXML
    private TextField mobilefield;
    @FXML
    private TextField oldpassword;
    @FXML
    private TextField newpassword;
    @FXML
    private Button cahngepasswordbtn;
    @FXML
    private TableView<invoice> invoicestable;
    @FXML
    private ComboBox<String> combobox2;
    @FXML
    private Button editbtn1;
    @FXML
    private TableColumn<order, String> quantityfield2;
    @FXML
    private TableColumn<order, Integer> useridcolumn2;
    @FXML
    private TableColumn<order, Integer> IDcolumn3;
    @FXML
    private TableColumn<order, Integer> peoductidcolumn3;
    @FXML
    private TableColumn<order, String> quantitycolumn3;
    @FXML
    private TableColumn<order, String> datecolumn3;
    @FXML
    private TableColumn<order, Integer> useridcolumn3;
    @FXML
    private Button editbtn2;
    @FXML
    private TableColumn<invoice, Integer> idcolumn2;
    @FXML
    private TableColumn<invoice, Integer> orderidcolumn2;
    @FXML
    private TableColumn<invoice, Double> totalpricacolumn2;
    @FXML
    private TableColumn<invoice, String> datecolumn2;

    Statement statement;
    @FXML
    private Button searchbtn;
    @FXML
    private TextField searchid;
    @FXML
    private TextField ordridtf;
    @FXML
    private Button displaybutton;
    @FXML
    private Button dbtn;
    @FXML
    private TableColumn<?, ?> orderidcoulmn;
    @FXML
    private Button viewbtn;
    @FXML
    private Button resetbtn;
    @FXML
    private Button resetbtn2;
    @FXML
    private Button resetbtn3;
    @FXML
    private Button resetbtn4;
    @FXML
    private Button resetbtn5;
    @FXML
    private Button logoutbtn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {


  try {
            statement =(Statement) DB.get_connection().createStatement();
        } 
  
      catch (SQLException ex) {
            System.out.println(ex.toString());
        }
  
  
        try {
            
            ResultSet rs = this.statement.executeQuery("select name from products");
            
            while(rs.next()){
                combobox.getItems().addAll(rs.getString("name"));
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProjController.class.getName()).log(Level.SEVERE, null, ex);
        }
   try {
            
            ResultSet rs = this.statement.executeQuery("select name from products");
            
            while(rs.next()){
                combobox2.getItems().addAll(rs.getString("name"));
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProjController.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    // tableview for search for order
      IDcolumn3.setCellValueFactory(new PropertyValueFactory("id"));
      peoductidcolumn3.setCellValueFactory(new PropertyValueFactory("product_id"));
      useridcolumn3.setCellValueFactory(new PropertyValueFactory("user_id"));      
      quantitycolumn3.setCellValueFactory(new PropertyValueFactory("quantity"));
      datecolumn3.setCellValueFactory(new PropertyValueFactory("date"));
      
 
      
      //tableview for invoices
      idcolumn2.setCellValueFactory(new PropertyValueFactory("id") );
      orderidcolumn2.setCellValueFactory(new PropertyValueFactory("order_id") );
      totalpricacolumn2.setCellValueFactory(new PropertyValueFactory("total_price"));
      datecolumn2.setCellValueFactory(new PropertyValueFactory("date") );
      
      
      
      //tableview for users
      namecolumn.setCellValueFactory(new PropertyValueFactory("name") );
      emailcolumn.setCellValueFactory(new PropertyValueFactory("email") );
      mobilecolumn.setCellValueFactory(new PropertyValueFactory("mobile"));
      
            
      
      //tableview for view order user
       orderidcoulmn.setCellValueFactory(new PropertyValueFactory("id"));
    productidcolumn.setCellValueFactory(new PropertyValueFactory("product_id"));
      useridcolumn2.setCellValueFactory(new PropertyValueFactory("user_id"));      
      quantityfield2.setCellValueFactory(new PropertyValueFactory("quantity"));
     datecolumn.setCellValueFactory(new PropertyValueFactory("date"));
      
    }    

    @FXML
    private void addproduct(ActionEvent event) throws SQLException {
       
       String combobox2 = combobox.getValue();
       String quantity = quantitytf.getText();
       LocalDate date = datetf.getValue();
       
       if(quantity.equals("")|| date.equals("") || combobox.getValue().equals("")){
         
           
           Alert alert = new Alert(AlertType.ERROR);
           alert.setHeaderText("empty form");
           alert.setContentText("fill data");
           alert.showAndWait();
           
       }
       
       else {
//        

   String sql1 = "select quantity from products where name = '" + combobox2 + "'" ;
 ResultSet qu=  this.statement.executeQuery(sql1);
        String q= "";
           while (qu.next()) {    
               
              q=qu.getString("quantity");
               
           }
           
          
           if((Integer.parseInt(q)>=Integer.parseInt(quantity)) && (Integer.parseInt(quantity)!=0) ){


           String productid = "select id from products where name = '" + combobox2+ "'";
                  ResultSet id=  this.statement.executeQuery(productid);
        String x= "";
           while (id.next()) {    
               
              x=id.getString("id");
               
           }
         
    String sql = "insert into orders(product_id , user_id , quantity , date ) values(" +x +",'" + LoginController.id + "','" + quantity + "','" +date +"') ";
    
      this.statement.executeUpdate(sql);
     
      
                 Integer newquantity = Integer.parseInt(q) - Integer.parseInt(quantity) ;
      
           String updatequantity = "update products set quantity = " + newquantity +" where id = '" + x + "'  ";
    
           this.statement.executeUpdate(updatequantity);
           
           
          Alert alert = new Alert(AlertType.CONFIRMATION);
             alert.setHeaderText("success");
             alert.setContentText("add successfuly");
             alert.showAndWait();
             
       
    
         }
           
          else {
             if(Integer.parseInt(quantity)==0){
         Alert alert = new Alert(AlertType.WARNING);
           alert.setHeaderText("invalid data");
           alert.setContentText("enter value greater than 0");
           alert.showAndWait();
                    
             } 
               
             if (Integer.parseInt(q)<Integer.parseInt(quantity)){
       Alert alert = new Alert(AlertType.WARNING);
           alert.setHeaderText("invalid data");
           alert.setContentText("enter a smaller value");
           alert.showAndWait();           
             }
            
               
               
           }          
           
       }
    }
    
      
    

    @FXML
    private void deleteproduct(ActionEvent event) throws SQLException {
        
        
        String id = productidfield.getText();
        
        if(id.equals("")){
       Alert alert = new Alert(AlertType.ERROR);
           
           alert.setHeaderText("empty field");
           alert.setContentText("fill data");
           alert.showAndWait();          
        }
        else {
        String sql = "DELETE FROM orders WHERE id ='"+ id +"'";
        
          this.statement.executeUpdate(sql);
                
          Alert alert = new Alert(AlertType.CONFIRMATION);
          alert.setHeaderText("");
          alert.setContentText("delete successfuly");
          alert.showAndWait();
        }
    }

    @FXML
    private void editproduct(ActionEvent event) throws SQLException {
   String cb = combobox2.getValue();
       String quantity = quantityfield.getText();
       LocalDate date = datefield.getValue();
       
       String id = ordridtf.getText();
     
      
     
           String sql = "select * from orders where id = '"+  id  +"' ";
           
           ResultSet rs = this.statement.executeQuery(sql);
           String ID = ""; 
           while(rs.next()){
               ID = rs.getString("id");
           }
          
           if(ID.equals("")){
            Alert alert = new Alert(AlertType.ERROR);
           
           alert.setHeaderText("invalid ID");
           alert.setContentText("enter existing ID");
           alert.showAndWait();                  
               
           }
           else {
               
          String productid = "select id from products where name = '" + cb+ "'";
                  ResultSet rs1=  this.statement.executeQuery(productid);
                  System.out.println(productid);
        String x= "";
           while (rs1.next()) {    
               x=rs1.getString("id");
               
           }
         
 String update =
         "Update orders Set product_id= " + x + ", user_id='" +LoginController.id + "', quantity='" + quantity + "', date = "+ date+ " Where id='"+ID+"'";
               System.out.println(update);
this.statement.executeUpdate(update);
            
              
           }
           
       }
        
     
        
    

    @FXML
    private void editprofile(ActionEvent event) throws SQLException {
        System.out.println(LoginController.id);
    String name = namefield.getText();
       String email = emailfield.getText();
       String mobile = mobilefield.getText();
       
    if(name.equals("")|| email.equals("") || mobile.equals("")){
     Alert alert = new Alert(AlertType.ERROR);
           
           alert.setHeaderText("invalid input");
           alert.setContentText("fill data");
           alert.showAndWait();           
        
    }
       
       
         
 String update =
    "Update users Set name= '" + name + "' , email= '" + email + "', mobile='" + mobile + "' Where id='"+LoginController.id+"'";
       this.statement.executeUpdate(update);
            
              
           }
                
        
        
        
    

    @FXML
    private void changepassword(ActionEvent event) throws NoSuchFieldException, SQLException {
       // System.out.print(LoginController.id);
        String newpass = newpassword.getText();
        String oldpass = oldpassword.getText();
        if(newpass.equals("")){
           Alert alert = new Alert(AlertType.ERROR);
           
          alert.setHeaderText("empty field");
   alert.setContentText("fill data");
          alert.showAndWait();                      
            
        }
        
        if (newpass.length()<7){
          Alert alert = new Alert(AlertType.WARNING);
           
           alert.setHeaderText("invalid field");
           alert.setContentText("password must be equal or more than 7 ");
           alert.showAndWait();    
        }
      
        else {
            String sql = "select password from users where id = '"+ LoginController.id  +"'";
            ResultSet rs = this.statement.executeQuery(sql);
            String op = "";
            while(rs.next()){
                op = rs.getString("password");
            }
            if(Integer.parseInt(op)== Integer.parseInt(oldpass)){
//        String sql = "select password  from users where id = '"+ LoginController.id +"'";   
//         ResultSet rs = this.statement.executeQuery(sql);
//         
//         String s = "";
//         while(rs.next()){
//             s = rs.getString("password");
//         }
////         
//         System.out.println("the password is :" + s);
         
         String change = "update users set password = '"+ newpass +"'where id ="+LoginController.id;
         statement.executeUpdate(change);
       
    }
            else {
          Alert alert = new Alert(AlertType.ERROR);
           
          alert.setHeaderText("wrong password");
   alert.setContentText("fill valid password ");
          alert.showAndWait();                      
                    
            }
    }
    }

    @FXML
    private void searchfororder(ActionEvent event) throws SQLException {
        
       String id = searchid.getText();
       
       if(id.equals("")){
  Alert alert = new Alert(AlertType.ERROR);
           
           alert.setHeaderText("empty form");
           alert.setContentText("fill data");
           alert.showAndWait();          
       }
       
       else {
           String sql = "select * from orders where id = '" + id +"' and user_id = '" + LoginController.id +"'";
           ResultSet rs = this.statement.executeQuery(sql);
           
          
           
           while(rs.next()){
               // ما بيعىض الاي دي 
               order r = new order();
               r.setId(rs.getInt("id"));
              r.setProduct_id(rs.getInt("product_id"));
              r.setUser_id(rs.getInt("user_id"));
              r.setQuantity(rs.getInt("quantity"));
              r.setDate(rs.getString("date"));
              
              searchtable.getItems().add(r);
           }
           
       }
    }

    @FXML
    private void display(ActionEvent event) throws SQLException {
        String sql = "select name , email , mobile from users where id = '" + LoginController.id+ "' ";
        ResultSet rs = this.statement.executeQuery(sql);
        
       while(rs.next()){
           client cl = new client();
           cl.setName(rs.getString("name"));
           cl.setEmail(rs.getString("email"));
           cl.setMobile(rs.getString("mobile"));
           
           
           viewprofile.getItems().add(cl);
           
           
           
       }        
    }

    @FXML
    private void dbtnbtn(ActionEvent event) throws SQLException {
        
        String sql = "select * from orders where user_id = '"+   LoginController.id +"'";
        ResultSet rs = this.statement.executeQuery(sql);
        
        
           while(rs.next()){
               order o1 = new order();

               o1.setId(rs.getInt("id"));
              o1.setProduct_id(rs.getInt("product_id"));
              o1.setUser_id(rs.getInt("user_id"));
              o1.setQuantity(rs.getInt("quantity"));
              o1.setDate(rs.getString("date"));

              
              viewtable.getItems().add(o1);

           }
    }

    @FXML
    private void viewinvoices(ActionEvent event) throws SQLException {
        invoicestable.getItems().clear();
        String sql = "select * from invoicses where order_id in(select id from orders where user_id = '"  + LoginController.id+ "' )";
        
        ResultSet rs = this.statement.executeQuery(sql);
        
        while(rs.next()){
            invoice in = new invoice();
            in.setId(rs.getInt("id"));
            in.setOrder_id(rs.getString("order_id"));
            in.setTotal_price(rs.getString("total_price"));
            in.setDate(rs.getString("date"));
            
            invoicestable.getItems().add(in);
        }
        
        
        
      
    }

    @FXML
    private void resetform(ActionEvent event) {
        
        combobox.setValue("");
        quantitytf.setText("");
        datetf.setValue(null);
    }

    @FXML
    private void resetID(ActionEvent event) {
        productidfield.setText("");
    }

    @FXML
    private void reseteditform(ActionEvent event) {
        ordridtf.setText("");
        combobox2.setValue("");
        quantityfield.setText("");
        datefield.setValue(null);
    }

    @FXML
    private void reseteditprofileform(ActionEvent event) {
        namefield.setText("");
        emailfield.setText("");
        mobilefield.setText("");
    }

    @FXML
    private void resethangepasswordform(ActionEvent event) {
    
    oldpassword.setText("");
    newpassword.setText("");
    
    
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
      //  System.exit(0);
        
       Stage stage = (Stage) logoutbtn.getScene().getWindow();
         
                    stage.close();
                    FXMLLoader loader=new FXMLLoader();      
                   TabPane root = FXMLLoader.load(getClass().getResource("login.fxml"));
                      Scene scene = new Scene(root);
                    Stage primaryStage = new Stage();
                    primaryStage.setScene(scene);
                    primaryStage.setTitle("client");
                    primaryStage.show();
    }
    
}
