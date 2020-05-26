package app.servl.beans;

/*
 * @author Carlos Mairena
 */
public class Categoria implements Cloneable {

    private int    idCategoria;
    private String nombreCateg;
    private String descripcionCateg;
    
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCateg() {
        return nombreCateg;
    }

    public void setNombreCateg(String nombreCateg) {
        this.nombreCateg = nombreCateg;
    }

    public String getDescripcionCateg() {
        return descripcionCateg;
    }

    public void setDescripcionCateg(String descripcionCateg) {
        this.descripcionCateg = descripcionCateg;
    }

    public Categoria() {
        this.idCategoria = 0;
        this.nombreCateg = "";
        this.descripcionCateg = "";
    }

    @Override
    public String toString() {
        return "Categoría: <br/>"
                + "ID: " + idCategoria
                + "<br/> Nombre: " + nombreCateg
                + "<br/> Descripción: " + descripcionCateg
                + "<br/>";
    }
    
    /**
     * Clonamos este objeto para evitar instanciar,<br>
     * patrón de diseño Prototype. <br>
     * Nota: Podría ser una interfaz quien declare este método, <br>
     * solamente que en esta ocasión no la necesitamos)
     *
     * @return Categoria
     */
    public Categoria clonar() {

        Categoria clon = null;
        try {

            clon = (Categoria) this.clone();

        } catch (CloneNotSupportedException ex) {

            System.out.println("No se puede clonar este objeto: " + ex.getMessage());
        }
        return clon;
    }
}
