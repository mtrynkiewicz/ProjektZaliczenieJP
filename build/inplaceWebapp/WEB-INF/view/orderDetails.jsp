<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Order</title>
</head>
<body>
<div>
    <table>
        <tr>
            <td>Order value: </td>
            <td>${currentOrder.totalValue}</td>
        </tr>
        <tr>Ordered items </tr>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Contains Alcohol</th>
        </tr>

        <c:forEach var="singleItem" items="${orderItems}" >
            <tr>

                <td>${singleItem.id}</td>
                <td>${singleItem.itemName}</td>
                <td>${singleItem.price}</td>
                <td>
                    <c:choose>
                        <c:when test="${singleItem.containsAlcohol == true }">
                            YES
                        </c:when>
                        <c:otherwise>
                            NO
                        </c:otherwise>
                    </c:choose>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <input type="button" value="Add Item"
           onclick="window.location.href='addItem';return false;" />
</div>
<div>
    <input type="button" value="Back to menu"
           onclick="window.location.href='backToMenu';return false;" />
</div>

</body>

</html>