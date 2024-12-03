/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectodeaulaenergy;

import Logica.LogicaUsuarios;
import Modelo.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Jhon Bermudez
 */
public class LoginController implements Initializable {
    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
    
    private LogicaUsuarios logica = new LogicaUsuarios();
    
    @FXML
    private void clickBtnLogin() throws IOException{
       String username = this.txtUsername.getText();
       String password = this.txtPassword.getText();
       Usuario user = this.logica.buscarUsuario(username);
       boolean success = true;
       if(user!=null){
           if(user.getPassword().equals(password)){
               App.setRoot("ListaDispositivos");
           }else{
               success = false;
           }
       }else{
           success = false;
       }
       if(!success){
           Alert alerta = new Alert(Alert.AlertType.ERROR);
           alerta.setHeaderText("Las credenciales de usuario no son correctas");
           alerta.setTitle("Error de login");
           alerta.show();
       }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
}