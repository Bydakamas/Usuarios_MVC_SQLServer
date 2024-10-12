/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.UsuarioController;
import Model.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author Asus
 */
public class UsuarioView extends javax.swing.JFrame {

    private UsuarioController controller;
    private JTable table;
    private DefaultTableModel tableModel;

    /**
     * Creates new form UsuarioView
     */
    public UsuarioView() {
        initComponents();
        controller = new UsuarioController();
        setTitle("Gestión de Usuarios");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear la tabla
        tableModel = new DefaultTableModel(new Object[]{"ID", "Nombre", "Correo"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Crear botones
        JPanel panelBotones = new JPanel();
        JButton btnListar = new JButton("Listar Usuarios");
        JButton btnAgregar = new JButton("Agregar Usuario");
        JButton btnEliminar = new JButton("Eliminar Usuario");
        JButton btnActualizar = new JButton("Actualizar Usuario");
        
        panelBotones.add(btnListar);
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnActualizar);
        add(panelBotones, BorderLayout.SOUTH);

        // Acciones de los botones
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarUsuarios();
            }
        });

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para agregar un nuevo usuario
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
                String correo = JOptionPane.showInputDialog("Ingrese el correo:");
                Usuario usuario = new Usuario();
                usuario.setNombre(nombre);
                usuario.setCorreo(correo);
                controller.agregarUsuario(usuario);
                listarUsuarios(); // Refrescar la tabla después de agregar
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarUsuario();
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarUsuario();
            }
        });

        listarUsuarios(); // Para que al iniciar ya se muestren los usuarios
    }

    // Método para listar los usuarios en la tabla
    private void listarUsuarios() {
        tableModel.setRowCount(0);  // Limpiar la tabla
        List<Usuario> usuarios = controller.listarUsuarios();
        for (Usuario usuario : usuarios) {
            tableModel.addRow(new Object[]{usuario.getId(), usuario.getNombre(), usuario.getCorreo()});
        }
    }

    // Método para eliminar un usuario seleccionado
    private void eliminarUsuario() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) tableModel.getValueAt(selectedRow, 0);
            controller.eliminarUsuario(id);
            listarUsuarios(); // Refrescar la tabla después de eliminar
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario para eliminar");
        }
    }

    // Método para actualizar un usuario seleccionado
    private void actualizarUsuario() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) tableModel.getValueAt(selectedRow, 0);
            String nombre = (String) tableModel.getValueAt(selectedRow, 1);
            String correo = (String) tableModel.getValueAt(selectedRow, 2);
            
            String nuevoNombre = JOptionPane.showInputDialog(this, "Ingrese el nuevo nombre:", nombre);
            String nuevoCorreo = JOptionPane.showInputDialog(this, "Ingrese el nuevo correo:", correo);
            
            if (nuevoNombre != null && nuevoCorreo != null) {
                Usuario usuario = new Usuario(id, nuevoNombre, nuevoCorreo);
                controller.actualizarUsuario(usuario);
                listarUsuarios(); // Refrescar la tabla después de actualizar
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario para actualizar");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuarioView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
