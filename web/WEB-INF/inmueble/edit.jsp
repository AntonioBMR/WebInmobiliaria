

<%@page import="hibernate.Inmueble"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Inmueble i = (Inmueble) request.getAttribute("inmueble");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="recursos/main.css">       
        <title>Modificar inmueble</title>
    </head>
    <body>
                <h1>Modificar inmueble</h1>

        <form name="control" action="control" method="POST">
            <p><label>Localidad: </label><input type="text" name="localidad" value="<%= i.getLocalidad()%>" /> </p>         
            <p><label>Dirección:</label> <input type="text" name="direccion" value="<%= i.getDireccion()%>" /></p>
            <p><label>Tipo:</label><input type="text" name="tipo" value="<%= i.getTipo()%>" /></p>
            <p><label>Precio:</label> <input type="text" name="precio" value="<%= i.getPrecio()%>" /></p>
            <p><label>Usuario:</label> <input type="text" name="usuario" value="<%= i.getUsuario()%>" /></p>
                <input type="hidden" name="target" value="inmueble" />
                <input type="hidden" name="op" value="edit" />
                <input type="hidden" name="action" value="op" />
                <input type="hidden" name="id" value="<%= i.getId()%>" />
                <input type="submit" value="Modificar" />
           
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
    </body>
</html>
