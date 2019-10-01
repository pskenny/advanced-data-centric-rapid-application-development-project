<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>ADCWA Final Project</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<h1>List of Customers</h1>

	<c:forEach var="customer" items="${AllCustomers}">

		<h2><c:out value="${customer.cid}"/> <c:out value="${customer.cname}"/></h2>
		Loan period = <c:out value="${customer.loanPeriod}"/> days
		
		<h3><c:out value="${customer.cname}"/>'s Loans</h3>
		<!-- Loans table -->
		<table>
			<tr>
				<th>Loan ID</th>
				<th>Book ID</th>
				<th>Title</th>
				<th>Author</th>
			</tr>

			<!-- iterate over loans in customer object -->
			<c:forEach var="loan" items="${customer.loans}">
				<tr>
					<td><c:out value="${loan.lid}"/></td>
					<td><c:out value="${loan.book.bid}"/></td>
					<td><c:out value="${loan.book.title}"/></td>
					<td><c:out value="${loan.book.author}"/></td>
				</tr>
			</c:forEach>
		</table>
	</c:forEach>

	<a href="../index.html">Home</a>
	<a href="/showBooks">List Books</a>
	<a href="/showCustomers">List Customers</a>
	<a href="/showLoans">List Loans</a>
	<a href="/logout">Logout</a>

</body>
</html>