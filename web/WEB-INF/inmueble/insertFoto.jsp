<%-- 
    Document   : insertFoto
    Created on : 31-ene-2015, 20:57:44
    Author     : Antonio
--%>
<%@page import="hibernate.Inmueble"%>
<% String id =(String) request.getAttribute("id");%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="recursos/main.css">

        <title>Insertar fotos </title>
    </head>
    <body>
        <h2>Insertar foto</h2>

            <form action="controlfotos" method="post" enctype="multipart/form-data">
                <input type="file" name="archivo"  accept="image/*" />
                <input type="hidden" name="target" value="foto" />
                <input type="hidden" name="op" value="insert" />
                <input type="hidden" name="action" value="op" />
                <input type="hidden" name="id" value="<%= id %>" />
                <input type="submit" value="Enviar" />
            </form>    
       <a href="control?target=inmueble&op=select&action=view">Volver</a>

    </body>
</html>
