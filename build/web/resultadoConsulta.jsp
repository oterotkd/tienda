<%-- 
    Document   : resultadoConsulta
    Created on : 14/02/2024, 1:10:38 p. m.
    Author     : OTEROTKD
--%>




<%@page import="Model.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@page import="Controller.consulta" %>
         <%/*La pagina noEncontrado.jsp, desplega un mensaje de error indicando que no se encontro
             el elemento buscado. La pagina resultadoConsulta.jsp, desplega el elemento encontrado y 
             recibe en un scriptlet el objecto Producto y  se u tilizan  las expresiones:
             producto.getClave, producto.getNombre,producto.getPrecio etc,*/
            Producto producto=(Producto)request.getAttribute("atribProd");
        %>
        
        <h1>Resultado de la Consulta</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Tipo</th>
                    <th>Datos</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Clave:</td>
                    <td><%= producto.getClave()%></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><%= producto.getNombre()%></td>
                </tr>
                <tr>
                    <td>Precio:</td>
                    <td><%= producto.getPrecio()%></td>
                </tr>
                <tr>
                    <td>Cantidad:</td>
                    <td><%= producto.getCantidad()%></td>
                </tr>

            </tbody>
        </table>

    </body>
</html>
