<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Order</title>
</head>
<body>
Add item to Order
<form:form action="itemAddedToOrder" modelAttribute="currentOrder" method="POST">
    <table>
        <tbody>
        <tr>
            <td><label>Order items:</label></td>
            <td>
                <form:select path="items">
                    <c:forEach var="item" items="${allOrderItems}" >
                        <option value="${item}">${item.itemName}</option>
                    </c:forEach>
                </form:select>
            </td>
            <td><form:hidden path="id"/></td>
            <td><form:hidden path="employee"/></td>
            <td><form:hidden path="discountPercent"/></td>
            <td><form:hidden path="totalValue"/></td>
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
    <input type="button" value="Back to menu"
           onclick="window.location.href='backToMenu';return false;" /></p>
</body>
</html>