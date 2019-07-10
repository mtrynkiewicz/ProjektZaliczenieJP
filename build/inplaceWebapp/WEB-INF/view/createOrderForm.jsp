<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Orders</title>
</head>
<body>
ADD Order
<form:form action="saveOrder" modelAttribute="order" method="POST">
    <table>
        <tbody>
        <tr>
            <td><label>Name:</label></td>
            <td><form:input path="totalValue" /></td>
            <td><form:hidden path="id"/></td>
        </tr>
        <tr>
            <td><label>Surname:</label></td>
            <td><form:input path="discountPercent" /></td>
        </tr>
        <tr>
            <td><label>Proffession:</label></td>
            <td>
                <form:select path="employee">
                    <c:forEach var="emp" items="${employeeList}" >
                        <option value="${emp}">
                                ${emp}
                                <%--${emp.name} ${emp.surname} ${emp.proffession.name}--%>
                        </option>
                    </c:forEach>
                </form:select>
            </td>
        </tr>
        <tr>
        </tr>
        <tr>
            <td><input type="submit" value="Save" class="save" /></td>
        </tr>
        <tr>
        </tr>
        </tbody>
    </table>
</form:form>
<p>
    <a href="${pageContext.request.contextPath}/orders/showOrders"> return </a>
</p>
</body>
</html>
