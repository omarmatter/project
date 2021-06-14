/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderapp.client;

import orderapp.client.DB;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class LoginController implements Initializable {

    @FXML
    private TextField LoginEmail;
    @FXML
    private TextField LoginPassword;
    @FXML
    private Button LoginButton;
    @FXML
    private Button LoginSignUp;
      PreparedStatement pre;
      ResultSet res;
Stage dialogStage = new Stage();
    Scene scene;
    Stage stage = new Stage();
    Statement statment;
    Connection connection1 = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Statement statement;
    
    public  static int  id =0;
    @FXML
    private MenuItem close_item;
    @FXML
    private MenuItem background_item;
    @FXML
    private RadioMenuItem sz1;
    @FXML
    private RadioMenuItem sz2;
    @FXML
    private RadioMenuItem sz3;
    @FXML
    private RadioMenuItem ff1;
    @FXML
    private RadioMenuItem ff2;
    @FXML
    private RadioMenuItem ff3;
    @FXML
    private MenuItem fontcolor;
    @FXML
    private MenuItem About;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 Connection connection = DB.get_connection();
        try {
            statment = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
    }

    @FXML
    private void LoginButton(ActionEvent event) throws SQLException, IOException {
         System.out.println("enmail");            
          String email = LoginEmail.getText();
        String pass = LoginPassword.getText();
        if (validate_input(email) && validate_input(pass)  && validate_Email(email)) {
            
            String sql = "select id , email, password, role from users where email = '" + email + "' and Password = '" + pass + "'";
            ResultSet rs = statment.executeQuery(sql);
            if (!rs.next()) {
               
            JOptionPane.showMessageDialog(null, "Login Failed");
            
           LoginEmail.setText("");
           LoginPassword.setText("");
            } else  {
                if (rs.getString("role").equalsIgnoreCase("admin")) {
                    id= rs.getInt("id");
                    Stage stage = (Stage) LoginButton.getScene().getWindow();
                    stage.close();
                    FXMLLoader loader=new FXMLLoader(); 
                    System.out.println(getClass().getResource(""));
         TabPane root = FXMLLoader.load(getClass().getResource("/orderapp/aa.fxml"));
         
                Scene scene = new Scene(root);
                    Stage primaryStage = new Stage();
                primaryStage.setScene(scene);
                    primaryStage.setScene(scene);
                    primaryStage.setTitle("Admin");
                    primaryStage.show();
        
    }else if(rs.getString("role").equalsIgnoreCase("client")) {
           id= rs.getInt("id");
         Stage stage = (Stage) LoginButton.getScene().getWindow();
         
                    stage.close();
                    FXMLLoader loader=new FXMLLoader();      
                   TabPane root = FXMLLoader.load(getClass().getResource("proj.fxml"));
                      Scene scene = new Scene(root);
                    Stage primaryStage = new Stage();
                    primaryStage.setScene(scene);
                    primaryStage.setTitle("client");
                    primaryStage.show();
    }
                   }
        }else{
             JOptionPane.showMessageDialog(null, "Email or Password Error");
        }}
        

    @FXML
    private void LoginSignUp(ActionEvent event) throws IOException {
       
        Stage stage = (Stage) LoginSignUp.getScene().getWindow();
                    stage.close();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("reg.fxml"));
                
        Parent parent = loader.load();
        
        Scene scene = new Scene(parent);
        
        stage.setScene(scene);
        stage.setTitle("Creating JavaFX using Scene Builder");
        stage.show();
    }
    
        private boolean validate_input(String input){
                return !input.equals("");
            }
        
        private boolean validate_Email(String input){
                return input.contains("@")&& input.endsWith(".com");
            }

    @FXML
    private void CloseWindow(ActionEvent event) {
    }

    @FXML
    private void change_background(ActionEvent event) {
    }

    @FXML
    private void sz25(ActionEvent event) {
    }

    @FXML
    private void sz30(ActionEvent event) {
    }

    @FXML
    private void sz35(ActionEvent event) {
    }

    @FXML
    private void ffss(ActionEvent event) {
    }

    @FXML
    private void mo(ActionEvent event) {
    }

    @FXML
    private void fa(ActionEvent event) {
    }

    @FXML
    private void fontcolor(ActionEvent event) {
    }

    @FXML
    private void About(ActionEvent event) {
    }

    
}
