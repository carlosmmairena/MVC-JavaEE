package app.servl.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carlos Mairena
 */
public abstract class ModelLogin {

    /**
     * Envía los datos a la BD para verificar <br>
     * los datos del usuario
     *
     * @param usuario
     * @param contrasena
     * @param con
     * @return DataUser - Datos del usuario
     */
    public static Object[] verificar(int usuario, String contrasena, Connection con) {

        ResultSet rs = null;
        try {

            CallableStatement cst = con.prepareCall("{CALL pa_sesionTrabajador(?,?)}");
            cst.setInt(1, usuario);
            cst.setString(2, contrasena);

            rs = cst.executeQuery();
            rs.first();
            
             Object obj[] = {rs.getInt(1), rs.getString(2),
                             rs.getString(3), rs.getString(4),
                             rs.getString(5), rs.getBoolean(6)};

            return obj;

        } catch (SQLException e) {

            System.out.println("Error al intentar enviar los datos: " + e.getMessage());
            return null;
        }
    }

}
