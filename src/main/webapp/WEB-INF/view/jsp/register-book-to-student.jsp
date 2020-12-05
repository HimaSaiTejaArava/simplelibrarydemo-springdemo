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

			<c:set var="now" value="<%=new java.util.Date()%>" />

			<form:form action="saveRegisterBook" modelAttribute="registerBook" method="POST">

				<!-- need to assocaite this data with customer id -->
				<form:hidden path="id" />

				<table>
					<tbody>
						<tr>
							<td><label>Student Id:</label></td>
							<td><form:input path="userId" /></td>
						</tr>

						<tr>
							<td><label>Book Id:</label></td>
							<td><form:input path="bookId" /></td>
						</tr>

						<tr>
                            <td><label>Due Date:</label></td>
                            <td><form:input path="date" type="text" /></p></td>
                        </tr>

						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save" class="save" /></td>
						</tr>

					</tbody>
				</table>


			</form:form>

			<div style="clear; both;"></div>



		</div>
	</body>

</html>