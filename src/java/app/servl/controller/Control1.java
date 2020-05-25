/*
    Cuando se requiera mostrar estos datos, en realidad se llama al servlet
para que este se encarge de redirigir los datos a otro sitio.
*/
package app.servl.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Carlos Mairena
 */

// Por medio de esta anotación indicamos la URL por el que responderá este servlet
//@WebServlet(name = "Control1", urlPatterns = {"/pagina.html"})
@WebServlet("/pagina.html")
public class Control1 extends HttpServlet {

 
    protected void resp(HttpServletRequest solicitud, HttpServletResponse respuesta)
            throws ServletException, IOException {

        // Obtenemos el objeto con que vamos a escribir la respuesta, en este caso no es necesario
        //PrintWriter salid = respuesta.getWriter();
        //salid.print("<h1> Título </h1>");
        // ---- demás codigo que hará la respuesta
        
        // El tipo de contenido que mostrará el servlet al responder, ya sea html, binaria, img, etc
        respuesta.setContentType("text/html;charset=UTF-8");
        
        String nombre = "Carlos";
        int cedula    = 504260647;
        int passwd    = 8944;
        
        // Creamos el objeto para poder enviar los datos a la vista que indicamos en el parámetro.
        RequestDispatcher dispat = solicitud.getRequestDispatcher("/Index.jsp");
        
        // Setteamos los atributos que tendrá la solicitud actual}
        solicitud.setAttribute("nomb", nombre);
        solicitud.setAttribute("cedula", cedula);
        solicitud.setAttribute("passwd", passwd);
        
        
        // Con este método nos permitirá enviar los datos al archivo vista indicado en el dispacher
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

}
