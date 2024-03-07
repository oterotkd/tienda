/*Para obtener la coneccion a la base de datos se utiliza el metodo (getConnetion)
de la clse (DirverManager), este metodo regresa un Objeto de la clase Connection y 
requiere tres parametros URL(donde se en cuentra la bases de datos)el nombre del 
usuario  y el password
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectaBD {
    public static Connection con;
    public static String bd = "tienda";
    public static String usuario = "root";
    public static String passw = "Otero98637130";
    public static String url = "jdbc:mysql://localhost:3306/tienda";

    public static Connection abrir() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, passw);
        } catch (Exception e) {
            System.out.println("Error en la Conexion...");
            e.printStackTrace();
        }
        return con;
    }

    public static void cerrar() {
        try {
            if (con != null)
                con.close();
        } catch (Exception e) {
            System.out.println("Error no se logró cerrar la Conexion:\n" + e);
        }
    }

}
