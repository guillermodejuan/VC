<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido al VideoClub!</title>
        <style>
            td.input:hover {
                background: red;

            }
            input {
                width: 100px;
            }
        </style>
    </head>

    <body>
        <%@ include file='cabecera.jsp' %>

        <p align="center">Bienvenido al VideoClub, introduce tus datos para inicio de sesión</p>
        <%
            String error = "";
            if (request.getAttribute("error") != null) {
                error = (String)request.getAttribute("error");
            }
        %>
        <p align="center" style="color: red"><%=error%></p>
        <form method="post" action="Login">
            <table align="center">
                <tr><td title="Email">Usuario:</td><td class="input"><input type="text" name="usuario"></td></tr>
                <tr><td title="Password">Password:</td><td class="input"><input type="password" name="password"></td></tr>
                <tr><td colspan="2" style="text-align:center"><button type="submit">Inicio</button></td></tr>
            </table>
        </form>
    </body>
</html>
