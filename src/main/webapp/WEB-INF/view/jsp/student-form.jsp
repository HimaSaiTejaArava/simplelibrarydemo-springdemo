<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

	<head>

		<title>Save Customer</title>


	</head>

	<body>
		<div id="wrapper">
			<div id="header">
				<h2>Student List</h2>
			</div>
		</div>

		<div id="container">
			<h3>Save Student</h3>

			<form:form action="saveStudent" modelAttribute="student" method="POST">

				<!-- need to assocaite this data with customer id -->
				<form:hidden path="id" />

				<table>
					<tbody>
						<tr>
							<td><label>First name:</label></td>
							<td><form:input path="firstName" /></td>
						</tr>

						<tr>
							<td><label>Last name:</label></td>
							<td><form:input path="lastName" /></td>
						</tr>

						<tr>
							<td><label>Email:</label></td>
							<td><form:input path="email" /></td>
						</tr>

						<tr>
                            <td><label>UserName:</label></td>
                            <td><form:input path="userName" /></td>
                        </tr>

                        <tr>
                            <td><label>Password:</label></td>
                            <td><form:input path="password" type="password"/></td>
                        </tr>

						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save" class="save" /></td>
						</tr>

					</tbody>
				</table>


			</form:form>

			<div style="clear; both;"></div>

			<p>
				<a href="${pageContext.request.contextPath}/students">Back to List</a>
			</p>

		</div>
	</body>

</html>