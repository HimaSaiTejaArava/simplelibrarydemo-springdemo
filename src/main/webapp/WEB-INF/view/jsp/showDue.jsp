<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

    <head>
        <title> Simple Library </title>
    </head>

    <body>
        This is Simple Library

        <div> ${userName} </div>

        <div> ${date} </div>

        <form:form action="${pageContext.request.contextPath}/logout" method="POST">

            <input type="submit" value="Logout" />

        </form:form>
    </body>

</html>