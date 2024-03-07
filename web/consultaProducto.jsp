<%-- 
    Document   : consultaProducto
    Created on : 13/02/2024, 3:30:41 p. m.
    Author     : OTEROTKD
--%>
<!-- con el boton consulatar esta  pagina se encarga de redireccionar los datos capturados a la pagina 
al servlet consulta.java
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consular</title>
    </head>
    <body>
         <%@page import="Controller.consulta" %>
        <h1>Consulta un Producto</h1>
        <h2>Para buscar un registro ptoporsiona los siguientes datos</h2>
        <form action="consulta" method="post">
            <table border="1">
                <thead>
                    <tr>
                        <th>TIPO </th>
                        <th>DATOS</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>CLAVE:</td>
                        <td><input type="text"name="clave"></td>
                    </tr>
                    <tr>
                        <td>NOMBRE:</td>
                        <td><input type="text"name="nombre"></td>
                    </tr>
                </tbody>               
            </table>
            <input type="reset" value="BORRAR"><!-- Borrar los datos de las casillas si hay un error -->
            <input type="submit" value="Consultar"><!-- envia los datos a la pagina siguiente -->       
        </form>
        <form action="index.jsp">
            <input type="submit" value="Regresar"><!--<!-- Se Regresa ala pagina Principal -->
        </form>
    </body>
</html>
