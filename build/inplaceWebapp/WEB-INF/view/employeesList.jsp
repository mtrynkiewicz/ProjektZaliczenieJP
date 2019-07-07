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
        </tr>
        <c:forEach var="employee" items="${employees}" >
            <tr>
                <td>${employee.name}</td>
                <td>${employee.surname}</td>
                <td>${employee.rating}</td>
                <td>${employee.dailyIncome}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <input type="button" value="Add Employee"
           onclick="window.location.href='addEmployee';return false;" />
</div>

</body>

</html>