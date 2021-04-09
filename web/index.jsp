<%-- 
    Document   : index
    Created on : 09-04-2021, 02:20:53 PM
    Author     : hmontes
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>LOGIN</h1>
        <c:if test="${!empty error}">
            <div style="color:red">
                <c:out value="${error}"/>
            </div>
        </c:if>
        <form action="<%= request.getContextPath() %>/LoginServlet" method="post">
            <label>Usuario</label>
            <input type="text" name="username" required><br>
            <label>Password</label>
            <input type="password" name="password" required><br>
            <input type="hidden" name="action" value="login"/>
            <input type="submit" value="Ingresar">            
        </form>
    </body>
</html>
