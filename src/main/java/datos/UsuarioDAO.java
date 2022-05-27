/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import domain.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author planl
 */
public class UsuarioDAO {
    
     private static final String SQL_SELECT =
            "SELECT id_cliente,nombre,apellido,email,telefono,saldo"
            + " FROM cliente";
    
     private static final String SQL_SELECT_BY_ID =
            "SELECT id_cliente,nombre,apellido,email,telefono,saldo"
            + " FROM cliente WHERE id_cliente";
     
      private static final String SQL_INSERT =
            "INSERT INTO usuarios(nombre,apellido,telefono,documento)"
            + " VALUES (?,?,?,?)";
      
      private static final String SQL_UPDATE =
            "UPDATE cliente "
              + "SET nombre=?, apellido=?, email=?,telefono=?,"
              +"saldo=? WHERE id_cliente=?";
      
      private static final String SQL_DELETE = "DELETE FROM"
              +"cliente WHERE id__cliente=?";
      
  
      
      public int insertar(Usuario usuario){
          Connection conn = null;
          PreparedStatement stmt = null;
          int rows = 0;
          
          try {
              conn = Conexion.getConnection();
              stmt = conn.prepareStatement(SQL_INSERT);
              stmt.setString(1, usuario.getNombre());
              stmt.setString(2, usuario.getApellido());
              stmt.setString(3, usuario.getTelefono());
              stmt.setString(4, usuario.getDocumento());
             
              
              rows = stmt.executeUpdate();
              
          } catch (SQLException e) {
              e.printStackTrace(System.out);
          }finally{
              Conexion.close(stmt);
              Conexion.close(conn);
          }
          
          return rows;
      }
      
      
    
}
