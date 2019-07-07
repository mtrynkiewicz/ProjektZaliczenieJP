<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        </tr>
        <tr>
            <td><label>Surname:</label></td>
            <td><form:input path="surname" /></td>
        </tr>
        <tr>
            <td><label>Proffession:</label></td>
            <td><form:input path="proffession" /></td>
        </tr>
        <tr>
            <td><label></label></td>
            <td><input type="submit" value="Save" class="save" /></td>
        </tr>
        </tbody>
    </table>
</form:form>
<p>
    <a href="${pageContext.request.contextPath}/employees/list "> return </a>
</p>
</body>
</html>
