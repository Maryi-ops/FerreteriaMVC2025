
package DAO;

import Modelo.usuario;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiante
 */
public class UsuarioDAO {

    public void crearUsuario(usuario usuario) throws SQLException {
        String sql = """
        INSERT INTO Usuarios (
            usuario, 
            contraseña
        ) VALUES (?, ?)""";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getContrasena());
            stmt.executeUpdate();
        }
    }

    public List<usuario> leerTodosUsuarios() throws SQLException {
        String sql = "SELECT * FROM Usuarios";
        List<usuario> usuarios = new ArrayList<>();

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                usuario usuario = new usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContrasena(rs.getString("contraseña"));
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

    public void actualizarUsuario(usuario usuario) throws SQLException {
        String sql = "UPDATE Usuarios SET usuario = ?, contraseña = ? WHERE id_usuario = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getContrasena());
            stmt.setInt(3, usuario.getIdUsuario());
            stmt.executeUpdate();
        }
    }

// Método para eliminar un usuario
    public void eliminarUsuario(int idUsuario) throws SQLException {
        String sql = "DELETE FROM Usuarios WHERE id_usuario = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            stmt.executeUpdate();
        }
    }
    
    public usuario validarUsuario(String usuario, String contrasena) throws SQLException {
    String sql = "SELECT * FROM Usuarios WHERE usuario = ? AND contraseña = ?";
    try (Connection c = ConexionDB.getConnection(); 
         PreparedStatement stmt = c.prepareStatement(sql)) {
        stmt.setString(1, usuario);
        stmt.setString(2, contrasena);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return new usuario(rs.getInt("id_usuario"), rs.getString("usuario"), rs.getString("contraseña"));
            }
        }
    }
    return null; // Si no se encuentra coincidencia
}

// Método Main
    public static void main(String[] args) {
        try {
            UsuarioDAO dao = new UsuarioDAO();

            // Actualizar un usuario
            usuario usuario = new usuario();
            usuario.setIdUsuario(1); // ID existente
            usuario.setUsuario("nuevo_usuario");
            usuario.setContrasena("nueva_contraseña");
            dao.actualizarUsuario(usuario);
            System.out.println("Usuario actualizado.");

            // Eliminar un usuario
            dao.eliminarUsuario(2); // ID a eliminar
            System.out.println("Usuario eliminado.");

            // Leer y mostrar todos los usuarios para verificar
            List<usuario> usuarios = dao.leerTodosUsuarios();
            System.out.println("Lista de usuarios:");
            for (usuario usu : usuarios) {
                System.out.println("ID: " + usu.getIdUsuario()
                        + ", Usuario: " + usu.getUsuario()
                        + ", Contraseña: " + usu.getContrasena());
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
