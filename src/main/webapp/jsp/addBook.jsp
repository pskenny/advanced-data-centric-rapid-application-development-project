<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>ADCWA Final Project</title>
</head>
<body>
	<h1>Add New Book</h1>
	<form:form modelAttribute="Book">
		<table>
			<tr>
				<!-- Bind title input to Book model object -->
				<td><label>Title: </label> <form:input path="title"></form:input></td>
				<!-- Error form element for bad POST Book input (title cannot be blank) -->
				<td><form:errors path="title"></form:errors></td>
			</tr>
			<tr>
				<!-- Bind author input to Book model object -->
				<td><label>Author: </label> <form:input path="author"></form:input></td>
				<!-- Error form element for bad POST Book input (author cannot be blank) -->
				<td><form:errors path="author"></form:errors></td>
			</tr>
			<tr>
				<!-- Submit a POST request to this page. Handled by BookController. -->
				<td><input type="submit" value="Add" /></td>
				<td></td>
			</tr>
		</table>
	</form:form>

	<!-- Bottom navigation links-->
	<a href="../index.html">Home</a>
	<a href="/addBook">Add Book</a>
	<a href="/addCustomer">Add Customers</a>
	<a href="/addLoan">New Loan</a>

</body>
</html>

