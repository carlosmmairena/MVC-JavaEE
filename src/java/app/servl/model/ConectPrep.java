package app.servl.model;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author Carlos Mairena
 */
public class ConectPrep {
    
    private DataSource pool1;
    private Connection conexion;

    /**
     * Iniciamos la conexión
     */
    public void iniciarConexion() {

        try {
            conexion = pool1.getConnection();

        } catch (SQLException ex) {
            // Crear archivo log para ver los mensajes de consola
            System.out.println("Error al conectarse a la BD: " + ex.getMessage());
        }
    }

    /**
     * Inyectamos el pool de conexiones
     *
     * @param pool
     */
    public ConectPrep(DataSource pool) {
        this.pool1 = pool;
        this.conexion = null;
    }

    /**
     * Retorna la conexión perparada.
     *
     * @return Connection
     */
    public Connection getConexion() {
        return conexion;
    }
}
