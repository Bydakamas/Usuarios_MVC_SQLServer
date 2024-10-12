/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.usuarios_crud_mvc;

import View.UsuarioView;

/**
 *
 * @author Asus
 */
public class USUARIOS_CRUD_MVC {

    public static void main(String[] args) {
        // Inicializar la vista de usuarios
        java.awt.EventQueue.invokeLater(() -> {
            new UsuarioView().setVisible(true); // Hace visible la ventana principal de la aplicación
        });
    }
}
