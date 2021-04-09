<%-- 
    Document   : listar
    Created on : 06-04-2021, 07:57:55 PM
    Author     : Hugo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
        <h1>LISTA DE USUARIOS</h1>
        <a href="<%= request.getContextPath() %>/UsuarioNuevoServlet" class="btn btn-success">Nuevo Usuario</a>
        <table class="table">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Ap. Paterno</th>
                <th>Ap. Materno</th>
                <th>Fecha Nac.</th>
                <th>Usuario</th>
                <th>Email</th>
                <th>Estado</th>
                <th>Creado</th>
                <th>Accion</th>
            </tr>
            <c:forEach var="usr" items="#{usuarios}">
            <tr>
                <td><c:out value="${usr.id}"/></td> 
                <td><c:out value="${usr.nombre}"/></td> 
                <td><c:out value="${usr.apellidoPaterno}"/></td> 
                <td><c:out value="${usr.apellidoMaterno}"/></td> 
                <td><c:out value="${usr.fechaNacimiento}"/></td> 
                <td><c:out value="${usr.username}"/></td> 
                <td><c:out value="${usr.email}"/></td> 
                <td><c:out value="${usr.status}"/></td> 
                <td><c:out value="${usr.createdAt}"/></td>
                <td>
                    <a href="<%= request.getContextPath() %>/UsuarioEliminarServlet?id=${usr.id}"
                       onclick="return confirm('Esta seguro de eliminar este item?');">Eliminar</a>
                    <a href="<%= request.getContextPath() %>/UsuarioEditarServlet?id=${usr.id}">Editar</a>
                </td>
            </tr>
            </c:forEach>
        </table>
        </div>
        <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
    </body>
</html>
