/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package da_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

/**
 *
 * @author francisco
 */
public class DA_JDBC {

    public static void main(String[] args) {
      Connection con = null;
      try {
      String url = "jdbc:postgresql://172.17.0.2:5432/ejemplo";
      String pdw = "password";
      String usr = "postgres";
      con=DriverManager.getConnection(url, usr, pdw);
      
      con.setAutoCommit(false);
      Statement st= con.createStatement();
      String sql= "insert into empleado (nombre, edad, direccion) values('francisco', '28', 'calle 09')";
      String sql2= "SELECT * FROM empleado WHERE nombre = 'martin'";
      String sql3= "UPDATE empleado SET nombre = 'martin' WHERE nombre = 'francisco';";
      String sql4= "DELETE FROM empleado WHERE nombre = 'francisco';";
      st.execute(sql);
      ResultSet resultSet = st.executeQuery(sql2);
      con.commit();
          System.out.println("se guardo"); 
      
           while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                int edad = resultSet.getInt("edad");
                String direccion = resultSet.getString("direccion");
                
                System.out.println("Nombre: " + nombre + ", Edad: " + edad + ", Dirección: " + direccion);
            }
            
      
      }
      catch(SQLException ex){
 Logger.getLogger(DA_JDBC.class.getName()).log(Level.SEVERE,null,ex);
      }
      
    }
}
