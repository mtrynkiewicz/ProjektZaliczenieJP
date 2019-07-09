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
                <c:url var="update" value="/employees/employeeUpdate">
                    <c:param name="employeeId" value="${employee.id}"/>
                </c:url>

                <c:url var="delete" value="/employees/employeeDelete">
                    <c:param name="employeeId" value="${employee.id}"/>
                </c:url>


                <td>${employee.name}</td>
                <td>${employee.surname}</td>
                <td>${employee.rating}</td>
                <td>${employee.dailyIncome}</td>
                <td>${employee.proffession.name}</td>
                <td><a href="${update}" >update</a> </td>
                <td><a href="${delete}" >delete</a> </td>

            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <input type="button" value="Add Employee"
           onclick="window.location.href='addEmployee';return false;" />
</div>
<div>
    <input type="button" value="Back to menu"
           onclick="window.location.href='backToMenu';return false;" />
</div>

</body>

</html>