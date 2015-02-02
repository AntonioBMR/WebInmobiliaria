<%-- 
    Document   : vistaFotos
    Created on : 31-ene-2015, 20:39:05
    Author     : Antonio
--%>


<%@page import="hibernate.Inmueble"%>
<%@page import="Modelo.ModeloInmueble"%>
<%@page import="hibernate.Foto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="recursos/main.css">

        <title>Fotos inmuebles</title>
    </head>
    <body>
        <h2>Fotos de los inmuebles</h2>
        <div>
 <table border="1">
            <thead>
                <tr>
                    <th>fotos de los inmuebles</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Foto> lista = (List<Foto>)request.getAttribute("fotos");
                    for(Foto f: lista){
                %>
                <tr>
                    
                    <td><img src="<%= f.getRuta()%>" width="300" height="300"/><br/>
                    <%= "localidad: "+ModeloInmueble.get(f.getInmueble().getId()+"").getLocalidad()+" calle:"+
                            ModeloInmueble.get(f.getInmueble().getId()+"").getDireccion()%><br/>  
                      <a href="controlfotos?target=foto&op=delete&action=op&id=<%= f.getId()%>">borrar foto</a>  </td>
                </tr>
                <%
                      }
                 %>
                  <a href="control?target=inmueble&op=select&action=view">Volver a inicio</a>
 
            </tbody>
        </table>
                 
</div>
    </body>    
</html>
