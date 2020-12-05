<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

	<head>

		<title>Save Book</title>


	</head>

	<body>
		<div id="wrapper">
			<div id="header">
				<h2>Books List</h2>
			</div>
		</div>

		<div id="container">
			<h3>Save Book</h3>

			<form:form action="saveBook" modelAttribute="book" method="POST">

				<!-- need to assocaite this data with customer id -->
				<form:hidden path="id" />

				<table>
					<tbody>
						<tr>
							<td><label>Book Name:</label></td>
							<td><form:input path="bookName" /></td>
						</tr>

						<tr>
							<td><label>Author Name:</label></td>
							<td><form:input path="authorName" /></td>
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
				<a href="${pageContext.request.contextPath}/books">Back to List </a>
			</p>

		</div>
	</body>

</html>