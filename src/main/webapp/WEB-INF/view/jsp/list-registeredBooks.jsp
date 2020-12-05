<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
	<head>
		<title>List Book</title>

		<!-- reference our style sheet -->

	</head>

	<body>
		<div >
		<div >
			<h2>Registered Books List</h2>
		</div>
	</div>

	<div>

		<div >

			<!-- put new button: Add Book Registration -->

			<input type="button" value="Add Book Registration"
            				   onclick="window.location.href='registerBookForm'; return false;"
            				   class="add-button"
            			/>

			<!--  add our html table here -->

			<table border="1">
				<tr>
					<th>Student Name</th>
					<th>Book Name</th>
					<th>Due Date</th>
					<th>Action</th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="registeredBook" items="${registeredBooks}">

					<!--  construct an "update" link with customer id -->

                    <c:url var="updateLink" value="/showBookRegistrationUpdate">
                        <c:param name="registrationId" value="${registeredBook.id}"></c:param>
                    </c:url>

                    <c:url var="deleteLink" value="/deleteBookRegistration">
                        <c:param name="registrationId" value="${registeredBook.id}"></c:param>
                    </c:url>

					<tr>
						<td> ${registeredBook.userId} </td>
						<td> ${registeredBook.bookId} </td>
                        <td> ${registeredBook.date} </td>
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