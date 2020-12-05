<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
	<head>
		<title>List Customers</title>

		<!-- reference our style sheet -->

	</head>

	<body>
		<div id="wrapper">
		<div id="header">
			<h2> Students List</h2>
		</div>
	</div>

	<div >

		<div style="display: flex; flex-direction: column; align-items: center; justify-content: center;">

			<!-- put new button: Add Customer -->

			<input type="button" value="Add Student"
				   onclick="window.location.href='showFormForAddStudent'; return false;"
				   class="add-button"
			/>

			<!--  add our html table here -->

			<table border="1" style="margin: 2rem;">
				<tr>
				    <th>Student Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="tempStudent" items="${students}">

					<!--  construct an "update" link with customer id -->

					<c:url var="updateLink" value="/showFormForUpdateStudent">
						<c:param name="studentId" value="${tempStudent.id}"></c:param>
					</c:url>

					<c:url var="deleteLink" value="/deleteStudent">
						<c:param name="studentId" value="${tempStudent.id}"></c:param>
					</c:url>

					<tr>
					    <td> ${tempStudent.id} </td>
						<td> ${tempStudent.firstName} </td>
						<td> ${tempStudent.lastName} </td>
						<td> ${tempStudent.email} </td>
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a> | <a href="${deleteLink}" onclick="if (!confirm('Are you sure to delete ?')) return false;">Delete</a>
						</td>
					</tr>

				</c:forEach>

			</table>

		</div>

	</div>
	</body>
</html>