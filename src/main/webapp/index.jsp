<%-- 
    Document   : index
    Created on : 23/03/2017, 11:00:12 AM
    Author     : flopez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estudiantes Info</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="./EstudianteServlet" method="POST">
            <table>
                <tr>
                    <td>id</td>
                    <td><input type="text" name="idEstudiante" value="${estudiante.idEstudiante}"/></td>
                </tr>
                <tr>
                    <td>nombre</td>
                    <td><input type="text" name="nombre" value="${estudiante.nombre}"/></td>
                </tr>
                <tr>
                    <td>apellido</td>
                    <td><input type="text" name="apellido" value="${estudiante.apellido}"/></td>
                </tr>
                <tr>
                    <td>edad</td>
                    <td><input type="text" name="edad" value="${estudiante.edad}"/></td>
                </tr> 
                <tr>
                    <td colspan="2">
                        <input type="submit" name="evento" value="add" />
                        <input type="submit" name="evento" value="edit" />
                        <input type="submit" name="evento" value="delete" />
                        <input type="submit" name="evento" value="search" />
                    </td> 
                </tr>
            </table>       
        </form>          
        <br/>
        <table border="1">
            <th>ID</th>
            <th>NOMBRE</th>
            <th>APELLIDO</th>
            <th>EDAD</th>
                <c:forEach items="${allestudiantes}" var="stud">
                <tr>
                    <td>${stud.idEstudiante}</td>
                    <td>${stud.nombre}</td>
                    <td>${stud.apellido}</td>
                    <td>${stud.edad}</td>
                </tr>
            </c:forEach>
        </table>      
    </body>
</html>
