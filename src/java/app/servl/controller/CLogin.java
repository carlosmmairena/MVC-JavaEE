/*
    Cuando se requiera mostrar estos datos, en realidad se llama al servlet
para que este se encarge de redirigir los datos a otro sitio.
 */
package app.servl.controller;

import app.servl.model.ConectPrep;
import app.servl.model.ModelLogin;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Carlos Mairena
 */
@WebServlet(name = "CLogin", urlPatterns = {"/login"})
public class CLogin extends HttpServlet {

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
    
    
    protected void resp(HttpServletRequest solicitud, HttpServletResponse respuesta)
            throws ServletException, IOException {

        // El tipo de contenido que mostrará el servlet al responder, ya sea html, binaria, img, etc
        respuesta.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispat = null;

        if (sesion(solicitud)) {

            // Utilizamos al controlador/vista para que muestre el menú
            dispat = solicitud.getRequestDispatcher("/categorias.html");

        } else {
            // Utilizamos el mismo jsp pero informando con un atributo el false del login
            dispat = solicitud.getRequestDispatcher("/Index.jsp");
            solicitud.setAttribute("sesion", false);
        }

        // Reenviamos la solicitud
        dispat.forward(solicitud, respuesta);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp(req, resp);
    }

    /**
     * Retorna si la sesión es correcta
     *
     * @return
     */
    private boolean sesion(HttpServletRequest solicitud) {
        
        int cedula = Integer.parseInt(encriptar(solicitud.getParameter("cedula")));
        String contr = encriptar(solicitud.getParameter("contrasena"));
        
        // Enviamos la cédula y contraseña a la BD
        Object obj[] =  ModelLogin.verificar(cedula, contr, conect.getConexion());
        solicitud.setAttribute("datosUser", obj);
        
        
        return true;

    }

    /**
     * Se llama para encriptar algún valor
     *
     * @param contrasenia
     */
    private String encriptar(String valor) {

        String encript = DigestUtils.md5Hex(valor);
        System.out.println("Encriptada");
        return encript;
    }

}
