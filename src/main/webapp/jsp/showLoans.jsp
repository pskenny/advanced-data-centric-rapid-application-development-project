<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>ADCWA Final Project</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<h1>List of Loans</h1>
	<table>
		<tr>
			<th>Loan ID</th>
			<th>Customer ID</th>
			<th>Customer Name</th>
			<th>Book Title</th>
			<th>Author</th>
			<th>Date</th>
		</tr>

		<!-- AllLoans model provided by LoanController. Iterated over for individual loans. -->
		<c:forEach var="loan" items="${AllLoans}">
			<tr>
				<td><c:out value="${loan.lid}" /></td>
				<td><c:out value="${loan.cust.cid}" /></td>
				<td><c:out value="${loan.cust.cname}" /></td>
				<td><c:out value="${loan.book.title}" /></td>
				<td><c:out value="${book.book.author}" /></td>
				<td><c:out value="${book.duedate}" /></td>
			</tr>
		</c:forEach>
	</table>

	<a href="../index.html">Home</a>
	<a href="/showBooks">List Books</a>
	<a href="/showCustomers">List Customers</a>
	<a href="/showLoans">List Loans</a>
	<a href="/deleteLoan">Delete Loan</a>
	<a href="/logout">Logout</a>

</body>
</html>