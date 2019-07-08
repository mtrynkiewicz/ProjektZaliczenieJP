<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>admin page</title>
</head>
<body>
<table>
    <tr>Strona Admina</tr>
    <tr>
        <form action = "tryShowMenu" method = "GET">
            <input type = "submit" value = "menu" />
        </form>
    </tr>
    <tr></tr>
    <tr>
        <form id="logout" action="<%=request.getContextPath()%>/logout" method="post" >
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <input type="submit" value="logout" />
        </form>
    </tr>
</table>
</body>
</html>