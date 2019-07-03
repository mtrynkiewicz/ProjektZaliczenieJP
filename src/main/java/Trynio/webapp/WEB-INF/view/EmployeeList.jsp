<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Employees</title>
</head>
<body>
<h2>Employees:</h2>
<div>
    <table>
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Rating</th>
            <th>TotalIncome</th>
            <th>Proffesion</th>
        </tr>
        <c:forEach var="employees" items="${employee}" >
            <tr>
                <td>${employee.Name}</td>
                <td>${employee.Surname}</td>
                <td>${employee.Rating}</td>
                <td>${employee.TotalIncome}</td>
                <td>${employee.ProffesionId.nazwa}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <input type="button" value="Add Book"
           onclick="window.location.href='formadd';return false;" />
</div>

</body>

</html>