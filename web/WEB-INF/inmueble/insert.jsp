

<%@page import="hibernate.Inmueble"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                       <link rel="stylesheet" type="text/css" href="recursos/main.css">

        <title>Insertar Inmueble</title>
    </head>
     
    <body>
        <div>
            <h1>Inmueble a insertar</h1>
            <div>
            <form name="control" action="control" method="POST">
                
                <p><label>Localidad: </label><input type="text" name="localidad" value="" /> </p>         
                <p><label>Dirección: </label><input type="text" name="direccion" value="" /></p>
                <p><label>Tipo:</label> <input type="text" name="tipo" value="" /></p>
                <p><label>Precio:</label> <input type="text" name="precio" value="" /></p>
                <p><label>Usuario:</label> <input type="text" name="usuario" value="" /></p>

                <input type="hidden" name="target" value="inmueble" />
                <input type="hidden" name="op" value="insert" />
                <input type="hidden" name="action" value="op" />

                <input type="submit" value="Insertar" />
            </form>
            <%
                String mensaje = (String) request.getAttribute("falso");
                if (mensaje != null) {
                    out.print(mensaje);
                }
                String mensaje1 = (String) request.getAttribute("nulos");
                if (mensaje1 != null) {
                    out.print(mensaje1);
                }
            %>
            </div>
            <h2>
                <a href="control?target=inmueble&op=select&action=view">Volver a inicio</a>
            </h2>
        </div>
    </body>
</html>
