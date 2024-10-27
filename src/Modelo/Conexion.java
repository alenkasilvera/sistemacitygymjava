
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    // Variable para la conexión
    private Connection con;

    // Método para obtener la conexión
    public Connection getConnection() {
        // URL de la base de datos
        String myBD = "jdbc:mysql://localhost:3306/sistemacitygym?serverTimezone=UTC";
        
        try {
            // Establecer la conexión
            con = DriverManager.getConnection(myBD, "root", "Nahiara230903");
            return con; // Devuelve la conexión si es exitosa
        } catch (SQLException e) {
            System.out.println(e.toString()); // Imprime el error en caso de excepción
        }
        
        return null; // Devuelve null si ocurre una excepción
    }
}

