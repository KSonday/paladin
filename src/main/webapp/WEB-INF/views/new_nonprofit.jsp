<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<html>
<body>
<div align="center">
    <h2>Create New Profile: </h2>
<form:form method="POST" commandName="nonProfitForm">
    <table>
        <tr>
            <td>Name:</td>
            <td><form:input path="name" type="text" /> </td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Register"></td>
        </tr>
    </table>
</form:form>
    </div>
</body>
</html>
