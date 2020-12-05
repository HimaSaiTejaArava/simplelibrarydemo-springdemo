<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

    <head>
        <title> Simple Library </title>
    </head>

    <body>
        This is Simple Library

        <a href="${pageContext.request.contextPath}/showDue"> Show Due </a>

        <form:form action="${pageContext.request.contextPath}/logout" method="POST">

            <input type="submit" value="Logout" />

        </form:form>
    </body>

</html>