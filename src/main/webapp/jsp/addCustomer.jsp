<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>ADCWA Final Project</title>
</head>
<body>
	<h1>Add New Customer</h1>
	<form:form modelAttribute="Customer">
		<table>
			<tr>
				<!-- Bind title input to Customer model object -->
				<td><label>Cust Name: </label> <form:input path="cname"></form:input></td>
				<!-- Error form element for bad POST Customer input (title cannot be blank) -->
				<td><form:errors path="cname"></form:errors></td>
			</tr>
			<tr>
				<!-- Bind author input to Customer model object -->
				<td><label>Loan period (days): </label> <form:input path="loanperiod"></form:input></td>
				<!-- Error form element for bad POST Customer input (author cannot be blank) -->
				<td><form:errors path="loanperiod"></form:errors></td>
			</tr>
			<tr>
				<!-- Submit a POST request to this page. Handled by CustomerController. -->
				<td><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form:form>

	<!-- Bottom navigation -->
	<a href="../index.html">Home</a>
	<a href="/addBook">Add Book</a>
	<a href="/addCustomer">Add Customers</a>
	<a href="/addLoan">New Loan</a>

</body>
</html>

