<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Employees</title>
</head>
<body>
ADD Employe
<form:form action="saveEmployee" modelAttribute="employee" method="POST">
    <table>
        <tbody>
        <tr>
            <td><label>Name:</label></td>
            <td><form:input path="name" /></td>
            <td><form:hidden path="id"/></td>
        </tr>
        <tr>
            <td><label>Surname:</label></td>
            <td><form:input path="surname" /></td>
        </tr>
        <tr>
            <td><label>Proffession:</label></td>
            <td>
                <form:select path="proffession">
                    <c:forEach var="prof" items="${proffessionsList}" >
                        <option value="${prof}">${prof.name}</option>
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
    <a href="${pageContext.request.contextPath}/employees/list "> return </a>
</p>
</body>
</html>
