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
            <th>Order id</th>
            <th>Order discount</th>
            <th>Order Total Value</th>
        </tr>
        <c:forEach var="employee" items="${hasSetKeyOfEmpValuesOfOrder.keySet()}" >
           <tr>
               <td>${employee.name} ${employee.surname}
                    <tr>
                        <c:forEach var="singleOrder" items="${hasSetKeyOfEmpValuesOfOrder.get(employee)}" >

                            <c:url var="showSingleOrder" value="/orders/show">
                                <c:param name="orderId" value="${singleOrder.id}"/>
                            </c:url>

                            <td>${singleOrder.id}</td>
                            <td>${singleOrder.discountPercent}</td>
                            <td>${singleOrder.totalValue}</td>
                            <td><a href="${showSingleOrder}" >show Order</a> </td>

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