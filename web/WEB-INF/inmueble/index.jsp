<%@page import="hibernate.Inmueble"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="recursos/main.css">
        
        <title>Tabla de Datos</title>
    </head>
    <body>
        <div>
        <h1>Inmuebles subidos</h1>
        
        <h3>
            <a href="control?target=inmueble&op=insert&action=view">Insertar inmueble</a>
            <a href="controlfotos?target=foto&op=select&action=view">Ver fotos</a>
        </h3>
        <table border="1">
            <thead>
                <tr>
                    <th>id</th>
                    <th>Localidad</th>
                    <th>Direccion</th>
                    <th>Tipo</th>
                    <th>Precio</th>
                    <th>Usuario</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Inmueble> lista = (List)request.getAttribute("datos");
                    for(Inmueble p: lista){
                %>
                <tr>
                    <td><%= p.getId()%></td>
                    <td><%= p.getLocalidad()%></td>
                    <td><%= p.getDireccion()%></td>
                    <td><%= p.getTipo()%></td>
                    <td><%= p.getPrecio()%></td>
                    <td><%= p.getUsuario()%></td>
                    <td><a href="control?target=inmueble&op=delete&action=op&id=<%= p.getId()%>">Borrar</a></td>
                    <td><a href="control?target=inmueble&op=edit&action=view&id=<%= p.getId()%>">Editar</a></td>
                    <td><a href="controlfotos?target=foto&op=insert&action=view&id=<%= p.getId()%>">Insertar foto</a></td>
                </tr>
                <%
                      }
                 %>
  
            </tbody>
        </table>
</div>
    </body>
</html>
