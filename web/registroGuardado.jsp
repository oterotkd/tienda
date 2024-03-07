<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Guardado</title>
    </head>
    <body>
        <%@page import="Model.Producto" %>
        <%
            int clave = Integer.parseInt(request.getParameter("clave"));
            String nombre = request.getParameter("nombre");
            Double precio = Double.parseDouble(request.getParameter("precio"));
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            Producto producto = new Producto(clave, nombre, precio, cantidad);
        %>
        <h1>registro exitoso en la base de datos</h1>
        <p>se guardaron lo Siguintes datos:</p>
        <table border="2">
            <thead>
                <tr>
                    <th>TIPO </th>
                    <th>DATOS</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Clave:</td>
                    <td><%= clave%></td>
                </tr>
                <tr>
                    <td>Nombre:</td>
                    <td><%= nombre%></td>
                </tr>
                <tr>
                    <td>Precio:</td>
                    <td><%= precio%></td>
                </tr>
                <tr>
                    <td>Cantidad:</td>
                    <td><%= cantidad%></td>
                </tr>
            </tbody>
        </table>
        <form action="index.jsp">
            <input type="submit" value="Regresar">
        </form>

    </body>
</html>
