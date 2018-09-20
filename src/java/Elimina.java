
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/Elimina"})
public class Elimina extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Elimina</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Elimina at " + request.getContextPath() + "</h1>");
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
        
        out.println("Elimina!");
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
