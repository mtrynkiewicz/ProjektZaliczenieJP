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
    <tr>Witaj</tr>
    <tr>
        <form action = "showEmployee" method = "GET">
            <input type = "submit" value = "Zarzadzaj Uzytkownikami" />
        </form>
    </tr>
    <tr>
        <form action = "showOrders" method = "GET">
            <input type = "submit" value = "Zarzadzaj Zamowieniami" />
        </form>
    </tr>
    <tr>
        <form action = "tryManageOrderItem" method = "GET">
            <input type = "submit" value = "Zarzadzaj Produkatami" />
        </form>
    </tr>

</table>
</body>
</html>