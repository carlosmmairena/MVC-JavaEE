package app.servl.model;

import app.servl.beans.Categoria;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Carlos Mairena
 */
public abstract class ModelCateg {

    private static ResultSet extraerCat(Connection conect) {

        ResultSet rs = null;

        try {

            CallableStatement ps = conect.prepareCall("{CALL pa_mostrarTablas(?)}");
            ps.setInt(1, 2);
            rs = ps.executeQuery();
            //rs.first();
            return rs;

        } catch (SQLException e) {
            System.out.println("Error del mensaje: " + e.getMessage());
            return rs;
        }
    }

    public static ArrayList<Categoria> formatearDatos(Connection conect)
            throws SQLException {

        Categoria cate = new Categoria();
        ArrayList<Categoria> categorias = new ArrayList<Categoria>();

        // Obtenemos los datos
        ResultSet rse = extraerCat(conect);

        while (rse.next()) {

            Categoria caten = cate.clonar();

            caten.setIdCategoria(rse.getInt(1));
            caten.setNombreCateg(rse.getString(2));
            caten.setDescripcionCateg(rse.getString(3));

            categorias.add(caten);
            categorias.trimToSize();
        }

        return categorias;
    }

}
