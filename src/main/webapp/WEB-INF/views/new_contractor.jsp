<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<html>
<body>
<style type="text/css">
    .border {
        border: 1px solid black;
    }
    .button {
        font-weight: bold;
        font-size: 18px;
    }
</style>
<div align="center">
<h2>Create New Profile: </h2>
<form:form method="POST" action="contractor" commandName="contractorForm">
    <table class="border">
        <tr>
            <td>Name:</td>
            <td><form:input path="name" type="text" /> </td>
        </tr>
        <tr>
        <td>Profession:</td>
        <td><form:checkboxes items="${skills}" itemLabel="displayName" path="skills" /></td>
        </tr>
        <tr>
            <td>Industries:</td>
            <td><form:checkboxes items="${industries}" itemLabel="displayName" path="industries" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Register" class="button"></td>
        </tr>
    </table>
</form:form>
    </div>

</body>
</html>