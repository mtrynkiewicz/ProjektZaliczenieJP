<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>orderItem</title>
</head>
<body>
Create item
<form:form action="confirmToDb" modelAttribute="item" method="POST">
    <table>
        <tbody>
        <tr>
            <td><label>itemName:</label></td>
            <td><form:input path="itemName" /></td>
            <td><form:hidden path="id"/></td>
        </tr>
        <tr>
            <td><label>Price:</label></td>
            <td><form:input path="price" /></td>
        </tr>
        <tr>
            <td><label>ContainsAlcohol:</label></td>
            <td>
                <form:select path="containsAlcohol">
                    <option value=true>YES</option>
                    <option value=false>NO</option>
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
<input type="button" value="Back to menu"
       onclick="window.location.href='/backToOrderItemList';return false;" />
</body>
</html>
