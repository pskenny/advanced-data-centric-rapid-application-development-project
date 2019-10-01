<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>ADCWA Final Project</title>
</head>
<body>
	<h1>Delete Loan</h1>
	<form:form modelAttribute="Loan">
		<table>
			<tr>
				<!-- Bind loan id input to Loan model object -->
				<td><label>Loan ID: </label> <form:input path="lid"></form:input></td>
				<!-- Error form element for bad POST Book input (title cannot be blank) -->
				<td><form:errors path="error"></form:errors></td>
			</tr>
			<tr>
				<!-- Submit a POST request to this page. Handled by LoanController. -->
				<td><input type="submit" value="Delete" /></td>
			</tr>
		</table>
	</form:form>

	<!-- Bottom navigation -->
	<a href="../index.html">Home</a>
	<a href="/showBooks">List Books</a>
	<a href="/showCustomers">List Customers</a>
	<a href="/showLoans">List Loans</a>
	<a href="/addLoan">New Loan</a>

</body>
</html>

