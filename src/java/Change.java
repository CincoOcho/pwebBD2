

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/Change"})
public class Change extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Change</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Change at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        
      PrintWriter out = response.getWriter();
      int num_p,idBook;
      String nombreL, editL,sqlQ;
      
      Modifica IDBook = new Modifica();
      idBook=IDBook.idL;
      
        try {
      conexionBD conex= new conexionBD();
      Connection con=conex.conectar();
      
      nombreL=request.getParameter("nombreNew");
      editL=request.getParameter("editorialNew");
      num_p=Integer.parseInt(request.getParameter("numero_paginaNew"));
      sqlQ=("UPDATE libros SET nombre='"+nombreL+"',editorial='"+editL+"',numeroPag='"+num_p+"' WHERE idLibro='"+idBook+"'");
      PreparedStatement pstmt=con.prepareStatement(sqlQ);
      pstmt.executeUpdate(sqlQ);
        //Query ok = UPDATE libros SET nombre='nuevoNombre',editorial='editorialNuevo"',numeroPag='xxx' WHERE idLibro= X;
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>CambioRealizado</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Cambio realizado</h1>");
                out.println("<form action='http://localhost:8080/pwebBD2/formularioBiblio.html'>"); 
                out.println("<p> Volver al menú principal :</p>");                                                        
                out.println("<br>"); 
                out.println("<input type='submit' value='Back' name='back'>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
     
      
 
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Modifica.class.getName()).log(Level.SEVERE, null, ex);
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
