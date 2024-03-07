/*
 SERVLET REGISTRO
el servlet registro usa el metodo registrar() de la clase GestorBD.java, para guardar la 
informacion capturada en la tabla "productos" de la base de datos "tienda", sí el metodo
registrar() regresa verdadero significa que los datos se guardaron exitosamente, de lao 
contrario se redireciona a la pagina que muestra el mensaje de error

los dats del producto(clave, nombre, precio, catidad)estan detro del objecto request que el servlet recibió del index.jsp
para desplegarlos en el registroGuardado.jsp no es necesario uincluir un atributo con el producto,
basta con el envio del objecto request(forward(request,response)
Estos parametros se obtienen en registroGuardado.jsp con el método request.getParameter()·*/
package Controller;

import Model.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "registro", urlPatterns = {"/registro"})
public class registro extends HttpServlet {    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            int clave=Integer.parseInt(request.getParameter("clave"));
            String nombre=request.getParameter("nombre");
            Double precio=Double.parseDouble(request.getParameter("precio"));
            int cantidad=Integer.parseInt(request.getParameter("cantidad"));
            
            GestorBD gestorBD=new GestorBD();
            
            if(gestorBD.registrar(clave,nombre,precio,cantidad)){
                request.getRequestDispatcher("/registroGuardado.jsp").forward(request, response);
            }else
                request.getRequestDispatcher("/errorEnRegisto.jsp").forward(request, response);
                    
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
