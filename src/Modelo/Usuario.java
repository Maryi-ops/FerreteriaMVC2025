
package Modelo;

/**
 *
 * @author JLG
 */
public class usuario {
    private int idUsuario;
    private String usuario;
    private String contrasena;
    
     public usuario(int idUsuario, String usuario, String contrasena) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

      public usuario() {
    }
     
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

   
}
