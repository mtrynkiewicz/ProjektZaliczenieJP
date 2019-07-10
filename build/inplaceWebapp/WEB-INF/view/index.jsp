<%--
  Created by IntelliJ IDEA.
  User: Mateu
  Date: 08.07.2019
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello Traveller</title>
</head>
<body>
<table>
    Wybierz uprawnienia użytkownika
    <tr>
        <form action = "showLoginUser" method = "GET">
            <input type = "submit" value = "user"/>
        </form>
        <form action = "showLoginAdmin" method = "GET">
            <input type = "submit" value = "admin"/>
        </form>
    </tr>
</table>
</body>
</html>
