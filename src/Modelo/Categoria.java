
package Modelo;


public class Categoria {
    private int idCategoria;
    private String NombreCategaoria;
    private String DescripcionCategaoria;
    
     public Categoria(int idCategoria, String NombreCategaoria, String DescripcionCategaoria) {
        this.idCategoria = idCategoria;
        this.NombreCategaoria = NombreCategaoria;
        this.DescripcionCategaoria = DescripcionCategaoria;
    }

    public Categoria() {
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategaoria() {
        return NombreCategaoria;
    }

    public void setNombreCategaoria(String NombreCategaoria) {
        this.NombreCategaoria = NombreCategaoria;
    }

    public String getDescripcionCategaoria() {
        return DescripcionCategaoria;
    }

    public void setDescripcionCategaoria(String DescripcionCategaoria) {
        this.DescripcionCategaoria = DescripcionCategaoria;
    }

   
}
