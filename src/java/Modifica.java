import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(urlPatterns = {"/Modifica"})
public class Modifica extends HttpServlet {
    int idL;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Modifica</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Modifica at " + request.getContextPath() + "</h1>");
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
            PrintWriter out = response.getWriter();
            
                idL=Integer.parseInt(request.getParameter("id_libro2"));
        try {
            //processRequest(request, response);
            
            
            conexionBD conex = new conexionBD();
            Connection con=conex.conectar();
            String sql="select* from libros where idLibro='"+idL+"'";
            PreparedStatement pstmt =con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
            
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Modificar</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Registrado</h1>");
                out.println("<table border=2><tr>");
                     out.println("<table border=2><tr>"
                    +"<td>ID libro: "+rs.getString("idLibro")+"</td>"
                    +"<td>Nombre libro: "+rs.getString("nombre")+"</td>"
                    +"<td>Editorial: "+rs.getString("editorial")+"</td>"
                            + "<td>Número paginas: "+rs.getString("numeroPag")+"</td></tr></table>");
                
                out.println("<br><br>");
                out.println("<p>Campos modificables : </p>");
                out.println("<form action='http://localhost:8080/pwebBD2/Change' method='post'>");
                out.println("Nombre:   <input type='text' name='nombreNew'><br>");
                out.println("Editorial: <input type='text' name='editorialNew'><br>");
                out.println("Paginas:   <input type='text' name='numero_paginaNew'><br>");
                out.println("<input type='submit' value='Modificar' name='modifica'>");
                out.println("</form>");
                out.println("<br>");
                out.println("<form action='http://localhost:8080/pwebBD2/formularioBiblio.html'>"); 
                out.println("<p> Volver al menú principal :</p>");                                                        
                out.println("<br>"); 
                out.println("<input type='submit' value='Back' name='back'>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
            }
            
            
   
        } catch (SQLException ex) {
            Logger.getLogger(Modifica.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      
        
    }
    
  protected void modifica(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
       
  
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
