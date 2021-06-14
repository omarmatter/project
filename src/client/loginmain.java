/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author dell
 */
public class loginmain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

FXMLLoader loader=new FXMLLoader();
      
         Pane root = FXMLLoader.load(getClass().getResource("login.fxml"));
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
        primaryStage.show();  


    }
    public static void main(String[] args) {
        launch(args);
    }
}
