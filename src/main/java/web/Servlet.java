/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;


import datos.UsuarioDAO;
import domain.Usuario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author planl
 */


@WebServlet("/mundo")
public class Servlet extends HttpServlet{
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
           throws ServletException, IOException {
       
      
          String name, lastname, tel, doc;
            
            name = request.getParameter("nombre");
            lastname = request.getParameter("apellido");
            tel = request.getParameter("telefono");
            doc = request.getParameter("documento");
            
            Usuario user = new Usuario(name, lastname, tel, doc);
            UsuarioDAO dao =new UsuarioDAO();
            dao.insertar(user);
          
            
           response.setContentType("text/html");
PrintWriter pw=response.getWriter();
pw.println("<script type=\"text/javascript\">");
pw.println("alert('Usuario Registrado');");
pw.println("</script>");
RequestDispatcher rd=request.getRequestDispatcher("index.html");
rd.include(request, response);

            
           
        
    }
    
}
