<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Order item list</title>
</head>
<body>
<h2>Items:</h2>
<div>
    <table>
        <tr>
            <th>Item id</th>
            <th>Item Name</th>
            <th>Price</th>
            <th>Contains Alcohol</th>
        </tr>
        <c:forEach var="item" items="${items}" >
            <tr>
                <c:url var="update" value="/orderItem/itemUpdate">
                    <c:param name="itemId" value="${item.id}"/>
                </c:url>

                <c:url var="delete" value="/orderItem/itemDelete">
                    <c:param name="itemId" value="${item.id}"/>
                </c:url>


                <td>${item.id}</td>
                <td>${item.itemName}</td>
                <td>${item.price}</td>
                <td>
                    <c:choose>
                        <c:when test="${item.containsAlcohol == true }">
                            YES
                        </c:when>
                        <c:otherwise>
                            NO
                        </c:otherwise>
                    </c:choose>
                </td>
                <td><a href="${update}" >update</a> </td>
                <td><a href="${delete}" >delete</a> </td>

            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <input type="button" value="Add order item"
           onclick="window.location.href='create';return false;" />
</div>
<div>

    <form action = "tryShowMenu" method = "GET">
        <input type = "submit" value = "menu" />
    </form>
</div>

</body>

</html>