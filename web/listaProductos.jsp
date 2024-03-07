<%-- 
    Document   : listaProductos
    Created on : 14/02/2024, 5:03:02 p. m.
    Author     : OTEROTKD
--%>

<%@page import="Model.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>Los Productos Que Están Registrados Son:</h1>
        <!-- Y el listado se Hace Con un for: -->
        <%
            ArrayList<Producto> productos = null;
            productos = (ArrayList<Producto>)request.getAttribute("Productos");
        %>
       
        <table border="1">
            <tr>
                <th>Clave</th>
                <th>Nombre</th>
                <th>Precio</th>
                <th>Cantidad</th>
            </tr>
            <%
                for (Producto producto : productos) {
            %>
            <tr>
                <td><%= producto.getClave()%></td>
                <td><%= producto.getNombre()%></td>
                <td><%= producto.getPrecio()%></td>
                <td><%= producto.getCantidad()%></td>
            </tr>
            <%} %>
        </table>
        
        <form action="index.jsp"method="post">
            <input type="submit" value="Regresar al inicio">            
        </form>
        

    </body>
</html>
