<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration Success</title>
</head>
<body>
<div align="center">
    <table border="0">
        <tr>
            <td colspan="2" align="center"><h2>Registration Succeeded!</h2></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <h3>Thank you for registering! Here's the review of your details:</h3>
            </td>
        </tr>
        <c:if test="${not empty contractor}">
            <tr>
                <td>Name:</td>
                <td><c:out value="${contractor.name}"/></td>
            </tr>
            <tr>
                <td valign="top">Skills:</td>
                <td>
                    <table>
                        <c:forEach var="skill" items="${contractor.skills}">
                            <tr>
                                <td><c:out value="${skill.displayName}"/></td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>
            <tr>
                <td valign="top">Industries:</td>
                <td>
                    <table>
                        <c:forEach var="industry" items="${contractor.industries}">
                            <tr>
                               <td> <c:out value="${industry.displayName}"/></td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>
        </c:if>
        <c:if test="${not empty nonprofit}">
            <tr>
                <td>Name:</td>
                <td>${nonprofit.name}</td>
            </tr>
        </c:if>
    </table>
</div>
</body>
</html>