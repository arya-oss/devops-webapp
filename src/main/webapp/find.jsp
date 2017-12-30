<%@page import="me.arya.webapp.domain.Book"%>
<%@page import="me.arya.webapp.service.BookService"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	Book book = null;
	if (request.getMethod().equalsIgnoreCase("post")) {
		int id = Integer.parseInt(request.getParameter("id"));
		BookService bookService = new BookService();
		book = bookService.findOne(id);
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=11">
<title>WebApp</title>
<link rel="shortcut icon" href='<c:url value="/images/favicon.ico" />' />
<link href="<c:url value='/css/bootstrap.min.css' />" rel="stylesheet" />
<link href="<c:url value='/css/style.css' />" rel="stylesheet" />
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">WebApp</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="<c:url value='/' />">Home</a></li>
				<li><a href="<c:url value='/find.jsp' />"> Find</a></li>
				<li><a href="<c:url value='/add.jsp' />"> Add</a></li>
				<li><a href="<c:url value='/update.jsp' />"> Update</a></li>
				<li><a href="<c:url value='/delete.jsp' />"> Delete</a></li>
				<li><a href="<c:url value='/upload.jsp' />"> Upload</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<h2>Find Books</h2>
			<form class="form-horizontal" id="findform">
				<div class="form-group">
					<label class="control-label" for="id">Book ID</label>
					<input type="number" name="id" id="id" class="form-control" placeholder="Book ID" />
				</div>
				<div class="form-group">
					<button class="btn btn-danger">Find <i class="glyphicon glyphicom-search"></i></button>
				</div>
			</form>
			<div id="status">
				<table class="table table-striped table-condensed">
					<tr>
						<th>Book ID</th>
						<th>Title</th>
						<th>Author</th>
						<th>Published</th>
					</tr>
					<c:if test="book ne null">
						<tr>
							<td>${book.id}</td>
							<td>${book.title}</td>
							<td>${book.author}</td>
							<td>${book.published}</td>
						</tr>
					</c:if>
				</table>
			</div>
		</div>
	</div>
	</div>

	<!-- Load scripts at end of page -->
	<script src="<c:url value='/js/jquery.min.js' />"></script>
	<script src="<c:url value='/js/bootstrap.min.js' />"></script>
</body>
</html>