/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderapp.client;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class RegController implements Initializable {

    @FXML
    private TextField namefield;
    @FXML
    private TextField emailfield;
    @FXML
    private TextField mobilefield;
    @FXML
    private TextField passfield;
    @FXML
    private Button registerbtn;

    
    Statement statement;
    @FXML
    private Button backbtn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

 try {
            // TODO
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection =
               DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbforjava","root","");
                       
                                              
            this.statement = connection.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }    

    @FXML
    private void registeration(ActionEvent event) throws SQLException {
        
        
        String name = namefield.getText();
        String mobile = mobilefield.getText();
        String email = emailfield.getText();
        String pass = passfield.getText();
        
        
        
        
        if(name.equals("") || mobile.equals("") || email.equals("") || pass.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setHeaderText("empty form");
           alert.setContentText("fill data");
           alert.showAndWait();
           
            
        }
        
        else {
            String role = "client";
String sql = "insert into users(name , email , mobile , password , role ) values('" +name + "','" + email + "','" + mobile + "','" +pass + "','" + role + "') ";
    
      this.statement.executeUpdate(sql);
            this.statement.executeUpdate(sql);
            
        }
        
        
    }

    @FXML
    private void backtologin(ActionEvent event) throws IOException {
        
        
        Stage stage = (Stage) registerbtn.getScene().getWindow();
                    stage.close();
      
        Pane pane= FXMLLoader.load(getClass().getResource("login.fxml"));
        
        Scene scene = new Scene(pane);
        Stage  primaryStage= new Stage(StageStyle.DECORATED);
        primaryStage.setTitle("");
        primaryStage.setScene(scene);
        primaryStage.show();            
                    
    }
    
}
