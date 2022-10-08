
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Est;

public class est extends HttpServlet {

    
     Estudiante est;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servletest</title>");            
            out.println("</head>");
            out.println("<b>");

            est = new Est(request.getParameter("txt_id_estudiante"),request.getParameter("txt_carne"),request.getParameter("txt_nombres"),request.getParameter("txt_apellidos"),request.getParameter("txt_direccion"),request.getParameter("txt_telefono"), request.getParameter("txt_correo"),request.getParameter("drop_id_sangre"),request.getParameter("txt_fn"));
              
              // Boton agregar 
            if ("agregar".equals(request.getParameter("btn_agregar"))){
             if (est.agregar()>0){
             response.sendRedirect("index.jsp");
             
             }else{
             out.println("<h1> no ingresado </h1>");
             out.println("<a href='index.jsp'>Regresar...</a>");
             }
             }
            
             // Boton modificar 
            if ("modificar".equals(request.getParameter("btn_modificar"))){
             if (est.modificar()>0){
             response.sendRedirect("index.jsp");
             
             }else{
             out.println("<h1> no pudo modificar </h1>");
             out.println("<a href='index.jsp'>Regresar...</a>");
             }
             }
              
            // Boton eliminar 
            if ("eliminar".equals(request.getParameter("btn_eliminar"))){
             if (est.eliminar()>0){
             response.sendRedirect("index.jsp");
             
             }else{
             out.println("<h1>No se pudo Eliminar</h1>");
             out.println("<a href='index.jsp'>Regresar...</a>");
             }
             }
          
            out.println("</body>");
            out.println("</html>");
        }
    }

}  protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
