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
        <c:forEach var="employee" items="${hasSetKeyOfEmpValuesOfOrder.keySet()}" >
           <tr>
               <td>${employee.name} ${employee.surname}
                    <tr>
                        <c:forEach var="order" items="${hasSetKeyOfEmpValuesOfOrder.get(employee)}" >
                            <td>${order.id}</td>
                            <td>${order.discountPercent}</td>
                            <td>${order.totalValue}</td>
                        </c:forEach>
                    </tr>
               </td>
           </tr>
        </c:forEach>
    </table>
</div>
<div>
    <input type="button" value="Back to menu"
           onclick="window.location.href='backToMenu';return false;" />
</div>

</body>

</html>