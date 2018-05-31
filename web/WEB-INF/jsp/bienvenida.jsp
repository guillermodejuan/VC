<%-- 
    Document   : bienvenida
    Created on : 30-may-2018, 12:28:29
    Author     : usuario
--%>

<%@page import="modelo.Pelicula"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Videoclub - <%=request.getAttribute("usuario")%></title>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
        <script type="text/javascript" language="javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" class="init">
            $(document).ready(function () {
                $('#example').DataTable();
            });
        </script>

    </head>
    <body>
        <%@ include file='cabecera.jsp' %>
        <h1 align="center">Hola <%=request.getAttribute("usuario")%>! </h1>

        <table id="example" class="display" style="width:100%">
            <thead>
                <tr>
                    <th>Titulo</th>
                    <th>Año</th>
                    <th>Idioma</th>
                    <th>Duración</th>
                    <th>Calificación</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${peliculas}" var="pelicula">
                <tr>
                    <td title="${pelicula.descripcion}"><c:out value="${pelicula.nombre}" /></td>
                    <td><c:out value="${pelicula.ano}" /></td>
                    <td><c:out value="${pelicula.lengua}" /></td>
                    <td><c:out value="${pelicula.duracion}" /></td>
                    <td><c:out value="${pelicula.rating}" /></td>
                    
                </tr>
                </c:forEach>
                
            <tfoot>
                <tr>
                    <th>Titulo</th>
                    <th>Año</th>
                    <th>Idioma</th>
                    <th>Duración</th>
                    <th>Calificación</th>
                </tr>
            </tfoot>
        </table>
    </body>
</html>
