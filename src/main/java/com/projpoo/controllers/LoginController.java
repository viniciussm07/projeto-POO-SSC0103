package com.projpoo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class LoginController {

    @FXML
    private Button botaoLogin;

    @FXML
    private TextField campoSenha;

    @FXML
    private TextField campoUsuario;

    @FXML
    void fazerLogin(ActionEvent event) {
        String usuario = campoUsuario.getText();
        String senha = campoSenha.getText();
        if (usuario.equals("usuario") && senha.equals("usuario")) {
            System.out.println("Logado com sucesso!");
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Erro");
            alert.setTitle("Login Inválido");
            alert.setContentText("Usuário ou senha inválido");
            alert.show();
        }
    }

}
