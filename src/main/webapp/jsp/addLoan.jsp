<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>ADCWA Final Project</title>
</head>
<body>
	<h1>New Loan</h1>
	<form:form modelAttribute="Loan">
		<table>
			<tr>
				<!-- Bind title input to Loan model object -->
				<td><label>Customer ID: </label> <form:input path="cust"></form:input></td>
				<!-- Error form element for bad POST Loan input (title cannot be blank) -->
				<td><form:errors path="cust"></form:errors></td>
			</tr>
			<tr>
				<!-- Bind author input to Loan model object -->
				<td><label>Loan ID: </label> <form:input path="lid"></form:input></td>
				<!-- Error form element for bad POST Loan input (author cannot be blank) -->
				<td><form:errors path="lid"></form:errors></td>
			</tr>
			<tr>
				<!-- Submit a POST request to this page. Handled by LoanController. -->
				<td><input type="submit" value="Loan Book!" /></td>
			</tr>
		</table>
	</form:form>

	<!-- Bottom navigation -->
	<a href="../index.html">Home</a>
	<a href="/showLoans">List Loans</a>
	<a href="/showCustomers">List Customers</a>
	<a href="/showLoans">List Loans</a>

</body>
</html>

