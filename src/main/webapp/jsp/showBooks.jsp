<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>ADCWA Final Project</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<h1>List of Books</h1>
	<table>
		<tr>
			<th>Book ID</th>
			<th>Title</th>
			<th>Author</th>
		</tr>

		<!-- c tag unable to be used, see FinalProjV1Application.java -->
		<!-- AllBooks model provided by BookController. Iterated over for individual books. -->
		<c:forEach var="book" items="${AllBooks}">
			<tr>
				<td><c:out value="${book.bid}" /></td>
				<td><c:out value="${book.title}" /></td>
				<td><c:out value="${book.author}" /></td>
			</tr>
		</c:forEach>
	</table>

	<a href="../index.html">Home</a>
	<a href="/addBook">Add Books</a>
	<a href="/showCustomers">List Customers</a>
	<a href="/showLoans">List Loans</a>
	<a href="/logout">Logout</a>

</body>
</html>