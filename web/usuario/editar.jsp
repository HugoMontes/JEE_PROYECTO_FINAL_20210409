<%-- 
    Document   : nuevo
    Created on : 06-04-2021, 08:36:35 PM
    Author     : Hugo
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h1>EDITAR USUARIO</h1>
            <!-- FORMULARIO -->
            <form action="<%= request.getContextPath() %>/UsuarioEditarServlet" method="POST">
                <input type="hidden" name="id" value="${usuario.id}"/>
                <div class="form-group">
                    <label>Nombre:</label>
                    <input type="text" name="nombre" class="form-control" value="${usuario.nombre}" required="true"/>
                </div>    
                <div class="form-group">
                    <label>Apellido Paterno:</label>
                    <input type="text" name="paterno" class="form-control" value="${usuario.apellidoPaterno}" required="true"/>
                </div>
                <div class="form-group">
                    <label>Apellido Materno:</label>
                    <input type="text" name="materno" class="form-control" value="${usuario.apellidoMaterno}" required="true"/>
                </div>
                <div class="form-group">
                    <label>Email:</label>
                    <input type="text" name="email" class="form-control" value="${usuario.email}" required="true"/>
                </div> 
                <div class="form-group">
                    <label>Fecha Nacimiento (dd/mm/aaaa):</label>
                    <fmt:formatDate type="date" var="fechaNacFormat" value="${usuario.fechaNacimiento}" pattern="dd/MM/yyyy"/>
                    <input type="input" name="fechaNac" class="form-control" value="${fechaNacFormat}" required="true"/>
                </div>
                <div class="form-group">
                    <label>Nombre de usuario:</label>
                    <input type="text" name="usuario" class="form-control" value="${usuario.username}" required="true"/>
                </div>
                <div class="form-group">
                    <label>Estado:</label>
                    <c:if test="${usuario.status eq 1}">
                        <input type="radio" name="estado" value="1" checked/> Activo
                        <input type="radio" name="estado" value="2"/> Inactivo
                    </c:if>
                    <c:if test="${usuario.status eq 2}">
                        <input type="radio" name="estado" value="1"/> Activo
                        <input type="radio" name="estado" value="2" checked/> Inactivo
                    </c:if>
                </div>
                <div class="form-group">
                    <input type="submit" value="Guardar" class="btn btn-primary"/>
                    <a href="<%= request.getContextPath() %>/UsuarioListarServlet" class="btn btn-secondary">Cancelar</a>
                </div> 
            </form>
        </div>
        <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
    </body>
</html>
