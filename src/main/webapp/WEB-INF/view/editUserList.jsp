<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users HW Test</title>
</head>
<body>
    <h3>Users</h3>
    <form:form method="post" action="add" commandName="user">
        Name: <form:input path="name" />
        Role: <form:input path="role" />
        Team: <form:input path="team" />
        <input type="submit" value="Add" />
    </form:form>
    <c:if test="${!empty userList}">
        <table class="data">
            <tr>
                <th>id</th>
                <th>Name</th>
                <th>Role</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${userList}" var="usr">
                <tr>
                    <td>${usr.id}</td>
                    <td>${usr.name}</td>
                    <td>${usr.role}</td>
                    <td><a href="u_delete/${usr.id}">delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <h3>Teams</h3>
    <c:if test="${!empty teamList}">
        <table class="data">
            <tr>
                <th>id</th>
                <th>Name</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${teamList}" var="team">
                <tr>
                    <td>${team.id}</td>
                    <td>${team.name}</td>
                    <td><a href="t_delete/${team.id}">delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>
