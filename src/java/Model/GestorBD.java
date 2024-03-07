/*
 Para guardar un nuevo registro(fila )en una tabla de la base de datos desde java, se debe 
seguir cuatro pasos:
1) Establecer la conexion con la base de datos.
2) Crear un objecto de la clase Statement para poder codificar instrucciones.
3) Codificar la instruccion  para guardar un  nurvo registro.
4) Cerrar la Coinexion con la base de Datos
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Presento la codificacion de lo scuatro pasos observar que la instruccion para
 * crear un Statement debe estar dentro de y try-catch y para guaradar una nueva
 * fila en la base de datos se usa el método executeUpdate(), del objecto de la
 * clase Statement
 */
public class GestorBD {

    Connection conn = null;
    Statement stm = null;
    ResultSet productResSet;
    Producto productoHallado;
    int clav, cant;
    String nom;
    Double precio;

    public boolean registrar(int clave, String nombre, Double precio, int cantidad) {
        Connection conn = null;
        Statement stm;
        ResultSet rs;
        int resultUpdate = 0;
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            resultUpdate = stm.executeUpdate("insert into productos values(" + clave + ",'" + nombre + "'," + precio + "," + cantidad + ");");
            if (resultUpdate != 0) {
                ConectaBD.cerrar();
                return true;
            } else {
                ConectaBD.cerrar();
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return false;
        }
    }

    /*La Cosnulta de datos es una de las funciones mas importantes en las apllicaciones web
    el comando  para hacerlo en Mysql es: (SELECT) para realizar una consulta en una tatbla desde java
     se realizan  cuatro pasos:
    1) Establecer la Conaxion con la base de datos
    2) Crear un objeto de la  clase Statement para poder codificar instrucciones 
    3) Codificar las instrucciones con la consola
    4) Cerrar la Conexion con la base de datos.
    
    para ello se agrega a esta clase GestorBD.java, el metodo consultar(),el cual sirve par buecar un producto en la tabla productos
    de la base de datos y contiene la codificacion de los cuatro  pasos */

    public Producto consultar(int clave, String nombre) {
        //la  instruccion para crear un Statement se hace dentro de un try-catch
        //para realizar la consulta a la base de datos se usa el método executeQuery()
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            productResSet = stm.executeQuery("SELECT*FROM productos WHERE clave='" + clave + "' AND nombre ='" + nombre + "'");

            if (!productResSet.next()) {
                System.out.println("No se Encontró el Registro");
                ConectaBD.cerrar();
                return null;
            } else {
                System.out.println("Se Encontró el Registro");
                clav = productResSet.getInt("clave");
                nom = productResSet.getString("nombre");
                precio = productResSet.getDouble("precio");
                cant = productResSet.getInt("cantidad");
                productoHallado = new Producto(clav, nom, precio, cant);

                ConectaBD.cerrar();
                return productoHallado;

            }
        } catch (Exception e) {
            System.out.println("Error en la Base de Datos.");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Producto> leerTodo() {
        ArrayList<Producto> productos = new ArrayList<Producto>();
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            productResSet = stm.executeQuery("SELECT *FROM productos");
            if (!productResSet.next()) {
                System.out.println("No se Encontró Registro");
                ConectaBD.cerrar();
            } else {
                do {
                    clav = productResSet.getInt("clave");
                    nom = productResSet.getString("nombre");
                    precio = productResSet.getDouble("precio");
                    cant = productResSet.getInt("cantidad");
                    productoHallado = new Producto(clav, nom, precio, cant);
                    productos.add(productoHallado);
                } while (productResSet.next());
                ConectaBD.cerrar();
                return productos;
            }
        } catch (Exception e) {
            System.out.println("Error en la Base de Datos.");
            e.printStackTrace();
            return null;
        }
        return null;
    }
    
    /*METODO BORRAR*/
    public boolean borrar(int clave){
        int resultUpdate=0;
        try {
            conn=ConectaBD.abrir();
            stm=conn.createStatement();
            resultUpdate= stm.executeUpdate("DELETE FROM productos WHERE (clave='"+clave+"');");
            
            if(resultUpdate !=0){
                ConectaBD.cerrar();
                return true;
            }else{
                ConectaBD.cerrar();
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error en la Base de Datos..");
            e.printStackTrace();
            return false;
        }
    }
    

}
