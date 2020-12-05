<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
	<head>
		<title>List Book</title>

		<!-- reference our style sheet -->

	</head>

	<body>
		<div id="wrapper">
		<div id="header">
			<h2>Books List</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<!-- put new button: Add Customer -->

			<input type="button" value="Add Book"
				   onclick="window.location.href='showFormForAddBook'; return false;"
				   class="add-button"
			/>

			<!--  add our html table here -->

			<table>
				<tr>
					<th>Book Name</th>
					<th>Author Name</th>


				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="tempBook" items="${books}">

					<!--  construct an "update" link with customer id -->

					<c:url var="updateLink" value="/showFormForUpdateBook">
						<c:param name="bookId" value="${tempBook.id}"></c:param>
					</c:url>

					<c:url var="deleteLink" value="/deleteBook">
						<c:param name="bookId" value="${tempBook.id}"></c:param>
					</c:url>

					<tr>
						<td> ${tempBook.bookName} </td>
						<td> ${tempBook.authorName} </td>
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