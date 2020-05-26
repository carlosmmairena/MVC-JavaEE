package app.servl.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import app.servl.beans.Categoria;
import app.servl.model.ConectPrep;
import app.servl.model.ModelCateg;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.sql.DataSource;

/**
 *
 * @author Carlos Mairena
 */
//@WebServlet(name = "Control2", urlPatterns = {"/categorias.html"})
@WebServlet("/categorias")
public class Control2 extends HttpServlet {

    // Para hacer referencia al pool de conexiones creado en el archivo .xml
    @Resource(name = "jdbc/Conexion")
    // Creamos una variable donde almacenamos nuestro pool de conexiones
    private DataSource pool1;
    private ConectPrep conect;

    /**
     * Método sinónimo al main(String) de las aplicaciones Java SE
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        super.init();
        
        this.conect = new ConectPrep(pool1);
        this.conect.iniciarConexion();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        // Creamos el objeto para poder enviar los datos a la vista que indicamos en el parámetro.
        RequestDispatcher dispat = request.getRequestDispatcher("/Categorias.jsp");

        try {
            
            String estado = conect.getConexion().getCatalog();
            // Obtenemos los datos
            ArrayList<Categoria> categorias = ModelCateg.formatearDatos(conect.getConexion());
            
            request.setAttribute("categTodas", categorias);
            request.setAttribute("estado", estado);

            // Con este método nos permitirá enviar los datos al archivo vista indicado en el dispacher
            dispat.forward(request, response);

        } catch (SQLException ex) {
            response.getWriter().println("Error al conectarse: " + ex.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
