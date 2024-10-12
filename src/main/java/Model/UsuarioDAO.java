/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Asus
 */
public class UsuarioDAO {
// Método para obtener conexión a SQL Server
    private Connection getConnection() throws SQLException {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=USUARIOCONTROLLER";
        String user = "sa";
        String password = "123";
        return DriverManager.getConnection(url, user, password);
    }

    // Operaciones CRUD (crear, leer, actualizar y eliminar)

    public List<Usuario> listarUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        Connection con = getConnection();
        String sql = "SELECT * FROM usuarios";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setCorreo(rs.getString("correo"));
            usuarios.add(usuario);
        }

        rs.close();
        stmt.close();
        con.close();
        return usuarios;
    }

    public void agregarUsuario(Usuario usuario) throws SQLException {
        Connection con = getConnection();
        String sql = "INSERT INTO usuarios (nombre, correo) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, usuario.getNombre());
        ps.setString(2, usuario.getCorreo());
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public void eliminarUsuario(int id) throws SQLException {
        Connection con = getConnection();
        String sql = "DELETE FROM usuarios WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public void actualizarUsuario(Usuario usuario) throws SQLException {
        Connection con = getConnection();
        String sql = "UPDATE usuarios SET nombre = ?, correo = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, usuario.getNombre());
        ps.setString(2, usuario.getCorreo());
        ps.setInt(3, usuario.getId());
        ps.executeUpdate();
        ps.close();
        con.close();
    }
}
