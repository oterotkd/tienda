<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/jquery.min.js"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Inicial</title>
    </head>
    <body>
        <%@page import="Controller.registro" %>
        <h2>Sitema de Gestion de Productos</h2>
        <script>
            function valida(form){
                if (document.forma.clave.value =="")
                    alert("Falta Introducir Clave..");
                else {
                    if (document.forma.nombre.value == "")
                        alert("Falta Introducir Nombre..");
                    else {
                        if (document.forma.precio.value == "")
                            alert("Falta Introducir Precio..");
                        else {
                            if (document.forma.cantidad.value == "")
                                alert("Falta Introducir Cantidad");
                            else
                                form.submit();
                        }
                    }
                }
            } 
        </script> 
        <form name="forma"action="registro" method="post">
            <table border="1">
                <thead>
                    <tr>
                        <th>TIPO </th>
                        <th>DATOS</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Clave:</td>
                        <td><input type="text"name="clave"></td>
                    </tr>
                    <tr>
                        <td>Nombre:</td>
                        <td><input type="text" name="nombre"></td>
                    </tr>
                    <tr>
                        <td>Precio:</td>
                        <td><input type="text" name="precio"></td>
                    </tr>
                    <tr>
                        <td>Cantidad:</td>
                        <td><input type="text" name="cantidad"></td>
                    </tr>
                </tbody>
            </table>
            <input type="reset" value="BORRAR"><!-- Borrar los datos de las casillas si hay un error -->
            <input type="submit" value="Registrar"onClick="valida(this.form)"><!-- envia los datos a la pagina siguiente -->
        </form>

        <form action="consultaProducto.jsp" method="post">
            <input type="submit" value="Consultar">
        </form>
        <form action="muestraProductos" method="post">
            <input type="submit" value="VerRegistros">
        </form>

    </body>
</html>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        