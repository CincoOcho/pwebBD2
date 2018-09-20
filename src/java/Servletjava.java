import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/Servletjava"})
public class Servletjava extends HttpServlet{


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registro exitoso !!!</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servletjava at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
       
        
        
        try {
            //processRequest(request, response);
            int id_L, num_p;
            String nombreL, editL;
            
            id_L=Integer.parseInt(request.getParameter("id_libro"));
            nombreL=request.getParameter("nombre");
            editL=request.getParameter("editorial");
            num_p=Integer.parseInt(request.getParameter("numero_pagina"));
   
            conexionBD conex= new conexionBD();
            Connection con =conex.conectar();
            conex.stmt=con.createStatement();
            conex.stmt.executeUpdate("INSERT INTO libros VALUES (' " +id_L+ " ', '" +nombreL+ "', '" +editL+"', '" +num_p+"')");
   
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Insertar</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Registrado</h1>");
                out.println("<form action='http://localhost:8080/pwebBD2/formularioBiblio.html'>"); 
                out.println("<p> Volver al menú principal :</p>");                                                        
                out.println("<br>"); 
                out.println("<input type='submit' value='Back' name='back'>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");}
                
            
                
                
                
            
            
        }   catch (SQLException ex) {
            Logger.getLogger(Servletjava.class.getName()).log(Level.SEVERE, null, ex);
        }
                               
                                  
    }
    
    

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
    public class conexionBD{
       Connection conexion=null;
       Statement stmt=null;
       public Connection conectar(){
           
                  String url = "jdbc:mysql://localhost:3306/biblioteca"; 
                  String usuario = "root"; 
                  String contraseña = "1234";           
           try{
           Class.forName("com.mysql.jdbc.Driver").newInstance();
           conexion=DriverManager.getConnection(url,usuario,contraseña);
           }
           catch(Exception ex){
               System.out.println("ERROR"+ex.getMessage()); 
           }
       return conexion;
       }
}
    
    
}





