<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>
<title>Customer Application</title>
</head>
<body>

	<div class="row">
		<div class="col-md-4">
			<div class="panel panel-default">
				<div class="panel-heading">Customer Registration Form</div>
				<div class="panel-body">
					<c:url var="addAction" value="/customer/add.html" />
					<form:form action="${addAction}" commandName="customer"
						method="post">
					<form:errors path="*" cssClass="alert alert-danger" element="div"></form:errors>
						<div class="form-group">
							<label for="id">Id</label>
							<form:input path="Id" class="form-control" readonly="true"
								size="8" disabled="true" />
							<form:hidden path="Id" />
						</div>
						<div class="form-group">
							<label for="fullname">Full Name</label>
							<form:input path="Name" class="form-control" />
						</div>
						<div class="form-group">
							<label for="email">Email Address</label>
							<form:input path="Email" class="form-control" />
						</div>
						<div class="form-group">
							<label for="department">Department</label>
							<form:select path="department" class="form-control">
								<c:if test="${!empty customer.name}">
									<c:forEach var="department" items="${enumDepartment}">
										<c:if test="${department == customer.department}">
											<option value="${department}" selected="selected">${department}</option>
										</c:if>
										<c:if test="${department != customer.department}">
											<option value="${department}">${department}</option>
										</c:if>
									</c:forEach>
								</c:if>
								<c:if test="${empty customer.name}">
									<c:forEach var="department" items="${enumDepartment}">
										<option value="${department}">${department}</option>
									</c:forEach>
								</c:if>
							</form:select>
						</div>
						<c:if test="${empty customer.name}">
							<input type="submit" class="btn btn-primary btn-sm"
								value="Add Customer">
						</c:if>
						<c:if test="${!empty customer.name}">
							<input type="submit" class="btn btn-warning btn-sm"
								value="Edit Customer">
						</c:if>
					</form:form>
				</div>
			</div>
		</div>
		<div class="col-md-8">
			<h3>Customer List</h3>
			<br>
			<table class="table table-hover">
				<tr>
					<th>Customer Id</th>
					<th>Full Name</th>
					<th>Email</th>
					<th>Department</th>
					<th>Action</th>
				</tr>
				<c:if test="${!empty listCustomer}">
					<c:forEach items="${listCustomer}" var="customer">
						<tr>
							<td>${customer.id}</td>
							<td>${customer.name}</td>
							<td>${customer.email}</td>
							<td>${customer.department}</td>
							<td><a href="<c:url value = '/edit/${customer.id}.html'/>"><button
										type="button" class="btn btn-warning btn-sm">Update</button></a> <a
								href="<c:url value = '/remove/${customer.id}.html'/>"><button
										type="button" class="btn btn-danger btn-sm">Delete</button></a></td>
						</tr>
					</c:forEach>
				</c:if>

			</table>
		</div>
	</div>
</body>
</html>