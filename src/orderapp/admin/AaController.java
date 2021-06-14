/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderapp.admin;

import orderapp.admin.orders;
import orderapp.admin.products;
import orderapp.admin.DBconnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class AaController implements Initializable {

    @FXML
    private TextField AddProduct_Name;
    @FXML
    private TextField AddProduct_Pricce;
    @FXML
    private TextField AddProduct_Quntity;
    @FXML
    private TextArea AddProduct_Dwscription;
    @FXML
    private ComboBox<String> AddProduct_Category;
    @FXML
    private Button AddProduct_ButtonAdd;
    @FXML
    private TextField EditProduct_id;
    @FXML
    private TextField EditProduct_Name;
    @FXML
    private TextField EditProduct_Pricce;
    @FXML
    private TextField EditProduct_Quntity;
    @FXML
    private TextArea EditProduct_Dwscription;
    @FXML
    private ComboBox<String> EditProduct_Category;
    @FXML
    private Button SditProduct_ButtonEdit;
    @FXML
    private TextField ManageProd_Delete;
    @FXML
    private Button ManageProduct_ButtonDelete;

    @FXML
    private TableView<products> ManageProductTableView;
    @FXML
    private TableColumn<products, Integer> id_view;
    @FXML
    private TableColumn<products, String> name_view;
    @FXML
    private TableColumn<products, String> category_view;
    @FXML
    private TableColumn<products, Double> price_view;
    @FXML
    private TableColumn<products, Integer> quentity_view;
    @FXML
    private TableColumn<products, String> description_view;
    @FXML
    private Label ManageProduct_labelBox;
    @FXML
    private TextField ManageProduct_box;
    @FXML
    private TableView<products> ManageProductTableSearch;
    @FXML
    private TableColumn<products, Integer> id_search;
    @FXML
    private TableColumn<products, String> name_search;
    @FXML
    private TableColumn<products, String> category_search;
    @FXML
    private TableColumn<products, Double> price_search;
    @FXML
    private TableColumn<products, Integer> quentity_search;
    @FXML
    private TableColumn<products, String> description_search;
    @FXML
    private Button ManageProduct_ButtonSearch;
    @FXML
    private TableView<user> ManageClient_Table;
    @FXML
    private TableColumn<user, Integer> ManageClient_IdView;
    @FXML
    private TableColumn<user, String> ManageClient_NameView;
    @FXML
    private TableColumn<user, String> ManageClient_EmailView;
    @FXML
    private TableColumn<user, String> ManageClient_MobileView;
    @FXML
    private TableColumn<user, String> ManageClient_PasswordView;
    @FXML
    private TableColumn<user, String> Role_view;
    @FXML
    private TextField ManageClient_Delete;
    @FXML
    private Button ManageClient_ButtonDelete;
    @FXML
    private Label ManageClient_labelBox;
    @FXML
    private TextField ManageClient_box;
    @FXML
    private TableView<user> ManageClient_TableSearch;

    @FXML
    private TableColumn<user, Integer> ManageClient_IdSearch;
    @FXML
    private TableColumn<user, String> ManageClient_NameSearch;
    @FXML
    private TableColumn<user, String> ManageClient_EmailSearch;
    @FXML
    private TableColumn<user, String> ManageClient_MobileSearch;
    @FXML
    private TableColumn<user, String> ManageClient_PasswordSearch;

    @FXML
    private TableColumn<user, String> ManageClient_roleSearch;
    @FXML
    private Button ManageCluent_ButtonSearch;
    @FXML
    private Button ViewOrder_button;
    @FXML
    private TableView<orders> ManageOrders_TabelView;
    @FXML
    private TableColumn<?, ?> ManageOrders_IdView;
    @FXML
    private TableColumn<?, ?> ManageOrders_ProductView;
    @FXML
    private TableColumn<?, ?> ManageOrders_UserView;
    @FXML
    private TableColumn<?, ?> ManageOrders_QuantityView;
    @FXML
    private TableColumn<?, ?> ManageOrders_DateView;
    @FXML
    private Label ManageProduct_labelBox1;
    @FXML
    private TextField ManageOrders_Search;
    @FXML
    private Button ManageOrders_ButtonSearch;
    @FXML
    private TableView<orders> ManageOrders_TabelSearch;
    @FXML
    private TableColumn<?, ?> ManageOrders_IdSearch;
    @FXML
    private TableColumn<?, ?> ManageOrders_ProductSearch;
    @FXML
    private TableColumn<?, ?> ManageOrders_UserSearch;
    @FXML
    private TableColumn<?, ?> ManageOrders_QuantitySearch;
    @FXML
    private TableColumn<?, ?> ManageOrders_DateSearch;
    @FXML
    private ComboBox<Integer> ManageOrder_comboUsers;
    @FXML
    private ComboBox<Integer> ManageOrder_comboProdct;
    @FXML
    private TextField ManageOrder_AddQuentity;
    @FXML
    private DatePicker ManageOrder_AddDate;
    @FXML
    private Button ManageOrder_ButtonAdd;
    @FXML
    private Button Button_Generate;
    @FXML
    private Label Label_Generate;
    @FXML
    private TextField ManageInvoices_delete;
    @FXML
    private Button ManageInvoices_ButtonDelete;
   
    @FXML
    private Button ViewInvoices_buttonRefresh;
     @FXML
    private TableView<Invoices> ManageInvoices_View;
    @FXML
    private TableColumn<Invoices, Integer> ManageInvoices_IdView;
    @FXML
    private TableColumn<Invoices, Integer> ManageInvoices_OrderView;
    @FXML
    private TableColumn<Invoices, Double> ManageInvoices_TotalView;
    @FXML
    private TableColumn<Invoices, String> ManageInvoices_DateView;
    @FXML
    private Label ManageClient_labelBox1;
    @FXML
    private TextField ManageInvoices_Search;
    @FXML
    private Button ManageInvoices_ButtonSearch;
    @FXML
    private TableView<Invoices> ManageInvoices_SearchTabel;
    @FXML
    private TableColumn<Invoices, Integer> ManageInvoices_IdSearch;
    @FXML
    private TableColumn<Invoices, Integer> ManageInvoices_OrderSearch;
    @FXML
    private TableColumn<Invoices, Double> ManageInvoices_TotalSearch;
    @FXML
    private TableColumn<Invoices, String> ManageInvoices_DateSearch;
    @FXML
    private TextField Odd_Password;
    @FXML
    private TextField New_Password;
    @FXML
    private Button Button_ChangePassword;
  
    private TextField userid_changePassword;

    private TextField Confirm_Password;
    Statement statment;
    Connection connection = DBconnection.get_connection();
    ResultSet rs;
    private ObservableList<products> data;
    private ObservableList<user> data1;
    private ObservableList<products> data2;
    private ObservableList<user> data3;
        private ObservableList<orders> data4;
  private ObservableList<Invoices> data5;
 private ObservableList<Invoices> data6;
    PreparedStatement preparedStatement;

    /**
     * Initializes the controller class.
     */
    ObservableList<String> catList = FXCollections.observableArrayList("CASUAL CLOTHES", "EVENING DRESSES", "SPORT CLOTHES", "WOMEN ACCESSORIES", "");
    @FXML
    private Button ManageProduct_AddReset;
    @FXML
    private Button ManageProduct_EditReset;
    @FXML
    private Button ManageProduct_DeleteReset;
    @FXML
    private Button ManageProduct_ButtonRefresh;
    @FXML
    private Button ManageClient_ButtonRefresh;
    @FXML
    private Button ManageClient_DeleteReset;
    @FXML
    private Button ManageOrder_AddReset;
    @FXML
    private Button ManageInvoices_DeleteReset;
    @FXML
    private Button ChangePasswordReset;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        AddProduct_Category.setItems(catList);
        EditProduct_Category.setItems(catList);
        data = FXCollections.observableArrayList();
        data1 = FXCollections.observableArrayList();
        data2 = FXCollections.observableArrayList();
        data3 = FXCollections.observableArrayList();
        data4 = FXCollections.observableArrayList();
        data5 = FXCollections.observableArrayList();
         data6 = FXCollections.observableArrayList();

        Connection connection = DBconnection.get_connection();

        try {
            statment = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException ex) {
            Logger.getLogger(AaController.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
             ResultSet rs=this.statment.executeQuery("select id from users");
             while(rs.next()){
                 
                 ManageOrder_comboUsers.getItems().addAll(rs.getInt("id"));
                 
             }
        } catch (SQLException ex) {
            Logger.getLogger(AaController.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
             ResultSet rs=this.statment.executeQuery("select id from products");
             while(rs.next()){
                 
                 ManageOrder_comboProdct.getItems().addAll(rs.getInt("id"));
                 
             }
        } catch (SQLException ex) {
            Logger.getLogger(AaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        loadfromdatabase();
        loadfromdatabaseUser();
        loadfromdatabaseSEARCH();
        loadfromdatabaseUserSearch();
        loadfromdatabaseOrder();
         loadfromdatabaseInvoiesView();
        id_view.setCellValueFactory(new PropertyValueFactory<>("id"));
        name_view.setCellValueFactory(new PropertyValueFactory<>("name"));
        category_view.setCellValueFactory(new PropertyValueFactory<>("category"));
        price_view.setCellValueFactory(new PropertyValueFactory<>("price"));
        quentity_view.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        description_view.setCellValueFactory(new PropertyValueFactory<>("description"));

        ManageClient_IdView.setCellValueFactory(new PropertyValueFactory<>("id"));
        ManageClient_NameView.setCellValueFactory(new PropertyValueFactory<>("name"));
        ManageClient_EmailView.setCellValueFactory(new PropertyValueFactory<>("email"));
        ManageClient_MobileView.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        ManageClient_PasswordView.setCellValueFactory(new PropertyValueFactory<>("password"));
        Role_view.setCellValueFactory(new PropertyValueFactory<>("role"));

        id_search.setCellValueFactory(new PropertyValueFactory<>("id"));
        name_search.setCellValueFactory(new PropertyValueFactory<>("name"));
        category_search.setCellValueFactory(new PropertyValueFactory<>("category"));
        price_search.setCellValueFactory(new PropertyValueFactory<>("price"));
        quentity_search.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        description_search.setCellValueFactory(new PropertyValueFactory<>("description"));

        ManageClient_IdSearch.setCellValueFactory(new PropertyValueFactory<>("id"));
        ManageClient_NameSearch.setCellValueFactory(new PropertyValueFactory<>("name"));
        ManageClient_EmailSearch.setCellValueFactory(new PropertyValueFactory<>("email"));
        ManageClient_MobileSearch.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        ManageClient_PasswordSearch.setCellValueFactory(new PropertyValueFactory<>("password"));
        ManageClient_roleSearch.setCellValueFactory(new PropertyValueFactory<>("role"));
        
        
        
        ManageOrders_IdView.setCellValueFactory(new PropertyValueFactory<>("id"));
        ManageOrders_UserView.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        ManageOrders_ProductView.setCellValueFactory(new PropertyValueFactory<>("product_id"));
        ManageOrders_QuantityView.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        ManageOrders_DateView.setCellValueFactory(new PropertyValueFactory<>("date"));
       
         
        ManageOrders_IdSearch.setCellValueFactory(new PropertyValueFactory<>("id"));
        ManageOrders_UserSearch.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        ManageOrders_ProductSearch.setCellValueFactory(new PropertyValueFactory<>("product_id"));
        ManageOrders_QuantitySearch.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        ManageOrders_DateSearch.setCellValueFactory(new PropertyValueFactory<>("date"));
       
        
        ManageInvoices_IdView.setCellValueFactory(new PropertyValueFactory<>("id"));
        ManageInvoices_OrderView.setCellValueFactory(new PropertyValueFactory<>("order_id"));
        ManageInvoices_TotalView.setCellValueFactory(new PropertyValueFactory<>("total_price"));
        ManageInvoices_DateView.setCellValueFactory(new PropertyValueFactory<>("date"));
       
        
         ManageInvoices_IdSearch.setCellValueFactory(new PropertyValueFactory<>("id"));
        ManageInvoices_OrderSearch.setCellValueFactory(new PropertyValueFactory<>("order_id"));
        ManageInvoices_TotalSearch.setCellValueFactory(new PropertyValueFactory<>("total_price"));
        ManageInvoices_DateSearch.setCellValueFactory(new PropertyValueFactory<>("date"));
       
        
        
        
    }

    public void loadfromdatabase() {
        try {
            preparedStatement = connection.prepareStatement("select * from products");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                data.add(new products(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getString(6)));

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        ManageProductTableView.setItems(data);
    }

    public void loadfromdatabaseUser() {
        try {
            preparedStatement = connection.prepareStatement("select * from users");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                //data.add(new user(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString() ,rs.getString(),rs.getString() ));
                data1.add(new user(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(5)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(AaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ManageClient_Table.setItems(data1);
        // ManageClient_TableSearch.setItems(data1);
    }

    public void loadfromdatabaseUserSearch() {
        try {
            preparedStatement = connection.prepareStatement("select * from users");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                //data.add(new user(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString() ,rs.getString(),rs.getString() ));
                data3.add(new user(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(5)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(AaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // ManageClient_Table.setItems(data1);
        ManageClient_TableSearch.setItems(data3);
    }

    
    
    public void loadfromdatabaseSEARCH() {
        try {
            preparedStatement = connection.prepareStatement("select * from products");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                data2.add(new products(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getString(6)));

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        ManageProductTableSearch.setItems(data2);
    }
      public void loadfromdatabaseOrder() {
        try {
            preparedStatement = connection.prepareStatement("select * from orders");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                data4.add(new orders(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4), rs.getString(5)));

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        ManageOrders_TabelView.setItems(data4);
    }
      
      
        public void loadfromdatabaseInvoiesView() {
        try {
            preparedStatement = connection.prepareStatement("select * from invoices");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                //data.add(new user(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString() ,rs.getString(),rs.getString() ));
                data5.add(new Invoices(rs.getInt(1), rs.getInt(1), rs.getDouble(3), rs.getString(4)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(AaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // ManageClient_Table.setItems(data1);
        ManageInvoices_View.setItems(data5);
    }
        
         public void loadfromdatabaseInvoiesSearch() {
        try {
            preparedStatement = connection.prepareStatement("select * from invoices");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                //data.add(new user(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString() ,rs.getString(),rs.getString() ));
                data6.add(new Invoices(rs.getInt(1), rs.getInt(1), rs.getDouble(3), rs.getString(4)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(AaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // ManageClient_Table.setItems(data1);
        ManageInvoices_SearchTabel.setItems(data6);
    }
        
        

    @FXML
    private void AddProduct_ButtonAdd(ActionEvent event) {
        String AddProduct_Name1 = AddProduct_Name.getText();
        String AddProduct_Pricce1 = AddProduct_Pricce.getText();
        String AddProduct_Quntity1 = AddProduct_Quntity.getText();
        String AddProduct_Dwscription1 = AddProduct_Dwscription.getText();
        String AddProduct_Category1 = AddProduct_Category.getValue();

        if (validate_input(AddProduct_Name1) && validate_input(AddProduct_Pricce1) && validate_input(AddProduct_Dwscription1) && validate_input(AddProduct_Category1)
                && validate_numeric_val(AddProduct_Quntity1) && validate_input(AddProduct_Pricce1)) {
            try {
                String sql = "INSERT INTO products(name,category,price,quantity,description) VALUES('" + AddProduct_Name1 + "', '" + AddProduct_Category1 + "', '" + AddProduct_Pricce1 + "', '" + AddProduct_Quntity1 + "', '" + AddProduct_Dwscription1 + "')";
                int executeUpdate = statment.executeUpdate(sql);
                if (executeUpdate > 0) {
                    clear_data();
                }
                System.out.println("affected rows : " + executeUpdate);
            } catch (SQLException ex) {
                Logger.getLogger(AaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    private void AddProduct_ButtonEdit(ActionEvent event) throws SQLException {
        try {
            String idEdit = EditProduct_id.getText();
            String nameEdit = EditProduct_Name.getText();
            String catEdit = EditProduct_Category.getValue();
            String priceEdit = EditProduct_Pricce.getText();
            String quenEdit = EditProduct_Quntity.getText();
            String desEdit = EditProduct_Dwscription.getText();
            String sql5 = "update products set id='" + idEdit + "',name='" + nameEdit + "',category='" + catEdit + "',price='" + priceEdit + "',quantity='" + quenEdit + "',description= '" + desEdit + "' where id='" + idEdit + "' ";
            //  rs=this.statment.executeQuery(sql5);
            preparedStatement = connection.prepareStatement(sql5);
            preparedStatement.execute();
            System.out.println("update");

        } catch (Exception e) {
            System.out.println(e);

        }

//        
//      String ID="";
//      while(rs.next()){
//          ID=rs.getString("idEdit");
//          
//      }
//      if(ID.equals("")){
//          JOptionPane.showMessageDialog(null, "INVALID ID");
//
//      }else{
//          String productid="select id from products where name ='"+nameEdit+"'";
//          ResultSet rs1=this.statment.executeQuery(productid);
//          System.out.println(productid);
//          String x="";
//          while(rs1.next()){
//              x=rs1.getString("idEdit");
//          }
//          String sql3="update products set id='"+idEdit+"',name='"+nameEdit"',category='"+catEdit+"',price='"+priceEdit+"',quantity='"+quenEdit+"',description= '"+desEdit+"' where id='"+idEdit+"' ";
//      }
//      
//        
    }

    @FXML
    private void ManageProduct_ButtonDelete(ActionEvent event) {
        String id1 = ManageProd_Delete.getText();
        if (validate_input(id1) && validate_numeric_val(id1)) {
            String sql = "delete from products where id='" + id1 + "'";
            try {
                this.statment.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Delete Sucessfuly");
            } catch (SQLException ex) {
                Logger.getLogger(AaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Valid ID");

        }

    }

    @FXML
    private void ManageProduct_ButtonSearch(ActionEvent event) throws SQLException {
        ManageProductTableSearch.getItems()
                .clear();
        String category = ManageProduct_box.getText();

        if (validate_input(category)) {
            String sql = "select * from products where category = '" + category + "'";
            ResultSet rs = this.statment.executeQuery(sql);
            ArrayList arraylist = new ArrayList<products>();

            products r = new products();
            try {
                while (rs.next()) {

                    r.setId(rs.getInt("id"));
                    r.setName(rs.getString("name"));
                    r.setCategory(rs.getString("category"));
                    r.setQuantity(rs.getInt("quantity"));
                    r.setPrice(rs.getDouble("price"));
                    r.setDescription(rs.getString("description"));

                }

            } catch (SQLException ex) {
                Logger.getLogger(AaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            ManageProductTableSearch.getItems().addAll(r);

        } else {
            JOptionPane.showMessageDialog(null, "Valid Category");

        }
    }

    @FXML
    private void ManageClient_ButtonDelete(ActionEvent event) {
        String deleteUser = ManageClient_Delete.getText();
        if (validate_input(deleteUser) && validate_numeric_val(deleteUser)) {
            String sql = "delete from users where id='" + deleteUser + "'";
            try {
                this.statment.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Delete Sucessfuly");
            } catch (SQLException ex) {
                Logger.getLogger(AaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Valid ID");

        }

    }

    @FXML
    private void ManageCluent_ButtonSearch(ActionEvent event) {
        ManageClient_TableSearch.getItems().clear();

        String ID = ManageClient_box.getText();

        if (validate_input(ID)) {
            String sql = "select * from users where id = '" + ID + "'";
        ArrayList<user> users_list=new ArrayList<>();

            try {
                ResultSet rs = this.statment.executeQuery(sql);

                while (rs.next()) {

//                    USER.setId(rs.getInt("id"));
//                    USER.setName(rs.getString("name"));
//                    USER.setEmail(rs.getString("email"));
//                    USER.setMobile(rs.getString("mobile"));
//                    USER.setPassword(rs.getString("password"));
//                    USER.setRole(rs.getString("role"));

                     user user=new user(rs.getInt("id"), rs.getString("name"),rs.getString("email"), rs.getString("mobile"),rs.getString("password"),rs.getString("role"));
              users_list.add(user);
        }
        ManageClient_TableSearch.getItems().setAll(users_list);
                }

             catch (SQLException ex) {
                Logger.getLogger(AaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Valid Category");

        }

    }
   
    @FXML
    private void ViewOrder_button(ActionEvent event) throws SQLException {
         String sql="select * from orders";
        ResultSet rs = statment.executeQuery(sql);
        ArrayList<orders> users_list=new ArrayList<>();
        while(rs.next()){
            orders user=new orders(rs.getInt("id"), rs.getInt("product_id"),rs.getInt("user_id"), rs.getInt("quantity"), rs.getString("date"));
            users_list.add(user);
        }
        ManageOrders_TabelView.getItems().setAll(users_list);
    }
    

    @FXML
    private void ManageOrders_ButtonSearch(ActionEvent event) throws SQLException {
        
         ManageOrders_TabelSearch.getItems().clear();
        String userID = ManageOrders_Search.getText();

        if (validate_input(userID) && validate_numeric_val(userID)) {
            String sql = "select * from orders where user_id = '" +userID+ "'";
            ResultSet rs = this.statment.executeQuery(sql);
            orders r = new orders();
                    ArrayList<orders> users_list=new ArrayList<>();

            try {
                while (rs.next()) {
//
//                    r.setId(rs.getInt("id"));
//                    r.setProduct_id(rs.getInt("product_id"));
//                    r.setUser_id(rs.getInt("user_id"));
//                    r.setQuantity(rs.getInt("quantity"));
//                    r.setDate(rs.getString("date"));
            orders user=new orders(rs.getInt("id"), rs.getInt("product_id"),rs.getInt("user_id"), rs.getInt("quantity"), rs.getString("date"));
            users_list.add(user);
                }
             ManageOrders_TabelSearch.getItems().setAll(users_list);


            } catch (SQLException ex) {
                Logger.getLogger(AaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        //    ManageOrders_TabelSearch.getItems().addAll(r);

        } else {
            JOptionPane.showMessageDialog(null, "Valid Category");

        }
    }

    @FXML
    private void ManageOrder_comboUsers(ActionEvent event) throws SQLException {
         
    }

    @FXML
    private void ManageOrder_comboProdct(ActionEvent event) {
    }

    @FXML
    private void ManageOrder_ButtonAdd(ActionEvent event) {
       int com1= ManageOrder_comboUsers.getValue();
        int com2=ManageOrder_comboProdct.getValue();
        String quentity=ManageOrder_AddQuentity.getText();
        LocalDate date=ManageOrder_AddDate.getValue();
        
        if(validate_input(quentity) && validate_numeric_val(quentity)  ){
          try {
                String sql = "INSERT INTO orders(product_id,user_id,quantity,date) VALUES('" + com2 + "', '" + com1 + "', '" + quentity + "', '" + date + "')";
                int executeUpdate = statment.executeUpdate(sql);
                if (executeUpdate > 0) {
                    clear_data();
                }
                System.out.println("affected rows : " + executeUpdate);
            } catch (SQLException ex) {
                Logger.getLogger(AaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else {
            JOptionPane.showMessageDialog(null, "Enter correct data");

    }
    }
    
    @FXML
    private void  ViewInvoices_buttonRefresh(ActionEvent event) throws SQLException {
        String sql="select * from invoices";
        ResultSet rs = statment.executeQuery(sql);
        ArrayList<Invoices> users_list=new ArrayList<>();
        while(rs.next()){
            Invoices inv=new Invoices(rs.getInt("id"), rs.getInt("order_id"),rs.getDouble("total_price"), rs.getString("date"));
            users_list.add(inv);
        }
        ManageInvoices_View.getItems().setAll(users_list);
        
   
    } 
      @FXML
        private void ManageInvoices_ButtonDelete (ActionEvent event) { 
             String deleteUser = ManageInvoices_delete.getText();
        if (validate_input(deleteUser) && validate_numeric_val(deleteUser)) {
            String sql = "delete from invoices where id='" + deleteUser + "'";
            try {
                this.statment.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Delete Sucessfuly");
            } catch (SQLException ex) {
                Logger.getLogger(AaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Valid ID");

        }
    
        
    }
    
    @FXML
    private void ManageInvoices_ButtonSearch(ActionEvent event) {
          ManageInvoices_SearchTabel.getItems().clear();

        String ID = ManageInvoices_Search.getText();

        if (validate_input(ID)) {
            String sql = "select * from invoices where order_id = '" + ID + "'";
        ArrayList<Invoices> users_list=new ArrayList<>();

            try {
                ResultSet rs = this.statment.executeQuery(sql);

                while (rs.next()) {

//                    USER.setId(rs.getInt("id"));
//                    USER.setName(rs.getString("name"));
//                    USER.setEmail(rs.getString("email"));
//                    USER.setMobile(rs.getString("mobile"));
//                    USER.setPassword(rs.getString("password"));
//                    USER.setRole(rs.getString("role"));

            Invoices inv=new Invoices(rs.getInt("id"), rs.getInt("order_id"),rs.getDouble("total_price"), rs.getString("date"));
              users_list.add(inv);
        }
        ManageInvoices_SearchTabel.getItems().setAll(users_list);
                }

             catch (SQLException ex) {
                Logger.getLogger(AaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Valid Category");

        }

        
        
        
        
    }
    
    
    
    

    @FXML
    private void Button_ChangePassword(ActionEvent event) throws SQLException {
        String idUser = userid_changePassword.getText();
        String old = Odd_Password.getText();
        String newPass = New_Password.getText();
        String confirm = Confirm_Password.getText();
        if (validate_input(old) && validate_input(newPass) && validate_input(idUser) && validate_numeric_val(idUser)) {
            if (newPass.equals(confirm)) {
                preparedStatement = connection.prepareStatement("select * from users where id=? and password=?");
                preparedStatement.setString(1, idUser);
                preparedStatement.setString(2, old);
                rs = preparedStatement.executeQuery();
                rs.next();
                int c = rs.getInt(1);

                if (c > 0) {
                    preparedStatement = connection.prepareStatement("update users set password=? where id=?");
                    preparedStatement.setString(1, newPass);
                    preparedStatement.setString(2, idUser);
                    JOptionPane.showMessageDialog(null, "password changed successfully");

                }

            } else {
                JOptionPane.showMessageDialog(null, "New password & confirm password does not match");

            }
//               String sql2="update users set password='"+newPass+"' where id='"+idUser+"' ";
//              
//              int executeUpdate;
//            try {
//                   String sql;
//                executeUpdate = statment.executeUpdate(sql);
//                 if(executeUpdate>0)    {   
//                     
//                     System.out.println("affected rows : "+executeUpdate);
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(AaController.class.getName()).log(Level.SEVERE, null, ex);
//            }

        }
    }

    private boolean validate_input(String input) {
        return !input.equals("");
    }

    private boolean validate_numeric_val(String input) {
        if (validate_input(input)) {
            try {
                Integer.parseInt(input);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }

    private void clear_data() {
        AddProduct_Name.setText("");
        AddProduct_Pricce.setText("");
        AddProduct_Quntity.setText("");
        AddProduct_Dwscription.setText("");
        AddProduct_Category.setValue("");

    }

    @FXML
    private void ManageProduct_AddReset(ActionEvent event) {
    }

    @FXML
    private void ManageProduct_EditReset(ActionEvent event) {
    }

    @FXML
    private void ManageProduct_DeleteReset(ActionEvent event) {
    }

    @FXML
    private void ManageProduct_ButtonRefresh(ActionEvent event) {
    }

    @FXML
    private void ManageClient_ButtonRefresh(ActionEvent event) {
    }

    @FXML
    private void ManageClient_DeleteReset(ActionEvent event) {
    }

    @FXML
    private void ManageOrder_AddReset(ActionEvent event) {
    }

    @FXML
    private void ManageInvoices_DeleteReset(ActionEvent event) {
    }

    @FXML
    private void ChangePasswordReset(ActionEvent event) {
    }

}
